package com.didactapp.commons.cloudlibrary.contracts;

import com.didactapp.commons.cloudlibrary.presenters.BasePresenter;
import com.didactapp.commons.cloudlibrary.views.BaseView;

import java.util.List;


public interface BooksContract {

    interface View extends BaseView<Presenter> {

        void showBooks(List<Book> bookList);

        void hideBooks();

        void showBookDetailsUi(String bookId);

        void showSpinner();

        void hideSpinner();

        void showLoadError();

        void hideLoadError();

        void showNoNetwork();

        void hideNoNetwork();

    }

    interface Presenter extends BasePresenter<View> {
        void openBookDetails(Book requestedBook);

    }

}
