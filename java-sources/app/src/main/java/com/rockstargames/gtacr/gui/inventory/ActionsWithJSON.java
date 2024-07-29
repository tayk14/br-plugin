package com.rockstargames.gtacr.gui.inventory;

import com.rockstargames.gtacr.GUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J.\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/ActionsWithJSON;", "", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "(Lcom/rockstargames/gtacr/GUIManager;)V", "openRadialMenu", "", "sendIdWithOldAndNewPositionsAndValueToServer", "typeKey", "", "idItem", "oldPosition", "newPosition", "value", "sendIdWithOldAndNewPositionsToServer", "sendMessageError", "message", "", "sendPositionToServer", "positionInSlot", "sendPressButton", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionsWithJSON {
    private final GUIManager guiManager;

    public ActionsWithJSON(GUIManager gUIManager) {
        this.guiManager = gUIManager;
    }

    public final void sendPressButton(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(34, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void openRadialMenu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.onPacketIncoming(14, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendIdWithOldAndNewPositionsAndValueToServer(int i, int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("ga", i2);
            jSONObject.put(PutKeys.PUT_OLD_POSITION, i3);
            jSONObject.put(GetKeys.GET_NEW_SIZE_INVENTORY, i4);
            jSONObject.put("v", i5);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(34, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendIdWithOldAndNewPositionsToServer(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("ga", i2);
            jSONObject.put(PutKeys.PUT_OLD_POSITION, i3);
            jSONObject.put("s", i4);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(34, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendPositionToServer(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            jSONObject.put("s", i2);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(34, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendMessageError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put("t", 2);
            jSONObject.put("d", 2);
            jSONObject.put("i", message);
            jSONObject.put("s", -1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.onPacketIncoming(13, jSONObject);
        } catch (Exception unused) {
        }
    }
}
