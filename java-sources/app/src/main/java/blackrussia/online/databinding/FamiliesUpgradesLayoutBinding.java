package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.kingfisher.easyviewindicator.AnyViewIndicator;

public final class FamiliesUpgradesLayoutBinding implements ViewBinding {
    public final RecyclerView allUpgradeParameters;
    public final View bgStore;
    public final View bodyRightBlock;
    public final View bodyUpgradeInfo;
    public final ConstraintLayout bodyUpgradeInfoNewLayout;
    public final ImageView buttonBackToMenu;
    public final Button buttonUpgrade;
    public final View leftTitleDiver;
    public final View mainBodyUpgradeInfo;
    public final TextView moneyOnStore;
    public final TextView moneyOnStoreValue;
    private final ConstraintLayout rootView;
    public final View tablesTitleLeftBlock;
    public final TextView titleLeftBlock;
    public final TextView titleRightBlock;
    public final RecyclerView upgradeList;
    public final TextView upgradeTitle;
    public final AnyViewIndicator viewDotIndicator;

    private FamiliesUpgradesLayoutBinding(ConstraintLayout rootView, RecyclerView allUpgradeParameters, View bgStore, View bodyRightBlock, View bodyUpgradeInfo, ConstraintLayout bodyUpgradeInfoNewLayout, ImageView buttonBackToMenu, Button buttonUpgrade, View leftTitleDiver, View mainBodyUpgradeInfo, TextView moneyOnStore, TextView moneyOnStoreValue, View tablesTitleLeftBlock, TextView titleLeftBlock, TextView titleRightBlock, RecyclerView upgradeList, TextView upgradeTitle, AnyViewIndicator viewDotIndicator) {
        this.rootView = rootView;
        this.allUpgradeParameters = allUpgradeParameters;
        this.bgStore = bgStore;
        this.bodyRightBlock = bodyRightBlock;
        this.bodyUpgradeInfo = bodyUpgradeInfo;
        this.bodyUpgradeInfoNewLayout = bodyUpgradeInfoNewLayout;
        this.buttonBackToMenu = buttonBackToMenu;
        this.buttonUpgrade = buttonUpgrade;
        this.leftTitleDiver = leftTitleDiver;
        this.mainBodyUpgradeInfo = mainBodyUpgradeInfo;
        this.moneyOnStore = moneyOnStore;
        this.moneyOnStoreValue = moneyOnStoreValue;
        this.tablesTitleLeftBlock = tablesTitleLeftBlock;
        this.titleLeftBlock = titleLeftBlock;
        this.titleRightBlock = titleRightBlock;
        this.upgradeList = upgradeList;
        this.upgradeTitle = upgradeTitle;
        this.viewDotIndicator = viewDotIndicator;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesUpgradesLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesUpgradesLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_upgrades_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesUpgradesLayoutBinding bind(View rootView) {
        int i = R.id.all_upgrade_parameters;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.all_upgrade_parameters);
        if (recyclerView != null) {
            i = R.id.bg_store;
            View findViewById = rootView.findViewById(R.id.bg_store);
            if (findViewById != null) {
                i = R.id.body_right_block;
                View findViewById2 = rootView.findViewById(R.id.body_right_block);
                if (findViewById2 != null) {
                    i = R.id.body_upgrade_info;
                    View findViewById3 = rootView.findViewById(R.id.body_upgrade_info);
                    if (findViewById3 != null) {
                        i = R.id.body_upgrade_info_new_layout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView.findViewById(R.id.body_upgrade_info_new_layout);
                        if (constraintLayout != null) {
                            i = R.id.button_back_to_menu;
                            ImageView imageView = (ImageView) rootView.findViewById(R.id.button_back_to_menu);
                            if (imageView != null) {
                                i = R.id.button_upgrade;
                                Button button = (Button) rootView.findViewById(R.id.button_upgrade);
                                if (button != null) {
                                    i = R.id.left_title_diver;
                                    View findViewById4 = rootView.findViewById(R.id.left_title_diver);
                                    if (findViewById4 != null) {
                                        i = R.id.main_body_upgrade_info;
                                        View findViewById5 = rootView.findViewById(R.id.main_body_upgrade_info);
                                        if (findViewById5 != null) {
                                            i = R.id.money_on_store;
                                            TextView textView = (TextView) rootView.findViewById(R.id.money_on_store);
                                            if (textView != null) {
                                                i = R.id.money_on_store_value;
                                                TextView textView2 = (TextView) rootView.findViewById(R.id.money_on_store_value);
                                                if (textView2 != null) {
                                                    i = R.id.tables_title_left_block;
                                                    View findViewById6 = rootView.findViewById(R.id.tables_title_left_block);
                                                    if (findViewById6 != null) {
                                                        i = R.id.title_left_block;
                                                        TextView textView3 = (TextView) rootView.findViewById(R.id.title_left_block);
                                                        if (textView3 != null) {
                                                            i = R.id.title_right_block;
                                                            TextView textView4 = (TextView) rootView.findViewById(R.id.title_right_block);
                                                            if (textView4 != null) {
                                                                i = R.id.upgrade_list;
                                                                RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.upgrade_list);
                                                                if (recyclerView2 != null) {
                                                                    i = R.id.upgrade_title;
                                                                    TextView textView5 = (TextView) rootView.findViewById(R.id.upgrade_title);
                                                                    if (textView5 != null) {
                                                                        i = R.id.view_dot_indicator;
                                                                        AnyViewIndicator anyViewIndicator = (AnyViewIndicator) rootView.findViewById(R.id.view_dot_indicator);
                                                                        if (anyViewIndicator != null) {
                                                                            return new FamiliesUpgradesLayoutBinding((ConstraintLayout) rootView, recyclerView, findViewById, findViewById2, findViewById3, constraintLayout, imageView, button, findViewById4, findViewById5, textView, textView2, findViewById6, textView3, textView4, recyclerView2, textView5, anyViewIndicator);
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
