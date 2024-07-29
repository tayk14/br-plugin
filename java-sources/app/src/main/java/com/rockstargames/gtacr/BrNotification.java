package com.rockstargames.gtacr;

import android.os.Build;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import blackrussia.online.App;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrNotification implements ISAMPGUI {
    public static final int MAX_NOTIFICATIONS = 4;
    public static final int TYPE_BUTTON_TEXT_ORANGE = 5;
    public static final int TYPE_BUTTON_VECTOR_ORANGE = 4;
    public static final int TYPE_MONEY_GREEN = 1;
    public static final int TYPE_MONEY_RED = 0;
    public static final int TYPE_NEW_GUI_INTERACTIVE = 6;
    public static final int TYPE_TEXT_GREEN = 3;
    public static final int TYPE_TEXT_RED = 2;
    public static int mActiveNotifications = 0;
    public static boolean mHiddenAll = false;
    public static BrNotification[] mNotifications;
    public static LinkedList<BrNotification> mQueuedNotifications;
    private GUIManager mManager = null;
    private PopupWindow mWindow = null;
    private NvEventQueueActivity mActivity = null;
    private View mView = null;
    private int mId = -1;
    public int mSubid = -1;
    private int mDuration = -1;
    private CountDownTimer mTimer = null;
    private ProgressBar mProgressBar = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 13;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrNotification();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mManager = manager;
        this.mActivity = activity;
        if (mNotifications == null) {
            mQueuedNotifications = new LinkedList<>();
            mNotifications = new BrNotification[4];
            for (int i = 0; i < 4; i++) {
                mNotifications[i] = null;
            }
        }
        if (this.mWindow == null) {
            this.mView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_notification, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mView, -2, NvEventQueueActivity.dpToPx(50.0f, this.mActivity), true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimationNotification);
            this.mWindow.setSoftInputMode(16);
        }
        int optInt = json.optInt("t");
        String optString = json.optString("i");
        int optInt2 = json.optInt("d");
        int optInt3 = json.optInt("s");
        int optInt4 = json.optInt("b");
        String optString2 = json.optString(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS);
        if (optString2.equalsIgnoreCase("")) {
            optString2 = "Продолжить";
        }
        this.mDuration = optInt2;
        this.mId = optInt3;
        this.mSubid = optInt4;
        Button button = (Button) this.mView.findViewById(R.id.br_not_button);
        View findViewById = this.mView.findViewById(R.id.br_not_view);
        TextView textView = (TextView) this.mView.findViewById(R.id.br_not_ruble);
        TextView textView2 = (TextView) this.mView.findViewById(R.id.br_not_text);
        final ProgressBar progressBar = (ProgressBar) this.mView.findViewById(R.id.br_not_progress);
        this.mProgressBar = progressBar;
        int i2 = this.mDuration;
        if (i2 != -1) {
            progressBar.setMax(i2 * 1000);
            progressBar.setProgress(this.mDuration * 1000);
        }
        switch (optInt) {
            case 0:
                button.setVisibility(8);
                textView.setVisibility(0);
                findViewById.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.background_br_notification_red));
                break;
            case 1:
                button.setVisibility(8);
                textView.setVisibility(0);
                findViewById.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.background_br_notification_green));
                break;
            case 2:
                button.setVisibility(8);
                textView.setVisibility(8);
                findViewById.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.background_br_notification_red));
                break;
            case 3:
                button.setVisibility(8);
                textView.setVisibility(8);
                findViewById.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.background_br_notification_green));
                break;
            case 4:
                button.setVisibility(0);
                textView.setVisibility(8);
                findViewById.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.background_br_notification_orange));
                button.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.button_red_square_vector));
                button.setText("");
                break;
            case 5:
                button.setVisibility(0);
                textView.setVisibility(8);
                findViewById.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.background_br_notification_orange));
                button.setBackground(ContextCompat.getDrawable(this.mActivity, R.drawable.button_red_square));
                if (optString2 != null) {
                    button.setText(GUIManager.transfromColors(optString2));
                    button.setWidth(GUIManager.getTextLength(button) + NvEventQueueActivity.dpToPx(26.0f, this.mActivity));
                    break;
                }
                break;
            case 6:
                close(6);
                return;
        }
        if (optInt == 5 || optInt == 4) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrNotification.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(BrNotification.this.mActivity, R.anim.button_click));
                    BrNotification.this.mView.postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrNotification.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrNotification.this.close(0);
                        }
                    }, 100L);
                }
            });
        }
        ((LinearLayout) this.mView.findViewById(R.id.dw_root)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrNotification.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(BrNotification.this.mActivity, R.anim.button_click));
                BrNotification.this.mView.postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrNotification.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrNotification.this.close(1);
                    }
                }, 100L);
            }
        });
        if (optString != null) {
            textView2.setText(GUIManager.transfromColors(optString));
        }
        this.mWindow.setTouchable(true);
        this.mWindow.setFocusable(false);
        this.mWindow.setOutsideTouchable(false);
        mActiveNotifications++;
        int firstFreeSlot = getFirstFreeSlot();
        if (firstFreeSlot == -1) {
            mQueuedNotifications.push(this);
            return;
        }
        progressBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rockstargames.gtacr.BrNotification.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                progressBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BrNotification.this.startCountdown();
            }
        });
        int yPosForNotification = getYPosForNotification(firstFreeSlot);
        mNotifications[firstFreeSlot] = this;
        this.mWindow.showAtLocation(activity.getParentLayout(), 81, 0, yPosForNotification);
    }

    public void startCountdown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        if (this.mDuration == -1) {
            return;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(this.mProgressBar.getProgress(), 100L) { // from class: com.rockstargames.gtacr.BrNotification.4
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                if (Build.VERSION.SDK_INT >= 24) {
                    BrNotification.this.mProgressBar.setProgress((int) millisUntilFinished, true);
                } else {
                    BrNotification.this.mProgressBar.setProgress((int) millisUntilFinished);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BrNotification.this.mProgressBar.setProgress(0);
                BrNotification.this.close(1);
            }
        };
        this.mTimer = countDownTimer2;
        countDownTimer2.start();
    }

    public static void closeNotificationById(int id) {
        if (mNotifications == null) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            BrNotification[] brNotificationArr = mNotifications;
            if (brNotificationArr[id] != null && brNotificationArr[id].mSubid == id) {
                brNotificationArr[id].close(2);
                mNotifications[id] = null;
            }
        }
    }

    public static void hideAllNotifications() {
        for (int i = 0; i < 4; i++) {
            BrNotification[] brNotificationArr = mNotifications;
            if (brNotificationArr[i] != null) {
                if (brNotificationArr[i].mTimer != null) {
                    brNotificationArr[i].mTimer.cancel();
                }
                mNotifications[i].mWindow.dismiss();
            }
        }
        mHiddenAll = true;
    }

    public static void resumeNotifications() {
        for (int i = 0; i < 4; i++) {
            BrNotification[] brNotificationArr = mNotifications;
            if (brNotificationArr[i] != null) {
                brNotificationArr[i].mWindow.showAtLocation(brNotificationArr[i].mActivity.getParentLayout(), 81, 0, mNotifications[i].getYPosForNotification(i));
            }
        }
        for (int i2 = 0; i2 < 4; i2++) {
            BrNotification[] brNotificationArr2 = mNotifications;
            if (brNotificationArr2[i2] != null) {
                brNotificationArr2[i2].startCountdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(int t) {
        JSONObject jSONObject = new JSONObject();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (t == 6) {
            try {
                jSONObject.put("d", 1);
                jSONObject.put("t", App.getInput(this.mActivity));
                this.mManager.sendJsonData(13, jSONObject);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (this.mId != -1) {
            try {
                jSONObject.put(Const.FRACTION_CLOSE_KEY, 13);
                jSONObject.put("t", t);
                jSONObject.put("s", this.mId);
                jSONObject.put("b", this.mSubid);
                this.mManager.sendJsonData(13, jSONObject);
            } catch (Exception unused2) {
            }
        }
        close((JSONObject) null);
    }

    int getFirstFreeSlot() {
        int i = 0;
        while (true) {
            BrNotification[] brNotificationArr = mNotifications;
            if (i >= brNotificationArr.length) {
                return -1;
            }
            if (brNotificationArr[i] == null) {
                return i;
            }
            i++;
        }
    }

    int getYPosForNotification(int id) {
        return (NvEventQueueActivity.dpToPx(50.0f, this.mActivity) * id) + ((id + 1) * NvEventQueueActivity.dpToPx(10.0f, this.mActivity));
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        BrNotification[] brNotificationArr;
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        int i = 0;
        while (true) {
            BrNotification[] brNotificationArr2 = mNotifications;
            if (i >= brNotificationArr2.length) {
                i = -1;
                break;
            } else {
                if (brNotificationArr2[i] == this) {
                    brNotificationArr2[i] = null;
                    break;
                }
                i++;
            }
        }
        if (i != -1) {
            while (true) {
                brNotificationArr = mNotifications;
                if (i >= brNotificationArr.length - 1) {
                    break;
                }
                int i2 = i + 1;
                brNotificationArr[i] = brNotificationArr[i2];
                i = i2;
            }
            brNotificationArr[brNotificationArr.length - 1] = null;
            if (mQueuedNotifications.size() > 0) {
                mNotifications[brNotificationArr.length - 1] = mQueuedNotifications.getFirst();
                mQueuedNotifications.removeFirst();
                BrNotification brNotification = mNotifications[brNotificationArr.length - 1];
                brNotification.mWindow.showAtLocation(brNotification.mActivity.getParentLayout(), 81, 0, brNotification.getYPosForNotification(mNotifications.length - 1));
                brNotification.startCountdown();
            }
        }
        int i3 = 0;
        while (true) {
            BrNotification[] brNotificationArr3 = mNotifications;
            if (i3 < brNotificationArr3.length) {
                if (brNotificationArr3[i3] != null) {
                    brNotificationArr3[i3].mWindow.update(0, getYPosForNotification(i3), -1, -1);
                }
                i3++;
            } else {
                mActiveNotifications--;
                return;
            }
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow == null) {
            return false;
        }
        if (mActiveNotifications > 0) {
            return true;
        }
        return popupWindow.isShowing();
    }
}
