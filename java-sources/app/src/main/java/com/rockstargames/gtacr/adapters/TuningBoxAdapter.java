package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.data.TuningBoxItem;
import java.util.List;

public class TuningBoxAdapter extends RecyclerView.Adapter<TuningBoxAdapter.TuningBoxHolder> {
    private List<TuningBoxItem> lBoxItems;

    public TuningBoxAdapter(List<TuningBoxItem> boxItems) {
        this.lBoxItems = boxItems;
    }

    @Override
    public TuningBoxHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TuningBoxHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_submenu_box_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TuningBoxHolder holder, int position) {
        holder.nameDetailInBox.setText(this.lBoxItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.lBoxItems.size();
    }

    public class TuningBoxHolder extends RecyclerView.ViewHolder {
        private TextView nameDetailInBox;

        public TuningBoxHolder(View itemView) {
            super(itemView);
            //TuningBoxAdapter.this = this$0;
            this.nameDetailInBox = (TextView) itemView.findViewById(R.id.text_box_item);
        }
    }
}
