package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.UILayoutDonateDepositCoins;
import java.util.ArrayList;

public class DonateDepositCoinsAdapter extends RecyclerView.Adapter<DonateDepositCoinsAdapter.ViewHolder> {
    private ArrayList<DonateItem> items;
    private UILayoutDonateDepositCoins mLayout;

    public DonateDepositCoinsAdapter(UILayoutDonateDepositCoins layout) {
        this.items = null;
        this.mLayout = layout;
        this.items = new ArrayList<>();
        for (int i = 0; i < App.getInstance().getDonateItems().size(); i++) {
            if (App.getInstance().getDonateItems().get(i).getType().intValue() == 10) {
                this.items.add(App.getInstance().getDonateItems().get(i));
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.donate_coins_hot_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(GUIManager.transfromColors(this.items.get(position).getHeader()));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            //DonateDepositCoinsAdapter.this = this$0;
            this.text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
