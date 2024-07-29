package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMenuMainItemBinding implements ViewBinding {
    public final TextView menuValue;
    private final ConstraintLayout rootView;

    private FamiliesMenuMainItemBinding(ConstraintLayout rootView, TextView menuValue) {
        this.rootView = rootView;
        this.menuValue = menuValue;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuMainItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuMainItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_main_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuMainItemBinding bind(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.menu_value);
        if (textView != null) {
            return new FamiliesMenuMainItemBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.menu_value)));
    }
}
