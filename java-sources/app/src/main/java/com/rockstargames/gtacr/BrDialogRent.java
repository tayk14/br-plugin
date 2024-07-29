package com.rockstargames.gtacr;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogRent extends DialogFragment implements ISAMPGUI {
    private NvEventQueueActivity mContext = null;
    private Button[] mButtons = new Button[4];
    private int mClosedByServer = 0;
    private GUIManager mGUIManager = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 6;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogRent();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        onRentGuiClicked(0);
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
        View inflate = inflater.inflate(R.layout.br_rent, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getContext();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().setLayout(-1, -1);
        this.mClosedByServer = 0;
        this.mButtons[0] = (Button) inflate.findViewById(R.id.br_rent_exit);
        this.mButtons[1] = (Button) inflate.findViewById(R.id.br_rent_rent);
        this.mButtons[2] = (Button) inflate.findViewById(R.id.br_rent_prev);
        this.mButtons[3] = (Button) inflate.findViewById(R.id.br_rent_next);
        this.mButtons[0].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogRent.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(BrDialogRent.this.getContext(), R.anim.button_click));
                BrDialogRent.this.dismissAllowingStateLoss();
            }
        });
        this.mButtons[1].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogRent.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(BrDialogRent.this.getContext(), R.anim.button_click));
                BrDialogRent.this.onRentGuiClicked(1);
            }
        });
        this.mButtons[2].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogRent.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(BrDialogRent.this.getContext(), R.anim.button_click));
                BrDialogRent.this.onRentGuiClicked(2);
            }
        });
        this.mButtons[3].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogRent.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(BrDialogRent.this.getContext(), R.anim.button_click));
                BrDialogRent.this.onRentGuiClicked(3);
            }
        });
        return inflate;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        show(activity.getSupportFragmentManager(), "dialog");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        this.mClosedByServer = 1;
        dismissAllowingStateLoss();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        if (getDialog() != null) {
            return getDialog().isShowing();
        }
        return false;
    }

    public void onRentGuiClicked(int type) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", type);
            if (type == 0) {
                jSONObject.put("e", this.mClosedByServer);
            }
            this.mGUIManager.sendJsonData(6, jSONObject);
        } catch (Exception unused) {
        }
    }
}
