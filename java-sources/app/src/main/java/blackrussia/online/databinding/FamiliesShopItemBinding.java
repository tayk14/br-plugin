package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesShopItemBinding implements ViewBinding {
    public final View familyShopBgItem;
    public final ImageView familyShopItemsIcon;
    public final ImageView iconCurrency;
    private final ConstraintLayout rootView;
    public final TextView titleShopItem;
    public final TextView valuePrice;

    private FamiliesShopItemBinding(ConstraintLayout rootView, View familyShopBgItem, ImageView familyShopItemsIcon, ImageView iconCurrency, TextView titleShopItem, TextView valuePrice) {
        this.rootView = rootView;
        this.familyShopBgItem = familyShopBgItem;
        this.familyShopItemsIcon = familyShopItemsIcon;
        this.iconCurrency = iconCurrency;
        this.titleShopItem = titleShopItem;
        this.valuePrice = valuePrice;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesShopItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesShopItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_shop_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesShopItemBinding bind(View rootView) {
        int i = R.id.family_shop_bg_item;
        View findViewById = rootView.findViewById(R.id.family_shop_bg_item);
        if (findViewById != null) {
            i = R.id.family_shop_items_icon;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.family_shop_items_icon);
            if (imageView != null) {
                i = R.id.icon_currency;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.icon_currency);
                if (imageView2 != null) {
                    i = R.id.title_shop_item;
                    TextView textView = (TextView) rootView.findViewById(R.id.title_shop_item);
                    if (textView != null) {
                        i = R.id.value_price;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.value_price);
                        if (textView2 != null) {
                            return new FamiliesShopItemBinding((ConstraintLayout) rootView, findViewById, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
