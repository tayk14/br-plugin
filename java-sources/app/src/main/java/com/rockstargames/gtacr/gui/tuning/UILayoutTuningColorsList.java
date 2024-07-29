package com.rockstargames.gtacr.gui.tuning;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.CarColorItem;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.TuningColorAdapter;
import com.rockstargames.gtacr.common.UILayout;
import java.util.ArrayList;
import java.util.List;

public class UILayoutTuningColorsList extends UILayout implements TuningColorAdapter.OnClickColorItem {
    private Button buttonBackTuSubmenu;
    private ConstraintLayout buttonPrice;
    private Button buttonResetToning;
    private Button buttonViewCar;
    private GUITuning mainRoot;
    private View rootView;
    private RelativeLayout seekBarBlock;
    private SeekBar seekBarTransparency;
    private TextView switchRGBColors;
    private TextView switchReadyColors;
    private TextView titlePriceBlock;
    private TextView titleSeekBar;
    private TextView typeCurrency;
    private View underlineRGBColor;
    private View underlineReadyColor;
    private TextView valueCostTuning;
    private TextView viewValueTransparency;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;
    private TuningColorAdapter colorAdapter = null;
    private RecyclerView recVListColors = null;
    private List<CarColorItem> colorsList = new ArrayList();
    private int detailsCost = 0;
    private String valueCurrency = "";
    private String valueTransparency = "";
    private String colorSend = "";
    private CarColorItem colorItem = null;
    private int counter = 0;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningColorsList(GUITuning root) {
        this.mainRoot = root;
    }

    public void setStartParameters(int selectorId) {
        cleaningInterface();
        setNewDataInList();
        this.mActiveSelectorId = selectorId;
        updateViewSeekBarAndResetButtonInterface();
    }

    private void cleaningInterface() {
        this.colorSend = "";
        this.detailsCost = 0;
        this.counter = 0;
        setVisiblePriceBlock(false);
        setClickForHeaderColor(false);
        this.seekBarTransparency.setProgress(0);
        this.viewValueTransparency.setText(this.seekBarTransparency.getProgress() + "%");
    }

    private void setNewDataInList() {
        if (this.colorsList.size() != 0) {
            TuningColorAdapter tuningColorAdapter = new TuningColorAdapter(getContext(), this.colorsList, this);
            this.colorAdapter = tuningColorAdapter;
            tuningColorAdapter.setOnlyColorClickable(-1);
            setColorDataInView();
        }
    }

    private void updateViewSeekBarAndResetButtonInterface() {
        int i = this.mActiveSelectorId;
        if (i == 3 || i == 4) {
            this.seekBarBlock.setVisibility(0);
            this.valueTransparency = "FF";
            this.buttonResetToning.setVisibility(0);
            return;
        }
        this.seekBarBlock.setVisibility(4);
        this.valueTransparency = "";
        this.buttonResetToning.setVisibility(4);
    }

    public void setStartColor(List<String> listAllColors) {
        if (listAllColors.size() != 0) {
            int i = this.mActiveSelectorId;
            if (i == 0) {
                updateStartColor(listAllColors.get(0));
                return;
            }
            if (i != 1) {
                if (i == 3) {
                    updateStartColor(listAllColors.get(2));
                    setTransparency(listAllColors.get(2));
                    return;
                } else if (i == 4) {
                    updateStartColor(listAllColors.get(3));
                    setTransparency(listAllColors.get(3));
                    return;
                } else if (i != 32) {
                    switch (i) {
                        case 10:
                            updateStartColor(listAllColors.get(4));
                            return;
                        case 11:
                            updateStartColor(listAllColors.get(5));
                            return;
                        case 12:
                            updateStartColor(listAllColors.get(6));
                            return;
                        case 13:
                            updateStartColor(listAllColors.get(7));
                            return;
                        default:
                            return;
                    }
                }
            }
            updateStartColor(listAllColors.get(1));
        }
    }

    private void updateStartColor(String getColor) {
        if (getColor.length() == 8) {
            getColor = getColor.substring(2);
        } else if (getColor.length() == 7) {
            getColor = getColor.substring(1);
        }
        if (getColor.equals("0")) {
            getColor = "000000";
        }
        String str = "#" + getColor;
        if (this.colorsList.size() != 0) {
            for (int i = 0; i < this.colorsList.size(); i++) {
                if (this.colorsList.get(i).getColor().equals(str)) {
                    this.colorsList.get(i).setStartColor(true);
                    this.colorAdapter.notifyItemChanged(i);
                    setVisiblePriceBlock(false);
                } else if (this.colorsList.get(i).getStartColor()) {
                    this.colorsList.get(i).setStartColor(false);
                    this.colorAdapter.notifyItemChanged(i);
                }
            }
        }
    }

