package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class DrivingSchoolClassInfoLayoutBinding implements ViewBinding {
    public final View bgIconRadialMenu;
    public final Button buttonStartPracticeOnSchool;
    public final View dividerVerticalAllInfo;
    public final View dividerVerticalTrafficSigns;
    public final ImageView iconRadialMenu;
    public final View iconScroll;
    public final ConstraintLayout mainBlock;
    public final ImageView menuIcon;
    public final RecyclerView radialMenuItems;
    public final TextView radialTextInfo1;
    public final TextView radialTextInfo2;
    public final TextView radialTextInfo3;
    public final NestedScrollView rootNestedScroll;
    private final ConstraintLayout rootView;
    public final RecyclerView signItems;
    public final TextView textHelpInfo;
    public final TextView titleAllInfo;
    public final TextView titleTrafficSigns;
    public final TextView titleTutor;
    public final TextView typeTutorInfoTitle;

    private DrivingSchoolClassInfoLayoutBinding(ConstraintLayout rootView, View bgIconRadialMenu, Button buttonStartPracticeOnSchool, View dividerVerticalAllInfo, View dividerVerticalTrafficSigns, ImageView iconRadialMenu, View iconScroll, ConstraintLayout mainBlock, ImageView menuIcon, RecyclerView radialMenuItems, TextView radialTextInfo1, TextView radialTextInfo2, TextView radialTextInfo3, NestedScrollView rootNestedScroll, RecyclerView signItems, TextView textHelpInfo, TextView titleAllInfo, TextView titleTrafficSigns, TextView titleTutor, TextView typeTutorInfoTitle) {
        this.rootView = rootView;
        this.bgIconRadialMenu = bgIconRadialMenu;
        this.buttonStartPracticeOnSchool = buttonStartPracticeOnSchool;
        this.dividerVerticalAllInfo = dividerVerticalAllInfo;
        this.dividerVerticalTrafficSigns = dividerVerticalTrafficSigns;
        this.iconRadialMenu = iconRadialMenu;
        this.iconScroll = iconScroll;
        this.mainBlock = mainBlock;
        this.menuIcon = menuIcon;
        this.radialMenuItems = radialMenuItems;
        this.radialTextInfo1 = radialTextInfo1;
        this.radialTextInfo2 = radialTextInfo2;
        this.radialTextInfo3 = radialTextInfo3;
        this.rootNestedScroll = rootNestedScroll;
        this.signItems = signItems;
        this.textHelpInfo = textHelpInfo;
        this.titleAllInfo = titleAllInfo;
        this.titleTrafficSigns = titleTrafficSigns;
        this.titleTutor = titleTutor;
        this.typeTutorInfoTitle = typeTutorInfoTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolClassInfoLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolClassInfoLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_class_info_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolClassInfoLayoutBinding bind(View rootView) {
        int i = R.id.bg_icon_radial_menu;
        View findViewById = rootView.findViewById(R.id.bg_icon_radial_menu);
        if (findViewById != null) {
            i = R.id.button_start_practice_on_school;
            Button button = (Button) rootView.findViewById(R.id.button_start_practice_on_school);
            if (button != null) {
                i = R.id.divider_vertical_all_info;
                View findViewById2 = rootView.findViewById(R.id.divider_vertical_all_info);
                if (findViewById2 != null) {
                    i = R.id.divider_vertical_traffic_signs;
                    View findViewById3 = rootView.findViewById(R.id.divider_vertical_traffic_signs);
                    if (findViewById3 != null) {
                        i = R.id.icon_radial_menu;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_radial_menu);
                        if (imageView != null) {
                            i = R.id.icon_scroll;
                            View findViewById4 = rootView.findViewById(R.id.icon_scroll);
                            if (findViewById4 != null) {
                                i = R.id.main_block;
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView.findViewById(R.id.main_block);
                                if (constraintLayout != null) {
                                    i = R.id.menu_icon;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.menu_icon);
                                    if (imageView2 != null) {
                                        i = R.id.radial_menu_items;
                                        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.radial_menu_items);
                                        if (recyclerView != null) {
                                            i = R.id.radial_text_info_1;
                                            TextView textView = (TextView) rootView.findViewById(R.id.radial_text_info_1);
                                            if (textView != null) {
                                                i = R.id.radial_text_info_2;
                                                TextView textView2 = (TextView) rootView.findViewById(R.id.radial_text_info_2);
                                                if (textView2 != null) {
                                                    i = R.id.radial_text_info_3;
                                                    TextView textView3 = (TextView) rootView.findViewById(R.id.radial_text_info_3);
                                                    if (textView3 != null) {
                                                        i = R.id.root_nested_scroll;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.root_nested_scroll);
                                                        if (nestedScrollView != null) {
                                                            i = R.id.sign_items;
                                                            RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.sign_items);
                                                            if (recyclerView2 != null) {
                                                                i = R.id.text_help_info;
                                                                TextView textView4 = (TextView) rootView.findViewById(R.id.text_help_info);
                                                                if (textView4 != null) {
                                                                    i = R.id.title_all_info;
                                                                    TextView textView5 = (TextView) rootView.findViewById(R.id.title_all_info);
                                                                    if (textView5 != null) {
                                                                        i = R.id.title_traffic_signs;
                                                                        TextView textView6 = (TextView) rootView.findViewById(R.id.title_traffic_signs);
                                                                        if (textView6 != null) {
                                                                            i = R.id.title_tutor;
                                                                            TextView textView7 = (TextView) rootView.findViewById(R.id.title_tutor);
                                                                            if (textView7 != null) {
                                                                                i = R.id.type_tutor_info_title;
                                                                                TextView textView8 = (TextView) rootView.findViewById(R.id.type_tutor_info_title);
                                                                                if (textView8 != null) {
                                                                                    return new DrivingSchoolClassInfoLayoutBinding((ConstraintLayout) rootView, findViewById, button, findViewById2, findViewById3, imageView, findViewById4, constraintLayout, imageView2, recyclerView, textView, textView2, textView3, nestedScrollView, recyclerView2, textView4, textView5, textView6, textView7, textView8);
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
