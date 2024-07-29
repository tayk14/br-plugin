package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryItemsItemBinding implements ViewBinding {
    public final View bgItemsAura;
    public final View bgMask;
    public final ImageView iconIfNoActive;
    public final View invBgItem;
    public final View invItemActiveBg;
    public final ImageView invItemItemsIcon;
    public final TextView invValueItems;
    private final ConstraintLayout rootView;
    public final View testBottomFill;
    public final TextView textIfNotActual;

    private InventoryItemsItemBinding(ConstraintLayout rootView, View bgItemsAura, View bgMask, ImageView iconIfNoActive, View invBgItem, View invItemActiveBg, ImageView invItemItemsIcon, TextView invValueItems, View testBottomFill, TextView textIfNotActual) {
        this.rootView = rootView;
        this.bgItemsAura = bgItemsAura;
        this.bgMask = bgMask;
        this.iconIfNoActive = iconIfNoActive;
        this.invBgItem = invBgItem;
        this.invItemActiveBg = invItemActiveBg;
        this.invItemItemsIcon = invItemItemsIcon;
        this.invValueItems = invValueItems;
        this.testBottomFill = testBottomFill;
        this.textIfNotActual = textIfNotActual;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryItemsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryItemsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_items_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryItemsItemBinding bind(View rootView) {
        int i = R.id.bg_items_aura;
        View findViewById = rootView.findViewById(R.id.bg_items_aura);
        if (findViewById != null) {
            i = R.id.bg_mask;
            View findViewById2 = rootView.findViewById(R.id.bg_mask);
            if (findViewById2 != null) {
                i = R.id.icon_if_no_active;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_if_no_active);
                if (imageView != null) {
                    i = R.id.inv_bg_item;
                    View findViewById3 = rootView.findViewById(R.id.inv_bg_item);
                    if (findViewById3 != null) {
                        i = R.id.inv_item_active_bg;
                        View findViewById4 = rootView.findViewById(R.id.inv_item_active_bg);
                        if (findViewById4 != null) {
                            i = R.id.inv_item_items_icon;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.inv_item_items_icon);
                            if (imageView2 != null) {
                                i = R.id.inv_value_items;
                                TextView textView = (TextView) rootView.findViewById(R.id.inv_value_items);
                                if (textView != null) {
                                    i = R.id.test_bottom_fill;
                                    View findViewById5 = rootView.findViewById(R.id.test_bottom_fill);
                                    if (findViewById5 != null) {
                                        i = R.id.text_if_not_actual;
                                        TextView textView2 = (TextView) rootView.findViewById(R.id.text_if_not_actual);
                                        if (textView2 != null) {
                                            return new InventoryItemsItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, imageView, findViewById3, findViewById4, imageView2, textView, findViewById5, textView2);
                                        }
                                    }
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
