package com.didactapp.android.cloudlibrary.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.didactapp.android.cloudlibrary.R;


class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView bookImage;
    TextView bookTitle;
    TextView bookAuthor;
    TextView bookDescription;
    TextView bookDate;



    RecyclerViewHolder(View itemView) {
        super(itemView);
        bookImage = itemView.findViewById(R.id.book_image);
        bookTitle = itemView.findViewById(R.id.book_title);
        bookAuthor = itemView.findViewById(R.id.book_author);
        bookDescription = itemView.findViewById(R.id.book_description);
        bookDate = itemView.findViewById(R.id.book_date);

    }

}