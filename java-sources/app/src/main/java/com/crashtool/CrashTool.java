package com.crashtool;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import blackrussia.online.App;
import blackrussia.online.BuildConfig;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.time.DurationKt;

/* loaded from: classes.dex */
public class CrashTool {
    private static HashMap<String, String> mAppLocalValues = null;
    private static File mLogFile = null;
    private static FileOutputStream mLogFileOutputStream = null;
    private static String mLogcatString = null;
    private static String mPath = null;
    private static Process mProcessLogcat = null;
    private static boolean mSendReports = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void memoryMonitor(int allocatedVM, int vmMaxHeapSize, int nativeHeapAllocatedSize, int nativeHeapSize);

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private static boolean uploadZipReport(ByteArrayOutputStream byteArrayOutputStream) throws Exception {
        String hexString = Long.toHexString(System.currentTimeMillis());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://crashtool.blackrussia.online:6787/").openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        httpURLConnection.setReadTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + hexString);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            byteArrayOutputStream.writeTo(outputStream);
            outputStream.flush();
            if (outputStream != null) {
                outputStream.close();
            }
            return httpURLConnection.getResponseCode() == 200;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    if (th != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        outputStream.close();
                    }
                }
                throw th2;
            }
        }
    }

    private static ArrayList<Integer> getReportsId(File[] files) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                int i2 = -1;
                try {
                    i2 = Integer.valueOf(files[i].getName().split(Pattern.quote("."))[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!arrayList.contains(i2)) {
                    arrayList.add(i2);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<File> getFilesForReport(File[] allFiles, Integer reportId) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (int i = 0; i < allFiles.length; i++) {
            if (allFiles[i].getName().contains(String.valueOf(reportId))) {
                arrayList.add(allFiles[i]);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private static ByteArrayOutputStream getZipFromReports(ArrayList<File> reports) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            for (int i = 0; i < reports.size(); i++) {
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(reports.get(i).getName()));
                    FileInputStream fileInputStream = new FileInputStream(reports.get(i));
                    int min = Math.min(fileInputStream.available(), 2048);
                    byte[] bArr = new byte[min];
                    int read = fileInputStream.read(bArr, 0, min);
                    while (read > 0) {
                        zipOutputStream.write(bArr, 0, min);
                        min = Math.min(fileInputStream.available(), 2048);
                        read = fileInputStream.read(bArr, 0, min);
                    }
                    zipOutputStream.closeEntry();
                } finally {
                }
            }
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    public static void sendUnsentReports() {
        File[] listFiles = new File(mPath + "crashtool/").listFiles();
        if (listFiles == null) {
            return;
        }
        ArrayList<Integer> reportsId = getReportsId(listFiles);
        for (int i = 0; i < reportsId.size(); i++) {
            try {
                if (reportsId.get(i).intValue() != Integer.parseInt(getAppLocalValue("SESSION_ID"))) {
                    ArrayList<File> filesForReport = getFilesForReport(listFiles, reportsId.get(i));
                    if (uploadZipReport(getZipFromReports(filesForReport))) {
                        for (int i2 = 0; i2 < filesForReport.size(); i2++) {
                            filesForReport.get(i2).delete();
                        }
                    }
                }
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public static void launchMemoryMonitor() {
        new Thread(new Runnable() { // from class: com.crashtool.CrashTool.1
            @Override // java.lang.Runnable
            public void run() {
                long j;
                long j2;
                long j3 = 0;
                while (true) {
                    long j4 = 0;
                    try {
                        j = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                        try {
                            j2 = Runtime.getRuntime().maxMemory();
                            try {
                                j3 = Debug.getNativeHeapAllocatedSize();
                                try {
                                    j4 = Debug.getNativeHeapSize();
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                j3 = 0;
                            }
                        } catch (Exception unused3) {
                            j2 = 0;
                            j3 = j2;
                            CrashTool.memoryMonitor((int) ((j / 1024) / 1024), (int) ((j2 / 1024) / 1024), (int) ((j3 / 1024) / 1024), (int) ((j4 / 1024) / 1024));
                            Thread.sleep(100L);
                        }
                    } catch (Exception unused4) {
                        j = 0;
                        j2 = 0;
                    }
                    CrashTool.memoryMonitor((int) ((j / 1024) / 1024), (int) ((j2 / 1024) / 1024), (int) ((j3 / 1024) / 1024), (int) ((j4 / 1024) / 1024));
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void init(Context context) {
        mAppLocalValues = new HashMap<>();
        setAppLocalValue("MANUFACTURER", Build.MANUFACTURER);
        setAppLocalValue("MODEL", Build.MODEL);
        setAppLocalValue("DEVICE", Build.PRODUCT);
        setAppLocalValue("OS", Build.VERSION.RELEASE);
        setAppLocalValue("SESSION_ID", String.valueOf(App.getInstance().rnd(DurationKt.NANOS_IN_MILLIS)));
        setAppLocalValue("VERSION_NAME", BuildConfig.VERSION_NAME);
        setAppLocalValue("VERSION_CODE", Integer.toString(BuildConfig.VERSION_CODE));
        try {
            mPath = context.getExternalFilesDir(null).getAbsolutePath() + "/";
            new File(mPath + "crashtool/").mkdirs();
        } catch (Exception unused) {
        }
        setAppLocalValue("PATH", mPath);
        if (mPath == null) {
            return;
        }
        File file = new File(mPath + "crashtool/" + getAppLocalValue("SESSION_ID") + ".userlog");
        mLogFile = file;
        if (!file.exists()) {
            try {
                mLogFile.createNewFile();
            } catch (Exception unused2) {
            }
        }
        try {
            mLogFileOutputStream = new FileOutputStream(mLogFile);
        } catch (Exception unused3) {
        }
        new Thread(new Runnable() { // from class: com.crashtool.CrashTool.2
            @Override // java.lang.Runnable
            public void run() {
                CrashTool.sendUnsentReports();
                boolean unused4 = CrashTool.mSendReports = true;
            }
        }).start();
        new Thread(new Runnable() { // from class: com.crashtool.CrashTool.3
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception unused4) {
                    }
                }
            }
        }).start();
    }

    public static boolean wasReportsSend() {
        return mSendReports;
    }

    public static String getAppLocalValue(String key) {
        return mAppLocalValues.get(key);
    }

    public static void setAppLocalValue(String key, String value) {
        mAppLocalValues.put(key, value);
    }

    public static byte[] getAppLocalValueNative(byte[] key) {
        try {
            return getAppLocalValue(new String(key, "windows-1251")).getBytes("windows-1251");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String readAllOf(InputStream is) throws IOException {
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

    public static void log(String str) {
        try {
            mLogFileOutputStream.write((str + "\n").getBytes("windows-1251"));
            mLogFileOutputStream.flush();
        } catch (Exception unused) {
        }
    }
}
