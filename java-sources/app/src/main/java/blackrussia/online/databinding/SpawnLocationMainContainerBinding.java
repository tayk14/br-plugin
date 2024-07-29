package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;
import java.util.Objects;

public final class SpawnLocationMainContainerBinding implements ViewBinding {
    public final UIContainer mainContainer;
    private final UIContainer rootView;

    private SpawnLocationMainContainerBinding(UIContainer rootView, UIContainer mainContainer) {
        this.rootView = rootView;
        this.mainContainer = mainContainer;
    }

    @Override
    public UIContainer getRoot() {
        return this.rootView;
    }

    public static SpawnLocationMainContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpawnLocationMainContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.spawn_location_main_container, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpawnLocationMainContainerBinding bind(View rootView) {
        Objects.requireNonNull(rootView, "rootView");
        UIContainer uIContainer = (UIContainer) rootView;
        return new SpawnLocationMainContainerBinding(uIContainer, uIContainer);
    }
}
