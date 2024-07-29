package com.rockstargames.gtacr.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Stack;

public class UIContainer extends FrameLayout {
    private Stack<Integer> mBackstack;
    private ArrayList<UILayout> mLayouts;
    private int mShowingUI;

    public UIContainer(Context context) {
        super(context);
        this.mLayouts = null;
        this.mBackstack = null;
        this.mShowingUI = -1;
    }

    public UIContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mLayouts = null;
        this.mBackstack = null;
        this.mShowingUI = -1;
        this.mLayouts = new ArrayList<>();
        this.mBackstack = new Stack<>();
    }

    public UIContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mLayouts = null;
        this.mBackstack = null;
        this.mShowingUI = -1;
        this.mLayouts = new ArrayList<>();
        this.mBackstack = new Stack<>();
    }

    private void showLayout(int id) {
        int i = this.mShowingUI;
        if (i == id) {
            this.mLayouts.get(id).onLayoutShown();
            return;
        }
        if (i != -1) {
            this.mLayouts.get(i).onLayoutClose();
        }
        removeAllViews();
        if (id == -1) {
            return;
        }
        UILayout uILayout = this.mLayouts.get(id);
        if (uILayout.getView() == null) {
            uILayout.onCreateView((LayoutInflater) getContext().getSystemService("layout_inflater"), this);
        }
        if (uILayout.getView() != null) {
            if (uILayout.getView().getParent() != null) {
                ((ViewGroup) uILayout.getView().getParent()).removeView(uILayout.getView());
            }
            addView(uILayout.getView());
        }
        uILayout.onLayoutShown();
    }

    public UILayout getLayout(int id) {
        return this.mLayouts.get(id);
    }

    public void addLayout(int id, UILayout layout) {
        while (this.mLayouts.size() < id) {
            this.mLayouts.add(null);
        }
        this.mLayouts.add(id, layout);
        layout.setParent(this);
        layout.onCreateView((LayoutInflater) getContext().getSystemService("layout_inflater"), this);
    }

    public void addLazyLayout(int id, UILayout layout) {
        while (this.mLayouts.size() < id) {
            this.mLayouts.add(null);
        }
        this.mLayouts.add(id, layout);
        layout.setParent(this);
    }

    public void removeLayout(int id) {
        if (id == this.mShowingUI) {
            this.mShowingUI = -1;
            showLayout(-1);
        }
        this.mLayouts.remove(id);
        for (int i = 0; i < this.mBackstack.size(); i++) {
            if (this.mBackstack.get(i).intValue() == id) {
                this.mBackstack.remove(i);
            }
        }
    }

    public void setCurrentLayout(int id) {
        int i = this.mShowingUI;
        if (i != -1) {
            this.mBackstack.push(Integer.valueOf(i));
        }
        showLayout(id);
        this.mShowingUI = id;
    }

    public void closeCurrentLayout() throws Exception {
        if (this.mShowingUI == -1) {
            throw new Exception("Invalid operation");
        }
        int intValue = this.mBackstack.pop().intValue();
        this.mShowingUI = intValue;
        showLayout(intValue);
    }

    public void replaceCurrentLayout(int newid) {
        this.mShowingUI = newid;
        showLayout(newid);
    }

    public int getCurrentLayoutId() {
        return this.mShowingUI;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = this.mShowingUI;
        if (i != -1) {
            this.mLayouts.get(i).onLayoutClose();
        }
    }
}
