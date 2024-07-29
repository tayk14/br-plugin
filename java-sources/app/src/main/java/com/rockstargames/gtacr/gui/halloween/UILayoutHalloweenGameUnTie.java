package com.rockstargames.gtacr.gui.halloween;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UILayout;
import org.json.JSONObject;

public class UILayoutHalloweenGameUnTie extends UILayout {
    private GUIHalloweenGame mRoot;
    private View mViewRoot = null;
    private ProgressBar mProgressBar = null;
    private TextView mProgress = null;
    private TextView mInfo = null;
    private Handler mHandler = null;
    private int maxValue = 100;
    private int currentStatus = 0;
    private int tick = 10;
    private int timer = 50;
    private Boolean isEnded = false;
    private Boolean isClosed = false;

    public UILayoutHalloweenGameUnTie(GUIHalloweenGame root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.halloween_game_untie, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mProgressBar = (ProgressBar) inflate.findViewById(R.id.progressBar);
        this.mProgress = (TextView) this.mViewRoot.findViewById(R.id.progress);
        this.mInfo = (TextView) this.mViewRoot.findViewById(R.id.info);
        this.maxValue = 100;
        this.currentStatus = 0;
        this.tick = 10;
        this.timer = 50;
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        initStartData(this.mRoot.getJson());
        startProgressBar();
    }

    private void initStartData(JSONObject mainJson) {
        if (mainJson.optInt("p_max") != 0) {
            this.maxValue = mainJson.optInt("p_max");
        }
        if (mainJson.optInt("p_tick") != 0) {
            this.tick = mainJson.optInt("p_tick");
        }
        if (mainJson.optInt("p_timer") != 0) {
            this.timer = mainJson.optInt("p_timer");
        }
        this.mProgressBar.setMax(this.maxValue);
        this.mProgressBar.setProgress(this.currentStatus);
        this.mProgress.setText(getContext().getString(R.string.percent, Integer.valueOf(this.mProgressBar.getProgress())));
        this.mInfo.setText(mainJson.optString("p_title"));
    }

    private void startProgressBar() {
        this.mHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public final void run() {
                UILayoutHalloweenGameUnTie.this.lambda$startProgressBar$1$UILayoutHalloweenGameUnTie();
            }
        }).start();
    }

    public void lambda$startProgressBar$1$UILayoutHalloweenGameUnTie() {
        while (this.currentStatus < this.maxValue && !this.isClosed.booleanValue()) {
            this.currentStatus += this.tick;
            SystemClock.sleep(this.timer);
            this.mHandler.post(new Runnable() {
                @Override
                public final void run() {
                    UILayoutHalloweenGameUnTie.this.lambda$null$0$UILayoutHalloweenGameUnTie();
                }
            });
        }
    }

    public void lambda$null$0$UILayoutHalloweenGameUnTie() {
        int min = Math.min(this.currentStatus, this.maxValue);
        this.mProgressBar.setProgress(min);
        this.mProgress.setText(getContext().getString(R.string.percent, Integer.valueOf(min)));
        if (this.currentStatus >= this.maxValue) {
            onProgressEnd();
            this.isEnded = true;
        }
    }

    @Override
    public void onLayoutClose() {
        this.isClosed = true;
    }

    public void onProgressEnd() {
        if (this.isEnded.booleanValue()) {
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutHalloweenGameUnTie.this.lambda$onProgressEnd$2$UILayoutHalloweenGameUnTie();
            }
        }, this.timer);
    }

    public void lambda$onProgressEnd$2$UILayoutHalloweenGameUnTie() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", 1);
            this.mRoot.close(jSONObject);
        } catch (Exception unused) {
        }
    }
}
