package com.rockstargames.gtacr.gui.inventory;

import blackrussia.online.network.InvItems;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.rockstargames.gtacr.data.InvActionButtonsData;
import com.rockstargames.gtacr.data.InvMainButtonsData;
import com.rockstargames.gtacr.data.NewInvItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020DR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020;0:¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0:¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=¨\u0006E"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/Constants;", "", "()V", "ACCESSORY", "", "ACTION_APPLY_DIALOG", "ACTION_CAR_TO_USER", "ACTION_CLOSE_DIALOG", "ACTION_DIVIDER", "ACTION_FROM_EXCHANGE_TO_MY", "ACTION_FROM_MY_TO_EXCHANGE", "ACTION_HOME", "ACTION_MES", "ACTION_USER_TO_CAR", "ADD_NEW_ITEM", "ALPHA_IF_NOT_USED", "", "ALPHA_IF_USED", "BUTTON_BLACK_PASS", "BUTTON_CHANGE", "BUTTON_DELETE_ITEM", "BUTTON_DONATE", "BUTTON_INVENTORY", "BUTTON_MENU", "BUTTON_RADIAL_MENU", "BUTTON_STATE", "BUTTON_USE_ITEM", "DEFAULT_ACTION", "DELETE_ITEM", "EDIT_VALUE_OF_MONEY", "EMPTY_NAME", "", "EMPTY_TYPE", "EMPTY_VALUE", "ID_DOCUMENTS", "ID_SIM_CARD", "ID_SKIN", "LAYOUT_EXCHANGE", "LAYOUT_INVENTORY", "MY_ITEM", "OTHER_ITEM", "OTHER_PLAYER", "OTHER_PLAYERS_ITEM", "PREMIUM_GOLD", "PREMIUM_NONE", "PREMIUM_PLATINUM", "PREMIUM_SILVER", "SET_NEW_VALUE_OF_MONEY", "SIM_CARD", "SIZE_EXCHANGE", "SIZE_SLOTS", "STATUS_BOTH_PLAYERS_APPLY_EXCHANGE", "STATUS_NOT_APPLY_EXCHANGE", "STATUS_YOUR_APPLY_EXCHANGE", "VIEW_OTHER_PLAYERS_EXCHANGE", "VIEW_YOUR_EXCHANGE", "YOU", "listActionButtons", "", "Lcom/rockstargames/gtacr/data/InvActionButtonsData;", "getListActionButtons", "()Ljava/util/List;", "listButtons", "Lcom/rockstargames/gtacr/data/InvMainButtonsData;", "getListButtons", "emptyItem", "Lblackrussia/online/network/InvItems;", "emptyNewItem", "Lcom/rockstargames/gtacr/data/NewInvItem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Constants {
    public static final int ACCESSORY = 1;
    public static final int ACTION_APPLY_DIALOG = 11;
    public static final int ACTION_CAR_TO_USER = 2;
    public static final int ACTION_CLOSE_DIALOG = 10;
    public static final int ACTION_DIVIDER = 0;
    public static final int ACTION_FROM_EXCHANGE_TO_MY = 5;
    public static final int ACTION_FROM_MY_TO_EXCHANGE = 4;
    public static final int ACTION_HOME = 3;
    public static final int ACTION_MES = 2;
    public static final int ACTION_USER_TO_CAR = 1;
    public static final int ADD_NEW_ITEM = 1;
    public static final float ALPHA_IF_NOT_USED = 0.2f;
    public static final float ALPHA_IF_USED = 1.0f;
    public static final int BUTTON_BLACK_PASS = 4;
    public static final int BUTTON_CHANGE = 7;
    public static final int BUTTON_DELETE_ITEM = 9;
    public static final int BUTTON_DONATE = 2;
    public static final int BUTTON_INVENTORY = 5;
    public static final int BUTTON_MENU = 0;
    public static final int BUTTON_RADIAL_MENU = 3;
    public static final int BUTTON_STATE = 1;
    public static final int BUTTON_USE_ITEM = 19;
    public static final int DEFAULT_ACTION = 0;
    public static final int DELETE_ITEM = 2;
    public static final int EDIT_VALUE_OF_MONEY = 4;
    public static final String EMPTY_NAME = "";
    public static final int EMPTY_TYPE = 0;
    public static final int EMPTY_VALUE = 0;
    public static final int ID_DOCUMENTS = 346;
    public static final int ID_SIM_CARD = 58;
    public static final int ID_SKIN = 134;
    public static final int LAYOUT_EXCHANGE = 1;
    public static final int LAYOUT_INVENTORY = 0;
    public static final int MY_ITEM = 1;
    public static final int OTHER_ITEM = 0;
    public static final int OTHER_PLAYER = 0;
    public static final int OTHER_PLAYERS_ITEM = 2;
    public static final int PREMIUM_GOLD = 2;
    public static final int PREMIUM_NONE = 0;
    public static final int PREMIUM_PLATINUM = 3;
    public static final int PREMIUM_SILVER = 1;
    public static final int SET_NEW_VALUE_OF_MONEY = 3;
    public static final int SIM_CARD = 2;
    public static final int SIZE_EXCHANGE = 16;
    public static final int SIZE_SLOTS = 8;
    public static final int STATUS_BOTH_PLAYERS_APPLY_EXCHANGE = 2;
    public static final int STATUS_NOT_APPLY_EXCHANGE = 0;
    public static final int STATUS_YOUR_APPLY_EXCHANGE = 1;
    public static final int VIEW_OTHER_PLAYERS_EXCHANGE = 1;
    public static final int VIEW_YOUR_EXCHANGE = 0;
    public static final int YOU = 1;
    public static final Constants INSTANCE = new Constants();
    private static final List<InvMainButtonsData> listButtons = (List<InvMainButtonsData>) CollectionsKt.listOf(new InvMainButtonsData[]{new InvMainButtonsData(0, "Меню", "inv_icon_button_menu_res"), new InvMainButtonsData(1, "Статистика", "inv_icon_button_state_res"), new InvMainButtonsData(2, "Донат", "inv_icon_button_donate_res"), new InvMainButtonsData(3, "Меню действий", "inv_icon_button_radial_menu_res"), new InvMainButtonsData(4, "BLACK PASS", "inv_icon_button_black_pass_res")});
    private static final List<InvActionButtonsData> listActionButtons = (List<InvActionButtonsData>) CollectionsKt.listOf(new InvActionButtonsData[]{new InvActionButtonsData(19, "Использовать", "inv_icon_players_state_bag_res"), new InvActionButtonsData(7, "Обмен", "inv_icon_change_items_res"), new InvActionButtonsData(9, "Удалить", "inv_icon_delete_items_res")});

    private Constants() {
    }

    public final List<InvMainButtonsData> getListButtons() {
        return listButtons;
    }

    public final List<InvActionButtonsData> getListActionButtons() {
        return listActionButtons;
    }

    public final InvItems emptyItem() {
        return new InvItems(0, "", "", 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, "", 0, null, false, 327680, null);
    }

    public final NewInvItem emptyNewItem() {
        return new NewInvItem(0, "", "", 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, "", 0, null, false, -1, 327680, null);
    }
}
