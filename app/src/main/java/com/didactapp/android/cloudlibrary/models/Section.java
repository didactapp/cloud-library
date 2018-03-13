package com.didactapp.android.cloudlibrary.models;

public abstract class Section {

    protected final int sectionId;
    protected final int chapterId;
    protected final int sectionNum;

    protected Section(int sectionId, int chapterId, int sectionNum) {
        this.sectionId = sectionId;
        this.chapterId = chapterId;
        this.sectionNum = sectionNum;
    }

    public final int getSectionId() {
        return sectionId;
    }

    public final int getChapterId() {
        return chapterId;
    }

    public final int getSectionNum() {
        return sectionNum;
    }
}
