package com.rockstargames.gtacr.gui.tuning;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import blackrussia.online.R;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import com.rockstargames.gtacr.common.UILayout;

public class UILayoutTuningViewCar extends UILayout {
    private Button buttonBack;
    private ImageView doorSwitch;
    private ImageView lightSwitch;
    private GUITuning mainRoot;
    private View rootView;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;
    private boolean checkDoorSwitch = false;
    private boolean checkLightSwitch = false;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningViewCar(GUITuning root) {
        this.mainRoot = root;
    }

    @Override
    public View getView() {
        return this.rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_view_car, (ViewGroup) null, false);
        this.rootView = inflate;
        this.doorSwitch = (ImageView) inflate.findViewById(R.id.button_door_view);
        this.lightSwitch = (ImageView) this.rootView.findViewById(R.id.button_light_view);
        this.buttonBack = (Button) this.rootView.findViewById(R.id.back_menu_view);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.doorSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningViewCar.this.lambda$onCreateView$0$UILayoutTuningViewCar(view);
            }
        });
        this.lightSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningViewCar.this.lambda$onCreateView$1$UILayoutTuningViewCar(view);
            }
        });
        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningViewCar.this.lambda$onCreateView$3$UILayoutTuningViewCar(view);
            }
        });
        this.rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int pointerCount = event.getPointerCount();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < pointerCount; i7++) {
                    int pointerId = event.getPointerId(i7);
                    if (pointerId == 0) {
                        i = (int) event.getX(i7);
                        i2 = (int) event.getY(i7);
                    } else if (pointerId == 1) {
                        i3 = (int) event.getX(i7);
                        i4 = (int) event.getY(i7);
                    } else if (pointerId == 2) {
                        i5 = (int) event.getX(i7);
                        i6 = (int) event.getY(i7);
                    }
                }
                int pointerId2 = event.getPointerId(event.getActionIndex());
                UILayoutTuningViewCar.this.mainRoot.getNvContext().customMultiTouchEvent(event.getActionMasked(), pointerId2, i, i2, i3, i4, i5, i6);
                return true;
            }
        });
        return this.rootView;
    }

    public void lambda$onCreateView$0$UILayoutTuningViewCar(View view) {
        view.startAnimation(this.anim);
        if (this.checkDoorSwitch) {
            setEffectForDoorSwitch(false, R.drawable.tuning_door_off);
            this.mainRoot.putPlayersActionToServer(14);
            return;
        }
        setEffectForDoorSwitch(true, R.drawable.tuning_door_on);
        this.mainRoot.putPlayersActionToServer(13);
    }

    public void lambda$onCreateView$1$UILayoutTuningViewCar(View view) {
        view.startAnimation(this.anim);
        if (this.checkLightSwitch) {
            setEffectForLightSwitch(false, R.drawable.tuning_light_off);
            this.mainRoot.putPlayersActionToServer(16);
            return;
        }
        setEffectForLightSwitch(true, R.drawable.tuning_light_on);
        this.mainRoot.putPlayersActionToServer(15);
    }

    public void lambda$onCreateView$3$UILayoutTuningViewCar(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningViewCar.this.lambda$null$2$UILayoutTuningViewCar();
            }
        }, 250L);
    }

    public void lambda$null$2$UILayoutTuningViewCar() {
        this.mainRoot.listenerButtonBackFromViewCar();
        this.mainRoot.putPlayersActionToServer(17);
    }

    private void setEffectForDoorSwitch(boolean isCheck, int resImage) {
        this.checkDoorSwitch = isCheck;
        this.doorSwitch.setImageResource(resImage);
    }

    private void setEffectForLightSwitch(boolean isCheck, int resImage) {
        this.checkLightSwitch = isCheck;
        this.lightSwitch.setImageResource(resImage);
    }
}
