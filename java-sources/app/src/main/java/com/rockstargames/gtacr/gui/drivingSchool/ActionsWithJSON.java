package com.rockstargames.gtacr.gui.drivingSchool;

import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.fractions.Const;
import kotlin.Metadata;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/ActionsWithJSON;", "", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "(Lcom/rockstargames/gtacr/GUIManager;)V", "sendCheckAnswer", "", "thisAnswer", "", "sendCheckType", Const.FRACTION_TYPE_KEY, "sendPressButton", "typeKey", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            gUIManager.sendJsonData(37, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendCheckType(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put("s", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(37, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendCheckAnswer(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 3);
            jSONObject.put("cq", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(37, jSONObject);
        } catch (Exception unused) {
        }
    }
}
