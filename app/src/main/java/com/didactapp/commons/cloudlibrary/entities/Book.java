package com.didactapp.commons.cloudlibrary.entities;

import android.arch.persistence.room.Entity;


@Entity(primaryKeys = {"bookId"})
public final class Book extends com.didactapp.commons.cloudlibrary.models.Book {

    public Book(int bookId, String coverUrl, String thumbnailUrl, String title, String tagLine, String description, int publishedDate, int revisionDate, int version) {
        super(bookId, coverUrl, thumbnailUrl, title, tagLine, description, publishedDate, revisionDate, version);

    }
}