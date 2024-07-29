package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.data.DataFood;
import java.util.List;

public class DialogDinnerAdapter extends RecyclerView.Adapter<DialogDinnerAdapter.DialogEatsHolder> {
    private List<DataFood> lDataEats;
    private OnUserClickListenerEatsDialog onUserClickListenerEatsDialog;

    public interface OnUserClickListenerEatsDialog {
        void click(DataFood dataFood, View view);
    }

    public DialogDinnerAdapter(List<DataFood> dataEats, OnUserClickListenerEatsDialog onUserClickListenerEatsDialog) {
        this.lDataEats = dataEats;
        this.onUserClickListenerEatsDialog = onUserClickListenerEatsDialog;
    }

    @Override
    public DialogEatsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DialogEatsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dinner_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DialogEatsHolder holder, int position) {
        DataFood dataFood = this.lDataEats.get(position);
        holder.imageFoodThis.setImageResource(dataFood.getImageFood());
        holder.titleFoodThis.setText(dataFood.getNameFood());
        holder.valueFoodSatietyThis.setText(String.valueOf(dataFood.getSatietyFood()));
        holder.valueFoodPriceThis.setText(String.valueOf(dataFood.getPriceFood()));
    }

    @Override
    public int getItemCount() {
        return this.lDataEats.size();
    }

    public class DialogEatsHolder extends RecyclerView.ViewHolder {
        ImageView imageFoodThis;
        TextView titleFoodThis;
        TextView valueFoodPriceThis;
        TextView valueFoodSatietyThis;

        public DialogEatsHolder(View itemView) {
            super(itemView);
            //DialogDinnerAdapter.this = this$0;
            this.imageFoodThis = (ImageView) itemView.findViewById(R.id.image_view_dinner);
            this.titleFoodThis = (TextView) itemView.findViewById(R.id.title_food_item);
            this.valueFoodSatietyThis = (TextView) itemView.findViewById(R.id.br_value_diner_satiety);
            this.valueFoodPriceThis = (TextView) itemView.findViewById(R.id.br_value_diner_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogDinnerAdapter.this.onUserClickListenerEatsDialog.click((DataFood) DialogDinnerAdapter.this.lDataEats.get(DialogEatsHolder.this.getLayoutPosition()), view);
                }
            });
        }
    }
}
