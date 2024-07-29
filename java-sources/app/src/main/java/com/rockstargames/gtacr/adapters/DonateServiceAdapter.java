package com.rockstargames.gtacr.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.UILayoutDonateServices;
import java.util.ArrayList;

public class DonateServiceAdapter extends RecyclerView.Adapter<DonateServiceAdapter.ViewHolder> {
    private ArrayList<DonateItemExtended> donateServices;
    private ServiceChangedListener listener;
    private UILayoutDonateServices mRoot;
    private int selected;

    public interface ServiceChangedListener {
        void onServiceChanged(DonateItem newService);
    }

    public class DonateItemExtended {
        public DonateItem item;
        private boolean selected = false;

        DonateItemExtended() {
            //DonateServiceAdapter.this = this$0;
        }
    }

    public DonateServiceAdapter(UILayoutDonateServices layout, ServiceChangedListener listener) {
        this.donateServices = null;
        this.selected = -1;
        this.mRoot = layout;
        this.listener = listener;
        this.donateServices = new ArrayList<>();
        ArrayList<DonateItem> donateItems = App.getInstance().getDonateItems();
        for (int i = 0; i < donateItems.size(); i++) {
            DonateItem donateItem = donateItems.get(i);
            if (donateItem != null && donateItem.getType().intValue() == 5) {
                DonateItemExtended donateItemExtended = new DonateItemExtended();
                donateItemExtended.item = donateItem;
                this.donateServices.add(donateItemExtended);
            }
        }
        this.donateServices.get(0).selected = true;
        this.selected = -1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.donate_services_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DonateItemExtended donateItemExtended = this.donateServices.get(position);
        Button button = holder.buttonRight;
        button.setText(donateItemExtended.item.getBasePrice() + GUIManager.getBCText());
        holder.buttonLeft.setText(donateItemExtended.item.getHeader());
        if (donateItemExtended.item.getSalePercent() != 0) {
            holder.sales.setVisibility(0);
            Button button2 = holder.sales;
            button2.setText("-" + donateItemExtended.item.getSalePercent() + "%");
        } else {
            holder.sales.setVisibility(4);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonateServiceAdapter.this.listener.onServiceChanged(((DonateItemExtended) DonateServiceAdapter.this.donateServices.get(position)).item);
                if (v != null) {
                    v.startAnimation(AnimationUtils.loadAnimation(DonateServiceAdapter.this.mRoot.getDonate().getNvEvent(), R.anim.button_click));
                    if (DonateServiceAdapter.this.selected != -1) {
                        ((DonateItemExtended) DonateServiceAdapter.this.donateServices.get(DonateServiceAdapter.this.selected)).selected = false;
                        DonateServiceAdapter donateServiceAdapter = DonateServiceAdapter.this;
                        donateServiceAdapter.notifyItemChanged(donateServiceAdapter.selected);
                        DonateServiceAdapter.this.selected = position;
                        ((DonateItemExtended) DonateServiceAdapter.this.donateServices.get(DonateServiceAdapter.this.selected)).selected = true;
                        DonateServiceAdapter donateServiceAdapter2 = DonateServiceAdapter.this;
                        donateServiceAdapter2.notifyItemChanged(donateServiceAdapter2.selected);
                        return;
                    }
                    ((DonateItemExtended) DonateServiceAdapter.this.donateServices.get(position)).selected = true;
                    DonateServiceAdapter.this.selected = position;
                    DonateServiceAdapter donateServiceAdapter3 = DonateServiceAdapter.this;
                    donateServiceAdapter3.notifyItemChanged(donateServiceAdapter3.selected);
                }
            }
        };
        if (this.selected == -1) {
            this.selected = 0;
            onClickListener.onClick(null);
        }
        if (this.donateServices.get(position).selected) {
            holder.buttonLeft.setTextColor(Color.parseColor("#20212A"));
            holder.buttonRight.setTextColor(Color.parseColor("#20212A"));
            holder.buttonLeft.setBackground(ResourcesCompat.getDrawable(this.mRoot.getDonate().getNvEvent().getResources(), R.drawable.button_yellow_gradient, null));
            holder.buttonRight.setBackground(ResourcesCompat.getDrawable(this.mRoot.getDonate().getNvEvent().getResources(), R.drawable.button_yellow_gradient, null));
        } else {
            holder.buttonLeft.setTextColor(Color.parseColor("#FFFFFF"));
            holder.buttonRight.setTextColor(Color.parseColor("#FFFFFF"));
            holder.buttonLeft.setBackground(ResourcesCompat.getDrawable(this.mRoot.getDonate().getNvEvent().getResources(), R.drawable.button_gray, null));
            holder.buttonRight.setBackground(ResourcesCompat.getDrawable(this.mRoot.getDonate().getNvEvent().getResources(), R.drawable.button_gray, null));
        }
        holder.buttonRight.setOnClickListener(onClickListener);
        holder.buttonLeft.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return this.donateServices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button buttonLeft;
        Button buttonRight;
        Button sales;

        public ViewHolder(View itemView) {
            super(itemView);
            //DonateServiceAdapter.this = this$0;
            this.buttonLeft = (Button) itemView.findViewById(R.id.button_left);
            this.buttonRight = (Button) itemView.findViewById(R.id.button_right);
            this.sales = (Button) itemView.findViewById(R.id.sales);
        }
    }
}
