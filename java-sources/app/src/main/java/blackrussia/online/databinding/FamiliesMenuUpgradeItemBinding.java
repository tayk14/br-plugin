package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMenuUpgradeItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView upgradeTitle;
    public final TextView upgradeValue;

    private FamiliesMenuUpgradeItemBinding(ConstraintLayout rootView, TextView upgradeTitle, TextView upgradeValue) {
        this.rootView = rootView;
        this.upgradeTitle = upgradeTitle;
        this.upgradeValue = upgradeValue;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuUpgradeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuUpgradeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_upgrade_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuUpgradeItemBinding bind(View rootView) {
        int i = R.id.upgrade_title;
        TextView textView = (TextView) rootView.findViewById(R.id.upgrade_title);
        if (textView != null) {
            i = R.id.upgrade_value;
            TextView textView2 = (TextView) rootView.findViewById(R.id.upgrade_value);
            if (textView2 != null) {
                return new FamiliesMenuUpgradeItemBinding((ConstraintLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
