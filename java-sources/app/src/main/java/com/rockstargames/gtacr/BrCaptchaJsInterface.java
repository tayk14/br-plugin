package com.rockstargames.gtacr;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import blackrussia.online.Logger;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrCaptchaJsInterface {
    private Activity mContext;
    private BrCaptcha mGui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrCaptchaJsInterface(BrCaptcha gui, Activity mContext) {
        this.mGui = gui;
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void recaptchaPass(final String token) {
        Logger.i("Recaptcha pass " + token);
        try {
            this.mContext.runOnUiThread(new Runnable() { // from class: com.rockstargames.gtacr.BrCaptchaJsInterface.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("t", token);
                        BrCaptchaJsInterface.this.mGui.GetGuiManager().sendJsonData(20, jSONObject);
                        BrCaptchaJsInterface.this.mGui.GetGuiManager().closeGUI(null, 20);
                    } catch (Exception e) {
                        FirebaseCrashlytics.getInstance().recordException(e);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }
}
