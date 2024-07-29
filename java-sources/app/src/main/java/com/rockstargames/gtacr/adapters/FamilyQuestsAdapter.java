package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesQuestItemBinding;
import blackrussia.online.network.FamilySystemTasksObj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyQuestsAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dBW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010\u0015\u001a\u00020\r2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyQuestsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyQuestsAdapter$ViewHolder;", "familyQuests", "", "Lblackrussia/online/network/FamilySystemTasksObj;", "onClickQuestInFamilyQuestsList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "", "position", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickQuestInFamilyQuestsList;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/FamiliesQuestItemBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyQuestsAdapter extends RecyclerView.Adapter<FamilyQuestsAdapter.ViewHolder> {
    private FamiliesQuestItemBinding binding;
    private final NvEventQueueActivity context;
    private final List<FamilySystemTasksObj> familyQuests;
    private final Function2<FamilySystemTasksObj, Integer, Unit> onClickQuestInFamilyQuestsList;

    public FamilyQuestsAdapter(List<FamilySystemTasksObj> familyQuests, Function2<? super FamilySystemTasksObj, ? super Integer, Unit> onClickQuestInFamilyQuestsList, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(familyQuests, "familyQuests");
        Intrinsics.checkNotNullParameter(onClickQuestInFamilyQuestsList, "onClickQuestInFamilyQuestsList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.familyQuests = familyQuests;
        this.onClickQuestInFamilyQuestsList = (Function2<FamilySystemTasksObj, Integer, Unit>) onClickQuestInFamilyQuestsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesQuestItemBinding inflate = FamiliesQuestItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.familyQuests.get(i), this.onClickQuestInFamilyQuestsList);
    }

    @Override
    public int getItemCount() {
        return this.familyQuests.size();
    }

    //@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyQuestsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesQuestItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyQuestsAdapter;Lblackrussia/online/databinding/FamiliesQuestItemBinding;)V", "bind", "", "thisQuest", "Lblackrussia/online/network/FamilySystemTasksObj;", "onClickQuestInFamilyQuestsList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "", "position", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickQuestInFamilyQuestsList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesQuestItemBinding binding;
        final FamilyQuestsAdapter this$0;

        public ViewHolder(FamilyQuestsAdapter this$0, FamiliesQuestItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilySystemTasksObj thisQuest, final Function2<? super FamilySystemTasksObj, ? super Integer, Unit> onClickQuestInFamilyQuestsList) {
            Intrinsics.checkNotNullParameter(thisQuest, "thisQuest");
            Intrinsics.checkNotNullParameter(onClickQuestInFamilyQuestsList, "onClickQuestInFamilyQuestsList");
            FamiliesQuestItemBinding familiesQuestItemBinding = this.binding;
            FamilyQuestsAdapter familyQuestsAdapter = this.this$0;
            if (thisQuest.isClicked()) {
                familiesQuestItemBinding.getRoot().setBackground(ResourcesCompat.getDrawable(familyQuestsAdapter.context.getResources(), R.drawable.families_quest_if_clicked_bg, null));
            } else {
                familiesQuestItemBinding.getRoot().setBackground(ResourcesCompat.getDrawable(familyQuestsAdapter.context.getResources(), R.drawable.entertainment_system_players_item_bg, null));
            }
            familiesQuestItemBinding.questionsTitle.setText(thisQuest.getTitle());
            if (thisQuest.getScoreReward() >= 0) {
                familiesQuestItemBinding.present2Item.setImageResource(R.drawable.families_shop_item_gold_up_icon_res);
            } else {
                familiesQuestItemBinding.present2Item.setImageResource(R.drawable.families_shop_item_gold_down_icon_res);
            }
            familiesQuestItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyQuestsAdapter.ViewHolder.m77bind$lambda1$lambda0(Function2.this, thisQuest, this, view);
                }
            });
        }

        public static final void m77bind$lambda1$lambda0(Function2 onClickQuestInFamilyQuestsList, FamilySystemTasksObj thisQuest, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(onClickQuestInFamilyQuestsList, "$onClickQuestInFamilyQuestsList");
            Intrinsics.checkNotNullParameter(thisQuest, "$thisQuest");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            onClickQuestInFamilyQuestsList.invoke(thisQuest, Integer.valueOf(this$0.getLayoutPosition()));
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.familyQuests.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.familyQuests.get(i2).isClicked() && i2 != i) {
                this.familyQuests.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
