package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryCarTrunkBinding implements ViewBinding {
    public final View carTrunkBgItemsInBag;
    public final View carTrunkBgItemsInCar;
    public final View carTrunkBgMainButtons;
    public final View carTrunkBgNameCar;
    public final View carTrunkBgUsersBag;
    public final View carTrunkBgValuesForBag;
    public final TextView carTrunkDivWeight;
    public final TextView carTrunkDivWeightUsers;
    public final ImageView carTrunkIconBag;
    public final ImageView carTrunkIconBagUsers;
    public final RecyclerView carTrunkListItemsInCar;
    public final RecyclerView carTrunkListItemsInInventory;
    public final ImageButton carTrunkMainButtonExit;
    public final RecyclerView carTrunkMainButtons;
    public final TextView carTrunkTextNameCar;
    public final TextView carTrunkTitleActualWeight;
    public final TextView carTrunkTitleActualWeightUsers;
    public final TextView carTrunkTitleMaxWeight;
    public final TextView carTrunkTitleMaxWeightUsers;
    public final TextView carTrunkTitleTypeWeight;
    public final TextView carTrunkTitleTypeWeightUsers;
    public final TextView carTrunkTitleUsersBag;
    public final TextView carTrunkTitleWeight;
    public final TextView carTrunkTitleWeightUsers;
    public final View familyBg;
    public final RecyclerView playersSlotsInCarTrunk;
    private final ConstraintLayout rootView;

    private InventoryCarTrunkBinding(ConstraintLayout rootView, View carTrunkBgItemsInBag, View carTrunkBgItemsInCar, View carTrunkBgMainButtons, View carTrunkBgNameCar, View carTrunkBgUsersBag, View carTrunkBgValuesForBag, TextView carTrunkDivWeight, TextView carTrunkDivWeightUsers, ImageView carTrunkIconBag, ImageView carTrunkIconBagUsers, RecyclerView carTrunkListItemsInCar, RecyclerView carTrunkListItemsInInventory, ImageButton carTrunkMainButtonExit, RecyclerView carTrunkMainButtons, TextView carTrunkTextNameCar, TextView carTrunkTitleActualWeight, TextView carTrunkTitleActualWeightUsers, TextView carTrunkTitleMaxWeight, TextView carTrunkTitleMaxWeightUsers, TextView carTrunkTitleTypeWeight, TextView carTrunkTitleTypeWeightUsers, TextView carTrunkTitleUsersBag, TextView carTrunkTitleWeight, TextView carTrunkTitleWeightUsers, View familyBg, RecyclerView playersSlotsInCarTrunk) {
        this.rootView = rootView;
        this.carTrunkBgItemsInBag = carTrunkBgItemsInBag;
        this.carTrunkBgItemsInCar = carTrunkBgItemsInCar;
        this.carTrunkBgMainButtons = carTrunkBgMainButtons;
        this.carTrunkBgNameCar = carTrunkBgNameCar;
        this.carTrunkBgUsersBag = carTrunkBgUsersBag;
        this.carTrunkBgValuesForBag = carTrunkBgValuesForBag;
        this.carTrunkDivWeight = carTrunkDivWeight;
        this.carTrunkDivWeightUsers = carTrunkDivWeightUsers;
        this.carTrunkIconBag = carTrunkIconBag;
        this.carTrunkIconBagUsers = carTrunkIconBagUsers;
        this.carTrunkListItemsInCar = carTrunkListItemsInCar;
        this.carTrunkListItemsInInventory = carTrunkListItemsInInventory;
        this.carTrunkMainButtonExit = carTrunkMainButtonExit;
        this.carTrunkMainButtons = carTrunkMainButtons;
        this.carTrunkTextNameCar = carTrunkTextNameCar;
        this.carTrunkTitleActualWeight = carTrunkTitleActualWeight;
        this.carTrunkTitleActualWeightUsers = carTrunkTitleActualWeightUsers;
        this.carTrunkTitleMaxWeight = carTrunkTitleMaxWeight;
        this.carTrunkTitleMaxWeightUsers = carTrunkTitleMaxWeightUsers;
        this.carTrunkTitleTypeWeight = carTrunkTitleTypeWeight;
        this.carTrunkTitleTypeWeightUsers = carTrunkTitleTypeWeightUsers;
        this.carTrunkTitleUsersBag = carTrunkTitleUsersBag;
        this.carTrunkTitleWeight = carTrunkTitleWeight;
        this.carTrunkTitleWeightUsers = carTrunkTitleWeightUsers;
        this.familyBg = familyBg;
        this.playersSlotsInCarTrunk = playersSlotsInCarTrunk;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryCarTrunkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryCarTrunkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_car_trunk, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryCarTrunkBinding bind(View rootView) {
        int i = R.id.car_trunk_bg_items_in_bag;
        View findViewById = rootView.findViewById(R.id.car_trunk_bg_items_in_bag);
        if (findViewById != null) {
            i = R.id.car_trunk_bg_items_in_car;
            View findViewById2 = rootView.findViewById(R.id.car_trunk_bg_items_in_car);
            if (findViewById2 != null) {
                i = R.id.car_trunk_bg_main_buttons;
                View findViewById3 = rootView.findViewById(R.id.car_trunk_bg_main_buttons);
                if (findViewById3 != null) {
                    i = R.id.car_trunk_bg_name_car;
                    View findViewById4 = rootView.findViewById(R.id.car_trunk_bg_name_car);
                    if (findViewById4 != null) {
                        i = R.id.car_trunk_bg_users_bag;
                        View findViewById5 = rootView.findViewById(R.id.car_trunk_bg_users_bag);
                        if (findViewById5 != null) {
                            i = R.id.car_trunk_bg_values_for_bag;
                            View findViewById6 = rootView.findViewById(R.id.car_trunk_bg_values_for_bag);
                            if (findViewById6 != null) {
                                i = R.id.car_trunk_div_weight;
                                TextView textView = (TextView) rootView.findViewById(R.id.car_trunk_div_weight);
                                if (textView != null) {
                                    i = R.id.car_trunk_div_weight_users;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.car_trunk_div_weight_users);
                                    if (textView2 != null) {
                                        i = R.id.car_trunk_icon_bag;
                                        ImageView imageView = (ImageView) rootView.findViewById(R.id.car_trunk_icon_bag);
                                        if (imageView != null) {
                                            i = R.id.car_trunk_icon_bag_users;
                                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.car_trunk_icon_bag_users);
                                            if (imageView2 != null) {
                                                i = R.id.car_trunk_list_items_in_car;
                                                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.car_trunk_list_items_in_car);
                                                if (recyclerView != null) {
                                                    i = R.id.car_trunk_list_items_in_inventory;
                                                    RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.car_trunk_list_items_in_inventory);
                                                    if (recyclerView2 != null) {
                                                        i = R.id.car_trunk_main_button_exit;
                                                        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.car_trunk_main_button_exit);
                                                        if (imageButton != null) {
                                                            i = R.id.car_trunk_main_buttons;
                                                            RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.car_trunk_main_buttons);
                                                            if (recyclerView3 != null) {
                                                                i = R.id.car_trunk_text_name_car;
                                                                TextView textView3 = (TextView) rootView.findViewById(R.id.car_trunk_text_name_car);
                                                                if (textView3 != null) {
                                                                    i = R.id.car_trunk_title_actual_weight;
                                                                    TextView textView4 = (TextView) rootView.findViewById(R.id.car_trunk_title_actual_weight);
                                                                    if (textView4 != null) {
                                                                        i = R.id.car_trunk_title_actual_weight_users;
                                                                        TextView textView5 = (TextView) rootView.findViewById(R.id.car_trunk_title_actual_weight_users);
                                                                        if (textView5 != null) {
                                                                            i = R.id.car_trunk_title_max_weight;
                                                                            TextView textView6 = (TextView) rootView.findViewById(R.id.car_trunk_title_max_weight);
                                                                            if (textView6 != null) {
                                                                                i = R.id.car_trunk_title_max_weight_users;
                                                                                TextView textView7 = (TextView) rootView.findViewById(R.id.car_trunk_title_max_weight_users);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.car_trunk_title_type_weight;
                                                                                    TextView textView8 = (TextView) rootView.findViewById(R.id.car_trunk_title_type_weight);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.car_trunk_title_type_weight_users;
                                                                                        TextView textView9 = (TextView) rootView.findViewById(R.id.car_trunk_title_type_weight_users);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.car_trunk_title_users_bag;
                                                                                            TextView textView10 = (TextView) rootView.findViewById(R.id.car_trunk_title_users_bag);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.car_trunk_title_weight;
                                                                                                TextView textView11 = (TextView) rootView.findViewById(R.id.car_trunk_title_weight);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.car_trunk_title_weight_users;
                                                                                                    TextView textView12 = (TextView) rootView.findViewById(R.id.car_trunk_title_weight_users);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.family_bg;
                                                                                                        View findViewById7 = rootView.findViewById(R.id.family_bg);
                                                                                                        if (findViewById7 != null) {
                                                                                                            i = R.id.players_slots_in_car_trunk;
                                                                                                            RecyclerView recyclerView4 = (RecyclerView) rootView.findViewById(R.id.players_slots_in_car_trunk);
                                                                                                            if (recyclerView4 != null) {
                                                                                                                return new InventoryCarTrunkBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, textView, textView2, imageView, imageView2, recyclerView, recyclerView2, imageButton, recyclerView3, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, findViewById7, recyclerView4);
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
