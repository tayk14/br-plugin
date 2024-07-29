package com.rockstargames.gtacr.gui.socialNetworkLink.network;

import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.socialNetworkLink.SocialNetworkLinkUtils;
import kotlin.Metadata;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/network/SocialNetworkActionWithJSON;", "", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "(Lcom/rockstargames/gtacr/GUIManager;)V", "sendSocialNetworkButton", "", "buttonId", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialNetworkActionWithJSON {
    private final GUIManager guiManager;

    public SocialNetworkActionWithJSON(GUIManager gUIManager) {
        this.guiManager = gUIManager;
    }

    public final void sendSocialNetworkButton(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialNetworkLinkUtils.KEY_BUTTON_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(52, jSONObject);
        } catch (Exception unused) {
        }
    }
}
