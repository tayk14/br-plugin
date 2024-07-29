package com.rockstargames.gtacr;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import androidx.core.content.ContextCompat;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogTaxiRating implements ISAMPGUI {
    private GUIManager mGUIManager;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mWindow = null;
    private View mRootView = null;
    private Animation anim = null;
    private int mActivePrice = -1;
    private boolean mClosed = true;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 18;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogTaxiRating();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            this.mRootView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_taxi_rating, (ViewGroup) null, false);
            this.mContext = activity;
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -2, -2, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiRating.1
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BrDialogTaxiRating.this.mClosed) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            BrDialogTaxiRating.this.mGUIManager.sendJsonData(18, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    BrDialogTaxiRating.this.mGUIManager.closeGUI(null, 18);
                }
            });
            this.mContext = activity;
            this.anim = AnimationUtils.loadAnimation(activity, R.anim.button_click);
            final Button[] buttonArr = {(Button) this.mRootView.findViewById(R.id.br_taxi_butt0), (Button) this.mRootView.findViewById(R.id.br_taxi_butt1), (Button) this.mRootView.findViewById(R.id.br_taxi_butt2)};
            final Button button = (Button) this.mRootView.findViewById(R.id.br_taxi_butt3);
            final RatingBar ratingBar = (RatingBar) this.mRootView.findViewById(R.id.br_taxi_bar);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiRating.2
                @Override // android.widget.RatingBar.OnRatingBarChangeListener
                public void onRatingChanged(RatingBar ratingBar2, float v, boolean b) {
                    button.setAlpha(1.0f);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiRating.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getAlpha() < 1.0f) {
                        return;
                    }
                    view.startAnimation(BrDialogTaxiRating.this.anim);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiRating.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("t", 0);
                                jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, ratingBar.getRating());
                                jSONObject.put("m", BrDialogTaxiRating.this.mActivePrice);
                                BrDialogTaxiRating.this.mGUIManager.sendJsonData(18, jSONObject);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            BrDialogTaxiRating.this.mClosed = false;
                            BrDialogTaxiRating.this.mWindow.dismiss();
                        }
                    }, 400L);
                }
            });
            try {
                JSONArray jSONArray = json.getJSONArray(TuningConstants.KEY_GET_ID_DETAIL);
                for (int i = 0; i < 3; i++) {
                    buttonArr[i].setText("" + jSONArray.getInt(i) + "₽");
                    buttonArr[i].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiRating.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            view.startAnimation(BrDialogTaxiRating.this.anim);
                            int i2 = 0;
                            if (BrDialogTaxiRating.this.mActivePrice != -1) {
                                buttonArr[BrDialogTaxiRating.this.mActivePrice].setBackground(ContextCompat.getDrawable(BrDialogTaxiRating.this.mContext, R.drawable.br_taxi_butt));
                                if (view != buttonArr[BrDialogTaxiRating.this.mActivePrice]) {
                                    view.setBackground(ContextCompat.getDrawable(BrDialogTaxiRating.this.mContext, R.drawable.br_taxi_butta));
                                    while (i2 < 3) {
                                        if (view == buttonArr[i2]) {
                                            BrDialogTaxiRating.this.mActivePrice = i2;
                                        }
                                        i2++;
                                    }
                                    return;
                                }
                                BrDialogTaxiRating.this.mActivePrice = -1;
                                return;
                            }
                            view.setBackground(ContextCompat.getDrawable(BrDialogTaxiRating.this.mContext, R.drawable.br_taxi_butta));
                            while (i2 < 3) {
                                if (view == buttonArr[i2]) {
                                    BrDialogTaxiRating.this.mActivePrice = i2;
                                }
                                i2++;
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
