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
import com.rockstargames.gtacr.adapters.TuningDetailsInDiagnosticAdapter;
import com.rockstargames.gtacr.data.TuningDetailDiagnosticItem;
import com.rockstargames.gtacr.gui.tuning.GUITuning;
import java.util.ArrayList;
import java.util.List;

public class TuningDetailsInDiagnosticAdapter extends RecyclerView.Adapter<TuningDetailsInDiagnosticAdapter.DiagnosticHolder> {
    private final Context context;
    private List<TuningDetailDiagnosticItem> lDetailsItems;
    private GUITuning mainRoot;
    private OnClickDetailInDiagnosticItem onClickDetailItem;
    private int statusDiagnostic;

    public interface OnClickDetailInDiagnosticItem {
        void clickInDiagnostic(TuningDetailDiagnosticItem detailsItem, int getPosition, View view);
    }

    public TuningDetailsInDiagnosticAdapter(GUITuning mainRoot, Context context, List<TuningDetailDiagnosticItem> lDetailsItems, OnClickDetailInDiagnosticItem onClickDetailItem, int statusDiagnostic) {
        this.lDetailsItems = new ArrayList();
        this.mainRoot = mainRoot;
        this.context = context;
        this.lDetailsItems = lDetailsItems;
        this.onClickDetailItem = onClickDetailItem;
        this.statusDiagnostic = statusDiagnostic;
    }

    @Override
    public DiagnosticHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiagnosticHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_diagnostic_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DiagnosticHolder holder, int position) {
        TuningDetailDiagnosticItem tuningDetailDiagnosticItem = this.lDetailsItems.get(position);
        holder.iconDetail.setImageDrawable(this.mainRoot.getDrawableByName(tuningDetailDiagnosticItem.getResName()));
        if (!tuningDetailDiagnosticItem.isChecked()) {
            holder.bgViewDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_detail_not_check));
            holder.bgHeaderDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_border_detail_not_check_item));
        } else {
            holder.bgViewDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_detail_check));
            holder.bgHeaderDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_border_detail_check_item));
        }
        holder.nameViewDetail.setText(tuningDetailDiagnosticItem.getNameDetail());
        holder.valueViewState.setText(tuningDetailDiagnosticItem.getValueState() + "%");
        holder.valueViewCost.setText(String.valueOf(tuningDetailDiagnosticItem.getCost()));
        holder.iconCost.setImageResource(R.drawable.tuning_icon_gold_in_details);
        if (this.statusDiagnostic == 0) {
            holder.iconState.setImageResource(R.drawable.tuning_icon_state_diagnostic_noactual);
            holder.valueViewState.setTextColor(ContextCompat.getColor(this.context, R.color.red_diagnostics));
            return;
        }
        holder.iconState.setImageResource(R.drawable.tuning_icon_state_diagnostic_actual);
        holder.valueViewState.setTextColor(ContextCompat.getColor(this.context, R.color.green_check_element));
    }

    @Override
    public int getItemCount() {
        return this.lDetailsItems.size();
    }

    public class DiagnosticHolder extends RecyclerView.ViewHolder {
        private final View bgHeaderDetail;
        private final View bgViewDetail;
        private final ImageView iconCost;
        private final ImageView iconDetail;
        private final ImageView iconState;
        private final TextView nameViewDetail;
        private final TextView valueViewCost;
        private final TextView valueViewState;

        public DiagnosticHolder(View itemView) {
            super(itemView);
            //TuningDetailsInDiagnosticAdapter.this = this$0;
            this.bgViewDetail = itemView.findViewById(R.id.bg_view_detail_in_diagnostic);
            this.bgHeaderDetail = itemView.findViewById(R.id.bg_header_detail_in_diagnostic);
            this.nameViewDetail = (TextView) itemView.findViewById(R.id.name_detail_in_diagnostic);
            this.valueViewState = (TextView) itemView.findViewById(R.id.value_state_detail_in_diagnostic);
            this.valueViewCost = (TextView) itemView.findViewById(R.id.value_cost_detail_in_diagnostic);
            this.iconState = (ImageView) itemView.findViewById(R.id.icon_state_detail_in_diagnostic);
            this.iconCost = (ImageView) itemView.findViewById(R.id.icon_detail_in_diagnostic);
            this.iconDetail = (ImageView) itemView.findViewById(R.id.icon_details_in_diagnostic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    DiagnosticHolder.this.lambda$new$0$TuningDetailsInDiagnosticAdapter$DiagnosticHolder(view);
                }
            });
        }

        public void lambda$new$0$TuningDetailsInDiagnosticAdapter$DiagnosticHolder(View view) {
            TuningDetailDiagnosticItem tuningDetailDiagnosticItem = (TuningDetailDiagnosticItem) TuningDetailsInDiagnosticAdapter.this.lDetailsItems.get(getLayoutPosition());
            tuningDetailDiagnosticItem.setChecked(true);
            TuningDetailsInDiagnosticAdapter.this.notifyItemChanged(getLayoutPosition());
            TuningDetailsInDiagnosticAdapter.this.onClickDetailItem.clickInDiagnostic(tuningDetailDiagnosticItem, getLayoutPosition(), view);
        }
    }

    public void setOnlyItemClickable(int getPosition) {
        for (int i = 0; i < this.lDetailsItems.size(); i++) {
            if (this.lDetailsItems.get(i).isChecked() && i != getPosition) {
                this.lDetailsItems.get(i).setChecked(false);
                notifyItemChanged(i);
            }
        }
    }
}
