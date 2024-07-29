package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryButtonActionItemBinding implements ViewBinding {
    public final View invButtonActionBg;
    public final ImageView invButtonActionIcon;
    public final View invButtonActionTitleBg;
    public final TextView invTitleButtonAction;
    private final ConstraintLayout rootView;

    private InventoryButtonActionItemBinding(ConstraintLayout rootView, View invButtonActionBg, ImageView invButtonActionIcon, View invButtonActionTitleBg, TextView invTitleButtonAction) {
        this.rootView = rootView;
        this.invButtonActionBg = invButtonActionBg;
        this.invButtonActionIcon = invButtonActionIcon;
        this.invButtonActionTitleBg = invButtonActionTitleBg;
        this.invTitleButtonAction = invTitleButtonAction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryButtonActionItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryButtonActionItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_button_action_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryButtonActionItemBinding bind(View rootView) {
        int i = R.id.inv_button_action_bg;
        View findViewById = rootView.findViewById(R.id.inv_button_action_bg);
        if (findViewById != null) {
            i = R.id.inv_button_action_icon;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.inv_button_action_icon);
            if (imageView != null) {
                i = R.id.inv_button_action_title_bg;
                View findViewById2 = rootView.findViewById(R.id.inv_button_action_title_bg);
                if (findViewById2 != null) {
                    i = R.id.inv_title_button_action;
                    TextView textView = (TextView) rootView.findViewById(R.id.inv_title_button_action);
                    if (textView != null) {
                        return new InventoryButtonActionItemBinding((ConstraintLayout) rootView, findViewById, imageView, findViewById2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
