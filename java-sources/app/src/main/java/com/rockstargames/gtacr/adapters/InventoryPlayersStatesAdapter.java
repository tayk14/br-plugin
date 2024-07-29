package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.InventoryPlayersStateItemBinding;
import com.rockstargames.gtacr.data.InvPlayersStateData;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.inventory.GUIUsersInventory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryPlayersStatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/InventoryPlayersStatesAdapter$ViewHolder;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "statesList", "", "Lcom/rockstargames/gtacr/data/InvPlayersStateData;", "(Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;Ljava/util/List;)V", "binding", "Lblackrussia/online/databinding/InventoryPlayersStateItemBinding;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryPlayersStatesAdapter extends RecyclerView.Adapter<InventoryPlayersStatesAdapter.ViewHolder> {
    private InventoryPlayersStateItemBinding binding;
    private final GUIUsersInventory mainRoot;
    private final List<InvPlayersStateData> statesList;

    public InventoryPlayersStatesAdapter(GUIUsersInventory mainRoot, List<InvPlayersStateData> statesList) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(statesList, "statesList");
        this.mainRoot = mainRoot;
        this.statesList = statesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryPlayersStateItemBinding inflate = InventoryPlayersStateItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.statesList.get(i), this.mainRoot);
    }

    @Override
    public int getItemCount() {
        return this.statesList.size();
    }

    //@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryPlayersStatesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryPlayersStateItemBinding;", "(Lblackrussia/online/databinding/InventoryPlayersStateItemBinding;)V", "bind", "", "playersState", "Lcom/rockstargames/gtacr/data/InvPlayersStateData;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryPlayersStateItemBinding binding;

        public ViewHolder(InventoryPlayersStateItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(InvPlayersStateData playersState, GUIUsersInventory mainRoot) {
            Intrinsics.checkNotNullParameter(playersState, "playersState");
            Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
            this.binding.invStateItemIcon.setImageDrawable(new Useful().getDrawableByName(playersState.getIconsRes(), mainRoot.getMainContext()));
            this.binding.invItemsProgressBar.setMax(playersState.getMaxValueState());
            this.binding.invItemsProgressBar.setProgress(playersState.getThisValueState());
        }
    }
}
