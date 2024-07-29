package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesUpgradeParentItemBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.FamilyUpgradeValueData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B7\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyUpgradeParentItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyUpgradeParentItemAdapter$ViewHolder;", "levels", "", "", "upgradeCurrentValueList", "Lcom/rockstargames/gtacr/data/FamilyUpgradeValueData;", "upgradeNewValueList", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/FamiliesUpgradeParentItemBinding;", "childAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyUpgradeChildItemAdapter;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyUpgradeParentItemAdapter extends RecyclerView.Adapter<FamilyUpgradeParentItemAdapter.ViewHolder> {
    private final NvEventQueueActivity activity;
    private FamiliesUpgradeParentItemBinding binding;
    private FamilyUpgradeChildItemAdapter childAdapter;
    private final List<Integer> levels;
    private final List<FamilyUpgradeValueData> upgradeCurrentValueList;
    private final List<FamilyUpgradeValueData> upgradeNewValueList;

    public FamilyUpgradeParentItemAdapter(List<Integer> levels, List<FamilyUpgradeValueData> upgradeCurrentValueList, List<FamilyUpgradeValueData> upgradeNewValueList, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(levels, "levels");
        Intrinsics.checkNotNullParameter(upgradeCurrentValueList, "upgradeCurrentValueList");
        Intrinsics.checkNotNullParameter(upgradeNewValueList, "upgradeNewValueList");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.levels = levels;
        this.upgradeCurrentValueList = upgradeCurrentValueList;
        this.upgradeNewValueList = upgradeNewValueList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesUpgradeParentItemBinding inflate = FamiliesUpgradeParentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.levels.get(i).intValue(), i);
    }

    @Override
    public int getItemCount() {
        return this.levels.size();
    }

    //@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyUpgradeParentItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesUpgradeParentItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyUpgradeParentItemAdapter;Lblackrussia/online/databinding/FamiliesUpgradeParentItemBinding;)V", "bind", "", "level", "", "position", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesUpgradeParentItemBinding binding;
        final FamilyUpgradeParentItemAdapter this$0;

        public ViewHolder(FamilyUpgradeParentItemAdapter this$0, FamiliesUpgradeParentItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(int i, int i2) {
            FamilyUpgradeChildItemAdapter familyUpgradeChildItemAdapter;
            FamiliesUpgradeParentItemBinding familiesUpgradeParentItemBinding = this.binding;
            FamilyUpgradeParentItemAdapter familyUpgradeParentItemAdapter = this.this$0;
            familiesUpgradeParentItemBinding.potentialValue.setText(familyUpgradeParentItemAdapter.activity.getString(R.string.families_upgrade_level, new Object[]{Integer.valueOf(i)}));
            familiesUpgradeParentItemBinding.potentialValue.setSelected(true);
            if (i2 == 1) {
                familyUpgradeChildItemAdapter = new FamilyUpgradeChildItemAdapter(familyUpgradeParentItemAdapter.upgradeNewValueList, familyUpgradeParentItemAdapter.activity);
            } else {
                familyUpgradeChildItemAdapter = new FamilyUpgradeChildItemAdapter(familyUpgradeParentItemAdapter.upgradeCurrentValueList, familyUpgradeParentItemAdapter.activity);
            }
            familyUpgradeParentItemAdapter.childAdapter = familyUpgradeChildItemAdapter;
            RecyclerView recyclerView = familiesUpgradeParentItemBinding.upgradeValues;
            recyclerView.setLayoutManager(new LinearLayoutManager(familiesUpgradeParentItemBinding.getRoot().getContext(), 1, false));
            recyclerView.setAdapter(familyUpgradeParentItemAdapter.childAdapter);
        }
    }
}
