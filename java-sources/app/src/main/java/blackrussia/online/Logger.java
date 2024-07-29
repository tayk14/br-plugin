package blackrussia.online;

import android.util.Log;
import com.crashtool.CrashTool;
import java.io.File;

/* loaded from: classes.dex */
public class Logger {
    private static final String FILENAME = "log.txt";
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 2;
    public static final int LOG_LEVEL_INFO = 0;
    public static final int LOG_LEVEL_WARNING = 1;
    static boolean mInited = false;
    private static String mPath;

    private static void logToFile(String str) {
    }

    public static void init(String path) {
        if (mInited) {
            return;
        }
        mPath = path;
        try {
            new File(path + FILENAME).delete();
        } catch (Exception unused) {
        }
        mInited = true;
    }

    public static void NativeLog(int level, byte[] str) {
        try {
            Log(level, new String(str, "windows-1251"));
        } catch (Exception unused) {
        }
    }

    public static void Log(int level, String str) {
        if (level == 0) {
            i(str);
            return;
        }
        if (level == 1) {
            w(str);
        } else if (level == 2) {
            e(str);
        } else {
            if (level != 3) {
                return;
            }
            d(str);
        }
    }

    public static void d(String string) {
        Log.d("SAMP-DEBUG", string);
        String str = "[Debug] " + string;
        CrashTool.log(str);
        logToFile(str);
    }

    public static void i(String string) {
        Log.i("SAMP-INFO", string);
        String str = "[Info] " + string;
        CrashTool.log(str);
        logToFile(str);
    }

    public static void w(String string) {
        Log.w("SAMP-WARN", string);
        String str = "[Warning] " + string;
        CrashTool.log(str);
        logToFile(str);
    }

    public static void e(String string) {
        Log.e("SAMP-ERROR", string);
        String str = "[Error] " + string;
        CrashTool.log(str);
        logToFile(str);
    }
}
