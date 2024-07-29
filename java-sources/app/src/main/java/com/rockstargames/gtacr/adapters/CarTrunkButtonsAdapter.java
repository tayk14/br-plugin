package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.InventoryButtonItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.adapters.CarTrunkButtonsAdapter;
import com.rockstargames.gtacr.data.InvMainButtonsData;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.inventory.GUICarsTrunkOrCloset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fBW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012:\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u000f2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/rockstargames/gtacr/adapters/CarTrunkButtonsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/CarTrunkButtonsAdapter$ViewHolder;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUICarsTrunkOrCloset;", "buttonsList", "", "Lcom/rockstargames/gtacr/data/InvMainButtonsData;", "mainButtonsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "mainButton", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/gui/inventory/OnMainButtonsClickListener;", "(Lcom/rockstargames/gtacr/gui/inventory/GUICarsTrunkOrCloset;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "binding", "Lblackrussia/online/databinding/InventoryButtonItemBinding;", "mUseful", "Lcom/rockstargames/gtacr/gui/Useful;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarTrunkButtonsAdapter extends RecyclerView.Adapter<CarTrunkButtonsAdapter.ViewHolder> {
    private InventoryButtonItemBinding binding;
    private final List<InvMainButtonsData> buttonsList;
    private final Useful mUseful;
    private final Function2<InvMainButtonsData, View, Unit> mainButtonsClickListener;
    private final GUICarsTrunkOrCloset mainRoot;

    public CarTrunkButtonsAdapter(GUICarsTrunkOrCloset mainRoot, List<InvMainButtonsData> buttonsList, Function2<? super InvMainButtonsData, ? super View, Unit> mainButtonsClickListener) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(buttonsList, "buttonsList");
        Intrinsics.checkNotNullParameter(mainButtonsClickListener, "mainButtonsClickListener");
        this.mainRoot = mainRoot;
        this.buttonsList = buttonsList;
        this.mainButtonsClickListener = (Function2<InvMainButtonsData, View, Unit>) mainButtonsClickListener;
        this.mUseful = new Useful();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryButtonItemBinding inflate = InventoryButtonItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.buttonsList.get(i), this.mainButtonsClickListener, this.mainRoot);
    }

    @Override
    public int getItemCount() {
        return this.buttonsList.size();
    }

    //@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/rockstargames/gtacr/adapters/CarTrunkButtonsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryButtonItemBinding;", "(Lcom/rockstargames/gtacr/adapters/CarTrunkButtonsAdapter;Lblackrussia/online/databinding/InventoryButtonItemBinding;)V", "bind", "", "mainButton", "Lcom/rockstargames/gtacr/data/InvMainButtonsData;", "mainButtonsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/view/View;", "view", "Lcom/rockstargames/gtacr/gui/inventory/OnMainButtonsClickListener;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUICarsTrunkOrCloset;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryButtonItemBinding binding;
        final CarTrunkButtonsAdapter this$0;

        public ViewHolder(CarTrunkButtonsAdapter this$0, InventoryButtonItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final InvMainButtonsData mainButton, final Function2<? super InvMainButtonsData, ? super View, Unit> mainButtonsClickListener, GUICarsTrunkOrCloset mainRoot) {
            Intrinsics.checkNotNullParameter(mainButton, "mainButton");
            Intrinsics.checkNotNullParameter(mainButtonsClickListener, "mainButtonsClickListener");
            Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
            this.binding.invTitleButton.setText(mainButton.getNameButton());
            this.binding.invIconButtonItem.setImageDrawable(this.this$0.mUseful.getDrawableByName(mainButton.getIconsRes(), mainRoot.getMainContext()));
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    ViewHolder.m50bind$lambda0(mainButtonsClickListener, mainButton, view);
                }
            });
        }

        public static final void m50bind$lambda0(Function2 mainButtonsClickListener, InvMainButtonsData mainButton, View it) {
            Intrinsics.checkNotNullParameter(mainButtonsClickListener, "$mainButtonsClickListener");
            Intrinsics.checkNotNullParameter(mainButton, "$mainButton");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mainButtonsClickListener.invoke(mainButton, it);
        }
    }
}
