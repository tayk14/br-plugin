package com.rockstargames.gtacr;

import com.nvidia.devtech.NvEventQueueActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface ISAMPGUI {
    void close(JSONObject json);

    int getGuiId();

    boolean isShowingGui();

    void onPacketIncoming(JSONObject json);

    void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity);
}
