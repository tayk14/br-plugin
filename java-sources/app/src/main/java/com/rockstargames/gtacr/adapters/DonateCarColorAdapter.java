package com.rockstargames.gtacr.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.CarColorItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.UILayoutDonatePreviewCar;
import java.util.ArrayList;

public class DonateCarColorAdapter extends RecyclerView.Adapter<DonateCarColorAdapter.ViewHolder> {
    private ArrayList<CarColorItem> carColors;
    private UILayoutDonatePreviewCar mLayout;
    private int selected = 0;

    public DonateCarColorAdapter(UILayoutDonatePreviewCar layout) {
        this.carColors = null;
        this.mLayout = layout;
        ArrayList<CarColorItem> carColorItems = App.getInstance().getCarColorItems();
        this.carColors = carColorItems;
        carColorItems.get(0).setSelected(true);
    }

    public int getSelectedGameColor() {
        return this.carColors.get(this.selected).getGameColor();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.br_donate_color_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (this.carColors.get(position).getSelected()) {
            if (position == 0) {
                holder.free.setVisibility(0);
            } else {
                holder.free.setVisibility(4);
                holder.paid.setVisibility(0);
            }
            holder.border.setBackground(ResourcesCompat.getDrawable(this.mLayout.getContext().getResources(), R.drawable.border_button, null));
        } else {
            holder.paid.setVisibility(4);
            holder.free.setVisibility(4);
            holder.border.setBackground(ResourcesCompat.getDrawable(this.mLayout.getContext().getResources(), R.drawable.border_button_gray, null));
        }
        TextView textView = holder.paid;
        textView.setText("+ " + String.valueOf((int) getCarColorPrice()) + GUIManager.getBCText());
        holder.color.setBackgroundColor(Color.parseColor(this.carColors.get(position).getColor()));
        holder.border.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CarColorItem) DonateCarColorAdapter.this.carColors.get(DonateCarColorAdapter.this.selected)).setSelected(false);
                DonateCarColorAdapter donateCarColorAdapter = DonateCarColorAdapter.this;
                donateCarColorAdapter.notifyItemChanged(donateCarColorAdapter.selected);
                ((CarColorItem) DonateCarColorAdapter.this.carColors.get(position)).setSelected(true);
                DonateCarColorAdapter.this.selected = position;
                DonateCarColorAdapter.this.notifyItemChanged(position);
                DonateCarColorAdapter.this.mLayout.changeCarColorPreview(((CarColorItem) DonateCarColorAdapter.this.carColors.get(position)).getGameColor());
                DonateCarColorAdapter.this.mLayout.updatePrice();
            }
        });
    }

    public float getCarColorPrice() {
        if (this.selected == 0) {
            return 0.0f;
        }
        return (this.mLayout.getDonate().getSelectedItem().getBasePrice().intValue() * 0.01f) + 5.0f;
    }

    public void resetColor() {
        this.carColors.get(this.selected).setSelected(false);
        notifyItemChanged(this.selected);
        this.selected = 0;
        this.carColors.get(0).setSelected(true);
        notifyItemChanged(this.selected);
    }

    @Override
    public int getItemCount() {
        return this.carColors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button border;
        View color;
        TextView free;
        TextView paid;

        public ViewHolder(View itemView) {
            super(itemView);
            //DonateCarColorAdapter.this = this$0;
            this.color = itemView.findViewById(R.id.color);
            this.border = (Button) itemView.findViewById(R.id.border);
            this.paid = (TextView) itemView.findViewById(R.id.paid);
            this.free = (TextView) itemView.findViewById(R.id.free);
        }
    }
}
