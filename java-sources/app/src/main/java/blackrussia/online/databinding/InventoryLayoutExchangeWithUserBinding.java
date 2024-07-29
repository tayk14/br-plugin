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
import com.rockstargames.gtacr.gui.inventory.CustomEditText;

public final class InventoryLayoutExchangeWithUserBinding implements ViewBinding {
    public final View exchangeBgButtonChat;
    public final ImageView exchangeBgIconInfo;
    public final View exchangeBgItemsInBag;
    public final View exchangeBgItemsInCar;
    public final View exchangeBgMoneyFromOther;
    public final View exchangeBgPlayersName;
    public final View exchangeBgTextInfo;
    public final View exchangeBgUsersBag;
    public final ImageButton exchangeBgValuesForBag;
    public final TextView exchangeButtonApply;
    public final TextView exchangeButtonCancel;
    public final TextView exchangeDivWeightUsers;
    public final CustomEditText exchangeEdittextMoney;
    public final ImageView exchangeIconBagUsers;
    public final RecyclerView exchangeListItemsInCar;
    public final RecyclerView exchangeListItemsInInventory;
    public final TextView exchangeMoneyFromText;
    public final TextView exchangeMoneyFromTitle;
    public final TextView exchangeTextInfo;
    public final TextView exchangeTextMoney;
    public final TextView exchangeTextOpenChat;
    public final TextView exchangeTextPlayersNick;
    public final TextView exchangeTextValueMessage;
    public final TextView exchangeTitleActualWeightUsers;
    public final TextView exchangeTitleMaxWeightUsers;
    public final TextView exchangeTitleMyMoney;
    public final TextView exchangeTitleTypeWeightUsers;
    public final TextView exchangeTitleUsersBag;
    public final TextView exchangeTitleWeightUsers;
    public final TextView exchangeValueMoneyFrom;
    public final TextView exchangeValueMyMoney;
    public final View helpExchangeView;
    public final RecyclerView playersSlotsInExchange;
    private final ConstraintLayout rootView;

