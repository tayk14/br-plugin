package com.rockstargames.gtacr.gui.drivingSchool;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolEndTestBinding;
import blackrussia.online.databinding.DrivingSchoolMainDialogBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.data.DrivingMainType;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u001fJ\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020\u0007H\u0016J\u0012\u0010+\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010,\u001a\u00020\u0019H\u0016J\u0010\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/J\u0012\u00100\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u000e\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u0007J\u000e\u00105\u001a\u00020$2\u0006\u00104\u001a\u00020\u0007J\b\u00106\u001a\u00020$H\u0002J$\u00107\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u00108\u001a\u0004\u0018\u00010\u00172\u0006\u00109\u001a\u00020\u0015H\u0016J\u0018\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/drivingSchool/ActionsWithJSON;", "actualPriceForType", "", "", "actualStatusForType", "allQuestions", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/DrivingSchoolMainDialogBinding;", "bindingEndTest", "Lblackrussia/online/databinding/DrivingSchoolEndTestBinding;", "classInfoLayout", "Lcom/rockstargames/gtacr/gui/drivingSchool/UIClassInfoLayout;", "container", "Lcom/rockstargames/gtacr/common/UIContainer;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "ifNotInformingAboutDismiss", "", "logicForDialogEndTest", "Lcom/rockstargames/gtacr/gui/drivingSchool/LogicForDialogEndTest;", "maiLayout", "Lcom/rockstargames/gtacr/gui/drivingSchool/UIMainLayout;", "popupWindow", "Landroid/widget/PopupWindow;", "popupWindowEndTest", "questionsLayout", "Lcom/rockstargames/gtacr/gui/drivingSchool/UIQuestions;", "close", "", "json", "Lorg/json/JSONObject;", "closeAndroidsInterface", "popup", "closePopupWindows", "getGuiId", "getStatusesFromServer", "isShowingGui", "listenerForLayout", "currentCategory", "Lcom/rockstargames/gtacr/data/DrivingMainType;", "onPacketIncoming", "sendForServerCheckAnswer", "answer", "sendForServerCheckType", Const.FRACTION_TYPE_KEY, "sendToServerClickButton", "setNullableParameters", "show", "manager", "activity", "startPopupWindowEndTest", "statusTest", "correctAnswers", "startTest", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIDrivingSchool implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private ActionsWithJSON actionsWithJSON;
    private int allQuestions;
    private Animation anim;
    private DrivingSchoolMainDialogBinding binding;
    private DrivingSchoolEndTestBinding bindingEndTest;
    private UIClassInfoLayout classInfoLayout;
    private UIContainer container;
    private NvEventQueueActivity context;
    private GUIManager guiManager;
    private boolean ifNotInformingAboutDismiss;
    private LogicForDialogEndTest logicForDialogEndTest;
    private UIMainLayout maiLayout;
    private PopupWindow popupWindow;
    private PopupWindow popupWindowEndTest;
    private UIQuestions questionsLayout;
    private List<Integer> actualStatusForType = new ArrayList();
    private List<Integer> actualPriceForType = new ArrayList();

    @Override
    public int getGuiId() {
        return 37;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GUIDrivingSchool newInstance() {
            return new GUIDrivingSchool();
        }
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        UIMainLayout uIMainLayout;
        Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("t"));
        Integer valueOf2 = jSONObject != null ? Integer.valueOf(jSONObject.optInt("s")) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                UIMainLayout uIMainLayout2 = this.maiLayout;
                if (uIMainLayout2 == null) {
                    return;
                }
                uIMainLayout2.clearCounter();
            } else if (valueOf2 == null || valueOf2.intValue() != 1 || (uIMainLayout = this.maiLayout) == null) {
            } else {
                uIMainLayout.openInfoAboutType();
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                UIClassInfoLayout uIClassInfoLayout = this.classInfoLayout;
                if (uIClassInfoLayout == null) {
                    return;
                }
                uIClassInfoLayout.setIfStartTest(false);
            } else if (valueOf2 != null && valueOf2.intValue() == 1) {
                this.allQuestions = jSONObject.optInt("q");
                startTest();
            }
        } else if (valueOf != null && valueOf.intValue() == 3) {
            int optInt = jSONObject.optInt("cq");
            int optInt2 = jSONObject.optInt("a");
            int optInt3 = jSONObject.optInt("b");
            UIQuestions uIQuestions = this.questionsLayout;
            if (uIQuestions == null) {
                return;
            }
            uIQuestions.setInfoForQuestion(optInt, optInt2, optInt3, this.allQuestions);
        } else if (valueOf != null && valueOf.intValue() == 4) {
            startPopupWindowEndTest(jSONObject.optInt("s"), jSONObject.optInt("cq"));
        }
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        View view;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        this.actionsWithJSON = new ActionsWithJSON(gUIManager);
        if (this.popupWindow == null) {
            Object systemService = activity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            DrivingSchoolMainDialogBinding inflate = DrivingSchoolMainDialogBinding.inflate((LayoutInflater) systemService);
            this.binding = inflate;
            if (inflate != null) {
                this.anim = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
                this.popupWindow = new PopupWindow((View) inflate.getRoot(), -1, -1, true);
            }
        }
        getStatusesFromServer(jSONObject);
        this.maiLayout = new UIMainLayout(this, activity);
        this.classInfoLayout = new UIClassInfoLayout(this, activity);
        this.questionsLayout = new UIQuestions(this, activity);
        DrivingSchoolMainDialogBinding drivingSchoolMainDialogBinding = this.binding;
        UIContainer uIContainer = drivingSchoolMainDialogBinding == null ? null : drivingSchoolMainDialogBinding.drivingSchoolMainContainer;
        this.container = uIContainer;
        if (uIContainer != null) {
            uIContainer.addLayout(1, this.maiLayout);
        }
        UIContainer uIContainer2 = this.container;
        if (uIContainer2 != null) {
            uIContainer2.addLayout(2, this.classInfoLayout);
        }
        UIContainer uIContainer3 = this.container;
        if (uIContainer3 != null) {
            uIContainer3.addLayout(3, this.questionsLayout);
        }
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity != null) {
            //nvEventQueueActivity.toggleDrawing2dStuff(true);
        }
        closeAndroidsInterface(this.popupWindow);
        PopupWindow popupWindow = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(activity.getParentLayout(), 17, 0, 0);
        }
        UIMainLayout uIMainLayout = this.maiLayout;
        if (uIMainLayout != null) {
            uIMainLayout.setStartParameters(this.actualStatusForType, this.actualPriceForType);
        }
        UIContainer uIContainer4 = this.container;
        if (uIContainer4 != null) {
            uIContainer4.setCurrentLayout(1);
        }
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUIDrivingSchool.m124show$lambda1(GUIDrivingSchool.this);
                }
            });
        }
        DrivingSchoolMainDialogBinding drivingSchoolMainDialogBinding2 = this.binding;
        if (drivingSchoolMainDialogBinding2 == null || (view = drivingSchoolMainDialogBinding2.drivingSchoolClose) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                GUIDrivingSchool.m125show$lambda3(GUIDrivingSchool.this, view2);
            }
        });
    }

    public static final void m124show$lambda1(GUIDrivingSchool this$0) {
        ActionsWithJSON actionsWithJSON;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.ifNotInformingAboutDismiss && (actionsWithJSON = this$0.actionsWithJSON) != null) {
            actionsWithJSON.sendPressButton(0);
        }
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity != null) {
            //nvEventQueueActivity.toggleDrawing2dStuff(false);
        }
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager != null) {
            gUIManager.closeGUI(null, 37);
        }
        this$0.closePopupWindows();
        this$0.setNullableParameters();
    }

    public static final void m125show$lambda3(GUIDrivingSchool this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                //GUIDrivingSchool.m126show$lambda3$lambda2(GUIDrivingSchool.this);
            }
        }, 250L);
    }

    public static final void m126show$lambda3$lambda2(GUIDrivingSchool this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public final void closeAndroidsInterface(final PopupWindow popupWindow) {
        FrameLayout parentLayout;
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null || (parentLayout = nvEventQueueActivity.getParentLayout()) == null) {
            return;
        }
        parentLayout.postDelayed(new Runnable() {
            @Override
            public final void run() {
                //GUIDrivingSchool.m119closeAndroidsInterface$lambda5(popupWindow, this);
            }
        }, 300L);
    }

    public static final void m119closeAndroidsInterface$lambda5(final PopupWindow popupWindow, GUIDrivingSchool this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intrinsics.checkNotNull(popupWindow);
            GUIManager.hideSystemUI(popupWindow.getContentView());
        } catch (Exception unused) {
            NvEventQueueActivity nvEventQueueActivity = this$0.context;
            Intrinsics.checkNotNull(nvEventQueueActivity);
            nvEventQueueActivity.getParentLayout().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    GUIDrivingSchool.m120closeAndroidsInterface$lambda5$lambda4(popupWindow);
                }
            }, 1000L);
        }
    }

    public static final void m120closeAndroidsInterface$lambda5$lambda4(PopupWindow popupWindow) {
        Intrinsics.checkNotNull(popupWindow);
        GUIManager.hideSystemUI(popupWindow.getContentView());
    }

    public final void listenerForLayout(DrivingMainType drivingMainType) {
        UIClassInfoLayout uIClassInfoLayout = this.classInfoLayout;
        if (uIClassInfoLayout != null) {
            uIClassInfoLayout.setStartView(drivingMainType);
        }
        UIContainer uIContainer = this.container;
        if (uIContainer == null) {
            return;
        }
        uIContainer.setCurrentLayout(2);
    }

    private final void startTest() {
        UIContainer uIContainer = this.container;
        if (uIContainer != null) {
            uIContainer.setCurrentLayout(3);
        }
        UIQuestions uIQuestions = this.questionsLayout;
        if (uIQuestions == null) {
            return;
        }
        uIQuestions.startTimer();
    }

    private final void getStatusesFromServer(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("a");
        if (optJSONArray != null) {
            this.actualStatusForType.clear();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    this.actualStatusForType.add(Integer.valueOf(Integer.parseInt(optJSONArray.get(i).toString())));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(TuningConstants.KEY_GET_ID_DETAIL);
        if (optJSONArray2 != null) {
            this.actualPriceForType.clear();
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                    this.actualPriceForType.add(Integer.valueOf(Integer.parseInt(optJSONArray2.get(i2).toString())));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public final void sendForServerCheckType(int i) {
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON == null) {
            return;
        }
        actionsWithJSON.sendCheckType(i);
    }

    public final void sendForServerCheckAnswer(int i) {
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON == null) {
            return;
        }
        actionsWithJSON.sendCheckAnswer(i);
    }

    public final void sendToServerClickButton(int i) {
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON != null) {
            actionsWithJSON.sendPressButton(i);
        }
        if (i == 5) {
            this.ifNotInformingAboutDismiss = true;
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow == null) {
                return;
            }
            popupWindow.dismiss();
        }
    }

    private final void startPopupWindowEndTest(int i, int i2) {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        DrivingSchoolEndTestBinding inflate = DrivingSchoolEndTestBinding.inflate((LayoutInflater) systemService);
        this.bindingEndTest = inflate;
        if (inflate != null) {
            PopupWindow popupWindow = new PopupWindow((View) inflate.getRoot(), -1, -1, true);
            this.popupWindowEndTest = popupWindow;
            if (popupWindow != null) {
                NvEventQueueActivity nvEventQueueActivity2 = this.context;
                popupWindow.showAtLocation(nvEventQueueActivity2 != null ? nvEventQueueActivity2.getParentLayout() : null, 17, 0, 0);
            }
            closeAndroidsInterface(this.popupWindowEndTest);
            LogicForDialogEndTest logicForDialogEndTest = new LogicForDialogEndTest(this, inflate, this.context);
            this.logicForDialogEndTest = logicForDialogEndTest;
            if (logicForDialogEndTest != null) {
                logicForDialogEndTest.setLogicAndView(i, i2, this.allQuestions);
            }
        }
        PopupWindow popupWindow2 = this.popupWindowEndTest;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUIDrivingSchool.m127startPopupWindowEndTest$lambda8(GUIDrivingSchool.this);
            }
        });
    }

    public static final void m127startPopupWindowEndTest$lambda8(GUIDrivingSchool this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
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

    private final void closePopupWindows() {
        PopupWindow popupWindow = this.popupWindowEndTest;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void setNullableParameters() {
        UIMainLayout uIMainLayout = this.maiLayout;
        if (uIMainLayout != null) {
            uIMainLayout.setNullableParameters();
        }
        UIClassInfoLayout uIClassInfoLayout = this.classInfoLayout;
        if (uIClassInfoLayout != null) {
            uIClassInfoLayout.setNullableParameters();
        }
        UIQuestions uIQuestions = this.questionsLayout;
        if (uIQuestions != null) {
            uIQuestions.setNullableParameters();
        }
        this.context = null;
        this.popupWindow = null;
        this.guiManager = null;
        this.container = null;
        this.anim = null;
        this.maiLayout = null;
        this.classInfoLayout = null;
        this.questionsLayout = null;
        this.actionsWithJSON = null;
        this.popupWindowEndTest = null;
        this.bindingEndTest = null;
        this.logicForDialogEndTest = null;
        this.actualStatusForType.clear();
        this.actualPriceForType.clear();
    }
}
