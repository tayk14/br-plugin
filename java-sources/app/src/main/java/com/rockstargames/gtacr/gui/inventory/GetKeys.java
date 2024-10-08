package com.rockstargames.gtacr.gui.inventory;

import kotlin.Metadata;

//@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/GetKeys;", "", "()V", "GET_ITEMS_ID", "", "GET_MAX_SIZE_INVENTORY", "GET_MAX_WEIGHT", "GET_MESSAGE", "GET_NEW_MAX_WEIGHT", "GET_NEW_PLAYERS_STATE", "GET_NEW_SIZE_INVENTORY", "GET_NEW_THIS_WEIGHT", "GET_NUMBER_IN_SLOT", "GET_OTHER_PLAYERS_MONEY", "GET_PLAYERS_ID", "GET_PLAYERS_ITEMS_IN_INV", "GET_PLAYERS_ITEMS_IN_SLOT", "GET_PLAYERS_LEVEL", "GET_PLAYERS_MONEY", "GET_PLAYERS_NICK", "GET_PLAYERS_NICK_WITH_EXCHANGE", "GET_POSITION_TO_SLOT", "GET_STATUS", "GET_THIS_WEIGHT", "GET_TYPE", "GET_TYPE_INTERFACE", "GET_TYPE_VIP", "GET_VALUE", "GET_VALUE_DINNER", "STATUS_CLEAR_INTERFACE", "", "STATUS_CLEAR_OTHER_PLAYERS_ITEMS", "STATUS_FROM_APPLY_TO_EXCHANGE", "STATUS_IS_FALSE", "STATUS_IS_TRUE", "STATUS_OPEN_INVENTORY", "STATUS_TO_DEFAULT", "TYPE_BOTH_PLAYERS_APPLY", "TYPE_CHANGE_DINNER", "TYPE_CHANGE_SKIN", "TYPE_CLICK_BUTTON_BLACK_PASS", "TYPE_CLICK_BUTTON_DONATE", "TYPE_CLICK_BUTTON_EXCHANGE", "TYPE_CLICK_BUTTON_EXCHANGE_APPLY", "TYPE_CLICK_BUTTON_EXCHANGE_CANCEL", "TYPE_CLICK_BUTTON_EXCHANGE_IN_INV", "TYPE_CLICK_BUTTON_EXIT", "TYPE_CLICK_BUTTON_INVENTORY", "TYPE_CLICK_BUTTON_MENU", "TYPE_CLICK_BUTTON_MENU_USING", "TYPE_CLICK_BUTTON_STATISTIC", "TYPE_DELETE_ITEM", "TYPE_EXCHANGE_ITEM_FROM_INV", "TYPE_EXCHANGE_ITEM_TO_INV", "TYPE_GET_OTHER_PLAYERS_MONEY", "TYPE_GET_PLAYERS_NICK", "TYPE_MESSENGER", "TYPE_MIGRATE_ITEM_FROM_SLOT", "TYPE_MIGRATE_ITEM_FROM_SLOT_IN_EXCHANGE", "TYPE_MIGRATE_ITEM_IN_INV", "TYPE_MIGRATE_SIM_CARD_TO_INV", "TYPE_OTHER_PLAYER_ADD_NEW_ITEM", "TYPE_OTHER_PLAYER_EDIT_ITEM", "TYPE_PUT_MONEY", "TYPE_USE_ITEM", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetKeys {
    public static final String GET_ITEMS_ID = "ga";
    public static final String GET_MAX_SIZE_INVENTORY = "sl";
    public static final String GET_MAX_WEIGHT = "mw";
    public static final String GET_MESSAGE = "tx";
    public static final String GET_NEW_MAX_WEIGHT = "nw";
    public static final String GET_NEW_PLAYERS_STATE = "i";
    public static final String GET_NEW_SIZE_INVENTORY = "ns";
    public static final String GET_NEW_THIS_WEIGHT = "w";
    public static final String GET_NUMBER_IN_SLOT = "nm";
    public static final String GET_OTHER_PLAYERS_MONEY = "gm";
    public static final String GET_PLAYERS_ID = "id";
    public static final String GET_PLAYERS_ITEMS_IN_INV = "it";
    public static final String GET_PLAYERS_ITEMS_IN_SLOT = "ai";
    public static final String GET_PLAYERS_LEVEL = "lv";
    public static final String GET_PLAYERS_MONEY = "m";
    public static final String GET_PLAYERS_NICK = "n";
    public static final String GET_PLAYERS_NICK_WITH_EXCHANGE = "en";
    public static final String GET_POSITION_TO_SLOT = "i";
    public static final String GET_STATUS = "s";
    public static final String GET_THIS_WEIGHT = "w";
    public static final String GET_TYPE = "t";
    public static final String GET_TYPE_INTERFACE = "i";
    public static final String GET_TYPE_VIP = "v";
    public static final String GET_VALUE = "s";
    public static final String GET_VALUE_DINNER = "s";
    public static final GetKeys INSTANCE = new GetKeys();
    public static final int STATUS_CLEAR_INTERFACE = 3;
    public static final int STATUS_CLEAR_OTHER_PLAYERS_ITEMS = 5;
    public static final int STATUS_FROM_APPLY_TO_EXCHANGE = 1;
    public static final int STATUS_IS_FALSE = 0;
    public static final int STATUS_IS_TRUE = 1;
    public static final int STATUS_OPEN_INVENTORY = 4;
    public static final int STATUS_TO_DEFAULT = 2;
    public static final int TYPE_BOTH_PLAYERS_APPLY = 26;
    public static final int TYPE_CHANGE_DINNER = 20;
    public static final int TYPE_CHANGE_SKIN = 33;
    public static final int TYPE_CLICK_BUTTON_BLACK_PASS = 14;
    public static final int TYPE_CLICK_BUTTON_DONATE = 12;
    public static final int TYPE_CLICK_BUTTON_EXCHANGE = 8;
    public static final int TYPE_CLICK_BUTTON_EXCHANGE_APPLY = 9;
    public static final int TYPE_CLICK_BUTTON_EXCHANGE_CANCEL = 7;
    public static final int TYPE_CLICK_BUTTON_EXCHANGE_IN_INV = 25;
    public static final int TYPE_CLICK_BUTTON_EXIT = 16;
    public static final int TYPE_CLICK_BUTTON_INVENTORY = 15;
    public static final int TYPE_CLICK_BUTTON_MENU = 10;
    public static final int TYPE_CLICK_BUTTON_MENU_USING = 13;
    public static final int TYPE_CLICK_BUTTON_STATISTIC = 11;
    public static final int TYPE_DELETE_ITEM = 18;
    public static final int TYPE_EXCHANGE_ITEM_FROM_INV = 5;
    public static final int TYPE_EXCHANGE_ITEM_TO_INV = 24;
    public static final int TYPE_GET_OTHER_PLAYERS_MONEY = 3;
    public static final int TYPE_GET_PLAYERS_NICK = 17;
    public static final int TYPE_MESSENGER = 31;
    public static final int TYPE_MIGRATE_ITEM_FROM_SLOT = 4;
    public static final int TYPE_MIGRATE_ITEM_FROM_SLOT_IN_EXCHANGE = 27;
    public static final int TYPE_MIGRATE_ITEM_IN_INV = 23;
    public static final int TYPE_MIGRATE_SIM_CARD_TO_INV = 32;
    public static final int TYPE_OTHER_PLAYER_ADD_NEW_ITEM = 0;
    public static final int TYPE_OTHER_PLAYER_EDIT_ITEM = 1;
    public static final int TYPE_PUT_MONEY = 6;
    public static final int TYPE_USE_ITEM = 19;

    private GetKeys() {
    }
}
