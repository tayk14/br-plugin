package blackrussia.online.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import blackrussia.online.R;
import blackrussia.online.network.TextLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SliderTextAdapter extends RecyclerView.Adapter<SliderTextAdapter.Holder> {
    private Context context;
    private List<TextLoader> sliderItems = new ArrayList();

    public SliderTextAdapter(Context context) {
        this.context = context;
    }

    public void addItems(List<TextLoader> sliderItems) {
        this.sliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.sliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(TextLoader sliderItem) {
        this.sliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method: onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder; */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_loader, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return new Holder(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method: onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Holder holder, int position) {
        if (this.sliderItems.size() > 0) {
            List<TextLoader> list = this.sliderItems;
            holder.text.setText(list.get(position % list.size()).getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.sliderItems.size() == 0 ? 0 : 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Holder extends RecyclerView.ViewHolder {
        View itemView;
        TextView text;

        public Holder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.text);
            this.itemView = itemView;
        }
    }
}
