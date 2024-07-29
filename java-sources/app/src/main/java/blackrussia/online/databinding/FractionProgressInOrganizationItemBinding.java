package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionProgressInOrganizationItemBinding implements ViewBinding {
    public final ImageView iconFractionsProgressExperience;
    public final Button imageButtonGetNewRank;
    public final ImageView imageViewStaff;
    public final ProgressBar progressBarStaffExperience;
    private final ConstraintLayout rootView;
    public final TextView textViewRankStatus;
    public final TextView textViewRankUnavailableContactLeader;
    public final TextView textViewStaffLevel;
    public final TextView textViewStaffName;
    public final TextView tvFractionsExperienceFromTo;
    public final View viewRankStatusReceive;
    public final View viewRankStatusReceived;

    private FractionProgressInOrganizationItemBinding(ConstraintLayout rootView, ImageView iconFractionsProgressExperience, Button imageButtonGetNewRank, ImageView imageViewStaff, ProgressBar progressBarStaffExperience, TextView textViewRankStatus, TextView textViewRankUnavailableContactLeader, TextView textViewStaffLevel, TextView textViewStaffName, TextView tvFractionsExperienceFromTo, View viewRankStatusReceive, View viewRankStatusReceived) {
        this.rootView = rootView;
        this.iconFractionsProgressExperience = iconFractionsProgressExperience;
        this.imageButtonGetNewRank = imageButtonGetNewRank;
        this.imageViewStaff = imageViewStaff;
        this.progressBarStaffExperience = progressBarStaffExperience;
        this.textViewRankStatus = textViewRankStatus;
        this.textViewRankUnavailableContactLeader = textViewRankUnavailableContactLeader;
        this.textViewStaffLevel = textViewStaffLevel;
        this.textViewStaffName = textViewStaffName;
        this.tvFractionsExperienceFromTo = tvFractionsExperienceFromTo;
        this.viewRankStatusReceive = viewRankStatusReceive;
        this.viewRankStatusReceived = viewRankStatusReceived;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionProgressInOrganizationItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionProgressInOrganizationItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fraction_progress_in_organization_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionProgressInOrganizationItemBinding bind(View rootView) {
        int i = R.id.icon_fractions_progress_experience;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_fractions_progress_experience);
        if (imageView != null) {
            i = R.id.image_button_get_new_rank;
            Button button = (Button) rootView.findViewById(R.id.image_button_get_new_rank);
            if (button != null) {
                i = R.id.image_view_staff;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.image_view_staff);
                if (imageView2 != null) {
                    i = R.id.progress_bar_staff_experience;
                    ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar_staff_experience);
                    if (progressBar != null) {
                        i = R.id.text_view_rank_status;
                        TextView textView = (TextView) rootView.findViewById(R.id.text_view_rank_status);
                        if (textView != null) {
                            i = R.id.text_view_rank_unavailable_contact_leader;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_rank_unavailable_contact_leader);
                            if (textView2 != null) {
                                i = R.id.text_view_staff_level;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_staff_level);
                                if (textView3 != null) {
                                    i = R.id.text_view_staff_name;
                                    TextView textView4 = (TextView) rootView.findViewById(R.id.text_view_staff_name);
                                    if (textView4 != null) {
                                        i = R.id.tv_fractions_experience_from_to;
                                        TextView textView5 = (TextView) rootView.findViewById(R.id.tv_fractions_experience_from_to);
                                        if (textView5 != null) {
                                            i = R.id.view_rank_status_receive;
                                            View findViewById = rootView.findViewById(R.id.view_rank_status_receive);
                                            if (findViewById != null) {
                                                i = R.id.view_rank_status_received;
                                                View findViewById2 = rootView.findViewById(R.id.view_rank_status_received);
                                                if (findViewById2 != null) {
                                                    return new FractionProgressInOrganizationItemBinding((ConstraintLayout) rootView, imageView, button, imageView2, progressBar, textView, textView2, textView3, textView4, textView5, findViewById, findViewById2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
