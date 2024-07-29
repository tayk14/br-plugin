package com.rockstargames.gtacr.common;

import android.app.Dialog;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;

public class DialogNoNavBar extends Dialog {
    public DialogNoNavBar(Context context, int themeResId) {
        super(context, themeResId);
    }

    public DialogNoNavBar(Context context) {
        super(context);
    }

    @Override
    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        super.getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        getWindow().clearFlags(8);
    }
}
