package com.rockstargames.gtacr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.adapters.PlayersListAdapter;
import com.rockstargames.gtacr.data.PlayersData;
import java.util.ArrayList;
import java.util.List;

public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.PlayersListHolder> implements Filterable {
    private OnClickListenerPlayersList clickListenerPlayersList;
    private Context context;
    private List<PlayersData> lPlayersData;
    private List<PlayersData> lPlayersDataCopy;

    public interface OnClickListenerPlayersList {
        void click(PlayersData playersData, int getPosition, View view);
    }

    public PlayersListAdapter(Context context, List<PlayersData> playersData, OnClickListenerPlayersList clickListenerPlayersList) {
        this.context = context;
        this.lPlayersData = playersData;
        this.lPlayersDataCopy = playersData;
        this.clickListenerPlayersList = clickListenerPlayersList;
    }

    @Override
    public PlayersListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlayersListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.players_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PlayersListHolder holder, int position) {
        PlayersData playersData = this.lPlayersData.get(position);
        holder.playerId.setText(String.valueOf(playersData.getId()));
        holder.playerName.setText(String.valueOf(playersData.getName()));
        holder.playerLevel.setText(playersData.getPlayerLevel() + " уровень");
        holder.playerPing.setText(playersData.getPing() + " ms");
        if (!playersData.isClickable()) {
            holder.bgItem.setBackground(ContextCompat.getDrawable(this.context, R.drawable.players_list_border_item));
        } else {
            holder.bgItem.setBackground(ContextCompat.getDrawable(this.context, R.drawable.players_list_border_item_active));
        }
    }

    @Override
    public int getItemCount() {
        return this.lPlayersData.size();
    }

    public class PlayersListHolder extends RecyclerView.ViewHolder {
        View bgItem;
        TextView playerId;
        TextView playerLevel;
        TextView playerName;
        TextView playerPing;

        public PlayersListHolder(View itemView) {
            super(itemView);
            //PlayersListAdapter.this = this$0;
            this.playerId = (TextView) itemView.findViewById(R.id.player_id);
            this.playerName = (TextView) itemView.findViewById(R.id.player_name);
            this.playerLevel = (TextView) itemView.findViewById(R.id.player_level);
            this.playerPing = (TextView) itemView.findViewById(R.id.player_ping);
            this.bgItem = itemView.findViewById(R.id.background_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    PlayersListHolder.this.lambda$new$0$PlayersListAdapter$PlayersListHolder(view);
                }
            });
        }

        public void lambda$new$0$PlayersListAdapter$PlayersListHolder(View view) {
            PlayersData playersData = (PlayersData) PlayersListAdapter.this.lPlayersData.get(getLayoutPosition());
            playersData.setClickable(true);
            PlayersListAdapter.this.notifyItemChanged(getLayoutPosition());
            PlayersListAdapter.this.clickListenerPlayersList.click(playersData, getLayoutPosition(), view);
        }
    }

    public void setOnlyItemClickable(int getPosition) {
        for (int i = 0; i < this.lPlayersData.size(); i++) {
            if (this.lPlayersData.get(i).isClickable() && i != getPosition) {
                this.lPlayersData.get(i).setClickable(false);
                notifyItemChanged(i);
            }
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                List arrayList = new ArrayList();
                if (charSequence2.isEmpty()) {
                    arrayList = PlayersListAdapter.this.lPlayersDataCopy;
                } else {
                    for (PlayersData playersData : PlayersListAdapter.this.lPlayersDataCopy) {
                        if (playersData.getName().toLowerCase().contains(charSequence2.toLowerCase())) {
                            arrayList.add(playersData);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                PlayersListAdapter.this.lPlayersData = (List) filterResults.values;
                PlayersListAdapter.this.notifyDataSetChanged();
            }
        };
    }
}
