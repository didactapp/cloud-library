package com.didactapp.android.cloudlibrary.models;

public abstract class Component {

    protected final int componentId;
    protected final int componentNum;

    protected Component(int componentId, int componentNum) {
        this.componentId = componentId;
        this.componentNum = componentNum;
    }

    public final int getComponentId() {
        return componentId;
    }

    public final int getComponentNum() {
        return componentNum;
    }
}
