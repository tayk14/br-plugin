package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryExchangeItemBinding implements ViewBinding {
    public final View bgItemsAura;
    public final View invBgItem;
    public final View invItemActiveBg;
    public final ImageView invItemItemsIcon;
    public final ImageView invLineUpOrDown;
    public final ImageView invUnderline;
    public final TextView invValueItems;
    private final ConstraintLayout rootView;

    private InventoryExchangeItemBinding(ConstraintLayout rootView, View bgItemsAura, View invBgItem, View invItemActiveBg, ImageView invItemItemsIcon, ImageView invLineUpOrDown, ImageView invUnderline, TextView invValueItems) {
        this.rootView = rootView;
        this.bgItemsAura = bgItemsAura;
        this.invBgItem = invBgItem;
        this.invItemActiveBg = invItemActiveBg;
        this.invItemItemsIcon = invItemItemsIcon;
        this.invLineUpOrDown = invLineUpOrDown;
        this.invUnderline = invUnderline;
        this.invValueItems = invValueItems;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryExchangeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryExchangeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_exchange_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryExchangeItemBinding bind(View rootView) {
        int i = R.id.bg_items_aura;
        View findViewById = rootView.findViewById(R.id.bg_items_aura);
        if (findViewById != null) {
            i = R.id.inv_bg_item;
            View findViewById2 = rootView.findViewById(R.id.inv_bg_item);
            if (findViewById2 != null) {
                i = R.id.inv_item_active_bg;
                View findViewById3 = rootView.findViewById(R.id.inv_item_active_bg);
                if (findViewById3 != null) {
                    i = R.id.inv_item_items_icon;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.inv_item_items_icon);
                    if (imageView != null) {
                        i = R.id.inv_line_up_or_down;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.inv_line_up_or_down);
                        if (imageView2 != null) {
                            i = R.id.inv_underline;
                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.inv_underline);
                            if (imageView3 != null) {
                                i = R.id.inv_value_items;
                                TextView textView = (TextView) rootView.findViewById(R.id.inv_value_items);
                                if (textView != null) {
                                    return new InventoryExchangeItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, imageView, imageView2, imageView3, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
