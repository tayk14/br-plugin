package com.rockstargames.gtacr.common;

import android.view.View;
import android.widget.PopupWindow;

public class PopupWindowNavBar extends PopupWindow {
    public PopupWindowNavBar(View view, int width, int height, boolean focusable) {
        super(view, width, height, focusable);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        setFocusable(false);
        super.showAtLocation(parent, gravity, x, y);
        setFocusable(true);
        update();
    }
}
