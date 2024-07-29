package com.rockstargames.gtacr.gui.tuning;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import blackrussia.online.R;

public class TuningLogicPopupWindowResetDetails {
    private Animation anim = null;
    private Button buttonApplyReset;
    private ImageView buttonCloseApplyReset;
    private Context context;
    private int established;
    private int mActiveSelectorId;
    private GUITuning root;
    private int typeLayout;
    private View viewDialog;

    public TuningLogicPopupWindowResetDetails(GUITuning root, View viewDialog, int mActiveSelectorId, int typeLayout, Context context, int established) {
        this.root = root;
        this.viewDialog = viewDialog;
        this.mActiveSelectorId = mActiveSelectorId;
        this.typeLayout = typeLayout;
        this.context = context;
        this.established = established;
    }

    public void startLogicReset() {
        findViewDataInLayout();
        logicForPopupWindow(this.mActiveSelectorId);
    }

    private void findViewDataInLayout() {
        this.buttonApplyReset = (Button) this.viewDialog.findViewById(R.id.button_apply_reset_details);
        this.buttonCloseApplyReset = (ImageView) this.viewDialog.findViewById(R.id.button_close_submenu_apply);
    }

    private void logicForPopupWindow(final int mActiveSelectorId) {
        this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
        this.buttonCloseApplyReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningLogicPopupWindowResetDetails.this.lambda$logicForPopupWindow$1$TuningLogicPopupWindowResetDetails(view);
            }
        });
        this.buttonApplyReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningLogicPopupWindowResetDetails.this.lambda$logicForPopupWindow$3$TuningLogicPopupWindowResetDetails(mActiveSelectorId, view);
            }
        });
    }

    public void lambda$logicForPopupWindow$1$TuningLogicPopupWindowResetDetails(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningLogicPopupWindowResetDetails.this.lambda$null$0$TuningLogicPopupWindowResetDetails();
            }
        }, 250L);
    }

    public void lambda$null$0$TuningLogicPopupWindowResetDetails() {
        this.root.dismissPopupWindowResetDetails();
    }

    public void lambda$logicForPopupWindow$3$TuningLogicPopupWindowResetDetails(final int mActiveSelectorId, View view) {
        view.startAnimation(this.anim);
        setTypeLayoutInMainRoot(this.typeLayout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningLogicPopupWindowResetDetails.this.lambda$null$2$TuningLogicPopupWindowResetDetails(mActiveSelectorId);
            }
        }, 250L);
    }

    public void lambda$null$2$TuningLogicPopupWindowResetDetails(final int mActiveSelectorId) {
        this.root.putActionResetDetailsToServer(5, mActiveSelectorId, this.established);
        this.root.dismissPopupWindowResetDetails();
    }

    private void setTypeLayoutInMainRoot(int typeLayout) {
        this.root.setTypeLayout(typeLayout);
    }
}
