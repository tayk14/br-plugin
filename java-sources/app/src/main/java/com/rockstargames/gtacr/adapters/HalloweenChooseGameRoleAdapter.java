package com.rockstargames.gtacr.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.Utils;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.halloween.UILayoutHalloweenChooseGameRole;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class HalloweenChooseGameRoleAdapter extends RecyclerView.Adapter<HalloweenChooseGameRoleAdapter.ViewHolder> {
    private ArrayList<Item> items;
    private UILayoutHalloweenChooseGameRole mLayout;
    private int selected = -1;
    private int mType = -1;

    public int getSelected() {
        return this.selected;
    }

    public void setType(int type) {
        this.mType = type;
        this.selected = -1;
        this.mLayout.notifyButtonDeactivated();
        this.items.clear();
        int i = this.mType;
        if (i == 0) {
            this.items.add(new Item("Гонка\nвооружений", R.drawable.entertainment_system_item_arms_battle_res, "Игроков\nв очереди: "));
            this.items.add(new Item("Командное\nсражение", R.drawable.entertainment_system_item_battleground_res, "Игроков\nв очереди: "));
            this.items.add(new Item("Танковые\nбаталии", R.drawable.tank_9may, "Игроков\nв очереди: "));
        } else if (i == 1) {
            this.items.add(new Item("Убийца", R.drawable.halloween_pumpkin, "Игроков в очереди: "));
            this.items.add(new Item("Выживший", R.drawable.halloween_survived, "Игроков в очереди: "));
        } else if (i == 2) {
            this.items.add(new Item("С другими\nигроками", R.drawable.halloween_solo, ""));
            this.items.add(new Item("С друзьями", R.drawable.halloween_party, ""));
        }
        notifyDataSetChanged();
    }

    public int getType() {
        return this.mType;
    }

    public HalloweenChooseGameRoleAdapter(UILayoutHalloweenChooseGameRole layout, int type) {
        this.mLayout = null;
        this.items = null;
        this.mLayout = layout;
        this.items = new ArrayList<>();
        setType(type);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.halloween_choose_tile, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Item item = this.items.get(position);
        if (item.selected) {
            Utils.setBackground((Activity) this.mLayout.getContext(), R.drawable.ny_tile_background_9_may_selected, holder.root);
        } else {
            Utils.setBackground((Activity) this.mLayout.getContext(), R.drawable.ny_tile_background_9_may, holder.root);
        }
        if (this.mType == 2) {
            holder.header.setTypeface(ResourcesCompat.getFont(this.mLayout.getContext(), R.font.muller_bold));
            holder.header.setTextSize(20.0f);
            holder.header.setLineSpacing(0.3f, 1.0f);
        }
        holder.header.setText(GUIManager.transfromColors(item.header));
        int i = this.mType;
        if (i == 0) {
            JSONArray jSONArray = null;
            try {
                jSONArray = this.mLayout.getRoot().getJson().getJSONArray(TuningConstants.KEY_GET_ID_DETAIL);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            TextView textView = holder.footer;
            try {
                textView.setText(item.footer + jSONArray.getInt(position));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else if (i == 1) {
            JSONArray jSONArray2 = null;
            try {
                jSONArray2 = this.mLayout.getRoot().getJson().getJSONArray("m");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            TextView textView2 = holder.footer;
            try {
                textView2.setText(item.footer + jSONArray2.getInt(position));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            holder.footer.setText("");
            holder.image.setBackground(ResourcesCompat.getDrawable(this.mLayout.getContext().getResources(), item.image, null));
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (HalloweenChooseGameRoleAdapter.this.selected != -1) {
                        ((Item) HalloweenChooseGameRoleAdapter.this.items.get(HalloweenChooseGameRoleAdapter.this.selected)).selected = false;
                        HalloweenChooseGameRoleAdapter halloweenChooseGameRoleAdapter = HalloweenChooseGameRoleAdapter.this;
                        halloweenChooseGameRoleAdapter.notifyItemChanged(halloweenChooseGameRoleAdapter.selected);
                        HalloweenChooseGameRoleAdapter.this.selected = -1;
                    }
                    item.selected = true;
                    HalloweenChooseGameRoleAdapter.this.selected = position;
                    HalloweenChooseGameRoleAdapter halloweenChooseGameRoleAdapter2 = HalloweenChooseGameRoleAdapter.this;
                    halloweenChooseGameRoleAdapter2.notifyItemChanged(halloweenChooseGameRoleAdapter2.selected);
                    HalloweenChooseGameRoleAdapter.this.mLayout.notifyButtonPressed();
                }
            });
        }
        holder.image.setBackground(ResourcesCompat.getDrawable(this.mLayout.getContext().getResources(), item.image, null));
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (HalloweenChooseGameRoleAdapter.this.selected != -1) {
                    ((Item) HalloweenChooseGameRoleAdapter.this.items.get(HalloweenChooseGameRoleAdapter.this.selected)).selected = false;
                    HalloweenChooseGameRoleAdapter halloweenChooseGameRoleAdapter = HalloweenChooseGameRoleAdapter.this;
                    halloweenChooseGameRoleAdapter.notifyItemChanged(halloweenChooseGameRoleAdapter.selected);
                    HalloweenChooseGameRoleAdapter.this.selected = -1;
                }
                item.selected = true;
                HalloweenChooseGameRoleAdapter.this.selected = position;
                HalloweenChooseGameRoleAdapter halloweenChooseGameRoleAdapter2 = HalloweenChooseGameRoleAdapter.this;
                halloweenChooseGameRoleAdapter2.notifyItemChanged(halloweenChooseGameRoleAdapter2.selected);
                HalloweenChooseGameRoleAdapter.this.mLayout.notifyButtonPressed();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView footer;
        TextView header;
        View image;
        FrameLayout root;

        public ViewHolder(View itemView) {
            super(itemView);
            //HalloweenChooseGameRoleAdapter.this = this$0;
            this.root = (FrameLayout) itemView.findViewById(R.id.root);
            this.header = (TextView) itemView.findViewById(R.id.header);
            this.image = itemView.findViewById(R.id.image);
            this.footer = (TextView) itemView.findViewById(R.id.footer);
        }
    }

    public class Item {
        String footer;
        String header;
        int image;
        boolean selected = false;

        Item(String header, int image, String footer) {
            //HalloweenChooseGameRoleAdapter.this = this$0;
            this.header = header;
            this.image = image;
            this.footer = footer;
        }
    }
}
