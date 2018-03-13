package com.didactapp.android.cloudlibrary.entities;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"authorId"})
public final class Author extends com.didactapp.android.cloudlibrary.models.Author {

    public Author(int authorId, String firstName, String lastName, String about) {
        super(authorId, firstName, lastName, about);
    }
}
