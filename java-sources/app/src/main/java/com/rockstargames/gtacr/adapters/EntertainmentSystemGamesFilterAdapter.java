package com.rockstargames.gtacr.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemGamesFilterItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.EntertainmentSystemGamesFilterAdapter;
import com.rockstargames.gtacr.data.EntertainmentGamesFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB[\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012>\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010\u0015\u001a\u00020\r2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/adapters/EntertainmentSystemGamesFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemGamesFilterAdapter$ViewHolder;", "gamesList", "", "Lcom/rockstargames/gtacr/data/EntertainmentGamesFilter;", "entertainmentFilterClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "game", "", "position", "", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentFilterClickListener;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/EntertainmentSystemGamesFilterItemBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EntertainmentSystemGamesFilterAdapter extends RecyclerView.Adapter<EntertainmentSystemGamesFilterAdapter.ViewHolder> {
    private EntertainmentSystemGamesFilterItemBinding binding;
    private final NvEventQueueActivity context;
    private final Function2<EntertainmentGamesFilter, Integer, Unit> entertainmentFilterClickListener;
    private final List<EntertainmentGamesFilter> gamesList;

    public EntertainmentSystemGamesFilterAdapter(List<EntertainmentGamesFilter> gamesList, Function2<? super EntertainmentGamesFilter, ? super Integer, Unit> function2, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(gamesList, "gamesList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.gamesList = gamesList;
        this.entertainmentFilterClickListener = (Function2<EntertainmentGamesFilter, Integer, Unit>) function2;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        EntertainmentSystemGamesFilterItemBinding inflate = EntertainmentSystemGamesFilterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.gamesList.get(i), this.entertainmentFilterClickListener);
    }

    @Override
    public int getItemCount() {
        return this.gamesList.size();
    }

    //@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2>\u0010\t\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/adapters/EntertainmentSystemGamesFilterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemGamesFilterItemBinding;", "(Lcom/rockstargames/gtacr/adapters/EntertainmentSystemGamesFilterAdapter;Lblackrussia/online/databinding/EntertainmentSystemGamesFilterItemBinding;)V", "bind", "", "game", "Lcom/rockstargames/gtacr/data/EntertainmentGamesFilter;", "entertainmentFilterClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "position", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentFilterClickListener;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final EntertainmentSystemGamesFilterItemBinding binding;
        final EntertainmentSystemGamesFilterAdapter this$0;

        public ViewHolder(EntertainmentSystemGamesFilterAdapter this$0, EntertainmentSystemGamesFilterItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final EntertainmentGamesFilter game, final Function2<? super EntertainmentGamesFilter, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(game, "game");
            this.binding.gameItemFilter.setText(game.getName());
            if (game.isClicked()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.binding.getRoot().setBackgroundColor(this.this$0.context.getResources().getColor(R.color.blue_not_active_switch, null));
                } else {
                    this.binding.getRoot().setBackgroundColor(this.this$0.context.getResources().getColor(R.color.blue_not_active_switch));
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.binding.getRoot().setBackgroundColor(this.this$0.context.getResources().getColor(R.color.inv_full_transparency, null));
            } else {
                this.binding.getRoot().setBackgroundColor(this.this$0.context.getResources().getColor(R.color.inv_full_transparency));
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //EntertainmentSystemGamesFilterAdapter.ViewHolder.m58bind$lambda0(function2, game, this$0, view);
                }
            });
        }

        public static final void m58bind$lambda0(Function2 function2, EntertainmentGamesFilter game, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(game, "$game");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (function2 == null) {
                return;
            }
            function2.invoke(game, Integer.valueOf(this$0.getLayoutPosition()));
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.gamesList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.gamesList.get(i2).isClicked() && i2 != i) {
                this.gamesList.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
