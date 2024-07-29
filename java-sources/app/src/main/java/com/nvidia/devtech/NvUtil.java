package com.nvidia.devtech;

import android.app.Activity;
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public class NvUtil {
    private static NvUtil instance = new NvUtil();
    private Activity activity = null;
    private HashMap<String, String> appLocalValues;

    public void deleteLogFile() {
        File file = new File(getAppLocalValue("STORAGE_ROOT") + "/SAMP/java_log.txt");
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void appendLog(String text) {
        File file = new File(Objects.requireNonNull(instance.activity.getExternalFilesDir(null)).getAbsolutePath() + "/SAMP/java_log.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.append((CharSequence) text);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private NvUtil() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.appLocalValues = hashMap;
        hashMap.put("STORAGE_ROOT", Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public static NvUtil getInstance() {
        return instance;
    }

    public boolean hasAppLocalValue(String key) {
        return this.appLocalValues.containsKey(key);
    }

    public String getAppLocalValue(String key) {
        return this.appLocalValues.get(key);
    }

    public void setAppLocalValue(String key, String value) {
        this.appLocalValues.put(key, value);
    }

    public String getParameter(String paramName) {
        return this.activity.getIntent().getStringExtra(paramName);
    }
}
