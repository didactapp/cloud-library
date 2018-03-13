package com.didactapp.commons.cloudlibrary.activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;
import com.didactapp.commons.cloudlibrary.R;
import com.didactapp.commons.cloudlibrary.data.network.RemoteGateway;
import com.didactapp.commons.cloudlibrary.data.network.RemoteGatewayCallback;
import com.didactapp.commons.cloudlibrary.data.persistence.AppDatabase;
import com.didactapp.commons.cloudlibrary.entities.Book;
import com.didactapp.commons.cloudlibrary.util.AppExecutor;

import java.util.List;

public class BooksActivity extends AppCompatActivity implements RemoteGatewayCallback {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        RemoteGateway remoteGateway = RemoteGateway.getInstance();
        remoteGateway.getBookList(this);


    }


    private void handleDatabase(final List<Book> bookList) {

        // create execution threads
        AppExecutor executor = new AppExecutor();

        // get data from the database
        executor.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                // TODO: make singleton
                // TODO: move database name to constants
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "book_database").build();
                List<Book> localBookList = db.bookDao().getAll();

                if (localBookList.isEmpty()) {
                    LogUtils.d(" the db is empty - save data to it");
                    for (Book book : bookList) {
                        db.bookDao().insert(book);
                    }
                } else {
                    LogUtils.d(" the db is NOT empty - print the data");
                    for (Book book : localBookList) {
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

    @Override
    public void onLoadSuccess(List<Book> bookList) {
        if (bookList != null) {
            handleDatabase(bookList);
        } else {
            LogUtils.d("booklist is null!!!");
        }
    }

    @Override
    public void onDataNotAvailable() {
        LogUtils.d("data not available");
    }

    @Override
    public void onLoadFailed() {
        LogUtils.d("load failed");
    }
}
