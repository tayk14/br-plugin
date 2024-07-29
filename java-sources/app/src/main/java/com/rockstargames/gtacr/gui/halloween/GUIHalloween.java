package com.rockstargames.gtacr.gui.halloween;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import blackrussia.online.Utils;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class GUIHalloween implements ISAMPGUI {
    public static final int HALLOWEEN_CHOOSEGAMEROLE = 0;
    public static final int HALLOWEEN_LOBBY = 2;
    public static final int HALLOWEEN_WAIT_FOR_START = 1;
    private DisplayMetrics displayMetrics;
    private NvEventQueueActivity mActivity = null;
    private GUIManager mGUIManager = null;
    private GUIPopupWindow mWindow = null;
    private UIContainer mContainer = null;
    private View mViewRoot = null;
    private JSONObject mJson = null;
    private GUIPopupWindow mPopup = null;

    @Override
    public int getGuiId() {
        return 30;
    }

    public static ISAMPGUI newInstance() {
        return new GUIHalloween();
    }

    public UIContainer getContainer() {
        return this.mContainer;
    }

    public void notifyButtonPressed(Button button) {
        button.setBackground(ResourcesCompat.getDrawable(this.mActivity.getResources(), R.drawable.donate_tile_button, null));
        button.setTextColor(Color.parseColor("#FFFFFF"));
        button.setClickable(true);
    }

    public void notifyButtonDeactivated(Button button) {
        button.setBackground(ResourcesCompat.getDrawable(this.mActivity.getResources(), R.drawable.donate_tile_button_inactive, null));
        button.setTextColor(Color.parseColor("#898989"));
        button.setClickable(false);
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        JSONArray jSONArray;
        int optInt = json.optInt("t");
        if (optInt == 0) {
            ((UILayoutHalloweenWaitForStart) this.mContainer.getLayout(1)).setPlayersWaiting(json.optInt("s"));
        } else if (optInt == 1) {
            ((UILayoutHalloweenLobby) this.mContainer.getLayout(2)).addPlayer(json.optString("n"), 0);
        } else if (optInt == 2) {
            ((UILayoutHalloweenLobby) this.mContainer.getLayout(2)).removePlayer(json.optString("n"));
        } else if (optInt == 3) {
            JSONArray jSONArray2 = null;
            try {
                jSONArray = json.getJSONArray("n");
                try {
                    jSONArray2 = json.getJSONArray("i");
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONArray = null;
            }
            ((UILayoutHalloweenLobby) this.mContainer.getLayout(2)).onPlayerListInviteIncoming(jSONArray, jSONArray2);
        } else if (optInt == 5) {
            this.mContainer.setCurrentLayout(1);
        } else if (optInt != 6) {
        } else {
            ((UILayoutHalloweenWaitForStart) this.mContainer.getLayout(1)).setHeader(json.optString("s"));
        }
    }

    public int getItemWidth() {
        return (int) (this.displayMetrics.widthPixels / 4.5f);
    }

    public void setScreen(int screen) {
        this.mContainer.setCurrentLayout(screen);
    }

    public GUIManager getGUIManager() {
        return this.mGUIManager;
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public void showPopup(String header, String content, String button, View.OnClickListener closeListener, View.OnClickListener okListener) {
        if (this.mPopup != null) {
            closePopup();
        }
        View inflate = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(R.layout.halloween_popup, (ViewGroup) null, false);
        this.mPopup = new GUIPopupWindow(inflate, -2, -2, true);
        inflate.findViewById(R.id.ok).setOnClickListener(okListener);
        if (closeListener != null) {
            inflate.findViewById(R.id.close).setOnClickListener(closeListener);
        } else {
            inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIHalloween.this.closePopup();
                }
            });
        }
        if (okListener != null) {
            inflate.findViewById(R.id.ok).setOnClickListener(okListener);
        } else {
            inflate.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIHalloween.this.closePopup();
                }
            });
        }
        ((TextView) inflate.findViewById(R.id.header)).setText(header);
        ((TextView) inflate.findViewById(R.id.content)).setText(content);
        ((Button) inflate.findViewById(R.id.ok)).setText(button);
        this.mPopup.showAtLocation(this.mActivity.getParentLayout(), 17, 0, 0);
        this.mPopup.setDimming(0.8f);
    }

    public void closePopup() {
        GUIPopupWindow gUIPopupWindow = this.mPopup;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.dismiss();
            this.mPopup = null;
        }
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        this.mActivity = activity;
        this.mJson = json;
        if (this.mWindow == null) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.halloween, (ViewGroup) null, false);
            this.mViewRoot = inflate;
            Utils.setBackground(activity, R.drawable.mini_game_events_9_may_back, inflate);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mViewRoot, -1, -1, true);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    GUIHalloween.this.mGUIManager.notifyGUIClosed(GUIHalloween.this.getGuiId(), null);
                }
            });
            this.mWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        }
        this.displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
        this.mContainer = (UIContainer) this.mViewRoot.findViewById(R.id.container);
        this.mViewRoot.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GUIHalloween.this.showPopup("Выход", "Вы действительно желаете выйти из мини-игр?", "Да", null, new View.OnClickListener() {
                    @Override
                    public void onClick(View view2) {
                        GUIHalloween.this.close(null);
                    }
                });
            }
        });
        this.mViewRoot.findViewById(R.id.game_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = ((UILayoutHalloweenChooseGameRole) GUIHalloween.this.mContainer.getLayout(0)).getAdapter().getSelected();
                if (selected == 0) {
                    GUIHalloween.this.showPopup("Гонка вооружений", "Гонка вооружений — это мероприятие, в котором задача игроков заключается в убийстве других и получении нового вооружения. Победит тот, кто первым дойдет до последнего оружия.", "ОК", null, null);
                } else if (selected == 1) {
                    GUIHalloween.this.showPopup("Командное сражение", "Командное сражение — игра, в которой Вам необходимо бок о бок с другими игроками сражаться против соперников! Побеждает та команда, которая набрала большее число убийств за время игры!", "ОК", null, null);
                } else if (selected != 2) {
                } else {
                    GUIHalloween.this.showPopup("Танковые баталии", "Танковые баталии - игра, в которой 4 игрока соревнуются за статус самого лучшего танкиста. Ваша задача убить максимальное число танков за 3 минуты, сражаясь с другими танкистами.", "ОК", null, null);
                }
            }
        });
        this.mContainer.addLayout(0, new UILayoutHalloweenChooseGameRole(this));
        this.mContainer.addLayout(1, new UILayoutHalloweenWaitForStart(this));
        this.mContainer.addLayout(2, new UILayoutHalloweenLobby(this));
        if (json.optInt(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS) == 1) {
            this.mContainer.setCurrentLayout(2);
        } else {
            this.mContainer.setCurrentLayout(0);
        }
        this.mWindow.showAtLocation(this.mActivity.getParentLayout(), 17, 0, 0);
    }

    @Override
    public void close(JSONObject json) {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.dismiss();
        }
        closePopup();
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
