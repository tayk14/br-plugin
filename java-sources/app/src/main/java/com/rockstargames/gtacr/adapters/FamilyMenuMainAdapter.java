package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMenuMainItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyMenuMainAdapter;
import com.rockstargames.gtacr.data.FamilyMainItemData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!Bp\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012S\u0010\u0006\u001aO\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u001c\u0010\u0019\u001a\u00020\u000f2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000bR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R[\u0010\u0006\u001aO\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter$ViewHolder;", "menuList", "", "Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "onClickMenuMainList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "Landroid/view/View;", "mView", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuMainList;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMenuMainItemBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyMenuMainAdapter extends RecyclerView.Adapter<FamilyMenuMainAdapter.ViewHolder> {
    private Animation anim;
    private FamiliesMenuMainItemBinding binding;
    private final NvEventQueueActivity context;
    private final List<FamilyMainItemData> menuList;
    private final Function3<FamilyMainItemData, Integer, View, Unit> onClickMenuMainList;

    public FamilyMenuMainAdapter(List<FamilyMainItemData> menuList, Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> function3, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.menuList = menuList;
        this.onClickMenuMainList = (Function3<FamilyMainItemData, Integer, View, Unit>) function3;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesMenuMainItemBinding inflate = FamiliesMenuMainItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        FamiliesMenuMainItemBinding familiesMenuMainItemBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        FamiliesMenuMainItemBinding familiesMenuMainItemBinding2 = this.binding;
        if (familiesMenuMainItemBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuMainItemBinding = familiesMenuMainItemBinding2;
        }
        return new ViewHolder(this, familiesMenuMainItemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.menuList.get(i), this.onClickMenuMainList);
    }

    @Override
    public int getItemCount() {
        return this.menuList.size();
    }

    //@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Jc\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2S\u0010\t\u001aO\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesMenuMainItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter;Lblackrussia/online/databinding/FamiliesMenuMainItemBinding;)V", "bind", "", "menuItem", "Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "onClickMenuMainList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "Landroid/view/View;", "mView", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuMainList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesMenuMainItemBinding binding;
        final FamilyMenuMainAdapter this$0;

        public ViewHolder(FamilyMenuMainAdapter this$0, FamiliesMenuMainItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilyMainItemData menuItem, final Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> function3) {
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            FamiliesMenuMainItemBinding familiesMenuMainItemBinding = this.binding;
            FamilyMenuMainAdapter familyMenuMainAdapter = this.this$0;
            familiesMenuMainItemBinding.menuValue.setText(menuItem.getItemsTitle());
            familiesMenuMainItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyMenuMainAdapter.ViewHolder.m68bind$lambda1$lambda0(Function3.this, menuItem, this, view);
                }
            });
            if (menuItem.isClicked()) {
                familiesMenuMainItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyMenuMainAdapter.context, R.drawable.families_quest_if_clicked_bg));
            } else {
                familiesMenuMainItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyMenuMainAdapter.context, R.drawable.entertainment_system_players_item_bg));
            }
        }

        public static final void m68bind$lambda1$lambda0(Function3 function3, FamilyMainItemData menuItem, ViewHolder this$0, View it) {
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (function3 == null) {
                return;
            }
            Integer valueOf = Integer.valueOf(this$0.getAdapterPosition());
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function3.invoke(menuItem, valueOf, it);
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.menuList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.menuList.get(i2).isClicked() && i2 != i) {
                this.menuList.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
