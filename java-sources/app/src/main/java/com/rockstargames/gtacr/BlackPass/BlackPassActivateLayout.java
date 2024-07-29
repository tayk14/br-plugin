package com.rockstargames.gtacr.BlackPass;

import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class BlackPassActivateLayout {
    private int BuyPrice;
    private Animation anim;
    private Button mBuy;
    private Button mBuyPremium;
    private NvEventQueueActivity mContext;
    private GUIManager mGUIManager;
    private boolean mIsStock;
    private BrBlackPass mParent;
    private int mPremiumPrice;
    private int mPrice;
    private View mRootView;

    public BlackPassActivateLayout(final BrBlackPass blackPass, View view, NvEventQueueActivity activity, GUIManager manager) {
        this.mContext = null;
        this.anim = null;
        this.mRootView = view;
        this.mContext = activity;
        this.mGUIManager = manager;
        this.mParent = blackPass;
        this.anim = blackPass.anim;
        this.mBuy = (Button) this.mRootView.findViewById(R.id.bp_act_buy);
        this.mBuyPremium = (Button) this.mRootView.findViewById(R.id.bp_act_premium_buy);
        ((TextView) this.mRootView.findViewById(R.id.bp_act_text1)).setText(Html.fromHtml("Пакет <font color='#FFBA08'>Premium</font>"));
        ((TextView) this.mRootView.findViewById(R.id.bp_act_text4)).setText(Html.fromHtml("Все преимущества из <font color='#FFBA08'>BLACK PASS PREMIUM</font>"));
        this.mBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                view2.startAnimation(blackPass.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassActivateLayout.this.BuyPrice = BlackPassActivateLayout.this.mPrice;
                        BlackPassActivateLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                        BlackPassActivateLayout.this.createAcceptWindow(1);
                    }
                }, 250L);
            }
        });
        this.mBuyPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                view2.startAnimation(blackPass.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassActivateLayout.this.BuyPrice = BlackPassActivateLayout.this.mPremiumPrice;
                        BlackPassActivateLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                        BlackPassActivateLayout.this.createAcceptWindow(0);
                    }
                }, 250L);
            }
        });
        ((Button) this.mRootView.findViewById(R.id.bp_act_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                view2.startAnimation(blackPass.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassActivateLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_back_sfx");
                        blackPass.EnableActivateLayout(false);
                    }
                }, 250L);
            }
        });
    }

    public void createAcceptWindow(final int ID) {
        this.mParent.showConfirmationDialog(this.BuyPrice, "Подтверждение", "приобрести данный премиум", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackPassActivateLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(BlackPassActivateLayout.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("ty", 1);
                            jSONObject.put("la", 4);
                            jSONObject.put(GetKeys.GET_PLAYERS_ID, ID);
                            BlackPassActivateLayout.this.mGUIManager.sendJsonData(22, jSONObject);
                        } catch (Exception unused) {
                        }
                        BlackPassActivateLayout.this.mParent.closeDialog();
                    }
                }, 250L);
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackPassActivateLayout.this.mParent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(BlackPassActivateLayout.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassActivateLayout.this.mParent.closeDialog();
                    }
                }, 250L);
            }
        });
    }

    public void onJsonDataIncoming(JSONObject json) {
        try {
            int i = json.getInt("ty");
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                if (json.getInt("s") != 0) {
                    this.mParent.ActivePremium = true;
                    this.mParent.UpdatePassPremium();
                    this.mParent.EnableActivateLayout(false);
                    return;
                }
                this.mParent.mGUID.BuyCoinsDialog(this.BuyPrice);
                return;
            }
            this.mPrice = json.getInt(TuningConstants.KEY_GET_ID_DETAIL);
            this.mPremiumPrice = json.getInt("pp");
            this.mBuy.setText(String.format("%,.0f BC", Float.valueOf(this.mPrice)));
            this.mBuyPremium.setText(String.format("%,.0f BC", Float.valueOf(this.mPremiumPrice)));
            boolean z = json.getInt("a") != 0;
            this.mIsStock = z;
            if (z) {
                this.mRootView.findViewById(R.id.bp_act_text5).setVisibility(0);
                this.mRootView.findViewById(R.id.bp_act_text3).setVisibility(8);
                this.mRootView.findViewById(R.id.bp_act_text8).setVisibility(0);
                this.mRootView.findViewById(R.id.bp_act_text6).setVisibility(0);
                this.mRootView.findViewById(R.id.bp_act_text7).setVisibility(0);
                ((TextView) this.mRootView.findViewById(R.id.bp_act_text6)).setPaintFlags(((TextView) this.mRootView.findViewById(R.id.bp_act_text6)).getPaintFlags() | 16);
                ((TextView) this.mRootView.findViewById(R.id.bp_act_text8)).setText("+" + json.getInt("s") + "% выгода");
                ((TextView) this.mRootView.findViewById(R.id.bp_act_text6)).setText(String.format("%,.0f BC", Float.valueOf((float) json.getInt("op"))));
                ((TextView) this.mRootView.findViewById(R.id.bp_act_text7)).setText(Html.fromHtml("До конца предложения <font color='#FFBA08'>" + (json.getInt("th") / 3600) + " ч. " + ((json.getInt("th") % 3600) / 60) + " м.</font>"));
            } else {
                this.mRootView.findViewById(R.id.bp_act_text5).setVisibility(8);
                this.mRootView.findViewById(R.id.bp_act_text3).setVisibility(0);
                this.mRootView.findViewById(R.id.bp_act_text8).setVisibility(4);
                this.mRootView.findViewById(R.id.bp_act_text6).setVisibility(8);
                this.mRootView.findViewById(R.id.bp_act_text7).setVisibility(4);
            }
            this.mRootView.findViewById(R.id.bp_act_premium_buy).setVisibility(0);
            this.mRootView.findViewById(R.id.bp_act_buy).setVisibility(0);
        } catch (Exception unused) {
        }
    }
}
