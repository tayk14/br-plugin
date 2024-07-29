package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class DrivingSchoolMainItemBinding implements ViewBinding {
    public final View bgMaskDrivingSchool;
    public final View bgPrice;
    public final View drivingSchoolBg;
    public final View drivingSchoolMainItem;
    public final TextView drivingSchoolValuePrice;
    public final ImageView iconDrivingSchool;
    public final ImageView iconIfNoActiveDrivingSchool;
    private final ConstraintLayout rootView;
    public final TextView textIfNotActualDrivingSchool;
    public final TextView titleMainItem;

    private DrivingSchoolMainItemBinding(ConstraintLayout rootView, View bgMaskDrivingSchool, View bgPrice, View drivingSchoolBg, View drivingSchoolMainItem, TextView drivingSchoolValuePrice, ImageView iconDrivingSchool, ImageView iconIfNoActiveDrivingSchool, TextView textIfNotActualDrivingSchool, TextView titleMainItem) {
        this.rootView = rootView;
        this.bgMaskDrivingSchool = bgMaskDrivingSchool;
        this.bgPrice = bgPrice;
        this.drivingSchoolBg = drivingSchoolBg;
        this.drivingSchoolMainItem = drivingSchoolMainItem;
        this.drivingSchoolValuePrice = drivingSchoolValuePrice;
        this.iconDrivingSchool = iconDrivingSchool;
        this.iconIfNoActiveDrivingSchool = iconIfNoActiveDrivingSchool;
        this.textIfNotActualDrivingSchool = textIfNotActualDrivingSchool;
        this.titleMainItem = titleMainItem;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolMainItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolMainItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_main_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolMainItemBinding bind(View rootView) {
        int i = R.id.bg_mask_driving_school;
        View findViewById = rootView.findViewById(R.id.bg_mask_driving_school);
        if (findViewById != null) {
            i = R.id.bg_price;
            View findViewById2 = rootView.findViewById(R.id.bg_price);
            if (findViewById2 != null) {
                i = R.id.driving_school_bg;
                View findViewById3 = rootView.findViewById(R.id.driving_school_bg);
                if (findViewById3 != null) {
                    i = R.id.driving_school_main_item;
                    View findViewById4 = rootView.findViewById(R.id.driving_school_main_item);
                    if (findViewById4 != null) {
                        i = R.id.driving_school_value_price;
                        TextView textView = (TextView) rootView.findViewById(R.id.driving_school_value_price);
                        if (textView != null) {
                            i = R.id.icon_driving_school;
                            ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_driving_school);
                            if (imageView != null) {
                                i = R.id.icon_if_no_active_driving_school;
                                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.icon_if_no_active_driving_school);
                                if (imageView2 != null) {
                                    i = R.id.text_if_not_actual_driving_school;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_if_not_actual_driving_school);
                                    if (textView2 != null) {
                                        i = R.id.title_main_item;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.title_main_item);
                                        if (textView3 != null) {
                                            return new DrivingSchoolMainItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, findViewById4, textView, imageView, imageView2, textView2, textView3);
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
