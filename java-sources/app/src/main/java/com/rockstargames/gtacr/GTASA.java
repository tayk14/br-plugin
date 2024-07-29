package com.rockstargames.gtacr;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import blackrussia.online.Logger;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wardrumstudios.utils.WarMedia;

/* loaded from: classes2.dex */
public class GTASA extends WarMedia {
    public static GTASA gtasaSelf;
    static String vmVersion;
    private boolean once = false;

    public void AfterDownloadFunction() {
    }

    public void EnterSocialClub() {
    }

    public void ExitSocialClub() {
    }

    @Override // com.wardrumstudios.utils.WarMedia
    public boolean ServiceAppCommand(String str, String str2) {
        return false;
    }

    @Override // com.wardrumstudios.utils.WarMedia
    public int ServiceAppCommandValue(String str, String str2) {
        return 0;
    }

    public native void main();

    public native void setCurrentScreenSize(int i, int i2);

    static {
        Logger.i("**** Loading SO's");
        try {
            vmVersion = System.getProperty("java.vm.version");
            Logger.i("vmVersion " + vmVersion);
            System.loadLibrary("ImmEmulatorJ");
        } catch (ExceptionInInitializerError | UnsatisfiedLinkError e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        System.loadLibrary("GTASA");
        System.loadLibrary("samp");
        System.loadLibrary("pluginbr");
    }

    public static void staticEnterSocialClub() {
        gtasaSelf.EnterSocialClub();
    }

    public static void staticExitSocialClub() {
        gtasaSelf.ExitSocialClub();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.wardrumstudios.utils.WarMedia, com.nvidia.devtech.NvEventQueueActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Logger.i("GTASA onCreate");
        gtasaSelf = this;
        this.wantsMultitouch = true;
        this.wantsAccelerometer = true;
        super.onCreate(bundle);
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Logger.i("GTASA onDestroy");
        super.onDestroy();
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Logger.i("GTASA onPause");
        super.onPause();
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onRestart() {
        Logger.i("GTASA onRestart");
        super.onRestart();
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Logger.i("GTASA onResume");
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Logger.i("GTASA onStart");
        super.onStart();
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Logger.i("GTASA onStop");
        super.onStop();
    }
}
