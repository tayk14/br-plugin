package blackrussia.online.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import blackrussia.online.R;
import blackrussia.online.activities.StoryActivity;
import blackrussia.online.network.Story;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder> {
    private Activity activity;
    private List<Story> stories = new ArrayList();

    public StoriesAdapter(Activity activity) {
        this.activity = activity;
    }

    public void addItems(List<Story> stories) {
        this.stories = stories;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.stories.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(Story story) {
        this.stories.add(story);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method: onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder; */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method: onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Story story = this.stories.get(position);
        holder.title.setText(story.getTitle());
        Glide.with(this.activity).load(story.getImage()).into(holder.image);
        holder.container.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.adapters.-$$Lambda$StoriesAdapter$NT8I9LfK3wsFh8gO-ulXBLBlxK0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoriesAdapter.this.lambda$onBindViewHolder$1$StoriesAdapter(position, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$StoriesAdapter(final int position, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.button_click));
        new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.adapters.-$$Lambda$StoriesAdapter$dXSxx5Ye4K0D0yVnVrnnbMUamTs
            @Override // java.lang.Runnable
            public final void run() {
                StoriesAdapter.this.lambda$null$0$StoriesAdapter(position);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$0$StoriesAdapter(final int position) {
        Intent intent = new Intent(this.activity, (Class<?>) StoryActivity.class);
        intent.putExtra("position", position);
        this.activity.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.stories.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout container;
        RoundedImageView image;
        View itemView;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            this.container = (FrameLayout) itemView.findViewById(R.id.container);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.image = (RoundedImageView) itemView.findViewById(R.id.image);
            this.itemView = itemView;
        }
    }
}
