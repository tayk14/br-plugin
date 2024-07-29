package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesUpgradeChildItemBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.FamilyUpgradeValueData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyUpgradeChildItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyUpgradeChildItemAdapter$ViewHolder;", "upgradeValues", "", "Lcom/rockstargames/gtacr/data/FamilyUpgradeValueData;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/FamiliesUpgradeChildItemBinding;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyUpgradeChildItemAdapter extends RecyclerView.Adapter<FamilyUpgradeChildItemAdapter.ViewHolder> {
    private final NvEventQueueActivity activity;
    private FamiliesUpgradeChildItemBinding binding;
    private final List<FamilyUpgradeValueData> upgradeValues;

    public FamilyUpgradeChildItemAdapter(List<FamilyUpgradeValueData> upgradeValues, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(upgradeValues, "upgradeValues");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.upgradeValues = upgradeValues;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesUpgradeChildItemBinding inflate = FamiliesUpgradeChildItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.upgradeValues.get(i));
    }

    @Override
    public int getItemCount() {
        return this.upgradeValues.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyUpgradeChildItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesUpgradeChildItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyUpgradeChildItemAdapter;Lblackrussia/online/databinding/FamiliesUpgradeChildItemBinding;)V", "bind", "", "upgradeItem", "Lcom/rockstargames/gtacr/data/FamilyUpgradeValueData;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesUpgradeChildItemBinding binding;
        final FamilyUpgradeChildItemAdapter this$0;

        public ViewHolder(FamilyUpgradeChildItemAdapter this$0, FamiliesUpgradeChildItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(FamilyUpgradeValueData upgradeItem) {
            Intrinsics.checkNotNullParameter(upgradeItem, "upgradeItem");
            FamiliesUpgradeChildItemBinding familiesUpgradeChildItemBinding = this.binding;
            FamilyUpgradeChildItemAdapter familyUpgradeChildItemAdapter = this.this$0;
            String description = upgradeItem.getDescription();
            switch (description.hashCode()) {
                case -1587433046:
                    if (description.equals("gasoline")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Хранить");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_oil, new Object[]{Integer.valueOf(upgradeItem.getValue())}));
                        break;
                    }
                    break;
                case -1409300624:
                    if (description.equals("armour")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Хранить");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_armor, new Object[]{Integer.valueOf(upgradeItem.getValue())}));
                        break;
                    }
                    break;
                case -991808881:
                    if (description.equals("people")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Количество членов семьи");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_people, new Object[]{Integer.valueOf(upgradeItem.getValue())}));
                        break;
                    }
                    break;
                case 2997966:
                    if (description.equals("ammo")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Хранить");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_ammo, new Object[]{Integer.valueOf(upgradeItem.getValue())}));
                        break;
                    }
                    break;
                case 103667463:
                    if (description.equals("masks")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Хранить");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_masks, new Object[]{Integer.valueOf(upgradeItem.getValue())}));
                        break;
                    }
                    break;
                case 104079552:
                    if (description.equals("money")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Хранить");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_money, new Object[]{new Useful().getPriceWithSpacesForInt(upgradeItem.getValue())}));
                        break;
                    }
                    break;
                case 681132076:
                    if (description.equals("materials")) {
                        familiesUpgradeChildItemBinding.titleUpgrade.setText("Хранить");
                        familiesUpgradeChildItemBinding.valueUpgrade.setText(familyUpgradeChildItemAdapter.activity.getString(R.string.families_store_materials, new Object[]{Integer.valueOf(upgradeItem.getValue())}));
                        break;
                    }
                    break;
            }
            familiesUpgradeChildItemBinding.valueUpgrade.setSelected(true);
        }
    }
}