    private InventoryLayoutExchangeWithUserBinding(ConstraintLayout rootView, View exchangeBgButtonChat, ImageView exchangeBgIconInfo, View exchangeBgItemsInBag, View exchangeBgItemsInCar, View exchangeBgMoneyFromOther, View exchangeBgPlayersName, View exchangeBgTextInfo, View exchangeBgUsersBag, ImageButton exchangeBgValuesForBag, TextView exchangeButtonApply, TextView exchangeButtonCancel, TextView exchangeDivWeightUsers, CustomEditText exchangeEdittextMoney, ImageView exchangeIconBagUsers, RecyclerView exchangeListItemsInCar, RecyclerView exchangeListItemsInInventory, TextView exchangeMoneyFromText, TextView exchangeMoneyFromTitle, TextView exchangeTextInfo, TextView exchangeTextMoney, TextView exchangeTextOpenChat, TextView exchangeTextPlayersNick, TextView exchangeTextValueMessage, TextView exchangeTitleActualWeightUsers, TextView exchangeTitleMaxWeightUsers, TextView exchangeTitleMyMoney, TextView exchangeTitleTypeWeightUsers, TextView exchangeTitleUsersBag, TextView exchangeTitleWeightUsers, TextView exchangeValueMoneyFrom, TextView exchangeValueMyMoney, View helpExchangeView, RecyclerView playersSlotsInExchange) {
        this.rootView = rootView;
        this.exchangeBgButtonChat = exchangeBgButtonChat;
        this.exchangeBgIconInfo = exchangeBgIconInfo;
        this.exchangeBgItemsInBag = exchangeBgItemsInBag;
        this.exchangeBgItemsInCar = exchangeBgItemsInCar;
        this.exchangeBgMoneyFromOther = exchangeBgMoneyFromOther;
        this.exchangeBgPlayersName = exchangeBgPlayersName;
        this.exchangeBgTextInfo = exchangeBgTextInfo;
        this.exchangeBgUsersBag = exchangeBgUsersBag;
        this.exchangeBgValuesForBag = exchangeBgValuesForBag;
        this.exchangeButtonApply = exchangeButtonApply;
        this.exchangeButtonCancel = exchangeButtonCancel;
        this.exchangeDivWeightUsers = exchangeDivWeightUsers;
        this.exchangeEdittextMoney = exchangeEdittextMoney;
        this.exchangeIconBagUsers = exchangeIconBagUsers;
        this.exchangeListItemsInCar = exchangeListItemsInCar;
        this.exchangeListItemsInInventory = exchangeListItemsInInventory;
        this.exchangeMoneyFromText = exchangeMoneyFromText;
        this.exchangeMoneyFromTitle = exchangeMoneyFromTitle;
        this.exchangeTextInfo = exchangeTextInfo;
        this.exchangeTextMoney = exchangeTextMoney;
        this.exchangeTextOpenChat = exchangeTextOpenChat;
        this.exchangeTextPlayersNick = exchangeTextPlayersNick;
        this.exchangeTextValueMessage = exchangeTextValueMessage;
        this.exchangeTitleActualWeightUsers = exchangeTitleActualWeightUsers;
        this.exchangeTitleMaxWeightUsers = exchangeTitleMaxWeightUsers;
        this.exchangeTitleMyMoney = exchangeTitleMyMoney;
        this.exchangeTitleTypeWeightUsers = exchangeTitleTypeWeightUsers;
        this.exchangeTitleUsersBag = exchangeTitleUsersBag;
        this.exchangeTitleWeightUsers = exchangeTitleWeightUsers;
        this.exchangeValueMoneyFrom = exchangeValueMoneyFrom;
        this.exchangeValueMyMoney = exchangeValueMyMoney;
        this.helpExchangeView = helpExchangeView;
        this.playersSlotsInExchange = playersSlotsInExchange;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryLayoutExchangeWithUserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryLayoutExchangeWithUserBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_layout_exchange_with_user, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryLayoutExchangeWithUserBinding bind(View rootView) {
        int i = R.id.exchange_bg_button_chat;
        View findViewById = rootView.findViewById(R.id.exchange_bg_button_chat);
        if (findViewById != null) {
            i = R.id.exchange_bg_icon_info;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.exchange_bg_icon_info);
            if (imageView != null) {
                i = R.id.exchange_bg_items_in_bag;
                View findViewById2 = rootView.findViewById(R.id.exchange_bg_items_in_bag);
                if (findViewById2 != null) {
                    i = R.id.exchange_bg_items_in_car;
                    View findViewById3 = rootView.findViewById(R.id.exchange_bg_items_in_car);
                    if (findViewById3 != null) {
                        i = R.id.exchange_bg_money_from_other;
                        View findViewById4 = rootView.findViewById(R.id.exchange_bg_money_from_other);
                        if (findViewById4 != null) {
                            i = R.id.exchange_bg_players_name;
                            View findViewById5 = rootView.findViewById(R.id.exchange_bg_players_name);
                            if (findViewById5 != null) {
                                i = R.id.exchange_bg_text_info;
                                View findViewById6 = rootView.findViewById(R.id.exchange_bg_text_info);
                                if (findViewById6 != null) {
                                    i = R.id.exchange_bg_users_bag;
                                    View findViewById7 = rootView.findViewById(R.id.exchange_bg_users_bag);
                                    if (findViewById7 != null) {
                                        i = R.id.exchange_bg_values_for_bag;
                                        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.exchange_bg_values_for_bag);
                                        if (imageButton != null) {
                                            i = R.id.exchange_button_apply;
                                            TextView textView = (TextView) rootView.findViewById(R.id.exchange_button_apply);
                                            if (textView != null) {
                                                i = R.id.exchange_button_cancel;
                                                TextView textView2 = (TextView) rootView.findViewById(R.id.exchange_button_cancel);
                                                if (textView2 != null) {
                                                    i = R.id.exchange_div_weight_users;
                                                    TextView textView3 = (TextView) rootView.findViewById(R.id.exchange_div_weight_users);
                                                    if (textView3 != null) {
                                                        i = R.id.exchange_edittext_money;
                                                        CustomEditText customEditText = (CustomEditText) rootView.findViewById(R.id.exchange_edittext_money);
                                                        if (customEditText != null) {
                                                            i = R.id.exchange_icon_bag_users;
                                                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.exchange_icon_bag_users);
                                                            if (imageView2 != null) {
                                                                i = R.id.exchange_list_items_in_car;
                                                                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.exchange_list_items_in_car);
                                                                if (recyclerView != null) {
                                                                    i = R.id.exchange_list_items_in_inventory;
                                                                    RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.exchange_list_items_in_inventory);
                                                                    if (recyclerView2 != null) {
                                                                        i = R.id.exchange_money_from_text;
                                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.exchange_money_from_text);
                                                                        if (textView4 != null) {
                                                                            i = R.id.exchange_money_from_title;
                                                                            TextView textView5 = (TextView) rootView.findViewById(R.id.exchange_money_from_title);
                                                                            if (textView5 != null) {
                                                                                i = R.id.exchange_text_info;
                                                                                TextView textView6 = (TextView) rootView.findViewById(R.id.exchange_text_info);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.exchange_text_money;
                                                                                    TextView textView7 = (TextView) rootView.findViewById(R.id.exchange_text_money);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.exchange_text_open_chat;
                                                                                        TextView textView8 = (TextView) rootView.findViewById(R.id.exchange_text_open_chat);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.exchange_text_players_nick;
                                                                                            TextView textView9 = (TextView) rootView.findViewById(R.id.exchange_text_players_nick);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.exchange_text_value_message;
                                                                                                TextView textView10 = (TextView) rootView.findViewById(R.id.exchange_text_value_message);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.exchange_title_actual_weight_users;
                                                                                                    TextView textView11 = (TextView) rootView.findViewById(R.id.exchange_title_actual_weight_users);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.exchange_title_max_weight_users;
                                                                                                        TextView textView12 = (TextView) rootView.findViewById(R.id.exchange_title_max_weight_users);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.exchange_title_my_money;
                                                                                                            TextView textView13 = (TextView) rootView.findViewById(R.id.exchange_title_my_money);
                                                                                                            if (textView13 != null) {
                                                                                                                i = R.id.exchange_title_type_weight_users;
                                                                                                                TextView textView14 = (TextView) rootView.findViewById(R.id.exchange_title_type_weight_users);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = R.id.exchange_title_users_bag;
                                                                                                                    TextView textView15 = (TextView) rootView.findViewById(R.id.exchange_title_users_bag);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = R.id.exchange_title_weight_users;
                                                                                                                        TextView textView16 = (TextView) rootView.findViewById(R.id.exchange_title_weight_users);
                                                                                                                        if (textView16 != null) {
                                                                                                                            i = R.id.exchange_value_money_from;
                                                                                                                            TextView textView17 = (TextView) rootView.findViewById(R.id.exchange_value_money_from);
                                                                                                                            if (textView17 != null) {
                                                                                                                                i = R.id.exchange_value_my_money;
                                                                                                                                TextView textView18 = (TextView) rootView.findViewById(R.id.exchange_value_my_money);
                                                                                                                                if (textView18 != null) {
                                                                                                                                    i = R.id.help_exchange_view;
                                                                                                                                    View findViewById8 = rootView.findViewById(R.id.help_exchange_view);
                                                                                                                                    if (findViewById8 != null) {
                                                                                                                                        i = R.id.players_slots_in_exchange;
                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.players_slots_in_exchange);
                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                            return new InventoryLayoutExchangeWithUserBinding((ConstraintLayout) rootView, findViewById, imageView, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, findViewById7, imageButton, textView, textView2, textView3, customEditText, imageView2, recyclerView, recyclerView2, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, findViewById8, recyclerView3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
