package blackrussia.online.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import blackrussia.online.R;
import blackrussia.online.activities.AuthorizationActivity;
import blackrussia.online.activities.MainActivity;
import blackrussia.online.network.Server;
import com.dinuscxj.progressbar.CircleProgressBar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChooseServerAdapter extends RecyclerView.Adapter<ChooseServerAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<Server> serverList;

    public ChooseServerAdapter(Activity activity, ArrayList<Server> serverList) {
        this.activity = activity;
        this.serverList = serverList;
    }

    /* JADX DEBUG: Method merged with bridge method: onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder; */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_server, parent, false));
    }

    /* JADX DEBUG: Method merged with bridge method: onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
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
        holder.container.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.adapters.-$$Lambda$ChooseServerAdapter$YzWLO1OyU-GzbBGwEAwr-pu984I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseServerAdapter.this.lambda$onBindViewHolder$1$ChooseServerAdapter(position, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$ChooseServerAdapter(final int position, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.button_click));
        new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.adapters.-$$Lambda$ChooseServerAdapter$WuQfbOB1EuCAngQy9v-7avVV5Vo
            @Override // java.lang.Runnable
            public final void run() {
                ChooseServerAdapter.this.lambda$null$0$ChooseServerAdapter(position);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$0$ChooseServerAdapter(final int position) {
        Activity activity = this.activity;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).setServer(position, this.serverList.get(position));
        } else if (activity instanceof AuthorizationActivity) {
            ((AuthorizationActivity) activity).setServer(this.serverList.get(position));
        }
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
