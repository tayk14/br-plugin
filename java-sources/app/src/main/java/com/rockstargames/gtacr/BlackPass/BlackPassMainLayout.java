package com.rockstargames.gtacr.BlackPass;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import org.json.JSONObject;

public class BlackPassMainLayout {
    private Animation anim;
    private Button mActButt;
    private LinearLayout mActiveCheck;
    public BlackPassLevelsAdapter mAdapter;
    private NvEventQueueActivity mContext;
    private GUIManager mGUIManager;
    private RecyclerView mLevelsRV;
    private BrBlackPass mParent;
    private BlackPassPricesAdapter mPricesAdapters;
    private RecyclerView mRV;
    private View mRootView;

    public BlackPassMainLayout(final BrBlackPass blackPass, View view, NvEventQueueActivity activity, GUIManager manager) {
        this.anim = null;
        this.mRootView = view;
        this.mContext = activity;
        this.mParent = blackPass;
        this.mGUIManager = manager;
        this.anim = AnimationUtils.loadAnimation(activity, R.anim.button_click);
        this.mActiveCheck = (LinearLayout) this.mRootView.findViewById(R.id.bp_pass_act);
        Button button = (Button) this.mRootView.findViewById(R.id.bp_pass_premium_butt);
        this.mActButt = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                BlackPassMainLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                view2.startAnimation(BlackPassMainLayout.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blackPass.EnableActivateLayout(true);
                    }
                }, 250L);
            }
        });
    }

    public void UpdateLevel() {
        if (this.mParent.ActivePremium) {
            this.mAdapter.IsAwardActivePremium = true;
        } else {
            this.mAdapter.IsAwardActivePremium = false;
        }
        this.mAdapter.IsAwardActive = true;
        for (int i = this.mParent.Level - 1; i >= 0; i--) {
            this.mAdapter.notifyItemChanged(i);
        }
        this.mPricesAdapters.notifyItemChanged(0);
        this.mPricesAdapters.notifyItemChanged(1);
    }

    public void onJsonDataIncoming(JSONObject json) {
        int i;
        try {
            i = json.getInt("ty");
            try {
                if (i == 1) {
                    if (json.getInt("s") == 0) {
                        this.mParent.mGUID.BuyCoinsDialog(App.getInstance().getBlackPassItems().getLevelPrices());
                    } else {
                        this.mAdapter.IsAwardActivePremium = true;
                        this.mAdapter.IsAwardActive = true;
                        this.mParent.Level++;
                        this.mAdapter.notifyItemChanged(this.mParent.Level - 2);
                        this.mAdapter.notifyItemChanged(this.mParent.Level - 1);
                        this.mPricesAdapters.notifyItemChanged(0);
                        this.mPricesAdapters.notifyItemChanged(1);
                        ((TextView) this.mParent.mRootView.findViewById(R.id.br_bp_level)).setText("" + this.mParent.Level);
                        ((TextView) this.mParent.mRootView.findViewById(R.id.br_bp_exp)).setText("0 из 1 500 очков");
                    }
                } else if (i == 2) {
                    if (this.mAdapter.IsStandardTaken) {
                        this.mAdapter.IsAwardActive = false;
                    } else {
                        this.mAdapter.IsAwardActivePremium = false;
                    }
                    this.mAdapter.notifyItemChanged(this.mParent.Level - 1);
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 0;
        }
        if (!this.mParent.ActivePremium) {
            this.mActiveCheck.setVisibility(4);
            this.mActButt.setVisibility(0);
        } else {
            this.mActiveCheck.setVisibility(0);
            this.mActButt.setVisibility(4);
        }
        if (i == 0 || i == -1) {
            if (this.mAdapter != null) {
                this.mAdapter = null;
            }
            RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(R.id.bp_pass_RV);
            this.mRV = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
            BlackPassLevelsAdapter blackPassLevelsAdapter = new BlackPassLevelsAdapter(json, this.mParent);
            this.mAdapter = blackPassLevelsAdapter;
            this.mRV.setAdapter(blackPassLevelsAdapter);
            this.mRV.clearOnScrollListeners();
            if (this.mPricesAdapters != null) {
                this.mPricesAdapters = null;
            }
            RecyclerView recyclerView2 = (RecyclerView) this.mRootView.findViewById(R.id.bp_pass_levelprice_RV);
            this.mLevelsRV = recyclerView2;
            recyclerView2.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
            BlackPassPricesAdapter blackPassPricesAdapter = new BlackPassPricesAdapter(this.mParent);
            this.mPricesAdapters = blackPassPricesAdapter;
            this.mLevelsRV.setAdapter(blackPassPricesAdapter);
            this.mLevelsRV.clearOnScrollListeners();
            final RecyclerView.OnScrollListener[] onScrollListenerArr = {new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                    super.onScrolled(recyclerView3, dx, dy);
                    //BlackPassMainLayout.this.mRV.removeOnScrollListener(onScrollListenerArr[1]);
                    BlackPassMainLayout.this.mRV.scrollBy(dx, dy);
                    //BlackPassMainLayout.this.mRV.addOnScrollListener(onScrollListenerArr[1]);
                }
            }, new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                    super.onScrolled(recyclerView3, dx, dy);
                    //BlackPassMainLayout.this.mLevelsRV.removeOnScrollListener(onScrollListenerArr[0]);
                    BlackPassMainLayout.this.mLevelsRV.scrollBy(dx, dy);
                    //BlackPassMainLayout.this.mLevelsRV.addOnScrollListener(onScrollListenerArr[0]);
                }
            }};
            this.mLevelsRV.addOnScrollListener(onScrollListenerArr[0]);
            this.mRV.addOnScrollListener(onScrollListenerArr[1]);
        }
    }
}
