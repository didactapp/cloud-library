package com.didactapp.android.cloudlibrary.entities;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"componentId"})
public final class Component extends com.didactapp.android.cloudlibrary.models.Component {

    public Component(int componentId, int componentNum) {
        super(componentId, componentNum);
    }
}
