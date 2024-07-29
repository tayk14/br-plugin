package com.rockstargames.gtacr.gui.halloween;

import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.HalloweenLobbyAdapter;
import com.rockstargames.gtacr.adapters.HalloweenLobbyInviteAdapter;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class UILayoutHalloweenLobby extends UILayout {
    private Button mButton;
    private GUIHalloween mRoot;
    private View mViewRoot = null;
    private RecyclerView mRV = null;
    private HalloweenLobbyAdapter mLobbyAdapter = null;
    private ProgressDialog mProgressDialog = null;
    private GUIPopupWindow mInvitePlayersDialog = null;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutHalloweenLobby(GUIHalloween root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    public void addPlayer(String name, int deletable) {
        this.mLobbyAdapter.addPlayer(name, deletable);
    }

    public void removePlayer(String player) {
        this.mLobbyAdapter.removePlayer(player);
    }

    public GUIHalloween getRoot() {
        return this.mRoot;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    public void showProgress() {
        ProgressDialog progressDialog = new ProgressDialog(getContext(), R.style.MyTheme);
        this.mProgressDialog = progressDialog;
        progressDialog.setProgressStyle(1);
        this.mProgressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), R.drawable.progressbar_custom));
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setProgressStyle(16973854);
        this.mProgressDialog.show();
    }

    private void closeProgress() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
            } catch (Exception unused) {
            }
            this.mProgressDialog = null;
        }
    }

    public void closeInviteDialog() {
        this.mInvitePlayersDialog.dismiss();
        this.mInvitePlayersDialog = null;
    }

    public void onPlayerListInviteIncoming(JSONArray names, JSONArray ids) {
        closeProgress();
        if (ids.length() == 0) {
            this.mRoot.showPopup("Ошибка", "В текущий момент нет игроков, которых можно пригласить в игру", "Назад", null, null);
            return;
        }
        GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.halloween_lobby_playerlist, (ViewGroup) null, false), -2, -2, true);
        this.mInvitePlayersDialog = gUIPopupWindow;
        RecyclerView recyclerView = (RecyclerView) gUIPopupWindow.getContentView().findViewById(R.id.rv);
        recyclerView.setAdapter(new HalloweenLobbyInviteAdapter(this, names, ids));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.mInvitePlayersDialog.setAnimationStyle(R.style.PopupWindowAnimation);
        this.mInvitePlayersDialog.showAtLocation(((NvEventQueueActivity) getContext()).getParentLayout(), 17, 0, 0);
    }

    public Button getButtonStart() {
        return this.mButton;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        this.mViewRoot = inflater.inflate(R.layout.halloween_lobby, (ViewGroup) null, false);
        this.mLobbyAdapter = new HalloweenLobbyAdapter(this);
        RecyclerView recyclerView = (RecyclerView) this.mViewRoot.findViewById(R.id.rv);
        this.mRV = recyclerView;
        recyclerView.setAdapter(this.mLobbyAdapter);
        this.mRV.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (this.mRoot.getJson().optInt(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS) == 1) {
            this.mViewRoot.findViewById(R.id.player_part).setVisibility(0);
            this.mViewRoot.findViewById(R.id.leader_part).setVisibility(8);
        }
        this.mViewRoot.findViewById(R.id.invite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", 3);
                    UILayoutHalloweenLobby.this.mRoot.getGUIManager().sendJsonData(UILayoutHalloweenLobby.this.mRoot.getGuiId(), jSONObject);
                    UILayoutHalloweenLobby.this.showProgress();
                } catch (Exception unused) {
                }
            }
        });
        Button button = (Button) this.mViewRoot.findViewById(R.id.start);
        this.mButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UILayoutHalloweenLobby.this.getRoot().showPopup("Старт", "Вы действительно желаете начать мини-игру?", "Да", null, new View.OnClickListener() {
                    @Override
                    public void onClick(View view2) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("t", 4);
                            UILayoutHalloweenLobby.this.mRoot.getGUIManager().sendJsonData(UILayoutHalloweenLobby.this.mRoot.getGuiId(), jSONObject);
                        } catch (Exception unused) {
                        }
                        UILayoutHalloweenLobby.this.mRoot.setScreen(1);
                        UILayoutHalloweenLobby.this.getRoot().closePopup();
                    }
                });
            }
        });
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        this.mButton.setClickable(false);
    }
}
