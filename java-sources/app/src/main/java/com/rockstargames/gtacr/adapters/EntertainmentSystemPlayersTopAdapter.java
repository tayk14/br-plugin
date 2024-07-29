package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemTopItemBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.EntertainmentPlayersData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/rockstargames/gtacr/adapters/EntertainmentSystemPlayersTopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemPlayersTopAdapter$ViewHolder;", "playersList", "", "Lcom/rockstargames/gtacr/data/EntertainmentPlayersData;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/EntertainmentSystemTopItemBinding;", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EntertainmentSystemPlayersTopAdapter extends RecyclerView.Adapter<EntertainmentSystemPlayersTopAdapter.ViewHolder> {
    private EntertainmentSystemTopItemBinding binding;
    private final NvEventQueueActivity context;
    private final List<EntertainmentPlayersData> playersList;

    @Override
    public long getItemId(int i) {
        return i;
    }

    public EntertainmentSystemPlayersTopAdapter(List<EntertainmentPlayersData> playersList, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(playersList, "playersList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.playersList = playersList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        EntertainmentSystemTopItemBinding inflate = EntertainmentSystemTopItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.playersList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.playersList.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/EntertainmentSystemPlayersTopAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemTopItemBinding;", "(Lcom/rockstargames/gtacr/adapters/EntertainmentSystemPlayersTopAdapter;Lblackrussia/online/databinding/EntertainmentSystemTopItemBinding;)V", "bind", "", "player", "Lcom/rockstargames/gtacr/data/EntertainmentPlayersData;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final EntertainmentSystemTopItemBinding binding;
        final EntertainmentSystemPlayersTopAdapter this$0;

        public ViewHolder(EntertainmentSystemPlayersTopAdapter this$0, EntertainmentSystemTopItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(EntertainmentPlayersData player) {
            Intrinsics.checkNotNullParameter(player, "player");
            EntertainmentSystemTopItemBinding entertainmentSystemTopItemBinding = this.binding;
            entertainmentSystemTopItemBinding.topPosition.setText(String.valueOf(player.getPosition()));
            entertainmentSystemTopItemBinding.playersNick.setText(player.getPlayersNick());
            entertainmentSystemTopItemBinding.playersGames.setText(player.getAllGames());
            int thisGame = player.getThisGame();
            int i = thisGame != 0 ? thisGame != 1 ? thisGame != 2 ? thisGame != 3 ? thisGame != 4 ? thisGame != 5 ? R.drawable.default_icon : R.drawable.entertainment_system_item_rice_little_res : R.drawable.entertainment_system_item_arms_battle_little_res : R.drawable.entertainment_system_item_tank_battles_little_res : R.drawable.entertainment_system_item_flatout_little_res : R.drawable.entertainment_system_item_rubilovo_little_res : R.drawable.entertainment_system_item_battleground_little_res;
            entertainmentSystemTopItemBinding.leftIcon.setImageResource(player.getLeftIcon());
            entertainmentSystemTopItemBinding.rightIcon.setImageResource(player.getRightIcon());
            entertainmentSystemTopItemBinding.gameIcon.setImageResource(i);
        }
    }
}
