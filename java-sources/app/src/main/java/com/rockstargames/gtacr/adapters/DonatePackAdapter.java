package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.rockstargames.gtacr.gui.GUIDonate;
import com.rockstargames.gtacr.gui.UILayoutDonatePreviewPack;
import java.util.ArrayList;

public class DonatePackAdapter extends RecyclerView.Adapter<DonatePackAdapter.ViewHolder> {
    private ArrayList<DonateItem> items;
    private UILayoutDonatePreviewPack mLayout;

    public DonatePackAdapter(UILayoutDonatePreviewPack layout) {
        this.items = null;
        this.mLayout = layout;
        this.items = new ArrayList<>();
        DonateItem selectedItem = this.mLayout.getDonate().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        if (selectedItem.getContains() == null) {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            firebaseCrashlytics.log("dolbaeb " + selectedItem.getInternalId());
            FirebaseCrashlytics.getInstance().recordException(new Throwable());
            return;
        }
        for (int i = 0; i < selectedItem.getContains().size(); i++) {
            this.items.add(GUIDonate.getItemFromInternalId(selectedItem.getContains().get(i).intValue()));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.donate_services_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.buttonRight.setVisibility(8);
        try {
            DonateItem donateItem = this.items.get(position);
            if (donateItem.getType().intValue() == 7) {
                Button button = holder.buttonLeft;
                button.setText(donateItem.getHeader() + " " + donateItem.getSubheader());
            } else {
                holder.buttonLeft.setText(donateItem.getHeader());
            }
        } catch (Exception e) {
            holder.buttonLeft.setText("invalid pos");
            Toast.makeText(this.mLayout.getContext(), e.toString(), 1);
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button buttonLeft;
        Button buttonRight;

        public ViewHolder(View itemView) {
            super(itemView);
            //DonatePackAdapter.this = this$0;
            this.buttonLeft = (Button) itemView.findViewById(R.id.button_left);
            this.buttonRight = (Button) itemView.findViewById(R.id.button_right);
            itemView.findViewById(R.id.frame).setVisibility(8);
        }
    }
}
