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

public final class FamiliesMenuTheStoreOrTheSafeLayoutBinding implements ViewBinding {
    public final TextView actionTitle;
    public final TextView allMoney;
    public final TextView allMoneyValue;
    public final TextView armor;
    public final TextView armorValue;
    public final View bgStore;
    public final View bodyRightBlock;
    public final View bodyStoreInfo;
    public final View bottomRightBlock;
    public final ImageView buttonBackToMenu;
    public final Button buttonGoToTheContents;
    public final View leftTitleDiver;
    public final View mainBodyStoreInfo;
    public final TextView masks;
    public final TextView masksValue;
    public final TextView materials;
    public final TextView materialsValue;
    public final TextView oil;
    public final TextView oilValue;
    private final ConstraintLayout rootView;
    public final TextView storeTitle;
    public final View tablesTitleLeftBlock;
    public final TextView titleContentsOfTheSafe;
    public final TextView titleLeftBlock;
    public final TextView titleRightBlock;
    public final RecyclerView upgradeList;

    private FamiliesMenuTheStoreOrTheSafeLayoutBinding(ConstraintLayout rootView, TextView actionTitle, TextView allMoney, TextView allMoneyValue, TextView armor, TextView armorValue, View bgStore, View bodyRightBlock, View bodyStoreInfo, View bottomRightBlock, ImageView buttonBackToMenu, Button buttonGoToTheContents, View leftTitleDiver, View mainBodyStoreInfo, TextView masks, TextView masksValue, TextView materials, TextView materialsValue, TextView oil, TextView oilValue, TextView storeTitle, View tablesTitleLeftBlock, TextView titleContentsOfTheSafe, TextView titleLeftBlock, TextView titleRightBlock, RecyclerView upgradeList) {
        this.rootView = rootView;
        this.actionTitle = actionTitle;
        this.allMoney = allMoney;
        this.allMoneyValue = allMoneyValue;
        this.armor = armor;
        this.armorValue = armorValue;
        this.bgStore = bgStore;
        this.bodyRightBlock = bodyRightBlock;
        this.bodyStoreInfo = bodyStoreInfo;
        this.bottomRightBlock = bottomRightBlock;
        this.buttonBackToMenu = buttonBackToMenu;
        this.buttonGoToTheContents = buttonGoToTheContents;
        this.leftTitleDiver = leftTitleDiver;
        this.mainBodyStoreInfo = mainBodyStoreInfo;
        this.masks = masks;
        this.masksValue = masksValue;
        this.materials = materials;
        this.materialsValue = materialsValue;
        this.oil = oil;
        this.oilValue = oilValue;
        this.storeTitle = storeTitle;
        this.tablesTitleLeftBlock = tablesTitleLeftBlock;
        this.titleContentsOfTheSafe = titleContentsOfTheSafe;
        this.titleLeftBlock = titleLeftBlock;
        this.titleRightBlock = titleRightBlock;
        this.upgradeList = upgradeList;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuTheStoreOrTheSafeLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuTheStoreOrTheSafeLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_the_store_or_the_safe_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuTheStoreOrTheSafeLayoutBinding bind(View rootView) {
        int i = R.id.action_title;
        TextView textView = (TextView) rootView.findViewById(R.id.action_title);
        if (textView != null) {
            i = R.id.all_money;
            TextView textView2 = (TextView) rootView.findViewById(R.id.all_money);
            if (textView2 != null) {
                i = R.id.all_money_value;
                TextView textView3 = (TextView) rootView.findViewById(R.id.all_money_value);
                if (textView3 != null) {
                    i = R.id.armor;
                    TextView textView4 = (TextView) rootView.findViewById(R.id.armor);
                    if (textView4 != null) {
                        i = R.id.armor_value;
                        TextView textView5 = (TextView) rootView.findViewById(R.id.armor_value);
                        if (textView5 != null) {
                            i = R.id.bg_store;
                            View findViewById = rootView.findViewById(R.id.bg_store);
                            if (findViewById != null) {
                                i = R.id.body_right_block;
                                View findViewById2 = rootView.findViewById(R.id.body_right_block);
                                if (findViewById2 != null) {
                                    i = R.id.body_store_info;
                                    View findViewById3 = rootView.findViewById(R.id.body_store_info);
                                    if (findViewById3 != null) {
                                        i = R.id.bottom_right_block;
                                        View findViewById4 = rootView.findViewById(R.id.bottom_right_block);
                                        if (findViewById4 != null) {
                                            i = R.id.button_back_to_menu;
                                            ImageView imageView = (ImageView) rootView.findViewById(R.id.button_back_to_menu);
                                            if (imageView != null) {
                                                i = R.id.button_go_to_the_contents;
                                                Button button = (Button) rootView.findViewById(R.id.button_go_to_the_contents);
                                                if (button != null) {
                                                    i = R.id.left_title_diver;
                                                    View findViewById5 = rootView.findViewById(R.id.left_title_diver);
                                                    if (findViewById5 != null) {
                                                        i = R.id.main_body_store_info;
                                                        View findViewById6 = rootView.findViewById(R.id.main_body_store_info);
                                                        if (findViewById6 != null) {
                                                            i = R.id.masks;
                                                            TextView textView6 = (TextView) rootView.findViewById(R.id.masks);
                                                            if (textView6 != null) {
                                                                i = R.id.masks_value;
                                                                TextView textView7 = (TextView) rootView.findViewById(R.id.masks_value);
                                                                if (textView7 != null) {
                                                                    i = R.id.materials;
                                                                    TextView textView8 = (TextView) rootView.findViewById(R.id.materials);
                                                                    if (textView8 != null) {
                                                                        i = R.id.materials_value;
                                                                        TextView textView9 = (TextView) rootView.findViewById(R.id.materials_value);
                                                                        if (textView9 != null) {
                                                                            i = R.id.oil;
                                                                            TextView textView10 = (TextView) rootView.findViewById(R.id.oil);
                                                                            if (textView10 != null) {
                                                                                i = R.id.oil_value;
                                                                                TextView textView11 = (TextView) rootView.findViewById(R.id.oil_value);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.store_title;
                                                                                    TextView textView12 = (TextView) rootView.findViewById(R.id.store_title);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.tables_title_left_block;
                                                                                        View findViewById7 = rootView.findViewById(R.id.tables_title_left_block);
                                                                                        if (findViewById7 != null) {
                                                                                            i = R.id.title_contents_of_the_safe;
                                                                                            TextView textView13 = (TextView) rootView.findViewById(R.id.title_contents_of_the_safe);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.title_left_block;
                                                                                                TextView textView14 = (TextView) rootView.findViewById(R.id.title_left_block);
                                                                                                if (textView14 != null) {
                                                                                                    i = R.id.title_right_block;
                                                                                                    TextView textView15 = (TextView) rootView.findViewById(R.id.title_right_block);
                                                                                                    if (textView15 != null) {
                                                                                                        i = R.id.upgrade_list;
                                                                                                        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.upgrade_list);
                                                                                                        if (recyclerView != null) {
                                                                                                            return new FamiliesMenuTheStoreOrTheSafeLayoutBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, findViewById, findViewById2, findViewById3, findViewById4, imageView, button, findViewById5, findViewById6, textView6, textView7, textView8, textView9, textView10, textView11, textView12, findViewById7, textView13, textView14, textView15, recyclerView);
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
