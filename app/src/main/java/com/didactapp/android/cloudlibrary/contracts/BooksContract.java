package com.didactapp.android.cloudlibrary.contracts;

import com.didactapp.android.cloudlibrary.presenters.BasePresenter;
import com.didactapp.android.cloudlibrary.views.BaseView;

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
