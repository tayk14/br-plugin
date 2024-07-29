package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class DrivingSchoolMainLayoutBinding implements ViewBinding {
    public final RecyclerView blockWitchTypeSchools;
    public final Button buttonStartCourse;
    private final ConstraintLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView titleDrivingSchool;

    private DrivingSchoolMainLayoutBinding(ConstraintLayout rootView, RecyclerView blockWitchTypeSchools, Button buttonStartCourse, TextView text1, TextView text2, TextView text3, TextView titleDrivingSchool) {
        this.rootView = rootView;
        this.blockWitchTypeSchools = blockWitchTypeSchools;
        this.buttonStartCourse = buttonStartCourse;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.titleDrivingSchool = titleDrivingSchool;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolMainLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_main_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolMainLayoutBinding bind(View rootView) {
        int i = R.id.block_witch_type_schools;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.block_witch_type_schools);
        if (recyclerView != null) {
            i = R.id.button_start_course;
            Button button = (Button) rootView.findViewById(R.id.button_start_course);
            if (button != null) {
                i = R.id.text_1;
                TextView textView = (TextView) rootView.findViewById(R.id.text_1);
                if (textView != null) {
                    i = R.id.text_2;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_2);
                    if (textView2 != null) {
                        i = R.id.text_3;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.text_3);
                        if (textView3 != null) {
                            i = R.id.title_driving_school;
                            TextView textView4 = (TextView) rootView.findViewById(R.id.title_driving_school);
                            if (textView4 != null) {
                                return new DrivingSchoolMainLayoutBinding((ConstraintLayout) rootView, recyclerView, button, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
