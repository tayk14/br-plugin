package com.rockstargames.gtacr.gui.inventory;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.rockstargames.gtacr.GUIManager;
import java.util.Objects;
import org.json.JSONObject;

public class CustomEditText extends AppCompatEditText {
    private int counter;
    private GUIManager guiManager;
    private GUIUsersInventory root;
    private int saveValueOfMoney;

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.counter = 0;
        this.saveValueOfMoney = 0;
    }

    public void setGUIManager(GUIManager guiManager) {
        this.guiManager = guiManager;
    }

    public void setMainRoot(GUIUsersInventory root) {
        this.root = root;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            int i = this.counter + 1;
            this.counter = i;
            if (i % 2 != 0 && this.saveValueOfMoney != sendToServerMyValueOfMoney()) {
                if (sendToServerMyValueOfMoney() > 20000000) {
                    sendMessageError("Нельзя передать за раз больше 20.000.000 ₽");
                } else {
                    putInfoForClickCancelOrNextOrDismiss(sendToServerMyValueOfMoney());
                }
            }
            this.root.closeAndroidsInterface();
            return false;
        }
        return false;
    }

    @Override
    public void onEditorAction(int actionCode) {
        super.onEditorAction(actionCode);
        if (actionCode == 3 || actionCode == 6) {
            if (this.saveValueOfMoney != sendToServerMyValueOfMoney()) {
                if (sendToServerMyValueOfMoney() > 20000000) {
                    sendMessageError("Нельзя передать за раз больше 20.000.000 ₽");
                } else {
                    putInfoForClickCancelOrNextOrDismiss(sendToServerMyValueOfMoney());
                }
            }
            this.root.closeAndroidsInterface();
        }
    }

    private int sendToServerMyValueOfMoney() {
        Editable text = super.getText();
        Objects.requireNonNull(text);
        String obj = text.toString();
        if (obj.length() <= 0 || obj.charAt(0) == '0') {
            return 0;
        }
        return Integer.parseInt(obj);
    }

    private void putInfoForClickCancelOrNextOrDismiss(int valueOfMoney) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 6);
            jSONObject.put(PutKeys.PUT_MONEY, valueOfMoney);
            this.guiManager.sendJsonData(33, jSONObject);
            this.saveValueOfMoney = sendToServerMyValueOfMoney();
        } catch (Exception unused) {
        }
    }

    private void sendMessageError(String message) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put("t", 2);
            jSONObject.put("d", 2);
            jSONObject.put("i", message);
            jSONObject.put("s", -1);
            this.guiManager.onPacketIncoming(13, jSONObject);
        } catch (Exception unused) {
        }
    }
}
