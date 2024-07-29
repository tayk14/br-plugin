package com.rockstargames.gtacr;

import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogTaxi implements ISAMPGUI {
    private ImageView mComm;
    private TextView mComment;
    private TextView mDist;
    private TextView mEndPoint;
    private GUIManager mGUIManager;
    private boolean mHasComment;
    private TextView mPrice;
    private TextView mStartPoint;
    private TextView mTime;
    private TextView mType;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mWindow = null;
    private PopupWindow mCommentWindow = null;
    private View mRootView = null;
    private Animation anim = null;
    private boolean mClosed = true;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 16;
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogTaxi();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, final NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
            this.mRootView = layoutInflater.inflate(R.layout.br_taxi, (ViewGroup) null, false);
            View inflate = layoutInflater.inflate(R.layout.br_taxi_comment, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, -1, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            PopupWindow popupWindow2 = new PopupWindow(inflate, -2, -2, true);
            this.mCommentWindow = popupWindow2;
            popupWindow2.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mCommentWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mCommentWindow);
            this.mComment = (TextView) inflate.findViewById(R.id.br_taxi_comment_comm);
            inflate.findViewById(R.id.br_taxi_comment_close).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.startAnimation(BrDialogTaxi.this.anim);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxi.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrDialogTaxi.this.mCommentWindow.dismiss();
                        }
                    }, 400L);
                    return true;
                }
            });
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BrDialogTaxi.this.mClosed) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            BrDialogTaxi.this.mGUIManager.sendJsonData(16, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    BrDialogTaxi.this.mCommentWindow.dismiss();
                    BrDialogTaxi.this.mGUIManager.closeGUI(null, 16);
                }
            });
        }
        this.mContext = activity;
        this.anim = AnimationUtils.loadAnimation(activity, R.anim.button_click);
        this.mRootView.findViewById(R.id.br_taxi_close).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogTaxi.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxi.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrDialogTaxi.this.mWindow.dismiss();
                    }
                }, 400L);
            }
        });
        this.mRootView.findViewById(R.id.br_taxi_next).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogTaxi.this.anim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 0);
                    jSONObject.put("b", 0);
                    BrDialogTaxi.this.mGUIManager.sendJsonData(16, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mRootView.findViewById(R.id.br_taxi_prev).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogTaxi.this.anim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 0);
                    jSONObject.put("b", 1);
                    BrDialogTaxi.this.mGUIManager.sendJsonData(16, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mRootView.findViewById(R.id.br_taxi_accept).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogTaxi.this.anim);
                BrDialogTaxi.this.mClosed = false;
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxi.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", 0);
                            jSONObject.put("b", 2);
                            BrDialogTaxi.this.mGUIManager.sendJsonData(16, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        BrDialogTaxi.this.mWindow.dismiss();
                    }
                }, 400L);
            }
        });
        this.mRootView.findViewById(R.id.br_taxi_comm).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BrDialogTaxi.this.mHasComment) {
                    view.startAnimation(BrDialogTaxi.this.anim);
                    BrDialogTaxi.this.mCommentWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
                }
            }
        });
        try {
            ((TextView) this.mRootView.findViewById(R.id.br_taxi_mark)).setText("" + json.getDouble(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL));
            ((TextView) this.mRootView.findViewById(R.id.br_taxi_num)).setText("Выполнено поездок за сегодня: " + json.getInt("n"));
            ((TextView) this.mRootView.findViewById(R.id.br_taxi_cash)).setText("Доход за сегодня: " + json.getInt("m") + " ₽");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mStartPoint = (TextView) this.mRootView.findViewById(R.id.br_taxi_start);
        this.mEndPoint = (TextView) this.mRootView.findViewById(R.id.br_taxi_end);
        this.mPrice = (TextView) this.mRootView.findViewById(R.id.br_taxi_price);
        this.mDist = (TextView) this.mRootView.findViewById(R.id.br_taxi_dist);
        this.mTime = (TextView) this.mRootView.findViewById(R.id.br_taxi_time);
        this.mType = (TextView) this.mRootView.findViewById(R.id.br_taxi_type_text);
        this.mComm = (ImageView) this.mRootView.findViewById(R.id.br_taxi_comm);
        this.mStartPoint.setText(Html.fromHtml("<font color='#F75514'>Начальная точка:</font>"));
        this.mEndPoint.setText(Html.fromHtml("<font color='#F75514'>Конечная точка:</font>"));
        this.mDist.setText(Html.fromHtml("<font color='#F75514'>Расстояние между точками:</font>"));
        this.mTime.setText(Html.fromHtml("<font color='#F75514'>Приблизительно время на поездку:</font>"));
        this.mPrice.setText("");
        this.mHasComment = false;
        this.mComm.setImageResource(R.drawable.br_taxi_comment);
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        try {
            if (json.getInt("t") == 0) {
                this.mStartPoint.setText(Html.fromHtml("<font color='#F75514'>Начальная точка: </font>" + json.getString("s")));
                this.mEndPoint.setText(Html.fromHtml("<font color='#F75514'>Конечная точка: </font>" + json.getString("e")));
                this.mDist.setText(Html.fromHtml("<font color='#F75514'>Расстояние между точками: </font>" + json.getDouble("d") + " км"));
                this.mTime.setText(Html.fromHtml("<font color='#F75514'>Приблизительно время на поездку: </font>" + json.getString("ti")));
                this.mPrice.setText(Html.fromHtml("" + String.format("%,.0f ₽", Float.valueOf(json.getInt("m")))));
                this.mType.setText(json.getString("ty"));
                this.mType.setVisibility(0);
                if (json.getString(TuningConstants.KEY_SEND_COLOR_FOR_PREVIEW) != "") {
                    this.mHasComment = true;
                    this.mComm.setImageResource(R.drawable.br_taxi_acomment);
                    this.mComment.setText(json.getString(TuningConstants.KEY_SEND_COLOR_FOR_PREVIEW));
                } else {
                    this.mHasComment = false;
                    this.mComm.setImageResource(R.drawable.br_taxi_comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
