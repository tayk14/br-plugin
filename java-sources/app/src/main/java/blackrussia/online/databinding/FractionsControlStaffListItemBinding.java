package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsControlStaffListItemBinding implements ViewBinding {
    public final ImageView imageViewOnline;
    public final ImageView imageViewStaffRank;
    public final ImageView imageViewTopRank;
    public final ProgressBar progressBarRankExperience;
    private final ConstraintLayout rootView;
    public final TextView textViewNickname;
    public final TextView textViewRank;

    private FractionsControlStaffListItemBinding(ConstraintLayout rootView, ImageView imageViewOnline, ImageView imageViewStaffRank, ImageView imageViewTopRank, ProgressBar progressBarRankExperience, TextView textViewNickname, TextView textViewRank) {
        this.rootView = rootView;
        this.imageViewOnline = imageViewOnline;
        this.imageViewStaffRank = imageViewStaffRank;
        this.imageViewTopRank = imageViewTopRank;
        this.progressBarRankExperience = progressBarRankExperience;
        this.textViewNickname = textViewNickname;
        this.textViewRank = textViewRank;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsControlStaffListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsControlStaffListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_control_staff_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsControlStaffListItemBinding bind(View rootView) {
        int i = R.id.image_view_online;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view_online);
        if (imageView != null) {
            i = R.id.image_view_staff_rank;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.image_view_staff_rank);
            if (imageView2 != null) {
                i = R.id.image_view_top_rank;
                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.image_view_top_rank);
                if (imageView3 != null) {
                    i = R.id.progress_bar_rank_experience;
                    ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar_rank_experience);
                    if (progressBar != null) {
                        i = R.id.text_view_nickname;
                        TextView textView = (TextView) rootView.findViewById(R.id.text_view_nickname);
                        if (textView != null) {
                            i = R.id.text_view_rank;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_rank);
                            if (textView2 != null) {
                                return new FractionsControlStaffListItemBinding((ConstraintLayout) rootView, imageView, imageView2, imageView3, progressBar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
