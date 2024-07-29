package com.rockstargames.gtacr.gui.fractions;

import android.util.Log;
import com.rockstargames.gtacr.GUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ&\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "(Lcom/rockstargames/gtacr/GUIManager;)V", "sendAnswerChosen", "", "chosenAnswerIndex", "", "sendButtonAcquaintedPressed", "documentId", "documentNumber", "sendButtonPressed", "currentLayout", Const.FRACTION_BUTTON_KEY, "sendChangeRankOrReprimand", "buttonKey", Const.FRACTION_CONTROL_CHANGE_RANK_OR_REPRIMAND, "sendItemInShopPressed", Const.FRACTION_SHOP_UNIQUE_ID, "sendKeyWithType", "currentPage", "typeKey", "mainKey", "", "value", "sendPlayerChosenId", "accountId", "sendStartQuest", "taskId", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionsWithJSON {
    private final GUIManager guiManager;

    public ActionsWithJSON(GUIManager gUIManager) {
        this.guiManager = gUIManager;
    }

    public final void sendKeyWithType(int i, int i2, String mainKey, int i3) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, i);
            jSONObject.put(Const.FRACTION_TYPE_KEY, i2);
            jSONObject.put(mainKey, i3);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, "put data sendKey: typeKey= " + i2 + ", mainKey = " + mainKey + ", value = " + i3);
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendButtonPressed(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, i);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, i2);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, "put data sendPressButton: currentLayout= " + i + ", button = " + i2);
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendButtonAcquaintedPressed(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, 4);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, 9);
            jSONObject.put(Const.FRACTION_DOCUMENT_ID, i);
            jSONObject.put(Const.FRACTION_DOCUMENT_NUMBER, i2);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, "put data sendPressButton: currentLayout= 4, button = 9, documentId=" + i + ", documentNumber=" + i2 + ' ');
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendStartQuest(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, 3);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, 10);
            jSONObject.put(Const.FRACTION_TASK_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, Intrinsics.stringPlus("page, 3)button, 10, sendStartQuest: taskId = ", Integer.valueOf(i)));
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendAnswerChosen(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, 5);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, 13);
            jSONObject.put(Const.FRACTION_TESTING_CHOSEN_ANSWER, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, Intrinsics.stringPlus("put data sendPressButton: typeKey = 13,  chosenAnswerIndex = ", Integer.valueOf(i)));
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendPlayerChosenId(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, 9);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, 15);
            jSONObject.put(Const.FRACTION_CONTROL_ACCOUNT_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, Intrinsics.stringPlus("put data sendPressButton: page=9, button = 15, account_id = ", Integer.valueOf(i)));
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendChangeRankOrReprimand(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, 9);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, i);
            jSONObject.put(Const.FRACTION_CONTROL_CHANGE_RANK_OR_REPRIMAND, i2);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, "put data sendPressButton: buttonKey = " + i + ", changeRank= " + i2);
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }

    public final void sendItemInShopPressed(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.PAGE_KEY, 8);
            jSONObject.put(Const.FRACTION_BUTTON_KEY, i);
            jSONObject.put(Const.FRACTION_SHOP_UNIQUE_ID, i2);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager != null) {
                gUIManager.sendJsonData(46, jSONObject);
            }
            Log.v(Const.LOG_FRACTION_S, "put data sendPressButton: buttonKey = " + i + ", uniqueID= " + i2);
        } catch (Exception e) {
            Log.v(Const.LOG_FRACTION_S, Log.getStackTraceString(e));
        }
    }
}
