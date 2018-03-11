package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Book.class,
        parentColumns = "bookId",
        childColumns = "chapterId",
        onDelete = CASCADE))
public class Chapter {

    @PrimaryKey
    private final int chapterId;
    @NonNull
    private final String bookId;
    private final String chapterNum;
    private final String description;
    private final String thumbnailUrl;


    public Chapter(int chapterId, String bookId, String chapterNum, String description, String imageUrl) {
        this.chapterId = chapterId;
        this.bookId = bookId;
        this.chapterNum = chapterNum;
        this.description = description;
        this.thumbnailUrl = imageUrl;
    }

    @NonNull
    public int getChapterId() {
        return chapterId;
    }

    @NonNull
    public String getBookId() {
        return bookId;
    }

    public String getChapterNum() {
        return chapterNum;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
