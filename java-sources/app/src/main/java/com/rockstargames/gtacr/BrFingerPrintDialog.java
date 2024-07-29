package com.rockstargames.gtacr;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.google.firebase.messaging.Constants;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrFingerPrintDialog extends DialogFragment implements ISAMPGUI {
    private NvEventQueueActivity mContext = null;
    private GUIManager mGUIManager = null;
    private String textInfo;
    private TextView textStatus;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 12;
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
        return new BrFingerPrintDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWithDelay() {
        new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrFingerPrintDialog.1
            @Override // java.lang.Runnable
            public void run() {
                BrFingerPrintDialog.this.OnExitButtClicked();
                BrFingerPrintDialog.this.dismissAllowingStateLoss();
            }
        }, 1000L);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_fingerprint, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getActivity();
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().getDecorView().getBackground().setAlpha(0);
        getDialog().setCancelable(false);
        this.textStatus = (TextView) inflate.findViewById(R.id.br_fingerprint_text);
        Button button = (Button) inflate.findViewById(R.id.br_fingerprint_butt);
        this.textStatus.setText(this.textInfo);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrFingerPrintDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(BrFingerPrintDialog.this.getContext(), R.anim.button_click));
                BrFingerPrintDialog.this.dismissWithDelay();
            }
        });
        return inflate;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        try {
            this.textInfo = json.getString("s");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void OnExitButtClicked() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            this.mGUIManager.sendJsonData(12, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void OnScanResult(String key) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            jSONObject.put(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS, key);
            this.mGUIManager.sendJsonData(12, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
