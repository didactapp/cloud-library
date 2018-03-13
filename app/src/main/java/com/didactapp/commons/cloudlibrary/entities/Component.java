package com.didactapp.commons.cloudlibrary.entities;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"componentId"})
public final class Component extends com.didactapp.commons.cloudlibrary.models.Component {

    public Component(int componentId, int componentNum) {
        super(componentId, componentNum);
    }
}
