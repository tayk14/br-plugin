package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsControlStaffListItemBinding;
import blackrussia.online.network.fraction.data.FractionControlListOfPlayers;
import com.bumptech.glide.Glide;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.adapters.FractionsControlStaffListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u001c\u0010\u0019\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0007R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsControlStaffListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FractionsControlStaffListAdapter$FractionsControlStaffListViewHolder;", "list", "", "Lblackrussia/online/network/fraction/data/FractionControlListOfPlayers;", "listOfImages", "", "(Ljava/util/List;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "onPlayerItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "position", "", "getOnPlayerItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnPlayerItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyForOneItem", "checkedPosition", "FractionsControlStaffListViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsControlStaffListAdapter extends RecyclerView.Adapter<FractionsControlStaffListAdapter.FractionsControlStaffListViewHolder> {
    private List<FractionControlListOfPlayers> list;
    private final List<Integer> listOfImages;
    public Function2<? super FractionControlListOfPlayers, ? super Integer, Unit> onPlayerItemClickListener;

    public final List<FractionControlListOfPlayers> getList() {
        return this.list;
    }

    public final void setList(List<FractionControlListOfPlayers> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }

    public FractionsControlStaffListAdapter(List<FractionControlListOfPlayers> list, List<Integer> listOfImages) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listOfImages, "listOfImages");
        this.list = list;
        this.listOfImages = listOfImages;
    }

    public final Function2<FractionControlListOfPlayers, Integer, Unit> getOnPlayerItemClickListener() {
        Function2 function2 = this.onPlayerItemClickListener;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onPlayerItemClickListener");
        return null;
    }

    public final void setOnPlayerItemClickListener(Function2<? super FractionControlListOfPlayers, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onPlayerItemClickListener = function2;
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsControlStaffListAdapter$FractionsControlStaffListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FractionsControlStaffListItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FractionsControlStaffListAdapter;Lblackrussia/online/databinding/FractionsControlStaffListItemBinding;)V", "getBinding", "()Lblackrussia/online/databinding/FractionsControlStaffListItemBinding;", "bind", "", "item", "Lblackrussia/online/network/fraction/data/FractionControlListOfPlayers;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FractionsControlStaffListViewHolder extends RecyclerView.ViewHolder {
        private final FractionsControlStaffListItemBinding binding;
        final FractionsControlStaffListAdapter this$0;

        public FractionsControlStaffListViewHolder(FractionsControlStaffListAdapter this$0, FractionsControlStaffListItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final FractionsControlStaffListItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(final FractionControlListOfPlayers item) {
            Intrinsics.checkNotNullParameter(item, "item");
            FractionsControlStaffListItemBinding fractionsControlStaffListItemBinding = this.binding;
            final FractionsControlStaffListAdapter fractionsControlStaffListAdapter = this.this$0;
            fractionsControlStaffListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FractionsControlStaffListAdapter.FractionsControlStaffListViewHolder.m90bind$lambda1$lambda0(FractionsControlStaffListAdapter.this, item, this, view);
                }
            });
            if (item.isClicked()) {
                fractionsControlStaffListItemBinding.getRoot().setBackground(ResourcesCompat.getDrawable(fractionsControlStaffListItemBinding.getRoot().getContext().getResources(), R.drawable.fractions_quest_clicked_bg, null));
            } else {
                fractionsControlStaffListItemBinding.getRoot().setBackground(ResourcesCompat.getDrawable(fractionsControlStaffListItemBinding.getRoot().getContext().getResources(), R.drawable.entertainment_system_players_item_bg, null));
            }
            int rank = item.getRank();
            if ((1 <= rank && rank < 11) && (!fractionsControlStaffListAdapter.listOfImages.isEmpty())) {
                Glide.with(fractionsControlStaffListItemBinding.imageViewStaffRank).load((Integer) fractionsControlStaffListAdapter.listOfImages.get(item.getRank() - 1)).into(fractionsControlStaffListItemBinding.imageViewStaffRank);
            }
            fractionsControlStaffListItemBinding.textViewRank.setText(String.valueOf(item.getRank()));
            fractionsControlStaffListItemBinding.textViewNickname.setText(item.getNickname());
            if (item.getRank() == 10) {
                fractionsControlStaffListItemBinding.progressBarRankExperience.setVisibility(4);
                fractionsControlStaffListItemBinding.imageViewTopRank.setVisibility(0);
            } else {
                fractionsControlStaffListItemBinding.progressBarRankExperience.setVisibility(0);
                fractionsControlStaffListItemBinding.progressBarRankExperience.setProgress(item.getRank() * 10);
                fractionsControlStaffListItemBinding.imageViewTopRank.setVisibility(4);
            }
            if (item.getOnline() == 1) {
                fractionsControlStaffListItemBinding.imageViewOnline.setImageResource(R.drawable.fractions_control_list_of_staff_online_circle_shape);
            } else {
                fractionsControlStaffListItemBinding.imageViewOnline.setImageResource(R.drawable.fractions_control_list_of_staff_offline_circle_shape);
            }
        }

        public static final void m90bind$lambda1$lambda0(FractionsControlStaffListAdapter this$0, FractionControlListOfPlayers item, FractionsControlStaffListViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getOnPlayerItemClickListener().invoke(item, Integer.valueOf(this$1.getAdapterPosition()));
        }
    }

    public final void setCheckOnlyForOneItem(int i) {
        int size = this.list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.list.get(i2).isClicked() && i2 != i) {
                this.list.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    @Override
    public FractionsControlStaffListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FractionsControlStaffListItemBinding inflate = FractionsControlStaffListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new FractionsControlStaffListViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(FractionsControlStaffListViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.list.get(i));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
