package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesUpgradeChildItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView titleUpgrade;
    public final TextView valueUpgrade;

    private FamiliesUpgradeChildItemBinding(ConstraintLayout rootView, TextView titleUpgrade, TextView valueUpgrade) {
        this.rootView = rootView;
        this.titleUpgrade = titleUpgrade;
        this.valueUpgrade = valueUpgrade;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesUpgradeChildItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesUpgradeChildItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_upgrade_child_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesUpgradeChildItemBinding bind(View rootView) {
        int i = R.id.title_upgrade;
        TextView textView = (TextView) rootView.findViewById(R.id.title_upgrade);
        if (textView != null) {
            i = R.id.value_upgrade;
            TextView textView2 = (TextView) rootView.findViewById(R.id.value_upgrade);
            if (textView2 != null) {
                return new FamiliesUpgradeChildItemBinding((ConstraintLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
