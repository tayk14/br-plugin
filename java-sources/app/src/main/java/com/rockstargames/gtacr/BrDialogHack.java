package com.rockstargames.gtacr;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import java.lang.reflect.Array;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogHack extends DialogFragment implements ISAMPGUI {
    private Animation mAnim;
    private TextView mHintText;
    private CountDownTimer mTimer;
    private TextView mTimerText;
    private NvEventQueueActivity mContext = null;
    private byte mCloseType = 2;
    private int mCursor = 0;
    private int mRandomCursor = 0;
    private int[] mRandomLine = new int[10];
    public int mTime = 0;
    private TextView[][] mTable = (TextView[][]) Array.newInstance((Class<?>) TextView.class, 6, 3);
    private TextView[] mPassLine = new TextView[6];
    private TextView[] mKeys = new TextView[20];
    private GUIManager mGUIManager = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 4;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    static /* synthetic */ int access$308(BrDialogHack brDialogHack) {
        int i = brDialogHack.mCursor;
        brDialogHack.mCursor = i + 1;
        return i;
    }

    static /* synthetic */ int access$604(BrDialogHack brDialogHack) {
        int i = brDialogHack.mRandomCursor + 1;
        brDialogHack.mRandomCursor = i;
        return i;
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogHack();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setStyle(0, R.style.CustomDialog);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        this.mTimer.cancel();
        onHackGuiClosed();
        super.onDismiss(dialog);
    }

    /* JADX WARN: Type inference failed for: r10v34, types: [com.rockstargames.gtacr.BrDialogHack$2] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_hack, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getContext();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().setLayout(-1, -1);
        this.mAnim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.mCursor = 0;
        this.mCloseType = (byte) 2;
        ((ImageView) inflate.findViewById(R.id.br_hack_close)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogHack.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogHack.this.mCloseType = (byte) 2;
                BrDialogHack.this.dismissAllowingStateLoss();
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.br_hack_hint);
        this.mHintText = textView;
        textView.setText("Найдите букву белого цвета и нажмите на неё на клавиатуре");
        this.mTimerText = (TextView) inflate.findViewById(R.id.br_hack_time);
        this.mTable[0][0] = (TextView) inflate.findViewById(R.id.br_hack_item_00);
        this.mTable[0][1] = (TextView) inflate.findViewById(R.id.br_hack_item_10);
        this.mTable[0][2] = (TextView) inflate.findViewById(R.id.br_hack_item_20);
        this.mTable[1][0] = (TextView) inflate.findViewById(R.id.br_hack_item_01);
        this.mTable[1][1] = (TextView) inflate.findViewById(R.id.br_hack_item_11);
        this.mTable[1][2] = (TextView) inflate.findViewById(R.id.br_hack_item_21);
        this.mTable[2][0] = (TextView) inflate.findViewById(R.id.br_hack_item_02);
        this.mTable[2][1] = (TextView) inflate.findViewById(R.id.br_hack_item_12);
        this.mTable[2][2] = (TextView) inflate.findViewById(R.id.br_hack_item_22);
        this.mTable[3][0] = (TextView) inflate.findViewById(R.id.br_hack_item_03);
        this.mTable[3][1] = (TextView) inflate.findViewById(R.id.br_hack_item_13);
        this.mTable[3][2] = (TextView) inflate.findViewById(R.id.br_hack_item_23);
        this.mTable[4][0] = (TextView) inflate.findViewById(R.id.br_hack_item_04);
        this.mTable[4][1] = (TextView) inflate.findViewById(R.id.br_hack_item_14);
        this.mTable[4][2] = (TextView) inflate.findViewById(R.id.br_hack_item_24);
        this.mTable[5][0] = (TextView) inflate.findViewById(R.id.br_hack_item_05);
        this.mTable[5][1] = (TextView) inflate.findViewById(R.id.br_hack_item_15);
        this.mTable[5][2] = (TextView) inflate.findViewById(R.id.br_hack_item_25);
        this.mPassLine[0] = (TextView) inflate.findViewById(R.id.br_hack_pass_0);
        this.mPassLine[1] = (TextView) inflate.findViewById(R.id.br_hack_pass_1);
        this.mPassLine[2] = (TextView) inflate.findViewById(R.id.br_hack_pass_2);
        this.mPassLine[3] = (TextView) inflate.findViewById(R.id.br_hack_pass_3);
        this.mPassLine[4] = (TextView) inflate.findViewById(R.id.br_hack_pass_4);
        this.mPassLine[5] = (TextView) inflate.findViewById(R.id.br_hack_pass_5);
        this.mKeys[0] = (TextView) inflate.findViewById(R.id.br_hack_key_0);
        this.mKeys[1] = (TextView) inflate.findViewById(R.id.br_hack_key_1);
        this.mKeys[2] = (TextView) inflate.findViewById(R.id.br_hack_key_2);
        this.mKeys[3] = (TextView) inflate.findViewById(R.id.br_hack_key_3);
        this.mKeys[4] = (TextView) inflate.findViewById(R.id.br_hack_key_4);
        this.mKeys[5] = (TextView) inflate.findViewById(R.id.br_hack_key_5);
        this.mKeys[6] = (TextView) inflate.findViewById(R.id.br_hack_key_6);
        this.mKeys[7] = (TextView) inflate.findViewById(R.id.br_hack_key_7);
        this.mKeys[8] = (TextView) inflate.findViewById(R.id.br_hack_key_8);
        this.mKeys[9] = (TextView) inflate.findViewById(R.id.br_hack_key_9);
        this.mKeys[10] = (TextView) inflate.findViewById(R.id.br_hack_key_10);
        this.mKeys[11] = (TextView) inflate.findViewById(R.id.br_hack_key_11);
        this.mKeys[12] = (TextView) inflate.findViewById(R.id.br_hack_key_12);
        this.mKeys[13] = (TextView) inflate.findViewById(R.id.br_hack_key_13);
        this.mKeys[14] = (TextView) inflate.findViewById(R.id.br_hack_key_14);
        this.mKeys[15] = (TextView) inflate.findViewById(R.id.br_hack_key_15);
        this.mKeys[16] = (TextView) inflate.findViewById(R.id.br_hack_key_16);
        this.mKeys[17] = (TextView) inflate.findViewById(R.id.br_hack_key_17);
        this.mKeys[18] = (TextView) inflate.findViewById(R.id.br_hack_key_18);
        this.mKeys[19] = (TextView) inflate.findViewById(R.id.br_hack_key_19);
        for (int i = 0; i < 6; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.mTable[i][i2].setText("?");
            }
            this.mPassLine[i].setText(" ");
        }
        Random random = new Random();
        for (int i3 = 0; i3 < 10; i3++) {
            this.mRandomLine[i3] = random.nextInt(20);
        }
        this.mRandomCursor = random.nextInt(10);
        this.mTimer = new CountDownTimer(this.mTime * 1000, 250L) { // from class: com.rockstargames.gtacr.BrDialogHack.2
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                BrDialogHack.this.mTimerText.setText("" + (millisUntilFinished / 1000));
                BrDialogHack.this.mTable[BrDialogHack.this.mCursor][2].setText(BrDialogHack.this.mTable[BrDialogHack.this.mCursor][1].getText());
                BrDialogHack.this.mTable[BrDialogHack.this.mCursor][2].setTextColor(BrDialogHack.this.mTable[BrDialogHack.this.mCursor][1].getTextColors());
                BrDialogHack.this.mTable[BrDialogHack.this.mCursor][1].setText(BrDialogHack.this.mTable[BrDialogHack.this.mCursor][0].getText());
                BrDialogHack.this.mTable[BrDialogHack.this.mCursor][1].setTextColor(BrDialogHack.this.mTable[BrDialogHack.this.mCursor][0].getTextColors());
                BrDialogHack.this.mTable[BrDialogHack.this.mCursor][0].setText(BrDialogHack.this.mKeys[BrDialogHack.this.mRandomLine[BrDialogHack.this.mRandomCursor]].getText());
                if (BrDialogHack.this.mRandomCursor == 0) {
                    BrDialogHack.this.mTable[BrDialogHack.this.mCursor][0].setTextColor(-1);
                } else {
                    BrDialogHack.this.mTable[BrDialogHack.this.mCursor][0].setTextColor(-40168);
                }
                if (BrDialogHack.access$604(BrDialogHack.this) > 9) {
                    BrDialogHack.this.mRandomCursor = 0;
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BrDialogHack.this.mCloseType = (byte) 1;
                BrDialogHack.this.dismissAllowingStateLoss();
            }
        }.start();
        for (int i4 = 0; i4 < 20; i4++) {
            ((FrameLayout) this.mKeys[i4].getParent()).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogHack.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    view.startAnimation(BrDialogHack.this.mAnim);
                    FrameLayout frameLayout = (FrameLayout) view;
                    BrDialogHack.this.mPassLine[BrDialogHack.access$308(BrDialogHack.this)].setText(((TextView) frameLayout.getChildAt(1)).getText());
                    if (((TextView) frameLayout.getChildAt(1)).getText() != BrDialogHack.this.mKeys[BrDialogHack.this.mRandomLine[0]].getText()) {
                        BrDialogHack.this.onHackGuiWasMistake();
                    }
                    if (BrDialogHack.this.mCursor > 5) {
                        BrDialogHack.this.mCloseType = (byte) 0;
                        BrDialogHack.this.dismissAllowingStateLoss();
                    }
                    Random random2 = new Random();
                    for (int i5 = 0; i5 < 10; i5++) {
                        BrDialogHack.this.mRandomLine[i5] = random2.nextInt(20);
                    }
                    BrDialogHack.this.mRandomCursor = random2.nextInt(10);
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

    public void onHackGuiClosed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", (int) this.mCloseType);
            this.mGUIManager.sendJsonData(4, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onHackGuiWasMistake() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 3);
            this.mGUIManager.sendJsonData(3, jSONObject);
        } catch (Exception unused) {
        }
    }
}
