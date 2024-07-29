package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsControlSortByItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.adapters.FractionsControlSortByAdapter;
import com.rockstargames.gtacr.data.FractionsSortByItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u001c\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsControlSortByAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FractionsControlSortByAdapter$FractionsControlSortByViewHolder;", "list", "", "Lcom/rockstargames/gtacr/data/FractionsSortByItem;", "selectedItemPosition", "", "(Ljava/util/List;I)V", "onSortByItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "position", "", "getOnSortByItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnSortByItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "changeBackgroundColor", "binding", "Lblackrussia/online/databinding/FractionsControlSortByItemBinding;", "changeBackgroundColorClicked", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FractionsControlSortByViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsControlSortByAdapter extends RecyclerView.Adapter<FractionsControlSortByAdapter.FractionsControlSortByViewHolder> {
    private final List<FractionsSortByItem> list;
    public Function1<? super Integer, Unit> onSortByItemClickListener;
    private int selectedItemPosition;

    public FractionsControlSortByAdapter(List<FractionsSortByItem> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.selectedItemPosition = i;
    }

    public final Function1<Integer, Unit> getOnSortByItemClickListener() {
        Function1 function1 = this.onSortByItemClickListener;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onSortByItemClickListener");
        return null;
    }

    public final void setOnSortByItemClickListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSortByItemClickListener = function1;
    }

    //@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsControlSortByAdapter$FractionsControlSortByViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FractionsControlSortByItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FractionsControlSortByAdapter;Lblackrussia/online/databinding/FractionsControlSortByItemBinding;)V", "getBinding", "()Lblackrussia/online/databinding/FractionsControlSortByItemBinding;", "bind", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FractionsControlSortByViewHolder extends RecyclerView.ViewHolder {
        private final FractionsControlSortByItemBinding binding;
        final FractionsControlSortByAdapter this$0;

        public FractionsControlSortByViewHolder(FractionsControlSortByAdapter this$0, FractionsControlSortByItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final FractionsControlSortByItemBinding getBinding() {
            return this.binding;
        }

        public final void bind() {
            FractionsControlSortByItemBinding fractionsControlSortByItemBinding = this.binding;
            final FractionsControlSortByAdapter fractionsControlSortByAdapter = this.this$0;
            fractionsControlSortByItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FractionsControlSortByAdapter.FractionsControlSortByViewHolder.m89bind$lambda1$lambda0(FractionsControlSortByAdapter.this, this, view);
                }
            });
            if (fractionsControlSortByAdapter.selectedItemPosition == getAdapterPosition()) {
                fractionsControlSortByAdapter.changeBackgroundColorClicked(getBinding(), getAdapterPosition());
            } else {
                fractionsControlSortByAdapter.changeBackgroundColor(getBinding(), getAdapterPosition());
            }
            fractionsControlSortByItemBinding.textViewTitle.setText(((FractionsSortByItem) fractionsControlSortByAdapter.list.get(getAdapterPosition())).getTitle());
        }

        public static final void m89bind$lambda1$lambda0(FractionsControlSortByAdapter this$0, FractionsControlSortByViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.selectedItemPosition != this$1.getAdapterPosition()) {
                this$0.notifyItemChanged(this$0.selectedItemPosition);
                this$0.selectedItemPosition = this$1.getAdapterPosition();
                this$0.notifyItemChanged(this$0.selectedItemPosition);
                this$0.getOnSortByItemClickListener().invoke(Integer.valueOf(this$1.getAdapterPosition()));
            }
        }
    }

    public final void changeBackgroundColor(FractionsControlSortByItemBinding fractionsControlSortByItemBinding, int i) {
        if (i == 3) {
            fractionsControlSortByItemBinding.getRoot().setBackground(ContextCompat.getDrawable(fractionsControlSortByItemBinding.getRoot().getContext(), R.drawable.fractions_control_search_by_bottom_bg));
            return;
        }
        int i2 = 0;
        while (i2 < 3) {
            i2++;
            fractionsControlSortByItemBinding.getRoot().setBackgroundColor(ContextCompat.getColor(fractionsControlSortByItemBinding.getRoot().getContext(), R.color.color_444754));
        }
    }

    public final void changeBackgroundColorClicked(FractionsControlSortByItemBinding fractionsControlSortByItemBinding, int i) {
        if (i == 3) {
            fractionsControlSortByItemBinding.getRoot().setBackground(ContextCompat.getDrawable(fractionsControlSortByItemBinding.getRoot().getContext(), R.drawable.fractions_control_search_by_bottom_bg_clicked));
            return;
        }
        int i2 = 0;
        while (i2 < 3) {
            i2++;
            fractionsControlSortByItemBinding.getRoot().setBackgroundColor(ContextCompat.getColor(fractionsControlSortByItemBinding.getRoot().getContext(), R.color.blue_not_active_switch));
        }
    }

    @Override
    public FractionsControlSortByViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FractionsControlSortByItemBinding inflate = FractionsControlSortByItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …rent, false\n            )");
        return new FractionsControlSortByViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(FractionsControlSortByViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
