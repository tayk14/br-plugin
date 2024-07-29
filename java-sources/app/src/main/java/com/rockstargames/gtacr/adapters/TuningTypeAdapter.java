package com.rockstargames.gtacr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.adapters.TuningTypeAdapter;
import com.rockstargames.gtacr.data.TuningMenuType;
import java.util.List;

public class TuningTypeAdapter extends RecyclerView.Adapter<TuningTypeAdapter.TuningHolder> {
    private Context context;
    private List<TuningMenuType> lTuningTypes;
    private OnClickTuningType onClickTuningType;

    public interface OnClickTuningType {
        void click(TuningMenuType tuningType, int getPosition, View view);
    }

    public TuningTypeAdapter(Context context, List<TuningMenuType> tuningTypes, OnClickTuningType onClickTuningType) {
        this.context = context;
        this.lTuningTypes = tuningTypes;
        this.onClickTuningType = onClickTuningType;
    }

    @Override
    public TuningHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TuningHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_type_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TuningHolder holder, int position) {
        TuningMenuType tuningMenuType = this.lTuningTypes.get(position);
        holder.typeTuning.setText(tuningMenuType.getTitleType());
        if (position == 0) {
            holder.bgTypeTuning.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_first_title_type_tuning));
        } else if (position == this.lTuningTypes.size() - 1) {
            holder.bgTypeTuning.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_last_title_type_tuning));
        } else {
            holder.bgTypeTuning.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_title_type_tuning));
        }
        if (!tuningMenuType.getClickable()) {
            holder.bgClick.setVisibility(4);
        } else {
            holder.bgClick.setVisibility(0);
        }
    }

    @Override
    public int getItemCount() {
        return this.lTuningTypes.size();
    }

    public class TuningHolder extends RecyclerView.ViewHolder {
        View bgClick;
        View bgTypeTuning;
        TextView typeTuning;

        public TuningHolder(View itemView) {
            super(itemView);
            //TuningTypeAdapter.this = this$0;
            this.typeTuning = (TextView) itemView.findViewById(R.id.title_type_tuning);
            this.bgTypeTuning = itemView.findViewById(R.id.bg_title_type_tuning);
            this.bgClick = itemView.findViewById(R.id.bg_click_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    TuningHolder.this.lambda$new$0$TuningTypeAdapter$TuningHolder(view);
                }
            });
        }

        public void lambda$new$0$TuningTypeAdapter$TuningHolder(View view) {
            TuningMenuType tuningMenuType = (TuningMenuType) TuningTypeAdapter.this.lTuningTypes.get(getLayoutPosition());
            tuningMenuType.setClickable(true);
            TuningTypeAdapter.this.notifyItemChanged(getLayoutPosition());
            TuningTypeAdapter.this.onClickTuningType.click(tuningMenuType, getLayoutPosition(), view);
        }
    }

    public void setOnlyItemClickable(int getPosition) {
        for (int i = 0; i < this.lTuningTypes.size(); i++) {
            if (this.lTuningTypes.get(i).getClickable() && i != getPosition) {
                this.lTuningTypes.get(i).setClickable(false);
                notifyItemChanged(i);
            }
        }
    }
}
