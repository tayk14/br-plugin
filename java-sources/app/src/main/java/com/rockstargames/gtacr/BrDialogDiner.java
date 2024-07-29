package com.rockstargames.gtacr;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogDiner extends DialogFragment implements ISAMPGUI {
    private LinearLayout[] mEatsLinears;
    private boolean[] mEatsSelected;
    private TextView mPriceSumText;
    private RelativeLayout mPurchaseLayout;
    NvEventQueueActivity mContext = null;
    private int[] mEatsPrice = {120, 230, 320, 580, 80, 30};
    private int[] mEatsSatiety = {5, 10, 15, 20, 3, 2};
    public int mPriceSum = 0;
    public int mMoney = 0;
    private boolean mPurchased = false;
    private GUIManager mGUIManager = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 3;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogDiner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdatePriceSum() {
        this.mPriceSum = 0;
        for (int i = 0; i < 6; i++) {
            if (this.mEatsSelected[i]) {
                this.mPriceSum += this.mEatsPrice[i];
            }
        }
        this.mPriceSumText.setText("Общая стоимость: " + this.mPriceSum + " рублей");
        int i2 = this.mPriceSum;
        if (i2 != 0 && this.mMoney >= i2) {
            this.mPurchaseLayout.setAlpha(1.0f);
        } else {
            this.mPurchaseLayout.setAlpha(0.5f);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        if (!this.mPurchased) {
            onDinerGuiClosed();
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_diner, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getActivity();
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().getDecorView().getBackground().setAlpha(0);
        ((Button) inflate.findViewById(R.id.close_button)).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BrDialogDiner.this.dismissAllowingStateLoss();
                return false;
            }
        });
        this.mEatsSelected = new boolean[6];
        this.mPriceSumText = (TextView) inflate.findViewById(R.id.br_diner_price_sum);
        this.mPurchaseLayout = (RelativeLayout) inflate.findViewById(R.id.br_diner_purchace_button);
        UpdatePriceSum();
        this.mPurchaseLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getAlpha() >= 1.0f) {
                    BrDialogDiner.this.mPurchased = true;
                    int i = 0;
                    for (int i2 = 0; i2 < 6; i2++) {
                        if (BrDialogDiner.this.mEatsSelected[i2]) {
                            i |= 1 << i2;
                        }
                    }
                    BrDialogDiner.this.onDinerGuiPurchased(i);
                    BrDialogDiner.this.dismissAllowingStateLoss();
                }
            }
        });
        TextView[] textViewArr = {(TextView) inflate.findViewById(R.id.br_diner_price_0), (TextView) inflate.findViewById(R.id.br_diner_price_1), (TextView) inflate.findViewById(R.id.br_diner_price_2), (TextView) inflate.findViewById(R.id.br_diner_price_3), (TextView) inflate.findViewById(R.id.br_diner_price_4), (TextView) inflate.findViewById(R.id.br_diner_price_5)};
        TextView[] textViewArr2 = {(TextView) inflate.findViewById(R.id.br_diner_satiety_0), (TextView) inflate.findViewById(R.id.br_diner_satiety_1), (TextView) inflate.findViewById(R.id.br_diner_satiety_2), (TextView) inflate.findViewById(R.id.br_diner_satiety_3), (TextView) inflate.findViewById(R.id.br_diner_satiety_4), (TextView) inflate.findViewById(R.id.br_diner_satiety_5)};
        for (int i = 0; i < 6; i++) {
            textViewArr[i].setText("Стоимость: " + this.mEatsPrice[i] + "Р");
            textViewArr2[i].setText("Сытость: " + this.mEatsSatiety[i] + " ед.");
        }
        LinearLayout[] linearLayoutArr = new LinearLayout[6];
        this.mEatsLinears = linearLayoutArr;
        linearLayoutArr[0] = (LinearLayout) inflate.findViewById(R.id.br_diner_hotdog);
        this.mEatsLinears[1] = (LinearLayout) inflate.findViewById(R.id.br_diner_cheburek);
        this.mEatsLinears[2] = (LinearLayout) inflate.findViewById(R.id.br_diner_pie);
        this.mEatsLinears[3] = (LinearLayout) inflate.findViewById(R.id.br_diner_sausage);
        this.mEatsLinears[4] = (LinearLayout) inflate.findViewById(R.id.br_diner_coffee);
        this.mEatsLinears[5] = (LinearLayout) inflate.findViewById(R.id.br_diner_tea);
        this.mEatsLinears[0].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BrDialogDiner.this.mEatsSelected[0]) {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.br_rent_exit));
                    BrDialogDiner.this.mEatsSelected[0] = true;
                } else {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.button_br_gray));
                    BrDialogDiner.this.mEatsSelected[0] = false;
                }
                BrDialogDiner.this.UpdatePriceSum();
            }
        });
        this.mEatsLinears[1].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BrDialogDiner.this.mEatsSelected[1]) {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.br_rent_exit));
                    BrDialogDiner.this.mEatsSelected[1] = true;
                } else {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.button_br_gray));
                    BrDialogDiner.this.mEatsSelected[1] = false;
                }
                BrDialogDiner.this.UpdatePriceSum();
            }
        });
        this.mEatsLinears[2].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BrDialogDiner.this.mEatsSelected[2]) {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.br_rent_exit));
                    BrDialogDiner.this.mEatsSelected[2] = true;
                } else {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.button_br_gray));
                    BrDialogDiner.this.mEatsSelected[2] = false;
                }
                BrDialogDiner.this.UpdatePriceSum();
            }
        });
        this.mEatsLinears[3].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BrDialogDiner.this.mEatsSelected[3]) {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.br_rent_exit));
                    BrDialogDiner.this.mEatsSelected[3] = true;
                } else {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.button_br_gray));
                    BrDialogDiner.this.mEatsSelected[3] = false;
                }
                BrDialogDiner.this.UpdatePriceSum();
            }
        });
        this.mEatsLinears[4].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BrDialogDiner.this.mEatsSelected[4]) {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.br_rent_exit));
                    BrDialogDiner.this.mEatsSelected[4] = true;
                } else {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.button_br_gray));
                    BrDialogDiner.this.mEatsSelected[4] = false;
                }
                BrDialogDiner.this.UpdatePriceSum();
            }
        });
        this.mEatsLinears[5].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogDiner.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BrDialogDiner.this.mEatsSelected[5]) {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.br_rent_exit));
                    BrDialogDiner.this.mEatsSelected[5] = true;
                } else {
                    view.setBackground(ContextCompat.getDrawable(BrDialogDiner.this.getContext(), R.drawable.button_br_gray));
                    BrDialogDiner.this.mEatsSelected[5] = false;
                }
                BrDialogDiner.this.UpdatePriceSum();
            }
        });
        return inflate;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        show(activity.getSupportFragmentManager(), "dialog");
        try {
            this.mMoney = json.getInt("m");
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

    public void onDinerGuiClosed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            this.mGUIManager.sendJsonData(3, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onDinerGuiPurchased(int order) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, order);
            this.mGUIManager.sendJsonData(3, jSONObject);
        } catch (Exception unused) {
        }
    }
}
