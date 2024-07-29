package com.rockstargames.gtacr.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.TuneVinyls;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.adapters.TuningVinylsAdapter;
import com.rockstargames.gtacr.gui.tuning.GUITuning;
import java.util.List;

public class TuningVinylsAdapter extends RecyclerView.Adapter<TuningVinylsAdapter.ViewHolder> {
    private Context context;
    private int costVinyl;
    private int mActiveSelectorId;
    private GUITuning mainRoot;
    private OnClickVinylItem onClickVinylItem;
    private List<TuneVinyls> tuneVinyls;

    public interface OnClickVinylItem {
        void click(TuneVinyls tuneVinyl, int getPosition, View view);
    }

    public TuningVinylsAdapter(GUITuning mainRoot, Context context, List<TuneVinyls> tuneVinyls, OnClickVinylItem onClickVinylItem, int costVinyl) {
        this.mainRoot = mainRoot;
        this.context = context;
        this.tuneVinyls = tuneVinyls;
        this.onClickVinylItem = onClickVinylItem;
        this.costVinyl = costVinyl;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_detail_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        TuneVinyls tuneVinyls = this.tuneVinyls.get(position);
        TextView textView = holder.nameDetail;
        textView.setText("Винил №" + (position + 1));
        if (tuneVinyls.getFirstRender()) {
            Log.v("LOG_D", "render true");
            holder.iconDetail.setAlpha(0.0f);
            this.mainRoot.getNvContext().getGameRender().RequestTexture(tuneVinyls.getNameVinyl(), position, new GameRender.GameTextureListener() {
                @Override
                public void OnTextureGet(int id, final Bitmap bitmap) {
                    TuningVinylsAdapter.this.mainRoot.getNvContext().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TuningVinylsAdapter.this.mainRoot.saveVinyls(bitmap);
                            holder.iconDetail.setImageBitmap(bitmap);
                            holder.iconDetail.setAlpha(1.0f);
                        }
                    });
                }
            });
            tuneVinyls.setFirstRender(false);
        } else {
            Log.v("LOG_D", "render false" + this.mainRoot.getSizeBitmapVinyls());
            if (this.mainRoot.getSizeBitmapVinyls() != 0) {
                Log.v("LOG_D", "render false and size not null");
                holder.iconDetail.setImageBitmap(this.mainRoot.getThisVinyl(position));
            }
        }
        if (!tuneVinyls.getSelected()) {
            holder.bgViewDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_detail_not_check));
            holder.bgHeaderDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_border_detail_not_check_item));
        } else {
            holder.bgViewDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_bg_detail_check));
            holder.bgHeaderDetail.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tuning_border_detail_check_item));
        }
        String priceWithSpaces = GUIManager.getPriceWithSpaces(this.costVinyl);
        if (!tuneVinyls.getStartVinyl()) {
            holder.costDetail.setText(priceWithSpaces);
            holder.iconCost.setImageResource(R.drawable.tuning_icon_gold_in_details);
            return;
        }
        holder.costDetail.setText(R.string.tuning_set_detail);
        holder.iconCost.setImageResource(R.drawable.tuning_icon_check_in_details);
    }

    @Override
    public int getItemCount() {
        return this.tuneVinyls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View bgHeaderDetail;
        private View bgViewDetail;
        private TextView costDetail;
        private ImageView iconCost;
        private ImageView iconDetail;
        private TextView nameDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            //TuningVinylsAdapter.this = this$0;
            this.bgViewDetail = itemView.findViewById(R.id.bg_view_detail);
            this.bgHeaderDetail = itemView.findViewById(R.id.bg_header_detail);
            this.nameDetail = (TextView) itemView.findViewById(R.id.name_detail);
            this.iconDetail = (ImageView) itemView.findViewById(R.id.icon_details);
            this.costDetail = (TextView) itemView.findViewById(R.id.value_cost);
            this.iconCost = (ImageView) itemView.findViewById(R.id.icon_value_cost);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    ViewHolder.this.lambda$new$0$TuningVinylsAdapter$ViewHolder(view);
                }
            });
        }

        public void lambda$new$0$TuningVinylsAdapter$ViewHolder(View view) {
            TuneVinyls tuneVinyls = (TuneVinyls) TuningVinylsAdapter.this.tuneVinyls.get(getLayoutPosition());
            tuneVinyls.setSelected(true);
            TuningVinylsAdapter.this.notifyItemChanged(getLayoutPosition());
            TuningVinylsAdapter.this.onClickVinylItem.click(tuneVinyls, getLayoutPosition(), view);
        }
    }

    public void setOnlyVinylClickable(int getPosition) {
        for (int i = 0; i < this.tuneVinyls.size(); i++) {
            if (this.tuneVinyls.get(i).getSelected() && i != getPosition) {
                this.tuneVinyls.get(i).setSelected(false);
                notifyItemChanged(i);
            }
        }
    }
}
