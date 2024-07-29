package blackrussia.online.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import blackrussia.online.R;
import blackrussia.online.network.Story;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SliderStoriesAdapter extends SliderViewAdapter<SliderStoriesAdapter.Holder> {
    private Context context;
    private List<Story> stories = new ArrayList();

    public SliderStoriesAdapter(Context context) {
        this.context = context;
    }

    public void addItems(List<Story> sliderItems) {
        this.stories = sliderItems;
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

    /* JADX DEBUG: Method merged with bridge method: onCreateViewHolder(Landroid/view/ViewGroup;)Lcom/smarteist/autoimageslider/SliderViewAdapter$ViewHolder; */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.smarteist.autoimageslider.SliderViewAdapter
    public Holder onCreateViewHolder(ViewGroup parent) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_story, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method: onBindViewHolder(Lcom/smarteist/autoimageslider/SliderViewAdapter$ViewHolder;I)V */
    @Override // com.smarteist.autoimageslider.SliderViewAdapter
    public void onBindViewHolder(Holder holder, final int position) {
        final Story story = this.stories.get(position);
        holder.text.setText(story.getText());
        holder.title.setText(story.getTitle());
        Glide.with(this.context).load(story.getImage()).into(holder.image);
        holder.more.setVisibility(story.getLink().isEmpty() ? 8 : 0);
        holder.more.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.adapters.-$$Lambda$SliderStoriesAdapter$jHs2KGpD9SgoIRFdsOKEVB70SV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SliderStoriesAdapter.this.lambda$onBindViewHolder$1$SliderStoriesAdapter(story, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$SliderStoriesAdapter(final Story story, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.button_click));
        new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.adapters.-$$Lambda$SliderStoriesAdapter$rTBvlVklCFdurNPnFNi9kmOCE_w
            @Override // java.lang.Runnable
            public final void run() {
                SliderStoriesAdapter.this.lambda$null$0$SliderStoriesAdapter(story);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$0$SliderStoriesAdapter(final Story story) {
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(story.getLink())));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.stories.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Holder extends SliderViewAdapter.ViewHolder {
        ImageView image;
        View itemView;
        FrameLayout more;
        TextView text;
        TextView title;

        public Holder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.text = (TextView) itemView.findViewById(R.id.text);
            this.image = (ImageView) itemView.findViewById(R.id.image);
            this.more = (FrameLayout) itemView.findViewById(R.id.more);
            this.itemView = itemView;
        }
    }
}
