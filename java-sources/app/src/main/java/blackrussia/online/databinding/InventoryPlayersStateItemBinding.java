package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryPlayersStateItemBinding implements ViewBinding {
    public final ProgressBar invItemsProgressBar;
    public final ImageView invStateItemIcon;
    private final ConstraintLayout rootView;

    private InventoryPlayersStateItemBinding(ConstraintLayout rootView, ProgressBar invItemsProgressBar, ImageView invStateItemIcon) {
        this.rootView = rootView;
        this.invItemsProgressBar = invItemsProgressBar;
        this.invStateItemIcon = invStateItemIcon;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryPlayersStateItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryPlayersStateItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_players_state_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryPlayersStateItemBinding bind(View rootView) {
        int i = R.id.inv_items_progress_bar;
        ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.inv_items_progress_bar);
        if (progressBar != null) {
            i = R.id.inv_state_item_icon;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.inv_state_item_icon);
            if (imageView != null) {
                return new InventoryPlayersStateItemBinding((ConstraintLayout) rootView, progressBar, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
