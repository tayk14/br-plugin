package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.InventoryButtonActionItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.adapters.InventoryActionButtonsAdapter;
import com.rockstargames.gtacr.data.InvActionButtonsData;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.inventory.GUIUsersInventory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dBW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012:\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016RB\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryActionButtonsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/InventoryActionButtonsAdapter$ViewHolder;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "buttonsList", "", "Lcom/rockstargames/gtacr/data/InvActionButtonsData;", "actionButtonsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "actionButton", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/adapters/OnActionButtonsClickListener;", "(Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "binding", "Lblackrussia/online/databinding/InventoryButtonActionItemBinding;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryActionButtonsAdapter extends RecyclerView.Adapter<InventoryActionButtonsAdapter.ViewHolder> {
    private final Function2<InvActionButtonsData, View, Unit> actionButtonsClickListener;
    private InventoryButtonActionItemBinding binding;
    private final List<InvActionButtonsData> buttonsList;
    private final GUIUsersInventory mainRoot;

    public InventoryActionButtonsAdapter(GUIUsersInventory mainRoot, List<InvActionButtonsData> buttonsList, Function2<? super InvActionButtonsData, ? super View, Unit> actionButtonsClickListener) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(buttonsList, "buttonsList");
        Intrinsics.checkNotNullParameter(actionButtonsClickListener, "actionButtonsClickListener");
        this.mainRoot = mainRoot;
        this.buttonsList = buttonsList;
        this.actionButtonsClickListener = (Function2<InvActionButtonsData, View, Unit>) actionButtonsClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryButtonActionItemBinding inflate = InventoryButtonActionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.buttonsList.get(i), this.actionButtonsClickListener, this.mainRoot);
    }

    @Override
    public int getItemCount() {
        return this.buttonsList.size();
    }

    //@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryActionButtonsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryButtonActionItemBinding;", "(Lblackrussia/online/databinding/InventoryButtonActionItemBinding;)V", "bind", "", "actionButton", "Lcom/rockstargames/gtacr/data/InvActionButtonsData;", "actionButtonsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/view/View;", "view", "Lcom/rockstargames/gtacr/adapters/OnActionButtonsClickListener;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryButtonActionItemBinding binding;

        public ViewHolder(InventoryButtonActionItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(final InvActionButtonsData actionButton, final Function2<? super InvActionButtonsData, ? super View, Unit> actionButtonsClickListener, GUIUsersInventory mainRoot) {
            Intrinsics.checkNotNullParameter(actionButton, "actionButton");
            Intrinsics.checkNotNullParameter(actionButtonsClickListener, "actionButtonsClickListener");
            Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
            this.binding.invTitleButtonAction.setText(actionButton.getNameButton());
            this.binding.invButtonActionIcon.setImageDrawable(new Useful().getDrawableByName(actionButton.getIconsRes(), mainRoot.getMainContext()));
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    ViewHolder.m97bind$lambda0(actionButtonsClickListener, actionButton, view);
                }
            });
        }

        public static final void m97bind$lambda0(Function2 actionButtonsClickListener, InvActionButtonsData actionButton, View it) {
            Intrinsics.checkNotNullParameter(actionButtonsClickListener, "$actionButtonsClickListener");
            Intrinsics.checkNotNullParameter(actionButton, "$actionButton");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            actionButtonsClickListener.invoke(actionButton, it);
        }
    }
}
