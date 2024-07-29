package com.nvidia.devtech;

import android.app.Activity;
import android.os.Handler;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class CrashHandler {
    private Process mProcess = null;
    private String mLog = null;
    private Handler mHandler = null;
    private Activity mActivity = null;

    private String readAllOf(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder(Math.max(16, is.available()));
        char[] cArr = new char[4096];
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(is, Key.STRING_CHARSET_NAME);
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read > 0) {
                    sb.append(cArr, 0, read);
                } else {
                    is.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            is.close();
            throw th;
        }
    }

    private void doInBackground() {
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-v", "threadtime"});
            this.mProcess = exec;
            this.mLog = readAllOf(exec.getInputStream());
        } catch (Exception unused) {
        }
    }

    CrashHandler(Activity activity) {
    }
}
