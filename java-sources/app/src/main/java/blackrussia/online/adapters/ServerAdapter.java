package blackrussia.online.adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import blackrussia.online.R;
import blackrussia.online.fragments.MonitoringFragment;
import blackrussia.online.network.Server;
import com.dinuscxj.progressbar.CircleProgressBar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.ViewHolder> {
    private MonitoringFragment monitoringFragment;
    private ArrayList<Server> serverList;

    public ServerAdapter(MonitoringFragment monitoringFragment, ArrayList<Server> serverList) {
        this.monitoringFragment = monitoringFragment;
        this.serverList = serverList;
    }

    /* JADX DEBUG: Method merged with bridge method: onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder; */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_server, parent, false));
    }

    /* JADX DEBUG: Method merged with bridge method: onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.backColor.getBackground().setColorFilter(Color.parseColor("#" + this.serverList.get(position).getColor()), PorterDuff.Mode.SRC_ATOP);
        holder.progressBar.setProgressStartColor(Color.parseColor("#" + this.serverList.get(position).getColor()));
        holder.progressBar.setProgressEndColor(Color.parseColor("#" + this.serverList.get(position).getColor()));
        holder.progressBar.setProgress((int) ((Double.parseDouble(this.serverList.get(position).getOnline()) / Double.parseDouble(this.serverList.get(position).getMaxonline())) * 100.0d));
        holder.bearPaw.setColorFilter(Color.parseColor("#" + this.serverList.get(position).getColor()), PorterDuff.Mode.SRC_ATOP);
        holder.people.setColorFilter(Color.parseColor("#" + this.serverList.get(position).getColor()), PorterDuff.Mode.SRC_ATOP);
        holder.x2.setVisibility(this.serverList.get(position).getX2() ? 0 : 8);
        holder.firstName.setText(this.serverList.get(position).getFirstName());
        holder.firstName.setTextColor(Color.parseColor("#" + this.serverList.get(position).getColor()));
        holder.secondName.setText(this.serverList.get(position).getSecondName());
        holder.online.setText(this.serverList.get(position).getOnline());
        holder.onlineTotal.setText(holder.itemView.getContext().getResources().getString(R.string.online_total, this.serverList.get(position).getMaxonline()));
        holder.container.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.adapters.ServerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(ServerAdapter.this.monitoringFragment.getContext(), R.anim.button_click));
                Toast.makeText(ServerAdapter.this.monitoringFragment.getContext(), "Для начала игры нажмите красную кнопку", 0).show();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.serverList.size();
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout backColor;
        private ImageView bearPaw;
        private FrameLayout container;
        private TextView firstName;
        private TextView online;
        private TextView onlineTotal;
        private ImageView people;
        private CircleProgressBar progressBar;
        private TextView secondName;
        private ImageView x2;

        public ViewHolder(View itemView) {
            super(itemView);
            this.backColor = (LinearLayout) itemView.findViewById(R.id.backColor);
            this.progressBar = (CircleProgressBar) itemView.findViewById(R.id.progressBar);
            this.bearPaw = (ImageView) itemView.findViewById(R.id.bearPaw);
            this.people = (ImageView) itemView.findViewById(R.id.people);
            this.x2 = (ImageView) itemView.findViewById(R.id.x2);
            this.firstName = (TextView) itemView.findViewById(R.id.firstName);
            this.secondName = (TextView) itemView.findViewById(R.id.secondName);
            this.online = (TextView) itemView.findViewById(R.id.online);
            this.onlineTotal = (TextView) itemView.findViewById(R.id.onlineTotal);
            this.container = (FrameLayout) itemView.findViewById(R.id.container);
        }
    }
}
