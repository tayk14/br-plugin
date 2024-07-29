package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesShopLayoutBinding implements ViewBinding {
    public final RecyclerView marketList;
    private final ConstraintLayout rootView;

    private FamiliesShopLayoutBinding(ConstraintLayout rootView, RecyclerView marketList) {
        this.rootView = rootView;
        this.marketList = marketList;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesShopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesShopLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_shop_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesShopLayoutBinding bind(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.market_list);
        if (recyclerView != null) {
            return new FamiliesShopLayoutBinding((ConstraintLayout) rootView, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.market_list)));
    }
}
