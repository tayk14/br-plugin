package com.rockstargames.gtacr.gui.halloween;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.common.UIContainer;
import org.json.JSONObject;

public class GUIHalloweenGame implements ISAMPGUI {
    public static final int HALLOWEEN_GAME_FINGER = 2;
    public static final int HALLOWEEN_GAME_PRIZE = 0;
    public static final int HALLOWEEN_GAME_UNTIE = 1;
    private NvEventQueueActivity mActivity = null;
    private GUIManager mGUIManager = null;
    private GUIPopupWindow mWindow = null;
    private UIContainer mContainer = null;
    private View mViewRoot = null;
    private JSONObject mJson = null;

    @Override
    public int getGuiId() {
        return 31;
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new GUIHalloweenGame();
    }

    public GUIManager getGuiManager() {
        return this.mGUIManager;
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        this.mActivity = activity;
        this.mJson = json;
        if (this.mWindow == null) {
            this.mViewRoot = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.halloween_game, (ViewGroup) null, false);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mViewRoot, -1, -1, true);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        }
        UIContainer uIContainer = (UIContainer) this.mViewRoot.findViewById(R.id.container);
        this.mContainer = uIContainer;
        uIContainer.addLayout(0, new UILayoutHalloweenGamePrize(this));
        this.mContainer.addLayout(1, new UILayoutHalloweenGameUnTie(this));
        this.mContainer.addLayout(2, new UILayoutHalloweenGameFinger(this));
        this.mContainer.setCurrentLayout(this.mJson.optInt("g"));
        this.mViewRoot.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GUIHalloweenGame.this.mGUIManager.notifyGUIClosed(GUIHalloweenGame.this.getGuiId(), null);
                GUIHalloweenGame.this.close(null);
            }
        });
        this.mWindow.showAtLocation(this.mActivity.getParentLayout(), 17, 0, 0);
        this.mWindow.setDimming(0.8f);
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    @Override
    public void close(JSONObject json) {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.dismiss();
        }
        if (json == null || json.optInt("t") != 1) {
            return;
        }
        this.mGUIManager.sendJsonData(getGuiId(), json);
    }

    @Override
    public boolean isShowingGui() {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            return gUIPopupWindow.isShowing();
        }
        return false;
    }
}
