package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Author {

    @PrimaryKey
    private final int authorId;
    private final String firstName;
    private final String lastName;
    private final String about;

    public Author(int authorId, String firstName, String lastName, String about) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = about;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAbout() {
        return about;
    }
}
