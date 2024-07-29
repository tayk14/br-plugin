package com.rockstargames.gtacr.gui.tuning;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.R;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.common.UILayout;
import com.skydoves.colorpickerview.AlphaTileView;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;
import java.util.List;

public class UILayoutTuningRGBColor extends UILayout {
    private AlphaTileView alphaTileView;
    private LinearLayout blockButtons;
    private LinearLayout blockRGBColor;
    private ConstraintLayout blockWithRGBColor;
    private RelativeLayout blockWithSeekBar;
    private RelativeLayout blockWithSeekbarRGBTransparency;
    private BrightnessSlideBar brightnessSlideBar;
    private Button buttonBackTuSubmenu;
    private ConstraintLayout buttonPrice;
    private Button buttonResetToning;
    private Button buttonSelectedColor;
    private Button buttonViewCar;
    private ColorPickerView colorPickerView;
    private GUITuning mainRoot;
    private View rootView;
    private SeekBar seekbarRGBTransparency;
    private TextView switchReadyColors;
    private TextView titlePriceBlock;
    private TextView typeCurrency;
    private TextView valueCostTuning;
    private TextView viewValueRGBTransparency;
    private Animation anim = null;
    private int detailsCost = 0;
    private String valueCurrency = "";
    private int mActiveSelectorId = -1;
    private String sendColor = "";
    private boolean isRBGColor = false;
    private boolean isThisLayout = false;
    private String valueTransparency = "";

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningRGBColor(GUITuning mainRoot) {
        this.mainRoot = mainRoot;
    }

    public void setStartParameters(int selectorId) {
        this.isThisLayout = false;
        this.isRBGColor = false;
        this.colorPickerView.selectCenter();
        this.sendColor = "";
        this.valueTransparency = "";
        this.detailsCost = 0;
        this.seekbarRGBTransparency.setProgress(0);
        this.blockRGBColor.setVisibility(0);
        this.blockWithSeekBar.setVisibility(0);
        this.blockButtons.setVisibility(4);
        this.blockWithSeekbarRGBTransparency.setVisibility(4);
        this.mActiveSelectorId = selectorId;
        if (selectorId == 3 || selectorId == 4) {
            this.buttonResetToning.setVisibility(0);
        } else {
            this.buttonResetToning.setVisibility(4);
        }
    }

    public void isThisLayout() {
        this.isThisLayout = true;
    }

    public void isNotThisLayout() {
        this.isThisLayout = false;
    }

    public void setStartColor(List<String> listAllColors) {
        if (listAllColors.size() != 0) {
            int i = this.mActiveSelectorId;
            if (i == 0) {
                setStartInitialColor(listAllColors.get(0));
                return;
            }
            if (i != 1) {
                if (i == 3) {
                    setStartInitialColor(listAllColors.get(2));
                    return;
                } else if (i == 4) {
                    setStartInitialColor(listAllColors.get(3));
                    return;
                } else if (i != 32) {
                    switch (i) {
                        case 10:
                            setStartInitialColor(listAllColors.get(4));
                            return;
                        case 11:
                            setStartInitialColor(listAllColors.get(5));
                            return;
                        case 12:
                            setStartInitialColor(listAllColors.get(6));
                            return;
                        case 13:
                            setStartInitialColor(listAllColors.get(7));
                            return;
                        default:
                            return;
                    }
                }
            }
            setStartInitialColor(listAllColors.get(1));
        }
    }

    public void setStartInitialColor(String colorHex) {
        this.colorPickerView.setInitialColor((int) Long.parseLong(colorHex, 16));
    }

