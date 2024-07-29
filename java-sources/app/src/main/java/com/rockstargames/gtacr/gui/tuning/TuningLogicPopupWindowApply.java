package com.rockstargames.gtacr.gui.tuning;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import blackrussia.online.R;
import blackrussia.online.network.CarColorItem;
import blackrussia.online.network.Tune;
import blackrussia.online.network.TuneVinyls;

public class TuningLogicPopupWindowApply {
    private int actionClick;
    private View applyRepeatView;
    private Button buttonAction;
    private ImageView buttonCloseWindow;
    private Context context;
    private ImageView iconMoney;
    private GUITuning root;
    private TextView textAction;
    private int thisActions;
    private String thisCurrency;
    private int thisPrice;
    private TextView titleChange;
    private int typeMenu;
    private TextView valueCurrency;
    private TextView valuePrice;
    private Animation anim = null;
    private Tune detailItem = null;
    private CarColorItem colorItem = null;
    private int collapse = 0;
    private String colorTransparency = "";
    private TuneVinyls tuneVinyl = null;
    private String color = "";
    private int mActiveSelectorId = -1;

    public TuningLogicPopupWindowApply(GUITuning root, View view, Context context, int typeMenu) {
        this.typeMenu = -1;
        this.applyRepeatView = view;
        this.root = root;
        this.context = context;
        this.typeMenu = typeMenu;
    }

    public void setDataInPopupWindow(int thisActions, int thisPrice, String thisCurrency) {
        this.thisActions = thisActions;
        this.thisPrice = thisPrice;
        this.thisCurrency = thisCurrency;
    }

    public void startWindow() {
        this.actionClick = -1;
        findViewDataInLayout();
        setDataInLayout();
        getActions();
    }

    public void setSelectorId(int selectorId) {
        this.mActiveSelectorId = selectorId;
    }

    private void findViewDataInLayout() {
        this.titleChange = (TextView) this.applyRepeatView.findViewById(R.id.change_title_submenu_apply);
        this.textAction = (TextView) this.applyRepeatView.findViewById(R.id.title_price_action);
        this.valuePrice = (TextView) this.applyRepeatView.findViewById(R.id.tuning_value_price_apply);
        this.valueCurrency = (TextView) this.applyRepeatView.findViewById(R.id.tuning_currency_apply);
        this.buttonAction = (Button) this.applyRepeatView.findViewById(R.id.button_apply_buy);
        this.buttonCloseWindow = (ImageView) this.applyRepeatView.findViewById(R.id.button_close_submenu_apply);
        this.iconMoney = (ImageView) this.applyRepeatView.findViewById(R.id.icon_money_apply);
    }

    private void setDataInLayout() {
    }

    private void getActions() {
        this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
        this.buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningLogicPopupWindowApply.this.lambda$getActions$2$TuningLogicPopupWindowApply(view);
            }
        });
        this.buttonCloseWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningLogicPopupWindowApply.this.lambda$getActions$4$TuningLogicPopupWindowApply(view);
            }
        });
    }

    public void lambda$getActions$2$TuningLogicPopupWindowApply(View view) {
        view.startAnimation(this.anim);
        int i = this.thisActions;
        if (i == 0) {
            this.root.putIntegerDataToServer(8, this.root.getRepairDetail());
        } else if (i == 1) {
            int i2 = this.typeMenu;
            if (i2 == 1) {
                String color = this.root.getColor();
                this.root.putColorDataWithSelectorIDToServer(1, color, this.mActiveSelectorId);
                Log.v("LOG_VIEW", "buy RGB color from logic: " + color);
            } else if (i2 == 2) {
                this.root.putColorDataWithSelectorIDToServer(1, this.color, this.mActiveSelectorId);
                Log.v("LOG_VIEW", "buy color from logic: " + this.color);
            } else if (i2 == 3) {
                String name = this.detailItem.getName();
                Log.v("LOG_VIEW", "buy detail from logic: " + name);
                this.root.putIntegerDataToServer(7, this.detailItem.getId());
            } else if (i2 == 4) {
                String nameVinyl = this.tuneVinyl.getNameVinyl();
                Log.v("LOG_VIEW", "buy vinyl from logic: " + nameVinyl);
                this.root.putIntegerDataToServer(3, this.tuneVinyl.getId());
            }
        } else if (i == 2) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    TuningLogicPopupWindowApply.this.lambda$null$0$TuningLogicPopupWindowApply();
                }
            }, 280L);
        } else if (i == 4) {
            this.root.putIntegerDataWithSelectorIDToServer(12, this.collapse, this.mActiveSelectorId);
            Log.v("LOG_VIEW", "buy collapse from logic: " + this.collapse);
        } else if (i == 6) {
            this.root.putIntegerDataToServer(7, this.mActiveSelectorId);
            Log.v("LOG_VIEW", "buy in main menu from logic");
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningLogicPopupWindowApply.this.lambda$null$1$TuningLogicPopupWindowApply();
            }
        }, 250L);
    }

    public void lambda$null$0$TuningLogicPopupWindowApply() {
        this.root.putPlayersActionToServer(6);
    }

    public void lambda$null$1$TuningLogicPopupWindowApply() {
        this.root.closeApplyWindow();
    }

    public void lambda$getActions$4$TuningLogicPopupWindowApply(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningLogicPopupWindowApply.this.lambda$null$3$TuningLogicPopupWindowApply();
            }
        }, 250L);
    }

    public void lambda$null$3$TuningLogicPopupWindowApply() {
        this.root.closeApplyWindow();
    }
}
