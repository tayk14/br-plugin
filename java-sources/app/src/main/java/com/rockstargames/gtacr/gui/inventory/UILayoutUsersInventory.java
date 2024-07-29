package com.rockstargames.gtacr.gui.inventory;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.InventoryDialogApplyDeletItemBinding;
import blackrussia.online.databinding.InventoryLayoutUsersInventoryBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.InventoryActionButtonsAdapter;
import com.rockstargames.gtacr.adapters.InventoryItemsAdapter;
import com.rockstargames.gtacr.adapters.InventoryItemsInSlotAdapter;
import com.rockstargames.gtacr.adapters.InventoryPlayersStatesAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.InvActionButtonsData;
import com.rockstargames.gtacr.data.InvPlayersStateData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

//@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u000126\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002j\u0002`\nB\r\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ \u0010c\u001a\u00020\t2\u0006\u0010X\u001a\u00020E2\u0006\u0010d\u001a\u00020\u00112\u0006\u0010e\u001a\u00020\u0011H\u0002J\u0016\u0010f\u001a\u00020\t2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002J\b\u0010h\u001a\u00020\tH\u0002J\b\u0010i\u001a\u00020\tH\u0002J\u0006\u0010j\u001a\u00020\tJ\u0006\u0010k\u001a\u00020\tJ\u0006\u0010l\u001a\u00020\tJ\u001e\u0010m\u001a\u00020\t2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010o\u001a\u000203H\u0002J\u0006\u0010p\u001a\u00020\tJ\b\u0010q\u001a\u00020\tH\u0002J\b\u0010r\u001a\u00020\tH\u0002J\f\u0010s\u001a\b\u0012\u0004\u0012\u00020E0DJ\f\u0010t\u001a\b\u0012\u0004\u0012\u00020E0DJ\b\u0010u\u001a\u00020\tH\u0002J\u0006\u0010v\u001a\u00020\u0011J\u0006\u0010w\u001a\u00020\u0011J\u0006\u0010x\u001a\u00020\u0011J\b\u0010y\u001a\u00020\u0007H\u0016J\u0019\u0010z\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002J>\u0010{\u001a\u00020\t2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020E0D2\b\u0010}\u001a\u0004\u0018\u00010E2\u0006\u0010~\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J\u0010\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\u0011J\u0007\u0010\u0082\u0001\u001a\u00020\tJ\u0007\u0010\u0083\u0001\u001a\u00020\tJ?\u0010\u0084\u0001\u001a\u00020\t2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020E0D2\b\u0010}\u001a\u0004\u0018\u00010E2\u0006\u0010~\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J\u001f\u0010\u0085\u0001\u001a\u00020\u00072\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020\tH\u0016J\t\u0010\u008b\u0001\u001a\u00020\tH\u0016J\u0010\u0010\u008c\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\u0011J\t\u0010\u008e\u0001\u001a\u00020\tH\u0002J\t\u0010\u008f\u0001\u001a\u00020\tH\u0002J\t\u0010\u0090\u0001\u001a\u00020\tH\u0002J\t\u0010\u0091\u0001\u001a\u00020\tH\u0002J\u0011\u0010\u0092\u0001\u001a\u00020\t2\u0006\u0010X\u001a\u00020EH\u0002J\u0012\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\u0011H\u0002J\u0011\u0010\u0095\u0001\u001a\u00020\t2\u0006\u0010X\u001a\u00020EH\u0002J\u0017\u0010\u0096\u0001\u001a\u00020\t2\u000e\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010DJ\u0017\u0010\u0099\u0001\u001a\u00020\t2\u000e\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010DJ\t\u0010\u009a\u0001\u001a\u00020\tH\u0002J\t\u0010\u009b\u0001\u001a\u00020\tH\u0002J\u0010\u0010\u009c\u0001\u001a\u00020\t2\u0007\u0010\u009d\u0001\u001a\u00020\u0011J\u001d\u0010\u009e\u0001\u001a\u00020\t2\u000e\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110 \u0001¢\u0006\u0003\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00020\t2\b\u0010£\u0001\u001a\u00030¤\u0001J\t\u0010¥\u0001\u001a\u00020\tH\u0002J\u0010\u0010¦\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\u0011J\t\u0010¨\u0001\u001a\u00020\tH\u0002J%\u0010©\u0001\u001a\u00020\t2\u0007\u0010ª\u0001\u001a\u00020E2\u0007\u0010«\u0001\u001a\u00020E2\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0002J%\u0010®\u0001\u001a\u00020\t2\r\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020E0D2\r\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020E0DJ\u0010\u0010±\u0001\u001a\u00020\t2\u0007\u0010²\u0001\u001a\u00020\u0011J\u0010\u0010³\u0001\u001a\u00020\t2\u0007\u0010´\u0001\u001a\u00020\u0011J\u0010\u0010µ\u0001\u001a\u00020\t2\u0007\u0010¶\u0001\u001a\u00020\u0011R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R\u001a\u0010(\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u000e\u0010+\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010/\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u0011\u00104\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u001a\u00106\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u00109\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u001a\u0010@\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020H0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010W\u001a6\u0012\u0013\u0012\u00110E¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(X\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020\t0\u0002j\u0002`ZX\u0082.¢\u0006\u0002\n\u0000RB\u0010[\u001a6\u0012\u0013\u0012\u00110E¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(X\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020\t0\u0002j\u0002`ZX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;", "Lcom/rockstargames/gtacr/common/UILayout;", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/InvActionButtonsData;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "actionButton", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/adapters/OnActionButtonsClickListener;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "(Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;)V", "actionsAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryActionButtonsAdapter;", "activeSlotsInInventory", "", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/InventoryLayoutUsersInventoryBinding;", "bindingDialogDelete", "Lblackrussia/online/databinding/InventoryDialogApplyDeletItemBinding;", "counter", "deletedCounter", "dialogDeletePopupWindow", "Landroid/widget/PopupWindow;", "exchangeHeight", "getExchangeHeight", "()I", "setExchangeHeight", "(I)V", "exchangeLocation", "", "getExchangeLocation", "()[I", "exchangeWidth", "getExchangeWidth", "setExchangeWidth", "intermediateOldPositionInInvIfUsed", "getIntermediateOldPositionInInvIfUsed", "setIntermediateOldPositionInInvIfUsed", "intermediatePositionInInv", "intermediatePositionInSlot", "getIntermediatePositionInSlot", "setIntermediatePositionInSlot", "inventoryHeight", "getInventoryHeight", "setInventoryHeight", "inventoryItemsAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryItemsAdapter;", "inventoryLocation", "getInventoryLocation", "inventoryWidth", "getInventoryWidth", "setInventoryWidth", "itemsHeight", "getItemsHeight", "setItemsHeight", "itemsInSlotAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter;", "itemsLocation", "getItemsLocation", "itemsWidth", "getItemsWidth", "setItemsWidth", "listItemsInInventory", "", "Lblackrussia/online/network/InvItems;", "listItemsInSlots", "listPlayersStates", "Lcom/rockstargames/gtacr/data/InvPlayersStateData;", "logicForDialogDelete", "Lcom/rockstargames/gtacr/gui/inventory/LogicForDialogDelete;", "maxSlotsInInventory", "maxWeightInventory", "migrateCounter", "oldPositionWithItem", "oldTimeDeleted", "", "oldTimeWithMigrateAndUsed", "getOldTimeWithMigrateAndUsed", "()J", "setOldTimeWithMigrateAndUsed", "(J)V", "oldValue", "onItemsClickListener", "item", "position", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "onItemsInSlotClickListener", "playersStatesAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryPlayersStatesAdapter;", "positionFromSlot", "positionInInventory", "sizeSlots", "thisWeightInventory", "usedCounter", "changePositionWithSimCartOrSkin", "positionInSlot", "positionInInv", "changeStatusWhoseItem", "myList", "clearInfoAboutInv", "clearInfoAboutSlot", "clearItemsInfo", "closePopupWindowDelete", "deleteItem", "deleteItemAndUpdateView", "thisList", "thisAdapter", "deleteThisItem", "getExchangeButton", "getInventoryPosition", "getItemsFromActiveSlots", "getItemsFromInventory", "getItemsPosition", "getMaxWeight", "getSizeSlots", "getThisWeight", "getView", "invoke", "migrateData", "oldList", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "thisPosition", "oldPosition", "migrateDataFromInvToSlot", "newPosition", "migrateDataFromSlotToInv", "migrateDataInInv", "migrateDataToSlot", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "renderMainSkin", "modelId", "setDataInInventoryInView", "setDataInSlotsView", "setDataPlayersButtonsActionInView", "setDataPlayersStateInfoInView", "setEmptyItem", "setEmptyItemsInInventory", "size", "setInfoAboutItem", "setItems", FirebaseAnalytics.Param.ITEMS, "", "setItemsInSlot", "setLogicForClickInSlot", "setLogicForItemsClickListener", "setMaxWeight", "maxWeight", "setPlayersInfo", "array", "", "([Ljava/lang/Integer;)V", "setPlayersNick", "nick", "", "setStartViewSlots", "setThisWeight", "thisWeight", "startPopupWindowDelete", "updateItemAfterMigrate", "thisItem", "migrateItem", "ifToSlot", "", "updateItems", "newListItemsInActiveSlot", "newListItemsInInventory", "updateNumberForSimCard", "simCardNumber", "updateSizeInventory", "newSize", "updateValueDinner", "newValueDinner", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UILayoutUsersInventory extends UILayout implements Function2<InvActionButtonsData, View, Unit> {
    private InventoryActionButtonsAdapter actionsAdapter;
    private int activeSlotsInInventory;
    private Animation anim;
    private InventoryLayoutUsersInventoryBinding binding;
    private InventoryDialogApplyDeletItemBinding bindingDialogDelete;
    private int counter;
    private int deletedCounter;
    private PopupWindow dialogDeletePopupWindow;
    private int exchangeHeight;
    private final int[] exchangeLocation;
    private int exchangeWidth;
    private int intermediateOldPositionInInvIfUsed;
    private int intermediatePositionInInv;
    private int intermediatePositionInSlot;
    private int inventoryHeight;
    private InventoryItemsAdapter inventoryItemsAdapter;
    private final int[] inventoryLocation;
    private int inventoryWidth;
    private int itemsHeight;
    private InventoryItemsInSlotAdapter itemsInSlotAdapter;
    private final int[] itemsLocation;
    private int itemsWidth;
    private List<InvItems> listItemsInInventory;
    private List<InvItems> listItemsInSlots;
    private final List<InvPlayersStateData> listPlayersStates;
    private LogicForDialogDelete logicForDialogDelete;
    private final GUIUsersInventory mainRoot;
    private int maxSlotsInInventory;
    private int maxWeightInventory;
    private int migrateCounter;
    private int oldPositionWithItem;
    private long oldTimeDeleted;
    private long oldTimeWithMigrateAndUsed;
    private int oldValue;
    private Function2<? super InvItems, ? super Integer, Unit> onItemsClickListener;
    private Function2<? super InvItems, ? super Integer, Unit> onItemsInSlotClickListener;
    private InventoryPlayersStatesAdapter playersStatesAdapter;
    private int positionFromSlot;
    private int positionInInventory;
    private final int sizeSlots;
    private int thisWeightInventory;
    private int usedCounter;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutUsersInventory(GUIUsersInventory mainRoot) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        this.mainRoot = mainRoot;
        this.positionInInventory = -1;
        this.oldPositionWithItem = -1;
        this.positionFromSlot = -1;
        this.intermediatePositionInInv = -1;
        this.intermediateOldPositionInInvIfUsed = -1;
        this.intermediatePositionInSlot = -1;
        this.listItemsInInventory = new ArrayList();
        this.sizeSlots = 8;
        this.listItemsInSlots = new ArrayList();
        this.listPlayersStates = CollectionsKt.mutableListOf(new InvPlayersStateData(0, 0, 0, "inv_icon_players_state_bag_res"), new InvPlayersStateData(1, 0, 100, "inv_icon_players_state_dinner_res"));
        this.exchangeLocation = new int[]{0, 0};
        this.itemsLocation = new int[]{0, 0};
        this.inventoryLocation = new int[]{0, 0};
    }

    @Override
    public Unit invoke(InvActionButtonsData invActionButtonsData, View view) {
        invoke2(invActionButtonsData, view);
        return Unit.INSTANCE;
    }

    public final int getIntermediateOldPositionInInvIfUsed() {
        return this.intermediateOldPositionInInvIfUsed;
    }

    public final void setIntermediateOldPositionInInvIfUsed(int i) {
        this.intermediateOldPositionInInvIfUsed = i;
    }

    public final int getIntermediatePositionInSlot() {
        return this.intermediatePositionInSlot;
    }

    public final void setIntermediatePositionInSlot(int i) {
        this.intermediatePositionInSlot = i;
    }

    public final long getOldTimeWithMigrateAndUsed() {
        return this.oldTimeWithMigrateAndUsed;
    }

    public final void setOldTimeWithMigrateAndUsed(long j) {
        this.oldTimeWithMigrateAndUsed = j;
    }

    public final void setPlayersNick(String nick) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        inventoryLayoutUsersInventoryBinding.playersNameValue.setText(nick);
    }

    public final void setPlayersInfo(Integer[] array) {
        Function2<? super InvItems, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i = 0;
        while (true) {
            InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = null;
            if (i < length) {
                int i2 = i + 1;
                switch (i) {
                    case 0:
                        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
                        if (inventoryLayoutUsersInventoryBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding2;
                        }
                        TextView textView = inventoryLayoutUsersInventoryBinding.playersIdValue;
                        StringBuilder sb = new StringBuilder();
                        sb.append('(');
                        sb.append(array[0].intValue());
                        sb.append(')');
                        textView.setText(sb.toString());
                        break;
                    case 1:
                        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding3 = this.binding;
                        if (inventoryLayoutUsersInventoryBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding3;
                        }
                        inventoryLayoutUsersInventoryBinding.playersLevelValue.setText(String.valueOf(array[1].intValue()));
                        break;
                    case 2:
                        int intValue = array[2].intValue();
                        if (intValue == 0) {
                            InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding4 = this.binding;
                            if (inventoryLayoutUsersInventoryBinding4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding4;
                            }
                            inventoryLayoutUsersInventoryBinding.playersDonateStatusIcon.setImageResource(R.drawable.inv_icon_none_donate);
                            break;
                        } else if (intValue == 1) {
                            InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding5 = this.binding;
                            if (inventoryLayoutUsersInventoryBinding5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding5;
                            }
                            inventoryLayoutUsersInventoryBinding.playersDonateStatusIcon.setImageResource(R.drawable.inv_icon_silver_donate);
                            break;
                        } else if (intValue == 2) {
                            InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding6 = this.binding;
                            if (inventoryLayoutUsersInventoryBinding6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding6;
                            }
                            inventoryLayoutUsersInventoryBinding.playersDonateStatusIcon.setImageResource(R.drawable.inv_icon_gold_donate);
                            break;
                        } else if (intValue != 3) {
                            break;
                        } else {
                            InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding7 = this.binding;
                            if (inventoryLayoutUsersInventoryBinding7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding7;
                            }
                            inventoryLayoutUsersInventoryBinding.playersDonateStatusIcon.setImageResource(R.drawable.inv_icon_platinum_donate);
                            break;
                        }
                    case 3:
                        this.listPlayersStates.get(1).setThisValueState(array[3].intValue());
                        break;
                    case 4:
                        this.thisWeightInventory = array[4].intValue();
                        this.listPlayersStates.get(0).setThisValueState(array[4].intValue());
                        break;
                    case 5:
                        this.listPlayersStates.get(0).setMaxValueState(array[5].intValue());
                        this.maxWeightInventory = array[5].intValue();
                        setDataPlayersStateInfoInView();
                        break;
                    case 6:
                        this.activeSlotsInInventory = array[6].intValue();
                        break;
                    case 7:
                        if (array[7].intValue() == 0) {
                            setEmptyItem(this.listItemsInSlots.get(0));
                            break;
                        } else {
                            InvItems objectSimCard = this.mainRoot.getObjectSimCard();
                            objectSimCard.setTextIfException(String.valueOf(array[7].intValue()));
                            this.listItemsInSlots.remove(0);
                            this.listItemsInSlots.add(0, objectSimCard);
                            break;
                        }
                    case 8:
                        this.maxSlotsInInventory = array[8].intValue();
                        break;
                }
                i = i2;
            } else {
                setThisWeight(this.thisWeightInventory);
                setMaxWeight(this.maxWeightInventory);
                setEmptyItemsInInventory(this.maxSlotsInInventory);
                GUIUsersInventory gUIUsersInventory = this.mainRoot;
                List<InvItems> list = this.listItemsInInventory;
                Function2<? super InvItems, ? super Integer, Unit> function22 = this.onItemsClickListener;
                if (function22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("onItemsClickListener");
                    function2 = null;
                } else {
                    function2 = function22;
                }
                this.inventoryItemsAdapter = new InventoryItemsAdapter(gUIUsersInventory, list, function2, this, this.activeSlotsInInventory);
                setDataInInventoryInView();
                setDataPlayersButtonsActionInView();
                return;
            }
        }
    }

    public final void setItems(List<Object> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mainRoot.migrateDataFromAnyToObject(items, this.listItemsInInventory, false);
        changeStatusWhoseItem(this.listItemsInInventory);
    }

    public final void setItemsInSlot(List<Object> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mainRoot.migrateDataFromAnyToObject(items, this.listItemsInSlots, true);
    }

    private final void changeStatusWhoseItem(List<InvItems> list) {
        for (InvItems invItems : list) {
            if (invItems.getItemsValue() != 0) {
                invItems.setWhoseItem(0);
            }
        }
    }

    public final void setThisWeight(int i) {
        this.listPlayersStates.get(0).setThisValueState(i);
        InventoryPlayersStatesAdapter inventoryPlayersStatesAdapter = this.playersStatesAdapter;
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = null;
        if (inventoryPlayersStatesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playersStatesAdapter");
            inventoryPlayersStatesAdapter = null;
        }
        inventoryPlayersStatesAdapter.notifyItemChanged(0);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding2;
        }
        inventoryLayoutUsersInventoryBinding.invTitleActualWeight.setText(String.valueOf(i));
    }

    public final void setMaxWeight(int i) {
        this.listPlayersStates.get(0).setMaxValueState(i);
        InventoryPlayersStatesAdapter inventoryPlayersStatesAdapter = this.playersStatesAdapter;
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = null;
        if (inventoryPlayersStatesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playersStatesAdapter");
            inventoryPlayersStatesAdapter = null;
        }
        inventoryPlayersStatesAdapter.notifyItemChanged(0);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutUsersInventoryBinding = inventoryLayoutUsersInventoryBinding2;
        }
        inventoryLayoutUsersInventoryBinding.invTitleMaxWeight.setText(String.valueOf(i));
    }

    public final void updateSizeInventory(int i) {
        this.activeSlotsInInventory = i;
        InventoryItemsAdapter inventoryItemsAdapter = this.inventoryItemsAdapter;
        if (inventoryItemsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
            inventoryItemsAdapter = null;
        }
        inventoryItemsAdapter.notifyDataSetChanged();
    }

    public final void updateValueDinner(int i) {
        this.listPlayersStates.get(1).setThisValueState(i);
        InventoryPlayersStatesAdapter inventoryPlayersStatesAdapter = this.playersStatesAdapter;
        if (inventoryPlayersStatesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playersStatesAdapter");
            inventoryPlayersStatesAdapter = null;
        }
        inventoryPlayersStatesAdapter.notifyItemChanged(1);
    }

    public final void updateItems(List<InvItems> newListItemsInActiveSlot, List<InvItems> newListItemsInInventory) {
        Intrinsics.checkNotNullParameter(newListItemsInActiveSlot, "newListItemsInActiveSlot");
        Intrinsics.checkNotNullParameter(newListItemsInInventory, "newListItemsInInventory");
        this.listItemsInSlots.clear();
        this.listItemsInSlots.addAll(newListItemsInActiveSlot);
        this.listItemsInInventory.clear();
        this.listItemsInInventory.addAll(newListItemsInInventory);
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
        InventoryItemsAdapter inventoryItemsAdapter = null;
        if (inventoryItemsInSlotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            inventoryItemsInSlotAdapter = null;
        }
        inventoryItemsInSlotAdapter.notifyDataSetChanged();
        InventoryItemsAdapter inventoryItemsAdapter2 = this.inventoryItemsAdapter;
        if (inventoryItemsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
        } else {
            inventoryItemsAdapter = inventoryItemsAdapter2;
        }
        inventoryItemsAdapter.notifyDataSetChanged();
    }

    public final void renderMainSkin(int i) {
        Useful useful = new Useful();
        NvEventQueueActivity mainContext = this.mainRoot.getMainContext();
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        FrameLayout frameLayout = inventoryLayoutUsersInventoryBinding.playersSkinView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.playersSkinView");
        useful.renderSkin(mainContext, 2, Constants.ID_SKIN, i, 1, frameLayout);
    }

    @Override
    public View getView() {
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        LinearLayout root = inventoryLayoutUsersInventoryBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        InventoryLayoutUsersInventoryBinding inflate = InventoryLayoutUsersInventoryBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(context, R.anim.button_click)");
        this.anim = loadAnimation;
        setLogicForItemsClickListener();
        setStartViewSlots();
        setLogicForClickInSlot();
        setDataInSlotsView();
        clearItemsInfo();
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutUsersInventory.m347onCreateView$lambda1(UILayoutUsersInventory.this);
            }
        }, 200L);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        LinearLayout root = inventoryLayoutUsersInventoryBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m347onCreateView$lambda1(UILayoutUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getExchangeButton();
        this$0.getItemsPosition();
        this$0.getInventoryPosition();
    }

    private final void setDataPlayersButtonsActionInView() {
        this.actionsAdapter = new InventoryActionButtonsAdapter(this.mainRoot, Constants.INSTANCE.getListActionButtons(), this);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        InventoryActionButtonsAdapter inventoryActionButtonsAdapter = null;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        inventoryLayoutUsersInventoryBinding.invSymbolDiv.setVisibility(4);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding2 = null;
        }
        inventoryLayoutUsersInventoryBinding2.invTitleBag.setVisibility(4);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding3 = this.binding;
        if (inventoryLayoutUsersInventoryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding3 = null;
        }
        RecyclerView recyclerView = inventoryLayoutUsersInventoryBinding3.playersButtonsAction;
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding4 = this.binding;
        if (inventoryLayoutUsersInventoryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding4 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryLayoutUsersInventoryBinding4.getRoot().getContext(), 1, false));
        InventoryActionButtonsAdapter inventoryActionButtonsAdapter2 = this.actionsAdapter;
        if (inventoryActionButtonsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsAdapter");
        } else {
            inventoryActionButtonsAdapter = inventoryActionButtonsAdapter2;
        }
        recyclerView.setAdapter(inventoryActionButtonsAdapter);
    }

    private final void setDataPlayersStateInfoInView() {
        this.playersStatesAdapter = new InventoryPlayersStatesAdapter(this.mainRoot, this.listPlayersStates);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        InventoryPlayersStatesAdapter inventoryPlayersStatesAdapter = null;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutUsersInventoryBinding.playersStateInfo;
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryLayoutUsersInventoryBinding2.getRoot().getContext(), 0, false));
        InventoryPlayersStatesAdapter inventoryPlayersStatesAdapter2 = this.playersStatesAdapter;
        if (inventoryPlayersStatesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playersStatesAdapter");
        } else {
            inventoryPlayersStatesAdapter = inventoryPlayersStatesAdapter2;
        }
        recyclerView.setAdapter(inventoryPlayersStatesAdapter);
    }

    private final void setLogicForItemsClickListener() {
        this.onItemsClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                InventoryItemsAdapter inventoryItemsAdapter;
                InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter;
                int i2;
                int i3;
                List list;
                int i4;
                List list2;
                int i5;
                int i6;
                GUIUsersInventory gUIUsersInventory;
                List list3;
                int i7;
                int i8;
                GUIUsersInventory gUIUsersInventory2;
                List list4;
                int i9;
                int i10;
                int i11;
                GUIUsersInventory gUIUsersInventory3;
                List list5;
                int i12;
                List list6;
                int i13;
                int i14;
                int i15;
                GUIUsersInventory gUIUsersInventory4;
                int i16;
                GUIUsersInventory gUIUsersInventory5;
                List list7;
                int i17;
                int i18;
                GUIUsersInventory gUIUsersInventory6;
                GUIUsersInventory gUIUsersInventory7;
                GUIUsersInventory gUIUsersInventory8;
                int unused;
                Intrinsics.checkNotNullParameter(item, "item");
                item.setCheck(true);
                UILayoutUsersInventory.this.positionInInventory = i;
                inventoryItemsAdapter = UILayoutUsersInventory.this.inventoryItemsAdapter;
                InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = null;
                if (inventoryItemsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
                    inventoryItemsAdapter = null;
                }
                inventoryItemsAdapter.setCheckOnlyElement(i);
                inventoryItemsInSlotAdapter = UILayoutUsersInventory.this.itemsInSlotAdapter;
                if (inventoryItemsInSlotAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
                } else {
                    inventoryItemsInSlotAdapter2 = inventoryItemsInSlotAdapter;
                }
                inventoryItemsInSlotAdapter2.setCheckOnlyElement(-1);
                UILayoutUsersInventory.this.setInfoAboutItem(item);
                if (item.getItemsValue() != 0) {
                    UILayoutUsersInventory.this.oldPositionWithItem = i;
                    UILayoutUsersInventory.this.oldValue = item.getItemsValue();
                    UILayoutUsersInventory.this.clearInfoAboutSlot();
                    gUIUsersInventory6 = UILayoutUsersInventory.this.mainRoot;
                    if (gUIUsersInventory6.isTutor() && item.getId() == 346) {
                        gUIUsersInventory7 = UILayoutUsersInventory.this.mainRoot;
                        gUIUsersInventory7.getGuideClass().visibleHelp(false);
                        gUIUsersInventory8 = UILayoutUsersInventory.this.mainRoot;
                        gUIUsersInventory8.getGuideClass().getHelp(2);
                        return;
                    }
                    return;
                }
                i2 = UILayoutUsersInventory.this.oldPositionWithItem;
                if (i2 != -1) {
                    list6 = UILayoutUsersInventory.this.listItemsInInventory;
                    i13 = UILayoutUsersInventory.this.oldPositionWithItem;
                    if (((InvItems) list6.get(i13)).getItemsValue() != 0) {
                        if (UILayoutUsersInventory.this.getOldTimeWithMigrateAndUsed() == System.currentTimeMillis() || System.currentTimeMillis() - UILayoutUsersInventory.this.getOldTimeWithMigrateAndUsed() <= 1200) {
                            i14 = UILayoutUsersInventory.this.migrateCounter;
                            if (i14 == 0) {
                                gUIUsersInventory4 = UILayoutUsersInventory.this.mainRoot;
                                gUIUsersInventory4.sendMessageError("Перекладывать предмет можно раз в 1 сек");
                            }
                            UILayoutUsersInventory uILayoutUsersInventory = UILayoutUsersInventory.this;
                            i15 = uILayoutUsersInventory.migrateCounter;
                            uILayoutUsersInventory.migrateCounter = i15 + 1;
                            unused = uILayoutUsersInventory.migrateCounter;
                            UILayoutUsersInventory.this.clearInfoAboutInv();
                            return;
                        }
                        UILayoutUsersInventory.this.setOldTimeWithMigrateAndUsed(System.currentTimeMillis());
                        UILayoutUsersInventory.this.intermediatePositionInInv = i;
                        UILayoutUsersInventory uILayoutUsersInventory2 = UILayoutUsersInventory.this;
                        i16 = uILayoutUsersInventory2.oldPositionWithItem;
                        uILayoutUsersInventory2.setIntermediateOldPositionInInvIfUsed(i16);
                        gUIUsersInventory5 = UILayoutUsersInventory.this.mainRoot;
                        list7 = UILayoutUsersInventory.this.listItemsInInventory;
                        i17 = UILayoutUsersInventory.this.oldPositionWithItem;
                        int id = ((InvItems) list7.get(i17)).getId();
                        i18 = UILayoutUsersInventory.this.oldPositionWithItem;
                        gUIUsersInventory5.sendIdWithOldAndNewPositionsToServer(23, id, i18, i);
                        UILayoutUsersInventory.this.migrateCounter = 0;
                        return;
                    }
                }
                i3 = UILayoutUsersInventory.this.positionFromSlot;
                if (i3 != -1) {
                    list = UILayoutUsersInventory.this.listItemsInSlots;
                    i4 = UILayoutUsersInventory.this.positionFromSlot;
                    if (((InvItems) list.get(i4)).getItemsValue() != 0) {
                        list2 = UILayoutUsersInventory.this.listItemsInSlots;
                        i5 = UILayoutUsersInventory.this.positionFromSlot;
                        int id2 = ((InvItems) list2.get(i5)).getId();
                        if (id2 == 58) {
                            UILayoutUsersInventory.this.intermediatePositionInInv = i;
                            UILayoutUsersInventory uILayoutUsersInventory3 = UILayoutUsersInventory.this;
                            i6 = uILayoutUsersInventory3.positionFromSlot;
                            uILayoutUsersInventory3.setIntermediatePositionInSlot(i6);
                            gUIUsersInventory = UILayoutUsersInventory.this.mainRoot;
                            list3 = UILayoutUsersInventory.this.listItemsInSlots;
                            i7 = UILayoutUsersInventory.this.positionFromSlot;
                            gUIUsersInventory.sendIdAndPositionToServer(32, ((InvItems) list3.get(i7)).getId(), i);
                        } else if (id2 != 134) {
                            UILayoutUsersInventory.this.intermediatePositionInInv = i;
                            UILayoutUsersInventory uILayoutUsersInventory4 = UILayoutUsersInventory.this;
                            i10 = uILayoutUsersInventory4.positionFromSlot;
                            uILayoutUsersInventory4.setIntermediatePositionInSlot(i10);
                            i11 = UILayoutUsersInventory.this.positionFromSlot;
                            gUIUsersInventory3 = UILayoutUsersInventory.this.mainRoot;
                            list5 = UILayoutUsersInventory.this.listItemsInSlots;
                            i12 = UILayoutUsersInventory.this.positionFromSlot;
                            gUIUsersInventory3.sendIdWithOldAndNewPositionsToServer(4, ((InvItems) list5.get(i12)).getId(), i11 - 2, i);
                        } else {
                            UILayoutUsersInventory.this.intermediatePositionInInv = i;
                            UILayoutUsersInventory uILayoutUsersInventory5 = UILayoutUsersInventory.this;
                            i8 = uILayoutUsersInventory5.positionFromSlot;
                            uILayoutUsersInventory5.setIntermediatePositionInSlot(i8);
                            gUIUsersInventory2 = UILayoutUsersInventory.this.mainRoot;
                            list4 = UILayoutUsersInventory.this.listItemsInSlots;
                            i9 = UILayoutUsersInventory.this.positionFromSlot;
                            gUIUsersInventory2.sendIdWithOldAndNewPositionsToServer(4, ((InvItems) list4.get(i9)).getId(), 6, i);
                        }
                    }
                }
            }
        };
    }

    public final void setInfoAboutItem(InvItems invItems) {
        String str;
        if (invItems.getItemsValue() != 0) {
            double itemsValue = invItems.getItemsValue();
            double weight = invItems.getWeight();
            Double.isNaN(itemsValue);
            double d = itemsValue * weight;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            int id = invItems.getId();
            if (id != 58) {
                if (id != 59) {
                    if (id == 134) {
                        StringBuilder sb = new StringBuilder();
                        sb.append('(');
                        sb.append(invItems.getModelid());
                        sb.append(')');
                        str = sb.toString();
                    } else {
                        switch (id) {
                            case 81:
                            case 82:
                            case 83:
                                break;
                            default:
                                str = '(' + invItems.getItemsValue() + " ед.)";
                                break;
                        }
                    }
                }
                str = "";
            } else {
                str = "(тел.  " + invItems.getTextIfException() + ')';
            }
            String str2 = invItems.getName() + ' ' + str;
            InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
            if (inventoryLayoutUsersInventoryBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutUsersInventoryBinding = null;
            }
            inventoryLayoutUsersInventoryBinding.invTitleThisItem.setText(getContext().getString(R.string.inv_info_title_items, str2));
            inventoryLayoutUsersInventoryBinding.invInfoThisItem.setText(invItems.getDesc());
            inventoryLayoutUsersInventoryBinding.invValueItemsWeight.setVisibility(0);
            inventoryLayoutUsersInventoryBinding.invValueItemsWeight.setText(getContext().getString(R.string.inv_items_weight, format));
            inventoryLayoutUsersInventoryBinding.invIconThisItem.setImageBitmap(invItems.getThisBitmap());
            inventoryLayoutUsersInventoryBinding.invIconThisItem.setScaleX(-1.0f);
            return;
        }
        clearItemsInfo();
    }

    public final void clearItemsInfo() {
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding2 = null;
        }
        inventoryLayoutUsersInventoryBinding2.invIconThisItem.setImageBitmap(null);
        inventoryLayoutUsersInventoryBinding.invTitleThisItem.setText("");
        inventoryLayoutUsersInventoryBinding.invInfoThisItem.setText("");
        inventoryLayoutUsersInventoryBinding.invValueItemsWeight.setVisibility(4);
    }

    public final void migrateDataFromSlotToInv() {
        int i = this.intermediatePositionInSlot;
        if (i != -1 && this.intermediatePositionInInv != -1) {
            List<InvItems> list = this.listItemsInInventory;
            List<InvItems> list2 = this.listItemsInSlots;
            migrateDataToSlot(list, list2, list2.get(i), this.intermediatePositionInInv, this.intermediatePositionInSlot);
            InventoryItemsAdapter inventoryItemsAdapter = this.inventoryItemsAdapter;
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = null;
            if (inventoryItemsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
                inventoryItemsAdapter = null;
            }
            inventoryItemsAdapter.notifyItemChanged(this.intermediatePositionInInv);
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = this.itemsInSlotAdapter;
            if (inventoryItemsInSlotAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            } else {
                inventoryItemsInSlotAdapter = inventoryItemsInSlotAdapter2;
            }
            inventoryItemsInSlotAdapter.notifyItemChanged(this.intermediatePositionInSlot);
        }
        clearInfoAboutInv();
        clearInfoAboutSlot();
    }

    public final void migrateDataFromInvToSlot(int i) {
        int i2 = i != 6 ? i != 255 ? i + 2 : 0 : 1;
        if (this.intermediateOldPositionInInvIfUsed != -1) {
            if (this.listItemsInSlots.get(i2).getItemsValue() != 0) {
                changePositionWithSimCartOrSkin(this.listItemsInInventory.get(this.intermediateOldPositionInInvIfUsed), i2, this.intermediateOldPositionInInvIfUsed);
            } else {
                List<InvItems> list = this.listItemsInSlots;
                List<InvItems> list2 = this.listItemsInInventory;
                migrateDataToSlot(list, list2, list2.get(this.intermediateOldPositionInInvIfUsed), i2, this.intermediateOldPositionInInvIfUsed);
            }
            InventoryItemsAdapter inventoryItemsAdapter = this.inventoryItemsAdapter;
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = null;
            if (inventoryItemsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
                inventoryItemsAdapter = null;
            }
            inventoryItemsAdapter.notifyItemChanged(this.intermediateOldPositionInInvIfUsed);
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = this.itemsInSlotAdapter;
            if (inventoryItemsInSlotAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            } else {
                inventoryItemsInSlotAdapter = inventoryItemsInSlotAdapter2;
            }
            inventoryItemsInSlotAdapter.notifyItemChanged(i2);
        }
        clearInfoAboutSlot();
        clearInfoAboutInv();
    }

    private final void changePositionWithSimCartOrSkin(InvItems invItems, int i, int i2) {
        int id = invItems.getId();
        if (id == 58) {
            String textIfException = this.listItemsInSlots.get(i).getTextIfException();
            this.listItemsInSlots.get(i).setTextIfException(invItems.getTextIfException());
            invItems.setTextIfException(textIfException);
        } else if (id != 134) {
        } else {
            int modelid = this.listItemsInSlots.get(i).getModelid();
            Bitmap thisBitmap = this.listItemsInSlots.get(i).getThisBitmap();
            int modelid2 = invItems.getModelid();
            Bitmap thisBitmap2 = invItems.getThisBitmap();
            this.listItemsInSlots.get(i).setModelid(modelid2);
            this.listItemsInSlots.get(i).setThisBitmap(thisBitmap2);
            invItems.setModelid(modelid);
            invItems.setThisBitmap(thisBitmap);
        }
    }

    private final void migrateDataToSlot(List<InvItems> list, List<InvItems> list2, InvItems invItems, int i, int i2) {
        if (invItems == null) {
            return;
        }
        updateItemAfterMigrate(list.get(i), invItems, true);
        InvItems invItems2 = list2.get(i2);
        int i3 = this.oldValue - 1;
        this.oldValue = i3;
        if (i3 == 0) {
            setEmptyItem(invItems2);
        }
        invItems2.setItemsValue(this.oldValue);
    }

    public final void migrateDataInInv() {
        int i = this.intermediateOldPositionInInvIfUsed;
        if (i != -1 && this.intermediatePositionInInv != -1) {
            List<InvItems> list = this.listItemsInInventory;
            migrateData(list, list, list.get(i), this.intermediatePositionInInv, this.intermediateOldPositionInInvIfUsed);
            InventoryItemsAdapter inventoryItemsAdapter = this.inventoryItemsAdapter;
            InventoryItemsAdapter inventoryItemsAdapter2 = null;
            if (inventoryItemsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
                inventoryItemsAdapter = null;
            }
            inventoryItemsAdapter.notifyItemChanged(this.intermediatePositionInInv);
            InventoryItemsAdapter inventoryItemsAdapter3 = this.inventoryItemsAdapter;
            if (inventoryItemsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
            } else {
                inventoryItemsAdapter2 = inventoryItemsAdapter3;
            }
            inventoryItemsAdapter2.notifyItemChanged(this.intermediateOldPositionInInvIfUsed);
        }
        clearInfoAboutInv();
        this.intermediatePositionInInv = -1;
        this.intermediateOldPositionInInvIfUsed = -1;
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
        invItems.setWhoseItem(0);
        invItems.setThisBitmap(null);
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
        invItems.setWhoseItem(0);
        invItems.setThisBitmap(invItems2.getThisBitmap());
    }

    private final void migrateData(List<InvItems> list, List<InvItems> list2, InvItems invItems, int i, int i2) {
        if (invItems == null) {
            return;
        }
        updateItemAfterMigrate(list.get(i), invItems, false);
        InvItems invItems2 = list2.get(i2);
        setEmptyItem(invItems2);
        invItems2.setItemsValue(0);
    }

    private final void setEmptyItemsInInventory(int i) {
        this.listItemsInInventory.clear();
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                this.listItemsInInventory.add(Constants.INSTANCE.emptyItem());
                if (i2 == i) {
                    break;
                }
                i2 = i3;
            }
        }
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        inventoryLayoutUsersInventoryBinding.invListItemsInInventory.setItemViewCacheSize(i);
    }

    private final void setDataInInventoryInView() {
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        InventoryItemsAdapter inventoryItemsAdapter = null;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutUsersInventoryBinding.invListItemsInInventory;
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding2 = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(inventoryLayoutUsersInventoryBinding2.getRoot().getContext(), 4));
        InventoryItemsAdapter inventoryItemsAdapter2 = this.inventoryItemsAdapter;
        if (inventoryItemsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
        } else {
            inventoryItemsAdapter = inventoryItemsAdapter2;
        }
        recyclerView.setAdapter(inventoryItemsAdapter);
    }

    private final void setStartViewSlots() {
        int i = this.sizeSlots;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            this.listItemsInSlots.add(Constants.INSTANCE.emptyItem());
        }
    }

    private final void setDataInSlotsView() {
        List<InvItems> list = this.listItemsInSlots;
        Function2<? super InvItems, ? super Integer, Unit> function2 = this.onItemsInSlotClickListener;
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemsInSlotClickListener");
            function2 = null;
        }
        this.itemsInSlotAdapter = new InventoryItemsInSlotAdapter(list, function2, this.mainRoot.getMainContext(), true);
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutUsersInventoryBinding.playersSlots;
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding2 = this.binding;
        if (inventoryLayoutUsersInventoryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryLayoutUsersInventoryBinding2.getRoot().getContext(), 1, false));
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
                InventoryItemsAdapter inventoryItemsAdapter;
                int i2;
                List list;
                int i3;
                int i4;
                GUIUsersInventory gUIUsersInventory;
                List list2;
                int i5;
                int i6;
                InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter;
                Intrinsics.checkNotNullParameter(item, "item");
                inventoryItemsAdapter = UILayoutUsersInventory.this.inventoryItemsAdapter;
                InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = null;
                if (inventoryItemsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
                    inventoryItemsAdapter = null;
                }
                inventoryItemsAdapter.setCheckOnlyElement(-1);
                if (item.getItemsValue() != 0) {
                    UILayoutUsersInventory.this.positionFromSlot = i;
                    UILayoutUsersInventory.this.oldValue = item.getItemsValue();
                    UILayoutUsersInventory.this.clearInfoAboutInv();
                    UILayoutUsersInventory.this.setInfoAboutItem(item);
                    item.setCheck(true);
                    inventoryItemsInSlotAdapter = UILayoutUsersInventory.this.itemsInSlotAdapter;
                    if (inventoryItemsInSlotAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
                    } else {
                        inventoryItemsInSlotAdapter2 = inventoryItemsInSlotAdapter;
                    }
                    inventoryItemsInSlotAdapter2.notifyItemChanged(i);
                    inventoryItemsInSlotAdapter2.setCheckOnlyElement(i);
                    return;
                }
                i2 = UILayoutUsersInventory.this.oldPositionWithItem;
                if (i2 != -1) {
                    list = UILayoutUsersInventory.this.listItemsInInventory;
                    i3 = UILayoutUsersInventory.this.oldPositionWithItem;
                    if (((InvItems) list.get(i3)).getItemsValue() != 0) {
                        UILayoutUsersInventory uILayoutUsersInventory = UILayoutUsersInventory.this;
                        i4 = uILayoutUsersInventory.oldPositionWithItem;
                        uILayoutUsersInventory.setIntermediateOldPositionInInvIfUsed(i4);
                        gUIUsersInventory = UILayoutUsersInventory.this.mainRoot;
                        list2 = UILayoutUsersInventory.this.listItemsInInventory;
                        i5 = UILayoutUsersInventory.this.oldPositionWithItem;
                        int id = ((InvItems) list2.get(i5)).getId();
                        i6 = UILayoutUsersInventory.this.oldPositionWithItem;
                        gUIUsersInventory.sendIdAndPositionToServer(19, id, i6);
                    }
                }
            }
        };
    }

    public void invoke2(InvActionButtonsData actionButton, View view) {
        Intrinsics.checkNotNullParameter(actionButton, "actionButton");
        Intrinsics.checkNotNullParameter(view, "view");
        Animation animation = this.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        int typeMenu = actionButton.getTypeMenu();
        if (typeMenu == 7) {
            this.mainRoot.sendPressButton(25);
        } else if (typeMenu == 9) {
            if (this.oldPositionWithItem == -1) {
                this.mainRoot.sendMessageError("Предмет не выбран");
            } else {
                startPopupWindowDelete();
            }
        } else if (typeMenu != 19) {
        } else {
            int i = this.oldPositionWithItem;
            if (i != -1 && this.listItemsInInventory.get(i).getItemsValue() != 0) {
                if (this.oldTimeWithMigrateAndUsed != System.currentTimeMillis() && System.currentTimeMillis() - this.oldTimeWithMigrateAndUsed > 1200) {
                    this.oldTimeWithMigrateAndUsed = System.currentTimeMillis();
                    int i2 = this.oldPositionWithItem;
                    this.intermediateOldPositionInInvIfUsed = i2;
                    this.mainRoot.sendIdAndPositionToServer(19, this.listItemsInInventory.get(i2).getId(), this.oldPositionWithItem);
                    this.usedCounter = 0;
                    return;
                }
                if (this.usedCounter == 0) {
                    this.mainRoot.sendMessageError("Предмет можно использовать раз в 1 сек");
                }
                this.usedCounter++;
                return;
            }
            this.mainRoot.sendMessageError("Предмет не выбран");
        }
    }

    public final void deleteThisItem() {
        if (this.oldPositionWithItem != -1) {
            if (this.oldTimeDeleted != System.currentTimeMillis() && System.currentTimeMillis() - this.oldTimeDeleted > 1000) {
                this.oldTimeDeleted = System.currentTimeMillis();
                int i = this.oldPositionWithItem;
                this.intermediateOldPositionInInvIfUsed = i;
                this.mainRoot.sendIdAndPositionToServer(18, this.listItemsInInventory.get(i).getId(), this.oldPositionWithItem);
                this.deletedCounter = 0;
            } else {
                if (this.deletedCounter == 0) {
                    this.mainRoot.sendMessageError("Предмет можно удалять раз в 1 сек");
                }
                this.deletedCounter++;
            }
        }
        closePopupWindowDelete();
    }

    public final void deleteItem() {
        List<InvItems> list = this.listItemsInInventory;
        InventoryItemsAdapter inventoryItemsAdapter = this.inventoryItemsAdapter;
        if (inventoryItemsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
            inventoryItemsAdapter = null;
        }
        deleteItemAndUpdateView(list, inventoryItemsAdapter);
    }

    private final void deleteItemAndUpdateView(List<InvItems> list, InventoryItemsAdapter inventoryItemsAdapter) {
        int i = this.intermediateOldPositionInInvIfUsed;
        if (i != -1) {
            InvItems invItems = list.get(i);
            if (invItems.getItemsValue() != 0) {
                invItems.setItemsValue(invItems.getItemsValue() - 1);
                if (invItems.getItemsValue() == 0) {
                    setEmptyItem(invItems);
                    clearItemsInfo();
                }
            }
            inventoryItemsAdapter.notifyItemChanged(getIntermediateOldPositionInInvIfUsed());
            if (invItems.getItemsValue() == 0) {
                clearInfoAboutInv();
            }
        }
    }

    public final void clearInfoAboutSlot() {
        this.positionFromSlot = -1;
        this.intermediatePositionInSlot = -1;
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
        if (inventoryItemsInSlotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            inventoryItemsInSlotAdapter = null;
        }
        inventoryItemsInSlotAdapter.setCheckOnlyElement(this.positionFromSlot);
    }

    public final void clearInfoAboutInv() {
        this.oldPositionWithItem = -1;
        this.positionInInventory = -1;
        this.intermediateOldPositionInInvIfUsed = -1;
        this.intermediatePositionInInv = -1;
        InventoryItemsAdapter inventoryItemsAdapter = this.inventoryItemsAdapter;
        if (inventoryItemsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inventoryItemsAdapter");
            inventoryItemsAdapter = null;
        }
        inventoryItemsAdapter.setCheckOnlyElement(this.oldPositionWithItem);
    }

    public final void updateNumberForSimCard(int i) {
        if (i != 0) {
            this.listItemsInSlots.get(0).setTextIfException(String.valueOf(i));
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
            if (inventoryItemsInSlotAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
                inventoryItemsInSlotAdapter = null;
            }
            inventoryItemsInSlotAdapter.notifyItemChanged(0);
        }
    }

    private final void startPopupWindowDelete() {
        NvEventQueueActivity mainContext = this.mainRoot.getMainContext();
        LogicForDialogDelete logicForDialogDelete = null;
        Object systemService = mainContext == null ? null : mainContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        InventoryDialogApplyDeletItemBinding inflate = InventoryDialogApplyDeletItemBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.bindingDialogDelete = inflate;
        InventoryDialogApplyDeletItemBinding inventoryDialogApplyDeletItemBinding = this.bindingDialogDelete;
        if (inventoryDialogApplyDeletItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialogDelete");
            inventoryDialogApplyDeletItemBinding = null;
        }
        PopupWindow popupWindow = new PopupWindow((View) inventoryDialogApplyDeletItemBinding.getRoot(), -1, -1, true);
        this.dialogDeletePopupWindow = popupWindow;
        if (popupWindow != null) {
            NvEventQueueActivity mainContext2 = this.mainRoot.getMainContext();
            popupWindow.showAtLocation(mainContext2 == null ? null : mainContext2.getParentLayout(), 17, 0, 0);
        }
        InventoryDialogApplyDeletItemBinding inventoryDialogApplyDeletItemBinding2 = this.bindingDialogDelete;
        if (inventoryDialogApplyDeletItemBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialogDelete");
            inventoryDialogApplyDeletItemBinding2 = null;
        }
        LogicForDialogDelete logicForDialogDelete2 = new LogicForDialogDelete(this, inventoryDialogApplyDeletItemBinding2);
        this.logicForDialogDelete = logicForDialogDelete2;
        if (logicForDialogDelete2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logicForDialogDelete");
        } else {
            logicForDialogDelete = logicForDialogDelete2;
        }
        logicForDialogDelete.startDialogDelete();
    }

    public final void closePopupWindowDelete() {
        PopupWindow popupWindow = this.dialogDeletePopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.mainRoot.closeAndroidsInterface();
    }

    public final List<InvItems> getItemsFromActiveSlots() {
        return this.listItemsInSlots;
    }

    public final List<InvItems> getItemsFromInventory() {
        return this.listItemsInInventory;
    }

    public final int getSizeSlots() {
        return this.activeSlotsInInventory;
    }

    public final int getThisWeight() {
        return this.thisWeightInventory;
    }

    public final int getMaxWeight() {
        return this.maxWeightInventory;
    }

    public final int[] getExchangeLocation() {
        return this.exchangeLocation;
    }

    public final int getExchangeHeight() {
        return this.exchangeHeight;
    }

    public final void setExchangeHeight(int i) {
        this.exchangeHeight = i;
    }

    public final int getExchangeWidth() {
        return this.exchangeWidth;
    }

    public final void setExchangeWidth(int i) {
        this.exchangeWidth = i;
    }

    private final void getExchangeButton() {
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        View childAt = inventoryLayoutUsersInventoryBinding.playersButtonsAction.getChildAt(1);
        if (childAt != null) {
            childAt.getLocationInWindow(getExchangeLocation());
        }
        if (childAt == null) {
            return;
        }
        setExchangeHeight(childAt.getHeight());
        setExchangeWidth(childAt.getWidth());
    }

    public final int[] getItemsLocation() {
        return this.itemsLocation;
    }

    public final int getItemsHeight() {
        return this.itemsHeight;
    }

    public final void setItemsHeight(int i) {
        this.itemsHeight = i;
    }

    public final int getItemsWidth() {
        return this.itemsWidth;
    }

    public final void setItemsWidth(int i) {
        this.itemsWidth = i;
    }

    private final void getItemsPosition() {
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutUsersInventoryBinding.invListItemsInInventory;
        int i = -1;
        int i2 = 0;
        int size = this.listItemsInInventory.size();
        while (true) {
            if (i2 >= size) {
                break;
            }
            int i3 = i2 + 1;
            if (this.listItemsInInventory.get(i2).getId() == 346) {
                i = i2;
                break;
            }
            i2 = i3;
        }
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            childAt.getLocationInWindow(getItemsLocation());
        }
        if (childAt == null) {
            return;
        }
        setItemsHeight(childAt.getHeight());
        setItemsWidth(childAt.getWidth());
    }

    public final int[] getInventoryLocation() {
        return this.inventoryLocation;
    }

    public final int getInventoryHeight() {
        return this.inventoryHeight;
    }

    public final void setInventoryHeight(int i) {
        this.inventoryHeight = i;
    }

    public final int getInventoryWidth() {
        return this.inventoryWidth;
    }

    public final void setInventoryWidth(int i) {
        this.inventoryWidth = i;
    }

    private final void getInventoryPosition() {
        InventoryLayoutUsersInventoryBinding inventoryLayoutUsersInventoryBinding = this.binding;
        if (inventoryLayoutUsersInventoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutUsersInventoryBinding = null;
        }
        View view = inventoryLayoutUsersInventoryBinding.invBgItemsInBag;
        view.getLocationInWindow(getInventoryLocation());
        setInventoryHeight(view.getHeight());
        setInventoryWidth(view.getWidth());
    }
}
