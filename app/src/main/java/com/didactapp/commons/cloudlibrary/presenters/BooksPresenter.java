package com.didactapp.commons.cloudlibrary.presenters;

import com.didactapp.commons.cloudlibrary.contracts.BooksContract;

/**
 * class to handle books presentation logic
 */
public final class BooksPresenter implements BooksContract.Presenter{
//    TODO: null safety - view might no be bounded
    private BooksContract.View view;

    public void loadBooks() {
        view.showSpinner();
        view.hideSpinner();
    }

    @Override
    public void openBookDetails(Book requestedBook) {
//        TODO: impl detail feature
    }

    @Override
    public void takeView(BooksContract.View view) {
//        TODO: handle nullability
        this.view = view;
        loadBooks();
    }

    @Override
    public void dropView() {
        view = null;
    }
}
