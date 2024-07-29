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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogPipes extends DialogFragment implements ISAMPGUI {
    private Animation mAnim;
    private Button mExitButton;
    private Button mHelpButton;
    private TextView mTextHelp;
    NvEventQueueActivity mContext = null;
    private boolean mResult = false;
    private CountDownTimer mTimer = null;
    private int mSelectedVar = -1;
    private int[] mIsAngle = new int[23];
    private boolean[] mIsActive = new boolean[23];
    private FrameLayout[] mPipesVar = new FrameLayout[2];
    private RelativeLayout[] mPipes = new RelativeLayout[23];
    int mCountTimer = 0;
    private GUIManager mGUIManager = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 8;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogPipes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.rockstargames.gtacr.BrDialogPipes$1] */
    public void CheckPath() {
        float[] fArr = new float[13];
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            if (!this.mIsActive[i2]) {
                return;
            }
            i |= this.mIsAngle[i2] << i2;
            fArr[i2] = this.mPipes[i2].getChildAt(0).getRotation();
        }
        if (i == 7017 && fArr[0] == 90.0f && fArr[1] == 90.0f && fArr[2] == 90.0f && fArr[3] == 270.0f && fArr[4] == 0.0f && fArr[5] == 180.0f && fArr[6] == 0.0f && fArr[7] == 0.0f && fArr[8] == 180.0f && fArr[9] == 0.0f && fArr[10] == 0.0f && fArr[11] == 90.0f && fArr[12] == 270.0f) {
            this.mResult = true;
            this.mTimer = new CountDownTimer(3750L, 250L) { // from class: com.rockstargames.gtacr.BrDialogPipes.1
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    if (BrDialogPipes.this.mCountTimer >= 13) {
                        return;
                    }
                    if (BrDialogPipes.this.mIsAngle[BrDialogPipes.this.mCountTimer] == 0) {
                        ((ImageView) BrDialogPipes.this.mPipes[BrDialogPipes.this.mCountTimer].getChildAt(0)).setImageResource(R.drawable.br_pipes_direct_blue);
                    } else {
                        ((ImageView) BrDialogPipes.this.mPipes[BrDialogPipes.this.mCountTimer].getChildAt(0)).setImageResource(R.drawable.br_pipes_angle_blue_png);
                    }
                    BrDialogPipes.this.mCountTimer++;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    BrDialogPipes.this.dismissAllowingStateLoss();
                }
            }.start();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        onPipesGuiClosed();
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setStyle(0, R.style.CustomDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_pipes, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getContext();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().setLayout(-1, -1);
        this.mResult = false;
        this.mSelectedVar = -1;
        this.mCountTimer = 0;
        this.mAnim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.mTextHelp = (TextView) inflate.findViewById(R.id.br_pipes_hint);
        this.mPipesVar[0] = (FrameLayout) inflate.findViewById(R.id.br_pipes_dir);
        this.mPipesVar[1] = (FrameLayout) inflate.findViewById(R.id.br_pipes_ang);
        this.mHelpButton = (Button) inflate.findViewById(R.id.br_pipes_help);
        this.mExitButton = (Button) inflate.findViewById(R.id.br_pipes_exit);
        this.mPipes[0] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_0);
        this.mPipes[1] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_1);
        this.mPipes[2] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_2);
        this.mPipes[3] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_3);
        this.mPipes[4] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_4);
        this.mPipes[5] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_5);
        this.mPipes[6] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_6);
        this.mPipes[7] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_7);
        this.mPipes[8] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_8);
        this.mPipes[9] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_9);
        this.mPipes[10] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_10);
        this.mPipes[11] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_11);
        this.mPipes[12] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_12);
        this.mPipes[13] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_13);
        this.mPipes[14] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_14);
        this.mPipes[15] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_15);
        this.mPipes[16] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_16);
        this.mPipes[17] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_17);
        this.mPipes[18] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_18);
        this.mPipes[19] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_19);
        this.mPipes[20] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_20);
        this.mPipes[21] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_21);
        this.mPipes[22] = (RelativeLayout) inflate.findViewById(R.id.br_pipes_22);
        this.mTextHelp.setText("Выберите нужный тип трубы из левого блока");
        for (int i = 0; i < 2; i++) {
            this.mPipesVar[i].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPipes.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BrDialogPipes.this.mResult) {
                        return;
                    }
                    view.startAnimation(BrDialogPipes.this.mAnim);
                    int i2 = 0;
                    for (int i3 = 0; i3 < 2; i3++) {
                        if (view == BrDialogPipes.this.mPipesVar[i3]) {
                            i2 = i3;
                        }
                    }
                    if (BrDialogPipes.this.mSelectedVar != i2) {
                        view.setBackground(ContextCompat.getDrawable(BrDialogPipes.this.getContext(), R.drawable.br_pipes_item_select));
                        if (BrDialogPipes.this.mSelectedVar != -1) {
                            BrDialogPipes.this.mPipesVar[BrDialogPipes.this.mSelectedVar].setBackground(ContextCompat.getDrawable(BrDialogPipes.this.getContext(), R.drawable.br_pipes_item));
                        }
                        BrDialogPipes.this.mSelectedVar = i2;
                        BrDialogPipes.this.mTextHelp.setText("Выберите ячейку, в которую желаете поставить трубу");
                    }
                }
            });
        }
        this.mHelpButton.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPipes.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BrDialogPipes.this.mResult) {
                    return;
                }
                view.startAnimation(BrDialogPipes.this.mAnim);
            }
        });
        this.mExitButton.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPipes.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BrDialogPipes.this.mResult) {
                    return;
                }
                view.startAnimation(BrDialogPipes.this.mAnim);
                BrDialogPipes.this.dismissAllowingStateLoss();
            }
        });
        for (int i2 = 0; i2 < 23; i2++) {
            this.mPipes[i2].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPipes.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BrDialogPipes.this.mResult) {
                        return;
                    }
                    view.startAnimation(BrDialogPipes.this.mAnim);
                    int i3 = 0;
                    for (int i4 = 0; i4 < 23; i4++) {
                        if (view == BrDialogPipes.this.mPipes[i4]) {
                            i3 = i4;
                        }
                    }
                    ImageView imageView = (ImageView) ((RelativeLayout) view).getChildAt(0);
                    int i5 = BrDialogPipes.this.mSelectedVar;
                    if (i5 != -1) {
                        if (i5 == 0 || i5 == 1) {
                            imageView.setVisibility(0);
                            if (BrDialogPipes.this.mSelectedVar == 0) {
                                imageView.setImageResource(R.drawable.br_pipes_direct);
                                imageView.setRotation(0.0f);
                                imageView.setScaleX(0.8f);
                                imageView.setScaleY(0.8f);
                                imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                                BrDialogPipes.this.mIsAngle[i3] = 0;
                            } else {
                                imageView.setImageResource(R.drawable.br_pipes_angle);
                                imageView.setRotation(0.0f);
                                imageView.setScaleX(0.5f);
                                imageView.setScaleY(0.5f);
                                imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                                BrDialogPipes.this.mIsAngle[i3] = 1;
                            }
                            BrDialogPipes.this.mTextHelp.setText("Вы можете повернуть трубу, для этого кликните по ней");
                            BrDialogPipes.this.mIsActive[i3] = true;
                            BrDialogPipes.this.mPipesVar[BrDialogPipes.this.mSelectedVar].setBackground(ContextCompat.getDrawable(BrDialogPipes.this.getContext(), R.drawable.br_pipes_item));
                            BrDialogPipes.this.mSelectedVar = -1;
                        }
                    } else if (BrDialogPipes.this.mIsActive[i3]) {
                        float rotation = imageView.getRotation() + 90.0f;
                        if (rotation >= 360.0f) {
                            rotation = 0.0f;
                        }
                        imageView.setRotation((rotation < 180.0f || BrDialogPipes.this.mIsAngle[i3] != 0) ? rotation : 0.0f);
                    }
                    BrDialogPipes.this.CheckPath();
                }
            });
            this.mPipes[i2].setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rockstargames.gtacr.BrDialogPipes.6
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (BrDialogPipes.this.mResult) {
                        return true;
                    }
                    view.startAnimation(BrDialogPipes.this.mAnim);
                    int i3 = 0;
                    for (int i4 = 0; i4 < 23; i4++) {
                        if (view == BrDialogPipes.this.mPipes[i4]) {
                            i3 = i4;
                        }
                    }
                    ((ImageView) ((RelativeLayout) view).getChildAt(0)).setVisibility(4);
                    BrDialogPipes.this.mIsActive[i3] = false;
                    return true;
                }
            });
        }
        return inflate;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        show(activity.getSupportFragmentManager(), "dialog");
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

    public void onPipesGuiClosed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, this.mResult);
            this.mGUIManager.sendJsonData(8, jSONObject);
        } catch (Exception unused) {
        }
    }
}
