package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.FractionsShopLayoutBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FractionsShopAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FractionsShopList;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsShopViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionsShopLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "shopViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsShopViewModel;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsShopViewModel;)V", "_binding", "Lblackrussia/online/databinding/FractionsShopLayoutBinding;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionsShopLayoutBinding;", "shopAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsShopAdapter;", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "removeObservers", "setupObservers", "setupRecyclerView", "setupShopAdapter", "list", "Lcom/rockstargames/gtacr/data/FractionsShopList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionsShopLayout extends UILayout {
    private FractionsShopLayoutBinding _binding;
    private final NvEventQueueActivity activity;
    private FractionsShopAdapter shopAdapter;
    private final FractionsShopViewModel shopViewModel;

    public UIFractionsShopLayout(NvEventQueueActivity activity, FractionsShopViewModel shopViewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shopViewModel, "shopViewModel");
        this.activity = activity;
        this.shopViewModel = shopViewModel;
    }

    private final FractionsShopLayoutBinding getBinding() {
        FractionsShopLayoutBinding fractionsShopLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fractionsShopLayoutBinding);
        return fractionsShopLayoutBinding;
    }

    @Override
    public View getView() {
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FractionsShopLayoutBinding.inflate(inflater);
        setupRecyclerView();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerViewShop;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3, 1, false));
    }

    private final void setupObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.shopViewModel.getShopListLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsShopLayout.m288setupObservers$lambda2$lambda1(UIFractionsShopLayout.this, (FractionsShopList) obj);
            }
        });
    }

    public static final void m288setupObservers$lambda2$lambda1(UIFractionsShopLayout this$0, FractionsShopList fractionsShopList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (fractionsShopList != null) {
            this$0.setupShopAdapter(fractionsShopList);
        }
    }

    private final void removeObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.shopViewModel.getShopListLiveData().removeObservers(lifecycleOwner);
    }

    private final void setupShopAdapter(FractionsShopList fractionsShopList) {
        FractionsShopAdapter fractionsShopAdapter = new FractionsShopAdapter(fractionsShopList, this.activity);
        fractionsShopAdapter.setOnItemClickListener(new Function1<Integer, Unit>() {
            @Override
            public Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                FractionsShopViewModel fractionsShopViewModel;
                fractionsShopViewModel = UIFractionsShopLayout.this.shopViewModel;
                fractionsShopViewModel.sendItemPressed(i);
            }
        });
        this.shopAdapter = fractionsShopAdapter;
        getBinding().recyclerViewShop.setAdapter(this.shopAdapter);
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
        setupObservers();
    }

    @Override
    public void onLayoutClose() {
        removeObservers();
    }
}
