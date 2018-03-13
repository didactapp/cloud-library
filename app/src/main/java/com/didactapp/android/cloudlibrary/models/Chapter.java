package com.didactapp.android.cloudlibrary.models;

public abstract class Chapter {

    protected final int bookId;
    protected final int chapterId;
    protected final int chapterNum;
    protected final String description;
    protected final String thumbnailUrl;


    protected Chapter(int chapterId, int bookId, int chapterNum, String description, String imageUrl) {
        this.chapterId = chapterId;
        this.bookId = bookId;
        this.chapterNum = chapterNum;
        this.description = description;
        this.thumbnailUrl = imageUrl;
    }

    public final int getChapterId() {
        return chapterId;
    }

    public final int getBookId() {
        return bookId;
    }

    public final int getChapterNum() {
        return chapterNum;
    }

    public final String getDescription() {
        return description;
    }

    public final String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "bookId=" + bookId +
                ", chapterId=" + chapterId +
                ", chapterNum=" + chapterNum +
                ", description='" + description + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
