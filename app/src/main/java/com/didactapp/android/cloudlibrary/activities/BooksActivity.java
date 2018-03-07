package com.didactapp.android.cloudlibrary.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;
import com.didactapp.android.cloudlibrary.R;
import com.didactapp.android.cloudlibrary.models.Book;
import com.didactapp.android.cloudlibrary.network.ApiCallback;
import com.didactapp.android.cloudlibrary.network.ApiClient;
import com.didactapp.android.cloudlibrary.network.ApiInterface;
import com.didactapp.android.cloudlibrary.util.AppThreadPoolExecutor;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksActivity extends AppCompatActivity implements ApiCallback {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        AppThreadPoolExecutor executor = new AppThreadPoolExecutor();

        getBooks(new WeakReference<ApiCallback>(this));

//        executor.diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                //        TODO: make singleton
////        TODO: move database name to constants
//                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                        AppDatabase.class, "book_database").build();
//
//
//                List<Book> bookList = db.bookDao().getAll();
//
//                if (bookList.isEmpty()) {
//                    LogUtils.d(" the db is empty - save data to it");
//                    bookList = MockDataSource.getBookList();
//                    for (Book book : bookList) {
//                        db.bookDao().insert(book);
//                    }
//                } else {
//                    LogUtils.d(" the db is NOT empty - print the data");
//                    for (Book book : bookList) {
//                        LogUtils.d(book.getBookId());
//                    }
//                }
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void getBooks(final WeakReference<ApiCallback> wCallback) {
        final Callback<List<Book>> objectCallback = new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                ApiCallback request = null;
                if (wCallback != null) {
                    request = wCallback.get();
                }
                if (request != null) {
                    // response.isSuccessful() is true if the response code is 2xx
                    if (response != null && response.isSuccessful()) {
                        List<Book> bookList = response.body();
                        request.onBookFetchSuccess(bookList);
                    } else {
                        int statusCode = response.code();
                        // handle response errors yourself
                        ResponseBody errorBody = response.errorBody();
                        try {
                            LogUtils.d("onResponse status code : " + statusCode + " , error message : " + errorBody.string());
                        } catch (IOException e) {
                            LogUtils.d("onResponse exception message : " + e.getMessage());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                ApiCallback req = null;
                if (wCallback != null) {
                    req = wCallback.get();
                }
                if (req != null) {
                    req.onFailure(t);
                }
            }
        };

        Call<List<Book>> call;
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        call = apiInterface.getBookList();
        call.enqueue(objectCallback);
    }

    @Override
    public void onFailure(Throwable error) {
        LogUtils.d("FAILED");
    }

    @Override
    public void onBookFetchSuccess(List<Book> bookList) {
        for (Book book : bookList) {
            LogUtils.d(book);
        }

    }
}
