package com.rockstargames.gtacr.BlackPass;

import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import org.json.JSONObject;

public class BlackPassMarathonLayout {
    private Animation anim;
    private BlackPassMarathonAdapter mAdapter;
    private NvEventQueueActivity mContext;
    private GUIManager mGUIManager;
    private BrBlackPass mParent;
    private RecyclerView mRV;
    private View mRootView;

    public BlackPassMarathonLayout(BrBlackPass blackPass, View view, NvEventQueueActivity activity, GUIManager manager) {
        this.mContext = null;
        this.anim = null;
        this.mRootView = view;
        this.mContext = activity;
        this.mGUIManager = manager;
        this.mParent = blackPass;
        this.anim = blackPass.anim;
    }

    public void onJsonDataIncoming(JSONObject json) {
        try {
            int i = json.getInt("ty");
            if (i != 0) {
                if (i != 2) {
                    return;
                }
                this.mAdapter.IsAwardActive = false;
                BlackPassMarathonAdapter blackPassMarathonAdapter = this.mAdapter;
                blackPassMarathonAdapter.notifyItemChanged(blackPassMarathonAdapter.CurrLevel - 1);
                return;
            }
            ((TextView) this.mRootView.findViewById(R.id.bp_marathon_time)).setText("" + (json.getInt("tm") / 3600) + " ч. " + ((json.getInt("tm") % 3600) / 60) + " м.");
            StringBuilder sb = new StringBuilder();
            sb.append("Заданий выполнено сегодня: ");
            sb.append(json.getInt("tc"));
            sb.append(" из 5");
            ((TextView) this.mRootView.findViewById(R.id.bp_marathon_tasks)).setText(sb.toString());
            ((TextView) this.mRootView.findViewById(R.id.bp_marathon_period)).setText("До конца марафона осталось: " + (json.getInt("mtd") / 86400) + " дней");
            if (this.mAdapter != null) {
                this.mAdapter = null;
            }
            RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(R.id.bp_marathon_RV);
            this.mRV = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
            BlackPassMarathonAdapter blackPassMarathonAdapter2 = new BlackPassMarathonAdapter(json, this.mParent);
            this.mAdapter = blackPassMarathonAdapter2;
            this.mRV.setAdapter(blackPassMarathonAdapter2);
        } catch (Exception unused) {
        }
    }
}
