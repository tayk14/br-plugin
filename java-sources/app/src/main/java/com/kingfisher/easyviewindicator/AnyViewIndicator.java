package com.kingfisher.easyviewindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class AnyViewIndicator extends LinearLayout {
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    private int currentPosition;
    private boolean isAnimationEnable;
    private int itemCount;
    private Animator mAnimatorIn;
    private Animator mAnimatorOut;
    private int mAnimatorResId;
    private int mAnimatorReverseResId;
    private Animator mImmediateAnimatorIn;
    private Animator mImmediateAnimatorOut;
    private int mIndicatorBackgroundResId;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorUnselectedBackgroundResId;
    private int mIndicatorWidth;
    protected int mLastPosition;

    public AnyViewIndicator(Context context) {
        super(context);
        this.mLastPosition = -1;
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.isAnimationEnable = true;
        init(context, null);
    }

    public AnyViewIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastPosition = -1;
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.isAnimationEnable = true;
        init(context, attributeSet);
    }

    public AnyViewIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastPosition = -1;
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.isAnimationEnable = true;
        init(context, attributeSet);
    }

    public AnyViewIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mLastPosition = -1;
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.isAnimationEnable = true;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        handleTypedArray(context, attributeSet);
        checkIndicatorConfig(context);
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnyViewIndicator);
        this.mIndicatorWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AnyViewIndicator_avi_width, -1);
        this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AnyViewIndicator_avi_height, -1);
        this.mIndicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AnyViewIndicator_avi_margin, -1);
        this.mAnimatorResId = obtainStyledAttributes.getResourceId(R.styleable.AnyViewIndicator_avi_animator, R.animator.scale_with_alpha);
        this.mAnimatorReverseResId = obtainStyledAttributes.getResourceId(R.styleable.AnyViewIndicator_avi_animator_reverse, 0);
        this.mIndicatorBackgroundResId = obtainStyledAttributes.getResourceId(R.styleable.AnyViewIndicator_avi_drawable, R.drawable.white_radius);
        this.mIndicatorUnselectedBackgroundResId = obtainStyledAttributes.getResourceId(R.styleable.AnyViewIndicator_avi_drawable_unselected, this.mIndicatorBackgroundResId);
        this.isAnimationEnable = obtainStyledAttributes.getBoolean(R.styleable.AnyViewIndicator_avi_animation_enable, true);
        setOrientation(obtainStyledAttributes.getInt(R.styleable.AnyViewIndicator_avi_orientation, -1) == 1 ? 1 : 0);
        int i = obtainStyledAttributes.getInt(R.styleable.AnyViewIndicator_avi_gravity, -1);
        if (i < 0) {
            i = 17;
        }
        setGravity(i);
        obtainStyledAttributes.recycle();
    }

    public void configureIndicator(int i, int i2, int i3) {
        configureIndicator(i, i2, i3, R.animator.scale_with_alpha, 0, R.drawable.white_radius, R.drawable.white_radius);
    }

    public void configureIndicator(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mIndicatorWidth = i;
        this.mIndicatorHeight = i2;
        this.mIndicatorMargin = i3;
        this.mAnimatorResId = i4;
        this.mAnimatorReverseResId = i5;
        this.mIndicatorBackgroundResId = i6;
        this.mIndicatorUnselectedBackgroundResId = i7;
        checkIndicatorConfig(getContext());
    }

    private void checkIndicatorConfig(Context context) {
        int i = this.mIndicatorWidth;
        if (i < 0) {
            i = dip2px(5.0f);
        }
        this.mIndicatorWidth = i;
        int i2 = this.mIndicatorHeight;
        if (i2 < 0) {
            i2 = dip2px(5.0f);
        }
        this.mIndicatorHeight = i2;
        int i3 = this.mIndicatorMargin;
        if (i3 < 0) {
            i3 = dip2px(5.0f);
        }
        this.mIndicatorMargin = i3;
        int i4 = this.mAnimatorResId;
        if (i4 == 0) {
            i4 = R.animator.scale_with_alpha;
        }
        this.mAnimatorResId = i4;
        this.mAnimatorOut = createAnimatorOut(context);
        Animator createAnimatorOut = createAnimatorOut(context);
        this.mImmediateAnimatorOut = createAnimatorOut;
        createAnimatorOut.setDuration(0L);
        this.mAnimatorIn = createAnimatorIn(context);
        Animator createAnimatorIn = createAnimatorIn(context);
        this.mImmediateAnimatorIn = createAnimatorIn;
        createAnimatorIn.setDuration(0L);
        int i5 = this.mIndicatorBackgroundResId;
        if (i5 == 0) {
            i5 = R.drawable.white_radius;
        }
        this.mIndicatorBackgroundResId = i5;
        int i6 = this.mIndicatorUnselectedBackgroundResId;
        if (i6 != 0) {
            i5 = i6;
        }
        this.mIndicatorUnselectedBackgroundResId = i5;
    }

    private Animator createAnimatorOut(Context context) {
        return AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
    }

    private Animator createAnimatorIn(Context context) {
        int i = this.mAnimatorReverseResId;
        if (i == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
            loadAnimator.setInterpolator(new ReverseInterpolator());
            return loadAnimator;
        }
        return AnimatorInflater.loadAnimator(context, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateCircleIndicator() {
        int itemCount = getItemCount();
        if (itemCount == getChildCount()) {
            return;
        }
        if (this.mLastPosition < itemCount) {
            this.mLastPosition = getCurrentPosition();
        } else {
            this.mLastPosition = -1;
        }
        if (this.mLastPosition == -1 && itemCount > 0) {
            this.mLastPosition = 0;
        }
        createIndicators();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCurrentLocationChange() {
        View childAt;
        if (this.isAnimationEnable) {
            if (this.mAnimatorIn.isRunning()) {
                this.mAnimatorIn.end();
                this.mAnimatorIn.cancel();
            }
            if (this.mAnimatorOut.isRunning()) {
                this.mAnimatorOut.end();
                this.mAnimatorOut.cancel();
            }
        }
        int i = this.mLastPosition;
        if (i >= 0 && (childAt = getChildAt(i)) != null) {
            childAt.setBackgroundResource(this.mIndicatorUnselectedBackgroundResId);
            if (this.isAnimationEnable) {
                this.mAnimatorIn.setTarget(childAt);
                this.mAnimatorIn.start();
            }
        }
        int currentPosition = getCurrentPosition();
        View childAt2 = getChildAt(currentPosition);
        if (childAt2 != null) {
            childAt2.setBackgroundResource(this.mIndicatorBackgroundResId);
            if (this.isAnimationEnable) {
                this.mAnimatorOut.setTarget(childAt2);
                this.mAnimatorOut.start();
            }
        }
        this.mLastPosition = currentPosition;
    }

    protected int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int i) {
        this.itemCount = i;
        updateCircleIndicator();
    }

    protected int getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
        onCurrentLocationChange();
    }

    private void createIndicators() {
        removeAllViews();
        int itemCount = getItemCount();
        if (itemCount <= 0) {
            return;
        }
        int currentPosition = getCurrentPosition();
        int orientation = getOrientation();
        if (currentPosition < 0) {
            currentPosition = 0;
        }
        for (int i = 0; i < itemCount; i++) {
            if (currentPosition == i) {
                addIndicator(orientation, this.mIndicatorBackgroundResId, this.mImmediateAnimatorOut);
            } else {
                addIndicator(orientation, this.mIndicatorUnselectedBackgroundResId, this.mImmediateAnimatorIn);
            }
        }
    }

    private void addIndicator(int i, int i2, Animator animator) {
        if (this.isAnimationEnable && animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.mIndicatorWidth, this.mIndicatorHeight);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = this.mIndicatorMargin;
            layoutParams.rightMargin = this.mIndicatorMargin;
        } else {
            layoutParams.topMargin = this.mIndicatorMargin;
            layoutParams.bottomMargin = this.mIndicatorMargin;
        }
        view.setLayoutParams(layoutParams);
        if (this.isAnimationEnable) {
            animator.setTarget(view);
            animator.start();
        }
    }

    public int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ReverseInterpolator implements Interpolator {
        private ReverseInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }
}
