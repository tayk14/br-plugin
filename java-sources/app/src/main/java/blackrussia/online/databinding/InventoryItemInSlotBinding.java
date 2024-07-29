package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryItemInSlotBinding implements ViewBinding {
    public final ImageView iconTelephone;
    public final View invSlotActiveBg;
    public final ImageView playersItem;
    public final View playersItemBg;
    private final ConstraintLayout rootView;

    private InventoryItemInSlotBinding(ConstraintLayout rootView, ImageView iconTelephone, View invSlotActiveBg, ImageView playersItem, View playersItemBg) {
        this.rootView = rootView;
        this.iconTelephone = iconTelephone;
        this.invSlotActiveBg = invSlotActiveBg;
        this.playersItem = playersItem;
        this.playersItemBg = playersItemBg;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryItemInSlotBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryItemInSlotBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_item_in_slot, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryItemInSlotBinding bind(View rootView) {
        int i = R.id.icon_telephone;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_telephone);
        if (imageView != null) {
            i = R.id.inv_slot_active_bg;
            View findViewById = rootView.findViewById(R.id.inv_slot_active_bg);
            if (findViewById != null) {
                i = R.id.players_item;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.players_item);
                if (imageView2 != null) {
                    i = R.id.players_item_bg;
                    View findViewById2 = rootView.findViewById(R.id.players_item_bg);
                    if (findViewById2 != null) {
                        return new InventoryItemInSlotBinding((ConstraintLayout) rootView, imageView, findViewById, imageView2, findViewById2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
