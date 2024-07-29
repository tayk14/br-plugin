package com.rockstargames.gtacr.gui.tuning;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import blackrussia.online.R;
import blackrussia.online.databinding.TuningFragmentInfoBinding;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import com.rockstargames.gtacr.common.UILayout;

public class UILayoutTuningViewInfoParameters extends UILayout {
    private TuningFragmentInfoBinding binding;
    private Context context;
    private GUITuning mainRoot;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningViewInfoParameters(GUITuning root) {
        this.mainRoot = root;
    }

    public void setVisibleThisWindow(boolean isVisible) {
        if (isVisible) {
            this.binding.getRoot().setVisibility(0);
        } else {
            this.binding.getRoot().setVisibility(4);
        }
    }

    @Override
    public View getView() {
        return this.binding.getRoot();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        this.binding = TuningFragmentInfoBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.binding.backToSubmenuInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningViewInfoParameters.this.lambda$onCreateView$1$UILayoutTuningViewInfoParameters(view);
            }
        });
        this.binding.tuningViewBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningViewInfoParameters.this.lambda$onCreateView$3$UILayoutTuningViewInfoParameters(view);
            }
        });
        this.binding.buttonBackDetailsInfoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningViewInfoParameters.this.lambda$onCreateView$5$UILayoutTuningViewInfoParameters(view);
            }
        });
        return this.binding.getRoot();
    }

    public void lambda$onCreateView$1$UILayoutTuningViewInfoParameters(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningViewInfoParameters.this.lambda$null$0$UILayoutTuningViewInfoParameters();
            }
        }, 250L);
    }

    public void lambda$null$0$UILayoutTuningViewInfoParameters() {
        this.mainRoot.listenerLayout(4);
    }

    public void lambda$onCreateView$3$UILayoutTuningViewInfoParameters(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningViewInfoParameters.this.lambda$null$2$UILayoutTuningViewInfoParameters();
            }
        }, 250L);
    }

    public void lambda$null$2$UILayoutTuningViewInfoParameters() {
        this.mainRoot.listenerLayout(11);
        setVisibleThisWindow(false);
    }

    public void lambda$onCreateView$5$UILayoutTuningViewInfoParameters(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningViewInfoParameters.this.lambda$null$4$UILayoutTuningViewInfoParameters();
            }
        }, 250L);
    }

    public void lambda$null$4$UILayoutTuningViewInfoParameters() {
        this.mainRoot.listenerLayout(4);
    }
}
