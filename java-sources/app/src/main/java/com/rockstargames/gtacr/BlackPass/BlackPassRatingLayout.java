package com.rockstargames.gtacr.BlackPass;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class BlackPassRatingLayout {
    private Animation anim;
    private BlackPassRatingAdapter mAdapter;
    private NvEventQueueActivity mContext;
    private GUIManager mGUIManager;
    private BrBlackPass mParent;
    private RecyclerView mRV;
    private View mRootView;

    public BlackPassRatingLayout(BrBlackPass blackPass, View view, NvEventQueueActivity activity, GUIManager manager) {
        this.mContext = null;
        this.anim = null;
        this.mRootView = view;
        this.mContext = activity;
        this.mGUIManager = manager;
        this.mParent = blackPass;
        this.anim = blackPass.anim;
        ((Button) this.mRootView.findViewById(R.id.bp_rating_butt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                view2.startAnimation(BlackPassRatingLayout.this.anim);
                BlackPassRatingLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("ty", 1);
                            jSONObject.put(GetKeys.GET_PLAYERS_ID, 0);
                            jSONObject.put("la", 3);
                            BlackPassRatingLayout.this.mGUIManager.sendJsonData(22, jSONObject);
                        } catch (Exception unused) {
                        }
                    }
                }, 250L);
            }
        });
        this.mRootView.findViewById(R.id.bp_rating_frame).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                BlackPassRatingLayout.this.AlignStuff();
            }
        });
    }

    public void AlignStuff() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((ImageView) this.mRootView.findViewById(R.id.bp_rating_img)).getLayoutParams();
        layoutParams.height = layoutParams.width;
    }

    public void onJsonDataIncoming(JSONObject json) {
        try {
            ((TextView) this.mRootView.findViewById(R.id.bp_rating_order)).setText("" + json.getInt(TuningConstants.KEY_GET_ID_DETAIL) + " место");
            if (json.getInt("ty") != 0) {
                return;
            }
        } catch (Exception unused) {
        }
        if (this.mAdapter != null) {
            this.mAdapter = null;
        }
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(R.id.bp_rating_RV);
        this.mRV = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        BlackPassRatingAdapter blackPassRatingAdapter = new BlackPassRatingAdapter(json);
        this.mAdapter = blackPassRatingAdapter;
        this.mRV.setAdapter(blackPassRatingAdapter);
    }
}
