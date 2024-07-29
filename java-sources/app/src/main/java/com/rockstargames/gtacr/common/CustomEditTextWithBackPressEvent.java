package com.rockstargames.gtacr.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Objects;

public class CustomEditTextWithBackPressEvent extends AppCompatEditText {
    private MyEditTextListener onBackPressListener;

    public interface MyEditTextListener {
        void callback();
    }

    public CustomEditTextWithBackPressEvent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnBackPressListener(MyEditTextListener onBackPressListener) {
        this.onBackPressListener = onBackPressListener;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event.getAction() == 1) {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(getRootView());
            Objects.requireNonNull(rootWindowInsets);
            if (rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
                this.onBackPressListener.callback();
                return false;
            }
            return false;
        }
        return super.dispatchKeyEvent(event);
    }
}
