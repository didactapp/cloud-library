package com.didactapp.commons.cloudlibrary.entities;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"userId"})
public final class User extends com.didactapp.commons.cloudlibrary.models.User {

    public User(int userId, int userPoints) {
        super(userId, userPoints);
    }
}