    public void resetColorParameters() {
        for (int i = 0; i < this.colorsList.size(); i++) {
            if (this.colorsList.get(i).getStartColor()) {
                this.colorsList.get(i).setStartColor(false);
                this.colorAdapter.notifyItemChanged(i);
            }
        }
        this.seekBarTransparency.setProgress(0);
        this.viewValueTransparency.setText(this.seekBarTransparency.getProgress() + "%");
    }

    private void setTransparency(String getColor) {
        String str;
        if (getColor.length() == 8) {
            str = getColor.substring(0, 2);
        } else if (getColor.length() == 7) {
            str = "0" + getColor.substring(0, 1);
        } else {
            str = "00";
        }
        this.seekBarTransparency.setProgress(this.seekBarTransparency.getMax() - (((Integer.parseInt(str, 16) - 96) * 100) / 159));
    }

    @Override
    public View getView() {
        return this.rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_color_list, (ViewGroup) null, false);
        this.rootView = inflate;
        this.recVListColors = (RecyclerView) inflate.findViewById(R.id.recv_colors_list);
        this.titlePriceBlock = (TextView) this.rootView.findViewById(R.id.title_price_block_color);
        this.valueCostTuning = (TextView) this.rootView.findViewById(R.id.tuning_value_price_color);
        this.buttonPrice = (ConstraintLayout) this.rootView.findViewById(R.id.tuning_price_color);
        this.typeCurrency = (TextView) this.rootView.findViewById(R.id.tuning_currency_color);
        this.buttonBackTuSubmenu = (Button) this.rootView.findViewById(R.id.back_to_submenu_color);
        this.buttonViewCar = (Button) this.rootView.findViewById(R.id.button_view_car_color);
        this.switchRGBColors = (TextView) this.rootView.findViewById(R.id.list_rgb_colors);
        this.underlineRGBColor = this.rootView.findViewById(R.id.underline_rgb);
        this.switchReadyColors = (TextView) this.rootView.findViewById(R.id.list_ready_colors);
        this.underlineReadyColor = this.rootView.findViewById(R.id.underline_ready_colors);
        this.seekBarTransparency = (SeekBar) this.rootView.findViewById(R.id.tuning_seekbar_color);
        this.viewValueTransparency = (TextView) this.rootView.findViewById(R.id.value_transparency_color);
        this.titleSeekBar = (TextView) this.rootView.findViewById(R.id.seekbar_header_color);
        this.seekBarBlock = (RelativeLayout) this.rootView.findViewById(R.id.seekbar_view_color);
        this.buttonResetToning = (Button) this.rootView.findViewById(R.id.button_reset_toning_ready);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        getColorItems();
        this.switchRGBColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningColorsList.this.lambda$onCreateView$0$UILayoutTuningColorsList(view);
            }
        });
        this.switchReadyColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningColorsList.this.lambda$onCreateView$1$UILayoutTuningColorsList(view);
            }
        });
        this.buttonViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningColorsList.this.lambda$onCreateView$3$UILayoutTuningColorsList(view);
            }
        });
        this.buttonPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningColorsList.this.lambda$onCreateView$5$UILayoutTuningColorsList(view);
            }
        });
        this.buttonBackTuSubmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningColorsList.this.lambda$onCreateView$7$UILayoutTuningColorsList(view);
            }
        });
        this.seekBarTransparency.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                UILayoutTuningColorsList.this.viewValueTransparency.setText(seekBar.getProgress() + "%");
                UILayoutTuningColorsList.this.valueTransparency = Integer.toHexString((((seekBar.getMax() - seekBar.getProgress()) * 159) / 100) + 96).toUpperCase();
                if (UILayoutTuningColorsList.this.valueTransparency.length() == 1) {
                    UILayoutTuningColorsList uILayoutTuningColorsList = UILayoutTuningColorsList.this;
                    uILayoutTuningColorsList.valueTransparency = "0" + UILayoutTuningColorsList.this.valueTransparency;
                }
                if (UILayoutTuningColorsList.this.counter != 0) {
                    UILayoutTuningColorsList.this.sendColorToClient();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (UILayoutTuningColorsList.this.colorItem != null) {
                    UILayoutTuningColorsList.this.setVisiblePriceBlock(true);
                }
            }
        });
        this.buttonResetToning.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningColorsList.this.lambda$onCreateView$8$UILayoutTuningColorsList(view);
            }
        });
        return this.rootView;
    }

    public void lambda$onCreateView$0$UILayoutTuningColorsList(View view) {
        this.mainRoot.listenerLayout(8);
        this.colorSend = "";
    }

    public void lambda$onCreateView$1$UILayoutTuningColorsList(View view) {
        setClickForHeaderColor(false);
    }

    public void lambda$onCreateView$3$UILayoutTuningColorsList(View view) {
        view.startAnimation(this.anim);
        this.mainRoot.saveLayoutForViewCar(5);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningColorsList.this.lambda$null$2$UILayoutTuningColorsList();
            }
        }, 250L);
    }

    public void lambda$null$2$UILayoutTuningColorsList() {
        this.mainRoot.listenerLayout(1);
    }

    public void lambda$onCreateView$5$UILayoutTuningColorsList(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningColorsList.this.lambda$null$4$UILayoutTuningColorsList();
            }
        }, 250L);
    }

    public void lambda$null$4$UILayoutTuningColorsList() {
        this.mainRoot.applyBuyNewItem(1, this.detailsCost, this.valueCurrency, this.mActiveSelectorId, 2);
    }

    public void lambda$onCreateView$7$UILayoutTuningColorsList(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningColorsList.this.lambda$null$6$UILayoutTuningColorsList();
            }
        }, 250L);
    }

    public void lambda$null$6$UILayoutTuningColorsList() {
        this.mainRoot.backToSubmenu();
    }

    public void lambda$onCreateView$8$UILayoutTuningColorsList(View view) {
        this.mainRoot.applyResetDetails(this.mActiveSelectorId, 2, -1);
    }

    private void getColorItems() {
        this.colorsList.clear();
        this.colorsList = App.getInstance().getCarColorItems();
    }

    private void setColorDataInView() {
        this.recVListColors.setLayoutManager(setHorizontalLayout());
        this.recVListColors.setAdapter(this.colorAdapter);
    }

    private RecyclerView.LayoutManager setHorizontalLayout() {
        return new LinearLayoutManager(this.rootView.getContext(), 0, false);
    }

    private void setClickForHeaderColor(boolean isClickedReadyColor) {
        if (isClickedReadyColor) {
            this.switchRGBColors.setTextColor(getContext().getResources().getColor(R.color.green_check_element));
            this.underlineRGBColor.setVisibility(0);
            this.switchReadyColors.setTextColor(getContext().getResources().getColor(R.color.white));
            this.underlineReadyColor.setVisibility(4);
            return;
        }
        this.switchRGBColors.setTextColor(getContext().getResources().getColor(R.color.white));
        this.switchReadyColors.setTextColor(getContext().getResources().getColor(R.color.green_check_element));
        this.underlineRGBColor.setVisibility(4);
        this.underlineReadyColor.setVisibility(0);
    }

    @Override
    public void click(CarColorItem colorItem, int getPosition, View view) {
        this.colorAdapter.setOnlyColorClickable(getPosition);
        this.detailsCost = this.mainRoot.setCost(this.mActiveSelectorId);
        setVisiblePriceBlock(true);
        setPrice();
        this.colorItem = colorItem;
        sendColorToClient();
        this.counter++;
    }

    public void sendColorToClient() {
        String color = this.colorItem.getColor();
        if (color.startsWith("#")) {
            color = color.substring(1);
        }
        if (this.valueTransparency.equals("")) {
            this.colorSend = "FF" + color;
        } else {
            this.colorSend = this.valueTransparency + color;
        }
        this.mainRoot.putColorToClient(23, this.colorSend);
    }

    public void setVisiblePriceBlock(boolean isVisible) {
        if (isVisible) {
            this.titlePriceBlock.setVisibility(0);
            this.buttonPrice.setVisibility(0);
            return;
        }
        this.titlePriceBlock.setVisibility(4);
        this.buttonPrice.setVisibility(4);
    }

    private void setPrice() {
        this.valueCostTuning.setText(GUIManager.getPriceWithSpaces(this.detailsCost));
        this.valueCurrency = "₽";
        this.typeCurrency.setText("₽");
    }

    public CarColorItem getBuyThisColor() {
        return this.colorItem;
    }

    public void setEmptyObject() {
        this.colorItem = null;
    }

    public String getColorItem() {
        return this.colorSend;
    }

    public String getHexValueColorTransparency() {
        return this.valueTransparency;
    }

    public void setEmptyTransparency() {
        this.valueTransparency = "";
    }
}
