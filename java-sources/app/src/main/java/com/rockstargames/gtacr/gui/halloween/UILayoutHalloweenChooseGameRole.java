package com.rockstargames.gtacr.gui.halloween;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.adapters.HalloweenChooseGameRoleAdapter;
import com.rockstargames.gtacr.common.UILayout;
import org.json.JSONObject;

public class UILayoutHalloweenChooseGameRole extends UILayout {
    public static final int CHOOSE_GAME = 0;
    public static final int CHOOSE_ROLE = 1;
    public static final int CHOOSE_SOLO_PARTY = 2;
    private GUIHalloween mRoot;
    private View mViewRoot = null;
    private RecyclerView mRV = null;
    private Button mButtonNext = null;
    private TextView mHeader = null;
    private HalloweenChooseGameRoleAdapter mGameRoleAdapter = null;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutHalloweenChooseGameRole(GUIHalloween root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    public void setType(int type) {
        this.mGameRoleAdapter.setType(type);
    }

    public GUIHalloween getRoot() {
        return this.mRoot;
    }

    public int getType() {
        return this.mGameRoleAdapter.getType();
    }

    public HalloweenChooseGameRoleAdapter getAdapter() {
        return this.mGameRoleAdapter;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    public void notifyButtonPressed() {
        this.mRoot.notifyButtonPressed(this.mButtonNext);
    }

    public void notifyButtonDeactivated() {
        this.mRoot.notifyButtonDeactivated(this.mButtonNext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.halloween_choosegamerole, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mRV = (RecyclerView) inflate.findViewById(R.id.rv);
        this.mHeader = (TextView) this.mViewRoot.findViewById(R.id.header);
        Button button = (Button) this.mViewRoot.findViewById(R.id.button);
        this.mButtonNext = button;
        button.setClickable(false);
        HalloweenChooseGameRoleAdapter halloweenChooseGameRoleAdapter = new HalloweenChooseGameRoleAdapter(this, 0);
        this.mGameRoleAdapter = halloweenChooseGameRoleAdapter;
        this.mRV.setAdapter(halloweenChooseGameRoleAdapter);
        this.mRV.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getType());
                    jSONObject.put("s", UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getSelected());
                    UILayoutHalloweenChooseGameRole.this.mRoot.getGUIManager().sendJsonData(UILayoutHalloweenChooseGameRole.this.mRoot.getGuiId(), jSONObject);
                } catch (Exception unused) {
                }
                if (UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getType() == 0) {
                    UILayoutHalloweenChooseGameRole.this.mRoot.setScreen(1);
                } else if (UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getType() == 1) {
                    if (UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getSelected() == 0) {
                        UILayoutHalloweenChooseGameRole.this.mRoot.setScreen(1);
                    } else {
                        UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.setType(2);
                    }
                    UILayoutHalloweenChooseGameRole.this.mHeader.setText("Выберите с кем вы хотите играть");
                } else if (UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getType() == 2) {
                    if (UILayoutHalloweenChooseGameRole.this.mGameRoleAdapter.getSelected() == 0) {
                        UILayoutHalloweenChooseGameRole.this.mRoot.setScreen(1);
                    } else {
                        UILayoutHalloweenChooseGameRole.this.mRoot.setScreen(2);
                    }
                }
            }
        });
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        this.mButtonNext.setClickable(false);
    }
}
