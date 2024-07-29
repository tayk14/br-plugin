package com.rockstargames.gtacr.gui.socialAction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.SocialInteractionBinding;
import blackrussia.online.network.SocialInteraction;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\u0012\u00102\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0006\u00103\u001a\u00020\u0010J\b\u00104\u001a\u00020\u0005H\u0016J\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u00020\"J\u0006\u00107\u001a\u00020\u0005J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\b\u0010;\u001a\u00020\u0018H\u0016J\u0012\u0010<\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u000e\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\"J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0018\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005H\u0002J\u0016\u0010F\u001a\u00020-2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\b\u0010G\u001a\u00020-H\u0002J$\u0010H\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010I\u001a\u0004\u0018\u00010\u00122\u0006\u0010J\u001a\u00020\u0010H\u0016J\u0016\u0010K\u001a\u00020-2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u0006\u0010M\u001a\u00020-J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020PH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00070\u0007 \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialAction/GUISocialInteraction;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "actualIdsArray", "", "", "actualListWithActions", "Lblackrussia/online/network/SocialInteraction;", "allListWithActions", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/SocialInteractionBinding;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "guideForSocialInteraction", "Lcom/rockstargames/gtacr/gui/socialAction/GuideForSocialInteraction;", "inflater", "Landroid/view/LayoutInflater;", "isBlockedForMessageError", "", "isGuide", "logicSetView", "Lcom/rockstargames/gtacr/gui/socialAction/SetViewByValueOfActions;", "minTimerForBlock", "oldTimer", "", "playerInOrganization", "playersId", "playersNick", "", "popupWindow", "Landroid/widget/PopupWindow;", "positionsGetter", "Lcom/rockstargames/gtacr/gui/socialAction/PositionsGetter;", "thisListWithCommunicationMain", "thisListWithOrganizationMain", "thisListWithSocialMain", "thisPage", "thisType", "close", "", "json", "Lorg/json/JSONObject;", "closeAndroidsInterface", "getActualListWithAction", "getAllParameters", "getContext", "getGuiId", "getPlayersId", "getPlayersNick", "getStatusInOrganization", "getThisListWithCommunicationMain", "getThisListWithOrganizationMain", "getThisListWithSocialMain", "isShowingGui", "onPacketIncoming", "sendIfCloseOrChangePlayer", "typeButton", "sendMessageError", "message", "sendPressButton", "actionsId", "setLogicForClick", Const.FRACTION_TYPE_KEY, Const.PAGE_KEY, "setMultipleLists", "setStartParameters", "show", "manager", "activity", "splitList", "actionsList", "startGuide", "updatePageOrBackToMain", "thisButton", "Landroid/widget/TextView;", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUISocialInteraction implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private Animation anim;
    private SocialInteractionBinding binding;
    private NvEventQueueActivity context;
    private GUIManager guiManager;
    private GuideForSocialInteraction guideForSocialInteraction;
    private LayoutInflater inflater;
    private boolean isBlockedForMessageError;
    private boolean isGuide;
    private SetViewByValueOfActions logicSetView;
    private long oldTimer;
    private int playerInOrganization;
    private int playersId;
    private PopupWindow popupWindow;
    private PositionsGetter positionsGetter;
    private int thisPage;
    private int thisType = 4;
    private List<SocialInteraction> thisListWithOrganizationMain = new ArrayList();
    private List<SocialInteraction> thisListWithSocialMain = new ArrayList();
    private List<SocialInteraction> thisListWithCommunicationMain = new ArrayList();
    private List<SocialInteraction> actualListWithActions = new ArrayList();
    private List<Integer> actualIdsArray = new ArrayList();
    private final ArrayList<SocialInteraction> allListWithActions = App.getInstance().getSocialInteractions();
    private String playersNick = "";
    private final int minTimerForBlock = PathInterpolatorCompat.MAX_NUM_POINTS;

    @Override
    public int getGuiId() {
        return 36;
    }

    public final void startGuide() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUISocialInteraction.m389startGuide$lambda0(GUISocialInteraction.this);
            }
        }, 200L);
    }

    public static final void m389startGuide$lambda0(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isGuide = true;
        GuideForSocialInteraction guideForSocialInteraction = this$0.guideForSocialInteraction;
        if (guideForSocialInteraction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            guideForSocialInteraction = null;
        }
        guideForSocialInteraction.setGuide(0);
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialAction/GUISocialInteraction$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/socialAction/GUISocialInteraction;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GUISocialInteraction newInstance() {
            return new GUISocialInteraction();
        }
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("t"));
        if (valueOf != null && valueOf.intValue() == 2) {
            getAllParameters(jSONObject);
            setStartParameters();
        }
    }

    public final NvEventQueueActivity getContext() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            return null;
        }
        return nvEventQueueActivity;
    }

    public final String getPlayersNick() {
        return this.playersNick;
    }

    public final int getPlayersId() {
        return this.playersId;
    }

    public final int getStatusInOrganization() {
        return this.playerInOrganization;
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        SocialInteractionBinding socialInteractionBinding = null;
        if (this.popupWindow == null) {
            Object systemService = activity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            this.inflater = layoutInflater;
            if (layoutInflater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflater");
                layoutInflater = null;
            }
            SocialInteractionBinding inflate = SocialInteractionBinding.inflate(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            this.anim = loadAnimation;
            SocialInteractionBinding socialInteractionBinding2 = this.binding;
            if (socialInteractionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                socialInteractionBinding2 = null;
            }
            this.popupWindow = new PopupWindow((View) socialInteractionBinding2.getRoot(), -1, -1, true);
            getAllParameters(jSONObject);
            setStartParameters();
        }
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        //nvEventQueueActivity.toggleDrawing2dStuff(true);
        PopupWindow popupWindow = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
        closeAndroidsInterface();
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(activity.getParentLayout(), 17, 0, 0);
        }
        SocialInteractionBinding socialInteractionBinding3 = this.binding;
        if (socialInteractionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding3 = null;
        }
        socialInteractionBinding3.closeInteraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m372show$lambda2(GUISocialInteraction.this, view);
            }
        });
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUISocialInteraction.m382show$lambda3(GUISocialInteraction.this);
                }
            });
        }
        SocialInteractionBinding socialInteractionBinding4 = this.binding;
        if (socialInteractionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding4 = null;
        }
        socialInteractionBinding4.bgSocialInteraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m384show$lambda4(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding5 = this.binding;
        if (socialInteractionBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding5 = null;
        }
        socialInteractionBinding5.buttonWithNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m385show$lambda6(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding6 = this.binding;
        if (socialInteractionBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding6 = null;
        }
        socialInteractionBinding6.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m387show$lambda9(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding7 = this.binding;
        if (socialInteractionBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding7 = null;
        }
        socialInteractionBinding7.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m366show$lambda13(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding8 = this.binding;
        if (socialInteractionBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding8 = null;
        }
        socialInteractionBinding8.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m369show$lambda17(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding9 = this.binding;
        if (socialInteractionBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding9 = null;
        }
        socialInteractionBinding9.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m374show$lambda20(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding10 = this.binding;
        if (socialInteractionBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding10 = null;
        }
        socialInteractionBinding10.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m376show$lambda23(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding11 = this.binding;
        if (socialInteractionBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding11 = null;
        }
        socialInteractionBinding11.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m378show$lambda26(GUISocialInteraction.this, view);
            }
        });
        SocialInteractionBinding socialInteractionBinding12 = this.binding;
        if (socialInteractionBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            socialInteractionBinding = socialInteractionBinding12;
        }
        socialInteractionBinding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialInteraction.m380show$lambda29(GUISocialInteraction.this, view);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUISocialInteraction.m383show$lambda30(GUISocialInteraction.this);
            }
        }, 100L);
    }

    public static final void m372show$lambda2(GUISocialInteraction this$0, View view) {
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
                //GUISocialInteraction.m373show$lambda2$lambda1(GUISocialInteraction.this);
            }
        }, 250L);
    }

    public static final void m373show$lambda2$lambda1(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m382show$lambda3(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        //nvEventQueueActivity.toggleDrawing2dStuff(false);
        this$0.sendIfCloseOrChangePlayer(1);
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager == null) {
            return;
        }
        gUIManager.closeGUI(null, 36);
    }

    public static final void m384show$lambda4(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m385show$lambda6(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.v(Utils.LOG_TAG, "кнопка для смены никнейма и ид, чтобы переоткрыть интерфейс");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
            }
        }, 250L);
    }

    public static final void m386show$lambda6$lambda5(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            this$0.sendIfCloseOrChangePlayer(2);
            this$0.isBlockedForMessageError = false;
        } else if (this$0.isBlockedForMessageError) {
        } else {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
    }

    public static final void m387show$lambda9(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        Log.v(Utils.LOG_TAG, "кнопка_1");
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
            }
        }, 250L);
    }

    public static final void m388show$lambda9$lambda8(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
            if (setViewByValueOfActions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                setViewByValueOfActions = null;
            }
            SocialInteraction actionFromButton1 = setViewByValueOfActions.getActionFromButton1();
            Utils.INSTANCE.logThisAction(actionFromButton1);
            if (actionFromButton1 != null) {
                this$0.sendPressButton(actionFromButton1.getId());
            }
            this$0.isBlockedForMessageError = false;
        } else if (!this$0.isBlockedForMessageError) {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction2;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m366show$lambda13(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.v(Utils.LOG_TAG, "кнопка_2");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
            }
        }, 250L);
    }

    public static final void m367show$lambda13$lambda12(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.thisType == 4 && this$0.playerInOrganization == 1) {
            if (this$0.thisListWithCommunicationMain.size() == 0) {
                this$0.sendMessageError("В текущем типе взаимодействия отсутствуют доступные команды");
            } else {
                this$0.thisType = 3;
                this$0.thisPage = 0;
                this$0.setLogicForClick(3, 0);
            }
            if (this$0.isGuide) {
                GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
                if (guideForSocialInteraction2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
                    guideForSocialInteraction2 = null;
                }
                guideForSocialInteraction2.setVisibleGuide(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public final void run() {
                    }
                }, 50L);
            }
        } else if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
            if (setViewByValueOfActions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                setViewByValueOfActions = null;
            }
            SocialInteraction actionFromButton2 = setViewByValueOfActions.getActionFromButton2();
            Utils.INSTANCE.logThisAction(actionFromButton2);
            if (actionFromButton2 != null) {
                this$0.sendPressButton(actionFromButton2.getId());
            }
            this$0.isBlockedForMessageError = false;
        } else if (!this$0.isBlockedForMessageError) {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction3 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction3;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m368show$lambda13$lambda12$lambda10(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PositionsGetter positionsGetter = this$0.positionsGetter;
        if (positionsGetter != null) {
            positionsGetter.getPositions();
        }
        GuideForSocialInteraction guideForSocialInteraction = this$0.guideForSocialInteraction;
        if (guideForSocialInteraction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            guideForSocialInteraction = null;
        }
        guideForSocialInteraction.setGuide(1);
    }

    public static final void m369show$lambda17(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        Log.v(Utils.LOG_TAG, "кнопка_3");
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
            }
        }, 250L);
    }

    public static final void m370show$lambda17$lambda16(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.thisType == 4 && this$0.playerInOrganization == 0) {
            if (this$0.thisListWithCommunicationMain.size() == 0) {
                this$0.sendMessageError("В текущем типе взаимодействия отсутствуют доступные команды");
            } else {
                this$0.thisType = 3;
                this$0.thisPage = 0;
                this$0.setLogicForClick(3, 0);
            }
            if (this$0.isGuide) {
                GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
                if (guideForSocialInteraction2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
                    guideForSocialInteraction2 = null;
                }
                guideForSocialInteraction2.setVisibleGuide(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public final void run() {

                    }
                }, 50L);
            }
        } else {
            SocialInteractionBinding socialInteractionBinding = this$0.binding;
            if (socialInteractionBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                socialInteractionBinding = null;
            }
            CharSequence text = socialInteractionBinding.button3.getText();
            NvEventQueueActivity nvEventQueueActivity = this$0.context;
            if (nvEventQueueActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                nvEventQueueActivity = null;
            }
            if (Intrinsics.areEqual(text, nvEventQueueActivity.getText(R.string.if_with_additionally))) {
                int i = this$0.thisPage + 1;
                this$0.thisPage = i;
                this$0.setLogicForClick(this$0.thisType, i);
                Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("thisPage = ", Integer.valueOf(this$0.thisPage)));
            } else if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
                this$0.oldTimer = System.currentTimeMillis();
                SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
                if (setViewByValueOfActions == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                    setViewByValueOfActions = null;
                }
                SocialInteraction actionFromButton3 = setViewByValueOfActions.getActionFromButton3();
                Utils.INSTANCE.logThisAction(actionFromButton3);
                if (actionFromButton3 != null) {
                    this$0.sendPressButton(actionFromButton3.getId());
                }
                this$0.isBlockedForMessageError = false;
            } else if (!this$0.isBlockedForMessageError) {
                this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
                this$0.isBlockedForMessageError = true;
            }
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction3 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction3;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m371show$lambda17$lambda16$lambda14(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PositionsGetter positionsGetter = this$0.positionsGetter;
        if (positionsGetter != null) {
            positionsGetter.getPositions();
        }
        GuideForSocialInteraction guideForSocialInteraction = this$0.guideForSocialInteraction;
        if (guideForSocialInteraction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            guideForSocialInteraction = null;
        }
        guideForSocialInteraction.setGuide(1);
    }

    public static final void m374show$lambda20(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        Log.v(Utils.LOG_TAG, "кнопка_4");
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {

            }
        }, 250L);
    }

    public static final void m375show$lambda20$lambda19(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.thisType == 4 && this$0.playerInOrganization == 1) {
            if (this$0.thisListWithSocialMain.size() == 0) {
                this$0.sendMessageError("В текущем типе взаимодействия отсутствуют доступные команды");
            } else {
                this$0.thisType = 2;
                this$0.thisPage = 0;
                this$0.setLogicForClick(2, 0);
            }
        } else if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            SocialInteractionBinding socialInteractionBinding = this$0.binding;
            if (socialInteractionBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                socialInteractionBinding = null;
            }
            TextView textView = socialInteractionBinding.button4;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.button4");
            this$0.updatePageOrBackToMain(textView);
            SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
            if (setViewByValueOfActions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                setViewByValueOfActions = null;
            }
            SocialInteraction actionFromButton4 = setViewByValueOfActions.getActionFromButton4();
            Utils.INSTANCE.logThisAction(actionFromButton4);
            if (actionFromButton4 != null) {
                this$0.sendPressButton(actionFromButton4.getId());
            }
            this$0.isBlockedForMessageError = false;
        } else if (!this$0.isBlockedForMessageError) {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction2;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m376show$lambda23(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.v(Utils.LOG_TAG, "кнопка_5");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {

            }
        }, 250L);
    }

    public static final void m377show$lambda23$lambda22(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.thisType == 4 && this$0.playerInOrganization == 0) {
            if (this$0.thisListWithSocialMain.size() == 0) {
                this$0.sendMessageError("В текущем типе взаимодействия отсутствуют доступные команды");
            } else {
                this$0.thisType = 2;
                this$0.thisPage = 0;
                this$0.setLogicForClick(2, 0);
            }
        } else if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            SocialInteractionBinding socialInteractionBinding = this$0.binding;
            if (socialInteractionBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                socialInteractionBinding = null;
            }
            TextView textView = socialInteractionBinding.button5;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.button5");
            this$0.updatePageOrBackToMain(textView);
            SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
            if (setViewByValueOfActions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                setViewByValueOfActions = null;
            }
            SocialInteraction actionFromButton5 = setViewByValueOfActions.getActionFromButton5();
            Utils.INSTANCE.logThisAction(actionFromButton5);
            if (actionFromButton5 != null) {
                this$0.sendPressButton(actionFromButton5.getId());
            }
            this$0.isBlockedForMessageError = false;
        } else if (!this$0.isBlockedForMessageError) {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction2;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m378show$lambda26(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.v(Utils.LOG_TAG, "кнопка_6");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {

            }
        }, 250L);
    }

    public static final void m379show$lambda26$lambda25(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.thisType == 4 && this$0.playerInOrganization == 1) {
            if (this$0.thisListWithOrganizationMain.size() == 0) {
                this$0.sendMessageError("В текущем типе взаимодействия отсутствуют доступные команды");
            } else {
                this$0.thisType = 1;
                this$0.thisPage = 0;
                this$0.setLogicForClick(1, 0);
            }
        } else if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
            if (setViewByValueOfActions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                setViewByValueOfActions = null;
            }
            SocialInteraction actionFromButton6 = setViewByValueOfActions.getActionFromButton6();
            Utils.INSTANCE.logThisAction(actionFromButton6);
            if (actionFromButton6 != null) {
                this$0.sendPressButton(actionFromButton6.getId());
            }
            this$0.isBlockedForMessageError = false;
        } else if (!this$0.isBlockedForMessageError) {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction2;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m380show$lambda29(GUISocialInteraction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.v(Utils.LOG_TAG, "кнопка_7");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {

            }
        }, 250L);
    }

    public static final void m381show$lambda29$lambda28(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuideForSocialInteraction guideForSocialInteraction = null;
        if (this$0.oldTimer != System.currentTimeMillis() && System.currentTimeMillis() - this$0.oldTimer > this$0.minTimerForBlock) {
            this$0.oldTimer = System.currentTimeMillis();
            SetViewByValueOfActions setViewByValueOfActions = this$0.logicSetView;
            if (setViewByValueOfActions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
                setViewByValueOfActions = null;
            }
            SocialInteraction actionFromButton7 = setViewByValueOfActions.getActionFromButton7();
            Utils.INSTANCE.logThisAction(actionFromButton7);
            if (actionFromButton7 != null) {
                this$0.sendPressButton(actionFromButton7.getId());
            }
            this$0.isBlockedForMessageError = false;
        } else if (!this$0.isBlockedForMessageError) {
            this$0.sendMessageError("Взаимодействовать с игроком можно раз в 3 секунды");
            this$0.isBlockedForMessageError = true;
        }
        if (this$0.isGuide) {
            GuideForSocialInteraction guideForSocialInteraction2 = this$0.guideForSocialInteraction;
            if (guideForSocialInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideForSocialInteraction");
            } else {
                guideForSocialInteraction = guideForSocialInteraction2;
            }
            guideForSocialInteraction.setVisibleGuide(false);
        }
    }

    public static final void m383show$lambda30(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SocialInteractionBinding socialInteractionBinding = this$0.binding;
        SocialInteractionBinding socialInteractionBinding2 = null;
        if (socialInteractionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding = null;
        }
        PositionsGetter positionsGetter = new PositionsGetter(socialInteractionBinding);
        this$0.positionsGetter = positionsGetter;
        Intrinsics.checkNotNull(positionsGetter);
        positionsGetter.getPositions();
        SocialInteractionBinding socialInteractionBinding3 = this$0.binding;
        if (socialInteractionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            socialInteractionBinding2 = socialInteractionBinding3;
        }
        PositionsGetter positionsGetter2 = this$0.positionsGetter;
        Intrinsics.checkNotNull(positionsGetter2);
        this$0.guideForSocialInteraction = new GuideForSocialInteraction(socialInteractionBinding2, positionsGetter2);
    }

    private final void setMultipleLists(List<SocialInteraction> list) {
        this.thisListWithOrganizationMain.clear();
        this.thisListWithSocialMain.clear();
        this.thisListWithCommunicationMain.clear();
        for (SocialInteraction socialInteraction : list) {
            int type = socialInteraction.getType();
            if (type == 1) {
                this.thisListWithOrganizationMain.add(socialInteraction);
            } else if (type == 2) {
                this.thisListWithSocialMain.add(socialInteraction);
            } else if (type == 3) {
                this.thisListWithCommunicationMain.add(socialInteraction);
            }
        }
    }

    private final void splitList(List<SocialInteraction> list) {
        if (list.size() > 6) {
            int size = list.size();
            int i = 0;
            int i2 = 0;
            for (int i3 = 5; i3 < size; i3++) {
                list.get(i3).setPage(1);
                i2++;
            }
            if (i2 > 6) {
                int size2 = list.size();
                for (int i4 = 10; i4 < size2; i4++) {
                    list.get(i4).setPage(2);
                    i++;
                }
                if (i > 6) {
                    int size3 = list.size();
                    for (int i5 = 15; i5 < size3; i5++) {
                        list.get(i5).setPage(3);
                    }
                }
            }
        }
    }

    public final List<SocialInteraction> getThisListWithOrganizationMain() {
        return this.thisListWithOrganizationMain;
    }

    public final List<SocialInteraction> getThisListWithSocialMain() {
        return this.thisListWithSocialMain;
    }

    public final List<SocialInteraction> getThisListWithCommunicationMain() {
        return this.thisListWithCommunicationMain;
    }

    private final void closeAndroidsInterface() {
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
                GUISocialInteraction.m358closeAndroidsInterface$lambda32(GUISocialInteraction.this);
            }
        }, 300L);
    }

    public static final void m358closeAndroidsInterface$lambda32(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            PopupWindow popupWindow = this$0.popupWindow;
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

                }
            }, 1000L);
        }
    }

    public static final void m359closeAndroidsInterface$lambda32$lambda31(GUISocialInteraction this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
    }

    private final void setLogicForClick(int i, int i2) {
        SetViewByValueOfActions setViewByValueOfActions = this.logicSetView;
        if (setViewByValueOfActions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
            setViewByValueOfActions = null;
        }
        setViewByValueOfActions.updateButtonsText(i, i2);
    }

    private final void updatePageOrBackToMain(TextView textView) {
        CharSequence text = textView.getText();
        NvEventQueueActivity nvEventQueueActivity = this.context;
        SetViewByValueOfActions setViewByValueOfActions = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        if (Intrinsics.areEqual(text, nvEventQueueActivity.getText(R.string.if_with_back))) {
            int i = this.thisPage;
            if (i > 0) {
                int i2 = i - 1;
                this.thisPage = i2;
                setLogicForClick(this.thisType, i2);
                Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("thisPage = ", Integer.valueOf(this.thisPage)));
                return;
            }
            this.thisType = 4;
            SetViewByValueOfActions setViewByValueOfActions2 = this.logicSetView;
            if (setViewByValueOfActions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
            } else {
                setViewByValueOfActions = setViewByValueOfActions2;
            }
            setViewByValueOfActions.setStartButtons(this.playersNick, this.playersId, this.playerInOrganization);
        }
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

    private final void getAllParameters(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("n");
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"n\")");
        this.playersNick = optString;
        Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("playersNick = ", optString));
        int optInt = jSONObject.optInt(GetKeys.GET_PLAYERS_ID);
        this.playersId = optInt;
        Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("playersId = ", Integer.valueOf(optInt)));
        int optInt2 = jSONObject.optInt("w");
        this.playerInOrganization = optInt2;
        Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("playerInOrganization = ", Integer.valueOf(optInt2)));
        JSONArray optJSONArray = jSONObject.optJSONArray(GetKeys.GET_PLAYERS_ITEMS_IN_SLOT);
        if (optJSONArray != null) {
            this.actualIdsArray.clear();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    this.actualIdsArray.add(Integer.valueOf(Integer.parseInt(optJSONArray.get(i).toString())));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Log.v(Utils.LOG_TAG, "actualIdsArray[" + i + "] = " + this.actualIdsArray.get(i).intValue());
            }
        }
    }

    private final void setStartParameters() {
        getActualListWithAction();
        setMultipleLists(this.actualListWithActions);
        splitList(this.thisListWithOrganizationMain);
        splitList(this.thisListWithSocialMain);
        splitList(this.thisListWithCommunicationMain);
        SocialInteractionBinding socialInteractionBinding = this.binding;
        if (socialInteractionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            socialInteractionBinding = null;
        }
        SetViewByValueOfActions setViewByValueOfActions = new SetViewByValueOfActions(this, socialInteractionBinding);
        this.logicSetView = setViewByValueOfActions;
        this.thisType = 4;
        if (setViewByValueOfActions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logicSetView");
            setViewByValueOfActions = null;
        }
        setViewByValueOfActions.setStartButtons(this.playersNick, this.playersId, this.playerInOrganization);
    }

    private final void sendPressButton(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            jSONObject.put(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(36, jSONObject);
            }
            Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("put data sendPressButton: actionsId = ", Integer.valueOf(i)));
        } catch (Exception e) {
            Log.v(Utils.LOG_TAG, Log.getStackTraceString(e));
        }
    }

    private final void sendIfCloseOrChangePlayer(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(36, jSONObject);
            }
            Log.v(Utils.LOG_TAG, Intrinsics.stringPlus("put key t: ", Integer.valueOf(i)));
        } catch (Exception e) {
            Log.v(Utils.LOG_TAG, Log.getStackTraceString(e));
        }
    }

    public final void sendMessageError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put("t", 2);
            jSONObject.put("d", 3);
            jSONObject.put("i", message);
            jSONObject.put("s", -1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.onPacketIncoming(13, jSONObject);
            }
            Log.v(Utils.LOG_TAG, "open menu with id = 13");
        } catch (Exception e) {
            Log.v(Utils.LOG_TAG, Log.getStackTraceString(e));
        }
    }

    private final void getActualListWithAction() {
        for (Integer num : this.actualIdsArray) {
            int intValue = num.intValue();
            Iterator<SocialInteraction> it = this.allListWithActions.iterator();
            while (true) {
                if (it.hasNext()) {
                    SocialInteraction action = it.next();
                    if (intValue == action.getId()) {
                        List<SocialInteraction> list = this.actualListWithActions;
                        Intrinsics.checkNotNullExpressionValue(action, "action");
                        list.add(action);
                        break;
                    }
                }
            }
        }
    }
}
