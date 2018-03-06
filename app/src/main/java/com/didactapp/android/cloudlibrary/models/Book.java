package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Book {

    @PrimaryKey
    @NonNull
    private String bookId;
    @ColumnInfo
    private String coveUrl;
    @ColumnInfo
    private String thumbnailUrl;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String tagLine;
    @ColumnInfo
    private String author;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String publishedDate;
    @ColumnInfo
    private String revisionDate;
    @ColumnInfo
    private String version;

    public Book(String bookId, String coveUrl, String thumbnailUrl, String title, String tagLine, String author, String description, String publishedDate, String revisionDate, String version) {
        this.bookId = bookId;
        this.coveUrl = coveUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.tagLine = tagLine;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
        this.revisionDate = revisionDate;
        this.version = version;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCoveUrl() {
        return coveUrl;
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

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getRevisionDate() {
        return revisionDate;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", coveUrl='" + coveUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", revisionDate='" + revisionDate + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
