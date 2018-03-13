package com.didactapp.android.cloudlibrary.data.network;

import com.didactapp.android.cloudlibrary.entities.Book;

import java.util.List;

/**
 * an interface that should be implemented by clients that ask for Data from {@code ApiManager}
 */
public interface RemoteGatewayCallback {

    /**
     * Fetch request succeeded.
     */
    void onLoadSuccess(List<Book> bookList);


    /**
     * Fetch request succeeded - but no data to show
     */
    void onDataNotAvailable();

    /**
     * Fetch request failed.
     *
     * @param error
     */
    void onLoadFailed();

}
