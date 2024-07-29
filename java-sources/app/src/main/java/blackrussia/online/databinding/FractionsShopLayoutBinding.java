package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsShopLayoutBinding implements ViewBinding {
    public final RecyclerView recyclerViewShop;
    private final ConstraintLayout rootView;

    private FractionsShopLayoutBinding(ConstraintLayout rootView, RecyclerView recyclerViewShop) {
        this.rootView = rootView;
        this.recyclerViewShop = recyclerViewShop;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsShopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsShopLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_shop_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsShopLayoutBinding bind(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_shop);
        if (recyclerView != null) {
            return new FractionsShopLayoutBinding((ConstraintLayout) rootView, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.recycler_view_shop)));
    }
}
