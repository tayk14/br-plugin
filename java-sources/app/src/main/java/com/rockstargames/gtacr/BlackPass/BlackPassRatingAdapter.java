package com.rockstargames.gtacr.BlackPass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BlackPassRatingAdapter extends RecyclerView.Adapter<BlackPassRatingAdapter.ViewHolder> {
    int[] ExpsArray = new int[10];
    ArrayList<String> NamesArray = new ArrayList<>();

    @Override
    public int getItemCount() {
        return 10;
    }

    public BlackPassRatingAdapter(JSONObject json) {
        try {
            JSONArray jSONArray = (JSONArray) json.get(GetKeys.GET_NEW_SIZE_INVENTORY);
            JSONArray jSONArray2 = (JSONArray) json.get("es");
            if (jSONArray == null || jSONArray2 == null) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.NamesArray.add(jSONArray.get(i).toString());
                this.ExpsArray[i] = jSONArray2.getInt(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_item_rating, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {
            holder.Medal.setImageResource(R.drawable.medal_gold);
        } else if (position == 1) {
            holder.Medal.setImageResource(R.drawable.medal_silver);
        } else if (position == 2) {
            holder.Medal.setImageResource(R.drawable.medal_bronze);
        } else {
            holder.Medal.setImageResource(R.drawable.medal_other);
        }
        holder.Name.setText(this.NamesArray.get(position));
        holder.Exp.setText(String.format("%,.0f очков", Float.valueOf(this.ExpsArray[position])));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Exp;
        ImageView Medal;
        TextView Name;

        ViewHolder(View view) {
            super(view);
            //BlackPassRatingAdapter.this = this$0;
            this.Medal = (ImageView) view.findViewById(R.id.bp_irating_medal);
            this.Name = (TextView) view.findViewById(R.id.bp_irating_name);
            this.Exp = (TextView) view.findViewById(R.id.bp_irating_exp);
        }
    }
}
