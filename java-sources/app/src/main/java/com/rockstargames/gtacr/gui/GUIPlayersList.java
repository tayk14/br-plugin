package com.rockstargames.gtacr.gui;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.PlayersListAdapter;
import com.rockstargames.gtacr.data.PlayersData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GUIPlayersList implements ISAMPGUI, PlayersListAdapter.OnClickListenerPlayersList {
    private static final int ACTION_VALUE_RESPONSE = 1;
    private static final String EMPTY_TEXT = "";
    private static final String KEY_ACTION_TYPE = "t";
    private static final String KEY_GET_ALL_PLAYERS = "data";
    private static final String KEY_GET_PLAYER_ID = "id";
    private static final String KEY_GET_PLAYER_LEVEL = "level";
    private static final String KEY_GET_PLAYER_NICK = "nick";
    private static final String KEY_GET_PLAYER_PING = "ping";
    private static final String LOG = "LOG_VIEW";
    private static final String TEXT_VALUE_PLAYERS = "Онлайн: ";
    private Button btClose;
    private ImageView iconClearSearchText;
    private ImageView iconSearch;
    private PlayersListAdapter playersListAdapter;
    private RecyclerView recyclerView;
    private EditText searchView;
    private TextView viewValuePlayers;
    private NvEventQueueActivity context = null;
    private View rootView = null;
    private PopupWindow popupWindow = null;
    private GUIManager guiManager = null;
    private Runnable mRunnable = null;
    private Handler mHandler = null;
    private final List<PlayersData> playersData = new ArrayList();
    private String searchText = "";
    private int thisPosition = -1;

    @Override
    public int getGuiId() {
        return 25;
    }

    public static ISAMPGUI newInstance() {
        return new GUIPlayersList();
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        if (json.optInt("t") != 1) {
            return;
        }
        clearPlayers();
        setData(json);
        this.playersListAdapter.notifyDataSetChanged();
        getFilterPlayers(this.searchText);
        updateValuePlayers();
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.context = activity;
        this.guiManager = manager;
        if (this.popupWindow == null) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.players_list_dialog, (ViewGroup) null, false);
            this.rootView = inflate;
            this.btClose = (Button) inflate.findViewById(R.id.players_list_close);
            this.viewValuePlayers = (TextView) this.rootView.findViewById(R.id.players_list_value_players);
            this.recyclerView = (RecyclerView) this.rootView.findViewById(R.id.players_list);
            this.searchView = (EditText) this.rootView.findViewById(R.id.search_view);
            this.iconSearch = (ImageView) this.rootView.findViewById(R.id.icon_search_view);
            this.iconClearSearchText = (ImageView) this.rootView.findViewById(R.id.icon_clear_search_text);
            this.popupWindow = new PopupWindow(this.rootView, -1, -1, true);
            this.playersData.add(new PlayersData(0, "-", 0, 0));
            this.playersListAdapter = new PlayersListAdapter(this.context, this.playersData, this);
            setDataInView();
            updateValuePlayers();
            this.searchView.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable editable) {
                }

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    GUIPlayersList.this.searchText = charSequence.toString();
                    GUIPlayersList gUIPlayersList = GUIPlayersList.this;
                    gUIPlayersList.setVisibleIconInSearchView(gUIPlayersList.searchText);
                    GUIPlayersList gUIPlayersList2 = GUIPlayersList.this;
                    gUIPlayersList2.getFilterPlayers(gUIPlayersList2.searchText);
                }
            });
            this.btClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIPlayersList.this.lambda$show$0$GUIPlayersList(view);
                }
            });
            this.iconClearSearchText.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIPlayersList.this.lambda$show$1$GUIPlayersList(view);
                }
            });
            this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUIPlayersList.this.lambda$show$2$GUIPlayersList();
                }
            });
            //this.context.toggleDrawing2dStuff(true);
            this.popupWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
            GUIManager.hideSystemUI(this.popupWindow.getContentView());
        }
        updateData();
        this.mHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                GUIPlayersList.this.updateData();
                GUIPlayersList.this.mHandler.postDelayed(GUIPlayersList.this.mRunnable, 5000L);
            }
        };
        this.mRunnable = runnable;
        this.mHandler.postDelayed(runnable, 5000L);
    }

    public void lambda$show$0$GUIPlayersList(View view) {
        this.popupWindow.dismiss();
    }

    public void lambda$show$1$GUIPlayersList(View view) {
        this.searchView.setText("");
        ((InputMethodManager) this.context.getSystemService("input_method")).hideSoftInputFromWindow(this.rootView.getWindowToken(), 0);
        this.searchView.setFocusable(false);
        this.searchView.setFocusableInTouchMode(true);
        GUIManager.hideSystemUI(this.rootView);
    }

    public void lambda$show$2$GUIPlayersList() {
        //this.context.toggleDrawing2dStuff(false);
        closedWindow();
        this.guiManager.closeGUI(null, 25);
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    private void clearPlayers() {
        this.playersData.clear();
    }

    private void setData(JSONObject jsonObject) {
        JSONArray optJSONArray = jsonObject.optJSONArray("data");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.playersData.add(new PlayersData(optJSONArray.optJSONObject(i).optInt("id"), optJSONArray.optJSONObject(i).optString(KEY_GET_PLAYER_NICK), optJSONArray.optJSONObject(i).optInt("level"), optJSONArray.optJSONObject(i).optInt(KEY_GET_PLAYER_PING)));
            }
        }
    }

    private RecyclerView.LayoutManager setLayout() {
        return new LinearLayoutManager(this.rootView.getContext(), 1, false);
    }

    private void setDataInView() {
        this.recyclerView.setLayoutManager(setLayout());
        this.recyclerView.setAdapter(this.playersListAdapter);
    }

    private void updateValuePlayers() {
        int size = this.playersData.size();
        this.viewValuePlayers.setText(TEXT_VALUE_PLAYERS + size);
    }

    public void setVisibleIconInSearchView(String searchText) {
        if (searchText.isEmpty()) {
            this.iconSearch.setVisibility(0);
            this.iconClearSearchText.setVisibility(4);
            this.searchView.setHint(R.string.players_list_search_hint);
            return;
        }
        this.iconSearch.setVisibility(4);
        this.iconClearSearchText.setVisibility(0);
    }

    public void getFilterPlayers(String textForFilter) {
        this.playersListAdapter.getFilter().filter(textForFilter);
    }

    @Override
    public void click(PlayersData playersData, int getPosition, View view) {
        this.playersListAdapter.setOnlyItemClickable(getPosition);
        this.thisPosition = getPosition;
    }

    public void updateData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            this.guiManager.sendJsonData(25, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void closedWindow() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 2);
            this.guiManager.sendJsonData(25, jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
