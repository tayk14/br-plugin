package blackrussia.online.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import blackrussia.online.R;

/* loaded from: classes.dex */
public class RouletteAdapter extends RecyclerView.Adapter<RouletteAdapter.Holder> {
    private Context context;
    private ArrayList<Integer> items;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public RouletteAdapter(Context context, ArrayList<Integer> items) {
        this.context = context;
        this.items = items;
    }

    /* JADX DEBUG: Method merged with bridge method: onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder; */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_roulette, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return new Holder(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method: onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Holder holder, int position) {
        ArrayList<Integer> arrayList = this.items;
        holder.imageView.setImageResource(arrayList.get(position % arrayList.size()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        View itemView;

        public Holder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
