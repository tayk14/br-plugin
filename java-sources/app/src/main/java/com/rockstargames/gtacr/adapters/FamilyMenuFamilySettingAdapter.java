package com.rockstargames.gtacr.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMenuRankOrColorItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyMenuFamilySettingAdapter;
import com.rockstargames.gtacr.data.FamilyRankOrColorData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"Bl\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012O\u0010\b\u001aK\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u0002`\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0018\u001a\u00020\u00102\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\rR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RW\u0010\b\u001aK\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u0002`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyMenuFamilySettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyMenuFamilySettingAdapter$ViewHolder;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "parameters", "", "Lcom/rockstargames/gtacr/data/FamilyRankOrColorData;", "onClickMenuFamilyList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "clicksType", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuFamilyList;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "binding", "Lblackrussia/online/databinding/FamiliesMenuRankOrColorItemBinding;", "getItemCount", "getItemId", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "setOnlyStartColor", "newPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyMenuFamilySettingAdapter extends RecyclerView.Adapter<FamilyMenuFamilySettingAdapter.ViewHolder> {
    private FamiliesMenuRankOrColorItemBinding binding;
    private final NvEventQueueActivity context;
    private final Function3<FamilyRankOrColorData, Integer, Integer, Unit> onClickMenuFamilyList;
    private final List<FamilyRankOrColorData> parameters;

    @Override
    public long getItemId(int i) {
        return i;
    }

    public FamilyMenuFamilySettingAdapter(NvEventQueueActivity context, List<FamilyRankOrColorData> parameters, Function3<? super FamilyRankOrColorData, ? super Integer, ? super Integer, Unit> onClickMenuFamilyList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(onClickMenuFamilyList, "onClickMenuFamilyList");
        this.context = context;
        this.parameters = parameters;
        this.onClickMenuFamilyList = (Function3<FamilyRankOrColorData, Integer, Integer, Unit>) onClickMenuFamilyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesMenuRankOrColorItemBinding inflate = FamiliesMenuRankOrColorItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.parameters.get(i), this.onClickMenuFamilyList);
    }

    @Override
    public int getItemCount() {
        return this.parameters.size();
    }

    //@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J_\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2O\u0010\t\u001aK\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyMenuFamilySettingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesMenuRankOrColorItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyMenuFamilySettingAdapter;Lblackrussia/online/databinding/FamiliesMenuRankOrColorItemBinding;)V", "bind", "", "thisItem", "Lcom/rockstargames/gtacr/data/FamilyRankOrColorData;", "onClickMenuFamilyList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "clicksType", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuFamilyList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesMenuRankOrColorItemBinding binding;
        final FamilyMenuFamilySettingAdapter this$0;

        public static final void m60bind$lambda8$lambda1(View view) {
        }

        public static final void m62bind$lambda8$lambda4(View view) {
        }

        public ViewHolder(FamilyMenuFamilySettingAdapter this$0, FamiliesMenuRankOrColorItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilyRankOrColorData thisItem, final Function3<? super FamilyRankOrColorData, ? super Integer, ? super Integer, Unit> onClickMenuFamilyList) {
            Intrinsics.checkNotNullParameter(thisItem, "thisItem");
            Intrinsics.checkNotNullParameter(onClickMenuFamilyList, "onClickMenuFamilyList");
            FamiliesMenuRankOrColorItemBinding familiesMenuRankOrColorItemBinding = this.binding;
            FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter = this.this$0;
            int statusType = thisItem.getStatusType();
            if (statusType == 0) {
                familiesMenuRankOrColorItemBinding.valueMenu1.setVisibility(8);
                familiesMenuRankOrColorItemBinding.rankAccessSwitch.setVisibility(8);
                familiesMenuRankOrColorItemBinding.color.setVisibility(8);
                familiesMenuRankOrColorItemBinding.colorsBorder.setVisibility(8);
                familiesMenuRankOrColorItemBinding.ifCurrentColor.setVisibility(8);
                familiesMenuRankOrColorItemBinding.renameRank.setVisibility(0);
                familiesMenuRankOrColorItemBinding.valueMenu2.setText(thisItem.getStatusName());
                familiesMenuRankOrColorItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyMenuFamilySettingAdapter.context, R.drawable.entertainment_system_players_item_bg));
                familiesMenuRankOrColorItemBinding.renameRank.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        //FamilyMenuFamilySettingAdapter.ViewHolder.m59bind$lambda8$lambda0(onClickMenuFamilyList, thisItem, this$0, view);
                    }
                });
                familiesMenuRankOrColorItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        ViewHolder.m60bind$lambda8$lambda1(view);
                    }
                });
            } else if (statusType == 1) {
                familiesMenuRankOrColorItemBinding.color.setVisibility(8);
                familiesMenuRankOrColorItemBinding.colorsBorder.setVisibility(8);
                familiesMenuRankOrColorItemBinding.ifCurrentColor.setVisibility(8);
                familiesMenuRankOrColorItemBinding.renameRank.setVisibility(8);
                familiesMenuRankOrColorItemBinding.valueMenu1.setVisibility(0);
                familiesMenuRankOrColorItemBinding.rankAccessSwitch.setVisibility(0);
                String statusName = thisItem.getStatusName();
                familiesMenuRankOrColorItemBinding.valueMenu1.setText(Intrinsics.areEqual(statusName, "складу") ? "true" : Intrinsics.areEqual(statusName, "сейфу") ? "Доступ к" : "Возможность");
                familiesMenuRankOrColorItemBinding.valueMenu2.setText(thisItem.getStatusName());
                familiesMenuRankOrColorItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyMenuFamilySettingAdapter.context, R.drawable.entertainment_system_players_item_bg));
                Integer currentStatus = thisItem.getCurrentStatus();
                if (currentStatus != null) {
                    int intValue = currentStatus.intValue();
                    if (intValue == 0) {
                        familiesMenuRankOrColorItemBinding.rankAccessSwitch.setChecked(false);
                    } else if (intValue == 1) {
                        familiesMenuRankOrColorItemBinding.rankAccessSwitch.setChecked(true);
                    }
                }
                familiesMenuRankOrColorItemBinding.rankAccessSwitch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        //FamilyMenuFamilySettingAdapter.ViewHolder.m61bind$lambda8$lambda3(Function3.this, thisItem, this, view);
                    }
                });
                familiesMenuRankOrColorItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        ViewHolder.m62bind$lambda8$lambda4(view);
                    }
                });
            } else if (statusType != 2) {
            } else {
                familiesMenuRankOrColorItemBinding.valueMenu1.setVisibility(8);
                familiesMenuRankOrColorItemBinding.rankAccessSwitch.setVisibility(8);
                familiesMenuRankOrColorItemBinding.renameRank.setVisibility(8);
                familiesMenuRankOrColorItemBinding.color.setVisibility(0);
                familiesMenuRankOrColorItemBinding.colorsBorder.setVisibility(0);
                Boolean ifStartedColor = thisItem.getIfStartedColor();
                if (ifStartedColor != null) {
                    if (ifStartedColor.booleanValue()) {
                        familiesMenuRankOrColorItemBinding.ifCurrentColor.setVisibility(0);
                    } else {
                        familiesMenuRankOrColorItemBinding.ifCurrentColor.setVisibility(4);
                    }
                }
                String thisColor = thisItem.getThisColor();
                if (thisColor != null) {
                    familiesMenuRankOrColorItemBinding.color.setBackgroundColor(Color.parseColor(thisColor));
                }
                familiesMenuRankOrColorItemBinding.valueMenu2.setText(thisItem.getStatusName());
                if (thisItem.isClicked() == null || !Intrinsics.areEqual((Object) thisItem.isClicked(), (Object) true)) {
                    familiesMenuRankOrColorItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyMenuFamilySettingAdapter.context, R.drawable.entertainment_system_players_item_bg));
                } else {
                    familiesMenuRankOrColorItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyMenuFamilySettingAdapter.context, R.drawable.families_quest_if_clicked_bg));
                }
                familiesMenuRankOrColorItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        //FamilyMenuFamilySettingAdapter.ViewHolder.m63bind$lambda8$lambda7(Function3.this, thisItem, this, view);
                    }
                });
            }
        }

        public static final void m59bind$lambda8$lambda0(Function3 onClickMenuFamilyList, FamilyRankOrColorData thisItem, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(onClickMenuFamilyList, "$onClickMenuFamilyList");
            Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            onClickMenuFamilyList.invoke(thisItem, Integer.valueOf(this$0.getLayoutPosition()), 0);
        }

        public static final void m61bind$lambda8$lambda3(Function3 onClickMenuFamilyList, FamilyRankOrColorData thisItem, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(onClickMenuFamilyList, "$onClickMenuFamilyList");
            Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            onClickMenuFamilyList.invoke(thisItem, Integer.valueOf(this$0.getLayoutPosition()), 1);
        }

        public static final void m63bind$lambda8$lambda7(Function3 onClickMenuFamilyList, FamilyRankOrColorData thisItem, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(onClickMenuFamilyList, "$onClickMenuFamilyList");
            Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            onClickMenuFamilyList.invoke(thisItem, Integer.valueOf(this$0.getLayoutPosition()), 2);
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.parameters.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.parameters.get(i2).isClicked() != null && Intrinsics.areEqual((Object) this.parameters.get(i2).isClicked(), (Object) true) && i2 != i) {
                this.parameters.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    public final void setOnlyStartColor(int i) {
        int size = this.parameters.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.parameters.get(i2).getIfStartedColor() != null && Intrinsics.areEqual((Object) this.parameters.get(i2).getIfStartedColor(), (Object) true) && i2 != i) {
                this.parameters.get(i2).setIfStartedColor(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
