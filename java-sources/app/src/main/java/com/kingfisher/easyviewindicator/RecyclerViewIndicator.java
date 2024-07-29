package com.kingfisher.easyviewindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class RecyclerViewIndicator extends AnyViewIndicator {
    private final RecyclerView.OnScrollListener onScrollListener;
    RecyclerView recyclerView;

    public RecyclerViewIndicator(Context context) {
        super(context);
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.kingfisher.easyviewindicator.RecyclerViewIndicator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && RecyclerViewIndicator.this.getItemCount() > 0) {
                    RecyclerViewIndicator.this.onCurrentLocationChange();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        };
    }

    public RecyclerViewIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.kingfisher.easyviewindicator.RecyclerViewIndicator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && RecyclerViewIndicator.this.getItemCount() > 0) {
                    RecyclerViewIndicator.this.onCurrentLocationChange();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        };
    }

    public RecyclerViewIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.kingfisher.easyviewindicator.RecyclerViewIndicator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && RecyclerViewIndicator.this.getItemCount() > 0) {
                    RecyclerViewIndicator.this.onCurrentLocationChange();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
            }
        };
    }

    public RecyclerViewIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.kingfisher.easyviewindicator.RecyclerViewIndicator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i22) {
                super.onScrollStateChanged(recyclerView, i22);
                if (i22 == 0 && RecyclerViewIndicator.this.getItemCount() > 0) {
                    RecyclerViewIndicator.this.onCurrentLocationChange();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i222) {
                super.onScrolled(recyclerView, i22, i222);
            }
        };
    }

    @Override // com.kingfisher.easyviewindicator.AnyViewIndicator
    protected int getItemCount() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null || recyclerView.getAdapter() == null) {
            return 0;
        }
        return this.recyclerView.getAdapter().getItemCount();
    }

    @Override // com.kingfisher.easyviewindicator.AnyViewIndicator
    protected int getCurrentPosition() {
        return ((LinearLayoutManager) this.recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    }

    public void setRecyclerView(final RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.kingfisher.easyviewindicator.RecyclerViewIndicator.2
                @Override // java.lang.Runnable
                public void run() {
                    RecyclerViewIndicator recyclerViewIndicator = RecyclerViewIndicator.this;
                    recyclerViewIndicator.mLastPosition = recyclerViewIndicator.getItemCount() > 0 ? 0 : -1;
                    RecyclerViewIndicator.this.updateCircleIndicator();
                    recyclerView.removeOnScrollListener(RecyclerViewIndicator.this.onScrollListener);
                    recyclerView.addOnScrollListener(RecyclerViewIndicator.this.onScrollListener);
                    RecyclerViewIndicator.this.onScrollListener.onScrollStateChanged(recyclerView, 0);
                }
            });
        }
    }

    public void forceUpdateItemCount() {
        updateCircleIndicator();
    }
}
