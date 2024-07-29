package com.rockstargames.gtacr.gui.woundSystem;

import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import blackrussia.online.R;
import blackrussia.online.databinding.WoundSystemDialogInfoBinding;
import blackrussia.online.databinding.WoundSystemMainLayoutBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010 J\b\u0010+\u001a\u00020\u0015H\u0016J\u0012\u0010,\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010-\u001a\u00020\u0013H\u0016J\u0012\u0010.\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\u0018\u00103\u001a\u00020&2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0002J$\u00107\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u00108\u001a\u0004\u0018\u00010\u00112\u0006\u00109\u001a\u00020\u000fH\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/rockstargames/gtacr/gui/woundSystem/GUIWoundSystem;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/woundSystem/ActionsWithJSON;", "alphaIfActive", "", "alphaIfNotActive", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/WoundSystemMainLayoutBinding;", "bindingDialog", "Lblackrussia/online/databinding/WoundSystemDialogInfoBinding;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "ifInformingServerAboutDismiss", "", "ifShowDialog", "", "inflater", "Landroid/view/LayoutInflater;", "invisible", "isClickButtonCloseSubInfo", "isClickButtonHelp", "isClickButtonHospital", "playersId", "playersNick", "", "popupWindow", "Landroid/widget/PopupWindow;", "popupWindowDialog", "timer", "Landroid/os/CountDownTimer;", "visible", "close", "", "json", "Lorg/json/JSONObject;", "closeAndroidsInterface", "popup", "getGuiId", "getStartParameters", "isShowingGui", "onPacketIncoming", "setLogicForDialog", "setPlayersInfo", "setStyleForDialogsText", "setStyleForText", "setTimerForButton", "seconds", "", "blockBothButtons", "show", "manager", "activity", "visibleBackground", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIWoundSystem implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private WoundSystemMainLayoutBinding binding;
    private WoundSystemDialogInfoBinding bindingDialog;
    private NvEventQueueActivity context;
    private GUIManager guiManager;
    private LayoutInflater inflater;
    private boolean isClickButtonCloseSubInfo;
    private boolean isClickButtonHelp;
    private boolean isClickButtonHospital;
    private PopupWindow popupWindow;
    private PopupWindow popupWindowDialog;
    private CountDownTimer timer;
    private int visible;
    private String playersNick = "";
    private int playersId = -1;
    private int ifShowDialog = -1;
    private boolean ifInformingServerAboutDismiss = true;
    private final float alphaIfNotActive = 0.5f;
    private final float alphaIfActive = 1.0f;
    private final int invisible = 4;

    @Override
    public int getGuiId() {
        return 40;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/woundSystem/GUIWoundSystem$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/woundSystem/GUIWoundSystem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GUIWoundSystem newInstance() {
            return new GUIWoundSystem();
        }
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("t"));
        if (valueOf != null && valueOf.intValue() == 2) {
            this.ifInformingServerAboutDismiss = false;
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            PopupWindow popupWindow2 = this.popupWindowDialog;
            if (popupWindow2 == null) {
                return;
            }
            popupWindow2.dismiss();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            setTimerForButton(30L, true);
        }
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        this.actionsWithJSON = new ActionsWithJSON(gUIManager);
        getStartParameters(jSONObject);
        this.ifInformingServerAboutDismiss = true;
        if (this.popupWindow == null) {
            Object systemService = activity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            this.inflater = layoutInflater;
            NvEventQueueActivity nvEventQueueActivity = null;
            if (layoutInflater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflater");
                layoutInflater = null;
            }
            WoundSystemMainLayoutBinding inflate = WoundSystemMainLayoutBinding.inflate(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            this.anim = loadAnimation;
            WoundSystemMainLayoutBinding woundSystemMainLayoutBinding = this.binding;
            if (woundSystemMainLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                woundSystemMainLayoutBinding = null;
            }
            this.popupWindow = new PopupWindow((View) woundSystemMainLayoutBinding.getRoot(), -1, -1, false);
            setStyleForText();
            setPlayersInfo();
            WoundSystemMainLayoutBinding woundSystemMainLayoutBinding2 = this.binding;
            if (woundSystemMainLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                woundSystemMainLayoutBinding2 = null;
            }
            woundSystemMainLayoutBinding2.buttonNeedHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIWoundSystem.m435show$lambda1(GUIWoundSystem.this, view);
                }
            });
            WoundSystemMainLayoutBinding woundSystemMainLayoutBinding3 = this.binding;
            if (woundSystemMainLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                woundSystemMainLayoutBinding3 = null;
            }
            woundSystemMainLayoutBinding3.buttonNeedHospital.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIWoundSystem.m437show$lambda3(GUIWoundSystem.this, view);
                }
            });
            NvEventQueueActivity nvEventQueueActivity2 = this.context;
            if (nvEventQueueActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                nvEventQueueActivity = nvEventQueueActivity2;
            }
            //nvEventQueueActivity.toggleDrawing2dStuff(true);
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                popupWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
            }
            closeAndroidsInterface(this.popupWindow);
            if (this.ifShowDialog == 0) {
                setLogicForDialog();
                visibleBackground(this.invisible);
            } else {
                setTimerForButton(15L, false);
            }
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUIWoundSystem.m439show$lambda4(GUIWoundSystem.this);
            }
        });
    }

    public static final void m435show$lambda1(GUIWoundSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getAlpha() == this$0.alphaIfActive) {
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            if (this$0.isClickButtonHelp) {
                return;
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //GUIWoundSystem.m436show$lambda1$lambda0(GUIWoundSystem.this);
                }
            }, 250L);
            this$0.isClickButtonHelp = true;
        }
    }

    public static final void m436show$lambda1$lambda0(GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendPressButton(1);
        this$0.setTimerForButton(30L, true);
    }

    public static final void m437show$lambda3(GUIWoundSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getAlpha() == this$0.alphaIfActive) {
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            if (this$0.isClickButtonHospital) {
                return;
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //GUIWoundSystem.m438show$lambda3$lambda2(GUIWoundSystem.this);
                }
            }, 250L);
            this$0.isClickButtonHospital = true;
        }
    }

    public static final void m438show$lambda3$lambda2(GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendPressButton(2);
    }

    public static final void m439show$lambda4(GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.ifInformingServerAboutDismiss) {
            ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
            if (actionsWithJSON == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                actionsWithJSON = null;
            }
            actionsWithJSON.sendPressButton(4);
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
        gUIManager.closeGUI(null, 40);
    }

    public final void closeAndroidsInterface(final PopupWindow popupWindow) {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        FrameLayout parentLayout = nvEventQueueActivity.getParentLayout();
        if (parentLayout == null) {
            return;
        }
        parentLayout.postDelayed(new Runnable() {
            @Override
            public final void run() {
                //GUIWoundSystem.m425closeAndroidsInterface$lambda6(popupWindow, this);
            }
        }, 300L);
    }

    public static final void m425closeAndroidsInterface$lambda6(final PopupWindow popupWindow, GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intrinsics.checkNotNull(popupWindow);
            GUIManager.hideSystemUI(popupWindow.getContentView());
        } catch (Exception unused) {
            NvEventQueueActivity nvEventQueueActivity = this$0.context;
            if (nvEventQueueActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                nvEventQueueActivity = null;
            }
            nvEventQueueActivity.getParentLayout().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    GUIWoundSystem.m426closeAndroidsInterface$lambda6$lambda5(popupWindow);
                }
            }, 1000L);
        }
    }

    public static final void m426closeAndroidsInterface$lambda6$lambda5(PopupWindow popupWindow) {
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
    }

    private final void getStartParameters(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(TuningConstants.KEY_GET_ID_DETAIL);
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"p\")");
        this.playersNick = optString;
        this.playersId = jSONObject.optInt(GetKeys.GET_PLAYERS_ID);
        this.ifShowDialog = jSONObject.optInt("h");
    }

    private final void setPlayersInfo() {
        if (Intrinsics.areEqual(this.playersNick, "") && this.playersId == -1) {
            this.playersNick = "";
            this.playersId = 0;
        }
        WoundSystemMainLayoutBinding woundSystemMainLayoutBinding = this.binding;
        NvEventQueueActivity nvEventQueueActivity = null;
        if (woundSystemMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            woundSystemMainLayoutBinding = null;
        }
        TextView textView = woundSystemMainLayoutBinding.playersNickAndId;
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            nvEventQueueActivity = nvEventQueueActivity2;
        }
        textView.setText(nvEventQueueActivity.getString(R.string.wound_system_players_nick_and_id, new Object[]{this.playersNick, String.valueOf(this.playersId)}));
    }

    private final void setLogicForDialog() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        WoundSystemDialogInfoBinding woundSystemDialogInfoBinding = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        Object systemService = nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        WoundSystemDialogInfoBinding inflate = WoundSystemDialogInfoBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.bindingDialog = inflate;
        WoundSystemDialogInfoBinding woundSystemDialogInfoBinding2 = this.bindingDialog;
        if (woundSystemDialogInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialog");
            woundSystemDialogInfoBinding2 = null;
        }
        this.popupWindowDialog = new PopupWindow((View) woundSystemDialogInfoBinding2.getRoot(), -1, -1, true);
        setStyleForDialogsText();
        PopupWindow popupWindow = this.popupWindowDialog;
        if (popupWindow != null) {
            NvEventQueueActivity nvEventQueueActivity2 = this.context;
            if (nvEventQueueActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                nvEventQueueActivity2 = null;
            }
            popupWindow.showAtLocation(nvEventQueueActivity2.getParentLayout(), 17, 0, 0);
        }
        closeAndroidsInterface(this.popupWindowDialog);
        WoundSystemDialogInfoBinding woundSystemDialogInfoBinding3 = this.bindingDialog;
        if (woundSystemDialogInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialog");
            woundSystemDialogInfoBinding3 = null;
        }
        woundSystemDialogInfoBinding3.closeWsDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIWoundSystem.m433setLogicForDialog$lambda9(GUIWoundSystem.this, view);
            }
        });
        WoundSystemDialogInfoBinding woundSystemDialogInfoBinding4 = this.bindingDialog;
        if (woundSystemDialogInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialog");
        } else {
            woundSystemDialogInfoBinding = woundSystemDialogInfoBinding4;
        }
        woundSystemDialogInfoBinding.textSubinfoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIWoundSystem.m430setLogicForDialog$lambda11(GUIWoundSystem.this, view);
            }
        });
        PopupWindow popupWindow2 = this.popupWindowDialog;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUIWoundSystem.m432setLogicForDialog$lambda12(GUIWoundSystem.this);
            }
        });
    }

    public static final void m433setLogicForDialog$lambda9(GUIWoundSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                //GUIWoundSystem.m434setLogicForDialog$lambda9$lambda8(GUIWoundSystem.this);
            }
        }, 250L);
    }

    public static final void m434setLogicForDialog$lambda9$lambda8(GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindowDialog;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m430setLogicForDialog$lambda11(GUIWoundSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isClickButtonCloseSubInfo) {
            return;
        }
        this$0.isClickButtonCloseSubInfo = true;
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                //GUIWoundSystem.m431setLogicForDialog$lambda11$lambda10(GUIWoundSystem.this);
            }
        }, 250L);
    }

    public static final void m431setLogicForDialog$lambda11$lambda10(GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        actionsWithJSON.sendPressButton(3);
        PopupWindow popupWindow = this$0.popupWindowDialog;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m432setLogicForDialog$lambda12(GUIWoundSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeAndroidsInterface(this$0.popupWindowDialog);
        this$0.visibleBackground(this$0.visible);
        this$0.setTimerForButton(15L, false);
    }

    private final void setStyleForText() {
        SpannableString spannableString = new SpannableString("Вы были ранены игроком");
        NvEventQueueActivity nvEventQueueActivity = this.context;
        WoundSystemMainLayoutBinding woundSystemMainLayoutBinding = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity, R.color.diving_school_yellow_text_background)), 8, 14, 33);
        WoundSystemMainLayoutBinding woundSystemMainLayoutBinding2 = this.binding;
        if (woundSystemMainLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            woundSystemMainLayoutBinding = woundSystemMainLayoutBinding2;
        }
        woundSystemMainLayoutBinding.titleDamage.setText(spannableString);
    }

    private final void setStyleForDialogsText() {
        SpannableString spannableString = new SpannableString("Вы можете моментально отправиться в больницу, либо дождаться помощи врача, который реанимирует Вас на месте.");
        NvEventQueueActivity nvEventQueueActivity = this.context;
        WoundSystemDialogInfoBinding woundSystemDialogInfoBinding = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity, R.color.diving_school_yellow_text_background)), 36, 44, 33);
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity2 = null;
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity2, R.color.diving_school_yellow_text_background)), 68, 73, 33);
        SpannableString spannableString2 = new SpannableString("Также другие игроки могут реанимировать Вас, воспользовавшись адреналином.\nПриобрести его можно в магазине 24/7.");
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        if (nvEventQueueActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity3 = null;
        }
        spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity3, R.color.diving_school_yellow_text_background)), 62, 73, 33);
        NvEventQueueActivity nvEventQueueActivity4 = this.context;
        if (nvEventQueueActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity4 = null;
        }
        spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity4, R.color.diving_school_yellow_text_background)), 98, 111, 33);
        WoundSystemDialogInfoBinding woundSystemDialogInfoBinding2 = this.bindingDialog;
        if (woundSystemDialogInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialog");
        } else {
            woundSystemDialogInfoBinding = woundSystemDialogInfoBinding2;
        }
        woundSystemDialogInfoBinding.textDoctor.setText(spannableString);
        woundSystemDialogInfoBinding.textFriends.setText(spannableString2);
    }

    private final void setTimerForButton(long j, boolean z) {
        WoundSystemMainLayoutBinding woundSystemMainLayoutBinding = this.binding;
        if (woundSystemMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            woundSystemMainLayoutBinding = null;
        }
        woundSystemMainLayoutBinding.buttonNeedHospital.setAlpha(this.alphaIfNotActive);
        woundSystemMainLayoutBinding.textInfoNeedHospital2.setVisibility(this.visible);
        woundSystemMainLayoutBinding.textInfoNeedHospital3.setVisibility(this.visible);
        if (z) {
            woundSystemMainLayoutBinding.buttonNeedHelp.setAlpha(this.alphaIfNotActive);
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = new CountDownTimer(j, 1000) {
            @Override
            public void onTick(long j3) {
                WoundSystemMainLayoutBinding woundSystemMainLayoutBinding2;
                NvEventQueueActivity nvEventQueueActivity;
                long j4 = j3 / 1000;
                woundSystemMainLayoutBinding2 = GUIWoundSystem.this.binding;
                NvEventQueueActivity nvEventQueueActivity2 = null;
                if (woundSystemMainLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    woundSystemMainLayoutBinding2 = null;
                }
                TextView textView = woundSystemMainLayoutBinding2.textInfoNeedHospital3;
                nvEventQueueActivity = GUIWoundSystem.this.context;
                if (nvEventQueueActivity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    nvEventQueueActivity2 = nvEventQueueActivity;
                }
                textView.setText(nvEventQueueActivity2.getString(R.string.wound_system_info_hospital_3, new Object[]{String.valueOf(j4)}));
            }

            @Override
            public void onFinish() {
                WoundSystemMainLayoutBinding woundSystemMainLayoutBinding2;
                float f;
                int i;
                int i2;
                woundSystemMainLayoutBinding2 = GUIWoundSystem.this.binding;
                if (woundSystemMainLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    woundSystemMainLayoutBinding2 = null;
                }
                GUIWoundSystem gUIWoundSystem = GUIWoundSystem.this;
                Button button = woundSystemMainLayoutBinding2.buttonNeedHospital;
                f = gUIWoundSystem.alphaIfActive;
                button.setAlpha(f);
                TextView textView = woundSystemMainLayoutBinding2.textInfoNeedHospital2;
                i = gUIWoundSystem.invisible;
                textView.setVisibility(i);
                TextView textView2 = woundSystemMainLayoutBinding2.textInfoNeedHospital3;
                i2 = gUIWoundSystem.invisible;
                textView2.setVisibility(i2);
                GUIWoundSystem.this.isClickButtonHospital = false;
                GUIWoundSystem.this.isClickButtonHelp = false;
            }
        }.start();
    }

    private final void visibleBackground(int i) {
        WoundSystemMainLayoutBinding woundSystemMainLayoutBinding = this.binding;
        if (woundSystemMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            woundSystemMainLayoutBinding = null;
        }
        woundSystemMainLayoutBinding.viewSmile.setVisibility(i);
        woundSystemMainLayoutBinding.titleDamage.setVisibility(i);
        woundSystemMainLayoutBinding.playersNickAndId.setVisibility(i);
        woundSystemMainLayoutBinding.buttonNeedHelp.setVisibility(i);
        woundSystemMainLayoutBinding.textInfoNeedHelp.setVisibility(i);
        woundSystemMainLayoutBinding.buttonNeedHospital.setVisibility(i);
        woundSystemMainLayoutBinding.textInfoNeedHospital1.setVisibility(i);
        woundSystemMainLayoutBinding.textInfoNeedHospital2.setVisibility(i);
        woundSystemMainLayoutBinding.textInfoNeedHospital3.setVisibility(i);
    }

    @Override
    public void close(JSONObject jSONObject) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = this.popupWindowDialog;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.dismiss();
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
