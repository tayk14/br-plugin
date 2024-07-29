package com.rockstargames.gtacr.gui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.R;
import blackrussia.online.Utils;
import blackrussia.online.databinding.BlackPassBannerBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\"\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/rockstargames/gtacr/gui/GUIBlackPassBanner;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "binding", "Lblackrussia/online/databinding/BlackPassBannerBinding;", "mWindow", "Lcom/rockstargames/gtacr/common/GUIPopupWindow;", "close", "", "json", "Lorg/json/JSONObject;", "getGuiId", "", "initView", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "isShowingGui", "", "onPacketIncoming", "setNullableParameters", "show", "manager", "Lcom/rockstargames/gtacr/GUIManager;", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIBlackPassBanner implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private BlackPassBannerBinding binding;
    private GUIPopupWindow mWindow;

    @JvmStatic
    public static final GUIBlackPassBanner newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 35;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/GUIBlackPassBanner$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/GUIBlackPassBanner;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIBlackPassBanner newInstance() {
            return new GUIBlackPassBanner();
        }
    }

    @Override
    public void show(JSONObject jSONObject, final GUIManager manager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.binding == null) {
            Object systemService = activity.getSystemService("layout_inflater");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            this.binding = BlackPassBannerBinding.inflate((LayoutInflater) systemService);
        }
        BlackPassBannerBinding blackPassBannerBinding = this.binding;
        if (blackPassBannerBinding == null) {
            return;
        }
        initView(activity);
        BlackPassBannerBinding blackPassBannerBinding2 = this.binding;
        Intrinsics.checkNotNull(blackPassBannerBinding2);
        GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(blackPassBannerBinding2.getRoot(), -1, -1, true);
        this.mWindow = gUIPopupWindow;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    //GUIBlackPassBanner.m105show$lambda3$lambda0(GUIManager.this, this);
                }
            });
        }
        GUIPopupWindow gUIPopupWindow2 = this.mWindow;
        if (gUIPopupWindow2 != null) {
            gUIPopupWindow2.setAnimationStyle(R.style.PopupWindowAnimation);
        }
        GUIManager.hideSystemUI(blackPassBannerBinding.getRoot());
        blackPassBannerBinding.nyBannerClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIBlackPassBanner.m106show$lambda3$lambda1(GUIBlackPassBanner.this, view);
            }
        });
        blackPassBannerBinding.nyBannerButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                //GUIBlackPassBanner.m107show$lambda3$lambda2(GUIManager.this, this, view);
            }
        });
        GUIPopupWindow gUIPopupWindow3 = this.mWindow;
        if (gUIPopupWindow3 == null) {
            return;
        }
        gUIPopupWindow3.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    public static final void m105show$lambda3$lambda0(GUIManager manager, GUIBlackPassBanner this$0) {
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        manager.notifyGUIClosed(this$0.getGuiId(), null);
        this$0.setNullableParameters();
    }

    public static final void m106show$lambda3$lambda1(GUIBlackPassBanner this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GUIPopupWindow gUIPopupWindow = this$0.mWindow;
        if (gUIPopupWindow == null) {
            return;
        }
        gUIPopupWindow.dismiss();
    }

    public static final void m107show$lambda3$lambda2(GUIManager manager, GUIBlackPassBanner this$0, View view) {
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            manager.sendJsonData(35, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GUIPopupWindow gUIPopupWindow = this$0.mWindow;
        if (gUIPopupWindow == null) {
            return;
        }
        gUIPopupWindow.dismiss();
    }

    private final void initView(NvEventQueueActivity nvEventQueueActivity) {
        NvEventQueueActivity nvEventQueueActivity2 = nvEventQueueActivity;
        BlackPassBannerBinding blackPassBannerBinding = this.binding;
        Utils.setBackground(nvEventQueueActivity2, R.drawable.black_pass_banner_summer_bg_res, blackPassBannerBinding == null ? null : blackPassBannerBinding.getRoot());
        BlackPassBannerBinding blackPassBannerBinding2 = this.binding;
        Utils.setBackground(nvEventQueueActivity2, R.drawable.black_pass_banner_summer_title_img, blackPassBannerBinding2 == null ? null : blackPassBannerBinding2.bannerMainTitle);
        BlackPassBannerBinding blackPassBannerBinding3 = this.binding;
        TextView textView = blackPassBannerBinding3 == null ? null : blackPassBannerBinding3.nyText1;
        if (textView != null) {
            Useful useful = new Useful();
            String string = nvEventQueueActivity.getString(R.string.banner_body_text_1);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.banner_body_text_1)");
            textView.setText(useful.getTextWithHtmlStyles(string));
        }
        BlackPassBannerBinding blackPassBannerBinding4 = this.binding;
        TextView textView2 = blackPassBannerBinding4 != null ? blackPassBannerBinding4.nyText2 : null;
        if (textView2 == null) {
            return;
        }
        Useful useful2 = new Useful();
        String string2 = nvEventQueueActivity.getString(R.string.banner_body_text_2);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.banner_body_text_2)");
        textView2.setText(useful2.getTextWithHtmlStyles(string2));
    }

    @Override
    public void close(JSONObject jSONObject) {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow == null || gUIPopupWindow == null) {
            return;
        }
        gUIPopupWindow.dismiss();
    }

    @Override
    public boolean isShowingGui() {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            Intrinsics.checkNotNull(gUIPopupWindow);
            return gUIPopupWindow.isShowing();
        }
        return false;
    }

    private final void setNullableParameters() {
        this.mWindow = null;
        this.binding = null;
    }
}
