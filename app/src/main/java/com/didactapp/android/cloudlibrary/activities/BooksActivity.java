package com.didactapp.android.cloudlibrary.activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;
import com.didactapp.android.cloudlibrary.R;
import com.didactapp.android.cloudlibrary.dummy.MockDataSource;
import com.didactapp.android.cloudlibrary.models.Book;
import com.didactapp.android.cloudlibrary.persistence.AppDatabase;
import com.didactapp.android.cloudlibrary.util.AppThreadPoolExecutor;

import java.util.List;

public class BooksActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        AppThreadPoolExecutor executor = new AppThreadPoolExecutor();

        executor.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                //        TODO: make singleton
//        TODO: move database name to constants
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "book_database").build();


                List<Book> bookList = db.bookDao().getAll();

                if (bookList.isEmpty()) {
                    LogUtils.d(" the db is empty - save data to it");
                    bookList = MockDataSource.getBookList();
                    for (Book book : bookList) {
                        db.bookDao().insert(book);
                    }
                } else {
                    LogUtils.d(" the db is NOT empty - print the data");
                    for (Book book : bookList) {
                        LogUtils.d(book.getBookId());
                    }
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}
