package com.rockstargames.gtacr.gui.inventory;

import android.app.Dialog;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.InventoryDialogBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.InventoryMainButtonsAdapter;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.data.InvMainButtonsData;
import com.rockstargames.gtacr.data.MessageData;
import com.rockstargames.gtacr.gui.entertainmentSystem.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bE\u0018\u0000 ¤\u00012\u00020\u000126\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002j\u0002`\n:\u0002¤\u0001B\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010Z\u001a\u00020\tH\u0002J\b\u0010[\u001a\u00020\tH\u0002J\u0016\u0010\\\u001a\u00020\t2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0012\u0010^\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0006\u0010a\u001a\u00020\tJ\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0006\u0010c\u001a\u00020\rJ\b\u0010d\u001a\u0004\u0018\u00010(J\b\u0010e\u001a\u00020\rH\u0016J\"\u0010f\u001a\u0004\u0018\u00010\u00102\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020PH\u0002J\b\u0010j\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010k\u001a\u00020\u0010J\u0006\u0010l\u001a\u00020PJ\u0012\u0010m\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0006\u0010n\u001a\u00020\rJ\u0019\u0010o\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002J\b\u0010p\u001a\u000200H\u0016J\u0016\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\r2\u0006\u0010s\u001a\u000200J\u0018\u0010t\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\rH\u0002J*\u0010v\u001a\u00020\t2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020K0\u000f2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010x\u001a\u000200J\u0012\u0010y\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0006\u0010z\u001a\u00020\tJ\b\u0010{\u001a\u00020\tH\u0002J\u0018\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u0002002\b\u0010~\u001a\u0004\u0018\u00010PJ \u0010\u007f\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0007\u0010\u0081\u0001\u001a\u00020\rJ)\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020\rJ)\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020\rJ*\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0007\u0010\u0086\u0001\u001a\u00020\r2\u0007\u0010\u0087\u0001\u001a\u00020\rJ\u0010\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020PJ\u0019\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0007\u0010\u0089\u0001\u001a\u00020PJ\u0010\u0010\u008b\u0001\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\rJ\u0019\u0010\u008b\u0001\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\rJ\u0010\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\rJ\t\u0010\u008f\u0001\u001a\u00020\tH\u0002J\t\u0010\u0090\u0001\u001a\u00020\tH\u0002J=\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u0002002\u0007\u0010\u0093\u0001\u001a\u00020\r2\u0007\u0010\u0094\u0001\u001a\u00020P2\u0007\u0010\u0095\u0001\u001a\u00020\r2\u0007\u0010\u0096\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020\rJ\u0011\u0010\u0097\u0001\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u0010H\u0002J\u0010\u0010\u0098\u0001\u001a\u00020\t2\u0007\u0010\u0099\u0001\u001a\u000200J)\u0010\u009a\u0001\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010`2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010(2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\u0007\u0010\u009d\u0001\u001a\u00020\tJ\u000f\u0010\u009e\u0001\u001a\u00020\t2\u0006\u0010h\u001a\u00020\rJ\u001b\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\u00102\u0007\u0010¡\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010¢\u0001\u001a\u00020\t2\u0007\u0010£\u0001\u001a\u000200H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00102\"\u0004\b9\u00104R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R-\u0010>\u001a!\u0012\u0013\u0012\u001100¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\t0?j\u0002`AX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¥\u0001"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/InvMainButtonsData;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "mainButton", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/gui/inventory/OnMainButtonsClickListener;", "()V", "activeSlotsInInventory", "", "allItems", "", "Lblackrussia/online/network/InvItems;", "anim", "Landroid/view/animation/Animation;", "arrayForExchange", "", "[Ljava/lang/Integer;", "arrayForInventory", "binding", "Lblackrussia/online/databinding/InventoryDialogBinding;", "container", "Lcom/rockstargames/gtacr/common/UIContainer;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "counter", "currentHelpStep", "getCurrentHelpStep", "()I", "setCurrentHelpStep", "(I)V", "dialog", "Landroid/app/Dialog;", "dialogLogic", "Lcom/rockstargames/gtacr/gui/inventory/UIChat;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "guideClass", "Lcom/rockstargames/gtacr/gui/inventory/GuideForInventory;", "getGuideClass", "()Lcom/rockstargames/gtacr/gui/inventory/GuideForInventory;", "setGuideClass", "(Lcom/rockstargames/gtacr/gui/inventory/GuideForInventory;)V", "ifClickOtherButtonWithDismiss", "", "getIfClickOtherButtonWithDismiss", "()Z", "setIfClickOtherButtonWithDismiss", "(Z)V", "ifHaveSimCard", "inflater", "Landroid/view/LayoutInflater;", "isTutor", "setTutor", "layoutExchange", "Lcom/rockstargames/gtacr/gui/inventory/UILayoutExchange;", "layoutUsersInventory", "Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;", "listenerForChangeStatus", "Lkotlin/Function1;", "statusBlocker", "Lcom/rockstargames/gtacr/gui/inventory/ListenerForChangeStatus;", "mainButtonsAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryMainButtonsAdapter;", "maxSlotsInInventory", "maxWeight", "messages", "Lcom/rockstargames/gtacr/data/MessageData;", "newListWithButtons", "playersId", "playersItems", "", "playersItemsInSlot", "playersLevel", "playersMoney", "playersNick", "", "playersNickWithExchange", "playersSkin", "popupWindow", "Landroid/widget/PopupWindow;", "simCard", "thisWeight", "typeInterface", "typeVIP", "valueDinner", "addDataForExchange", "addDataForInventory", "addOtherParametersInList", "newList", "close", "json", "Lorg/json/JSONObject;", "closeAndroidsInterface", "getAllItems", "getCounter", "getGUIManager", "getGuiId", "getItemWithAllParameters", "idItem", "count", "text", "getMainContext", "getObjectSimCard", "getOtherPlayersNick", "getStartData", "getTypeInterface", "invoke", "isShowingGui", "layoutListener", "selectedLayout", "ifFirstOpen", "mainButtonsClickListener", "typeButton", "migrateDataFromAnyToObject", FirebaseAnalytics.Param.ITEMS, "ifSlot", "onPacketIncoming", "openChat", "openRadialMenu", "sendActionToChat", "action", "item", "sendIdAndPositionToServer", "typeKey", "positionInSlot", "sendIdWithCountAndSlotToServer", "position", "sendIdWithCountToServer", "sendIdWithOldAndNewPositionsToServer", "oldPosition", "newPosition", "sendMessageError", "message", "sendMessageToServer", "sendPressButton", "valueMoney", "setCounter", "newValue", "setLogicForChangedStatus", "setMainButtonsInView", "setNewMessage", "ifMyMessage", "fromMessage", "textMessage", "actionStatus", "itemsName", "setObjectSimCard", "setVisibleMainBlock", "isShow", "show", "manager", "activity", "startTutor", "updateCountWithNewMessages", "updateItemAfterMigrate", "thisItem", "migrateItem", "updateMainsButton", "ifHaveButtonBackToTheInventory", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIUsersInventory implements ISAMPGUI, Function2<InvMainButtonsData, View, Unit> {
    public static final Companion Companion = new Companion(null);
    private int activeSlotsInInventory;
    private Animation anim;
    private InventoryDialogBinding binding;
    private UIContainer container;
    private NvEventQueueActivity context;
    private int counter;
    private int currentHelpStep;
    private Dialog dialog;
    private UIChat dialogLogic;
    private GUIManager guiManager;
    public GuideForInventory guideClass;
    private boolean ifClickOtherButtonWithDismiss;
    private int ifHaveSimCard;
    private LayoutInflater inflater;
    private boolean isTutor;
    private UILayoutExchange layoutExchange;
    private UILayoutUsersInventory layoutUsersInventory;
    private Function1<? super Boolean, Unit> listenerForChangeStatus;
    private InventoryMainButtonsAdapter mainButtonsAdapter;
    private int maxWeight;
    private int playersId;
    private int playersLevel;
    private int playersMoney;
    private int playersSkin;
    private PopupWindow popupWindow;
    private int thisWeight;
    private int typeInterface;
    private int typeVIP;
    private int valueDinner;
    private String playersNick = "";
    private List<Object> playersItems = new ArrayList();
    private List<Object> playersItemsInSlot = new ArrayList();
    private Integer[] arrayForInventory = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private Integer[] arrayForExchange = {0, 0, 0, 0, 0, 0, 0};
    private String playersNickWithExchange = "";
    private int maxSlotsInInventory = 39;
    private List<InvItems> allItems = new ArrayList();
    private List<MessageData> messages = new ArrayList();
    private InvItems simCard = Constants.INSTANCE.emptyItem();
    private List<InvMainButtonsData> newListWithButtons = new ArrayList();

    @Override
    public int getGuiId() {
        return 33;
    }

    @Override
    public Unit invoke(InvMainButtonsData invMainButtonsData, View view) {
        invoke2(invMainButtonsData, view);
        return Unit.INSTANCE;
    }

    public final boolean getIfClickOtherButtonWithDismiss() {
        return this.ifClickOtherButtonWithDismiss;
    }

    public final void setIfClickOtherButtonWithDismiss(boolean z) {
        this.ifClickOtherButtonWithDismiss = z;
    }

    public final GuideForInventory getGuideClass() {
        GuideForInventory guideForInventory = this.guideClass;
        if (guideForInventory != null) {
            return guideForInventory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guideClass");
        return null;
    }

    public final void setGuideClass(GuideForInventory guideForInventory) {
        Intrinsics.checkNotNullParameter(guideForInventory, "<set-?>");
        this.guideClass = guideForInventory;
    }

    public final boolean isTutor() {
        return this.isTutor;
    }

    public final void setTutor(boolean z) {
        this.isTutor = z;
    }

    public final int getCurrentHelpStep() {
        return this.currentHelpStep;
    }

    public final void setCurrentHelpStep(int i) {
        this.currentHelpStep = i;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GUIUsersInventory newInstance() {
            return new GUIUsersInventory();
        }
    }

    public final void startTutor() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUIUsersInventory.m322startTutor$lambda0(GUIUsersInventory.this);
            }
        }, 300L);
    }

    public static final void m322startTutor$lambda0(GUIUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isTutor = true;
        this$0.getGuideClass().getHelp(1);
    }

    public final void setVisibleMainBlock(boolean z) {
        InventoryDialogBinding inventoryDialogBinding = null;
        if (z) {
            InventoryDialogBinding inventoryDialogBinding2 = this.binding;
            if (inventoryDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                inventoryDialogBinding = inventoryDialogBinding2;
            }
            inventoryDialogBinding.invMainButtonsBlock.setVisibility(0);
            return;
        }
        InventoryDialogBinding inventoryDialogBinding3 = this.binding;
        if (inventoryDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryDialogBinding = inventoryDialogBinding3;
        }
        inventoryDialogBinding.invMainButtonsBlock.setVisibility(4);
    }

    public final void setCounter(int i) {
        this.counter = i;
    }

    public final int getCounter() {
        return this.counter;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        UILayoutUsersInventory uILayoutUsersInventory = null;
        UILayoutUsersInventory uILayoutUsersInventory2 = null;
        UILayoutUsersInventory uILayoutUsersInventory3 = null;
        UILayoutUsersInventory uILayoutUsersInventory4 = null;
        UILayoutUsersInventory uILayoutUsersInventory5 = null;
        UILayoutUsersInventory uILayoutUsersInventory6 = null;
        UILayoutExchange uILayoutExchange = null;
        UILayoutExchange uILayoutExchange2 = null;
        UILayoutExchange uILayoutExchange3 = null;
        UILayoutExchange uILayoutExchange4 = null;
        UILayoutExchange uILayoutExchange5 = null;
        UILayoutExchange uILayoutExchange6 = null;
        UILayoutExchange uILayoutExchange7 = null;
        UILayoutExchange uILayoutExchange8 = null;
        UILayoutExchange uILayoutExchange9 = null;
        UILayoutExchange uILayoutExchange10 = null;
        UILayoutExchange uILayoutExchange11 = null;
        UILayoutExchange uILayoutExchange12 = null;
        UILayoutUsersInventory uILayoutUsersInventory7 = null;
        Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("t"));
        Integer valueOf2 = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("s"));
        if (valueOf != null && valueOf.intValue() == 4) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            int optInt = jSONObject.optInt(GetKeys.GET_NEW_MAX_WEIGHT);
            int optInt2 = jSONObject.optInt(GetKeys.GET_NEW_SIZE_INVENTORY);
            UILayoutUsersInventory uILayoutUsersInventory8 = this.layoutUsersInventory;
            if (uILayoutUsersInventory8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory8 = null;
            }
            uILayoutUsersInventory8.migrateDataFromSlotToInv();
            UILayoutUsersInventory uILayoutUsersInventory9 = this.layoutUsersInventory;
            if (uILayoutUsersInventory9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory9 = null;
            }
            uILayoutUsersInventory9.setMaxWeight(optInt);
            if (optInt2 != 0) {
                UILayoutUsersInventory uILayoutUsersInventory10 = this.layoutUsersInventory;
                if (uILayoutUsersInventory10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                } else {
                    uILayoutUsersInventory2 = uILayoutUsersInventory10;
                }
                uILayoutUsersInventory2.updateSizeInventory(optInt2 - 1);
            }
        } else if (valueOf != null && valueOf.intValue() == 23) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            UILayoutUsersInventory uILayoutUsersInventory11 = this.layoutUsersInventory;
            if (uILayoutUsersInventory11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            } else {
                uILayoutUsersInventory3 = uILayoutUsersInventory11;
            }
            uILayoutUsersInventory3.migrateDataInInv();
        } else if (valueOf != null && valueOf.intValue() == 20) {
            int optInt3 = jSONObject.optInt("i");
            UILayoutUsersInventory uILayoutUsersInventory12 = this.layoutUsersInventory;
            if (uILayoutUsersInventory12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            } else {
                uILayoutUsersInventory4 = uILayoutUsersInventory12;
            }
            uILayoutUsersInventory4.updateValueDinner(optInt3);
        } else if (valueOf != null && valueOf.intValue() == 18) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            int optInt4 = jSONObject.optInt("w");
            UILayoutUsersInventory uILayoutUsersInventory13 = this.layoutUsersInventory;
            if (uILayoutUsersInventory13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory13 = null;
            }
            uILayoutUsersInventory13.deleteItem();
            if (optInt4 != 0) {
                UILayoutUsersInventory uILayoutUsersInventory14 = this.layoutUsersInventory;
                if (uILayoutUsersInventory14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                } else {
                    uILayoutUsersInventory5 = uILayoutUsersInventory14;
                }
                uILayoutUsersInventory5.setThisWeight(optInt4);
            }
        } else if (valueOf != null && valueOf.intValue() == 19) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            int optInt5 = jSONObject.optInt("w");
            int optInt6 = jSONObject.optInt("i");
            int optInt7 = jSONObject.optInt(GetKeys.GET_NEW_MAX_WEIGHT);
            int optInt8 = jSONObject.optInt(GetKeys.GET_NEW_SIZE_INVENTORY);
            if (optInt5 != 0) {
                UILayoutUsersInventory uILayoutUsersInventory15 = this.layoutUsersInventory;
                if (uILayoutUsersInventory15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                    uILayoutUsersInventory15 = null;
                }
                uILayoutUsersInventory15.setThisWeight(optInt5);
            }
            if (optInt6 > -1) {
                UILayoutUsersInventory uILayoutUsersInventory16 = this.layoutUsersInventory;
                if (uILayoutUsersInventory16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                    uILayoutUsersInventory16 = null;
                }
                uILayoutUsersInventory16.migrateDataFromInvToSlot(optInt6);
            } else {
                UILayoutUsersInventory uILayoutUsersInventory17 = this.layoutUsersInventory;
                if (uILayoutUsersInventory17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                    uILayoutUsersInventory17 = null;
                }
                uILayoutUsersInventory17.deleteItem();
            }
            if (optInt7 != 0) {
                UILayoutUsersInventory uILayoutUsersInventory18 = this.layoutUsersInventory;
                if (uILayoutUsersInventory18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                    uILayoutUsersInventory18 = null;
                }
                uILayoutUsersInventory18.setMaxWeight(optInt7);
            }
            if (optInt8 != 0) {
                UILayoutUsersInventory uILayoutUsersInventory19 = this.layoutUsersInventory;
                if (uILayoutUsersInventory19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                } else {
                    uILayoutUsersInventory6 = uILayoutUsersInventory19;
                }
                uILayoutUsersInventory6.updateSizeInventory(optInt8);
            }
        } else if (valueOf != null && valueOf.intValue() == 16) {
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow == null) {
                return;
            }
            popupWindow.dismiss();
            Unit unit = Unit.INSTANCE;
        } else if (valueOf != null && valueOf.intValue() == 8) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            UILayoutExchange uILayoutExchange13 = this.layoutExchange;
            if (uILayoutExchange13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange = uILayoutExchange13;
            }
            uILayoutExchange.changeStatusInInterface(8);
        } else if (valueOf != null && valueOf.intValue() == 7) {
            UILayoutExchange uILayoutExchange14 = this.layoutExchange;
            if (uILayoutExchange14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange2 = uILayoutExchange14;
            }
            uILayoutExchange2.listenerStatusAfterClickCancel(valueOf2);
        } else if (valueOf != null && valueOf.intValue() == 26) {
            UILayoutExchange uILayoutExchange15 = this.layoutExchange;
            if (uILayoutExchange15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange3 = uILayoutExchange15;
            }
            uILayoutExchange3.changeStatusInInterface(26);
        } else if (valueOf != null && valueOf.intValue() == 17) {
            String optString = jSONObject.optString(GetKeys.GET_PLAYERS_NICK_WITH_EXCHANGE);
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(GET_PLAYERS_NICK_WITH_EXCHANGE)");
            this.playersNickWithExchange = optString;
            UILayoutExchange uILayoutExchange16 = this.layoutExchange;
            if (uILayoutExchange16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange4 = uILayoutExchange16;
            }
            uILayoutExchange4.setPlayersNick(this.playersNickWithExchange);
            layoutListener(1, false);
        } else if (valueOf != null && valueOf.intValue() == 3) {
            int optInt9 = jSONObject.optInt(GetKeys.GET_OTHER_PLAYERS_MONEY);
            this.counter++;
            UILayoutExchange uILayoutExchange17 = this.layoutExchange;
            if (uILayoutExchange17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange5 = uILayoutExchange17;
            }
            uILayoutExchange5.setOtherPlayersMoney(optInt9);
        } else if (valueOf != null && valueOf.intValue() == 27) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            int optInt10 = jSONObject.optInt(GetKeys.GET_NEW_MAX_WEIGHT);
            int optInt11 = jSONObject.optInt(GetKeys.GET_NEW_SIZE_INVENTORY);
            UILayoutExchange uILayoutExchange18 = this.layoutExchange;
            if (uILayoutExchange18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange18 = null;
            }
            uILayoutExchange18.migrateFromSlotToInventory();
            if (optInt10 != 0) {
                UILayoutExchange uILayoutExchange19 = this.layoutExchange;
                if (uILayoutExchange19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                    uILayoutExchange19 = null;
                }
                uILayoutExchange19.setMaxWeightInventory(optInt10);
            }
            if (optInt11 != 0) {
                UILayoutExchange uILayoutExchange20 = this.layoutExchange;
                if (uILayoutExchange20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                } else {
                    uILayoutExchange6 = uILayoutExchange20;
                }
                uILayoutExchange6.updateSizeInventory(optInt11 - 1);
            }
        } else if (valueOf != null && valueOf.intValue() == 0) {
            int optInt12 = jSONObject.optInt("ga");
            int optInt13 = jSONObject.optInt("s");
            String text = jSONObject.optString("nt");
            this.counter++;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            InvItems itemWithAllParameters = getItemWithAllParameters(optInt12, optInt13, text);
            UILayoutExchange uILayoutExchange21 = this.layoutExchange;
            if (uILayoutExchange21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange7 = uILayoutExchange21;
            }
            uILayoutExchange7.addNewItemsOtherPlayers(itemWithAllParameters);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            int optInt14 = jSONObject.optInt("ga");
            int optInt15 = jSONObject.optInt("s");
            String numberPlate = jSONObject.optString("nt");
            this.counter++;
            UILayoutExchange uILayoutExchange22 = this.layoutExchange;
            if (uILayoutExchange22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange8 = uILayoutExchange22;
            }
            Intrinsics.checkNotNullExpressionValue(numberPlate, "numberPlate");
            uILayoutExchange8.editValueItems(optInt14, optInt15, numberPlate);
        } else if (valueOf != null && valueOf.intValue() == 5) {
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                UILayoutExchange uILayoutExchange23 = this.layoutExchange;
                if (uILayoutExchange23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                    uILayoutExchange23 = null;
                }
                uILayoutExchange23.setOldValueOnMyList();
                UILayoutExchange uILayoutExchange24 = this.layoutExchange;
                if (uILayoutExchange24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                } else {
                    uILayoutExchange9 = uILayoutExchange24;
                }
                uILayoutExchange9.clearAllMigrateItem();
            } else if (valueOf2 != null && valueOf2.intValue() == 1) {
                int optInt16 = jSONObject.optInt("w");
                UILayoutExchange uILayoutExchange25 = this.layoutExchange;
                if (uILayoutExchange25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                    uILayoutExchange25 = null;
                }
                uILayoutExchange25.setThisWeightInventory(optInt16, false);
                UILayoutExchange uILayoutExchange26 = this.layoutExchange;
                if (uILayoutExchange26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                } else {
                    uILayoutExchange10 = uILayoutExchange26;
                }
                uILayoutExchange10.migrateItemFromInvToExchange();
            }
        } else if (valueOf != null && valueOf.intValue() == 24) {
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                UILayoutExchange uILayoutExchange27 = this.layoutExchange;
                if (uILayoutExchange27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                    uILayoutExchange27 = null;
                }
                uILayoutExchange27.setOldValueOnMyExchangeList();
                UILayoutExchange uILayoutExchange28 = this.layoutExchange;
                if (uILayoutExchange28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                } else {
                    uILayoutExchange11 = uILayoutExchange28;
                }
                uILayoutExchange11.clearAllMigrateItem();
            } else if (valueOf2 != null && valueOf2.intValue() == 1) {
                int optInt17 = jSONObject.optInt("w");
                UILayoutExchange uILayoutExchange29 = this.layoutExchange;
                if (uILayoutExchange29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                    uILayoutExchange29 = null;
                }
                uILayoutExchange29.setThisWeightInventory(optInt17, false);
                UILayoutExchange uILayoutExchange30 = this.layoutExchange;
                if (uILayoutExchange30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                } else {
                    uILayoutExchange12 = uILayoutExchange30;
                }
                uILayoutExchange12.migrateFromExchangeToInv();
            }
        } else if (valueOf != null && valueOf.intValue() == 31) {
            String messageFromPlayer = jSONObject.optString("tx");
            int i = this.counter + 1;
            this.counter = i;
            updateCountWithNewMessages(i);
            Intrinsics.checkNotNullExpressionValue(messageFromPlayer, "messageFromPlayer");
            setNewMessage(false, 0, messageFromPlayer, 0, "", 0);
        } else if (valueOf != null && valueOf.intValue() == 32) {
            if ((valueOf2 != null && valueOf2.intValue() == 0) || valueOf2 == null || valueOf2.intValue() != 1) {
                return;
            }
            UILayoutUsersInventory uILayoutUsersInventory20 = this.layoutUsersInventory;
            if (uILayoutUsersInventory20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            } else {
                uILayoutUsersInventory7 = uILayoutUsersInventory20;
            }
            uILayoutUsersInventory7.migrateDataFromSlotToInv();
        } else if (valueOf != null && valueOf.intValue() == 33) {
            int optInt18 = jSONObject.optInt(Utils.KEY_GET_ARR_WITH_PLAYERS_START);
            UILayoutUsersInventory uILayoutUsersInventory21 = this.layoutUsersInventory;
            if (uILayoutUsersInventory21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            } else {
                uILayoutUsersInventory = uILayoutUsersInventory21;
            }
            uILayoutUsersInventory.renderMainSkin(optInt18);
        } else if (valueOf != null && valueOf.intValue() == 34) {
            this.ifClickOtherButtonWithDismiss = true;
        }
    }

    public final NvEventQueueActivity getMainContext() {
        return this.context;
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity nvEventQueueActivity) {
        this.context = nvEventQueueActivity;
        this.guiManager = gUIManager;
        UILayoutExchange uILayoutExchange = null;
        if (this.popupWindow == null) {
            Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            this.inflater = layoutInflater;
            if (layoutInflater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflater");
                layoutInflater = null;
            }
            InventoryDialogBinding inflate = InventoryDialogBinding.inflate(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            this.anim = loadAnimation;
            InventoryDialogBinding inventoryDialogBinding = this.binding;
            if (inventoryDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryDialogBinding = null;
            }
            this.popupWindow = new PopupWindow((View) inventoryDialogBinding.getRoot(), -1, -1, true);
            this.allItems.addAll(getAllItems());
            setLogicForChangedStatus();
            getStartData(jSONObject);
            GlobalValue.INSTANCE.setGlobalStatusBlocker(false);
            this.layoutUsersInventory = new UILayoutUsersInventory(this);
            Function1<? super Boolean, Unit> function1 = this.listenerForChangeStatus;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerForChangeStatus");
                function1 = null;
            }
            this.layoutExchange = new UILayoutExchange(this, function1);
            InventoryDialogBinding inventoryDialogBinding2 = this.binding;
            if (inventoryDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryDialogBinding2 = null;
            }
            UIContainer uIContainer = inventoryDialogBinding2.invContainer;
            Intrinsics.checkNotNullExpressionValue(uIContainer, "binding.invContainer");
            this.container = uIContainer;
            if (uIContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                uIContainer = null;
            }
            UILayoutUsersInventory uILayoutUsersInventory = this.layoutUsersInventory;
            if (uILayoutUsersInventory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory = null;
            }
            uIContainer.addLayout(0, uILayoutUsersInventory);
            UIContainer uIContainer2 = this.container;
            if (uIContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                uIContainer2 = null;
            }
            UILayoutExchange uILayoutExchange2 = this.layoutExchange;
            if (uILayoutExchange2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange2 = null;
            }
            uIContainer2.addLayout(1, uILayoutExchange2);
            InventoryDialogBinding inventoryDialogBinding3 = this.binding;
            if (inventoryDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryDialogBinding3 = null;
            }
            inventoryDialogBinding3.invMainButtonExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIUsersInventory.m319show$lambda3(GUIUsersInventory.this, view);
                }
            });
        }
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 != null) {
            nvEventQueueActivity2.toggleDrawing2dStuff(true);
        }
        closeAndroidsInterface();
        PopupWindow popupWindow = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(nvEventQueueActivity == null ? null : nvEventQueueActivity.getParentLayout(), 17, 0, 0);
        }
        addDataForInventory();
        addDataForExchange();
        UILayoutUsersInventory uILayoutUsersInventory2 = this.layoutUsersInventory;
        if (uILayoutUsersInventory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory2 = null;
        }
        uILayoutUsersInventory2.setPlayersInfo(this.arrayForInventory);
        UILayoutUsersInventory uILayoutUsersInventory3 = this.layoutUsersInventory;
        if (uILayoutUsersInventory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory3 = null;
        }
        uILayoutUsersInventory3.setPlayersNick(this.playersNick);
        UILayoutUsersInventory uILayoutUsersInventory4 = this.layoutUsersInventory;
        if (uILayoutUsersInventory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory4 = null;
        }
        uILayoutUsersInventory4.setItems(this.playersItems);
        UILayoutUsersInventory uILayoutUsersInventory5 = this.layoutUsersInventory;
        if (uILayoutUsersInventory5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory5 = null;
        }
        uILayoutUsersInventory5.setItemsInSlot(this.playersItemsInSlot);
        UILayoutUsersInventory uILayoutUsersInventory6 = this.layoutUsersInventory;
        if (uILayoutUsersInventory6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory6 = null;
        }
        uILayoutUsersInventory6.renderMainSkin(this.playersSkin);
        UILayoutExchange uILayoutExchange3 = this.layoutExchange;
        if (uILayoutExchange3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            uILayoutExchange3 = null;
        }
        uILayoutExchange3.setPlayersInfo(this.arrayForExchange);
        UILayoutExchange uILayoutExchange4 = this.layoutExchange;
        if (uILayoutExchange4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            uILayoutExchange4 = null;
        }
        uILayoutExchange4.setPlayersNick(this.playersNickWithExchange);
        UILayoutExchange uILayoutExchange5 = this.layoutExchange;
        if (uILayoutExchange5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            uILayoutExchange5 = null;
        }
        uILayoutExchange5.setItems(this.playersItems);
        UILayoutExchange uILayoutExchange6 = this.layoutExchange;
        if (uILayoutExchange6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            uILayoutExchange6 = null;
        }
        uILayoutExchange6.setItemsInSlot(this.playersItemsInSlot);
        updateCountWithNewMessages(this.counter);
        layoutListener(this.typeInterface, true);
        UILayoutUsersInventory uILayoutUsersInventory7 = this.layoutUsersInventory;
        if (uILayoutUsersInventory7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory7 = null;
        }
        uILayoutUsersInventory7.updateNumberForSimCard(this.ifHaveSimCard);
        List<InvMainButtonsData> list = this.newListWithButtons;
        list.clear();
        list.addAll(Constants.INSTANCE.getListButtons());
        setMainButtonsInView();
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUIUsersInventory.m321show$lambda5(GUIUsersInventory.this);
                }
            });
        }
        InventoryDialogBinding inventoryDialogBinding4 = this.binding;
        if (inventoryDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryDialogBinding4 = null;
        }
        UILayoutUsersInventory uILayoutUsersInventory8 = this.layoutUsersInventory;
        if (uILayoutUsersInventory8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            uILayoutUsersInventory8 = null;
        }
        UILayoutExchange uILayoutExchange7 = this.layoutExchange;
        if (uILayoutExchange7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
        } else {
            uILayoutExchange = uILayoutExchange7;
        }
        setGuideClass(new GuideForInventory(inventoryDialogBinding4, uILayoutUsersInventory8, uILayoutExchange));
    }

    public static final void m319show$lambda3(GUIUsersInventory this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InventoryDialogBinding inventoryDialogBinding = this$0.binding;
        Animation animation = null;
        if (inventoryDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryDialogBinding = null;
        }
        if (inventoryDialogBinding.invMainButtonExit.getAlpha() == 1.0f) {
            Animation animation2 = this$0.anim;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
            } else {
                animation = animation2;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    GUIUsersInventory.m320show$lambda3$lambda2(this$0);
                }
            }, 250L);
        }
    }

    public static final void m320show$lambda3$lambda2(GUIUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ifClickOtherButtonWithDismiss = false;
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m321show$lambda5(GUIUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity != null) {
            //nvEventQueueActivity.toggleDrawing2dStuff(false);
        }
        UIChat uIChat = this$0.dialogLogic;
        if (uIChat != null) {
            uIChat.closeChat();
        }
        if (!this$0.ifClickOtherButtonWithDismiss) {
            this$0.sendPressButton(16);
        }
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager == null) {
            return;
        }
        gUIManager.closeGUI(null, 33);
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

    public final InvItems getObjectSimCard() {
        return this.simCard;
    }

    private final void setLogicForChangedStatus() {
        this.listenerForChangeStatus = new Function1<Boolean, Unit>() {
            @Override
            public Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public void invoke(boolean z) {
                InventoryDialogBinding inventoryDialogBinding;
                InventoryDialogBinding inventoryDialogBinding2;
                InventoryDialogBinding inventoryDialogBinding3;
                InventoryDialogBinding inventoryDialogBinding4;
                InventoryDialogBinding inventoryDialogBinding5 = null;
                if (z) {
                    inventoryDialogBinding3 = GUIUsersInventory.this.binding;
                    if (inventoryDialogBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        inventoryDialogBinding3 = null;
                    }
                    inventoryDialogBinding3.invMainButtonExit.setAlpha(0.2f);
                    inventoryDialogBinding4 = GUIUsersInventory.this.binding;
                    if (inventoryDialogBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        inventoryDialogBinding5 = inventoryDialogBinding4;
                    }
                    inventoryDialogBinding5.invMainButtons.setAlpha(0.2f);
                } else if (z) {
                } else {
                    inventoryDialogBinding = GUIUsersInventory.this.binding;
                    if (inventoryDialogBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        inventoryDialogBinding = null;
                    }
                    inventoryDialogBinding.invMainButtonExit.setAlpha(1.0f);
                    inventoryDialogBinding2 = GUIUsersInventory.this.binding;
                    if (inventoryDialogBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        inventoryDialogBinding5 = inventoryDialogBinding2;
                    }
                    inventoryDialogBinding5.invMainButtons.setAlpha(1.0f);
                }
            }
        };
    }

    private final void setMainButtonsInView() {
        this.mainButtonsAdapter = new InventoryMainButtonsAdapter(this, this.newListWithButtons, this);
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        InventoryMainButtonsAdapter inventoryMainButtonsAdapter = null;
        if (inventoryDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryDialogBinding = null;
        }
        RecyclerView recyclerView = inventoryDialogBinding.invMainButtons;
        InventoryDialogBinding inventoryDialogBinding2 = this.binding;
        if (inventoryDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryDialogBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryDialogBinding2.getRoot().getContext(), 1, false));
        InventoryMainButtonsAdapter inventoryMainButtonsAdapter2 = this.mainButtonsAdapter;
        if (inventoryMainButtonsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainButtonsAdapter");
        } else {
            inventoryMainButtonsAdapter = inventoryMainButtonsAdapter2;
        }
        recyclerView.setAdapter(inventoryMainButtonsAdapter);
    }

    public final void closeAndroidsInterface() {
        FrameLayout parentLayout;
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null || (parentLayout = nvEventQueueActivity.getParentLayout()) == null) {
            return;
        }
        parentLayout.postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUIUsersInventory.m312closeAndroidsInterface$lambda11(GUIUsersInventory.this);
            }
        }, 300L);
    }

    public static final void m312closeAndroidsInterface$lambda11(GUIUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            PopupWindow popupWindow = this$0.popupWindow;
            Intrinsics.checkNotNull(popupWindow);
            GUIManager.hideSystemUI(popupWindow.getContentView());
        } catch (Exception unused) {
            NvEventQueueActivity nvEventQueueActivity = this$0.context;
            Intrinsics.checkNotNull(nvEventQueueActivity);
            nvEventQueueActivity.getParentLayout().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    GUIUsersInventory.m313closeAndroidsInterface$lambda11$lambda10(this$0);
                }
            }, 1000L);
        }
    }

    public static final void m313closeAndroidsInterface$lambda11$lambda10(GUIUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
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

    public void invoke2(InvMainButtonsData mainButton, View view) {
        Intrinsics.checkNotNullParameter(mainButton, "mainButton");
        Intrinsics.checkNotNullParameter(view, "view");
        UILayoutExchange uILayoutExchange = this.layoutExchange;
        Animation animation = null;
        if (uILayoutExchange == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            uILayoutExchange = null;
        }
        if (uILayoutExchange.getStatusApply() == 0) {
            Animation animation2 = this.anim;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
            } else {
                animation = animation2;
            }
            view.startAnimation(animation);
            int typeMenu = mainButton.getTypeMenu();
            if (typeMenu == 0) {
                mainButtonsClickListener(mainButton, 10);
                PopupWindow popupWindow = this.popupWindow;
                if (popupWindow == null) {
                    return;
                }
                popupWindow.dismiss();
            } else if (typeMenu == 1) {
                mainButtonsClickListener(mainButton, 11);
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 == null) {
                    return;
                }
                popupWindow2.dismiss();
            } else if (typeMenu == 2) {
                mainButtonsClickListener(mainButton, 12);
                PopupWindow popupWindow3 = this.popupWindow;
                if (popupWindow3 == null) {
                    return;
                }
                popupWindow3.dismiss();
            } else if (typeMenu == 3) {
                openRadialMenu();
                mainButtonsClickListener(mainButton, 13);
                PopupWindow popupWindow4 = this.popupWindow;
                if (popupWindow4 == null) {
                    return;
                }
                popupWindow4.dismiss();
            } else if (typeMenu != 4) {
                if (typeMenu != 5) {
                    return;
                }
                mainButtonsClickListener(mainButton, 15);
            } else {
                mainButtonsClickListener(mainButton, 14);
                PopupWindow popupWindow5 = this.popupWindow;
                if (popupWindow5 == null) {
                    return;
                }
                popupWindow5.dismiss();
            }
        }
    }

    private final void mainButtonsClickListener(InvMainButtonsData invMainButtonsData, int i) {
        if (i != 15) {
            this.ifClickOtherButtonWithDismiss = true;
        }
        sendPressButton(i);
    }

    private final void openRadialMenu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.onPacketIncoming(14, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void layoutListener(int i, boolean z) {
        UILayoutExchange uILayoutExchange = null;
        UILayoutUsersInventory uILayoutUsersInventory = null;
        if (i == 0) {
            UIContainer uIContainer = this.container;
            if (uIContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                uIContainer = null;
            }
            uIContainer.setCurrentLayout(0);
            closeAndroidsInterface();
            if (z) {
                return;
            }
            UILayoutUsersInventory uILayoutUsersInventory2 = this.layoutUsersInventory;
            if (uILayoutUsersInventory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory2 = null;
            }
            UILayoutExchange uILayoutExchange2 = this.layoutExchange;
            if (uILayoutExchange2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange2 = null;
            }
            for (InvItems invItems : uILayoutExchange2.getItemsFromInventory()) {
                if (invItems.getItemsValue() != 0) {
                    invItems.setWhoseItem(0);
                }
            }
            UILayoutExchange uILayoutExchange3 = this.layoutExchange;
            if (uILayoutExchange3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange3 = null;
            }
            List<InvItems> itemsFromActiveSlots = uILayoutExchange3.getItemsFromActiveSlots();
            UILayoutExchange uILayoutExchange4 = this.layoutExchange;
            if (uILayoutExchange4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange4 = null;
            }
            uILayoutUsersInventory2.updateItems(itemsFromActiveSlots, uILayoutExchange4.getItemsFromInventory());
            UILayoutExchange uILayoutExchange5 = this.layoutExchange;
            if (uILayoutExchange5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange5 = null;
            }
            uILayoutUsersInventory2.setThisWeight(uILayoutExchange5.getThisWeight());
            UILayoutExchange uILayoutExchange6 = this.layoutExchange;
            if (uILayoutExchange6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange6 = null;
            }
            uILayoutUsersInventory2.setMaxWeight(uILayoutExchange6.getMaxWeight());
            UILayoutExchange uILayoutExchange7 = this.layoutExchange;
            if (uILayoutExchange7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            } else {
                uILayoutExchange = uILayoutExchange7;
            }
            uILayoutUsersInventory2.updateSizeInventory(uILayoutExchange.getSizeSlots());
            updateMainsButton(false);
        } else if (i == 1) {
            UIContainer uIContainer2 = this.container;
            if (uIContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                uIContainer2 = null;
            }
            uIContainer2.setCurrentLayout(1);
            UILayoutExchange uILayoutExchange8 = this.layoutExchange;
            if (uILayoutExchange8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange8 = null;
            }
            uILayoutExchange8.setStartParametersInLayout();
            closeAndroidsInterface();
            if (z) {
                return;
            }
            UILayoutExchange uILayoutExchange9 = this.layoutExchange;
            if (uILayoutExchange9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
                uILayoutExchange9 = null;
            }
            UILayoutUsersInventory uILayoutUsersInventory3 = this.layoutUsersInventory;
            if (uILayoutUsersInventory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory3 = null;
            }
            List<InvItems> itemsFromInventory = uILayoutUsersInventory3.getItemsFromInventory();
            for (InvItems invItems2 : itemsFromInventory) {
                if (invItems2.getItemsValue() != 0) {
                    invItems2.setWhoseItem(1);
                }
            }
            UILayoutUsersInventory uILayoutUsersInventory4 = this.layoutUsersInventory;
            if (uILayoutUsersInventory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory4 = null;
            }
            uILayoutExchange9.updateItems(uILayoutUsersInventory4.getItemsFromActiveSlots(), itemsFromInventory);
            UILayoutUsersInventory uILayoutUsersInventory5 = this.layoutUsersInventory;
            if (uILayoutUsersInventory5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory5 = null;
            }
            uILayoutExchange9.setThisWeightInventory(uILayoutUsersInventory5.getThisWeight(), true);
            UILayoutUsersInventory uILayoutUsersInventory6 = this.layoutUsersInventory;
            if (uILayoutUsersInventory6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
                uILayoutUsersInventory6 = null;
            }
            uILayoutExchange9.setMaxWeightInventory(uILayoutUsersInventory6.getMaxWeight());
            UILayoutUsersInventory uILayoutUsersInventory7 = this.layoutUsersInventory;
            if (uILayoutUsersInventory7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutUsersInventory");
            } else {
                uILayoutUsersInventory = uILayoutUsersInventory7;
            }
            uILayoutExchange9.updateSizeInventory(uILayoutUsersInventory.getSizeSlots());
            updateMainsButton(true);
            if (this.isTutor) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public final void run() {
                        GUIUsersInventory.m318layoutListener$lambda13(GUIUsersInventory.this);
                    }
                }, 300L);
            }
        }
    }

    public static final void m318layoutListener$lambda13(GUIUsersInventory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getGuideClass().visibleHelp(false);
        this$0.getGuideClass().getHelp(3);
    }

    private final void getStartData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.typeInterface = jSONObject.optInt("i");
        String optString = jSONObject.optString("n");
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(GET_PLAYERS_NICK)");
        this.playersNick = optString;
        this.playersLevel = jSONObject.optInt(GetKeys.GET_PLAYERS_LEVEL);
        this.playersId = jSONObject.optInt(GetKeys.GET_PLAYERS_ID);
        this.thisWeight = jSONObject.optInt("w");
        this.maxWeight = jSONObject.optInt(GetKeys.GET_MAX_WEIGHT);
        this.valueDinner = jSONObject.optInt("s");
        this.typeVIP = jSONObject.optInt("v");
        int optInt = jSONObject.optInt(GetKeys.GET_MAX_SIZE_INVENTORY);
        this.activeSlotsInInventory = optInt;
        if (optInt > 0) {
            this.activeSlotsInInventory = optInt - 1;
        }
        this.playersMoney = jSONObject.optInt("m");
        this.ifHaveSimCard = jSONObject.optInt(GetKeys.GET_NUMBER_IN_SLOT);
        this.playersSkin = jSONObject.optInt(Utils.KEY_GET_ARR_WITH_PLAYERS_START);
        String optString2 = jSONObject.optString(GetKeys.GET_PLAYERS_NICK_WITH_EXCHANGE);
        Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(GET_PLAYERS_NICK_WITH_EXCHANGE)");
        this.playersNickWithExchange = optString2;
        JSONArray optJSONArray = jSONObject.optJSONArray(GetKeys.GET_PLAYERS_ITEMS_IN_INV);
        int i = 0;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                List<Object> list = this.playersItems;
                Object obj = null;
                try {
                    obj = optJSONArray.get(i2);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "playersItemsJsonArray[i]");
                list.add(obj);
                i2 = i3;
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(GetKeys.GET_PLAYERS_ITEMS_IN_SLOT);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            while (i < length2) {
                int i4 = i + 1;
                List<Object> list2 = this.playersItemsInSlot;
                Object obj2 = null;
                try {
                    obj2 = optJSONArray2.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Intrinsics.checkNotNullExpressionValue(obj2, "playersItemsInSlotJsonArray[i]");
                list2.add(obj2);
                i = i4;
            }
        }
    }

    public final int getTypeInterface() {
        return this.typeInterface;
    }

    public final void sendIdAndPositionToServer(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("ga", i2);
            jSONObject.put("s", i3);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(33, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendIdWithOldAndNewPositionsToServer(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("ga", i2);
            jSONObject.put(PutKeys.PUT_OLD_POSITION, i3);
            jSONObject.put("s", i4);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(33, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendPressButton(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(33, jSONObject);
            }
        } catch (Exception unused) {
        }
        if (i == 25) {
            getGuideClass().visibleHelp(false);
        }
    }

    public final void sendPressButton(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put(PutKeys.PUT_MONEY, i2);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(33, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendIdWithCountAndSlotToServer(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("ga", i2);
            jSONObject.put("s", i3);
            jSONObject.put(PutKeys.PUT_OLD_POSITION, i4);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(33, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendIdWithCountToServer(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("ga", i2);
            jSONObject.put("s", i3);
            jSONObject.put(GetKeys.GET_MAX_SIZE_INVENTORY, i4);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(33, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendMessageToServer(int i, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("tx", message);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(33, jSONObject);
        } catch (Exception unused) {
        }
    }

    private final void addDataForInventory() {
        Integer[] numArr = this.arrayForInventory;
        numArr[0] = Integer.valueOf(this.playersId);
        numArr[1] = Integer.valueOf(this.playersLevel);
        numArr[2] = Integer.valueOf(this.typeVIP);
        numArr[3] = Integer.valueOf(this.valueDinner);
        numArr[4] = Integer.valueOf(this.thisWeight);
        numArr[5] = Integer.valueOf(this.maxWeight);
        numArr[6] = Integer.valueOf(this.activeSlotsInInventory);
        numArr[7] = Integer.valueOf(this.ifHaveSimCard);
        numArr[8] = Integer.valueOf(this.maxSlotsInInventory);
    }

    private final void addDataForExchange() {
        Integer[] numArr = this.arrayForExchange;
        numArr[0] = Integer.valueOf(this.thisWeight);
        numArr[1] = Integer.valueOf(this.maxWeight);
        numArr[2] = Integer.valueOf(this.activeSlotsInInventory);
        numArr[3] = Integer.valueOf(this.playersMoney);
        numArr[4] = Integer.valueOf(this.ifHaveSimCard);
        numArr[5] = Integer.valueOf(this.maxSlotsInInventory);
    }

    public final void migrateDataFromAnyToObject(List<Object> items, List<InvItems> newList, boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(newList, "newList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        IntProgression step = RangesKt.step(RangesKt.until(0, items.size()), 3);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int i = first + step2;
                arrayList.add(Integer.valueOf(Integer.parseInt(items.get(first).toString())));
                if (first == last) {
                    break;
                }
                first = i;
            }
        }
        IntProgression step3 = RangesKt.step(RangesKt.until(1, items.size()), 3);
        int first2 = step3.getFirst();
        int last2 = step3.getLast();
        int step4 = step3.getStep();
        if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
            while (true) {
                int i2 = first2 + step4;
                if (items.get(first2) instanceof String) {
                    arrayList2.add(1);
                    arrayList3.add(items.get(first2).toString());
                } else {
                    arrayList2.add(Integer.valueOf(Integer.parseInt(items.get(first2).toString())));
                    arrayList3.add("");
                }
                if (first2 == last2) {
                    break;
                }
                first2 = i2;
            }
        }
        IntProgression step5 = RangesKt.step(RangesKt.until(2, items.size()), 3);
        int first3 = step5.getFirst();
        int last3 = step5.getLast();
        int step6 = step5.getStep();
        if ((step6 > 0 && first3 <= last3) || (step6 < 0 && last3 <= first3)) {
            while (true) {
                int i3 = first3 + step6;
                arrayList4.add(Integer.valueOf(Integer.parseInt(items.get(first3).toString())));
                if (first3 == last3) {
                    break;
                }
                first3 = i3;
            }
        }
        int size = newList.size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            int size2 = arrayList4.size();
            int i6 = 0;
            while (i6 < size2) {
                int i7 = i6 + 1;
                if (i4 == ((Number) arrayList4.get(i6)).intValue()) {
                    int i8 = z ? i4 + 2 : i4;
                    if (i8 == 8 && z) {
                        InvItems invItems = newList.get(1);
                        invItems.setId(((Number) arrayList.get(i6)).intValue());
                        invItems.setItemsValue(((Number) arrayList2.get(i6)).intValue());
                        invItems.setTextIfException((String) arrayList3.get(i6));
                    } else {
                        InvItems invItems2 = newList.get(i8);
                        invItems2.setId(((Number) arrayList.get(i6)).intValue());
                        invItems2.setItemsValue(((Number) arrayList2.get(i6)).intValue());
                        invItems2.setTextIfException((String) arrayList3.get(i6));
                    }
                }
                i6 = i7;
            }
            i4 = i5;
        }
        addOtherParametersInList(newList);
    }

    private final void addOtherParametersInList(List<InvItems> list) {
        for (InvItems invItems : list) {
            Iterator<InvItems> it = this.allItems.iterator();
            while (true) {
                if (it.hasNext()) {
                    InvItems next = it.next();
                    if (invItems.getId() == next.getId()) {
                        updateItemAfterMigrate(invItems, next);
                        break;
                    }
                }
            }
        }
    }

    private final InvItems getItemWithAllParameters(int i, int i2, String str) {
        InvItems emptyItem = Constants.INSTANCE.emptyItem();
        Iterator<InvItems> it = this.allItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InvItems next = it.next();
            if (i == next.getId()) {
                emptyItem.setId(i);
                emptyItem.setName(next.getName());
                emptyItem.setDesc(next.getDesc());
                emptyItem.setModelid(next.getModelid());
                emptyItem.setWeight(next.getWeight());
                emptyItem.setAddw(next.getAddw());
                emptyItem.setFold(next.getFold());
                emptyItem.setShiftX(next.getShiftX());
                emptyItem.setShiftY(next.getShiftY());
                emptyItem.setShiftZ(next.getShiftZ());
                emptyItem.setX(next.getX());
                emptyItem.setY(next.getY());
                emptyItem.setZ(next.getZ());
                emptyItem.setZoom(next.getZoom());
                emptyItem.setItemsValue(i2);
                emptyItem.setTextIfException(str);
                emptyItem.setWhoseItem(2);
                emptyItem.setThisBitmap(next.getThisBitmap());
                emptyItem.setCheck(next.getCheck());
                if (i == 58) {
                    emptyItem.setTextIfException(String.valueOf(i2));
                    emptyItem.setItemsValue(1);
                } else if (i == 134) {
                    emptyItem.setModelid(i2);
                    emptyItem.setItemsValue(1);
                }
            }
        }
        return emptyItem;
    }

    private final void updateItemAfterMigrate(InvItems invItems, InvItems invItems2) {
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
        invItems.setWhoseItem(0);
        invItems.setThisBitmap(invItems2.getThisBitmap());
        int id = invItems.getId();
        if (id == 58) {
            invItems.setTextIfException(String.valueOf(invItems.getItemsValue()));
            invItems.setItemsValue(1);
        } else if (id != 134) {
        } else {
            invItems.setModelid(invItems.getItemsValue());
            invItems.setItemsValue(1);
        }
    }

    public final void openChat() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        Dialog dialog = nvEventQueueActivity == null ? null : new Dialog(nvEventQueueActivity);
        UIChat uIChat = new UIChat(dialog, this.messages, this, this.playersNickWithExchange);
        this.dialogLogic = uIChat;
        if (uIChat != null) {
            uIChat.setStartLogic();
        }
        GUIManager.hideSystemUI(dialog != null ? dialog.getWindow() : null);
    }

    public final void setNewMessage(boolean z, int i, String textMessage, int i2, String itemsName, int i3) {
        Intrinsics.checkNotNullParameter(textMessage, "textMessage");
        Intrinsics.checkNotNullParameter(itemsName, "itemsName");
        this.messages.add(new MessageData(i, textMessage, i2, itemsName, i3));
        UIChat uIChat = this.dialogLogic;
        if (uIChat == null) {
            return;
        }
        uIChat.updateMessage(z);
    }

    public final void updateCountWithNewMessages(int i) {
        UILayoutExchange uILayoutExchange = this.layoutExchange;
        if (uILayoutExchange == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutExchange");
            uILayoutExchange = null;
        }
        uILayoutExchange.updateCountWithNewMessages(i);
    }

    private final void updateMainsButton(boolean z) {
        if (z) {
            List<InvMainButtonsData> list = this.newListWithButtons;
            list.clear();
            list.addAll(Constants.INSTANCE.getListButtons());
            list.add(new InvMainButtonsData(5, "Инвентарь", "inv_icon_button_inventory_res"));
        } else if (!z) {
            List<InvMainButtonsData> list2 = this.newListWithButtons;
            list2.clear();
            list2.addAll(Constants.INSTANCE.getListButtons());
        }
        InventoryMainButtonsAdapter inventoryMainButtonsAdapter = this.mainButtonsAdapter;
        if (inventoryMainButtonsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainButtonsAdapter");
            inventoryMainButtonsAdapter = null;
        }
        inventoryMainButtonsAdapter.notifyDataSetChanged();
    }

    public final void sendActionToChat(boolean z, String str) {
        UIChat uIChat = this.dialogLogic;
        if (uIChat == null) {
            return;
        }
        uIChat.getMessageAboutExchangeItems(this.playersNickWithExchange, z, str);
    }

    public final String getOtherPlayersNick() {
        return this.playersNickWithExchange;
    }

    public final GUIManager getGUIManager() {
        return this.guiManager;
    }

    public final void sendMessageError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put("t", 2);
            jSONObject.put("d", 2);
            jSONObject.put("i", message);
            jSONObject.put("s", -1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.onPacketIncoming(13, jSONObject);
        } catch (Exception unused) {
        }
    }
}
