package com.rockstargames.gtacr.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class PopupViewContainer extends FrameLayout {
    public PopupViewContainer(Context context) {
        super(context);
    }

    public PopupViewContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopupViewContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
