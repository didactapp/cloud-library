package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Chapter.class,
        parentColumns = "chapterId",
        childColumns = "sectionId",
        onDelete = CASCADE))
public class Section {

    @PrimaryKey
    private final int sectionId;
    private final int chapterId;
    private final int sectionNum;

    public Section(int sectionId, int chapterId, int sectionNum) {
        this.sectionId = sectionId;
        this.chapterId = chapterId;
        this.sectionNum = sectionNum;
    }

    public int getSectionId() {
        return sectionId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public int getSectionNum() {
        return sectionNum;
    }
}
