package com.didactapp.android.cloudlibrary.data.network;

import com.didactapp.android.cloudlibrary.models.Book;

import java.util.List;

/**
 * an interface that should be implemented by clients that ask for Data from {@code ApiManager}
 */
public interface ApiCallback {

    /**
     * Fetch request failed.
     *
     * @param error
     */
    void onFailure(Throwable error);

    /**
     * Fetch request succeeded.
     */
    void onBookFetchSuccess(List<Book> bookList);

}
