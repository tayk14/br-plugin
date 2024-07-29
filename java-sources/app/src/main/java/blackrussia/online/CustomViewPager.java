package blackrussia.online;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class CustomViewPager extends ViewPager {
    private boolean enabled;
    private FixedSpeedScroller mScroller;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mScroller = null;
        this.enabled = true;
        init();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }
        init();
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private void init() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            FixedSpeedScroller fixedSpeedScroller = new FixedSpeedScroller(getContext(), new DecelerateInterpolator());
            this.mScroller = fixedSpeedScroller;
            declaredField.set(this, fixedSpeedScroller);
        } catch (Exception unused) {
        }
    }

    public void setScrollDuration(int duration) {
        this.mScroller.setScrollDuration(duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FixedSpeedScroller extends Scroller {
        private int mDuration;

        public FixedSpeedScroller(Context context) {
            super(context);
            this.mDuration = 500;
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.mDuration = 500;
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
            this.mDuration = 500;
        }

        @Override // android.widget.Scroller
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, this.mDuration);
        }

        @Override // android.widget.Scroller
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, this.mDuration);
        }

        public void setScrollDuration(int duration) {
            this.mDuration = duration;
        }
    }
}
