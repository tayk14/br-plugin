//////////////HalloweenLobbyAdapter.this = this$0;
//////////////HalloweenLobbyAdapter.this = this$0;
package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.gui.halloween.UILayoutHalloweenLobby;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.ArrayList;
import org.json.JSONObject;

public class HalloweenLobbyAdapter extends RecyclerView.Adapter<HalloweenLobbyAdapter.ViewHolder> {
    private ArrayList<Item> items;
    private UILayoutHalloweenLobby mLayout;

    public void addPlayer(String name, int deletable) {
        this.items.add(new Item(name, deletable));
        notifyItemInserted(this.items.size() - 1);
        if (this.items.size() != 0) {
            this.mLayout.getRoot().notifyButtonPressed(this.mLayout.getButtonStart());
        }
    }

    public void removePlayer(String player) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).name.equals(player)) {
                this.items.remove(i);
                notifyItemRemoved(i);
                return;
            }
        }
        if (this.items.size() != 0) {
            this.mLayout.getRoot().notifyButtonDeactivated(this.mLayout.getButtonStart());
        }
    }

    public HalloweenLobbyAdapter(UILayoutHalloweenLobby layout) {
        this.mLayout = null;
        this.items = null;
        this.mLayout = layout;
        this.items = new ArrayList<>();
        if (this.mLayout.getRoot().getJson().optInt(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS) == 1) {
            this.items.add(new Item("Ожидайте начала игры ...", 1));
        } else {
            this.items.add(new Item("Удалить лобби", 0));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.halloween_lobby_player_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (position == 0) {
            holder.name.setTypeface(ResourcesCompat.getFont(this.mLayout.getContext(), R.font.montserrat_bold));
            holder.name.setText(this.items.get(position).name);
            holder.button.setBackground(ResourcesCompat.getDrawable(this.mLayout.getContext().getResources(), R.drawable.minus_orange, null));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HalloweenLobbyAdapter.this.mLayout.getRoot().showPopup("Удаление лобби", "Вы действительно желаете удалить лобби?", "Да", null, new View.OnClickListener() {
                        @Override
                        public void onClick(View view2) {
                            HalloweenLobbyAdapter.this.mLayout.getRoot().close(null);
                        }
                    });
                }
            });
            if (this.items.get(position).deletable == 1) {
                holder.button.setVisibility(8);
                return;
            }
            return;
        }
        holder.name.setTypeface(ResourcesCompat.getFont(this.mLayout.getContext(), R.font.montserrat_regular));
        holder.name.setText(this.items.get(position).name);
        if (this.items.get(position).deletable == 1) {
            holder.button.setBackground(ResourcesCompat.getDrawable(this.mLayout.getContext().getResources(), R.drawable.icon_delete, null));
            holder.button.setVisibility(0);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HalloweenLobbyAdapter.this.mLayout.getRoot().showPopup("Исключение", "Вы действительно желаете кикнуть данного игрока?", "Да", null, new View.OnClickListener() {
                        @Override
                        public void onClick(View view2) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("n", ((Item) HalloweenLobbyAdapter.this.items.get(position)).name);
                                HalloweenLobbyAdapter.this.mLayout.getRoot().getGUIManager().sendJsonData(HalloweenLobbyAdapter.this.mLayout.getRoot().getGuiId(), jSONObject);
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            });
            return;
        }
        holder.button.setVisibility(8);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.button = (Button) itemView.findViewById(R.id.button);
        }
    }

    public class Item {
        int deletable;
        String name;

        Item(String name, int deletable) {
            this.name = name;
            this.deletable = deletable;
        }
    }
}
