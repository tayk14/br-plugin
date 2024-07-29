package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesUpgradeParentItemBinding implements ViewBinding {
    public final TextView potential;
    public final TextView potentialValue;
    private final ConstraintLayout rootView;
    public final RecyclerView upgradeValues;

    private FamiliesUpgradeParentItemBinding(ConstraintLayout rootView, TextView potential, TextView potentialValue, RecyclerView upgradeValues) {
        this.rootView = rootView;
        this.potential = potential;
        this.potentialValue = potentialValue;
        this.upgradeValues = upgradeValues;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesUpgradeParentItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesUpgradeParentItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_upgrade_parent_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesUpgradeParentItemBinding bind(View rootView) {
        int i = R.id.potential;
        TextView textView = (TextView) rootView.findViewById(R.id.potential);
        if (textView != null) {
            i = R.id.potential_value;
            TextView textView2 = (TextView) rootView.findViewById(R.id.potential_value);
            if (textView2 != null) {
                i = R.id.upgrade_values;
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.upgrade_values);
                if (recyclerView != null) {
                    return new FamiliesUpgradeParentItemBinding((ConstraintLayout) rootView, textView, textView2, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
