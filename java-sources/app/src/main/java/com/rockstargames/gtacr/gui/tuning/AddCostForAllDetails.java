package com.rockstargames.gtacr.gui.tuning;

import com.rockstargames.gtacr.gui.entertainmentSystem.GUIEntertainmentSystemKt;

/* loaded from: classes2.dex */
public class AddCostForAllDetails {
    private GUITuning mainRoot;
    private final int minCostCar = 2000000;
    private final int addCostIsTrue = 5000;
    private final int addCostIsFalse = 15000;
    private final int[] tuningCostTypes = {1000, 1000, 500, 600, 1000, 5000, GUIEntertainmentSystemKt.MIN_TIMER_ENTERTAINMENT_SYSTEM, 1000, 1000, 10000, 450, 450, 1000, 1000, 700, 15000, 15000, 15000, 15000, 15000, 50000, 150000, 300, 150000, 10000, 15000, 10000, 0, 50000};

    public AddCostForAllDetails(GUITuning mainRoot) {
        this.mainRoot = mainRoot;
    }

    public int getSizePrice() {
        return this.tuningCostTypes.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0102, code lost:
        if (r3 >= 10000.0d) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDetailPrice(int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rockstargames.gtacr.gui.tuning.AddCostForAllDetails.getDetailPrice(int, int, int):int");
    }
}