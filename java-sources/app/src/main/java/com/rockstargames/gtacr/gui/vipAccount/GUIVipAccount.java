package com.rockstargames.gtacr.gui.vipAccount;

import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import blackrussia.online.R;
import blackrussia.online.databinding.VipAccountDialogBinding;
import com.google.android.gms.common.ConnectionResult;
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

//@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J$\u0010\u001e\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/rockstargames/gtacr/gui/vipAccount/GUIVipAccount;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/VipAccountDialogBinding;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "inflater", "Landroid/view/LayoutInflater;", "popupWindow", "Landroid/widget/PopupWindow;", "thisEarnings", "", "wouldEarning", "close", "", "json", "Lorg/json/JSONObject;", "getEarnings", "getGuiId", "isShowingGui", "", "onPacketIncoming", "setParameters", "wouldEarnings", "setStyleForText", "show", "manager", "activity", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIVipAccount implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private Animation anim;
    private VipAccountDialogBinding binding;
    private NvEventQueueActivity context;
    private GUIManager guiManager;
    private LayoutInflater inflater;
    private PopupWindow popupWindow;
    private int thisEarnings = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    private int wouldEarning = PathInterpolatorCompat.MAX_NUM_POINTS;

    @JvmStatic
    public static final GUIVipAccount newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 41;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/vipAccount/GUIVipAccount$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/vipAccount/GUIVipAccount;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIVipAccount newInstance() {
            return new GUIVipAccount();
        }
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        if (this.popupWindow == null) {
            Object systemService = activity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            this.inflater = layoutInflater;
            VipAccountDialogBinding vipAccountDialogBinding = null;
            if (layoutInflater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflater");
                layoutInflater = null;
            }
            VipAccountDialogBinding inflate = VipAccountDialogBinding.inflate(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            this.anim = loadAnimation;
            VipAccountDialogBinding vipAccountDialogBinding2 = this.binding;
            if (vipAccountDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vipAccountDialogBinding2 = null;
            }
            this.popupWindow = new PopupWindow((View) vipAccountDialogBinding2.getRoot(), -1, -1, true);
            NvEventQueueActivity nvEventQueueActivity = this.context;
            if (nvEventQueueActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                nvEventQueueActivity = null;
            }
            //nvEventQueueActivity.toggleDrawing2dStuff(true);
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                popupWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
            }
            Useful useful = new Useful();
            NvEventQueueActivity nvEventQueueActivity2 = this.context;
            if (nvEventQueueActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                nvEventQueueActivity2 = null;
            }
            useful.closeAndroidsInterface(nvEventQueueActivity2, this.popupWindow);
            VipAccountDialogBinding vipAccountDialogBinding3 = this.binding;
            if (vipAccountDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vipAccountDialogBinding3 = null;
            }
            vipAccountDialogBinding3.buttonByuVip.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIVipAccount.m420show$lambda1(GUIVipAccount.this, view);
                }
            });
            VipAccountDialogBinding vipAccountDialogBinding4 = this.binding;
            if (vipAccountDialogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vipAccountDialogBinding = vipAccountDialogBinding4;
            }
            vipAccountDialogBinding.closeVipAccountDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIVipAccount.m422show$lambda3(GUIVipAccount.this, view);
                }
            });
        }
        setStyleForText();
        setParameters(this.thisEarnings, this.wouldEarning);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUIVipAccount.m424show$lambda4(GUIVipAccount.this);
            }
        });
    }

    public static final void m420show$lambda1(GUIVipAccount this$0, View view) {
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
                //GUIVipAccount.m421show$lambda1$lambda0(GUIVipAccount.this);
            }
        }, 250L);
    }

    public static final void m421show$lambda1$lambda0(GUIVipAccount this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m422show$lambda3(GUIVipAccount this$0, View view) {
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
                //GUIVipAccount.m423show$lambda3$lambda2(GUIVipAccount.this);
            }
        }, 250L);
    }

    public static final void m423show$lambda3$lambda2(GUIVipAccount this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m424show$lambda4(GUIVipAccount this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        //nvEventQueueActivity.toggleDrawing2dStuff(false);
    }

    private final void getEarnings(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.thisEarnings = jSONObject.optInt("te");
        this.wouldEarning = jSONObject.optInt("we");
    }

    private final void setParameters(int i, int i2) {
        String priceWithSpacesForInt = new Useful().getPriceWithSpacesForInt(i);
        String priceWithSpacesForInt2 = new Useful().getPriceWithSpacesForInt(i2);
        VipAccountDialogBinding vipAccountDialogBinding = this.binding;
        if (vipAccountDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vipAccountDialogBinding = null;
        }
        if (priceWithSpacesForInt != null) {
            vipAccountDialogBinding.moneyValue.setText(priceWithSpacesForInt);
        }
        if (priceWithSpacesForInt2 == null) {
            return;
        }
        vipAccountDialogBinding.moneyValueWould.setText(priceWithSpacesForInt2);
    }

    private final void setStyleForText() {
        SpannableString spannableString = new SpannableString("А могли заработать больше!");
        NvEventQueueActivity nvEventQueueActivity = this.context;
        VipAccountDialogBinding vipAccountDialogBinding = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(nvEventQueueActivity, R.color.diving_school_green_text_color)), 19, 25, 33);
        VipAccountDialogBinding vipAccountDialogBinding2 = this.binding;
        if (vipAccountDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vipAccountDialogBinding = vipAccountDialogBinding2;
        }
        vipAccountDialogBinding.wouldEarnTitle.setText(spannableString);
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
