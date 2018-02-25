package com.didactapp.android.cloudlibrary;

import com.didactapp.android.coreapp.model.Book;

import java.util.List;

/**
 * class to handle books presentation logic
 */
public final class BooksPresenter implements BooksContract.Presenter{
//    TODO: null safety - view might no be bounded
    private BooksContract.View view;

    public void loadBooks() {
        view.showSpinner();
        List<Book> bookList = MockDataSource.getBookList();
        view.hideSpinner();
        view.showBooks(bookList);
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
