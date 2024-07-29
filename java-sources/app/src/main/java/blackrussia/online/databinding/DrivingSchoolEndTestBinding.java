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

public final class DrivingSchoolEndTestBinding implements ViewBinding {
    public final View bgEndTest;
    public final View borderEntTest;
    public final Button buttonStartPractice;
    public final ImageView iconResultFace;
    public final View radialBgEntTest;
    private final ConstraintLayout rootView;
    public final TextView textResultTest;
    public final TextView titleResultTest;
    public final TextView valueResultTest;

    private DrivingSchoolEndTestBinding(ConstraintLayout rootView, View bgEndTest, View borderEntTest, Button buttonStartPractice, ImageView iconResultFace, View radialBgEntTest, TextView textResultTest, TextView titleResultTest, TextView valueResultTest) {
        this.rootView = rootView;
        this.bgEndTest = bgEndTest;
        this.borderEntTest = borderEntTest;
        this.buttonStartPractice = buttonStartPractice;
        this.iconResultFace = iconResultFace;
        this.radialBgEntTest = radialBgEntTest;
        this.textResultTest = textResultTest;
        this.titleResultTest = titleResultTest;
        this.valueResultTest = valueResultTest;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolEndTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolEndTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_end_test, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolEndTestBinding bind(View rootView) {
        int i = R.id.bg_end_test;
        View findViewById = rootView.findViewById(R.id.bg_end_test);
        if (findViewById != null) {
            i = R.id.border_ent_test;
            View findViewById2 = rootView.findViewById(R.id.border_ent_test);
            if (findViewById2 != null) {
                i = R.id.button_start_practice;
                Button button = (Button) rootView.findViewById(R.id.button_start_practice);
                if (button != null) {
                    i = R.id.icon_result_face;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_result_face);
                    if (imageView != null) {
                        i = R.id.radial_bg_ent_test;
                        View findViewById3 = rootView.findViewById(R.id.radial_bg_ent_test);
                        if (findViewById3 != null) {
                            i = R.id.text_result_test;
                            TextView textView = (TextView) rootView.findViewById(R.id.text_result_test);
                            if (textView != null) {
                                i = R.id.title_result_test;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.title_result_test);
                                if (textView2 != null) {
                                    i = R.id.value_result_test;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.value_result_test);
                                    if (textView3 != null) {
                                        return new DrivingSchoolEndTestBinding((ConstraintLayout) rootView, findViewById, findViewById2, button, imageView, findViewById3, textView, textView2, textView3);
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
