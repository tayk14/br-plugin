package com.rockstargames.gtacr.gui.inventory;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.InventoryCarTrunkBinding;
import blackrussia.online.databinding.InventoryDialogValueApplyBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.CarTrunkButtonsAdapter;
import com.rockstargames.gtacr.adapters.InventoryExchangeAndTrunkAdapter;
import com.rockstargames.gtacr.adapters.InventoryItemsInSlotAdapter;
import com.rockstargames.gtacr.data.InvMainButtonsData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b?\b\u0007\u0018\u0000 \u009a\u00012\u00020\u000126\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002j\u0002`\n:\u0002\u009a\u0001B\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010W\u001a\u00020\tH\u0002J\b\u0010X\u001a\u00020\tH\u0002J\b\u0010Y\u001a\u00020\tH\u0002J\u0012\u0010Z\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020\tH\u0002J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010_\u001a\u00020\u001bH\u0016J\b\u0010`\u001a\u0004\u0018\u00010$J\u0012\u0010a\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u0019\u0010b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002J\b\u0010c\u001a\u00020,H\u0016J\u0018\u0010d\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u001bH\u0002J\b\u0010f\u001a\u00020\tH\u0002J\b\u0010g\u001a\u00020\tH\u0002J\b\u0010h\u001a\u00020\tH\u0002J\u0012\u0010i\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010j\u001a\u00020\tH\u0002J\b\u0010k\u001a\u00020\tH\u0002J\b\u0010l\u001a\u00020\tH\u0002J\u0010\u0010m\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010n\u001a\u00020\tH\u0002J\u0010\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020\u001bH\u0002J\u0010\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\u001bH\u0002J\u0016\u0010s\u001a\u00020\t2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u000fH\u0002J\u0016\u0010t\u001a\u00020\t2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020A0\u000fH\u0002J\u0016\u0010v\u001a\u00020\t2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020A0\u000fH\u0002J\b\u0010x\u001a\u00020\tH\u0002J\b\u0010y\u001a\u00020\tH\u0002J\b\u0010z\u001a\u00020\tH\u0002J\b\u0010{\u001a\u00020\tH\u0002J\b\u0010|\u001a\u00020\tH\u0002J\u0010\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u001bH\u0002J\u0010\u0010\u007f\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u001bH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\t\u0010\u0081\u0001\u001a\u00020\tH\u0002J\t\u0010\u0082\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\u001bH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u001bH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\u001bH\u0002J)\u0010\u0089\u0001\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010*2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010$H\u0016J\t\u0010\u008c\u0001\u001a\u00020\tH\u0002J*\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u00102\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0007\u0010\u0090\u0001\u001a\u00020\u001bH\u0002J*\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u00102\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u001bH\u0002J*\u0010\u0094\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u00102\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u001bH\u0002J$\u0010\u0095\u0001\u001a\u00020\t2\u0007\u0010\u0096\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010\u0097\u0001\u001a\u00020,H\u0002J\u0012\u0010\u0098\u0001\u001a\u00020\t2\u0007\u0010\u0099\u0001\u001a\u00020\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000RB\u0010\u0019\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0002j\u0002`\u001dX\u0082.¢\u0006\u0002\n\u0000RY\u0010\u001e\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\t0\u001fj\u0002`\"X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010>\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0002j\u0002`\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020A0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000RB\u0010U\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0002j\u0002`\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/GUICarsTrunkOrCloset;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/InvMainButtonsData;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "mainButton", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/gui/inventory/OnMainButtonsClickListener;", "()V", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/inventory/ActionsWithJSON;", "allItems", "", "Lblackrussia/online/network/InvItems;", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/InventoryCarTrunkBinding;", "bindingDialogApply", "Lblackrussia/online/databinding/InventoryDialogValueApplyBinding;", "carsAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryExchangeAndTrunkAdapter;", "carsItemClickListener", "item", "", "position", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "clickDialogMenu", "Lkotlin/Function3;", "action", "applyAction", "Lcom/rockstargames/gtacr/gui/inventory/ActionListenerFromDialogApply;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "dialogApplyMigrate", "Lcom/rockstargames/gtacr/gui/inventory/LogicForMigrateItemsInCar;", "dialogApplyPopupWindow", "Landroid/widget/PopupWindow;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "ifClickOtherButtonWithDismiss", "", "inflater", "Landroid/view/LayoutInflater;", "intermediatePositionFromCarsList", "intermediatePositionFromSlot", "intermediatePositionFromUsersList", "itemsInSlotAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter;", "itemsInSlots", "mainButtonsAdapter", "Lcom/rockstargames/gtacr/adapters/CarTrunkButtonsAdapter;", "maxOtherWeight", "maxPlayersWeight", "migrateCounter", "oldTimeAfterCheck", "", "oldTimeMigrate", "oldValue", "onItemsInSlotClickListener", "otherItems", "otherItemsAny", "", "playersItemsInInventoryAny", "playersItemsInSlotAny", "popupWindow", "positionFromCarsList", "positionFromSlot", "positionFromUsersList", "positionIfThereIsFoldZero", "simCard", "simCardsNumber", "sizeCarsTrunkOrCloset", "sizeSlots", "slotsInInventory", "slotsOther", "status", "statusCarOrHome", "thisOtherWeight", "thisPlayersWeight", "typeInterface", "usersAdapter", "usersItemClickListener", "usersItems", "clearInfoAboutOtherItem", "clearInfoAboutSlot", "clearInfoAboutUsersItem", "close", "json", "Lorg/json/JSONObject;", "closePopupWindowApply", "getAllItems", "getGuiId", "getMainContext", "getStartData", "invoke", "isShowingGui", "mainButtonsClickListener", "typeButton", "migrateDataFromCarToUser", "migrateDataFromSlotToUser", "migrateDataFromUserToCar", "onPacketIncoming", "setDataInCarsList", "setDataInSlotsView", "setDataInUsersList", "setEmptyItem", "setEmptySlotInSlots", "setEmptySlotsInOtherList", "slotOther", "setEmptySlotsInUsersList", "slotInventory", "setItemsInOtherSlots", "setItemsInSlot", "itemInSlotAny", "setItemsInUsersSlots", "playersItemsAny", "setLogicForCarsItemClickListener", "setLogicForClickInSlot", "setLogicForDialogApply", "setLogicForUsersItemClickListener", "setMainButtonsInView", "setMaxOtherWeight", "maxWeight", "setMaxPlayersWeight", "setObjectSimCard", "setOldValueOnMyList", "setOldValueOnOtherList", "setSimCardInSlot", "phoneNumber", "setStartParameters", "setThisOtherWeight", "thisWeight", "setThisPlayersWeight", "show", "manager", "activity", "startPopupWindowApply", "subtractionFromList", "migrateItem", "oldList", "positionInOldList", "updateDataAfterMigrate", "newList", "positionInNewList", "updateDataAfterMigrateToSlot", "updateItemAfterMigrate", "thisItem", "ifToSlot", "updateSizeInventory", "newSize", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUICarsTrunkOrCloset implements ISAMPGUI, Function2<InvMainButtonsData, View, Unit> {
    public static final Companion Companion = new Companion(null);
    private ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private InventoryCarTrunkBinding binding;
    private InventoryDialogValueApplyBinding bindingDialogApply;
    private InventoryExchangeAndTrunkAdapter carsAdapter;
    private Function2<? super InvItems, ? super Integer, Unit> carsItemClickListener;
    private Function3<? super InvItems, ? super Integer, ? super Integer, Unit> clickDialogMenu;
    private NvEventQueueActivity context;
    private LogicForMigrateItemsInCar dialogApplyMigrate;
    private PopupWindow dialogApplyPopupWindow;
    private GUIManager guiManager;
    private boolean ifClickOtherButtonWithDismiss;
    private LayoutInflater inflater;
    private InventoryItemsInSlotAdapter itemsInSlotAdapter;
    private CarTrunkButtonsAdapter mainButtonsAdapter;
    private int maxOtherWeight;
    private int maxPlayersWeight;
    private int migrateCounter;
    private long oldTimeAfterCheck;
    private long oldTimeMigrate;
    private int oldValue;
    private Function2<? super InvItems, ? super Integer, Unit> onItemsInSlotClickListener;
    private PopupWindow popupWindow;
    private int simCardsNumber;
    private int sizeCarsTrunkOrCloset;
    private int slotsInInventory;
    private int slotsOther;
    private int status;
    private int statusCarOrHome;
    private int thisOtherWeight;
    private int thisPlayersWeight;
    private int typeInterface;
    private InventoryExchangeAndTrunkAdapter usersAdapter;
    private Function2<? super InvItems, ? super Integer, Unit> usersItemClickListener;
    private List<InvItems> usersItems = new ArrayList();
    private List<InvItems> otherItems = new ArrayList();
    private int positionFromCarsList = -1;
    private int positionFromUsersList = -1;
    private int intermediatePositionFromCarsList = -1;
    private int intermediatePositionFromUsersList = -1;
    private final int sizeSlots = 8;
    private List<InvItems> itemsInSlots = new ArrayList();
    private int positionFromSlot = -1;
    private int intermediatePositionFromSlot = -1;
    private List<Object> playersItemsInInventoryAny = new ArrayList();
    private List<Object> playersItemsInSlotAny = new ArrayList();
    private List<Object> otherItemsAny = new ArrayList();
    private List<InvItems> allItems = new ArrayList();
    private InvItems simCard = Constants.INSTANCE.emptyItem();
    private int positionIfThereIsFoldZero = -1;

    @Override
    public int getGuiId() {
        return 34;
    }

    @Override
    public Unit invoke(InvMainButtonsData invMainButtonsData, View view) {
        invoke2(invMainButtonsData, view);
        return Unit.INSTANCE;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/GUICarsTrunkOrCloset$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/inventory/GUICarsTrunkOrCloset;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GUICarsTrunkOrCloset newInstance() {
            return new GUICarsTrunkOrCloset();
        }
    }

    public final NvEventQueueActivity getMainContext() {
        return this.context;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("t"));
        Integer valueOf2 = jSONObject != null ? Integer.valueOf(jSONObject.optInt("s")) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                setOldValueOnMyList();
            } else if (valueOf2 != null && valueOf2.intValue() == 1) {
                int optInt = jSONObject.optInt("w");
                int optInt2 = jSONObject.optInt("bw");
                setThisPlayersWeight(optInt);
                setThisOtherWeight(optInt2);
                if (this.intermediatePositionFromCarsList != -1 && this.intermediatePositionFromUsersList != -1) {
                    migrateDataFromUserToCar();
                }
            }
            clearInfoAboutOtherItem();
            clearInfoAboutUsersItem();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                setOldValueOnOtherList();
            } else if (valueOf2 != null && valueOf2.intValue() == 1) {
                int optInt3 = jSONObject.optInt("w");
                int optInt4 = jSONObject.optInt("bw");
                setThisPlayersWeight(optInt3);
                setThisOtherWeight(optInt4);
                if (this.intermediatePositionFromCarsList != -1 && this.intermediatePositionFromUsersList != -1) {
                    migrateDataFromCarToUser();
                }
            }
            clearInfoAboutOtherItem();
            clearInfoAboutUsersItem();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if ((valueOf2 == null || valueOf2.intValue() != 0) && valueOf2 != null && valueOf2.intValue() == 1) {
                int optInt5 = jSONObject.optInt(GetKeys.GET_NEW_MAX_WEIGHT);
                int optInt6 = jSONObject.optInt(GetKeys.GET_NEW_SIZE_INVENTORY);
                setMaxPlayersWeight(optInt5);
                updateSizeInventory(optInt6);
                if (this.intermediatePositionFromUsersList != -1 && this.intermediatePositionFromSlot != -1) {
                    migrateDataFromSlotToUser();
                }
            }
            clearInfoAboutSlot();
        } else if (valueOf != null && valueOf.intValue() == 9) {
            if ((valueOf2 == null || valueOf2.intValue() != 0) && valueOf2 != null && valueOf2.intValue() == 1 && this.intermediatePositionFromUsersList != -1 && this.intermediatePositionFromSlot != -1) {
                migrateDataFromSlotToUser();
            }
            clearInfoAboutSlot();
        }
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity nvEventQueueActivity) {
        this.context = nvEventQueueActivity;
        this.guiManager = gUIManager;
        this.actionsWithJSON = new ActionsWithJSON(gUIManager);
        this.status = 0;
        InventoryCarTrunkBinding inventoryCarTrunkBinding = null;
        if (this.popupWindow == null) {
            Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            this.inflater = layoutInflater;
            if (layoutInflater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflater");
                layoutInflater = null;
            }
            InventoryCarTrunkBinding inflate = InventoryCarTrunkBinding.inflate(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            this.anim = loadAnimation;
            InventoryCarTrunkBinding inventoryCarTrunkBinding2 = this.binding;
            if (inventoryCarTrunkBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryCarTrunkBinding2 = null;
            }
            this.popupWindow = new PopupWindow((View) inventoryCarTrunkBinding2.getRoot(), -1, -1, true);
            this.allItems.addAll(getAllItems());
            setMainButtonsInView();
            setLogicForDialogApply();
            setLogicForUsersItemClickListener();
            setLogicForCarsItemClickListener();
            setDataInUsersList();
            setDataInCarsList();
            getStartData(jSONObject);
            setStartParameters(this.typeInterface);
            setEmptySlotInSlots();
            setLogicForClickInSlot();
            setDataInSlotsView();
            setItemsInUsersSlots(this.playersItemsInInventoryAny);
            setItemsInOtherSlots(this.otherItemsAny);
            setItemsInSlot(this.playersItemsInSlotAny);
            setSimCardInSlot(this.simCardsNumber);
        }
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 != null) {
            nvEventQueueActivity2.toggleDrawing2dStuff(true);
        }
        PopupWindow popupWindow = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(nvEventQueueActivity == null ? null : nvEventQueueActivity.getParentLayout(), 17, 0, 0);
        }
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUICarsTrunkOrCloset.m310show$lambda1(GUICarsTrunkOrCloset.this);
                }
            });
        }
        InventoryCarTrunkBinding inventoryCarTrunkBinding3 = this.binding;
        if (inventoryCarTrunkBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryCarTrunkBinding = inventoryCarTrunkBinding3;
        }
        inventoryCarTrunkBinding.carTrunkMainButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUICarsTrunkOrCloset.m311show$lambda2(GUICarsTrunkOrCloset.this, view);
            }
        });
    }

    public static final void m310show$lambda1(GUICarsTrunkOrCloset this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity != null) {
            //nvEventQueueActivity.toggleDrawing2dStuff(false);
        }
        if (!this$0.ifClickOtherButtonWithDismiss) {
            ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
            if (actionsWithJSON == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                actionsWithJSON = null;
            }
            actionsWithJSON.sendPressButton(8);
        }
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager == null) {
            return;
        }
        gUIManager.closeGUI(null, 34);
    }

    public static final void m311show$lambda2(GUICarsTrunkOrCloset this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ifClickOtherButtonWithDismiss = false;
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void setMainButtonsInView() {
        this.mainButtonsAdapter = new CarTrunkButtonsAdapter(this, Constants.INSTANCE.getListButtons(), this);
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        CarTrunkButtonsAdapter carTrunkButtonsAdapter = null;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        RecyclerView recyclerView = inventoryCarTrunkBinding.carTrunkMainButtons;
        InventoryCarTrunkBinding inventoryCarTrunkBinding2 = this.binding;
        if (inventoryCarTrunkBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryCarTrunkBinding2.getRoot().getContext(), 1, false));
        CarTrunkButtonsAdapter carTrunkButtonsAdapter2 = this.mainButtonsAdapter;
        if (carTrunkButtonsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainButtonsAdapter");
        } else {
            carTrunkButtonsAdapter = carTrunkButtonsAdapter2;
        }
        recyclerView.setAdapter(carTrunkButtonsAdapter);
    }

    private final void setStartParameters(int i) {
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity != null) {
            if (i == 0) {
                inventoryCarTrunkBinding.carTrunkTextNameCar.setText(nvEventQueueActivity.getText(R.string.inv_text_car_trunk));
                inventoryCarTrunkBinding.familyBg.setVisibility(8);
                if (Build.VERSION.SDK_INT >= 23) {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.transparent, null));
                } else {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.transparent));
                }
                this.statusCarOrHome = 1;
                inventoryCarTrunkBinding.carTrunkMainButtons.setVisibility(0);
            } else if (i == 1) {
                inventoryCarTrunkBinding.carTrunkTextNameCar.setText(nvEventQueueActivity.getText(R.string.inv_text_closet));
                inventoryCarTrunkBinding.familyBg.setVisibility(8);
                if (Build.VERSION.SDK_INT >= 23) {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.transparent, null));
                } else {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.transparent));
                }
                this.statusCarOrHome = 3;
                inventoryCarTrunkBinding.carTrunkMainButtons.setVisibility(0);
            } else if (i == 2) {
                inventoryCarTrunkBinding.carTrunkTextNameCar.setText(nvEventQueueActivity.getText(R.string.inv_text_family_safe));
                inventoryCarTrunkBinding.familyBg.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 23) {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.color_1F2024, null));
                } else {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.color_1F2024));
                }
                inventoryCarTrunkBinding.carTrunkMainButtons.setVisibility(4);
            } else if (i == 3) {
                inventoryCarTrunkBinding.carTrunkTextNameCar.setText(nvEventQueueActivity.getText(R.string.inv_text_ship_trunk));
                inventoryCarTrunkBinding.familyBg.setVisibility(8);
                if (Build.VERSION.SDK_INT >= 23) {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.transparent, null));
                } else {
                    inventoryCarTrunkBinding.getRoot().setBackgroundColor(nvEventQueueActivity.getResources().getColor(R.color.transparent));
                }
                this.statusCarOrHome = 1;
                inventoryCarTrunkBinding.carTrunkMainButtons.setVisibility(0);
            }
        }
        setThisPlayersWeight(this.thisPlayersWeight);
        setMaxPlayersWeight(this.maxPlayersWeight);
        setEmptySlotsInUsersList(this.slotsInInventory);
        setThisOtherWeight(this.thisOtherWeight);
        setMaxOtherWeight(this.maxOtherWeight);
        setEmptySlotsInOtherList(this.slotsOther);
    }

    private final void setThisPlayersWeight(int i) {
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        inventoryCarTrunkBinding.carTrunkTitleActualWeightUsers.setText(String.valueOf(i));
    }

    private final void setMaxPlayersWeight(int i) {
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        inventoryCarTrunkBinding.carTrunkTitleMaxWeightUsers.setText(String.valueOf(i));
    }

    private final void setEmptySlotsInUsersList(int i) {
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                this.usersItems.add(Constants.INSTANCE.emptyItem());
                if (i2 == i) {
                    break;
                }
                i2 = i3;
            }
        }
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        inventoryCarTrunkBinding.carTrunkListItemsInInventory.setItemViewCacheSize(i);
    }

    private final void setThisOtherWeight(int i) {
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        inventoryCarTrunkBinding.carTrunkTitleActualWeight.setText(String.valueOf(i));
    }

    private final void setMaxOtherWeight(int i) {
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        inventoryCarTrunkBinding.carTrunkTitleMaxWeight.setText(String.valueOf(i));
    }

    private final void setEmptySlotsInOtherList(int i) {
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                this.otherItems.add(Constants.INSTANCE.emptyItem());
                if (i2 == i) {
                    break;
                }
                i2 = i3;
            }
        }
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        inventoryCarTrunkBinding.carTrunkListItemsInCar.setItemViewCacheSize(i);
    }

    private final void setItemsInUsersSlots(List<Object> list) {
        MigrateItemsFromAny migrateItemsFromAny = new MigrateItemsFromAny();
        migrateItemsFromAny.migrateDataFromAnyToObject(list, this.usersItems, false);
        migrateItemsFromAny.addOtherParametersInList(this.usersItems, this.allItems);
    }

    private final void setItemsInOtherSlots(List<Object> list) {
        MigrateItemsFromAny migrateItemsFromAny = new MigrateItemsFromAny();
        migrateItemsFromAny.migrateDataFromAnyToObject(list, this.otherItems, false);
        migrateItemsFromAny.addOtherParametersInList(this.otherItems, this.allItems);
    }

    private final void setItemsInSlot(List<Object> list) {
        MigrateItemsFromAny migrateItemsFromAny = new MigrateItemsFromAny();
        migrateItemsFromAny.migrateDataFromAnyToObject(list, this.itemsInSlots, true);
        migrateItemsFromAny.addOtherParametersInList(this.itemsInSlots, this.allItems);
    }

    private final void setSimCardInSlot(int i) {
        if (i == 0) {
            setEmptyItem(this.itemsInSlots.get(0));
            return;
        }
        InvItems invItems = this.simCard;
        invItems.setTextIfException(String.valueOf(i));
        this.itemsInSlots.remove(0);
        this.itemsInSlots.add(0, invItems);
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
        if (inventoryItemsInSlotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            inventoryItemsInSlotAdapter = null;
        }
        inventoryItemsInSlotAdapter.notifyItemChanged(0);
    }

    private final List<InvItems> getAllItems() {
        ArrayList<InvItems> invItems = App.getInstance().getInvItems();
        Intrinsics.checkNotNullExpressionValue(invItems, "getInstance().invItems");
        ArrayList<InvItems> arrayList = invItems;
        for (InvItems invItems2 : arrayList) {
            invItems2.setItemsValue(0);
            invItems2.setTextIfException("");
            invItems2.setWhoseItem(0);
            invItems2.setCheck(false);
            if (invItems2.getId() == 58) {
                setObjectSimCard(invItems2);
            }
        }
        return arrayList;
    }

    private final void setObjectSimCard(InvItems invItems) {
        InvItems invItems2 = this.simCard;
        invItems2.setId(invItems.getId());
        invItems2.setName(invItems.getName());
        invItems2.setDesc(invItems.getDesc());
        invItems2.setModelid(invItems.getModelid());
        invItems2.setWeight(invItems.getWeight());
        invItems2.setAddw(invItems.getAddw());
        invItems2.setFold(invItems.getFold());
        invItems2.setShiftX(invItems.getShiftX());
        invItems2.setShiftY(invItems.getShiftY());
        invItems2.setShiftZ(invItems.getShiftZ());
        invItems2.setX(invItems.getX());
        invItems2.setY(invItems.getY());
        invItems2.setZ(invItems.getZ());
        invItems2.setZoom(invItems.getZoom());
        invItems2.setItemsValue(1);
        invItems2.setTextIfException(invItems.getTextIfException());
        invItems2.setWhoseItem(invItems.getWhoseItem());
        invItems2.setThisBitmap(invItems.getThisBitmap());
        invItems2.setCheck(invItems.getCheck());
    }

    private final void updateSizeInventory(int i) {
        int i2 = i - 1;
        int i3 = this.slotsInInventory;
        if (i2 > i3) {
            if (i3 <= i2) {
                while (true) {
                    int i4 = i3 + 1;
                    this.usersItems.add(Constants.INSTANCE.emptyItem());
                    if (i3 == i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
        } else if (i2 < i3 && i2 <= i3) {
            while (true) {
                int i5 = i3 - 1;
                this.usersItems.remove(i3);
                if (i3 == i2) {
                    break;
                }
                i3 = i5;
            }
        }
        if (i2 != this.slotsInInventory) {
            this.slotsInInventory = i2;
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.usersAdapter;
            if (inventoryExchangeAndTrunkAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
                inventoryExchangeAndTrunkAdapter = null;
            }
            inventoryExchangeAndTrunkAdapter.notifyDataSetChanged();
        }
    }

    private final void setLogicForUsersItemClickListener() {
        this.usersItemClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                long j;
                long j2;
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter;
                int i2;
                int i3;
                List list;
                int i4;
                List list2;
                int i5;
                int i6;
                ActionsWithJSON actionsWithJSON;
                int i7;
                ActionsWithJSON actionsWithJSON2;
                List list3;
                int i8;
                int i9;
                int i10;
                ActionsWithJSON actionsWithJSON3;
                List list4;
                int i11;
                List list5;
                int i12;
                List list6;
                int i13;
                List list7;
                int i14;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding2;
                Function3 function3;
                Function3 function32;
                NvEventQueueActivity nvEventQueueActivity;
                LogicForMigrateItemsInCar logicForMigrateItemsInCar;
                long j3;
                int i15;
                int i16;
                ActionsWithJSON actionsWithJSON4;
                long j4;
                List list8;
                int i17;
                List list9;
                int i18;
                int itemsValue;
                int i19;
                ActionsWithJSON actionsWithJSON5;
                ActionsWithJSON actionsWithJSON6;
                List list10;
                int i20;
                int i21;
                List list11;
                int i22;
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2;
                int unused;
                Intrinsics.checkNotNullParameter(item, "item");
                j = GUICarsTrunkOrCloset.this.oldTimeAfterCheck;
                if (j != System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = GUICarsTrunkOrCloset.this.oldTimeAfterCheck;
                    if (currentTimeMillis - j2 > 500) {
                        GUICarsTrunkOrCloset.this.oldTimeAfterCheck = System.currentTimeMillis();
                        GUICarsTrunkOrCloset.this.positionFromUsersList = i;
                        inventoryExchangeAndTrunkAdapter = GUICarsTrunkOrCloset.this.usersAdapter;
                        ActionsWithJSON actionsWithJSON7 = null;
                        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = null;
                        ActionsWithJSON actionsWithJSON8 = null;
                        LogicForMigrateItemsInCar logicForMigrateItemsInCar2 = null;
                        ActionsWithJSON actionsWithJSON9 = null;
                        ActionsWithJSON actionsWithJSON10 = null;
                        if (inventoryExchangeAndTrunkAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
                            inventoryExchangeAndTrunkAdapter = null;
                        }
                        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(i);
                        if (item.getItemsValue() == 0) {
                            i2 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                            if (i2 != -1) {
                                list5 = GUICarsTrunkOrCloset.this.otherItems;
                                i12 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                if (((InvItems) list5.get(i12)).getItemsValue() != 0) {
                                    list6 = GUICarsTrunkOrCloset.this.otherItems;
                                    i13 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                    if (((InvItems) list6.get(i13)).getItemsValue() == 1) {
                                        j3 = GUICarsTrunkOrCloset.this.oldTimeMigrate;
                                        if (j3 != System.currentTimeMillis()) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            j4 = GUICarsTrunkOrCloset.this.oldTimeMigrate;
                                            if (currentTimeMillis2 - j4 > 1200) {
                                                GUICarsTrunkOrCloset.this.oldTimeMigrate = System.currentTimeMillis();
                                                list8 = GUICarsTrunkOrCloset.this.otherItems;
                                                i17 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                                if (((InvItems) list8.get(i17)).getId() == 134) {
                                                    list11 = GUICarsTrunkOrCloset.this.otherItems;
                                                    i22 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                                    itemsValue = ((InvItems) list11.get(i22)).getModelid();
                                                } else {
                                                    list9 = GUICarsTrunkOrCloset.this.otherItems;
                                                    i18 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                                    itemsValue = ((InvItems) list9.get(i18)).getItemsValue();
                                                }
                                                int i23 = itemsValue;
                                                GUICarsTrunkOrCloset gUICarsTrunkOrCloset = GUICarsTrunkOrCloset.this;
                                                i19 = gUICarsTrunkOrCloset.positionFromCarsList;
                                                gUICarsTrunkOrCloset.intermediatePositionFromCarsList = i19;
                                                GUICarsTrunkOrCloset.this.intermediatePositionFromUsersList = i;
                                                actionsWithJSON5 = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                                if (actionsWithJSON5 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                                    actionsWithJSON6 = null;
                                                } else {
                                                    actionsWithJSON6 = actionsWithJSON5;
                                                }
                                                list10 = GUICarsTrunkOrCloset.this.otherItems;
                                                i20 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                                int id = ((InvItems) list10.get(i20)).getId();
                                                i21 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                                actionsWithJSON6.sendIdWithOldAndNewPositionsAndValueToServer(1, id, i21, i, i23);
                                                GUICarsTrunkOrCloset.this.migrateCounter = 0;
                                                return;
                                            }
                                        }
                                        i15 = GUICarsTrunkOrCloset.this.migrateCounter;
                                        if (i15 == 0) {
                                            actionsWithJSON4 = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                            if (actionsWithJSON4 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                            } else {
                                                actionsWithJSON8 = actionsWithJSON4;
                                            }
                                            actionsWithJSON8.sendMessageError("Перекладывать предмет можно раз в 1 сек");
                                        }
                                        GUICarsTrunkOrCloset gUICarsTrunkOrCloset2 = GUICarsTrunkOrCloset.this;
                                        i16 = gUICarsTrunkOrCloset2.migrateCounter;
                                        gUICarsTrunkOrCloset2.migrateCounter = i16 + 1;
                                        unused = gUICarsTrunkOrCloset2.migrateCounter;
                                        GUICarsTrunkOrCloset.this.clearInfoAboutOtherItem();
                                        GUICarsTrunkOrCloset.this.clearInfoAboutSlot();
                                        GUICarsTrunkOrCloset.this.clearInfoAboutUsersItem();
                                        return;
                                    }
                                    GUICarsTrunkOrCloset.this.startPopupWindowApply();
                                    GUICarsTrunkOrCloset gUICarsTrunkOrCloset3 = GUICarsTrunkOrCloset.this;
                                    list7 = gUICarsTrunkOrCloset3.otherItems;
                                    i14 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                    InvItems invItems = (InvItems) list7.get(i14);
                                    inventoryDialogValueApplyBinding = GUICarsTrunkOrCloset.this.bindingDialogApply;
                                    if (inventoryDialogValueApplyBinding == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bindingDialogApply");
                                        inventoryDialogValueApplyBinding2 = null;
                                    } else {
                                        inventoryDialogValueApplyBinding2 = inventoryDialogValueApplyBinding;
                                    }
                                    function3 = GUICarsTrunkOrCloset.this.clickDialogMenu;
                                    if (function3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("clickDialogMenu");
                                        function32 = null;
                                    } else {
                                        function32 = function3;
                                    }
                                    nvEventQueueActivity = GUICarsTrunkOrCloset.this.context;
                                    gUICarsTrunkOrCloset3.dialogApplyMigrate = new LogicForMigrateItemsInCar(invItems, inventoryDialogValueApplyBinding2, 2, function32, nvEventQueueActivity);
                                    logicForMigrateItemsInCar = GUICarsTrunkOrCloset.this.dialogApplyMigrate;
                                    if (logicForMigrateItemsInCar == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("dialogApplyMigrate");
                                    } else {
                                        logicForMigrateItemsInCar2 = logicForMigrateItemsInCar;
                                    }
                                    logicForMigrateItemsInCar2.openDialogApply();
                                    return;
                                }
                            }
                            i3 = GUICarsTrunkOrCloset.this.positionFromSlot;
                            if (i3 != -1) {
                                list = GUICarsTrunkOrCloset.this.itemsInSlots;
                                i4 = GUICarsTrunkOrCloset.this.positionFromSlot;
                                if (((InvItems) list.get(i4)).getItemsValue() != 0) {
                                    list2 = GUICarsTrunkOrCloset.this.itemsInSlots;
                                    i5 = GUICarsTrunkOrCloset.this.positionFromSlot;
                                    int id2 = ((InvItems) list2.get(i5)).getId();
                                    if (id2 == 58) {
                                        GUICarsTrunkOrCloset.this.intermediatePositionFromUsersList = i;
                                        GUICarsTrunkOrCloset gUICarsTrunkOrCloset4 = GUICarsTrunkOrCloset.this;
                                        i6 = gUICarsTrunkOrCloset4.positionFromSlot;
                                        gUICarsTrunkOrCloset4.intermediatePositionFromSlot = i6;
                                        actionsWithJSON = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                        if (actionsWithJSON == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                        } else {
                                            actionsWithJSON7 = actionsWithJSON;
                                        }
                                        actionsWithJSON7.sendPositionToServer(9, i);
                                        return;
                                    } else if (id2 != 134) {
                                        i9 = GUICarsTrunkOrCloset.this.positionFromSlot;
                                        int i24 = i9 - 2;
                                        GUICarsTrunkOrCloset.this.intermediatePositionFromUsersList = i;
                                        GUICarsTrunkOrCloset gUICarsTrunkOrCloset5 = GUICarsTrunkOrCloset.this;
                                        i10 = gUICarsTrunkOrCloset5.positionFromSlot;
                                        gUICarsTrunkOrCloset5.intermediatePositionFromSlot = i10;
                                        actionsWithJSON3 = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                        if (actionsWithJSON3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                        } else {
                                            actionsWithJSON9 = actionsWithJSON3;
                                        }
                                        list4 = GUICarsTrunkOrCloset.this.itemsInSlots;
                                        i11 = GUICarsTrunkOrCloset.this.positionFromSlot;
                                        actionsWithJSON9.sendIdWithOldAndNewPositionsToServer(2, ((InvItems) list4.get(i11)).getId(), i24, i);
                                        return;
                                    } else {
                                        GUICarsTrunkOrCloset.this.intermediatePositionFromUsersList = i;
                                        GUICarsTrunkOrCloset gUICarsTrunkOrCloset6 = GUICarsTrunkOrCloset.this;
                                        i7 = gUICarsTrunkOrCloset6.positionFromSlot;
                                        gUICarsTrunkOrCloset6.intermediatePositionFromSlot = i7;
                                        actionsWithJSON2 = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                        if (actionsWithJSON2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                        } else {
                                            actionsWithJSON10 = actionsWithJSON2;
                                        }
                                        list3 = GUICarsTrunkOrCloset.this.itemsInSlots;
                                        i8 = GUICarsTrunkOrCloset.this.positionFromSlot;
                                        actionsWithJSON10.sendIdWithOldAndNewPositionsToServer(2, ((InvItems) list3.get(i8)).getId(), 6, i);
                                        return;
                                    }
                                }
                            }
                            GUICarsTrunkOrCloset.this.clearInfoAboutOtherItem();
                            return;
                        }
                        GUICarsTrunkOrCloset.this.oldValue = item.getItemsValue();
                        item.setCheck(true);
                        inventoryExchangeAndTrunkAdapter2 = GUICarsTrunkOrCloset.this.usersAdapter;
                        if (inventoryExchangeAndTrunkAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
                        } else {
                            inventoryExchangeAndTrunkAdapter3 = inventoryExchangeAndTrunkAdapter2;
                        }
                        inventoryExchangeAndTrunkAdapter3.notifyItemChanged(i);
                        inventoryExchangeAndTrunkAdapter3.setCheckOnlyElement(i);
                        GUICarsTrunkOrCloset.this.clearInfoAboutOtherItem();
                        GUICarsTrunkOrCloset.this.clearInfoAboutSlot();
                    }
                }
            }
        };
    }

    public final void clearInfoAboutOtherItem() {
        this.positionFromCarsList = -1;
        this.positionIfThereIsFoldZero = -1;
        this.intermediatePositionFromCarsList = -1;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.carsAdapter;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(this.positionFromCarsList);
    }

    public final void clearInfoAboutSlot() {
        this.positionFromSlot = -1;
        this.intermediatePositionFromSlot = -1;
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
        if (inventoryItemsInSlotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            inventoryItemsInSlotAdapter = null;
        }
        inventoryItemsInSlotAdapter.setCheckOnlyElement(this.positionFromSlot);
    }

    private final void migrateDataFromCarToUser() {
        int i = this.intermediatePositionFromCarsList;
        if (i == -1 || this.intermediatePositionFromUsersList == -1) {
            return;
        }
        updateDataAfterMigrate(this.otherItems.get(i), this.usersItems, this.intermediatePositionFromUsersList);
        subtractionFromList(this.otherItems.get(this.intermediatePositionFromCarsList), this.otherItems, this.intermediatePositionFromCarsList);
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.carsAdapter;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.notifyItemChanged(this.intermediatePositionFromCarsList);
        if (this.positionIfThereIsFoldZero != -1) {
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.usersAdapter;
            if (inventoryExchangeAndTrunkAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
            } else {
                inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter3;
            }
            inventoryExchangeAndTrunkAdapter2.notifyItemChanged(this.positionIfThereIsFoldZero);
            return;
        }
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter4 = this.usersAdapter;
        if (inventoryExchangeAndTrunkAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter4;
        }
        inventoryExchangeAndTrunkAdapter2.notifyItemChanged(this.intermediatePositionFromUsersList);
    }

    public final void startPopupWindowApply() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        InventoryDialogValueApplyBinding inflate = InventoryDialogValueApplyBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.bindingDialogApply = inflate;
        InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding = this.bindingDialogApply;
        if (inventoryDialogValueApplyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialogApply");
            inventoryDialogValueApplyBinding = null;
        }
        PopupWindow popupWindow = new PopupWindow((View) inventoryDialogValueApplyBinding.getRoot(), -1, -1, true);
        this.dialogApplyPopupWindow = popupWindow;
        if (popupWindow == null) {
            return;
        }
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        popupWindow.showAtLocation(nvEventQueueActivity2 != null ? nvEventQueueActivity2.getParentLayout() : null, 17, 0, 0);
    }

    public final void closePopupWindowApply() {
        PopupWindow popupWindow = this.dialogApplyPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        GUIManager.hideSystemUI(inventoryCarTrunkBinding.getRoot());
    }

    private final void setDataInUsersList() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (nvEventQueueActivity != null) {
            List<InvItems> list = this.usersItems;
            Function2<? super InvItems, ? super Integer, Unit> function2 = this.usersItemClickListener;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("usersItemClickListener");
                function2 = null;
            }
            this.usersAdapter = new InventoryExchangeAndTrunkAdapter(list, function2, nvEventQueueActivity, 0);
        }
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        RecyclerView recyclerView = inventoryCarTrunkBinding.carTrunkListItemsInInventory;
        InventoryCarTrunkBinding inventoryCarTrunkBinding2 = this.binding;
        if (inventoryCarTrunkBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding2 = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(inventoryCarTrunkBinding2.getRoot().getContext(), 4));
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.usersAdapter;
        if (inventoryExchangeAndTrunkAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
        }
        recyclerView.setAdapter(inventoryExchangeAndTrunkAdapter);
    }

    private final void setLogicForCarsItemClickListener() {
        this.carsItemClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                long j;
                long j2;
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter;
                int i2;
                List list;
                int i3;
                List list2;
                int i4;
                List list3;
                int i5;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding2;
                Function3 function3;
                Function3 function32;
                NvEventQueueActivity nvEventQueueActivity;
                LogicForMigrateItemsInCar logicForMigrateItemsInCar;
                long j3;
                int i6;
                int i7;
                ActionsWithJSON actionsWithJSON;
                long j4;
                List list4;
                int i8;
                List list5;
                int i9;
                int itemsValue;
                int i10;
                ActionsWithJSON actionsWithJSON2;
                ActionsWithJSON actionsWithJSON3;
                List list6;
                int i11;
                int i12;
                List list7;
                int i13;
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2;
                int unused;
                Intrinsics.checkNotNullParameter(item, "item");
                j = GUICarsTrunkOrCloset.this.oldTimeAfterCheck;
                if (j != System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = GUICarsTrunkOrCloset.this.oldTimeAfterCheck;
                    if (currentTimeMillis - j2 > 500) {
                        GUICarsTrunkOrCloset.this.oldTimeAfterCheck = System.currentTimeMillis();
                        GUICarsTrunkOrCloset.this.positionFromCarsList = i;
                        inventoryExchangeAndTrunkAdapter = GUICarsTrunkOrCloset.this.carsAdapter;
                        LogicForMigrateItemsInCar logicForMigrateItemsInCar2 = null;
                        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = null;
                        ActionsWithJSON actionsWithJSON4 = null;
                        if (inventoryExchangeAndTrunkAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
                            inventoryExchangeAndTrunkAdapter = null;
                        }
                        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(i);
                        if (item.getItemsValue() == 0) {
                            i2 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                            if (i2 != -1) {
                                list = GUICarsTrunkOrCloset.this.usersItems;
                                i3 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                if (((InvItems) list.get(i3)).getItemsValue() != 0) {
                                    list2 = GUICarsTrunkOrCloset.this.usersItems;
                                    i4 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                    if (((InvItems) list2.get(i4)).getItemsValue() == 1) {
                                        j3 = GUICarsTrunkOrCloset.this.oldTimeMigrate;
                                        if (j3 != System.currentTimeMillis()) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            j4 = GUICarsTrunkOrCloset.this.oldTimeMigrate;
                                            if (currentTimeMillis2 - j4 > 1200) {
                                                GUICarsTrunkOrCloset.this.oldTimeMigrate = System.currentTimeMillis();
                                                list4 = GUICarsTrunkOrCloset.this.usersItems;
                                                i8 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                                if (((InvItems) list4.get(i8)).getId() == 134) {
                                                    list7 = GUICarsTrunkOrCloset.this.usersItems;
                                                    i13 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                                    itemsValue = ((InvItems) list7.get(i13)).getModelid();
                                                } else {
                                                    list5 = GUICarsTrunkOrCloset.this.usersItems;
                                                    i9 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                                    itemsValue = ((InvItems) list5.get(i9)).getItemsValue();
                                                }
                                                int i14 = itemsValue;
                                                GUICarsTrunkOrCloset gUICarsTrunkOrCloset = GUICarsTrunkOrCloset.this;
                                                i10 = gUICarsTrunkOrCloset.positionFromUsersList;
                                                gUICarsTrunkOrCloset.intermediatePositionFromUsersList = i10;
                                                GUICarsTrunkOrCloset.this.intermediatePositionFromCarsList = i;
                                                actionsWithJSON2 = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                                if (actionsWithJSON2 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                                    actionsWithJSON3 = null;
                                                } else {
                                                    actionsWithJSON3 = actionsWithJSON2;
                                                }
                                                list6 = GUICarsTrunkOrCloset.this.usersItems;
                                                i11 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                                int id = ((InvItems) list6.get(i11)).getId();
                                                i12 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                                actionsWithJSON3.sendIdWithOldAndNewPositionsAndValueToServer(0, id, i12, i, i14);
                                                GUICarsTrunkOrCloset.this.migrateCounter = 0;
                                                return;
                                            }
                                        }
                                        i6 = GUICarsTrunkOrCloset.this.migrateCounter;
                                        if (i6 == 0) {
                                            actionsWithJSON = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                            if (actionsWithJSON == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                            } else {
                                                actionsWithJSON4 = actionsWithJSON;
                                            }
                                            actionsWithJSON4.sendMessageError("Перекладывать предмет можно раз в 1 сек");
                                        }
                                        GUICarsTrunkOrCloset gUICarsTrunkOrCloset2 = GUICarsTrunkOrCloset.this;
                                        i7 = gUICarsTrunkOrCloset2.migrateCounter;
                                        gUICarsTrunkOrCloset2.migrateCounter = i7 + 1;
                                        unused = gUICarsTrunkOrCloset2.migrateCounter;
                                        GUICarsTrunkOrCloset.this.clearInfoAboutOtherItem();
                                        GUICarsTrunkOrCloset.this.clearInfoAboutSlot();
                                        GUICarsTrunkOrCloset.this.clearInfoAboutUsersItem();
                                        return;
                                    }
                                    GUICarsTrunkOrCloset.this.startPopupWindowApply();
                                    GUICarsTrunkOrCloset gUICarsTrunkOrCloset3 = GUICarsTrunkOrCloset.this;
                                    list3 = gUICarsTrunkOrCloset3.usersItems;
                                    i5 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                    InvItems invItems = (InvItems) list3.get(i5);
                                    inventoryDialogValueApplyBinding = GUICarsTrunkOrCloset.this.bindingDialogApply;
                                    if (inventoryDialogValueApplyBinding == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bindingDialogApply");
                                        inventoryDialogValueApplyBinding2 = null;
                                    } else {
                                        inventoryDialogValueApplyBinding2 = inventoryDialogValueApplyBinding;
                                    }
                                    function3 = GUICarsTrunkOrCloset.this.clickDialogMenu;
                                    if (function3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("clickDialogMenu");
                                        function32 = null;
                                    } else {
                                        function32 = function3;
                                    }
                                    nvEventQueueActivity = GUICarsTrunkOrCloset.this.context;
                                    gUICarsTrunkOrCloset3.dialogApplyMigrate = new LogicForMigrateItemsInCar(invItems, inventoryDialogValueApplyBinding2, 1, function32, nvEventQueueActivity);
                                    logicForMigrateItemsInCar = GUICarsTrunkOrCloset.this.dialogApplyMigrate;
                                    if (logicForMigrateItemsInCar == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("dialogApplyMigrate");
                                    } else {
                                        logicForMigrateItemsInCar2 = logicForMigrateItemsInCar;
                                    }
                                    logicForMigrateItemsInCar2.openDialogApply();
                                    return;
                                }
                            }
                            GUICarsTrunkOrCloset.this.clearInfoAboutUsersItem();
                            return;
                        }
                        GUICarsTrunkOrCloset.this.oldValue = item.getItemsValue();
                        item.setCheck(true);
                        inventoryExchangeAndTrunkAdapter2 = GUICarsTrunkOrCloset.this.carsAdapter;
                        if (inventoryExchangeAndTrunkAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
                        } else {
                            inventoryExchangeAndTrunkAdapter3 = inventoryExchangeAndTrunkAdapter2;
                        }
                        inventoryExchangeAndTrunkAdapter3.notifyItemChanged(i);
                        inventoryExchangeAndTrunkAdapter3.setCheckOnlyElement(i);
                        GUICarsTrunkOrCloset.this.clearInfoAboutUsersItem();
                        GUICarsTrunkOrCloset.this.clearInfoAboutSlot();
                    }
                }
            }
        };
    }

    public final void clearInfoAboutUsersItem() {
        this.positionFromUsersList = -1;
        this.positionIfThereIsFoldZero = -1;
        this.intermediatePositionFromUsersList = -1;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.usersAdapter;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(this.positionFromUsersList);
    }

    private final void migrateDataFromUserToCar() {
        int i = this.intermediatePositionFromUsersList;
        if (i == -1 || this.intermediatePositionFromCarsList == -1) {
            return;
        }
        updateDataAfterMigrate(this.usersItems.get(i), this.otherItems, this.intermediatePositionFromCarsList);
        subtractionFromList(this.usersItems.get(this.intermediatePositionFromUsersList), this.usersItems, this.intermediatePositionFromUsersList);
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.usersAdapter;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.notifyItemChanged(this.intermediatePositionFromUsersList);
        if (this.positionIfThereIsFoldZero != -1) {
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.carsAdapter;
            if (inventoryExchangeAndTrunkAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
            } else {
                inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter3;
            }
            inventoryExchangeAndTrunkAdapter2.notifyItemChanged(this.positionIfThereIsFoldZero);
            return;
        }
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter4 = this.carsAdapter;
        if (inventoryExchangeAndTrunkAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter4;
        }
        inventoryExchangeAndTrunkAdapter2.notifyItemChanged(this.intermediatePositionFromCarsList);
    }

    private final void subtractionFromList(InvItems invItems, List<InvItems> list, int i) {
        InvItems invItems2 = list.get(i);
        int itemsValue = this.oldValue - invItems.getItemsValue();
        this.oldValue = itemsValue;
        if (itemsValue == 0) {
            setEmptyItem(invItems2);
        }
        invItems2.setItemsValue(this.oldValue);
    }

    private final void setEmptyItem(InvItems invItems) {
        invItems.setId(0);
        invItems.setName("");
        invItems.setDesc("");
        invItems.setModelid(0);
        invItems.setWeight(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        invItems.setAddw(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        invItems.setFold(0);
        invItems.setShiftX(0.0f);
        invItems.setShiftY(0.0f);
        invItems.setShiftZ(0.0f);
        invItems.setX(0.0f);
        invItems.setY(0.0f);
        invItems.setZ(0.0f);
        invItems.setZoom(0.0f);
        invItems.setTextIfException("");
        invItems.setThisBitmap(null);
    }

    private final void updateDataAfterMigrate(InvItems invItems, List<InvItems> list, int i) {
        boolean z;
        if (invItems.getFold() == 0) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                if (list.get(i2).getId() == invItems.getId()) {
                    InvItems invItems2 = list.get(i2);
                    invItems2.setItemsValue(invItems2.getItemsValue() + invItems.getItemsValue());
                    this.positionIfThereIsFoldZero = i2;
                    z = true;
                    break;
                }
                i2 = i3;
            }
        }
        z = false;
        if (z) {
            return;
        }
        updateItemAfterMigrate(list.get(i), invItems, false);
    }

    private final void updateDataAfterMigrateToSlot(InvItems invItems, List<InvItems> list, int i) {
        updateItemAfterMigrate(list.get(i), invItems, true);
    }

    private final void updateItemAfterMigrate(InvItems invItems, InvItems invItems2, boolean z) {
        invItems.setId(invItems2.getId());
        invItems.setName(invItems2.getName());
        invItems.setDesc(invItems2.getDesc());
        invItems.setModelid(invItems2.getModelid());
        invItems.setWeight(invItems2.getWeight());
        invItems.setAddw(invItems2.getAddw());
        invItems.setFold(invItems2.getFold());
        invItems.setShiftX(invItems2.getShiftX());
        invItems.setShiftY(invItems2.getShiftY());
        invItems.setShiftZ(invItems2.getShiftZ());
        invItems.setX(invItems2.getX());
        invItems.setY(invItems2.getY());
        invItems.setZ(invItems2.getZ());
        invItems.setZoom(invItems2.getZoom());
        invItems.setItemsValue(!z ? invItems2.getItemsValue() : 1);
        invItems.setTextIfException(invItems2.getTextIfException());
        invItems.setThisBitmap(invItems2.getThisBitmap());
    }

    private final void setDataInCarsList() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (nvEventQueueActivity != null) {
            List<InvItems> list = this.otherItems;
            Function2<? super InvItems, ? super Integer, Unit> function2 = this.carsItemClickListener;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("carsItemClickListener");
                function2 = null;
            }
            this.carsAdapter = new InventoryExchangeAndTrunkAdapter(list, function2, nvEventQueueActivity, 1);
        }
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        RecyclerView recyclerView = inventoryCarTrunkBinding.carTrunkListItemsInCar;
        InventoryCarTrunkBinding inventoryCarTrunkBinding2 = this.binding;
        if (inventoryCarTrunkBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding2 = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(inventoryCarTrunkBinding2.getRoot().getContext(), 4));
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.carsAdapter;
        if (inventoryExchangeAndTrunkAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carsAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
        }
        recyclerView.setAdapter(inventoryExchangeAndTrunkAdapter);
    }

    private final void setEmptySlotInSlots() {
        int i = this.sizeSlots;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            this.itemsInSlots.add(Constants.INSTANCE.emptyItem());
        }
    }

    private final void setDataInSlotsView() {
        List<InvItems> list = this.itemsInSlots;
        Function2<? super InvItems, ? super Integer, Unit> function2 = this.onItemsInSlotClickListener;
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemsInSlotClickListener");
            function2 = null;
        }
        this.itemsInSlotAdapter = new InventoryItemsInSlotAdapter(list, function2, this.context, false);
        InventoryCarTrunkBinding inventoryCarTrunkBinding = this.binding;
        if (inventoryCarTrunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding = null;
        }
        RecyclerView recyclerView = inventoryCarTrunkBinding.playersSlotsInCarTrunk;
        InventoryCarTrunkBinding inventoryCarTrunkBinding2 = this.binding;
        if (inventoryCarTrunkBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryCarTrunkBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryCarTrunkBinding2.getRoot().getContext(), 1, false));
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = this.itemsInSlotAdapter;
        if (inventoryItemsInSlotAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
        } else {
            inventoryItemsInSlotAdapter = inventoryItemsInSlotAdapter2;
        }
        recyclerView.setAdapter(inventoryItemsInSlotAdapter);
    }

    private final void setLogicForClickInSlot() {
        this.onItemsInSlotClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter;
                Intrinsics.checkNotNullParameter(item, "item");
                GUICarsTrunkOrCloset.this.positionFromSlot = i;
                GUICarsTrunkOrCloset.this.clearInfoAboutOtherItem();
                GUICarsTrunkOrCloset.this.clearInfoAboutUsersItem();
                if (item.getItemsValue() != 0) {
                    item.setCheck(true);
                    inventoryItemsInSlotAdapter = GUICarsTrunkOrCloset.this.itemsInSlotAdapter;
                    if (inventoryItemsInSlotAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
                        inventoryItemsInSlotAdapter = null;
                    }
                    inventoryItemsInSlotAdapter.notifyItemChanged(i);
                    inventoryItemsInSlotAdapter.setCheckOnlyElement(i);
                }
            }
        };
    }

    private final void migrateDataFromSlotToUser() {
        int i = this.intermediatePositionFromSlot;
        if (i != -1 && this.intermediatePositionFromUsersList != -1) {
            updateDataAfterMigrate(this.itemsInSlots.get(i), this.usersItems, this.intermediatePositionFromUsersList);
            InvItems invItems = this.itemsInSlots.get(this.intermediatePositionFromSlot);
            setEmptyItem(invItems);
            invItems.setItemsValue(0);
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.usersAdapter;
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = null;
            if (inventoryExchangeAndTrunkAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("usersAdapter");
                inventoryExchangeAndTrunkAdapter = null;
            }
            inventoryExchangeAndTrunkAdapter.notifyItemChanged(this.intermediatePositionFromUsersList);
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = this.itemsInSlotAdapter;
            if (inventoryItemsInSlotAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            } else {
                inventoryItemsInSlotAdapter = inventoryItemsInSlotAdapter2;
            }
            inventoryItemsInSlotAdapter.notifyItemChanged(this.intermediatePositionFromSlot);
        }
        this.positionFromSlot = -1;
        this.intermediatePositionFromSlot = -1;
    }

    public void invoke2(InvMainButtonsData mainButton, View view) {
        Intrinsics.checkNotNullParameter(mainButton, "mainButton");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.typeInterface != 2) {
            Animation animation = this.anim;
            ActionsWithJSON actionsWithJSON = null;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            int typeMenu = mainButton.getTypeMenu();
            if (typeMenu == 0) {
                mainButtonsClickListener(mainButton, 3);
            } else if (typeMenu == 1) {
                mainButtonsClickListener(mainButton, 4);
            } else if (typeMenu == 2) {
                mainButtonsClickListener(mainButton, 5);
            } else if (typeMenu != 3) {
                if (typeMenu != 4) {
                    return;
                }
                mainButtonsClickListener(mainButton, 7);
            } else {
                ActionsWithJSON actionsWithJSON2 = this.actionsWithJSON;
                if (actionsWithJSON2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                } else {
                    actionsWithJSON = actionsWithJSON2;
                }
                actionsWithJSON.openRadialMenu();
                mainButtonsClickListener(mainButton, 6);
            }
        }
    }

    private final void mainButtonsClickListener(InvMainButtonsData invMainButtonsData, int i) {
        this.ifClickOtherButtonWithDismiss = true;
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendPressButton(i);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void setLogicForDialogApply() {
        this.clickDialogMenu = new Function3<InvItems, Integer, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num, Integer num2) {
                invoke(invItems, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems invItems, int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                ActionsWithJSON actionsWithJSON;
                ActionsWithJSON actionsWithJSON2;
                List list;
                int i7;
                int i8;
                int i9;
                List list2;
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                ActionsWithJSON actionsWithJSON3;
                ActionsWithJSON actionsWithJSON4;
                List list3;
                int i15;
                int i16;
                int i17;
                List list4;
                int i18;
                if (i == 1) {
                    if (i2 == 11) {
                        i3 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                        if (i3 != -1) {
                            i4 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                            if (i4 != -1) {
                                GUICarsTrunkOrCloset gUICarsTrunkOrCloset = GUICarsTrunkOrCloset.this;
                                i5 = gUICarsTrunkOrCloset.positionFromUsersList;
                                gUICarsTrunkOrCloset.intermediatePositionFromUsersList = i5;
                                GUICarsTrunkOrCloset gUICarsTrunkOrCloset2 = GUICarsTrunkOrCloset.this;
                                i6 = gUICarsTrunkOrCloset2.positionFromCarsList;
                                gUICarsTrunkOrCloset2.intermediatePositionFromCarsList = i6;
                                actionsWithJSON = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                if (actionsWithJSON == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                    actionsWithJSON2 = null;
                                } else {
                                    actionsWithJSON2 = actionsWithJSON;
                                }
                                list = GUICarsTrunkOrCloset.this.usersItems;
                                i7 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                int id = ((InvItems) list.get(i7)).getId();
                                i8 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                i9 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                list2 = GUICarsTrunkOrCloset.this.usersItems;
                                i10 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                actionsWithJSON2.sendIdWithOldAndNewPositionsAndValueToServer(0, id, i8, i9, ((InvItems) list2.get(i10)).getItemsValue());
                            }
                        }
                    }
                    GUICarsTrunkOrCloset.this.closePopupWindowApply();
                } else if (i != 2) {
                } else {
                    if (i2 == 11) {
                        i11 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                        if (i11 != -1) {
                            i12 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                            if (i12 != -1) {
                                GUICarsTrunkOrCloset gUICarsTrunkOrCloset3 = GUICarsTrunkOrCloset.this;
                                i13 = gUICarsTrunkOrCloset3.positionFromUsersList;
                                gUICarsTrunkOrCloset3.intermediatePositionFromUsersList = i13;
                                GUICarsTrunkOrCloset gUICarsTrunkOrCloset4 = GUICarsTrunkOrCloset.this;
                                i14 = gUICarsTrunkOrCloset4.positionFromCarsList;
                                gUICarsTrunkOrCloset4.intermediatePositionFromCarsList = i14;
                                actionsWithJSON3 = GUICarsTrunkOrCloset.this.actionsWithJSON;
                                if (actionsWithJSON3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                                    actionsWithJSON4 = null;
                                } else {
                                    actionsWithJSON4 = actionsWithJSON3;
                                }
                                list3 = GUICarsTrunkOrCloset.this.otherItems;
                                i15 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                int id2 = ((InvItems) list3.get(i15)).getId();
                                i16 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                i17 = GUICarsTrunkOrCloset.this.positionFromUsersList;
                                list4 = GUICarsTrunkOrCloset.this.otherItems;
                                i18 = GUICarsTrunkOrCloset.this.positionFromCarsList;
                                actionsWithJSON4.sendIdWithOldAndNewPositionsAndValueToServer(1, id2, i16, i17, ((InvItems) list4.get(i18)).getItemsValue());
                            }
                        }
                    }
                    GUICarsTrunkOrCloset.this.closePopupWindowApply();
                }
            }
        };
    }

    private final void getStartData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.typeInterface = jSONObject.optInt("tb");
        this.thisPlayersWeight = jSONObject.optInt("w");
        this.maxPlayersWeight = jSONObject.optInt(GetKeys.GET_MAX_WEIGHT);
        int optInt = jSONObject.optInt(GetKeys.GET_MAX_SIZE_INVENTORY);
        this.slotsInInventory = optInt;
        if (optInt != 0) {
            this.slotsInInventory = optInt - 1;
        }
        this.thisOtherWeight = jSONObject.optInt("bw");
        this.maxOtherWeight = jSONObject.optInt("cw");
        int optInt2 = jSONObject.optInt("sb");
        this.slotsOther = optInt2;
        if (optInt2 != 0) {
            this.slotsOther = optInt2 - 1;
        }
        this.simCardsNumber = jSONObject.optInt(GetKeys.GET_NUMBER_IN_SLOT);
        JSONArray optJSONArray = jSONObject.optJSONArray(GetKeys.GET_PLAYERS_ITEMS_IN_INV);
        int i = 0;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                List<Object> list = this.playersItemsInInventoryAny;
                Object obj = null;
                try {
                    obj = optJSONArray.get(i2);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "playersItemsInInventoryArray[i]");
                list.add(obj);
                i2 = i3;
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(GetKeys.GET_PLAYERS_ITEMS_IN_SLOT);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            int i4 = 0;
            while (i4 < length2) {
                int i5 = i4 + 1;
                List<Object> list2 = this.playersItemsInSlotAny;
                Object obj2 = null;
                try {
                    obj2 = optJSONArray2.get(i4);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Intrinsics.checkNotNullExpressionValue(obj2, "playersItemsInSlotArray[i]");
                list2.add(obj2);
                i4 = i5;
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("ic");
        if (optJSONArray3 != null) {
            int length3 = optJSONArray3.length();
            while (i < length3) {
                int i6 = i + 1;
                List<Object> list3 = this.otherItemsAny;
                Object obj3 = null;
                try {
                    obj3 = optJSONArray3.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Intrinsics.checkNotNullExpressionValue(obj3, "otherItemsArray[i]");
                list3.add(obj3);
                i = i6;
            }
        }
    }

    private final void setOldValueOnMyList() {
        int i = this.intermediatePositionFromUsersList;
        if (i <= -1 || i >= this.usersItems.size()) {
            return;
        }
        this.usersItems.get(this.intermediatePositionFromUsersList).setItemsValue(this.oldValue);
    }

    private final void setOldValueOnOtherList() {
        int i = this.intermediatePositionFromCarsList;
        if (i <= -1 || i >= this.otherItems.size()) {
            return;
        }
        this.otherItems.get(this.intermediatePositionFromCarsList).setItemsValue(this.oldValue);
    }

    @Override
    public void close(JSONObject jSONObject) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }
}
