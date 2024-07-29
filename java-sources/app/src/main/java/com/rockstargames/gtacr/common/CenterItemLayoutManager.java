package com.rockstargames.gtacr.common;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CenterItemLayoutManager extends LinearLayoutManager {
    private final int itemWidth;
    private int numItems;
    private int parentWidth;

    public CenterItemLayoutManager(final Context context, final int orientation, final int itemWidth, final int parentWidth, final int numItems) {
        super(context, orientation, false);
        this.itemWidth = itemWidth;
        this.parentWidth = parentWidth;
        this.numItems = numItems;
    }

    @Override
    public void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        this.numItems = recyclerView.getAdapter().getItemCount();
        this.parentWidth = recyclerView.getWidth();
    }

    @Override
    public int getPaddingLeft() {
        int i = this.itemWidth * this.numItems;
        int i2 = this.parentWidth;
        if (i >= i2) {
            return super.getPaddingLeft();
        }
        return Math.round((i2 / 2.0f) - (i / 2.0f));
    }

    @Override
    public int getPaddingRight() {
        return getPaddingLeft();
    }
}
