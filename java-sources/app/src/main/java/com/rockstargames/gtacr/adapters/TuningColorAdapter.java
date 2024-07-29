package com.rockstargames.gtacr.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.CarColorItem;
import com.rockstargames.gtacr.adapters.TuningColorAdapter;
import java.util.ArrayList;
import java.util.List;

public class TuningColorAdapter extends RecyclerView.Adapter<TuningColorAdapter.ColorHolder> {
    private OnClickColorItem lClickColorItem;
    private List<CarColorItem> lColorList;
    private Context lContext;

    public interface OnClickColorItem {
        void click(CarColorItem colorItem, int getPosition, View view);
    }

    public TuningColorAdapter(Context context, List<CarColorItem> colorList, OnClickColorItem clickColorItem) {
        this.lColorList = new ArrayList();
        this.lContext = context;
        this.lColorList = colorList;
        this.lClickColorItem = clickColorItem;
    }

    @Override
    public ColorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColorHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_color_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ColorHolder holder, int position) {
        CarColorItem carColorItem = this.lColorList.get(position);
        holder.colorItem.setBackgroundColor(Color.parseColor(carColorItem.getColor()));
        if (carColorItem.getStartColor()) {
            holder.checkedIcon.setVisibility(0);
        } else {
            holder.checkedIcon.setVisibility(4);
        }
        if (!carColorItem.getSelected()) {
            holder.borderItem.setBackground(ContextCompat.getDrawable(this.lContext, R.drawable.tuning_border_button_gray));
        } else {
            holder.borderItem.setBackground(ContextCompat.getDrawable(this.lContext, R.drawable.tuning_border_button_white));
        }
    }

    @Override
    public int getItemCount() {
        return this.lColorList.size();
    }

    public class ColorHolder extends RecyclerView.ViewHolder {
        private View borderItem;
        private View checkedIcon;
        private View colorItem;

        public ColorHolder(View itemView) {
            super(itemView);
            //TuningColorAdapter.this = this$0;
            this.colorItem = itemView.findViewById(R.id.color);
            this.borderItem = itemView.findViewById(R.id.border);
            this.checkedIcon = itemView.findViewById(R.id.checked_start_color);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    ColorHolder.this.lambda$new$0$TuningColorAdapter$ColorHolder(view);
                }
            });
        }

        public void lambda$new$0$TuningColorAdapter$ColorHolder(View view) {
            CarColorItem carColorItem = (CarColorItem) TuningColorAdapter.this.lColorList.get(getLayoutPosition());
            carColorItem.setSelected(true);
            TuningColorAdapter.this.notifyItemChanged(getLayoutPosition());
            TuningColorAdapter.this.lClickColorItem.click(carColorItem, getLayoutPosition(), view);
        }
    }

    public void setOnlyColorClickable(int getPosition) {
        for (int i = 0; i < this.lColorList.size(); i++) {
            if (this.lColorList.get(i).getSelected() && i != getPosition) {
                this.lColorList.get(i).setSelected(false);
                notifyItemChanged(i);
            }
        }
    }

    public void setOnlyItemStartColor(int getId) {
        for (int i = 0; i < this.lColorList.size(); i++) {
            if (this.lColorList.get(i).getId() == getId) {
                this.lColorList.get(i).setStartColor(true);
                notifyItemChanged(i);
            }
        }
    }
}
