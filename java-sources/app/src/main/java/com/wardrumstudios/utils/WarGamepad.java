package com.wardrumstudios.utils;

import android.view.ViewParent;
import blackrussia.online.Logger;

/* loaded from: classes2.dex */
public class WarGamepad extends WarBilling {
    public int GetGamepadType() {
        return -1;
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity
    public native boolean processTouchpadAsPointer(ViewParent viewParent, boolean z);

    public int GetGamepadButtons() {
        Logger.i("**** GetGamepadButtons()");
        return 0;
    }

    public int GetGamepadTrack(int i, int i2) {
        Logger.i("**** GetGamepadTrack()");
        return 0;
    }

    public float GetGamepadAxis(int i) {
        Logger.i("**** GetGamepadAxis()");
        return 0.0f;
    }
}
