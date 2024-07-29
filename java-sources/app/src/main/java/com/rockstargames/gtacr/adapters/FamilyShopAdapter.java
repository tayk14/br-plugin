package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesShopItemBinding;
import blackrussia.online.network.FamilySystemShopObj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyShopAdapter;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.familySystem.FamilyUseful;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB_\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00020\r2\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000bR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyShopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyShopAdapter$ViewHolder;", "listShopItems", "", "Lblackrussia/online/network/FamilySystemShopObj;", "onClickItemInShopList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "", "position", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickItemInShopList;", "familyUseful", "Lcom/rockstargames/gtacr/gui/familySystem/FamilyUseful;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/rockstargames/gtacr/gui/familySystem/FamilyUseful;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/FamiliesShopItemBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyShopAdapter extends RecyclerView.Adapter<FamilyShopAdapter.ViewHolder> {
    private FamiliesShopItemBinding binding;
    private final NvEventQueueActivity context;
    private final FamilyUseful familyUseful;
    private final List<FamilySystemShopObj> listShopItems;
    private final Function2<FamilySystemShopObj, Integer, Unit> onClickItemInShopList;

    public FamilyShopAdapter(List<FamilySystemShopObj> listShopItems, Function2<? super FamilySystemShopObj, ? super Integer, Unit> onClickItemInShopList, FamilyUseful familyUseful, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(listShopItems, "listShopItems");
        Intrinsics.checkNotNullParameter(onClickItemInShopList, "onClickItemInShopList");
        Intrinsics.checkNotNullParameter(familyUseful, "familyUseful");
        Intrinsics.checkNotNullParameter(context, "context");
        this.listShopItems = listShopItems;
        this.onClickItemInShopList = (Function2<FamilySystemShopObj, Integer, Unit>) onClickItemInShopList;
        this.familyUseful = familyUseful;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesShopItemBinding inflate = FamiliesShopItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.listShopItems.get(i), this.onClickItemInShopList);
    }

    @Override
    public int getItemCount() {
        return this.listShopItems.size();
    }

    //@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyShopAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesShopItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyShopAdapter;Lblackrussia/online/databinding/FamiliesShopItemBinding;)V", "bind", "", "item", "Lblackrussia/online/network/FamilySystemShopObj;", "onClickItemInShopList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "", "position", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickItemInShopList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesShopItemBinding binding;
        final FamilyShopAdapter this$0;

        public ViewHolder(FamilyShopAdapter this$0, FamiliesShopItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilySystemShopObj item, final Function2<? super FamilySystemShopObj, ? super Integer, Unit> onClickItemInShopList) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(onClickItemInShopList, "onClickItemInShopList");
            FamiliesShopItemBinding familiesShopItemBinding = this.binding;
            FamilyShopAdapter familyShopAdapter = this.this$0;
            if (item.isClicked()) {
                familiesShopItemBinding.familyShopBgItem.setBackground(ResourcesCompat.getDrawable(familyShopAdapter.context.getResources(), R.drawable.families_shop_active_item_bg_res, null));
            } else {
                familiesShopItemBinding.familyShopBgItem.setBackground(ResourcesCompat.getDrawable(familyShopAdapter.context.getResources(), R.drawable.families_shop_item_bg_res, null));
            }
            familiesShopItemBinding.titleShopItem.setText(item.getTitle());
            if (item.getType() == 0) {
                familiesShopItemBinding.iconCurrency.setImageResource(R.drawable.families_shop_item_star_money_icon_res);
            } else {
                familiesShopItemBinding.iconCurrency.setImageResource(R.drawable.families_raw_icon_res);
            }
            familiesShopItemBinding.valuePrice.setText(new Useful().getPriceWithDotForInt(item.getPrice()));
            if (item.getTypeId() == 3) {
                familiesShopItemBinding.familyShopItemsIcon.setImageResource(R.drawable.tuning_icon_box);
            } else if (item.getThisRender() == null) {
                if (item.getObjectId() == 7378) {
                    FamilyUseful familyUseful = familyShopAdapter.familyUseful;
                    int id = item.getId();
                    int objectId = item.getObjectId();
                    ImageView familyShopItemsIcon = familiesShopItemBinding.familyShopItemsIcon;
                    Intrinsics.checkNotNullExpressionValue(familyShopItemsIcon, "familyShopItemsIcon");
                    familyUseful.renderShopItem(id, objectId, familyShopItemsIcon, item, 90.0f, 270.0f, 0.0f);
                } else {
                    FamilyUseful familyUseful2 = familyShopAdapter.familyUseful;
                    int id2 = item.getId();
                    int objectId2 = item.getObjectId();
                    ImageView familyShopItemsIcon2 = familiesShopItemBinding.familyShopItemsIcon;
                    Intrinsics.checkNotNullExpressionValue(familyShopItemsIcon2, "familyShopItemsIcon");
                    familyUseful2.renderShopItem(id2, objectId2, familyShopItemsIcon2, item, 20.0f, 180.0f, 0.0f);
                }
            } else {
                familiesShopItemBinding.familyShopItemsIcon.setImageBitmap(item.getThisRender());
            }
            familiesShopItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyShopAdapter.ViewHolder.m79bind$lambda1$lambda0(Function2.this, item, this, view);
                }
            });
        }

        public static final void m79bind$lambda1$lambda0(Function2 onClickItemInShopList, FamilySystemShopObj item, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(onClickItemInShopList, "$onClickItemInShopList");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            onClickItemInShopList.invoke(item, Integer.valueOf(this$0.getAdapterPosition()));
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.listShopItems.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.listShopItems.get(i2).isClicked() && i2 != i) {
                this.listShopItems.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
