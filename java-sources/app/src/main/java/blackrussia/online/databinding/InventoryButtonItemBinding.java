package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryButtonItemBinding implements ViewBinding {
    public final View invDivers;
    public final ImageView invIconButtonItem;
    public final TextView invTitleButton;
    private final RelativeLayout rootView;

    private InventoryButtonItemBinding(RelativeLayout rootView, View invDivers, ImageView invIconButtonItem, TextView invTitleButton) {
        this.rootView = rootView;
        this.invDivers = invDivers;
        this.invIconButtonItem = invIconButtonItem;
        this.invTitleButton = invTitleButton;
    }

    @Override
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static InventoryButtonItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryButtonItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_button_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryButtonItemBinding bind(View rootView) {
        int i = R.id.inv_divers;
        View findViewById = rootView.findViewById(R.id.inv_divers);
        if (findViewById != null) {
            i = R.id.inv_icon_button_item;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.inv_icon_button_item);
            if (imageView != null) {
                i = R.id.inv_title_button;
                TextView textView = (TextView) rootView.findViewById(R.id.inv_title_button);
                if (textView != null) {
                    return new InventoryButtonItemBinding((RelativeLayout) rootView, findViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
