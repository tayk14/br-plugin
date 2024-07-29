package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsNewRankLayoutBinding implements ViewBinding {
    public final ImageView bgEffectShadow;
    public final ImageView bgViewEllipse;
    public final Button buttonGetReward;
    public final ImageView imageViewLavr;
    public final ImageView imageViewStaffRank;
    public final ImageView ivAward1;
    public final ImageView ivAward2;
    public final ImageView ivAward3;
    public final View mainViewNewRank;
    private final ConstraintLayout rootView;
    public final TextView textViewCongratulation;
    public final TextView textViewNewRankReceived;
    public final TextView textViewRank;
    public final TextView textViewReward1;
    public final TextView textViewReward2;
    public final TextView textViewReward3;

    private FractionsNewRankLayoutBinding(ConstraintLayout rootView, ImageView bgEffectShadow, ImageView bgViewEllipse, Button buttonGetReward, ImageView imageViewLavr, ImageView imageViewStaffRank, ImageView ivAward1, ImageView ivAward2, ImageView ivAward3, View mainViewNewRank, TextView textViewCongratulation, TextView textViewNewRankReceived, TextView textViewRank, TextView textViewReward1, TextView textViewReward2, TextView textViewReward3) {
        this.rootView = rootView;
        this.bgEffectShadow = bgEffectShadow;
        this.bgViewEllipse = bgViewEllipse;
        this.buttonGetReward = buttonGetReward;
        this.imageViewLavr = imageViewLavr;
        this.imageViewStaffRank = imageViewStaffRank;
        this.ivAward1 = ivAward1;
        this.ivAward2 = ivAward2;
        this.ivAward3 = ivAward3;
        this.mainViewNewRank = mainViewNewRank;
        this.textViewCongratulation = textViewCongratulation;
        this.textViewNewRankReceived = textViewNewRankReceived;
        this.textViewRank = textViewRank;
        this.textViewReward1 = textViewReward1;
        this.textViewReward2 = textViewReward2;
        this.textViewReward3 = textViewReward3;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsNewRankLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsNewRankLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_new_rank_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsNewRankLayoutBinding bind(View rootView) {
        int i = R.id.bg_effect_shadow;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bg_effect_shadow);
        if (imageView != null) {
            i = R.id.bg_view_ellipse;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bg_view_ellipse);
            if (imageView2 != null) {
                i = R.id.button_get_reward;
                Button button = (Button) rootView.findViewById(R.id.button_get_reward);
                if (button != null) {
                    i = R.id.image_view_lavr;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.image_view_lavr);
                    if (imageView3 != null) {
                        i = R.id.image_view_staff_rank;
                        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.image_view_staff_rank);
                        if (imageView4 != null) {
                            i = R.id.iv_award_1;
                            ImageView imageView5 = (ImageView) rootView.findViewById(R.id.iv_award_1);
                            if (imageView5 != null) {
                                i = R.id.iv_award_2;
                                ImageView imageView6 = (ImageView) rootView.findViewById(R.id.iv_award_2);
                                if (imageView6 != null) {
                                    i = R.id.iv_award_3;
                                    ImageView imageView7 = (ImageView) rootView.findViewById(R.id.iv_award_3);
                                    if (imageView7 != null) {
                                        i = R.id.main_view_new_rank;
                                        View findViewById = rootView.findViewById(R.id.main_view_new_rank);
                                        if (findViewById != null) {
                                            i = R.id.text_view_congratulation;
                                            TextView textView = (TextView) rootView.findViewById(R.id.text_view_congratulation);
                                            if (textView != null) {
                                                i = R.id.text_view_new_rank_received;
                                                TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_new_rank_received);
                                                if (textView2 != null) {
                                                    i = R.id.text_view_rank;
                                                    TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_rank);
                                                    if (textView3 != null) {
                                                        i = R.id.text_view_reward_1;
                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.text_view_reward_1);
                                                        if (textView4 != null) {
                                                            i = R.id.text_view_reward_2;
                                                            TextView textView5 = (TextView) rootView.findViewById(R.id.text_view_reward_2);
                                                            if (textView5 != null) {
                                                                i = R.id.text_view_reward_3;
                                                                TextView textView6 = (TextView) rootView.findViewById(R.id.text_view_reward_3);
                                                                if (textView6 != null) {
                                                                    return new FractionsNewRankLayoutBinding((ConstraintLayout) rootView, imageView, imageView2, button, imageView3, imageView4, imageView5, imageView6, imageView7, findViewById, textView, textView2, textView3, textView4, textView5, textView6);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
