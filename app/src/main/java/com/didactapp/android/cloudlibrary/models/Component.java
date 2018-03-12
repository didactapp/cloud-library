package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Component {

    @PrimaryKey
    private final int componentId;
    private final int componentNum;

    public Component(int componentId, int componentNum) {
        this.componentId = componentId;
        this.componentNum = componentNum;
    }

    public int getComponentId() {
        return componentId;
    }

    public int getComponentNum() {
        return componentNum;
    }
}
