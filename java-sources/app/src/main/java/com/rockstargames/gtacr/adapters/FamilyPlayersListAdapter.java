package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesPlayersItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyPlayersListAdapter;
import com.rockstargames.gtacr.data.FamilyPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001#B[\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012>\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\u0004\u0018\u0001`\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u001c\u0010\u001b\u001a\u00020\u000e2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fH\u0016J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017RF\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\u0004\u0018\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyPlayersListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyPlayersListAdapter$ViewHolder;", "Landroid/widget/Filterable;", "playersList", "", "Lcom/rockstargames/gtacr/data/FamilyPlayer;", "playerClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickPlayerList;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/FamiliesPlayersItemBinding;", "copyList", "getCopyList", "()Ljava/util/List;", "getFilter", "Landroid/widget/Filter;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyPlayersListAdapter extends RecyclerView.Adapter<FamilyPlayersListAdapter.ViewHolder> implements Filterable {
    private FamiliesPlayersItemBinding binding;
    private final NvEventQueueActivity context;
    private final List<FamilyPlayer> copyList;
    private final Function2<FamilyPlayer, Integer, Unit> playerClick;
    private final List<FamilyPlayer> playersList;

    public FamilyPlayersListAdapter(List<FamilyPlayer> playersList, Function2<? super FamilyPlayer, ? super Integer, Unit> function2, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(playersList, "playersList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.playersList = playersList;
        this.playerClick = (Function2<FamilyPlayer, Integer, Unit>) function2;
        this.context = context;
        this.copyList = new ArrayList();
    }

    public final List<FamilyPlayer> getCopyList() {
        return this.copyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesPlayersItemBinding inflate = FamiliesPlayersItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.playersList.get(i), this.playerClick);
    }

    @Override
    public int getItemCount() {
        return this.playersList.size();
    }

    //@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2>\u0010\t\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyPlayersListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesPlayersItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyPlayersListAdapter;Lblackrussia/online/databinding/FamiliesPlayersItemBinding;)V", "bind", "", "player", "Lcom/rockstargames/gtacr/data/FamilyPlayer;", "playerClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickPlayerList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesPlayersItemBinding binding;
        final FamilyPlayersListAdapter this$0;

        public ViewHolder(FamilyPlayersListAdapter this$0, FamiliesPlayersItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilyPlayer player, final Function2<? super FamilyPlayer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(player, "player");
            FamiliesPlayersItemBinding familiesPlayersItemBinding = this.binding;
            FamilyPlayersListAdapter familyPlayersListAdapter = this.this$0;
            familiesPlayersItemBinding.playersRank.setText(String.valueOf(player.getPlayersRank()));
            familiesPlayersItemBinding.playersNick.setText(player.getPlayersNick());
            familiesPlayersItemBinding.playersNick.setSelected(true);
            if (player.getPlayersStatus() == 1) {
                familiesPlayersItemBinding.playersStatus.setBackground(ContextCompat.getDrawable(familyPlayersListAdapter.context, R.drawable.families_bg_player_active));
            } else {
                familiesPlayersItemBinding.playersStatus.setBackground(ContextCompat.getDrawable(familyPlayersListAdapter.context, R.drawable.families_bg_player_not_active));
            }
            if (player.isClicked()) {
                familiesPlayersItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyPlayersListAdapter.context, R.drawable.families_quest_if_clicked_bg));
            } else {
                familiesPlayersItemBinding.getRoot().setBackground(ContextCompat.getDrawable(familyPlayersListAdapter.context, R.drawable.entertainment_system_players_item_bg));
            }
            familiesPlayersItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyPlayersListAdapter.ViewHolder.m76bind$lambda1$lambda0(Function2.this, player, this, view);
                }
            });
        }

        public static final void m76bind$lambda1$lambda0(Function2 function2, FamilyPlayer player, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(player, "$player");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (function2 == null) {
                return;
            }
            function2.invoke(player, Integer.valueOf(this$0.getLayoutPosition()));
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.playersList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.playersList.get(i2).isClicked() && i2 != i) {
                this.playersList.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            /*@Override
            protected android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r10) {
                java.lang.String r10;
                java.lang.String r10;
                java.util.ArrayList r0 = new java.util.ArrayList();
                if (r10 != null && (r10 = r10.toString()) != null) {
                    java.lang.String r10 = r10.toLowerCase(java.util.Locale.ROOT);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (r10 != null) {
                        java.lang.String r10 = r10;
                        int r3 = r10.length() - 1;
                        int r5 = 0;
                        boolean r6 = false;
                        while (r5 <= r3) {
                            boolean r7 = kotlin.jvm.internal.Intrinsics.compare((int) r10.charAt(!r6 ? r5 : r3), 32) <= 0;
                            if (r6) {
                                if (!r7) {
                                    break;
                                }
                                r3--;
                            } else if (r7) {
                                r5++;
                            } else {
                                r6 = true;
                            }
                        }
                        r10 = r10.subSequence(r5, r3 + 1).toString();
                        for (com.rockstargames.gtacr.data.FamilyPlayer r4 : com.rockstargames.gtacr.adapters.FamilyPlayersListAdapter.this.getCopyList()) {
                            if (r10 != null) {
                                java.lang.String r5 = r4.getPlayersNick();
                                java.util.Locale r6 = java.util.Locale.ROOT;
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "ROOT");
                                java.lang.String r5 = r5.toLowerCase(r6);
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).toLowerCase(locale)");
                                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r10, false, 2, (java.lang.Object) null)) {
                                    r0.add(r4);
                                }
                            }
                        }
                        android.widget.Filter.FilterResults r10 = new android.widget.Filter.FilterResults();
                        r10.values = r0;
                        return r10;
                    }
                }
                r10 = null;
                while (r3.hasNext()) {
                }
                android.widget.Filter.FilterResults r10 = new android.widget.Filter.FilterResults();
                r10.values = r0;
                return r10;
            }*/

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                List list;
                List list2;
                list = FamilyPlayersListAdapter.this.playersList;
                list.clear();
                list2 = FamilyPlayersListAdapter.this.playersList;
                Object obj = filterResults == null ? null : filterResults.values;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.Collection<com.rockstargames.gtacr.data.FamilyPlayer>");
                list2.addAll((Collection) obj);
                FamilyPlayersListAdapter.this.notifyDataSetChanged();
            }
        };
    }
}
