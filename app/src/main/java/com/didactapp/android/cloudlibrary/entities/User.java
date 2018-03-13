package com.didactapp.android.cloudlibrary.entities;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"userId"})
public final class User extends com.didactapp.android.cloudlibrary.models.User {

    public User(int userId, int userPoints) {
        super(userId, userPoints);
    }
}
