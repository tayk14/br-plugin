package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsQuestsItemBinding;
import blackrussia.online.network.fraction.data.FractionQuestsItem;
import com.bumptech.glide.Glide;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.adapters.FractionsQuestsAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\f2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsQuestsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FractionsQuestsAdapter$FractionsQuestsViewHolder;", "fractionsQuests", "", "Lblackrussia/online/network/fraction/data/FractionQuestsItem;", "(Ljava/util/List;)V", "onQuestItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "", "getOnQuestItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnQuestItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedItemPosition", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FractionsQuestsViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsQuestsAdapter extends RecyclerView.Adapter<FractionsQuestsAdapter.FractionsQuestsViewHolder> {
    private final List<FractionQuestsItem> fractionsQuests;
    public Function1<? super FractionQuestsItem, Unit> onQuestItemClickListener;
    private int selectedItemPosition;

    public FractionsQuestsAdapter(List<FractionQuestsItem> fractionsQuests) {
        Intrinsics.checkNotNullParameter(fractionsQuests, "fractionsQuests");
        this.fractionsQuests = fractionsQuests;
        Iterator<FractionQuestsItem> it = fractionsQuests.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().isClicked()) {
                break;
            } else {
                i++;
            }
        }
        this.selectedItemPosition = i;
    }

    public final Function1<FractionQuestsItem, Unit> getOnQuestItemClickListener() {
        Function1 function1 = this.onQuestItemClickListener;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onQuestItemClickListener");
        return null;
    }

    public final void setOnQuestItemClickListener(Function1<? super FractionQuestsItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onQuestItemClickListener = function1;
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsQuestsAdapter$FractionsQuestsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FractionsQuestsItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FractionsQuestsAdapter;Lblackrussia/online/databinding/FractionsQuestsItemBinding;)V", "bind", "", "quest", "Lblackrussia/online/network/fraction/data/FractionQuestsItem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FractionsQuestsViewHolder extends RecyclerView.ViewHolder {
        private final FractionsQuestsItemBinding binding;
        final FractionsQuestsAdapter this$0;

        public FractionsQuestsViewHolder(FractionsQuestsAdapter this$0, FractionsQuestsItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FractionQuestsItem quest) {
            Intrinsics.checkNotNullParameter(quest, "quest");
            FractionsQuestsItemBinding fractionsQuestsItemBinding = this.binding;
            final FractionsQuestsAdapter fractionsQuestsAdapter = this.this$0;
            fractionsQuestsItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FractionsQuestsAdapter.FractionsQuestsViewHolder.m94bind$lambda2$lambda0(FractionsQuestsAdapter.this, this, quest, view);
                }
            });
            TextView textView = fractionsQuestsItemBinding.questTitle;
            textView.setText(quest.getTitle());
            textView.setSelected(true);
            if (quest.getMoneyReward() == 0) {
                fractionsQuestsItemBinding.ivAward1.setVisibility(4);
            } else {
                fractionsQuestsItemBinding.ivAward1.setVisibility(0);
            }
            if (quest.getScoreReward() >= 0) {
                Glide.with(fractionsQuestsItemBinding.ivAward2).load(Integer.valueOf((int) R.drawable.fractions_shop_item_gold_up_icon_res)).into(fractionsQuestsItemBinding.ivAward2);
            } else {
                Glide.with(fractionsQuestsItemBinding.ivAward2).load(Integer.valueOf((int) R.drawable.fractions_shop_item_gold_down_icon_res)).into(fractionsQuestsItemBinding.ivAward2);
            }
        }

        public static final void m94bind$lambda2$lambda0(FractionsQuestsAdapter this$0, FractionsQuestsViewHolder this$1, FractionQuestsItem quest, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(quest, "$quest");
            if (this$0.selectedItemPosition != this$1.getAdapterPosition()) {
                this$0.notifyItemChanged(this$0.selectedItemPosition);
                ((FractionQuestsItem) this$0.fractionsQuests.get(this$0.selectedItemPosition)).setClicked(false);
                this$0.selectedItemPosition = this$1.getAdapterPosition();
                quest.setClicked(true);
                this$0.notifyItemChanged(this$1.getAdapterPosition());
                this$0.getOnQuestItemClickListener().invoke(quest);
            }
        }
    }

    @Override
    public FractionsQuestsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FractionsQuestsItemBinding inflate = FractionsQuestsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…, parent, false\n        )");
        return new FractionsQuestsViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(FractionsQuestsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.fractionsQuests.get(i));
        if (this.fractionsQuests.get(i).isClicked()) {
            holder.itemView.isSelected();
            holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.fractions_quest_clicked_bg));
        } else if (this.fractionsQuests.get(i).getScoreReward() >= 0) {
            holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.fractions_quests_background_item_positive_score));
        } else {
            holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.fractions_quests_background_item_negative_score));
        }
    }

    @Override
    public int getItemCount() {
        return this.fractionsQuests.size();
    }
}
