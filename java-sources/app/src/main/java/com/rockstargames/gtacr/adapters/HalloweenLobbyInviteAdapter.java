//////////////HalloweenLobbyInviteAdapter.this = this$0;
//////////////HalloweenLobbyInviteAdapter.this = this$0;
package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.gui.halloween.UILayoutHalloweenLobby;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class HalloweenLobbyInviteAdapter extends RecyclerView.Adapter<HalloweenLobbyInviteAdapter.ViewHolder> {
    private ArrayList<Item> items;
    private UILayoutHalloweenLobby mLayout;

    public HalloweenLobbyInviteAdapter(UILayoutHalloweenLobby layout, JSONArray names, JSONArray ids) {
        this.mLayout = null;
        this.items = null;
        this.mLayout = layout;
        this.items = new ArrayList<>();
        for (int i = 0; i < names.length(); i++) {
            try {
                this.items.add(new Item(names.getString(i), ids.getInt(i)));
            } catch (Exception unused) {
                return;
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.halloween_lobby_player_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        TextView textView = holder.name;
        textView.setText(this.items.get(position).name + "[" + this.items.get(position).id + "]");
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", 6);
                    jSONObject.put("i", ((Item) HalloweenLobbyInviteAdapter.this.items.get(position)).id);
                    HalloweenLobbyInviteAdapter.this.mLayout.getRoot().getGUIManager().sendJsonData(HalloweenLobbyInviteAdapter.this.mLayout.getRoot().getGuiId(), jSONObject);
                } catch (Exception unused) {
                }
                HalloweenLobbyInviteAdapter.this.mLayout.closeInviteDialog();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            itemView.findViewById(R.id.button).setVisibility(8);
        }
    }

    public class Item {
        int id;
        String name;

        Item(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
