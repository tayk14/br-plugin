package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InviteBannerLayoutBinding implements ViewBinding {
    public final Button buttonDownload;
    public final Guideline guidelineBot;
    public final Guideline guidelineCenterHorizontal;
    public final Guideline guidelineCenterVertical;
    public final Guideline guidelineStart;
    public final Guideline guidelineTop;
    public final ImageView imageButtonClose;
    public final ImageView imageViewCars;
    public final ImageView imageViewFastSwimming;
    public final ImageView imageViewPrizesInPayday;
    public final ImageView imageViewSalaries;
    public final ImageView imageViewStartPlayLeftArrows;
    public final ImageView imageViewStartPlayRightArrows;
    public final ImageView imageViewTempX2;
    public final ImageView imageViewVipGold;
    private final ConstraintLayout rootView;
    public final TextView textNewEngine;
    public final TextView textView26;
    public final TextView textViewBonusEnds;
    public final TextView textViewCars;
    public final TextView textViewDescription;
    public final TextView textViewFastSwimming;
    public final TextView textViewHeader;
    public final TextView textViewPrizesInPayday;
    public final TextView textViewPrizesInPaydayTop;
    public final TextView textViewSalaries;
    public final TextView textViewStartPlay;
    public final TextView textViewTempX2;
    public final TextView textViewVipGoldBot;

    private InviteBannerLayoutBinding(ConstraintLayout rootView, Button buttonDownload, Guideline guidelineBot, Guideline guidelineCenterHorizontal, Guideline guidelineCenterVertical, Guideline guidelineStart, Guideline guidelineTop, ImageView imageButtonClose, ImageView imageViewCars, ImageView imageViewFastSwimming, ImageView imageViewPrizesInPayday, ImageView imageViewSalaries, ImageView imageViewStartPlayLeftArrows, ImageView imageViewStartPlayRightArrows, ImageView imageViewTempX2, ImageView imageViewVipGold, TextView textNewEngine, TextView textView26, TextView textViewBonusEnds, TextView textViewCars, TextView textViewDescription, TextView textViewFastSwimming, TextView textViewHeader, TextView textViewPrizesInPayday, TextView textViewPrizesInPaydayTop, TextView textViewSalaries, TextView textViewStartPlay, TextView textViewTempX2, TextView textViewVipGoldBot) {
        this.rootView = rootView;
        this.buttonDownload = buttonDownload;
        this.guidelineBot = guidelineBot;
        this.guidelineCenterHorizontal = guidelineCenterHorizontal;
        this.guidelineCenterVertical = guidelineCenterVertical;
        this.guidelineStart = guidelineStart;
        this.guidelineTop = guidelineTop;
        this.imageButtonClose = imageButtonClose;
        this.imageViewCars = imageViewCars;
        this.imageViewFastSwimming = imageViewFastSwimming;
        this.imageViewPrizesInPayday = imageViewPrizesInPayday;
        this.imageViewSalaries = imageViewSalaries;
        this.imageViewStartPlayLeftArrows = imageViewStartPlayLeftArrows;
        this.imageViewStartPlayRightArrows = imageViewStartPlayRightArrows;
        this.imageViewTempX2 = imageViewTempX2;
        this.imageViewVipGold = imageViewVipGold;
        this.textNewEngine = textNewEngine;
        this.textView26 = textView26;
        this.textViewBonusEnds = textViewBonusEnds;
        this.textViewCars = textViewCars;
        this.textViewDescription = textViewDescription;
        this.textViewFastSwimming = textViewFastSwimming;
        this.textViewHeader = textViewHeader;
        this.textViewPrizesInPayday = textViewPrizesInPayday;
        this.textViewPrizesInPaydayTop = textViewPrizesInPaydayTop;
        this.textViewSalaries = textViewSalaries;
        this.textViewStartPlay = textViewStartPlay;
        this.textViewTempX2 = textViewTempX2;
        this.textViewVipGoldBot = textViewVipGoldBot;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InviteBannerLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InviteBannerLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.invite_banner_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InviteBannerLayoutBinding bind(View rootView) {
        int i = R.id.button_download;
        Button button = (Button) rootView.findViewById(R.id.button_download);
        if (button != null) {
            i = R.id.guideline_bot;
            Guideline guideline = (Guideline) rootView.findViewById(R.id.guideline_bot);
            if (guideline != null) {
                i = R.id.guideline_center_horizontal;
                Guideline guideline2 = (Guideline) rootView.findViewById(R.id.guideline_center_horizontal);
                if (guideline2 != null) {
                    i = R.id.guideline_center_vertical;
                    Guideline guideline3 = (Guideline) rootView.findViewById(R.id.guideline_center_vertical);
                    if (guideline3 != null) {
                        i = R.id.guideline_start;
                        Guideline guideline4 = (Guideline) rootView.findViewById(R.id.guideline_start);
                        if (guideline4 != null) {
                            i = R.id.guideline_top;
                            Guideline guideline5 = (Guideline) rootView.findViewById(R.id.guideline_top);
                            if (guideline5 != null) {
                                i = R.id.image_button_close;
                                ImageView imageView = (ImageView) rootView.findViewById(R.id.image_button_close);
                                if (imageView != null) {
                                    i = R.id.image_view_cars;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.image_view_cars);
                                    if (imageView2 != null) {
                                        i = R.id.image_view_fast_swimming;
                                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.image_view_fast_swimming);
                                        if (imageView3 != null) {
                                            i = R.id.image_view_prizes_in_payday;
                                            ImageView imageView4 = (ImageView) rootView.findViewById(R.id.image_view_prizes_in_payday);
                                            if (imageView4 != null) {
                                                i = R.id.image_view_salaries;
                                                ImageView imageView5 = (ImageView) rootView.findViewById(R.id.image_view_salaries);
                                                if (imageView5 != null) {
                                                    i = R.id.image_view_start_play_left_arrows;
                                                    ImageView imageView6 = (ImageView) rootView.findViewById(R.id.image_view_start_play_left_arrows);
                                                    if (imageView6 != null) {
                                                        i = R.id.image_view_start_play_right_arrows;
                                                        ImageView imageView7 = (ImageView) rootView.findViewById(R.id.image_view_start_play_right_arrows);
                                                        if (imageView7 != null) {
                                                            i = R.id.image_view_temp_x2;
                                                            ImageView imageView8 = (ImageView) rootView.findViewById(R.id.image_view_temp_x2);
                                                            if (imageView8 != null) {
                                                                i = R.id.image_view_vip_gold;
                                                                ImageView imageView9 = (ImageView) rootView.findViewById(R.id.image_view_vip_gold);
                                                                if (imageView9 != null) {
                                                                    i = R.id.text_new_engine;
                                                                    TextView textView = (TextView) rootView.findViewById(R.id.text_new_engine);
                                                                    if (textView != null) {
                                                                        i = R.id.textView26;
                                                                        TextView textView2 = (TextView) rootView.findViewById(R.id.textView26);
                                                                        if (textView2 != null) {
                                                                            i = R.id.text_view_bonus_ends;
                                                                            TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_bonus_ends);
                                                                            if (textView3 != null) {
                                                                                i = R.id.text_view_cars;
                                                                                TextView textView4 = (TextView) rootView.findViewById(R.id.text_view_cars);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.text_view_description;
                                                                                    TextView textView5 = (TextView) rootView.findViewById(R.id.text_view_description);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.text_view_fast_swimming;
                                                                                        TextView textView6 = (TextView) rootView.findViewById(R.id.text_view_fast_swimming);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.text_view_header;
                                                                                            TextView textView7 = (TextView) rootView.findViewById(R.id.text_view_header);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.text_view_prizes_in_payday;
                                                                                                TextView textView8 = (TextView) rootView.findViewById(R.id.text_view_prizes_in_payday);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.text_view_prizes_in_payday_top;
                                                                                                    TextView textView9 = (TextView) rootView.findViewById(R.id.text_view_prizes_in_payday_top);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.text_view_salaries;
                                                                                                        TextView textView10 = (TextView) rootView.findViewById(R.id.text_view_salaries);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.text_view_start_play;
                                                                                                            TextView textView11 = (TextView) rootView.findViewById(R.id.text_view_start_play);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.text_view_temp_x2;
                                                                                                                TextView textView12 = (TextView) rootView.findViewById(R.id.text_view_temp_x2);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.text_view_vip_gold_bot;
                                                                                                                    TextView textView13 = (TextView) rootView.findViewById(R.id.text_view_vip_gold_bot);
                                                                                                                    if (textView13 != null) {
                                                                                                                        return new InviteBannerLayoutBinding((ConstraintLayout) rootView, button, guideline, guideline2, guideline3, guideline4, guideline5, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
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
