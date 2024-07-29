package com.rockstargames.gtacr.BlackPass;

import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import org.json.JSONObject;

public class BlackPassTasksLayout {
    private Animation anim;
    private BlackPassTasksAdapter mAdapter;
    private NvEventQueueActivity mContext;
    private GUIManager mGUIManager;
    private BlackPassTasksAdapter mMarathonAdapter;
    private RecyclerView mMarathonRV;
    private BrBlackPass mParent;
    private RecyclerView mRV;
    private View mRootView;

    public BlackPassTasksLayout(BrBlackPass blackPass, View view, NvEventQueueActivity activity, GUIManager manager) {
        this.mContext = null;
        this.anim = null;
        this.mRootView = view;
        this.mContext = activity;
        this.mGUIManager = manager;
        this.mParent = blackPass;
        this.anim = blackPass.anim;
        BlackPassTasksAdapter.UpdatePos = -1;
    }

    public void onJsonDataIncoming(JSONObject json) {
        try {
            int i = json.getInt("ty");
            boolean z = true;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                if (json.getInt("s") == 0) {
                    this.mParent.mGUID.BuyCoinsDialog(10);
                } else if (BlackPassTasksAdapter.UpdatePos != -1) {
                    if (BlackPassTasksAdapter.UpdatePos < 5) {
                        this.mMarathonAdapter.tasksTypes.get(BlackPassTasksAdapter.UpdatePos).id = json.getInt("d");
                        this.mAdapter.tasksTypes.get(BlackPassTasksAdapter.UpdatePos).num = 0;
                        this.mMarathonAdapter.notifyItemChanged(BlackPassTasksAdapter.UpdatePos);
                    } else {
                        int i2 = BlackPassTasksAdapter.UpdatePos - 5;
                        if (i2 % 2 == 0) {
                            z = false;
                        }
                        int i3 = z ? (i2 / 2) + 5 : i2 / 2;
                        this.mAdapter.tasksTypes.get(i3).id = json.getInt("d");
                        this.mAdapter.tasksTypes.get(i3).num = 0;
                        this.mAdapter.notifyItemChanged(BlackPassTasksAdapter.UpdatePos - 5);
                    }
                }
                BlackPassTasksAdapter.UpdatePos = -1;
                return;
            }
            ((TextView) this.mRootView.findViewById(R.id.bp_tasks_time)).setText(Html.fromHtml("До обновления <font color='#FFBA08'>" + (json.getInt("tm") / 3600) + "ч. " + ((json.getInt("tm") % 3600) / 60) + "м.</font>"));
            if (this.mAdapter != null) {
                this.mAdapter = null;
            }
            RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(R.id.bp_tasks_RV);
            this.mRV = recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 2));
            BlackPassTasksAdapter blackPassTasksAdapter = new BlackPassTasksAdapter(json, this.mParent, false);
            this.mAdapter = blackPassTasksAdapter;
            this.mRV.setAdapter(blackPassTasksAdapter);
            if (this.mMarathonAdapter != null) {
                this.mMarathonAdapter = null;
            }
            RecyclerView recyclerView2 = (RecyclerView) this.mRootView.findViewById(R.id.bp_tasks_mRV);
            this.mMarathonRV = recyclerView2;
            recyclerView2.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
            BlackPassTasksAdapter blackPassTasksAdapter2 = new BlackPassTasksAdapter(json, this.mParent, true);
            this.mMarathonAdapter = blackPassTasksAdapter2;
            this.mMarathonRV.setAdapter(blackPassTasksAdapter2);
        } catch (Exception unused) {
        }
    }
}
