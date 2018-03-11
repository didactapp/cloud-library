package com.didactapp.android.cloudlibrary.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Component {

    @PrimaryKey
    private final int componentId;
    private final String type;
    private final int componentNum;

    public Component(int componentId, String type, int componentNum) {
        this.componentId = componentId;
        this.type = type;
        this.componentNum = componentNum;
    }

    public int getComponentId() {
        return componentId;
    }

    public String getType() {
        return type;
    }

    public int getComponentNum() {
        return componentNum;
    }
}
