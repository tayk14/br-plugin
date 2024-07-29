package com.rockstargames.gtacr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import blackrussia.online.R;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.nvidia.devtech.NvEventQueueActivity;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogDance implements ISAMPGUI {
    private ImageView mActiveLimb;
    private FrameLayout mActiveView;
    private GUIManager mGUIManager;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mWindow = null;
    private View mRootView = null;
    private CountDownTimer mTimer = null;
    private Animation anim = null;
    private int mTime = 0;
    private int mBank = 0;
    private int mEx = 0;
    private int mNextEx = 0;
    private int mMistakes = 0;
    private int mGratuity = 0;
    private int mNextGratuity = 0;
    private boolean mWasPressed = false;
    private boolean mClosedByTimer = false;
    private int mDrawBank = 0;
    private TextView mMistakesV = null;
    private TextView mBankV = null;
    private TextView mHint = null;
    private final int LEFT_ARM = 0;
    private final int LEFT_LEG = 1;
    private final int RIGHT_ARM = 2;
    private final int RIGHT_LEG = 3;
    private final int ELEMSNUM = 15;
    private ScaleDraw scaleDraw = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 15;
    }

    static /* synthetic */ int access$104(BrDialogDance brDialogDance) {
        int i = brDialogDance.mEx + 1;
        brDialogDance.mEx = i;
        return i;
    }

    static /* synthetic */ int access$1104(BrDialogDance brDialogDance) {
        int i = brDialogDance.mMistakes + 1;
        brDialogDance.mMistakes = i;
        return i;
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogDance();
    }

    /* loaded from: classes2.dex */
    private class ScaleDraw extends View {
        private int Active;
        private int[] OffsetX;
        private int[] Type;
        private Bitmap[] mBitmaps;
        private Paint mPaint;
        private int mWidth;
        private Random rnd;

        public void ProcessOnPressed(int index) {
            if (BrDialogDance.this.mWasPressed) {
                return;
            }
            int i = this.Active;
            if (i < 0 || index != this.Type[i]) {
                BrDialogDance.this.mMistakesV.setText("" + BrDialogDance.access$1104(BrDialogDance.this));
                if (this.Active >= 0) {
                    BrDialogDance.this.mHint.setText("Неверно!");
                } else {
                    BrDialogDance.this.mHint.setText("Рано!");
                }
                BrDialogDance.this.mActiveView.setBackground(ContextCompat.getDrawable(BrDialogDance.this.mContext, R.drawable.br_dance_oval));
                NvEventQueueActivity nvEventQueueActivity = BrDialogDance.this.mContext;
                NvEventQueueActivity unused = BrDialogDance.this.mContext;
                Vibrator vibrator = (Vibrator) nvEventQueueActivity.getSystemService("vibrator");
                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(200L);
                }
            } else {
                if (BrDialogDance.access$104(BrDialogDance.this) == BrDialogDance.this.mNextEx) {
                    BrDialogDance brDialogDance = BrDialogDance.this;
                    brDialogDance.mGratuity = brDialogDance.mNextGratuity;
                }
                BrDialogDance.this.mBank += BrDialogDance.this.mGratuity;
                BrDialogDance.this.mBankV.setText(String.format("%,.0f ₽", Float.valueOf(BrDialogDance.this.mBank)));
                BrDialogDance.this.mActiveView.setBackground(ContextCompat.getDrawable(BrDialogDance.this.mContext, R.drawable.br_dance_oval_active));
                BrDialogDance.this.mHint.setText("Верно!");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 1);
                    BrDialogDance.this.mGUIManager.sendJsonData(15, jSONObject);
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
            BrDialogDance.this.mWasPressed = true;
        }

        public ScaleDraw(Context context) {
            super(context);
            this.mWidth = 100;
            this.mBitmaps = new Bitmap[4];
            this.OffsetX = new int[15];
            this.Type = new int[15];
            this.Active = -1;
            this.mPaint = new Paint();
            Resources resources = getResources();
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            this.mBitmaps[0] = BitmapFactory.decodeResource(resources, R.drawable.br_dance_arm);
            this.mBitmaps[1] = BitmapFactory.decodeResource(resources, R.drawable.br_dance_leg);
            this.mBitmaps[2] = Bitmap.createBitmap(BitmapFactory.decodeResource(resources, R.drawable.br_dance_arm), 0, 0, this.mBitmaps[0].getWidth(), this.mBitmaps[0].getHeight(), matrix, false);
            this.mBitmaps[3] = Bitmap.createBitmap(BitmapFactory.decodeResource(resources, R.drawable.br_dance_leg), 0, 0, this.mBitmaps[1].getWidth(), this.mBitmaps[1].getHeight(), matrix, false);
            Random random = new Random();
            this.rnd = random;
            this.OffsetX[0] = -70;
            this.Type[0] = random.nextInt(4);
            for (int i = 1; i < 15; i++) {
                this.OffsetX[i] = (i * (-70)) - 70;
                this.Type[i] = this.rnd.nextInt(4);
                while (true) {
                    int[] iArr = this.Type;
                    if (iArr[i] == iArr[i - 1]) {
                        iArr[i] = this.rnd.nextInt(4);
                    }
                }
            }
        }

        private int toPx(int dp) {
            return NvEventQueueActivity.dpToPx(dp, BrDialogDance.this.mContext);
        }

        public void Update() {
            int i = 0;
            while (i < 15) {
                if (toPx(this.OffsetX[i]) <= this.mWidth) {
                    int[] iArr = this.OffsetX;
                    iArr[i] = iArr[i] + 1;
                } else {
                    Random random = new Random();
                    this.Type[i] = random.nextInt(4);
                    int i2 = i != 0 ? i - 1 : 14;
                    while (true) {
                        int[] iArr2 = this.Type;
                        if (iArr2[i2] != iArr2[i]) {
                            break;
                        } else {
                            iArr2[i] = random.nextInt(4);
                        }
                    }
//                    this.OffsetX[i] = r2[i2] - 70;
                }
                if (this.Active != i && toPx(this.OffsetX[i]) >= (this.mWidth / 2) - toPx(35) && toPx(this.OffsetX[i]) <= (this.mWidth / 2) + toPx(35)) {
                    if (!BrDialogDance.this.mWasPressed && this.Active >= 0) {
                        NvEventQueueActivity nvEventQueueActivity = BrDialogDance.this.mContext;
                        NvEventQueueActivity unused = BrDialogDance.this.mContext;
                        Vibrator vibrator = (Vibrator) nvEventQueueActivity.getSystemService("vibrator");
                        if (vibrator.hasVibrator()) {
                            vibrator.vibrate(200L);
                        }
                        BrDialogDance.this.mMistakesV.setText("" + BrDialogDance.access$1104(BrDialogDance.this));
                        BrDialogDance.this.mHint.setText("Поздно!");
                    }
                    BrDialogDance.this.mActiveLimb.setVisibility(0);
                    BrDialogDance.this.mActiveLimb.setImageBitmap(this.mBitmaps[this.Type[i]]);
                    BrDialogDance.this.mActiveView.setBackground(ContextCompat.getDrawable(BrDialogDance.this.mContext, R.drawable.br_dance_oval_gray));
                    this.Active = i;
                    BrDialogDance.this.mWasPressed = false;
                }
                i++;
            }
            invalidate();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.mWidth = canvas.getWidth();
            for (int i = 0; i < 15; i++) {
                this.mPaint.setColor(-16777216);
                this.mPaint.setAlpha(160);
                canvas.drawRoundRect(toPx(this.OffsetX[i] - 8), toPx(5), toPx(this.OffsetX[i] + 53), toPx(65), toPx(4), toPx(4), this.mPaint);
                this.mPaint.setAlpha(255);
                canvas.drawBitmap(this.mBitmaps[this.Type[i]], (Rect) null, new RectF(toPx(this.OffsetX[i]), toPx(10), toPx(this.OffsetX[i] + 45), toPx(60)), this.mPaint);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [com.rockstargames.gtacr.BrDialogDance$3] */
    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            this.mRootView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_dance, (ViewGroup) null, false);
            this.mContext = activity;
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, -1, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogDance.1
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    BrDialogDance.this.mTimer.cancel();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("t", 0);
                        jSONObject.put("cl", BrDialogDance.this.mClosedByTimer ? 1 : 0);
                        jSONObject.put("b", BrDialogDance.this.mBank);
                        jSONObject.put("e", BrDialogDance.this.mEx);
                        BrDialogDance.this.mGUIManager.sendJsonData(15, jSONObject);
                    } catch (Exception e) {
                        FirebaseCrashlytics.getInstance().recordException(e);
                    }
                    BrDialogDance.this.mGUIManager.closeGUI(null, 15);
                }
            });
        }
        this.anim = AnimationUtils.loadAnimation(this.mContext, R.anim.button_click);
        this.mRootView.findViewById(R.id.br_dance_close).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDance.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogDance.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogDance.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrDialogDance.this.mWindow.dismiss();
                    }
                }, 400L);
            }
        });
        this.mActiveLimb = (ImageView) this.mRootView.findViewById(R.id.br_dance_alimb);
        this.mMistakesV = (TextView) this.mRootView.findViewById(R.id.br_dance_mistakes_text);
        this.mBankV = (TextView) this.mRootView.findViewById(R.id.br_dance_bank_text);
        this.mHint = (TextView) this.mRootView.findViewById(R.id.br_dance_hint);
        this.mBankV.setText("0 ₽");
        this.mMistakesV.setText("0");
        this.mHint.setText("Нажимайте на соответсвующие кнопки в нужное время.");
        try {
            this.mTime = json.getInt("ti");
            this.mEx = json.getInt("e");
            this.mNextEx = json.getInt("ne");
            this.mGratuity = json.getInt("g");
            this.mNextGratuity = json.getInt("ng");
            this.mDrawBank = json.getInt("b");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mDrawBank != 0) {
            this.mRootView.findViewById(R.id.br_dance_bank).setVisibility(4);
        }
        final TextView textView = (TextView) this.mRootView.findViewById(R.id.br_dance_time);
        this.mTimer = new CountDownTimer(this.mTime * 1000, 5L) { // from class: com.rockstargames.gtacr.BrDialogDance.3
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                long j = millisUntilFinished / 1000;
                if (j > 59) {
                    textView.setText("Осталось: " + (j / 60) + " мин. " + (j % 60) + " сек.");
                } else {
                    textView.setText("Осталось: " + j + " сек.");
                }
                BrDialogDance.this.scaleDraw.Update();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BrDialogDance.this.mClosedByTimer = true;
                BrDialogDance.this.mWindow.dismiss();
            }
        }.start();
        this.scaleDraw = new ScaleDraw(this.mContext);
        ((FrameLayout) this.mRootView.findViewById(R.id.br_dance_bar_frame)).addView(this.scaleDraw);
        this.mActiveView = (FrameLayout) this.mRootView.findViewById(R.id.br_dance_active);
        final FrameLayout[] frameLayoutArr = {(FrameLayout) this.mRootView.findViewById(R.id.br_dance_left_up), (FrameLayout) this.mRootView.findViewById(R.id.br_dance_left_down), (FrameLayout) this.mRootView.findViewById(R.id.br_dance_right_up), (FrameLayout) this.mRootView.findViewById(R.id.br_dance_right_down)};
        for (int i = 0; i < 4; i++) {
            frameLayoutArr[i].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDance.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i2 = -1;
                    for (int i3 = 0; i3 < 4; i3++) {
                        if (frameLayoutArr[i3] == view) {
                            i2 = i3;
                        }
                    }
                    BrDialogDance.this.scaleDraw.ProcessOnPressed(i2);
                }
            });
        }
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        try {
            if (json.getInt("t") != 0) {
                return;
            }
            this.mHint.setText("Вам дали чаевые, в размере " + String.format("%,.0f ₽", Float.valueOf(json.getInt("m"))));
            this.mBank = this.mBank + json.getInt("m");
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
