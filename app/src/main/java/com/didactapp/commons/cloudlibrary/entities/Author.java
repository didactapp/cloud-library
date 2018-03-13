package com.didactapp.commons.cloudlibrary.entities;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"authorId"})
public final class Author extends com.didactapp.commons.cloudlibrary.models.Author {

    public Author(int authorId, String firstName, String lastName, String about) {
        super(authorId, firstName, lastName, about);
    }
}
