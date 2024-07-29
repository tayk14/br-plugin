package com.rockstargames.gtacr.gui.entertainmentSystem;

import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemFinalWindowBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.gui.Useful;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010H\u0002J$\u0010!\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystemFinalWindow;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemFinalWindowBinding;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "inflater", "Landroid/view/LayoutInflater;", "popupWindow", "Landroid/widget/PopupWindow;", "textIfLost", "Landroid/text/SpannableString;", "textIfWin", "close", "", "json", "Lorg/json/JSONObject;", "getGuiId", "", "initialisationPopupWindow", "activity", "isShowingGui", "", "onPacketIncoming", "sendPressButton", "typeKey", "setTextStyle", "thisText", "show", "manager", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIEntertainmentSystemFinalWindow implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private Animation anim;
    private EntertainmentSystemFinalWindowBinding binding;
    private NvEventQueueActivity context;
    private GUIManager guiManager;
    private LayoutInflater inflater;
    private PopupWindow popupWindow;
    private final SpannableString textIfWin = new SpannableString("Вы победили");
    private final SpannableString textIfLost = new SpannableString("Вы проиграли");

    @JvmStatic
    public static final GUIEntertainmentSystemFinalWindow newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 43;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystemFinalWindow$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystemFinalWindow;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIEntertainmentSystemFinalWindow newInstance() {
            return new GUIEntertainmentSystemFinalWindow();
        }
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        if (this.popupWindow == null) {
            initialisationPopupWindow(activity);
        }
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("st");
            if (optInt == 0) {
                setTextStyle(this.textIfLost);
            } else if (optInt == 1) {
                setTextStyle(this.textIfWin);
            }
        }
        EntertainmentSystemFinalWindowBinding entertainmentSystemFinalWindowBinding = this.binding;
        if (entertainmentSystemFinalWindowBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemFinalWindowBinding = null;
        }
        entertainmentSystemFinalWindowBinding.closeFinalWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIEntertainmentSystemFinalWindow.m155show$lambda2(GUIEntertainmentSystemFinalWindow.this, view);
            }
        });
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUIEntertainmentSystemFinalWindow.m157show$lambda3(GUIEntertainmentSystemFinalWindow.this);
            }
        });
    }

    public static final void m155show$lambda2(GUIEntertainmentSystemFinalWindow this$0, View view) {
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
                //GUIEntertainmentSystemFinalWindow.m156show$lambda2$lambda1(GUIEntertainmentSystemFinalWindow.this);
            }
        }, 250L);
    }

    public static final void m156show$lambda2$lambda1(GUIEntertainmentSystemFinalWindow this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m157show$lambda3(GUIEntertainmentSystemFinalWindow this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        //nvEventQueueActivity.toggleDrawing2dStuff(false);
        this$0.sendPressButton(3);
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager == null) {
            return;
        }
        gUIManager.closeGUI(null, 43);
    }

    private final void initialisationPopupWindow(NvEventQueueActivity nvEventQueueActivity) {
        Object systemService = nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        this.inflater = layoutInflater;
        NvEventQueueActivity nvEventQueueActivity2 = null;
        if (layoutInflater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflater");
            layoutInflater = null;
        }
        EntertainmentSystemFinalWindowBinding inflate = EntertainmentSystemFinalWindowBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        EntertainmentSystemFinalWindowBinding entertainmentSystemFinalWindowBinding = this.binding;
        if (entertainmentSystemFinalWindowBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemFinalWindowBinding = null;
        }
        this.popupWindow = new PopupWindow((View) entertainmentSystemFinalWindowBinding.getRoot(), -1, -1, true);
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        if (nvEventQueueActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            nvEventQueueActivity2 = nvEventQueueActivity3;
        }
        nvEventQueueActivity2.toggleDrawing2dStuff(true);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            GUIManager.hideSystemUI(popupWindow.getContentView());
        }
        new Useful().closeAndroidsInterface(nvEventQueueActivity, this.popupWindow);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.showAtLocation(nvEventQueueActivity.getParentLayout(), 17, 0, 0);
    }

    private final void setTextStyle(SpannableString spannableString) {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        EntertainmentSystemFinalWindowBinding entertainmentSystemFinalWindowBinding = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity, R.color.red_bg_queue_smi_dialog)), 3, spannableString.length(), 33);
        EntertainmentSystemFinalWindowBinding entertainmentSystemFinalWindowBinding2 = this.binding;
        if (entertainmentSystemFinalWindowBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemFinalWindowBinding = entertainmentSystemFinalWindowBinding2;
        }
        entertainmentSystemFinalWindowBinding.gamesStatus.setText(spannableString);
    }

    private final void sendPressButton(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(43, jSONObject);
        } catch (Exception unused) {
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
}
