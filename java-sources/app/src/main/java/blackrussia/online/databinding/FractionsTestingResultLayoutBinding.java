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

public final class FractionsTestingResultLayoutBinding implements ViewBinding {
    public final ImageView bgEffectShadow;
    public final ImageView bgViewEllipse;
    public final ImageView bgViewRays;
    public final Button buttonNext;
    public final ImageView imageViewSun;
    public final View mainViewTestingResult;
    private final ConstraintLayout rootView;
    public final TextView textViewCorrectAnswers;
    public final TextView textViewDescriptionOfResult;
    public final TextView textViewTitleOfResult;

    private FractionsTestingResultLayoutBinding(ConstraintLayout rootView, ImageView bgEffectShadow, ImageView bgViewEllipse, ImageView bgViewRays, Button buttonNext, ImageView imageViewSun, View mainViewTestingResult, TextView textViewCorrectAnswers, TextView textViewDescriptionOfResult, TextView textViewTitleOfResult) {
        this.rootView = rootView;
        this.bgEffectShadow = bgEffectShadow;
        this.bgViewEllipse = bgViewEllipse;
        this.bgViewRays = bgViewRays;
        this.buttonNext = buttonNext;
        this.imageViewSun = imageViewSun;
        this.mainViewTestingResult = mainViewTestingResult;
        this.textViewCorrectAnswers = textViewCorrectAnswers;
        this.textViewDescriptionOfResult = textViewDescriptionOfResult;
        this.textViewTitleOfResult = textViewTitleOfResult;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsTestingResultLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsTestingResultLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_testing_result_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsTestingResultLayoutBinding bind(View rootView) {
        int i = R.id.bg_effect_shadow;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bg_effect_shadow);
        if (imageView != null) {
            i = R.id.bg_view_ellipse;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bg_view_ellipse);
            if (imageView2 != null) {
                i = R.id.bg_view_rays;
                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.bg_view_rays);
                if (imageView3 != null) {
                    i = R.id.button_next;
                    Button button = (Button) rootView.findViewById(R.id.button_next);
                    if (button != null) {
                        i = R.id.image_view_sun;
                        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.image_view_sun);
                        if (imageView4 != null) {
                            i = R.id.main_view_testing_result;
                            View findViewById = rootView.findViewById(R.id.main_view_testing_result);
                            if (findViewById != null) {
                                i = R.id.text_view_correct_answers;
                                TextView textView = (TextView) rootView.findViewById(R.id.text_view_correct_answers);
                                if (textView != null) {
                                    i = R.id.text_view_description_of_result;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_description_of_result);
                                    if (textView2 != null) {
                                        i = R.id.text_view_title_of_result;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_title_of_result);
                                        if (textView3 != null) {
                                            return new FractionsTestingResultLayoutBinding((ConstraintLayout) rootView, imageView, imageView2, imageView3, button, imageView4, findViewById, textView, textView2, textView3);
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
