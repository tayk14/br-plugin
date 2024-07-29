package com.rockstargames.gtacr.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class UILayout {
    private UIContainer mParent = null;

    public abstract View getView();

    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container);

    public abstract void onLayoutClose();

    public abstract void onLayoutShown();

    public void setParent(UIContainer parent) {
        this.mParent = parent;
    }

    public Context getContext() {
        return this.mParent.getContext();
    }
}
