package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Book {

    @PrimaryKey
    private final int bookId;
    private final String coverUrl;
    private final String thumbnailUrl;
    private final String title;
    private final String tagLine;
    private final String description;
    private final int publishedDate;
    private final int revisionDate;
    private final int version;

    public Book(int bookId, String coverUrl, String thumbnailUrl, String title, String tagLine, String description, int publishedDate, int revisionDate, int version) {
        this.bookId = bookId;
        this.coverUrl = coverUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.tagLine = tagLine;
        this.description = description;
        this.publishedDate = publishedDate;
        this.revisionDate = revisionDate;
        this.version = version;
    }

    @NonNull
    public int getBookId() {
        return bookId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getTagLine() {
        return tagLine;
    }

    public String getDescription() {
        return description;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public int getRevisionDate() {
        return revisionDate;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", revisionDate='" + revisionDate + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
