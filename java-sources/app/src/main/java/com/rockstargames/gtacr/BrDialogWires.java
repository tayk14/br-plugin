package com.rockstargames.gtacr;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogWires extends DialogFragment implements ISAMPGUI {
    private Animation mAnim;
    private TextView mAttachedText;
    private Button mExitButton;
    private Button mHelpButton;
    private TextView mHintText;
    private TextView mTimerText;
    NvEventQueueActivity mContext = null;
    private CountDownTimer mTimer = null;
    public int mTime = 0;
    private FrameLayout[] mLitem = new FrameLayout[5];
    private FrameLayout[] mRitem = new FrameLayout[5];
    private int[] mLitemSeq = {0, 1, 2, 3, 4};
    private int[] mRitemSeq = {0, 1, 2, 3, 4};
    private int mLitemSelected = -1;
    private int mRitemSelected = -1;
    private int mLitemMask = 0;
    private int mRitemMask = 0;
    private int mAttached = 0;
    private LinesDraw linesDraw = null;
    private GUIManager mGUIManager = null;

    private int getWireId(int id) {
        if (id == 0) {
            return R.drawable.br_wires_red;
        }
        if (id == 1) {
            return R.drawable.br_wires_green;
        }
        if (id == 2) {
            return R.drawable.br_wires_blue;
        }
        if (id == 3) {
            return R.drawable.br_wires_yellow;
        }
        if (id != 4) {
            return 0;
        }
        return R.drawable.br_wires_pink;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 7;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    static /* synthetic */ int access$504(BrDialogWires brDialogWires) {
        int i = brDialogWires.mAttached + 1;
        brDialogWires.mAttached = i;
        return i;
    }

    /* loaded from: classes2.dex */
    private class LinesDraw extends View {
        private int[] mColor;
        private int mCount;
        private int[] mFirstPnt;
        private Paint mPaint;
        private Rect mRect;
        private int[] mSecondPnt;

        public void addLine(int firstPnt, int secondPnt, int color) {
            int i = this.mCount;
            if (i < 5) {
                this.mFirstPnt[i] = firstPnt;
                this.mSecondPnt[i] = secondPnt;
                int[] iArr = this.mColor;
                this.mCount = i + 1;
                iArr[i] = color;
            }
        }

        public LinesDraw(Context context) {
            super(context);
            this.mCount = 0;
            this.mFirstPnt = new int[5];
            this.mSecondPnt = new int[5];
            this.mColor = new int[5];
            this.mPaint = new Paint();
            this.mRect = new Rect();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeWidth(10.0f);
            for (int i = 0; i < this.mCount; i++) {
                this.mPaint.setColor(this.mColor[i]);
                float height = canvas.getHeight() / 10;
                float height2 = canvas.getHeight() / 5;
                canvas.drawLine(0.0f, height + (this.mFirstPnt[i] * height2), canvas.getWidth(), height + (height2 * this.mSecondPnt[i]), this.mPaint);
            }
        }
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogWires();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWireColor(int id) {
        if (id == 0) {
            return Color.rgb(255, 0, 0);
        }
        if (id == 1) {
            return Color.rgb(0, 255, 0);
        }
        if (id == 2) {
            return Color.rgb(0, 0, 255);
        }
        if (id == 3) {
            return Color.rgb(255, 210, 0);
        }
        if (id != 4) {
            return 0;
        }
        return Color.rgb(175, 0, 240);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        onWiresGuiClosed();
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setStyle(0, R.style.CustomDialog);
    }

    private void mix(int[] a) {
        Random random = new Random();
        for (int i = 1; i < a.length; i++) {
            int nextInt = random.nextInt(i);
            int i2 = a[i];
            a[i] = a[nextInt];
            a[nextInt] = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r11v46, types: [com.rockstargames.gtacr.BrDialogWires$4] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_wires, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getContext();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().setLayout(-1, -1);
        this.mAnim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.mLitemSelected = -1;
        this.mRitemSelected = -1;
        this.mLitemMask = 0;
        this.mRitemMask = 0;
        this.mAttached = 0;
        this.mLitem[0] = (FrameLayout) inflate.findViewById(R.id.br_wires_litem_0);
        this.mLitem[1] = (FrameLayout) inflate.findViewById(R.id.br_wires_litem_1);
        this.mLitem[2] = (FrameLayout) inflate.findViewById(R.id.br_wires_litem_2);
        this.mLitem[3] = (FrameLayout) inflate.findViewById(R.id.br_wires_litem_3);
        this.mLitem[4] = (FrameLayout) inflate.findViewById(R.id.br_wires_litem_4);
        this.mRitem[0] = (FrameLayout) inflate.findViewById(R.id.br_wires_ritem_0);
        this.mRitem[1] = (FrameLayout) inflate.findViewById(R.id.br_wires_ritem_1);
        this.mRitem[2] = (FrameLayout) inflate.findViewById(R.id.br_wires_ritem_2);
        this.mRitem[3] = (FrameLayout) inflate.findViewById(R.id.br_wires_ritem_3);
        this.mRitem[4] = (FrameLayout) inflate.findViewById(R.id.br_wires_ritem_4);
        this.mHintText = (TextView) inflate.findViewById(R.id.br_wires_hint);
        this.mTimerText = (TextView) inflate.findViewById(R.id.br_wires_time);
        this.mAttachedText = (TextView) inflate.findViewById(R.id.br_wires_attached);
        this.mHelpButton = (Button) inflate.findViewById(R.id.br_wires_help);
        this.mExitButton = (Button) inflate.findViewById(R.id.br_wires_exit);
        final ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.br_wires_frame);
        LinesDraw linesDraw = new LinesDraw(getContext());
        this.linesDraw = linesDraw;
        linesDraw.setId(View.generateViewId());
        constraintLayout.addView(this.linesDraw);
        final ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(this.linesDraw.getId(), 1, R.id.br_wires_litem_0, 2);
        constraintSet.connect(this.linesDraw.getId(), 2, R.id.br_wires_ritem_0, 1);
        constraintSet.connect(this.linesDraw.getId(), 4, R.id.br_wires_ritem_4, 4);
        constraintSet.connect(this.linesDraw.getId(), 3, 0, 3);
        constraintSet.constrainWidth(this.linesDraw.getId(), 0);
        constraintSet.constrainHeight(this.linesDraw.getId(), 0);
        constraintSet.applyTo(constraintLayout);
        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rockstargames.gtacr.BrDialogWires.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                constraintLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                float width = BrDialogWires.this.mLitem[0].getWidth();
                float left = BrDialogWires.this.mRitem[0].getLeft() - BrDialogWires.this.mLitem[0].getRight();
                constraintSet.setScaleX(BrDialogWires.this.linesDraw.getId(), (((width / 12.0f) * 2.0f) + left) / left);
                constraintSet.applyTo(constraintLayout);
                if (Build.VERSION.SDK_INT < 16) {
                    BrDialogWires.this.mLitem[0].getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    BrDialogWires.this.mLitem[0].getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
        mix(this.mLitemSeq);
        mix(this.mRitemSeq);
        for (int i = 0; i < 5; i++) {
            ((ImageView) this.mLitem[i].getChildAt(0)).setImageResource(getWireId(this.mLitemSeq[i]));
            ((ImageView) this.mRitem[i].getChildAt(0)).setImageResource(getWireId(this.mRitemSeq[i]));
        }
        this.mHelpButton.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWires.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogWires.this.mAnim);
            }
        });
        this.mExitButton.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWires.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogWires.this.mAnim);
                BrDialogWires.this.dismissAllowingStateLoss();
            }
        });
        this.mTimer = new CountDownTimer(this.mTime * 1000, 1000L) { // from class: com.rockstargames.gtacr.BrDialogWires.4
            @Override // android.os.CountDownTimer
            public void onTick(long l) {
                BrDialogWires.this.mTimerText.setText("" + (l / 1000));
                if (BrDialogWires.this.mAttached == 5) {
                    cancel();
                    BrDialogWires.this.dismissAllowingStateLoss();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BrDialogWires.this.dismissAllowingStateLoss();
            }
        }.start();
        for (int i2 = 0; i2 < 5; i2++) {
            this.mLitem[i2].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWires.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < 5; i4++) {
                        if (view == BrDialogWires.this.mLitem[i4]) {
                            i3 = i4;
                        }
                    }
                    if (((BrDialogWires.this.mLitemMask >> i3) & 1) != 0) {
                        return;
                    }
                    if (BrDialogWires.this.mLitemSelected != i3) {
                        if (BrDialogWires.this.mLitemSelected != -1) {
                            BrDialogWires.this.mLitem[BrDialogWires.this.mLitemSelected].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item));
                        }
                        BrDialogWires.this.mLitem[i3].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item_select));
                        BrDialogWires.this.mLitemSelected = i3;
                    }
                    if (BrDialogWires.this.mRitemSelected != -1) {
                        if (BrDialogWires.this.mLitemSeq[i3] == BrDialogWires.this.mRitemSeq[BrDialogWires.this.mRitemSelected]) {
                            BrDialogWires.this.mLitemMask |= 1 << i3;
                            BrDialogWires brDialogWires = BrDialogWires.this;
                            brDialogWires.mRitemMask = (1 << BrDialogWires.this.mRitemSelected) | brDialogWires.mRitemMask;
                            BrDialogWires.this.mAttachedText.setText("" + BrDialogWires.access$504(BrDialogWires.this) + "/5");
                            LinesDraw linesDraw2 = BrDialogWires.this.linesDraw;
                            int i5 = BrDialogWires.this.mRitemSelected;
                            BrDialogWires brDialogWires2 = BrDialogWires.this;
                            linesDraw2.addLine(i3, i5, brDialogWires2.getWireColor(brDialogWires2.mLitemSeq[i3]));
                            BrDialogWires.this.linesDraw.invalidate();
                        }
                        BrDialogWires.this.mLitem[i3].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item));
                        BrDialogWires.this.mRitem[BrDialogWires.this.mRitemSelected].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item));
                        BrDialogWires brDialogWires3 = BrDialogWires.this;
                        brDialogWires3.mRitemSelected = brDialogWires3.mLitemSelected = -1;
                    }
                    view.startAnimation(BrDialogWires.this.mAnim);
                }
            });
            this.mRitem[i2].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWires.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < 5; i4++) {
                        if (view == BrDialogWires.this.mRitem[i4]) {
                            i3 = i4;
                        }
                    }
                    if (((BrDialogWires.this.mRitemMask >> i3) & 1) != 0) {
                        return;
                    }
                    if (BrDialogWires.this.mRitemSelected != i3) {
                        if (BrDialogWires.this.mRitemSelected != -1) {
                            BrDialogWires.this.mRitem[BrDialogWires.this.mRitemSelected].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item));
                        }
                        BrDialogWires.this.mRitem[i3].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item_select));
                        BrDialogWires.this.mRitemSelected = i3;
                    }
                    if (BrDialogWires.this.mLitemSelected != -1) {
                        if (BrDialogWires.this.mRitemSeq[i3] == BrDialogWires.this.mLitemSeq[BrDialogWires.this.mLitemSelected]) {
                            BrDialogWires.this.mRitemMask |= 1 << i3;
                            BrDialogWires brDialogWires = BrDialogWires.this;
                            brDialogWires.mLitemMask = (1 << BrDialogWires.this.mLitemSelected) | brDialogWires.mLitemMask;
                            BrDialogWires.this.mAttachedText.setText("" + BrDialogWires.access$504(BrDialogWires.this) + "/5");
                            LinesDraw linesDraw2 = BrDialogWires.this.linesDraw;
                            int i5 = BrDialogWires.this.mLitemSelected;
                            BrDialogWires brDialogWires2 = BrDialogWires.this;
                            linesDraw2.addLine(i5, i3, brDialogWires2.getWireColor(brDialogWires2.mRitemSeq[i3]));
                            BrDialogWires.this.linesDraw.invalidate();
                        }
                        BrDialogWires.this.mLitem[BrDialogWires.this.mLitemSelected].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item));
                        BrDialogWires.this.mRitem[i3].setBackground(ContextCompat.getDrawable(BrDialogWires.this.getContext(), R.drawable.br_wires_item));
                        BrDialogWires brDialogWires3 = BrDialogWires.this;
                        brDialogWires3.mRitemSelected = brDialogWires3.mLitemSelected = -1;
                    }
                    view.startAnimation(BrDialogWires.this.mAnim);
                }
            });
        }
        return inflate;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        show(activity.getSupportFragmentManager(), "dialog");
        try {
            this.mTime = json.getInt("i");
        } catch (Exception unused) {
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        dismissAllowingStateLoss();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        if (getDialog() != null) {
            return getDialog().isShowing();
        }
        return false;
    }

    public void onWiresGuiClosed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            jSONObject.put("a", this.mAttached);
            this.mGUIManager.sendJsonData(7, jSONObject);
        } catch (Exception unused) {
        }
    }
}
