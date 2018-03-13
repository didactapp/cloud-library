package com.didactapp.android.cloudlibrary.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"chapterId"}, foreignKeys = @ForeignKey(entity = com.didactapp.android.cloudlibrary.entities.Book.class,
        parentColumns = "bookId",
        childColumns = "chapterId",
        onDelete = CASCADE))
public final class Chapter extends com.didactapp.android.cloudlibrary.models.Chapter {

    public Chapter(int chapterId, int bookId, int chapterNum, String description, String imageUrl) {
        super(chapterId, bookId, chapterNum, description, imageUrl);
    }
}
