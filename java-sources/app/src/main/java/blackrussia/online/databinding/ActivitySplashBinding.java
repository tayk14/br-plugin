package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import java.util.Objects;

public final class ActivitySplashBinding implements ViewBinding {
    private final FrameLayout rootView;

    private ActivitySplashBinding(FrameLayout rootView) {
        this.rootView = rootView;
    }

    @Override
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_splash, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySplashBinding bind(View rootView) {
        Objects.requireNonNull(rootView, "rootView");
        return new ActivitySplashBinding((FrameLayout) rootView);
    }
}
