package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsShopItemBinding implements ViewBinding {
    public final ImageView imageViewBoxImage;
    public final View mainRootView;
    private final ConstraintLayout rootView;
    public final TextView textViewPrice;
    public final TextView textViewTitle;

    private FractionsShopItemBinding(ConstraintLayout rootView, ImageView imageViewBoxImage, View mainRootView, TextView textViewPrice, TextView textViewTitle) {
        this.rootView = rootView;
        this.imageViewBoxImage = imageViewBoxImage;
        this.mainRootView = mainRootView;
        this.textViewPrice = textViewPrice;
        this.textViewTitle = textViewTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsShopItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsShopItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_shop_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsShopItemBinding bind(View rootView) {
        int i = R.id.image_view_box_image;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view_box_image);
        if (imageView != null) {
            i = R.id.main_root_view;
            View findViewById = rootView.findViewById(R.id.main_root_view);
            if (findViewById != null) {
                i = R.id.text_view_price;
                TextView textView = (TextView) rootView.findViewById(R.id.text_view_price);
                if (textView != null) {
                    i = R.id.text_view_title;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_title);
                    if (textView2 != null) {
                        return new FractionsShopItemBinding((ConstraintLayout) rootView, imageView, findViewById, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