    @Override
    public View getView() {
        return this.rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_rgb_color, (ViewGroup) null, false);
        this.rootView = inflate;
        this.blockRGBColor = (LinearLayout) inflate.findViewById(R.id.menu_block_radial_color);
        this.colorPickerView = (ColorPickerView) this.rootView.findViewById(R.id.color_picker_rgb);
        this.blockWithRGBColor = (ConstraintLayout) this.rootView.findViewById(R.id.block_with_this_rgb_color);
        this.alphaTileView = (AlphaTileView) this.rootView.findViewById(R.id.alpha_tile_view_rgb_color);
        this.buttonSelectedColor = (Button) this.rootView.findViewById(R.id.button_selected_color);
        this.buttonViewCar = (Button) this.rootView.findViewById(R.id.button_view_car_rgb_color);
        this.blockWithSeekBar = (RelativeLayout) this.rootView.findViewById(R.id.seekbar_view_rgb_color);
        this.brightnessSlideBar = (BrightnessSlideBar) this.rootView.findViewById(R.id.tuning_seekbar_rgb_color);
        this.blockWithSeekbarRGBTransparency = (RelativeLayout) this.rootView.findViewById(R.id.seekbar_block_rgb_transparency);
        this.seekbarRGBTransparency = (SeekBar) this.rootView.findViewById(R.id.tuning_seekbar_rgb_transparency);
        this.viewValueRGBTransparency = (TextView) this.rootView.findViewById(R.id.value_transparency_color);
        this.blockButtons = (LinearLayout) this.rootView.findViewById(R.id.menu_block_rgb_color);
        this.buttonPrice = (ConstraintLayout) this.rootView.findViewById(R.id.tuning_price_rgb_color);
        this.titlePriceBlock = (TextView) this.rootView.findViewById(R.id.title_price_block_rgb_color);
        this.valueCostTuning = (TextView) this.rootView.findViewById(R.id.tuning_value_price_rgb_color);
        this.typeCurrency = (TextView) this.rootView.findViewById(R.id.tuning_currency_rgb_color);
        this.buttonBackTuSubmenu = (Button) this.rootView.findViewById(R.id.back_to_submenu_rgb_color);
        this.switchReadyColors = (TextView) this.rootView.findViewById(R.id.list_ready_colors_rgb_color);
        this.buttonResetToning = (Button) this.rootView.findViewById(R.id.button_reset_toning_rgb);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.colorPickerView.setColorListener(new ColorEnvelopeListener() {
            @Override
            public final void onColorSelected(ColorEnvelope colorEnvelope, boolean z) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$0$UILayoutTuningRGBColor(colorEnvelope, z);
            }
        });
        this.colorPickerView.attachBrightnessSlider(this.brightnessSlideBar);
        this.blockWithRGBColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$1$UILayoutTuningRGBColor(view);
            }
        });
        this.buttonSelectedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$3$UILayoutTuningRGBColor(view);
            }
        });
        this.buttonViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$5$UILayoutTuningRGBColor(view);
            }
        });
        this.buttonPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$7$UILayoutTuningRGBColor(view);
            }
        });
        this.buttonBackTuSubmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$9$UILayoutTuningRGBColor(view);
            }
        });
        this.switchReadyColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$10$UILayoutTuningRGBColor(view);
            }
        });
        this.seekbarRGBTransparency.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                UILayoutTuningRGBColor.this.viewValueRGBTransparency.setText(seekBar.getProgress() + "%");
                UILayoutTuningRGBColor.this.valueTransparency = Integer.toHexString((((seekBar.getMax() - seekBar.getProgress()) * 159) / 100) + 96).toUpperCase();
                if (UILayoutTuningRGBColor.this.valueTransparency.length() == 1) {
                    UILayoutTuningRGBColor uILayoutTuningRGBColor = UILayoutTuningRGBColor.this;
                    uILayoutTuningRGBColor.valueTransparency = "0" + UILayoutTuningRGBColor.this.valueTransparency;
                }
                UILayoutTuningRGBColor.this.sendColorToClient();
            }
        });
        this.buttonResetToning.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningRGBColor.this.lambda$onCreateView$11$UILayoutTuningRGBColor(view);
            }
        });
        return this.rootView;
    }

    public void lambda$onCreateView$0$UILayoutTuningRGBColor(ColorEnvelope envelope, boolean fromUser) {
        this.alphaTileView.setPaintColor(envelope.getColor());
        String hexCode = envelope.getHexCode();
        this.sendColor = hexCode;
        Log.v("LOG_VIEW", hexCode);
        if (this.isThisLayout) {
            this.mainRoot.putColorToClient(23, this.sendColor);
        }
    }

    public void lambda$onCreateView$1$UILayoutTuningRGBColor(View view) {
        view.startAnimation(this.anim);
        this.blockRGBColor.setVisibility(0);
        this.blockWithSeekBar.setVisibility(0);
        this.blockButtons.setVisibility(4);
        this.blockWithSeekbarRGBTransparency.setVisibility(4);
    }

    public void lambda$onCreateView$3$UILayoutTuningRGBColor(View view) {
        view.startAnimation(this.anim);
        this.detailsCost = this.mainRoot.setCost(this.mActiveSelectorId);
        setPrice();
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningRGBColor.this.lambda$null$2$UILayoutTuningRGBColor();
            }
        }, 250L);
        this.mainRoot.putColorToClient(23, this.sendColor);
        this.seekbarRGBTransparency.setProgress(0);
    }

    public void lambda$null$2$UILayoutTuningRGBColor() {
        this.blockRGBColor.setVisibility(4);
        this.blockWithSeekBar.setVisibility(4);
        this.blockButtons.setVisibility(0);
        int i = this.mActiveSelectorId;
        if (i == 3 || i == 4) {
            this.blockWithSeekbarRGBTransparency.setVisibility(0);
        }
    }

    public void lambda$onCreateView$5$UILayoutTuningRGBColor(View view) {
        view.startAnimation(this.anim);
        this.mainRoot.saveLayoutForViewCar(8);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningRGBColor.this.lambda$null$4$UILayoutTuningRGBColor();
            }
        }, 250L);
    }

    public void lambda$null$4$UILayoutTuningRGBColor() {
        this.mainRoot.listenerLayout(1);
    }

    public void lambda$onCreateView$7$UILayoutTuningRGBColor(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningRGBColor.this.lambda$null$6$UILayoutTuningRGBColor();
            }
        }, 250L);
    }

    public void lambda$null$6$UILayoutTuningRGBColor() {
        this.mainRoot.applyBuyNewItem(1, this.detailsCost, this.valueCurrency, this.mActiveSelectorId, 1);
        this.isRBGColor = true;
    }

    public void lambda$onCreateView$9$UILayoutTuningRGBColor(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningRGBColor.this.lambda$null$8$UILayoutTuningRGBColor();
            }
        }, 250L);
    }

    public void lambda$null$8$UILayoutTuningRGBColor() {
        this.mainRoot.backToSubmenu();
    }

    public void lambda$onCreateView$10$UILayoutTuningRGBColor(View view) {
        this.mainRoot.listenerLayout(6);
        this.isRBGColor = false;
    }

    public void lambda$onCreateView$11$UILayoutTuningRGBColor(View view) {
        this.mainRoot.applyResetDetails(this.mActiveSelectorId, 1, -1);
    }

    private void setPrice() {
        this.valueCostTuning.setText(GUIManager.getPriceWithSpaces(this.detailsCost));
        this.valueCurrency = "₽";
        this.typeCurrency.setText("₽");
    }

    public void sendColorToClient() {
        if (this.sendColor.length() != 0) {
            this.sendColor = this.sendColor.substring(2);
        }
        String str = this.valueTransparency + this.sendColor;
        this.sendColor = str;
        this.mainRoot.putColorToClient(23, str);
    }

    public String getColor() {
        return this.sendColor;
    }

    public boolean isRBGColor() {
        return this.isRBGColor;
    }

    public void setEmptyRGBColor() {
        this.sendColor = "";
        this.isRBGColor = false;
    }
}
