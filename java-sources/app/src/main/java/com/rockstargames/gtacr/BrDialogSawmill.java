package com.rockstargames.gtacr;

import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogSawmill implements ISAMPGUI {
    private static final int TYPE_NONE = 0;
    private static final int TYPE_READY = 1;
    private static final int TYPE_RIGHT = 2;
    private static final int TYPE_WRONG = 3;
    static boolean mClosed = false;
    private ProgressBar mBar;
    CountDownTimer mCountDownTimer;
    private GUIManager mGUIManager;
    private TextView mText;
    private int mTime;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mWindow = null;
    private View mRootView = null;
    private Animation anim = null;
    View[] Chunks = new View[18];
    int[] ChunksTypes = new int[18];
    int Mistakes = 0;
    int mResult = -1;
    int progress = 0;
    int PrevId = 0;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 23;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogSawmill();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        int nextInt;
        int[] iArr;
        this.mContext = activity;
        this.mGUIManager = manager;
        this.mContext = activity;
        if (this.mWindow == null) {
            this.mRootView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_sawmill, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, -1, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            GUIManager.hideSystemUI(this.mWindow.getContentView());
        }
        this.mTime = 20000;
        this.mBar = (ProgressBar) this.mRootView.findViewById(R.id.br_sawmill_progress);
        this.mText = (TextView) this.mRootView.findViewById(R.id.br_sawmill_text);
        this.Chunks[0] = this.mRootView.findViewById(R.id.br_sawmill_1);
        this.Chunks[1] = this.mRootView.findViewById(R.id.br_sawmill_2);
        this.Chunks[2] = this.mRootView.findViewById(R.id.br_sawmill_3);
        this.Chunks[3] = this.mRootView.findViewById(R.id.br_sawmill_4);
        this.Chunks[4] = this.mRootView.findViewById(R.id.br_sawmill_5);
        this.Chunks[5] = this.mRootView.findViewById(R.id.br_sawmill_6);
        this.Chunks[6] = this.mRootView.findViewById(R.id.br_sawmill_7);
        this.Chunks[7] = this.mRootView.findViewById(R.id.br_sawmill_8);
        this.Chunks[8] = this.mRootView.findViewById(R.id.br_sawmill_9);
        this.Chunks[9] = this.mRootView.findViewById(R.id.br_sawmill_10);
        this.Chunks[10] = this.mRootView.findViewById(R.id.br_sawmill_11);
        this.Chunks[11] = this.mRootView.findViewById(R.id.br_sawmill_12);
        this.Chunks[12] = this.mRootView.findViewById(R.id.br_sawmill_13);
        this.Chunks[13] = this.mRootView.findViewById(R.id.br_sawmill_14);
        this.Chunks[14] = this.mRootView.findViewById(R.id.br_sawmill_15);
        this.Chunks[15] = this.mRootView.findViewById(R.id.br_sawmill_16);
        this.Chunks[16] = this.mRootView.findViewById(R.id.br_sawmill_17);
        this.Chunks[17] = this.mRootView.findViewById(R.id.br_sawmill_18);
        this.mText.setText("0%");
        this.mBar.setProgress(0);
        for (int i = 0; i < 18; i++) {
            this.Chunks[i].setBackgroundColor(0);
        }
        Random random = new Random();
        for (int i2 = 0; i2 < 6; i2++) {
            while (true) {
                nextInt = random.nextInt(18);
                while (true) {
                    iArr = this.ChunksTypes;
                    if (iArr[nextInt] != 1) {
                        break;
                    } else {
                        nextInt = random.nextInt(18);
                    }
                }
                if (nextInt != 0 && nextInt != 17) {
                    if (iArr[nextInt - 1] != 1 && iArr[nextInt + 1] != 1) {
                        break;
                    }
                } else if (nextInt != 0 || iArr[nextInt + 1] != 1) {
                    if (nextInt == 17 && iArr[nextInt - 1] == 1) {
                    }
                }
            }
            iArr[nextInt] = 1;
        }
        for (int i3 = 0; i3 < 18; i3++) {
            if (this.ChunksTypes[i3] == 1) {
                this.Chunks[i3].setBackgroundColor(-1953524);
            }
        }
        new Handler().postDelayed(new AnonymousClass1(), 3000L);
        ((Button) this.mRootView.findViewById(R.id.br_sawmill_butt)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogSawmill.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int progress = ((int) ((BrDialogSawmill.this.mBar.getProgress() / BrDialogSawmill.this.mBar.getMax()) * 20.0f)) - 1;
                if (progress < 0 || progress >= 18) {
                    return;
                }
                view.startAnimation(AnimationUtils.loadAnimation(BrDialogSawmill.this.mContext, R.anim.button_click));
                view.setBackgroundResource(R.drawable.sawmill_abutt);
                if (BrDialogSawmill.this.ChunksTypes[progress] == 1) {
                    BrDialogSawmill.this.Chunks[progress].setBackgroundColor(-10625753);
                    BrDialogSawmill.this.ChunksTypes[progress] = 2;
                    return;
                }
                if (BrDialogSawmill.this.ChunksTypes[progress] == 0) {
                    for (int i4 = progress + 1; i4 < 18; i4++) {
                        if (BrDialogSawmill.this.ChunksTypes[i4] != 0) {
                            if (BrDialogSawmill.this.ChunksTypes[i4] == 1) {
                                BrDialogSawmill.this.ChunksTypes[i4] = 3;
                                BrDialogSawmill.this.Chunks[i4].setBackgroundColor(-8355712);
                                BrDialogSawmill.this.Mistakes++;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        });
        this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogSawmill.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                try {
                    if (BrDialogSawmill.this.mCountDownTimer != null) {
                        BrDialogSawmill.this.mCountDownTimer.cancel();
                    } else {
                        BrDialogSawmill.mClosed = true;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", 0);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, BrDialogSawmill.this.mResult);
                    BrDialogSawmill.this.mGUIManager.sendJsonData(23, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    /* renamed from: com.rockstargames.gtacr.BrDialogSawmill$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BrDialogSawmill.mClosed) {
                BrDialogSawmill.mClosed = false;
                return;
            }
            BrDialogSawmill.this.mCountDownTimer = new CountDownTimer(BrDialogSawmill.this.mTime, 10L) { // from class: com.rockstargames.gtacr.BrDialogSawmill.1.1
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        BrDialogSawmill.this.mBar.setProgress((int) ((((float) (BrDialogSawmill.this.mTime - millisUntilFinished)) / BrDialogSawmill.this.mTime) * BrDialogSawmill.this.mBar.getMax()), true);
                    } else {
                        BrDialogSawmill.this.mBar.setProgress((int) ((((float) (BrDialogSawmill.this.mTime - millisUntilFinished)) / BrDialogSawmill.this.mTime) * BrDialogSawmill.this.mBar.getMax()));
                    }
                    int progress = (int) ((BrDialogSawmill.this.mBar.getProgress() / BrDialogSawmill.this.mBar.getMax()) * 100.0f);
                    if (progress != BrDialogSawmill.this.progress) {
                        BrDialogSawmill.this.mText.setText("" + progress + "%");
                        BrDialogSawmill.this.progress = progress;
                    }
                    int progress2 = (int) ((BrDialogSawmill.this.mBar.getProgress() / BrDialogSawmill.this.mBar.getMax()) * 20.0f);
                    if (progress2 != BrDialogSawmill.this.PrevId) {
                        ((Button) BrDialogSawmill.this.mRootView.findViewById(R.id.br_sawmill_butt)).setBackgroundResource(R.drawable.sawmill_butt);
                        int i = progress2 - 1;
                        if (i < 0 || i >= 18) {
                            if (i > 0) {
                                int i2 = 17;
                                while (true) {
                                    if (i2 < 0) {
                                        break;
                                    }
                                    if (BrDialogSawmill.this.ChunksTypes[i2] == 0) {
                                        i2--;
                                    } else if (BrDialogSawmill.this.ChunksTypes[i2] == 1) {
                                        BrDialogSawmill.this.ChunksTypes[i2] = 3;
                                        BrDialogSawmill.this.Chunks[i2].setBackgroundColor(-8355712);
                                        BrDialogSawmill.this.Mistakes++;
                                    }
                                }
                            }
                        } else if (BrDialogSawmill.this.ChunksTypes[i] == 0) {
                            int i3 = i - 1;
                            while (true) {
                                if (i3 < 0) {
                                    break;
                                }
                                if (BrDialogSawmill.this.ChunksTypes[i3] == 0) {
                                    i3--;
                                } else if (BrDialogSawmill.this.ChunksTypes[i3] == 1) {
                                    BrDialogSawmill.this.ChunksTypes[i3] = 3;
                                    BrDialogSawmill.this.Chunks[i3].setBackgroundColor(-8355712);
                                    BrDialogSawmill.this.Mistakes++;
                                }
                            }
                        }
                        BrDialogSawmill.this.PrevId = progress2;
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    BrDialogSawmill.this.mBar.setProgress(BrDialogSawmill.this.mBar.getMax());
                    BrDialogSawmill.this.mText.setText("100%");
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogSawmill.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BrDialogSawmill.this.Mistakes > 2) {
                                BrDialogSawmill.this.mResult = 0;
                            } else {
                                BrDialogSawmill.this.mResult = 1;
                            }
                            BrDialogSawmill.this.mWindow.dismiss();
                        }
                    }, 1000L);
                }
            };
            BrDialogSawmill.this.mCountDownTimer.start();
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
