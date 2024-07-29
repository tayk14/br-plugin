package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class DrivingSchoolRadialMenuInfoItemBinding implements ViewBinding {
    public final View blockWithLeftRadialMenu;
    public final View blockWithRightRadialMenu;
    public final View dividerHorizontalUnderline;
    public final ImageView iconLeftAction;
    public final ImageView iconRightAction;
    public final TextView numberLeftAction;
    public final TextView numberRightAction;
    private final ConstraintLayout rootView;
    public final TextView textLeftAction;
    public final TextView textRightAction;
    public final TextView titleLeftAction;
    public final TextView titleRightAction;

    private DrivingSchoolRadialMenuInfoItemBinding(ConstraintLayout rootView, View blockWithLeftRadialMenu, View blockWithRightRadialMenu, View dividerHorizontalUnderline, ImageView iconLeftAction, ImageView iconRightAction, TextView numberLeftAction, TextView numberRightAction, TextView textLeftAction, TextView textRightAction, TextView titleLeftAction, TextView titleRightAction) {
        this.rootView = rootView;
        this.blockWithLeftRadialMenu = blockWithLeftRadialMenu;
        this.blockWithRightRadialMenu = blockWithRightRadialMenu;
        this.dividerHorizontalUnderline = dividerHorizontalUnderline;
        this.iconLeftAction = iconLeftAction;
        this.iconRightAction = iconRightAction;
        this.numberLeftAction = numberLeftAction;
        this.numberRightAction = numberRightAction;
        this.textLeftAction = textLeftAction;
        this.textRightAction = textRightAction;
        this.titleLeftAction = titleLeftAction;
        this.titleRightAction = titleRightAction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolRadialMenuInfoItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolRadialMenuInfoItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_radial_menu_info_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolRadialMenuInfoItemBinding bind(View rootView) {
        int i = R.id.block_with_left_radial_menu;
        View findViewById = rootView.findViewById(R.id.block_with_left_radial_menu);
        if (findViewById != null) {
            i = R.id.block_with_right_radial_menu;
            View findViewById2 = rootView.findViewById(R.id.block_with_right_radial_menu);
            if (findViewById2 != null) {
                i = R.id.divider_horizontal_underline;
                View findViewById3 = rootView.findViewById(R.id.divider_horizontal_underline);
                if (findViewById3 != null) {
                    i = R.id.icon_left_action;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_left_action);
                    if (imageView != null) {
                        i = R.id.icon_right_action;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.icon_right_action);
                        if (imageView2 != null) {
                            i = R.id.number_left_action;
                            TextView textView = (TextView) rootView.findViewById(R.id.number_left_action);
                            if (textView != null) {
                                i = R.id.number_right_action;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.number_right_action);
                                if (textView2 != null) {
                                    i = R.id.text_left_action;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.text_left_action);
                                    if (textView3 != null) {
                                        i = R.id.text_right_action;
                                        TextView textView4 = (TextView) rootView.findViewById(R.id.text_right_action);
                                        if (textView4 != null) {
                                            i = R.id.title_left_action;
                                            TextView textView5 = (TextView) rootView.findViewById(R.id.title_left_action);
                                            if (textView5 != null) {
                                                i = R.id.title_right_action;
                                                TextView textView6 = (TextView) rootView.findViewById(R.id.title_right_action);
                                                if (textView6 != null) {
                                                    return new DrivingSchoolRadialMenuInfoItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, imageView, imageView2, textView, textView2, textView3, textView4, textView5, textView6);
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
