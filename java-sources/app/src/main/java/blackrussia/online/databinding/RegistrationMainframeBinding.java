package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;
import java.util.Objects;

public final class RegistrationMainframeBinding implements ViewBinding {
    public final UIContainer container;
    private final UIContainer rootView;

    private RegistrationMainframeBinding(UIContainer rootView, UIContainer container) {
        this.rootView = rootView;
        this.container = container;
    }

    @Override
    public UIContainer getRoot() {
        return this.rootView;
    }

    public static RegistrationMainframeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationMainframeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_mainframe, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationMainframeBinding bind(View rootView) {
        Objects.requireNonNull(rootView, "rootView");
        UIContainer uIContainer = (UIContainer) rootView;
        return new RegistrationMainframeBinding(uIContainer, uIContainer);
    }
}
