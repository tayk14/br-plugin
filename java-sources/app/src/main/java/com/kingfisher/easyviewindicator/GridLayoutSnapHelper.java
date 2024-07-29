package com.kingfisher.easyviewindicator;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: classes2.dex */
public class GridLayoutSnapHelper extends SnapHelper {
    private static final float MILLISECONDS_PER_INCH = 100.0f;
    private static final String TAG = "SnapToBlock";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.kingfisher.easyviewindicator.-$$Lambda$GridLayoutSnapHelper$V1pjsdbgfydLNn7cUbEpL015MzE
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return GridLayoutSnapHelper.lambda$static$0(f);
        }
    };
    private int mBlocksize;
    private int mItemDimension;
    private LayoutDirectionHelper mLayoutDirectionHelper;
    private final int mMaxFlingBlocks;
    private int mMaxPositionsToMove;
    private OrientationHelper mOrientationHelper;
    private int mPriorFirstPosition = -1;
    private RecyclerView mRecyclerView;
    private Scroller mScroller;
    private SnapBlockCallback mSnapBlockCallback;

    /* loaded from: classes2.dex */
    public interface SnapBlockCallback {
        void onBlockSnap(int i);

        void onBlockSnapped(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2) + 1.0f;
    }

    public GridLayoutSnapHelper(int i) {
        this.mMaxFlingBlocks = i;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        if (recyclerView != null) {
            this.mRecyclerView = recyclerView;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.canScrollHorizontally()) {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(linearLayoutManager);
                this.mLayoutDirectionHelper = new LayoutDirectionHelper(ViewCompat.getLayoutDirection(this.mRecyclerView));
            } else if (linearLayoutManager.canScrollVertically()) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(linearLayoutManager);
                this.mLayoutDirectionHelper = new LayoutDirectionHelper(0);
            } else {
                throw new IllegalStateException("RecyclerView must be scrollable");
            }
            this.mScroller = new Scroller(this.mRecyclerView.getContext(), sInterpolator);
            initItemDimensionIfNeeded(linearLayoutManager);
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = this.mLayoutDirectionHelper.getScrollToAlignView(view);
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = this.mLayoutDirectionHelper.getScrollToAlignView(view);
        }
        SnapBlockCallback snapBlockCallback = this.mSnapBlockCallback;
        if (snapBlockCallback != null) {
            if (iArr[0] == 0 && iArr[1] == 0) {
                snapBlockCallback.onBlockSnapped(layoutManager.getPosition(view));
            } else {
                snapBlockCallback.onBlockSnap(layoutManager.getPosition(view));
            }
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        initItemDimensionIfNeeded(layoutManager);
        this.mScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (i != 0) {
            return this.mLayoutDirectionHelper.getPositionsToMove(linearLayoutManager, this.mScroller.getFinalX(), this.mItemDimension);
        }
        if (i2 != 0) {
            return this.mLayoutDirectionHelper.getPositionsToMove(linearLayoutManager, this.mScroller.getFinalY(), this.mItemDimension);
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        int calcTargetPosition = calcTargetPosition((LinearLayoutManager) layoutManager);
        View findViewByPosition = calcTargetPosition == -1 ? null : layoutManager.findViewByPosition(calcTargetPosition);
        if (findViewByPosition == null) {
            Log.d(TAG, "<<<<findSnapView is returning null!");
        }
        Log.d(TAG, "<<<<findSnapView snapos=" + calcTargetPosition);
        return findViewByPosition;
    }

    private int calcTargetPosition(LinearLayoutManager linearLayoutManager) {
        int i;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1) {
            return -1;
        }
        initItemDimensionIfNeeded(linearLayoutManager);
        if (findFirstVisibleItemPosition >= this.mPriorFirstPosition) {
            i = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (i == -1 || i % this.mBlocksize != 0) {
                i = roundDownToBlockSize(this.mBlocksize + findFirstVisibleItemPosition);
            }
        } else {
            int roundDownToBlockSize = roundDownToBlockSize(findFirstVisibleItemPosition);
            if (linearLayoutManager.findViewByPosition(roundDownToBlockSize) == null) {
                int[] calculateDistanceToScroll = this.mLayoutDirectionHelper.calculateDistanceToScroll(linearLayoutManager, roundDownToBlockSize);
                this.mRecyclerView.smoothScrollBy(calculateDistanceToScroll[0], calculateDistanceToScroll[1], sInterpolator);
            }
            i = roundDownToBlockSize;
        }
        this.mPriorFirstPosition = findFirstVisibleItemPosition;
        return i;
    }

    private void initItemDimensionIfNeeded(RecyclerView.LayoutManager layoutManager) {
        View childAt;
        if (this.mItemDimension == 0 && (childAt = layoutManager.getChildAt(0)) != null) {
            if (layoutManager.canScrollHorizontally()) {
                this.mItemDimension = childAt.getWidth();
                this.mBlocksize = getSpanCount(layoutManager) * (this.mRecyclerView.getWidth() / this.mItemDimension);
            } else if (layoutManager.canScrollVertically()) {
                this.mItemDimension = childAt.getHeight();
                this.mBlocksize = getSpanCount(layoutManager) * (this.mRecyclerView.getHeight() / this.mItemDimension);
            }
            this.mMaxPositionsToMove = this.mBlocksize * this.mMaxFlingBlocks;
        }
    }

    private int getSpanCount(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int roundDownToBlockSize(int i) {
        return i - (i % this.mBlocksize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int roundUpToBlockSize(int i) {
        return roundDownToBlockSize((i + this.mBlocksize) - 1);
    }

    /* JADX DEBUG: Method merged with bridge method: createScroller(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Landroidx/recyclerview/widget/RecyclerView$SmoothScroller; */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.mRecyclerView.getContext()) { // from class: com.kingfisher.easyviewindicator.GridLayoutSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    GridLayoutSnapHelper gridLayoutSnapHelper = GridLayoutSnapHelper.this;
                    int[] calculateDistanceToFinalSnap = gridLayoutSnapHelper.calculateDistanceToFinalSnap(gridLayoutSnapHelper.mRecyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, GridLayoutSnapHelper.sInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return GridLayoutSnapHelper.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    public void setSnapBlockCallback(SnapBlockCallback snapBlockCallback) {
        this.mSnapBlockCallback = snapBlockCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class LayoutDirectionHelper {
        private final boolean mIsRTL;

        LayoutDirectionHelper(int i) {
            this.mIsRTL = i == 1;
        }

        int getScrollToAlignView(View view) {
            return this.mIsRTL ? GridLayoutSnapHelper.this.mOrientationHelper.getDecoratedEnd(view) - GridLayoutSnapHelper.this.mRecyclerView.getWidth() : GridLayoutSnapHelper.this.mOrientationHelper.getDecoratedStart(view);
        }

        int[] calculateDistanceToScroll(LinearLayoutManager linearLayoutManager, int i) {
            int[] iArr = new int[2];
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (linearLayoutManager.canScrollHorizontally() && i <= findFirstVisibleItemPosition) {
                if (this.mIsRTL) {
                    iArr[0] = GridLayoutSnapHelper.this.mOrientationHelper.getDecoratedEnd(linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition())) + ((findFirstVisibleItemPosition - i) * GridLayoutSnapHelper.this.mItemDimension);
                } else {
                    iArr[0] = GridLayoutSnapHelper.this.mOrientationHelper.getDecoratedStart(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition)) - ((findFirstVisibleItemPosition - i) * GridLayoutSnapHelper.this.mItemDimension);
                }
            }
            if (linearLayoutManager.canScrollVertically() && i <= findFirstVisibleItemPosition) {
                iArr[1] = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition).getTop() - ((findFirstVisibleItemPosition - i) * GridLayoutSnapHelper.this.mItemDimension);
            }
            return iArr;
        }

        int getPositionsToMove(LinearLayoutManager linearLayoutManager, int i, int i2) {
            int roundUpToBlockSize = GridLayoutSnapHelper.this.roundUpToBlockSize(Math.abs(i) / i2);
            if (roundUpToBlockSize < GridLayoutSnapHelper.this.mBlocksize) {
                roundUpToBlockSize = GridLayoutSnapHelper.this.mBlocksize;
            } else if (roundUpToBlockSize > GridLayoutSnapHelper.this.mMaxPositionsToMove) {
                roundUpToBlockSize = GridLayoutSnapHelper.this.mMaxPositionsToMove;
            }
            if (i < 0) {
                roundUpToBlockSize *= -1;
            }
            if (this.mIsRTL) {
                roundUpToBlockSize *= -1;
            }
            return (GridLayoutSnapHelper.this.mLayoutDirectionHelper.isDirectionToBottom(i < 0) ? GridLayoutSnapHelper.this.roundDownToBlockSize(linearLayoutManager.findFirstVisibleItemPosition()) : GridLayoutSnapHelper.this.roundDownToBlockSize(linearLayoutManager.findLastVisibleItemPosition())) + roundUpToBlockSize;
        }

        boolean isDirectionToBottom(boolean z) {
            return this.mIsRTL ? z : !z;
        }
    }
}
