package com.rockstargames.gtacr;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupWindow;
import blackrussia.online.Logger;
import blackrussia.online.R;
import blackrussia.online.activities.AuthorizationActivity;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrCaptcha implements ISAMPGUI {
    private static boolean mIsShowing = false;
    private Activity mContext = null;
    private GUIManager mGUIManager = null;
    private PopupWindow mWindow = null;
    private View mViewRoot = null;
    private WebView mWebView = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 20;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrCaptcha();
    }

    public GUIManager GetGuiManager() {
        return this.mGUIManager;
    }

    public void rouletteShow(Activity activity) {
        this.mContext = activity;
        show(null, null, null);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        View parentLayout;
        if (mIsShowing) {
            return;
        }
        mIsShowing = true;
        if (activity != null) {
            this.mContext = activity;
        }
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            this.mViewRoot = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.br_captcha, (ViewGroup) null, false);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mViewRoot, -2, -2, true);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrCaptcha.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        return motionEvent.getX() < 0.0f || motionEvent.getX() > ((float) view.getWidth()) || motionEvent.getY() < 0.0f || motionEvent.getY() > ((float) view.getHeight());
                    }
                    return false;
                }
            });
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrCaptcha.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    Logger.w("Dismissed captcha");
                }
            });
        }
        WebView webView = (WebView) this.mViewRoot.findViewById(R.id.captcha_webview);
        this.mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        Activity activity2 = this.mContext;
        if (activity2 instanceof AuthorizationActivity) {
            parentLayout = ((AuthorizationActivity) activity2).getParentLayout();
        } else {
            parentLayout = ((NvEventQueueActivity) activity2).getParentLayout();
        }
        this.mWindow.showAtLocation(parentLayout, 17, 0, 0);
        Activity activity3 = this.mContext;
        if (activity3 instanceof AuthorizationActivity) {
            this.mWebView.addJavascriptInterface(new BrCaptchaRouletteJsInterface((AuthorizationActivity) activity3, this), "android");
        } else {
            this.mWebView.addJavascriptInterface(new BrCaptchaJsInterface(this, activity3), "android");
        }
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.rockstargames.gtacr.BrCaptcha.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.getSettings().setUseWideViewPort(false);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.loadUrl("https://api.blackrussia.online/captcha.html");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        mIsShowing = false;
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        return mIsShowing;
    }
}
