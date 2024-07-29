package com.rockstargames.gtacr.gui.halloween;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UILayout;

public class UILayoutHalloweenWaitForStart extends UILayout {
    private GUIHalloween mRoot;
    private View mViewRoot = null;
    private TextView mText = null;
    private TextView mHeader = null;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutHalloweenWaitForStart(GUIHalloween root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    public void setHeader(String header) {
        this.mHeader.setText(header);
        this.mText.setText("");
    }

    public void setPlayersWaiting(int players) {
        TextView textView = this.mText;
        textView.setText("Игроков в очереди: " + players);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.halloween_wait_for_start, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mText = (TextView) inflate.findViewById(R.id.info);
        this.mHeader = (TextView) this.mViewRoot.findViewById(R.id.header);
        this.mViewRoot.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UILayoutHalloweenWaitForStart.this.mRoot.showPopup("Выход", "Вы действительно желаете покинуть очередь?", "Да", null, new View.OnClickListener() {
                    @Override
                    public void onClick(View view2) {
                        UILayoutHalloweenWaitForStart.this.mRoot.close(null);
                    }
                });
            }
        });
        return this.mViewRoot;
    }
}
