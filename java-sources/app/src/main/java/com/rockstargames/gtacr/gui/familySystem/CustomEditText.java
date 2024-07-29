package com.rockstargames.gtacr.gui.familySystem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.NotificationCompat;
import com.rockstargames.gtacr.GUIManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/CustomEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "counter", "", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "onEditorAction", "", "actionCode", "onKeyPreIme", "", "keyCode", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "putValueTokenForGetCost", "valueOfToken", "sendToServerValueOfToken", "setGUIManager", "getGuiManager", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomEditText extends AppCompatEditText {
    private int counter;
    private GUIManager guiManager;

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setGUIManager(GUIManager gUIManager) {
        this.guiManager = gUIManager;
    }

    @Override
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            int i2 = this.counter + 1;
            this.counter = i2;
            if (i2 % 2 != 0) {
                putValueTokenForGetCost(sendToServerValueOfToken());
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public void onEditorAction(int i) {
        super.onEditorAction(i);
        if (i == 3 || i == 4 || i == 6) {
            putValueTokenForGetCost(sendToServerValueOfToken());
        }
    }

    private final int sendToServerValueOfToken() {
        String valueOf = String.valueOf(super.getText());
        Objects.requireNonNull(valueOf);
        String getText = valueOf;
        Intrinsics.checkNotNullExpressionValue(getText, "getText");
        if (!(getText.length() > 0) || getText.charAt(0) == '0') {
            return 0;
        }
        return Integer.parseInt(getText);
    }

    private final void putValueTokenForGetCost(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 9);
            jSONObject.put("s", 1);
            jSONObject.put("v", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }
}
