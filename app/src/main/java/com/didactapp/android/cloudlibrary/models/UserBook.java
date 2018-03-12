package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by roman on 11/03/2018.
 */

@Entity
public class UserBook {
    @PrimaryKey
    @ForeignKey(entity = Book.class, parentColumns = "bookId", childColumns = "bookId")
    private final int bookId;

    @PrimaryKey
    @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "userId")
    private final int userId;

    private final int userProgress;

    public UserBook(int bookId, int userId, int userProgress) {
        this.bookId = bookId;
        this.userId = userId;
        this.userProgress = userProgress;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserProgress() {
        return userProgress;
    }
}
