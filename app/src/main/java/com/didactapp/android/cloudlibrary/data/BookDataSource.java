package com.didactapp.android.cloudlibrary.data;

import android.support.annotation.NonNull;

import com.didactapp.android.cloudlibrary.models.Book;

import java.util.List;

/**
 * Created by roman on 11/03/2018.
 */

public interface BookDataSource {

    void getBookList(@NonNull GetBookListCallback callback);

    interface GetBookListCallback {

        void onBooksLoaded(List<Book> bookList);

        void onDataNotAvailable();

        void onLoadFailed();
    }


}