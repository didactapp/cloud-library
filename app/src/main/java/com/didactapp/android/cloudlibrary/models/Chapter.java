package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Book.class,
        parentColumns = "bookId",
        childColumns = "chapterId",
        onDelete = CASCADE))
public class Chapter {

    @PrimaryKey
    private final int chapterId;
    private final int bookId;
    private final int chapterNum;
    private final String description;
    private final String thumbnailUrl;


    public Chapter(int chapterId, int bookId, int chapterNum, String description, String imageUrl) {
        this.chapterId = chapterId;
        this.bookId = bookId;
        this.chapterNum = chapterNum;
        this.description = description;
        this.thumbnailUrl = imageUrl;
    }

    public int getChapterId() {
        return chapterId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
