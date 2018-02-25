package com.didactapp.android.cloudlibrary.ui;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.didactapp.android.cloudlibrary.BooksContract;
import com.didactapp.android.cloudlibrary.BooksPresenter;
import com.didactapp.android.cloudlibrary.R;
import com.didactapp.android.coreapp.model.Book;

import java.util.List;


public final class BooksView extends LinearLayoutCompat implements BooksContract.View {

    private static final int NUM_OF_COLUMNS = 2;
    private RecyclerView recycler;
    private ProgressBar spinner;
    private TextView noNetwork;
    private TextView loadError;
    private BooksContract.Presenter presenter;

    public BooksView(Context context) {
        this(context, null);
    }

    public BooksView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        /* inflate layout */
        inflate(getContext(), R.layout.books_view, this);

        /* get layout elements */
        recycler = findViewById(R.id.books_grid);
        spinner = findViewById(R.id.progress_spinner);
        noNetwork = findViewById(R.id.no_network);
        loadError = findViewById(R.id.loading_error);

        /* init recycler view */
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), NUM_OF_COLUMNS);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(gridLayoutManager);

        /* init presenter */
        presenter = new BooksPresenter();
        presenter.takeView(this);

    }

    @Override
    public void showBooks(List<Book> bookList) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), bookList);
        recycler.swapAdapter(recyclerViewAdapter, false);
        recycler.setVisibility(VISIBLE);
    }

    @Override
    public void hideBooks() {
        recycler.setVisibility(GONE);
    }

    @Override
    public void showBookDetailsUi(String bookId) {
//        TODO: impl this feature
    }

    @Override
    public void showSpinner() {
        spinner.setVisibility(VISIBLE);
    }

    @Override
    public void hideSpinner() {
        spinner.setVisibility(GONE);

    }

    @Override
    public void showLoadError() {
        loadError.setVisibility(VISIBLE);

    }

    @Override
    public void hideLoadError() {
        loadError.setVisibility(GONE);

    }

    @Override
    public void showNoNetwork() {
        noNetwork.setVisibility(VISIBLE);
    }

    @Override
    public void hideNoNetwork() {
        noNetwork.setVisibility(GONE);

    }
}
