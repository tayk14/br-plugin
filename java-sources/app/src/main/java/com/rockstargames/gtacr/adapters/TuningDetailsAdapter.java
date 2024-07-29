package com.rockstargames.gtacr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.Tune;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.TuningDetailsAdapter;
import com.rockstargames.gtacr.gui.tuning.GUITuning;
import java.util.List;

public class TuningDetailsAdapter extends RecyclerView.Adapter<TuningDetailsAdapter.TuningDetailsHolder> {
    private Context context;
    private List<Tune> lDetailsItems;
    private int mActiveSelectorId;
    private GUITuning mainRoot;
    private OnClickDetailItem onClickDetailItem;

    public interface OnClickDetailItem {
        void click(Tune detailsItem, int getPosition, View view);
    }

    public TuningDetailsAdapter(GUITuning mainRoot, Context context, List<Tune> detailsItems, OnClickDetailItem onClickDetailItem) {
        this.mainRoot = mainRoot;
        this.context = context;
        this.lDetailsItems = detailsItems;
        this.onClickDetailItem = onClickDetailItem;
    }

    @Override
    public TuningDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TuningDetailsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_detail_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TuningDetailsHolder holder, int position) {
        Tune tune = this.lDetailsItems.get(position);
        holder.nameDetail.setText(tune.getName());
        String priceWithSpaces = GUIManager.getPriceWithSpaces(tune.getCost());
        holder.iconDetail.setImageDrawable(this.mainRoot.getDrawableByName(tune.getImageId()));
        if (!tune.getChecked()) {
            holder.bgViewDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_detail_not_check));
            holder.bgHeaderDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_border_detail_not_check_item));
        } else {
            holder.bgViewDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_detail_check));
            holder.bgHeaderDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_border_detail_check_item));
        }
        int thisLocation = tune.getThisLocation();
        if (thisLocation == 0) {
            holder.costDetail.setText(priceWithSpaces);
            if (tune.getCurrency() == 0) {
                holder.iconCost.setImageResource(R.drawable.tuning_icon_gold_in_details);
            } else {
                holder.iconCost.setImageResource(R.drawable.tuning_icon_black_coin_in_details);
            }
        } else if (thisLocation == 1) {
            holder.costDetail.setText(R.string.tuning_bought_detail);
            holder.iconCost.setImageResource(R.drawable.tuning_icon_bought_in_details);
        } else if (thisLocation != 2) {
        } else {
            holder.costDetail.setText(R.string.tuning_set_detail);
            holder.iconCost.setImageResource(R.drawable.tuning_icon_check_in_details);
        }
    }

    @Override
    public int getItemCount() {
        return this.lDetailsItems.size();
    }

    public class TuningDetailsHolder extends RecyclerView.ViewHolder {
        private View bgHeaderDetail;
        private View bgViewDetail;
        private TextView costDetail;
        private ImageView iconCost;
        private ImageView iconDetail;
        private TextView nameDetail;

        public TuningDetailsHolder(View itemView) {
            super(itemView);
            //TuningDetailsAdapter.this = this$0;
            this.bgViewDetail = itemView.findViewById(R.id.bg_view_detail);
            this.bgHeaderDetail = itemView.findViewById(R.id.bg_header_detail);
            this.nameDetail = (TextView) itemView.findViewById(R.id.name_detail);
            this.iconDetail = (ImageView) itemView.findViewById(R.id.icon_details);
            this.costDetail = (TextView) itemView.findViewById(R.id.value_cost);
            this.iconCost = (ImageView) itemView.findViewById(R.id.icon_value_cost);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    TuningDetailsHolder.this.lambda$new$0$TuningDetailsAdapter$TuningDetailsHolder(view);
                }
            });
        }

        public void lambda$new$0$TuningDetailsAdapter$TuningDetailsHolder(View view) {
            Tune tune = (Tune) TuningDetailsAdapter.this.lDetailsItems.get(getLayoutPosition());
            tune.setChecked(true);
            TuningDetailsAdapter.this.notifyItemChanged(getLayoutPosition());
            TuningDetailsAdapter.this.onClickDetailItem.click(tune, getLayoutPosition(), view);
        }
    }

    public void setOnlyDetailClickable(int getPosition) {
        for (int i = 0; i < this.lDetailsItems.size(); i++) {
            if (this.lDetailsItems.get(i).getChecked() && i != getPosition) {
                this.lDetailsItems.get(i).setChecked(false);
                notifyItemChanged(i);
            }
        }
    }
}
