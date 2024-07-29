package com.rockstargames.gtacr;

import android.webkit.JavascriptInterface;
import blackrussia.online.activities.AuthorizationActivity;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: classes2.dex */
public class BrCaptchaRouletteJsInterface {
    private BrCaptcha gui;
    private AuthorizationActivity mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrCaptchaRouletteJsInterface(AuthorizationActivity activity, BrCaptcha gui) {
        this.mActivity = activity;
        this.gui = gui;
    }

    @JavascriptInterface
    public void recaptchaPass(final String token) {
        try {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.rockstargames.gtacr.BrCaptchaRouletteJsInterface.1
                @Override // java.lang.Runnable
                public void run() {
                    BrCaptchaRouletteJsInterface.this.mActivity.responseToken = token;
                    BrCaptchaRouletteJsInterface.this.gui.close(null);
                    BrCaptchaRouletteJsInterface.this.mActivity.checkBox.setChecked(true);
                }
            });
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
