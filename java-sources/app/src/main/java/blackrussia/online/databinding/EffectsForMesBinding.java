package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import java.util.Objects;

public final class EffectsForMesBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private EffectsForMesBinding(ConstraintLayout rootView) {
        this.rootView = rootView;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EffectsForMesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EffectsForMesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.effects_for_mes, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EffectsForMesBinding bind(View rootView) {
        Objects.requireNonNull(rootView, "rootView");
        return new EffectsForMesBinding((ConstraintLayout) rootView);
    }
}
