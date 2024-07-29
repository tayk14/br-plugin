package com.rockstargames.gtacr.gui.tuning;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.R;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.common.UILayout;
import java.util.List;

public class UILayoutTuningCollapse extends UILayout {
    private Button buttonBackToSubmenu;
    private ConstraintLayout buttonPrice;
    private Button buttonResetCollapse;
    private Button buttonViewCar;
    private GUITuning mainRoot;
    private String percent;
    private View rootView;
    private SeekBar seekBarCorner;
    private String thisProgress;
    private TextView titlePriceBlock;
    private TextView titleThisParameter;
    private TextView typeCurrency;
    private TextView valueCorner;
    private TextView valueCostTuning;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;
    private int detailsCost = 0;
    private int valueCornerToSend = 0;
    private String valueCurrency = "";

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningCollapse(GUITuning root) {
        this.mainRoot = root;
    }

    public void setNameChangeParameter(String textTitleThisParameter) {
        this.titleThisParameter.setText(textTitleThisParameter);
    }

    public void setActiveSelectorId(int selectorId) {
        this.mActiveSelectorId = selectorId;
    }

    public void setStartParameters(List<Integer> listAllCollapse) {
        this.detailsCost = this.mainRoot.setCost(this.mActiveSelectorId);
        setPrice();
        setStartCollapse(listAllCollapse);
        String str = this.seekBarCorner.getProgress() + this.percent;
        this.thisProgress = str;
        this.valueCorner.setText(str);
    }

    public void setStartCollapse(List<Integer> listAllCollapse) {
        if (listAllCollapse.size() != 0) {
            switch (this.mActiveSelectorId) {
                case 22:
                    setStartParameters(listAllCollapse.get(0).intValue());
                    return;
                case 23:
                    setStartParameters(listAllCollapse.get(1).intValue());
                    return;
                case 24:
                    setStartParameters(listAllCollapse.get(2).intValue());
                    return;
                case 25:
                    setStartParameters(listAllCollapse.get(3).intValue());
                    return;
                case 26:
                    setStartParameters(listAllCollapse.get(4).intValue());
                    return;
                case 27:
                    setStartParameters(listAllCollapse.get(5).intValue());
                    return;
                case 28:
                    setStartParameters(listAllCollapse.get(6).intValue());
                    return;
                case 29:
                    setStartParameters(listAllCollapse.get(7).intValue());
                    return;
                case 30:
                    setStartParameters(listAllCollapse.get(8).intValue());
                    return;
                default:
                    return;
            }
        }
        setStartParameters(50);
    }

    private void setStartParameters(int valueParameter) {
        this.seekBarCorner.setProgress(valueParameter);
    }

    @Override
    public View getView() {
        return this.rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_collapse, (ViewGroup) null, false);
        this.rootView = inflate;
        this.valueCostTuning = (TextView) inflate.findViewById(R.id.tuning_value_price_collapse);
        this.titlePriceBlock = (TextView) this.rootView.findViewById(R.id.title_price_block_collapse);
        this.buttonPrice = (ConstraintLayout) this.rootView.findViewById(R.id.tuning_price_collapse);
        this.typeCurrency = (TextView) this.rootView.findViewById(R.id.tuning_currency_collapse);
        this.buttonBackToSubmenu = (Button) this.rootView.findViewById(R.id.back_to_submenu_collapse);
        this.titleThisParameter = (TextView) this.rootView.findViewById(R.id.seekbar_title_collapse);
        this.valueCorner = (TextView) this.rootView.findViewById(R.id.value_this_corner);
        this.seekBarCorner = (SeekBar) this.rootView.findViewById(R.id.tuning_seekbar_collapse);
        this.buttonViewCar = (Button) this.rootView.findViewById(R.id.button_view_car_collapse);
        this.buttonResetCollapse = (Button) this.rootView.findViewById(R.id.button_reset_collapse);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.percent = getContext().getString(R.string.tuning_percent);
        String str = this.seekBarCorner.getProgress() + this.percent;
        this.thisProgress = str;
        this.valueCorner.setText(str);
        this.buttonPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningCollapse.this.lambda$onCreateView$1$UILayoutTuningCollapse(view);
            }
        });
        this.buttonBackToSubmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningCollapse.this.lambda$onCreateView$3$UILayoutTuningCollapse(view);
            }
        });
        this.buttonViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningCollapse.this.lambda$onCreateView$5$UILayoutTuningCollapse(view);
            }
        });
        this.seekBarCorner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                UILayoutTuningCollapse.this.valueCornerToSend = seekBar.getProgress();
                UILayoutTuningCollapse uILayoutTuningCollapse = UILayoutTuningCollapse.this;
                uILayoutTuningCollapse.thisProgress = UILayoutTuningCollapse.this.valueCornerToSend + UILayoutTuningCollapse.this.percent;
                UILayoutTuningCollapse.this.valueCorner.setText(UILayoutTuningCollapse.this.thisProgress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                UILayoutTuningCollapse.this.valueCornerToSend = seekBar.getProgress();
                UILayoutTuningCollapse.this.mainRoot.putDetailOrCollapseToClient(24, UILayoutTuningCollapse.this.valueCornerToSend);
            }
        });
        this.buttonResetCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningCollapse.this.lambda$onCreateView$6$UILayoutTuningCollapse(view);
            }
        });
        return this.rootView;
    }

    public void lambda$onCreateView$1$UILayoutTuningCollapse(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningCollapse.this.lambda$null$0$UILayoutTuningCollapse();
            }
        }, 250L);
    }

    public void lambda$null$0$UILayoutTuningCollapse() {
        this.mainRoot.applyBuyNewItem(4, this.detailsCost, this.valueCurrency, this.mActiveSelectorId, 5);
    }

    public void lambda$onCreateView$3$UILayoutTuningCollapse(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningCollapse.this.lambda$null$2$UILayoutTuningCollapse();
            }
        }, 250L);
    }

    public void lambda$null$2$UILayoutTuningCollapse() {
        this.mainRoot.backToSubmenu();
    }

    public void lambda$onCreateView$5$UILayoutTuningCollapse(View view) {
        view.startAnimation(this.anim);
        this.mainRoot.saveLayoutForViewCar(14);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningCollapse.this.lambda$null$4$UILayoutTuningCollapse();
            }
        }, 250L);
    }

    public void lambda$null$4$UILayoutTuningCollapse() {
        this.mainRoot.listenerLayout(1);
    }

    public void lambda$onCreateView$6$UILayoutTuningCollapse(View view) {
        this.mainRoot.applyResetDetails(this.mActiveSelectorId, 5, -1);
    }

    private void setPrice() {
        this.valueCostTuning.setText(GUIManager.getPriceWithSpaces(this.detailsCost));
        this.valueCurrency = "₽";
        this.typeCurrency.setText("₽");
    }

    public int getCollapse() {
        return this.valueCornerToSend;
    }

    public void setEmptyValueCorner() {
        this.valueCornerToSend = 0;
    }
}
