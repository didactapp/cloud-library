package com.didactapp.android.cloudlibrary.ui;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didactapp.android.cloudlibrary.R;
import com.didactapp.android.coreapp.model.Book;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Book> bookList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Book> bookList) {
        this.bookList = bookList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, null);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(layoutView);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Book bookAtPosition = bookList.get(position);
        holder.bookTitle.setText(bookAtPosition.getTitle());
        holder.bookAuthor.setText(bookAtPosition.getAuthor());
        holder.bookDescription.setText(bookAtPosition.getDescription());
        holder.bookDate.setText(bookAtPosition.getPublishedDate());

//        TODO: find a way to move picasso out of here and remove global context variable
        Picasso.with(context)
                .load(R.mipmap.ic_launcher)
                .placeholder(R.drawable.ic_book) // show this image if not loaded yet
                .error(R.drawable.ic_book)      // show this if error or image not exist
                .into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }

}