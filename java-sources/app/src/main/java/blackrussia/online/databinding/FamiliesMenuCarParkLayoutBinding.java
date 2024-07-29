package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMenuCarParkLayoutBinding implements ViewBinding {
    public final RecyclerView actionWithCar;
    public final View bodyRightBlock;
    public final ImageView buttonBackToMenu;
    public final RecyclerView carList;
    public final View leftTitleDiver;
    private final ConstraintLayout rootView;
    public final View tablesTitleLeftBlock;
    public final TextView titleLeftBlock;
    public final TextView titleRightBlock;

    private FamiliesMenuCarParkLayoutBinding(ConstraintLayout rootView, RecyclerView actionWithCar, View bodyRightBlock, ImageView buttonBackToMenu, RecyclerView carList, View leftTitleDiver, View tablesTitleLeftBlock, TextView titleLeftBlock, TextView titleRightBlock) {
        this.rootView = rootView;
        this.actionWithCar = actionWithCar;
        this.bodyRightBlock = bodyRightBlock;
        this.buttonBackToMenu = buttonBackToMenu;
        this.carList = carList;
        this.leftTitleDiver = leftTitleDiver;
        this.tablesTitleLeftBlock = tablesTitleLeftBlock;
        this.titleLeftBlock = titleLeftBlock;
        this.titleRightBlock = titleRightBlock;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuCarParkLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuCarParkLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_car_park_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuCarParkLayoutBinding bind(View rootView) {
        int i = R.id.action_with_car;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.action_with_car);
        if (recyclerView != null) {
            i = R.id.body_right_block;
            View findViewById = rootView.findViewById(R.id.body_right_block);
            if (findViewById != null) {
                i = R.id.button_back_to_menu;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.button_back_to_menu);
                if (imageView != null) {
                    i = R.id.car_list;
                    RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.car_list);
                    if (recyclerView2 != null) {
                        i = R.id.left_title_diver;
                        View findViewById2 = rootView.findViewById(R.id.left_title_diver);
                        if (findViewById2 != null) {
                            i = R.id.tables_title_left_block;
                            View findViewById3 = rootView.findViewById(R.id.tables_title_left_block);
                            if (findViewById3 != null) {
                                i = R.id.title_left_block;
                                TextView textView = (TextView) rootView.findViewById(R.id.title_left_block);
                                if (textView != null) {
                                    i = R.id.title_right_block;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.title_right_block);
                                    if (textView2 != null) {
                                        return new FamiliesMenuCarParkLayoutBinding((ConstraintLayout) rootView, recyclerView, findViewById, imageView, recyclerView2, findViewById2, findViewById3, textView, textView2);
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
