//////////////TuningSubmenuItemsAdapter.this = this$0;
package com.rockstargames.gtacr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.TuneGuiNode;
import com.rockstargames.gtacr.adapters.TuningSubmenuItemsAdapter;
import com.rockstargames.gtacr.gui.tuning.GUITuning;
import java.util.List;

public class TuningSubmenuItemsAdapter extends RecyclerView.Adapter<TuningSubmenuItemsAdapter.SubmenuHolder> {
    private OnClickSubmenuItem clickSubmenuItem;
    private Context context;
    private List<TuneGuiNode> lSubmenuTunings;
    private GUITuning mainRoot;

    public interface OnClickSubmenuItem {
        void click(TuneGuiNode submenuTuning, int getPosition, View view);
    }

    public TuningSubmenuItemsAdapter(GUITuning mainRoot, Context context, List<TuneGuiNode> submenuTunings, OnClickSubmenuItem clickSubmenuItem) {
        this.mainRoot = mainRoot;
        this.context = context;
        this.lSubmenuTunings = submenuTunings;
        this.clickSubmenuItem = clickSubmenuItem;
    }

    @Override
    public SubmenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SubmenuHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tuning_submenu_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SubmenuHolder holder, int position) {
        TuneGuiNode tuneGuiNode = this.lSubmenuTunings.get(position);
        holder.nameSubmenuItem.setText(tuneGuiNode.getName());
        holder.iconSubmenuItem.setImageDrawable(this.mainRoot.getDrawableByName(tuneGuiNode.getImageId()));
    }

    @Override
    public int getItemCount() {
        return this.lSubmenuTunings.size();
    }

    public class SubmenuHolder extends RecyclerView.ViewHolder {
        private ImageView iconSubmenuItem;
        private TextView nameSubmenuItem;

        public SubmenuHolder(View itemView) {
            super(itemView);
            this.iconSubmenuItem = (ImageView) itemView.findViewById(R.id.icon_submenu_item);
            this.nameSubmenuItem = (TextView) itemView.findViewById(R.id.name_submenu_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    SubmenuHolder.this.lambda$new$0$TuningSubmenuItemsAdapter$SubmenuHolder(view);
                }
            });
        }

        public void lambda$new$0$TuningSubmenuItemsAdapter$SubmenuHolder(View view) {
            TuningSubmenuItemsAdapter.this.clickSubmenuItem.click((TuneGuiNode) TuningSubmenuItemsAdapter.this.lSubmenuTunings.get(getLayoutPosition()), getLayoutPosition(), view);
        }
    }
}
