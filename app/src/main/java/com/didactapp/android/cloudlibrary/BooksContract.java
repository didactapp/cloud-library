package com.didactapp.android.cloudlibrary;

import com.didactapp.android.coreapp.base.BasePresenter;
import com.didactapp.android.coreapp.base.BaseView;
import com.didactapp.android.coreapp.model.Book;

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
