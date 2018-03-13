package com.didactapp.commons.models;

public abstract class User {

    protected final int userId;
    protected final int userPoints;

    protected User(int userId, int userPoints) {
        this.userId = userId;
        this.userPoints = userPoints;
    }

    public final int getUserId() {
        return userId;
    }

    public final int getUserPoints() {
        return userPoints;
    }
}
