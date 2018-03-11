package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    private final int userId;
    private final int userPoints;

    public User(int userId, int userPoints) {
        this.userId = userId;
        this.userPoints = userPoints;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserPoints() {
        return userPoints;
    }
}
