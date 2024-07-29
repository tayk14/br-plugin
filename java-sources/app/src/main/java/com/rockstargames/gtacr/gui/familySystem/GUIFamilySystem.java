package com.rockstargames.gtacr.gui.familySystem;

import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMainContainerBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GUIFamilySystem.kt */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 {2\u00020\u0001:\u0001{B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0006\u0010e\u001a\u00020bJ\b\u0010f\u001a\u00020\u0014H\u0016J\u0012\u0010g\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J\b\u0010h\u001a\u00020bH\u0002J\b\u0010i\u001a\u00020bH\u0002J\b\u0010j\u001a\u00020 H\u0016J\u000e\u0010k\u001a\u00020b2\u0006\u0010l\u001a\u00020\u0014J\u0012\u0010m\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0010\u0010n\u001a\u00020b2\u0006\u0010o\u001a\u00020\u0014H\u0002J\u0010\u0010p\u001a\u00020b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010q\u001a\u00020b2\u0006\u0010r\u001a\u00020\u0014H\u0002J\u0010\u0010s\u001a\u00020b2\u0006\u0010t\u001a\u00020\u0014H\u0002J\u0010\u0010u\u001a\u00020b2\u0006\u0010v\u001a\u00020\u0014H\u0002J$\u0010w\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010x\u001a\u0004\u0018\u00010\u001a2\u0006\u0010y\u001a\u00020\u000eH\u0016J\u0006\u0010z\u001a\u00020bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010)\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u001a\u0010,\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0016\"\u0004\bO\u0010\u0018R\u001a\u0010P\u001a\u00020QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "actionWithJson", "Lcom/rockstargames/gtacr/gui/familySystem/GetDataFromJsonAndTransformationToCorrectType;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMainContainerBinding;", "container", "Lcom/rockstargames/gtacr/common/UIContainer;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "familyName", "Landroid/text/Spanned;", "familyRatingLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyRating;", "familyStatus", "", "getFamilyStatus", "()I", "setFamilyStatus", "(I)V", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "getGuiManager", "()Lcom/rockstargames/gtacr/GUIManager;", "setGuiManager", "(Lcom/rockstargames/gtacr/GUIManager;)V", "ifCloseOtherMethodAndNotInforming", "", "getIfCloseOtherMethodAndNotInforming", "()Z", "setIfCloseOtherMethodAndNotInforming", "(Z)V", "ifFamilyInTop", "ifFromMainMenuForCarPark", "getIfFromMainMenuForCarPark", "setIfFromMainMenuForCarPark", "ifFromMainMenuForUpgrade", "getIfFromMainMenuForUpgrade", "setIfFromMainMenuForUpgrade", "ifLeader", "getIfLeader", "setIfLeader", "inflater", "Landroid/view/LayoutInflater;", "logicForDialogApply", "Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;", "logicForDialogBuyToken", "Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogBuyToken;", "mainLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMailLayout;", "menuCarParkLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMenuCarPark;", "menuFamilyPlayersSettingLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilyPlayersSetting;", "menuFamilySettingLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilySetting;", "menuFamilyStoreLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilyStore;", "menuFamilyUpgradeLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilyUpgrade;", "menuMainLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIMenuMain;", "notificationsLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyNotification;", "oldTimer", "", "getOldTimer", "()J", "setOldTimer", "(J)V", "otherState", "", "playersId", "getPlayersId", "setPlayersId", "playersNick", "", "getPlayersNick", "()Ljava/lang/String;", "setPlayersNick", "(Ljava/lang/String;)V", "popupWindow", "Landroid/widget/PopupWindow;", "questsLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyQuests;", "shopLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyShop;", "topPresentsLayout", "Lcom/rockstargames/gtacr/gui/familySystem/UITopPresents;", "valueBlackCoins", "valueMoney", "valueNotifications", "close", "", "json", "Lorg/json/JSONObject;", "closeAndroidsButtons", "getGuiId", "getStartParameters", "initialisationContainer", "initialisationPopupWindow", "isShowingGui", "listenerLayout", "thisLayout", "onPacketIncoming", "setBlackCoin", "thisBlackCoin", "setFamilyName", "setLavr", "conditionInTop", "setMoney", "thisMoney", "setNotification", "thisValueNotification", "show", "manager", "activity", "upgradeFamily", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GUIFamilySystem implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesMainContainerBinding binding;
    private UIContainer container;
    private NvEventQueueActivity context;
    private UIFamilyRating familyRatingLayout;
    private int familyStatus;
    private GUIManager guiManager;
    private boolean ifCloseOtherMethodAndNotInforming;
    private int ifFamilyInTop;
    private int ifLeader;
    private LayoutInflater inflater;
    private LogicForDialogApply logicForDialogApply;
    private LogicForDialogBuyToken logicForDialogBuyToken;
    private UIMailLayout mainLayout;
    private UIMenuCarPark menuCarParkLayout;
    private UIMenuFamilyPlayersSetting menuFamilyPlayersSettingLayout;
    private UIMenuFamilySetting menuFamilySettingLayout;
    private UIMenuFamilyStore menuFamilyStoreLayout;
    private UIMenuFamilyUpgrade menuFamilyUpgradeLayout;
    private UIMenuMain menuMainLayout;
    private UIFamilyNotification notificationsLayout;
    private long oldTimer;
    private int playersId;
    private PopupWindow popupWindow;
    private UIFamilyQuests questsLayout;
    private UIFamilyShop shopLayout;
    private UITopPresents topPresentsLayout;
    private int valueBlackCoins;
    private int valueMoney;
    private int valueNotifications;
    private Spanned familyName = new SpannableString("");
    private String playersNick = "";
    private final GetDataFromJsonAndTransformationToCorrectType actionWithJson = new GetDataFromJsonAndTransformationToCorrectType();
    private final List<Integer> otherState = new ArrayList();
    private boolean ifFromMainMenuForUpgrade = true;
    private boolean ifFromMainMenuForCarPark = true;

    @JvmStatic
    public static final GUIFamilySystem newInstance() {
        return Companion.newInstance();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 45;
    }

    public final GUIManager getGuiManager() {
        return this.guiManager;
    }

    public final void setGuiManager(GUIManager gUIManager) {
        this.guiManager = gUIManager;
    }

    public final int getIfLeader() {
        return this.ifLeader;
    }

    public final void setIfLeader(int i) {
        this.ifLeader = i;
    }

    public final int getFamilyStatus() {
        return this.familyStatus;
    }

    public final void setFamilyStatus(int i) {
        this.familyStatus = i;
    }

    public final String getPlayersNick() {
        return this.playersNick;
    }

    public final void setPlayersNick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playersNick = str;
    }

    public final int getPlayersId() {
        return this.playersId;
    }

    public final void setPlayersId(int i) {
        this.playersId = i;
    }

    public final boolean getIfCloseOtherMethodAndNotInforming() {
        return this.ifCloseOtherMethodAndNotInforming;
    }

    public final void setIfCloseOtherMethodAndNotInforming(boolean z) {
        this.ifCloseOtherMethodAndNotInforming = z;
    }

    public final boolean getIfFromMainMenuForUpgrade() {
        return this.ifFromMainMenuForUpgrade;
    }

    public final void setIfFromMainMenuForUpgrade(boolean z) {
        this.ifFromMainMenuForUpgrade = z;
    }

    public final boolean getIfFromMainMenuForCarPark() {
        return this.ifFromMainMenuForCarPark;
    }

    public final void setIfFromMainMenuForCarPark(boolean z) {
        this.ifFromMainMenuForCarPark = z;
    }

    public final long getOldTimer() {
        return this.oldTimer;
    }

    public final void setOldTimer(long j) {
        this.oldTimer = j;
    }

    /* compiled from: GUIFamilySystem.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIFamilySystem newInstance() {
            return new GUIFamilySystem();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:264:? A[RETURN, SYNTHETIC] */
    @Override // com.rockstargames.gtacr.ISAMPGUI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPacketIncoming(JSONObject r30) {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rockstargames.gtacr.gui.familySystem.GUIFamilySystem.onPacketIncoming(org.json.JSONObject):void");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        this.actionsWithJSON = new ActionsWithJSON(gUIManager);
        getStartParameters(jSONObject);
        if (this.popupWindow == null) {
            initialisationPopupWindow();
        }
        NvEventQueueActivity nvEventQueueActivity = this.context;
        FamiliesMainContainerBinding familiesMainContainerBinding = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        this.logicForDialogApply = new LogicForDialogApply(this, nvEventQueueActivity, actionsWithJSON);
        initialisationContainer();
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity2 = null;
        }
        ActionsWithJSON actionsWithJSON2 = this.actionsWithJSON;
        if (actionsWithJSON2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON2 = null;
        }
        this.logicForDialogBuyToken = new LogicForDialogBuyToken(this, nvEventQueueActivity2, actionsWithJSON2);
        setFamilyName(this.familyName);
        setMoney(this.valueMoney);
        setBlackCoin(this.valueBlackCoins);
        setNotification(this.valueNotifications);
        setLavr(this.ifFamilyInTop);
        listenerLayout(0);
        FamiliesMainContainerBinding familiesMainContainerBinding2 = this.binding;
        if (familiesMainContainerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMainContainerBinding = familiesMainContainerBinding2;
        }
        familiesMainContainerBinding.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$d9AsgPWUWXkDjXCq-_mCDpCXDqk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GUIFamilySystem.m177show$lambda16$lambda5(GUIFamilySystem.this, view);
            }
        });
        familiesMainContainerBinding.addMoney.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$te3fSSUSqXhkAeVwNP1mkTYkG14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GUIFamilySystem.m179show$lambda16$lambda7(GUIFamilySystem.this, view);
            }
        });
        familiesMainContainerBinding.buttonFamiliesSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$A0ntkGKRMMtwo0_wX1blaupMH0Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GUIFamilySystem.m181show$lambda16$lambda9(GUIFamilySystem.this, view);
            }
        });
        familiesMainContainerBinding.buttonNotification.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$97_wAlnZz18nOb56-Srp9jrBD24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GUIFamilySystem.m171show$lambda16$lambda11(GUIFamilySystem.this, view);
            }
        });
        familiesMainContainerBinding.buttonTop.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$uX73bc-a92AVH1tB2uqHtil2Bp0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GUIFamilySystem.m173show$lambda16$lambda13(GUIFamilySystem.this, view);
            }
        });
        familiesMainContainerBinding.buttonBack.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$RU98es3Ysur2-fhfKJ-C1rVVuqI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GUIFamilySystem.m175show$lambda16$lambda15(GUIFamilySystem.this, view);
            }
        });
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$pq3QQXZGFgEH3JyDea3ZrOZOeaM
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                GUIFamilySystem.m183show$lambda17(GUIFamilySystem.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-5  reason: not valid java name */
    public static final void m177show$lambda16$lambda5(final GUIFamilySystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        this$0.ifCloseOtherMethodAndNotInforming = false;
        new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$yCuiK4n1upjx81BQ63gPVvPrHFs
            @Override // java.lang.Runnable
            public final void run() {
                //GUIFamilySystem.m178show$lambda16$lambda5$lambda4(GUIFamilySystem.this);
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-5$lambda-4  reason: not valid java name */
    public static final void m178show$lambda16$lambda5$lambda4(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-7  reason: not valid java name */
    public static final void m179show$lambda16$lambda7(final GUIFamilySystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$QK-uGsc8_wJ6NLCClDF0eICjIDk
            @Override // java.lang.Runnable
            public final void run() {
                //GUIFamilySystem.m180show$lambda16$lambda7$lambda6(GUIFamilySystem.this);
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-7$lambda-6  reason: not valid java name */
    public static final void m180show$lambda16$lambda7$lambda6(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LogicForDialogBuyToken logicForDialogBuyToken = this$0.logicForDialogBuyToken;
        if (logicForDialogBuyToken == null) {
            return;
        }
        logicForDialogBuyToken.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-9  reason: not valid java name */
    public static final void m181show$lambda16$lambda9(final GUIFamilySystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldTimer > 500) {
            this$0.oldTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$kBSUwJ0n0bw1gWbMSq_XEa7TBQM
                @Override // java.lang.Runnable
                public final void run() {
                    //GUIFamilySystem.m182show$lambda16$lambda9$lambda8(GUIFamilySystem.this);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-9$lambda-8  reason: not valid java name */
    public static final void m182show$lambda16$lambda9$lambda8(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendGetLayout(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-11  reason: not valid java name */
    public static final void m171show$lambda16$lambda11(final GUIFamilySystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldTimer > 500) {
            this$0.oldTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$gtM08nuFZuja9Qkus6ey8eg74o0
                @Override // java.lang.Runnable
                public final void run() {
                    //GUIFamilySystem.m172show$lambda16$lambda11$lambda10(GUIFamilySystem.this);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-11$lambda-10  reason: not valid java name */
    public static final void m172show$lambda16$lambda11$lambda10(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendGetLayout(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-13  reason: not valid java name */
    public static final void m173show$lambda16$lambda13(final GUIFamilySystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldTimer > 500) {
            this$0.oldTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$8fYYS7EqCM0cetqBlN-VJUFYL-4
                @Override // java.lang.Runnable
                public final void run() {
                    //GUIFamilySystem.m174show$lambda16$lambda13$lambda12(GUIFamilySystem.this);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-13$lambda-12  reason: not valid java name */
    public static final void m174show$lambda16$lambda13$lambda12(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendGetLayout(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-15  reason: not valid java name */
    public static final void m175show$lambda16$lambda15(final GUIFamilySystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.gui.familySystem.-$$Lambda$GUIFamilySystem$NYRNhSMWUlGLooFjSPVVQcBZTYk
            @Override // java.lang.Runnable
            public final void run() {
                //GUIFamilySystem.m176show$lambda16$lambda15$lambda14(GUIFamilySystem.this);
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-16$lambda-15$lambda-14  reason: not valid java name */
    public static final void m176show$lambda16$lambda15$lambda14(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenerLayout(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: show$lambda-17  reason: not valid java name */
    public static final void m183show$lambda17(GUIFamilySystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.ifCloseOtherMethodAndNotInforming) {
            ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
            if (actionsWithJSON == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                actionsWithJSON = null;
            }
            actionsWithJSON.sendPressButton(8);
        }
        LogicForDialogApply logicForDialogApply = this$0.logicForDialogApply;
        if (logicForDialogApply != null) {
            logicForDialogApply.closeDialogApply();
        }
        LogicForDialogBuyToken logicForDialogBuyToken = this$0.logicForDialogBuyToken;
        if (logicForDialogBuyToken != null) {
            logicForDialogBuyToken.closeDialog();
        }
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        //nvEventQueueActivity.toggleDrawing2dStuff(false);
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager == null) {
            return;
        }
        gUIManager.closeGUI(null, 45);
    }

    private final void initialisationPopupWindow() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        NvEventQueueActivity nvEventQueueActivity2 = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        Object systemService = nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        this.inflater = layoutInflater;
        if (layoutInflater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflater");
            layoutInflater = null;
        }
        FamiliesMainContainerBinding inflate = FamiliesMainContainerBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        this.popupWindow = new PopupWindow((View) familiesMainContainerBinding.getRoot(), -1, -1, true);
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        if (nvEventQueueActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity3 = null;
        }
        nvEventQueueActivity3.toggleDrawing2dStuff(true);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            GUIManager.hideSystemUI(popupWindow.getContentView());
        }
        closeAndroidsButtons();
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return;
        }
        NvEventQueueActivity nvEventQueueActivity4 = this.context;
        if (nvEventQueueActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            nvEventQueueActivity2 = nvEventQueueActivity4;
        }
        popupWindow2.showAtLocation(nvEventQueueActivity2.getParentLayout(), 17, 0, 0);
    }

    public final void closeAndroidsButtons() {
        Useful useful = new Useful();
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        useful.closeAndroidsInterface(nvEventQueueActivity, this.popupWindow);
    }

    private final void initialisationContainer() {
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        UIMenuFamilyStore uIMenuFamilyStore = null;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        UIContainer uIContainer = familiesMainContainerBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(uIContainer, "binding.mainContainer");
        this.container = uIContainer;
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        this.mainLayout = new UIMailLayout(this, actionsWithJSON);
        UIContainer uIContainer2 = this.container;
        if (uIContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer2 = null;
        }
        UIMailLayout uIMailLayout = this.mainLayout;
        if (uIMailLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
            uIMailLayout = null;
        }
        uIContainer2.addLayout(0, uIMailLayout);
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        this.familyRatingLayout = new UIFamilyRating(this, nvEventQueueActivity);
        UIContainer uIContainer3 = this.container;
        if (uIContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer3 = null;
        }
        UIFamilyRating uIFamilyRating = this.familyRatingLayout;
        if (uIFamilyRating == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familyRatingLayout");
            uIFamilyRating = null;
        }
        uIContainer3.addLayout(1, uIFamilyRating);
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity2 = null;
        }
        this.topPresentsLayout = new UITopPresents(nvEventQueueActivity2);
        UIContainer uIContainer4 = this.container;
        if (uIContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer4 = null;
        }
        UITopPresents uITopPresents = this.topPresentsLayout;
        if (uITopPresents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topPresentsLayout");
            uITopPresents = null;
        }
        uIContainer4.addLayout(2, uITopPresents);
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        if (nvEventQueueActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity3 = null;
        }
        this.shopLayout = new UIFamilyShop(this, nvEventQueueActivity3, this.logicForDialogApply);
        UIContainer uIContainer5 = this.container;
        if (uIContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer5 = null;
        }
        UIFamilyShop uIFamilyShop = this.shopLayout;
        if (uIFamilyShop == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopLayout");
            uIFamilyShop = null;
        }
        uIContainer5.addLayout(3, uIFamilyShop);
        NvEventQueueActivity nvEventQueueActivity4 = this.context;
        if (nvEventQueueActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity4 = null;
        }
        ActionsWithJSON actionsWithJSON2 = this.actionsWithJSON;
        if (actionsWithJSON2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON2 = null;
        }
        this.questsLayout = new UIFamilyQuests(nvEventQueueActivity4, actionsWithJSON2);
        UIContainer uIContainer6 = this.container;
        if (uIContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer6 = null;
        }
        UIFamilyQuests uIFamilyQuests = this.questsLayout;
        if (uIFamilyQuests == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questsLayout");
            uIFamilyQuests = null;
        }
        uIContainer6.addLayout(4, uIFamilyQuests);
        NvEventQueueActivity nvEventQueueActivity5 = this.context;
        if (nvEventQueueActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity5 = null;
        }
        ActionsWithJSON actionsWithJSON3 = this.actionsWithJSON;
        if (actionsWithJSON3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON3 = null;
        }
        this.notificationsLayout = new UIFamilyNotification(this, nvEventQueueActivity5, actionsWithJSON3, this.logicForDialogApply);
        UIContainer uIContainer7 = this.container;
        if (uIContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer7 = null;
        }
        UIFamilyNotification uIFamilyNotification = this.notificationsLayout;
        if (uIFamilyNotification == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsLayout");
            uIFamilyNotification = null;
        }
        uIContainer7.addLayout(5, uIFamilyNotification);
        NvEventQueueActivity nvEventQueueActivity6 = this.context;
        if (nvEventQueueActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity6 = null;
        }
        ActionsWithJSON actionsWithJSON4 = this.actionsWithJSON;
        if (actionsWithJSON4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON4 = null;
        }
        this.menuMainLayout = new UIMenuMain(this, nvEventQueueActivity6, actionsWithJSON4, this.logicForDialogApply);
        UIContainer uIContainer8 = this.container;
        if (uIContainer8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer8 = null;
        }
        UIMenuMain uIMenuMain = this.menuMainLayout;
        if (uIMenuMain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuMainLayout");
            uIMenuMain = null;
        }
        uIContainer8.addLayout(6, uIMenuMain);
        NvEventQueueActivity nvEventQueueActivity7 = this.context;
        if (nvEventQueueActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity7 = null;
        }
        ActionsWithJSON actionsWithJSON5 = this.actionsWithJSON;
        if (actionsWithJSON5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON5 = null;
        }
        this.menuFamilySettingLayout = new UIMenuFamilySetting(nvEventQueueActivity7, actionsWithJSON5);
        UIContainer uIContainer9 = this.container;
        if (uIContainer9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer9 = null;
        }
        UIMenuFamilySetting uIMenuFamilySetting = this.menuFamilySettingLayout;
        if (uIMenuFamilySetting == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuFamilySettingLayout");
            uIMenuFamilySetting = null;
        }
        uIContainer9.addLayout(7, uIMenuFamilySetting);
        NvEventQueueActivity nvEventQueueActivity8 = this.context;
        if (nvEventQueueActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity8 = null;
        }
        ActionsWithJSON actionsWithJSON6 = this.actionsWithJSON;
        if (actionsWithJSON6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON6 = null;
        }
        this.menuFamilyPlayersSettingLayout = new UIMenuFamilyPlayersSetting(nvEventQueueActivity8, actionsWithJSON6);
        UIContainer uIContainer10 = this.container;
        if (uIContainer10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer10 = null;
        }
        UIMenuFamilyPlayersSetting uIMenuFamilyPlayersSetting = this.menuFamilyPlayersSettingLayout;
        if (uIMenuFamilyPlayersSetting == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuFamilyPlayersSettingLayout");
            uIMenuFamilyPlayersSetting = null;
        }
        uIContainer10.addLayout(8, uIMenuFamilyPlayersSetting);
        NvEventQueueActivity nvEventQueueActivity9 = this.context;
        if (nvEventQueueActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity9 = null;
        }
        ActionsWithJSON actionsWithJSON7 = this.actionsWithJSON;
        if (actionsWithJSON7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON7 = null;
        }
        this.menuCarParkLayout = new UIMenuCarPark(nvEventQueueActivity9, actionsWithJSON7);
        UIContainer uIContainer11 = this.container;
        if (uIContainer11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer11 = null;
        }
        UIMenuCarPark uIMenuCarPark = this.menuCarParkLayout;
        if (uIMenuCarPark == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuCarParkLayout");
            uIMenuCarPark = null;
        }
        uIContainer11.addLayout(9, uIMenuCarPark);
        NvEventQueueActivity nvEventQueueActivity10 = this.context;
        if (nvEventQueueActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity10 = null;
        }
        ActionsWithJSON actionsWithJSON8 = this.actionsWithJSON;
        if (actionsWithJSON8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON8 = null;
        }
        this.menuFamilyUpgradeLayout = new UIMenuFamilyUpgrade(nvEventQueueActivity10, actionsWithJSON8, this.logicForDialogApply);
        UIContainer uIContainer12 = this.container;
        if (uIContainer12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer12 = null;
        }
        UIMenuFamilyUpgrade uIMenuFamilyUpgrade = this.menuFamilyUpgradeLayout;
        if (uIMenuFamilyUpgrade == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuFamilyUpgradeLayout");
            uIMenuFamilyUpgrade = null;
        }
        uIContainer12.addLayout(10, uIMenuFamilyUpgrade);
        NvEventQueueActivity nvEventQueueActivity11 = this.context;
        if (nvEventQueueActivity11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity11 = null;
        }
        ActionsWithJSON actionsWithJSON9 = this.actionsWithJSON;
        if (actionsWithJSON9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON9 = null;
        }
        this.menuFamilyStoreLayout = new UIMenuFamilyStore(nvEventQueueActivity11, actionsWithJSON9);
        UIContainer uIContainer13 = this.container;
        if (uIContainer13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            uIContainer13 = null;
        }
        UIMenuFamilyStore uIMenuFamilyStore2 = this.menuFamilyStoreLayout;
        if (uIMenuFamilyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuFamilyStoreLayout");
        } else {
            uIMenuFamilyStore = uIMenuFamilyStore2;
        }
        uIContainer13.addLayout(11, uIMenuFamilyStore);
    }

    private final void getStartParameters(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ActionWithString actionWithString = new ActionWithString();
        String optString = jSONObject.optString("n");
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"n\")");
        this.familyName = actionWithString.convertStringToHtmlType(optString);
        setIfLeader(jSONObject.optInt(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS));
        this.valueMoney = jSONObject.optInt("m");
        this.valueBlackCoins = jSONObject.optInt(TuningConstants.KEY_GET_GOS_COST);
        this.valueNotifications = jSONObject.optInt("y");
        this.ifFamilyInTop = jSONObject.optInt("b");
        String optString2 = jSONObject.optString("pn");
        Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"pn\")");
        setPlayersNick(optString2);
        setPlayersId(jSONObject.optInt("pi"));
        setFamilyStatus(jSONObject.optInt("is"));
    }

    private final void setFamilyName(Spanned spanned) {
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        TextView textView = familiesMainContainerBinding.titleText;
        textView.setText(spanned);
        textView.setSelected(true);
    }

    private final void setMoney(int i) {
        String priceWithSpacesForInt = new Useful().getPriceWithSpacesForInt(i);
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        familiesMainContainerBinding.moneyValue.setText(priceWithSpacesForInt);
    }

    private final void setBlackCoin(int i) {
        String priceWithSpacesForInt = new Useful().getPriceWithSpacesForInt(i);
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        familiesMainContainerBinding.blackCoinValue.setText(priceWithSpacesForInt);
    }

    private final void setNotification(int i) {
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        if (i == 0) {
            familiesMainContainerBinding.valueNotification.setVisibility(4);
            familiesMainContainerBinding.buttonNotification.setImageResource(R.drawable.families_notification_icon_res);
        } else if (i < 10) {
            familiesMainContainerBinding.valueNotification.setVisibility(0);
            familiesMainContainerBinding.valueNotification.setText(String.valueOf(i));
            familiesMainContainerBinding.buttonNotification.setImageResource(R.drawable.families_notification_if_not_null_icon_res);
        } else {
            familiesMainContainerBinding.valueNotification.setVisibility(0);
            familiesMainContainerBinding.valueNotification.setText("9+");
            familiesMainContainerBinding.buttonNotification.setImageResource(R.drawable.families_notification_if_not_null_icon_res);
        }
    }

    private final void setLavr(int i) {
        FamiliesMainContainerBinding familiesMainContainerBinding = null;
        if (i == 0) {
            FamiliesMainContainerBinding familiesMainContainerBinding2 = this.binding;
            if (familiesMainContainerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesMainContainerBinding = familiesMainContainerBinding2;
            }
            familiesMainContainerBinding.titleText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.families_family_icon, 0, 0, 0);
        } else if (i != 1) {
        } else {
            FamiliesMainContainerBinding familiesMainContainerBinding3 = this.binding;
            if (familiesMainContainerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesMainContainerBinding = familiesMainContainerBinding3;
            }
            familiesMainContainerBinding.titleText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.families_family_with_lavre_icon, 0, 0, 0);
        }
    }

    public final void listenerLayout(int i) {
        FamiliesMainContainerBinding familiesMainContainerBinding = this.binding;
        UIContainer uIContainer = null;
        if (familiesMainContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainContainerBinding = null;
        }
        GUIManager.hideSystemUI(familiesMainContainerBinding.getRoot());
        if (i != 0) {
            FamiliesMainContainerBinding familiesMainContainerBinding2 = this.binding;
            if (familiesMainContainerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                familiesMainContainerBinding2 = null;
            }
            familiesMainContainerBinding2.buttonBack.setVisibility(0);
        } else {
            FamiliesMainContainerBinding familiesMainContainerBinding3 = this.binding;
            if (familiesMainContainerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                familiesMainContainerBinding3 = null;
            }
            familiesMainContainerBinding3.buttonBack.setVisibility(4);
        }
        switch (i) {
            case 2:
                UITopPresents uITopPresents = this.topPresentsLayout;
                if (uITopPresents == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topPresentsLayout");
                    uITopPresents = null;
                }
                uITopPresents.setParameters();
                break;
            case 3:
                UIFamilyShop uIFamilyShop = this.shopLayout;
                if (uIFamilyShop == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shopLayout");
                    uIFamilyShop = null;
                }
                uIFamilyShop.setStartParameters(this.familyStatus);
                break;
            case 4:
                UIFamilyQuests uIFamilyQuests = this.questsLayout;
                if (uIFamilyQuests == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questsLayout");
                    uIFamilyQuests = null;
                }
                uIFamilyQuests.setStartParameters();
                break;
            case 5:
                this.valueNotifications = 0;
                setNotification(0);
                break;
            case 8:
                UIMenuFamilyPlayersSetting uIMenuFamilyPlayersSetting = this.menuFamilyPlayersSettingLayout;
                if (uIMenuFamilyPlayersSetting == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuFamilyPlayersSettingLayout");
                    uIMenuFamilyPlayersSetting = null;
                }
                uIMenuFamilyPlayersSetting.setStartParameters();
                break;
            case 9:
                UIMenuCarPark uIMenuCarPark = this.menuCarParkLayout;
                if (uIMenuCarPark == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuCarParkLayout");
                    uIMenuCarPark = null;
                }
                uIMenuCarPark.setStartData();
                UIMenuCarPark uIMenuCarPark2 = this.menuCarParkLayout;
                if (uIMenuCarPark2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuCarParkLayout");
                    uIMenuCarPark2 = null;
                }
                uIMenuCarPark2.setVisibleButtonBackToMenu(this.ifFromMainMenuForCarPark);
                break;
            case 10:
                UIMenuFamilyUpgrade uIMenuFamilyUpgrade = this.menuFamilyUpgradeLayout;
                if (uIMenuFamilyUpgrade == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuFamilyUpgradeLayout");
                    uIMenuFamilyUpgrade = null;
                }
                uIMenuFamilyUpgrade.setVisibleButtonBackToMenu(this.ifFromMainMenuForUpgrade);
                break;
            case 11:
                UIMenuFamilyStore uIMenuFamilyStore = this.menuFamilyStoreLayout;
                if (uIMenuFamilyStore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuFamilyStoreLayout");
                    uIMenuFamilyStore = null;
                }
                uIMenuFamilyStore.setStartParameters(this.otherState);
                break;
        }
        UIContainer uIContainer2 = this.container;
        if (uIContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        } else {
            uIContainer = uIContainer2;
        }
        uIContainer.setCurrentLayout(i);
    }

    public final void upgradeFamily() {
        UIMenuFamilyUpgrade uIMenuFamilyUpgrade = this.menuFamilyUpgradeLayout;
        if (uIMenuFamilyUpgrade == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuFamilyUpgradeLayout");
            uIMenuFamilyUpgrade = null;
        }
        uIMenuFamilyUpgrade.upgradeFamily();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject jSONObject) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }
}