package com.rockstargames.gtacr.common;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.rockstargames.gtacr.GUIManager;

public class GUIPopupWindow extends PopupWindow {
    GUIManager mGUIManager;

    public GUIPopupWindow(View view, int width, int height, boolean focusable) {
        super(view, width, height, focusable);
        this.mGUIManager = null;
    }

    public void setDimming(float value) {
        View contentView;
        if (Build.VERSION.SDK_INT >= 23) {
            contentView = (View) getContentView().getParent();
        } else {
            contentView = getContentView();
        }
        if (getBackground() != null) {
            contentView = (View) contentView.getParent();
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) contentView.getLayoutParams();
        layoutParams.flags |= 2;
        layoutParams.dimAmount = value;
        ((WindowManager) getContentView().getContext().getSystemService("window")).updateViewLayout(contentView, layoutParams);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        View contentView = getContentView();
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        int i = -2;
        i = (layoutParams == null || layoutParams.height != -2) ? -1 : -1;
        PopupViewContainer popupViewContainer = new PopupViewContainer(contentView.getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
        popupViewContainer.setBackgroundDrawable(null);
        popupViewContainer.addView(contentView, layoutParams2);
        setContentView(popupViewContainer);
        setBackgroundDrawable(null);
        getContentView().setFocusableInTouchMode(true);
        GUIManager.hideSystemUIver2(getContentView());
        getContentView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i2) {
                GUIManager.hideSystemUIver2(GUIPopupWindow.this.getContentView());
            }
        });
        super.showAtLocation(parent, gravity, x, y);
    }
}
