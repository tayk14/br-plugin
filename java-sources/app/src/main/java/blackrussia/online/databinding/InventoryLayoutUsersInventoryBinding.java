package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryLayoutUsersInventoryBinding implements ViewBinding {
    public final CoordinatorLayout coordinatorForSnackbar;
    public final View invBgItemsInBag;
    public final View invBgThisItem;
    public final View invBgTitleInfo;
    public final TextView invDivWeight;
    public final ImageView invIconThisItem;
    public final TextView invInfoThisItem;
    public final RecyclerView invListItemsInInventory;
    public final TextView invSymbolDiv;
    public final TextView invTitleActualWeight;
    public final TextView invTitleBag;
    public final TextView invTitleInventory;
    public final TextView invTitleMaxWeight;
    public final TextView invTitleThisItem;
    public final TextView invTitleTypeWeight;
    public final TextView invTitleWeight;
    public final TextView invValueItemsWeight;
    public final ConstraintLayout playersBlock;
    public final RecyclerView playersButtonsAction;
    public final View playersDonateStatusBg;
    public final ImageView playersDonateStatusIcon;
    public final TextView playersIdValue;
    public final View playersLevelBg;
    public final TextView playersLevelTitle;
    public final TextView playersLevelValue;
    public final View playersNameBg;
    public final TextView playersNameValue;
    public final FrameLayout playersSkinView;
    public final RecyclerView playersSlots;
    public final RecyclerView playersStateInfo;
    private final LinearLayout rootView;

    private InventoryLayoutUsersInventoryBinding(LinearLayout rootView, CoordinatorLayout coordinatorForSnackbar, View invBgItemsInBag, View invBgThisItem, View invBgTitleInfo, TextView invDivWeight, ImageView invIconThisItem, TextView invInfoThisItem, RecyclerView invListItemsInInventory, TextView invSymbolDiv, TextView invTitleActualWeight, TextView invTitleBag, TextView invTitleInventory, TextView invTitleMaxWeight, TextView invTitleThisItem, TextView invTitleTypeWeight, TextView invTitleWeight, TextView invValueItemsWeight, ConstraintLayout playersBlock, RecyclerView playersButtonsAction, View playersDonateStatusBg, ImageView playersDonateStatusIcon, TextView playersIdValue, View playersLevelBg, TextView playersLevelTitle, TextView playersLevelValue, View playersNameBg, TextView playersNameValue, FrameLayout playersSkinView, RecyclerView playersSlots, RecyclerView playersStateInfo) {
        this.rootView = rootView;
        this.coordinatorForSnackbar = coordinatorForSnackbar;
        this.invBgItemsInBag = invBgItemsInBag;
        this.invBgThisItem = invBgThisItem;
        this.invBgTitleInfo = invBgTitleInfo;
        this.invDivWeight = invDivWeight;
        this.invIconThisItem = invIconThisItem;
        this.invInfoThisItem = invInfoThisItem;
        this.invListItemsInInventory = invListItemsInInventory;
        this.invSymbolDiv = invSymbolDiv;
        this.invTitleActualWeight = invTitleActualWeight;
        this.invTitleBag = invTitleBag;
        this.invTitleInventory = invTitleInventory;
        this.invTitleMaxWeight = invTitleMaxWeight;
        this.invTitleThisItem = invTitleThisItem;
        this.invTitleTypeWeight = invTitleTypeWeight;
        this.invTitleWeight = invTitleWeight;
        this.invValueItemsWeight = invValueItemsWeight;
        this.playersBlock = playersBlock;
        this.playersButtonsAction = playersButtonsAction;
        this.playersDonateStatusBg = playersDonateStatusBg;
        this.playersDonateStatusIcon = playersDonateStatusIcon;
        this.playersIdValue = playersIdValue;
        this.playersLevelBg = playersLevelBg;
        this.playersLevelTitle = playersLevelTitle;
        this.playersLevelValue = playersLevelValue;
        this.playersNameBg = playersNameBg;
        this.playersNameValue = playersNameValue;
        this.playersSkinView = playersSkinView;
        this.playersSlots = playersSlots;
        this.playersStateInfo = playersStateInfo;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static InventoryLayoutUsersInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryLayoutUsersInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_layout_users_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryLayoutUsersInventoryBinding bind(View rootView) {
        int i = R.id.coordinator_for_snackbar;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinator_for_snackbar);
        if (coordinatorLayout != null) {
            i = R.id.inv_bg_items_in_bag;
            View findViewById = rootView.findViewById(R.id.inv_bg_items_in_bag);
            if (findViewById != null) {
                i = R.id.inv_bg_this_item;
                View findViewById2 = rootView.findViewById(R.id.inv_bg_this_item);
                if (findViewById2 != null) {
                    i = R.id.inv_bg_title_info;
                    View findViewById3 = rootView.findViewById(R.id.inv_bg_title_info);
                    if (findViewById3 != null) {
                        i = R.id.inv_div_weight;
                        TextView textView = (TextView) rootView.findViewById(R.id.inv_div_weight);
                        if (textView != null) {
                            i = R.id.inv_icon_this_item;
                            ImageView imageView = (ImageView) rootView.findViewById(R.id.inv_icon_this_item);
                            if (imageView != null) {
                                i = R.id.inv_info_this_item;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.inv_info_this_item);
                                if (textView2 != null) {
                                    i = R.id.inv_list_items_in_inventory;
                                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.inv_list_items_in_inventory);
                                    if (recyclerView != null) {
                                        i = R.id.inv_symbol_div;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.inv_symbol_div);
                                        if (textView3 != null) {
                                            i = R.id.inv_title_actual_weight;
                                            TextView textView4 = (TextView) rootView.findViewById(R.id.inv_title_actual_weight);
                                            if (textView4 != null) {
                                                i = R.id.inv_title_bag;
                                                TextView textView5 = (TextView) rootView.findViewById(R.id.inv_title_bag);
                                                if (textView5 != null) {
                                                    i = R.id.inv_title_inventory;
                                                    TextView textView6 = (TextView) rootView.findViewById(R.id.inv_title_inventory);
                                                    if (textView6 != null) {
                                                        i = R.id.inv_title_max_weight;
                                                        TextView textView7 = (TextView) rootView.findViewById(R.id.inv_title_max_weight);
                                                        if (textView7 != null) {
                                                            i = R.id.inv_title_this_item;
                                                            TextView textView8 = (TextView) rootView.findViewById(R.id.inv_title_this_item);
                                                            if (textView8 != null) {
                                                                i = R.id.inv_title_type_weight;
                                                                TextView textView9 = (TextView) rootView.findViewById(R.id.inv_title_type_weight);
                                                                if (textView9 != null) {
                                                                    i = R.id.inv_title_weight;
                                                                    TextView textView10 = (TextView) rootView.findViewById(R.id.inv_title_weight);
                                                                    if (textView10 != null) {
                                                                        i = R.id.inv_value_items_weight;
                                                                        TextView textView11 = (TextView) rootView.findViewById(R.id.inv_value_items_weight);
                                                                        if (textView11 != null) {
                                                                            i = R.id.players_block;
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView.findViewById(R.id.players_block);
                                                                            if (constraintLayout != null) {
                                                                                i = R.id.players_buttons_action;
                                                                                RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.players_buttons_action);
                                                                                if (recyclerView2 != null) {
                                                                                    i = R.id.players_donate_status_bg;
                                                                                    View findViewById4 = rootView.findViewById(R.id.players_donate_status_bg);
                                                                                    if (findViewById4 != null) {
                                                                                        i = R.id.players_donate_status_icon;
                                                                                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.players_donate_status_icon);
                                                                                        if (imageView2 != null) {
                                                                                            i = R.id.players_id_value;
                                                                                            TextView textView12 = (TextView) rootView.findViewById(R.id.players_id_value);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.players_level_bg;
                                                                                                View findViewById5 = rootView.findViewById(R.id.players_level_bg);
                                                                                                if (findViewById5 != null) {
                                                                                                    i = R.id.players_level_title;
                                                                                                    TextView textView13 = (TextView) rootView.findViewById(R.id.players_level_title);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.players_level_value;
                                                                                                        TextView textView14 = (TextView) rootView.findViewById(R.id.players_level_value);
                                                                                                        if (textView14 != null) {
                                                                                                            i = R.id.players_name_bg;
                                                                                                            View findViewById6 = rootView.findViewById(R.id.players_name_bg);
                                                                                                            if (findViewById6 != null) {
                                                                                                                i = R.id.players_name_value;
                                                                                                                TextView textView15 = (TextView) rootView.findViewById(R.id.players_name_value);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = R.id.players_skin_view;
                                                                                                                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.players_skin_view);
                                                                                                                    if (frameLayout != null) {
                                                                                                                        i = R.id.players_slots;
                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.players_slots);
                                                                                                                        if (recyclerView3 != null) {
                                                                                                                            i = R.id.players_state_info;
                                                                                                                            RecyclerView recyclerView4 = (RecyclerView) rootView.findViewById(R.id.players_state_info);
                                                                                                                            if (recyclerView4 != null) {
                                                                                                                                return new InventoryLayoutUsersInventoryBinding((LinearLayout) rootView, coordinatorLayout, findViewById, findViewById2, findViewById3, textView, imageView, textView2, recyclerView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, constraintLayout, recyclerView2, findViewById4, imageView2, textView12, findViewById5, textView13, textView14, findViewById6, textView15, frameLayout, recyclerView3, recyclerView4);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
