package com.wardrumstudios.utils;

import blackrussia.online.Logger;

/* loaded from: classes2.dex */
public class WarBilling extends WarBase {
    @Override // com.nvidia.devtech.NvEventQueueActivity
    public native void changeConnection(boolean z);

    @Override // com.nvidia.devtech.NvEventQueueActivity
    public native void notifyChange(String str, int i);

    public void AddSKU(String str) {
        Logger.i("**** AddSKU: " + str);
    }

    public boolean InitBilling() {
        Logger.i("**** InitBilling()");
        return true;
    }

    public String LocalizedPrice(String str) {
        Logger.i("**** LocalizedPrice: " + str);
        return "";
    }

    public boolean RequestPurchase(String str) {
        Logger.i("**** RequestPurchase: " + str);
        return true;
    }

    public void SetBillingKey(String str) {
        Logger.i("**** SetBillingKey: " + str);
    }
}
