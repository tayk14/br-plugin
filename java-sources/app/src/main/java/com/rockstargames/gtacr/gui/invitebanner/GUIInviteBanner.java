package com.rockstargames.gtacr.gui.invitebanner;

import android.animation.ObjectAnimator;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import blackrussia.online.Utils;
import blackrussia.online.databinding.InviteBannerLayoutBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\u001dH\u0002J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J\u0012\u0010-\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J&\u00101\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u00102\u001a\u0004\u0018\u0001032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/rockstargames/gtacr/gui/invitebanner/GUIInviteBanner;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "_binding", "Lblackrussia/online/databinding/InviteBannerLayoutBinding;", "actionWithJson", "Lcom/rockstargames/gtacr/gui/invitebanner/InviteBannerActionsWithJSON;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "anim", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "getAnim", "()Landroid/view/animation/Animation;", "anim$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lblackrussia/online/databinding/InviteBannerLayoutBinding;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "popupWindow", "Landroid/widget/PopupWindow;", "spamBlock", "", "animateButtonCloseAppearing", "", "animateLeftArrow", "animateRightArrow", "animateTextViewPLayNow", "calculateDate", "json", "Lorg/json/JSONObject;", "close", "downloadLauncher", "formatBonusesEndsText", "days", "", "plurals", "formatHeader", "getGuiId", "isShowingGui", "onPacketIncoming", "openSite", "setOnCloseClickListener", "setOnDownloadClickListener", "show", "manager", "Lcom/rockstargames/gtacr/GUIManager;", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIInviteBanner implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private InviteBannerLayoutBinding _binding;
    private InviteBannerActionsWithJSON actionWithJson;
    private NvEventQueueActivity activity;
    private final Lazy anim$delegate = LazyKt.lazy(new Function0<Animation>() {

        @Override
        public final Animation invoke() {
            InviteBannerLayoutBinding binding;
            binding = GUIInviteBanner.this.getBinding();
            return AnimationUtils.loadAnimation(binding.getRoot().getContext(), R.anim.button_click);
        }
    });
    private final Lazy handler$delegate = LazyKt.lazy(new Function0<Handler>() {
        @Override
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private PopupWindow popupWindow;
    private boolean spamBlock;

    @JvmStatic
    public static final GUIInviteBanner newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 55;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
    }

    public final InviteBannerLayoutBinding getBinding() {
        InviteBannerLayoutBinding inviteBannerLayoutBinding = this._binding;
        Intrinsics.checkNotNull(inviteBannerLayoutBinding);
        return inviteBannerLayoutBinding;
    }

    private final Animation getAnim() {
        return (Animation) this.anim$delegate.getValue();
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity nvEventQueueActivity) {
        this.activity = nvEventQueueActivity;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this._binding = InviteBannerLayoutBinding.inflate((LayoutInflater) systemService);
        this.actionWithJson = new InviteBannerActionsWithJSON(gUIManager);
        this.popupWindow = new PopupWindow((View) getBinding().getRoot(), -1, -1, false);
        if (jSONObject != null) {
            calculateDate(jSONObject);
        }
        formatHeader();
        animateLeftArrow();
        animateRightArrow();
        animateTextViewPLayNow();
        setOnCloseClickListener();
        setOnDownloadClickListener();
        Utils.setBackground(nvEventQueueActivity, R.drawable.invite_banner_bg_image, getBinding().getRoot());
        PopupWindow popupWindow = this.popupWindow;
        GUIManager.hideSystemUI(popupWindow == null ? null : popupWindow.getContentView());
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            NvEventQueueActivity nvEventQueueActivity2 = this.activity;
            popupWindow2.showAtLocation(nvEventQueueActivity2 != null ? nvEventQueueActivity2.getParentLayout() : null, 17, 0, 0);
        }
        animateButtonCloseAppearing();
    }

    private final void animateButtonCloseAppearing() {
        getHandler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUIInviteBanner.m348animateButtonCloseAppearing$lambda2(GUIInviteBanner.this);
            }
        }, 5000L);
    }

    public static final void m348animateButtonCloseAppearing$lambda2(GUIInviteBanner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().imageButtonClose.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.getBinding().imageButtonClose, View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    private final void animateLeftArrow() {
        getBinding().imageViewStartPlayLeftArrows.post(new Runnable() {
            @Override
            public final void run() {
                GUIInviteBanner.m349animateLeftArrow$lambda4(GUIInviteBanner.this);
            }
        });
    }

    public static final void m349animateLeftArrow$lambda4(GUIInviteBanner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float left = this$0.getBinding().imageViewStartPlayLeftArrows.getLeft();
        float right = this$0.getBinding().imageViewStartPlayLeftArrows.getRight() - 20.0f;
        Log.d("ANIMAT_CHECK_TAG", Intrinsics.stringPlus("leftArrowStart ", Float.valueOf(left)));
        Log.d("ANIMAT_CHECK_TAG", Intrinsics.stringPlus("leftArrowEnd ", Float.valueOf(right)));
        Log.d("ANIMAT_CHECK_TAG", "diff " + (right - left) + '\n');
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.getBinding().imageViewStartPlayLeftArrows, View.X, left, right);
        ofFloat.setDuration(750L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
    }

    private final void setOnDownloadClickListener() {
        getBinding().buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIInviteBanner.m356setOnDownloadClickListener$lambda6(GUIInviteBanner.this, view);
            }
        });
    }

    public static final void m356setOnDownloadClickListener$lambda6(GUIInviteBanner this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.getAnim());
        if (!this$0.spamBlock) {
            this$0.getHandler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                }
            }, 200L);
        }
        this$0.spamBlock = true;
    }

    public static final void m357setOnDownloadClickListener$lambda6$lambda5(GUIInviteBanner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.spamBlock = false;
        InviteBannerActionsWithJSON inviteBannerActionsWithJSON = this$0.actionWithJson;
        if (inviteBannerActionsWithJSON != null) {
            inviteBannerActionsWithJSON.sendButtonPressed(2);
        }
        this$0.openSite();
        this$0.downloadLauncher();
    }

    private final void openSite() {
        Uri parse = Uri.parse("https://blackrussia.online/play.php");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        if (nvEventQueueActivity == null) {
            return;
        }
        nvEventQueueActivity.startActivity(intent);
    }

    private final void downloadLauncher() {
        Uri parse = Uri.parse("https://dl.blackcdn.me/launcher.apk");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"https://dl.blackcdn.me/launcher.apk\")");
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        DownloadManager downloadManager = nvEventQueueActivity == null ? null : (DownloadManager) ContextCompat.getSystemService(nvEventQueueActivity, DownloadManager.class);
        DownloadManager.Request destinationInExternalPublicDir = new DownloadManager.Request(parse).setMimeType("apk").setNotificationVisibility(1).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "black_russia_launcher.apk");
        if (downloadManager == null) {
            return;
        }
        downloadManager.enqueue(destinationInExternalPublicDir);
    }

    private final void setOnCloseClickListener() {
        getBinding().imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIInviteBanner.m354setOnCloseClickListener$lambda9(GUIInviteBanner.this, view);
            }
        });
    }

    public static final void m354setOnCloseClickListener$lambda9(GUIInviteBanner this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.getAnim());
        if (this$0.spamBlock) {
            return;
        }
        this$0.getHandler().postDelayed(new Runnable() {
            @Override
            public final void run() {
            }
        }, 200L);
        this$0.spamBlock = true;
    }

    public static final void m355setOnCloseClickListener$lambda9$lambda8(GUIInviteBanner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.spamBlock = false;
        InviteBannerActionsWithJSON inviteBannerActionsWithJSON = this$0.actionWithJson;
        if (inviteBannerActionsWithJSON != null) {
            inviteBannerActionsWithJSON.sendButtonPressed(1);
        }
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void animateTextViewPLayNow() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getBinding().textViewStartPlay, View.ALPHA, 0.2f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
    }

    private final void animateRightArrow() {
        getBinding().imageViewStartPlayRightArrows.post(new Runnable() {
            @Override
            public final void run() {
                GUIInviteBanner.m350animateRightArrow$lambda12(GUIInviteBanner.this);
            }
        });
    }

    public static final void m350animateRightArrow$lambda12(GUIInviteBanner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float left = this$0.getBinding().imageViewStartPlayRightArrows.getLeft() - 20.0f;
        float right = this$0.getBinding().imageViewStartPlayRightArrows.getRight() - 40.0f;
        Log.d("ANIMAT_CHECK_TAG", Intrinsics.stringPlus("rightArrowStart ", Float.valueOf(left)));
        Log.d("ANIMAT_CHECK_TAG", Intrinsics.stringPlus("rightArrowEnd ", Float.valueOf(right)));
        Log.d("ANIMAT_CHECK_TAG", "diff " + (right - left) + '\n');
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.getBinding().imageViewStartPlayRightArrows, View.X, right, left);
        ofFloat.setDuration(750L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
    }

    private final void calculateDate(JSONObject jSONObject) {
        long optInt = jSONObject.optInt("time") * 1000;
        if (optInt > 0) {
            Date date = new Date(optInt);
            long currentTimeMillis = System.currentTimeMillis();
            Date date2 = new Date(currentTimeMillis);
            long j = optInt - currentTimeMillis;
            int convert = (int) TimeUnit.DAYS.convert(j, TimeUnit.MILLISECONDS);
            if (convert < 1) {
                convert = (int) TimeUnit.HOURS.convert(j, TimeUnit.MILLISECONDS);
                if (convert < 1) {
                    convert = (int) TimeUnit.MINUTES.convert(j, TimeUnit.MILLISECONDS);
                } else {
                    formatBonusesEndsText(convert, R.plurals.invite_banner_bonus_ends_hours);
                }
            } else {
                formatBonusesEndsText(convert, R.plurals.invite_banner_bonus_ends);
            }
            Log.d("DATE_CHECK_TAG", "date=" + date + "\nnow=" + date2 + "\ntimeLeft=" + j + "\ndateLeft=" + convert);
        }
    }

    private final void formatHeader() {
        Resources resources;
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        CharSequence charSequence = null;
        if (nvEventQueueActivity != null && (resources = nvEventQueueActivity.getResources()) != null) {
            charSequence = resources.getText(R.string.invite_banner_header);
        }
        Objects.requireNonNull(charSequence, "null cannot be cast to non-null type android.text.SpannedString");
        SpannedString spannedString = (SpannedString) charSequence;
        int i = 0;
        Annotation[] annotations = (Annotation[]) spannedString.getSpans(0, spannedString.length(), Annotation.class);
        SpannableString spannableString = new SpannableString(spannedString);
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        int length = annotations.length;
        while (i < length) {
            Annotation annotation = annotations[i];
            i++;
            if (Intrinsics.areEqual(annotation.getKey(), "font") && Intrinsics.areEqual(annotation.getValue(), "montserrat_bold")) {
                spannableString.setSpan(new CustomTypefaceSpan(ResourcesCompat.getFont(getBinding().getRoot().getContext(), R.font.montserrat_bold)), spannedString.getSpanStart(annotation), spannedString.getSpanEnd(annotation), 33);
            }
        }
        getBinding().textViewHeader.setText(spannableString);
    }

    private final void formatBonusesEndsText(int i, int i2) {
        Resources resources;
        String quantityString;
        SpannedString spannedString;
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        SpannableString spannableString = null;
        if (nvEventQueueActivity == null || (resources = nvEventQueueActivity.getResources()) == null || (quantityString = resources.getQuantityString(i2, i, Integer.valueOf(i))) == null) {
            spannedString = null;
        } else {
            SpannedString valueOf = SpannedString.valueOf(quantityString);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
            spannedString = valueOf;
        }
        if (spannedString != null) {
            SpannableString valueOf2 = SpannableString.valueOf(spannedString);
            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(this)");
            spannableString = valueOf2;
        }
        Typeface font = ResourcesCompat.getFont(getBinding().getRoot().getContext(), R.font.montserrat_bold);
        if (spannableString != null) {
            spannableString.setSpan(new CustomTypefaceSpan(font), 18, spannedString.length(), 33);
        }
        int color = ContextCompat.getColor(getBinding().getRoot().getContext(), R.color.color_FFE253);
        if (spannableString != null) {
            spannableString.setSpan(new ForegroundColorSpan(color), 18, spannedString.length(), 33);
        }
        getBinding().textViewBonusEnds.setText(spannableString);
    }

    @Override
    public void close(JSONObject jSONObject) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow != null) {
            popupWindow.dismiss();
        }
        this.popupWindow = null;
        this.activity = null;
        this._binding = null;
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            Intrinsics.checkNotNull(popupWindow);
            return popupWindow.isShowing();
        }
        return false;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/invitebanner/GUIInviteBanner$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/invitebanner/GUIInviteBanner;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIInviteBanner newInstance() {
            return new GUIInviteBanner();
        }
    }
}
