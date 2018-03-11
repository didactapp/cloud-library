package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by roman on 11/03/2018.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Book.class,
                parentColumns = "bookId",
                childColumns = "bookId"),
        @ForeignKey(entity = Author.class,
                parentColumns = "authorId",
                childColumns = "authorId")
})

public class BookAuthor {
    @NonNull
    @PrimaryKey
    private final String bookId;
    @PrimaryKey
    private final int authorId;

    public BookAuthor(@NonNull String bookId, int authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    @NonNull
    public String getBookId() {
        return bookId;
    }

    public int getAuthorId() {
        return authorId;
    }
}
