package com.wardrumstudios.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import blackrussia.online.Logger;
import com.nvidia.devtech.NvUtil;
import java.io.File;

/* loaded from: classes2.dex */
public class WarMedia extends WarGamepad {
    private String baseDirectory;
    private String baseDirectoryRoot;

    public String GetGameBaseDirectory() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return "";
        }
        try {
            File externalFilesDir = getExternalFilesDir(null);
            String absolutePath = externalFilesDir.getAbsolutePath();
            this.baseDirectoryRoot = absolutePath.substring(0, absolutePath.indexOf("/Android"));
            return externalFilesDir.getAbsolutePath() + "/";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.baseDirectory = GetGameBaseDirectory();
        NvUtil.getInstance().setActivity(this);
        NvUtil.getInstance().setAppLocalValue("STORAGE_ROOT", this.baseDirectory);
        NvUtil.getInstance().setAppLocalValue("STORAGE_ROOT_BASE", this.baseDirectoryRoot);
        super.onCreate(bundle);
    }

    public void ShowKeyboard(int i) {
        Logger.i("**** ShowKeyboard");
    }

    public boolean IsKeyboardShown() {
        Logger.i("**** IsKeyboardShown");
        return false;
    }

    public void PlayMovie(String str, float f) {
        Logger.i("**** PlayMovie");
    }

    public void PlayMovieInFile(String str, float f, int i, int i2) {
        Logger.i("**** PlayMovieInFile");
    }

    public void PlayMovieInWindow(String str, int i, int i2, int i3, int i4, float f, int i5, int i6, int i7) {
        Logger.i("**** PlayMovieInWindow");
    }

    public void StopMovie() {
        Logger.i("**** StopMovie");
    }

    public void MovieSetSkippable(boolean z) {
        Logger.i("**** MovieSetSkippable");
    }

    public int IsMoviePlaying() {
        Logger.i("**** IsMoviePlaying");
        return 0;
    }

    public boolean DeleteFile(String str) {
        Logger.i("**** DeleteFile");
        return true;
    }

    public boolean FileRename(String str, String str2, int i) {
        Logger.i("**** FileRename");
        return true;
    }

    public int GetDeviceLocale() {
        Logger.i("**** GetDeviceLocale");
        return 0;
    }

    public boolean IsPhone() {
        Logger.i("**** IsPhone");
        return true;
    }

    public int GetDeviceType() {
        Logger.i("Build info version device  " + Build.DEVICE);
        Logger.i("Build MANUFACTURER  " + Build.MANUFACTURER);
        Logger.i("Build BOARD  " + Build.BOARD);
        Logger.i("Build DISPLAY  " + Build.DISPLAY);
        Logger.i("Build CPU_ABI  " + Build.CPU_ABI);
        Logger.i("Build CPU_ABI2  " + Build.CPU_ABI2);
        Logger.i("Build HARDWARE  " + Build.HARDWARE);
        Logger.i("Build MODEL  " + Build.MODEL);
        Logger.i("Build PRODUCT  " + Build.PRODUCT);
        return (IsPhone() ? 1 : 0) + 0 + 4 + 512;
    }

    public int GetDeviceInfo(int i) {
        Logger.i("**** GetDeviceInfo");
        if (i != 0) {
            if (i != 1) {
                return -1;
            }
            Logger.i("Return for touchsreen 1");
        }
        return 1;
    }

    public String GetAndroidBuildinfo(int i) {
        Logger.i("**** GetAndroidBuildinfo");
        if (i == 0) {
            return Build.MANUFACTURER;
        }
        if (i != 1) {
            return i != 2 ? "UNKNOWN" : Build.MODEL;
        }
        return Build.PRODUCT;
    }

    public String OBFU_GetDeviceID() {
        Logger.i("**** OBFU_GetDeviceID");
        return "no id";
    }

    public String FileGetArchiveName(int i) {
        Logger.i("**** FileGetArchiveName");
        return "";
    }

    public boolean IsAppInstalled(String str) {
        Logger.i("**** IsAppInstalled");
        return false;
    }

    public void OpenLink(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        Logger.i("**** OpenLink");
    }

    public void LoadAllGamesFromCloud() {
        Logger.i("**** LoadAllGamesFromCloud");
    }

    public String LoadGameFromCloud(int i, byte[] bArr) {
        Logger.i("**** LoadGameFromCloud");
        return "";
    }

    public void SaveGameToCloud(int i, byte[] bArr, int i2) {
        Logger.i("**** SaveGameToCloud");
    }

    public boolean IsCloudAvailable() {
        Logger.i("**** IsCloudAvailable");
        return false;
    }

    public boolean NewCloudSaveAvailable(int i) {
        Logger.i("**** NewCloudSaveAvailable");
        return false;
    }

    public void MovieKeepAspectRatio(boolean z) {
        Logger.i("**** MovieKeepAspectRatio");
    }

    public void MovieSetText(String str, boolean z, boolean z2) {
        Logger.i("**** MovieSetText");
    }

    public void MovieDisplayText(boolean z) {
        Logger.i("**** MovieDisplayText");
    }

    public void MovieClearText(boolean z) {
        Logger.i("**** MovieClearText");
    }

    public void MovieSetTextScale(int i) {
        Logger.i("**** MovieSetTextScale");
    }

    public int GetSpecialBuildType() {
        Logger.i("**** GetSpecialBuildType");
        return 0;
    }

    public void SendStatEvent(String str) {
        Logger.i("**** SendStatEvent");
    }

    public void SendStatEvent(String str, String str2, String str3) {
        Logger.i("**** SendStatEvent1");
    }

    public int GetTotalMemory() {
        Logger.i("**** GetTotalMemory");
        return 0;
    }

    public int GetLowThreshhold() {
        Logger.i("**** GetLowThreshhold");
        return 0;
    }

    public int GetAvailableMemory() {
        Logger.i("**** GetAvailableMemory");
        return 0;
    }

    public float GetScreenWidthInches() {
        Logger.i("**** GetScreenWidthInches");
        return 0.0f;
    }

    public String GetAppId() {
        Logger.i("**** GetAppId");
        return "";
    }

    public void ScreenSetWakeLock(boolean z) {
        Logger.i("**** ScreenSetWakeLock");
    }

    public boolean ServiceAppCommand(String str, String str2) {
        Logger.i("**** ServiceAppCommand " + str + " " + str2);
        return false;
    }

    public int ServiceAppCommandValue(String str, String str2) {
        Logger.i("**** ServiceAppCommandValue " + str + " " + str2);
        return 0;
    }
}
