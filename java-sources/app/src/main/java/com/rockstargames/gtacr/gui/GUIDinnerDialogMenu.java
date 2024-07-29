package com.rockstargames.gtacr.gui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.DialogDinnerAdapter;
import com.rockstargames.gtacr.data.DataFood;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class GUIDinnerDialogMenu implements ISAMPGUI {
    private static final float ACTIVITY_BUTTON = 1.0f;
    private static final int GRID_LINE_VALUE = 2;
    private static final String KEY_ACTION_TYPE = "t";
    private static final String KEY_GET_MONEY = "m";
    private static final String KEY_ORDER_MASK = "r";
    private static final float NO_ACTIVITY_BUTTON = 0.5f;
    private static final int VALUE_ACTION_EMPTY_CLOSE = 0;
    private static final int VALUE_ACTION_SUCCESSFUL_CLOSE = 1;
    private TextView currencyPriceView;
    private RelativeLayout purchaseButton;
    private TextView titlePriceView;
    private TextView totalValuePriceView;
    private final List<DataFood> dataFoodList = new ArrayList();
    private int totalPrice = 0;
    private NvEventQueueActivity context = null;
    private View rootView = null;
    private PopupWindow popupWindow = null;
    private GUIManager guiManager = null;
    private boolean statusPurchase = false;
    private int myMoney = 0;

    @Override
    public int getGuiId() {
        return 3;
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new GUIDinnerDialogMenu();
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.context = activity;
        this.guiManager = manager;
        try {
            this.myMoney = json.getInt("m");
        } catch (Exception unused) {
        }
        if (this.popupWindow == null) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.dinner_dialog, (ViewGroup) null, false);
            this.rootView = inflate;
            this.totalValuePriceView = (TextView) inflate.findViewById(R.id.br_diner_value_price_sum);
            this.titlePriceView = (TextView) this.rootView.findViewById(R.id.br_diner_title_price_sum);
            this.currencyPriceView = (TextView) this.rootView.findViewById(R.id.br_diner_currency_price_sum);
            this.purchaseButton = (RelativeLayout) this.rootView.findViewById(R.id.br_diner_purchase_button);
            setDataFood();
            setStartView();
            this.popupWindow = new PopupWindow(this.rootView, -2, -2, true);
            setDataInView(new DialogDinnerAdapter.OnUserClickListenerEatsDialog() {
                @Override
                public void click(DataFood dataFood, View view) {
                    if (!dataFood.isClickableListener()) {
                        dataFood.setClickableListener(true);
                        view.setBackground(ContextCompat.getDrawable(GUIDinnerDialogMenu.this.context, R.drawable.br_rent_exit));
                        GUIDinnerDialogMenu.this.setTotalPrice(true, dataFood);
                    } else {
                        dataFood.setClickableListener(false);
                        view.setBackground(ContextCompat.getDrawable(GUIDinnerDialogMenu.this.context, R.drawable.button_br_gray));
                        GUIDinnerDialogMenu.this.setTotalPrice(false, dataFood);
                    }
                    GUIDinnerDialogMenu gUIDinnerDialogMenu = GUIDinnerDialogMenu.this;
                    if (gUIDinnerDialogMenu.checkClickable(gUIDinnerDialogMenu.dataFoodList)) {
                        GUIDinnerDialogMenu.this.setVisibilityView();
                    } else {
                        GUIDinnerDialogMenu.this.setStartView();
                    }
                }
            });
            this.rootView.findViewById(R.id.close_button_dinner_dialog).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIDinnerDialogMenu.this.close(null);
                }
            });
            this.popupWindow.showAtLocation(activity.getParentLayout(), 17, 100, 0);
            this.purchaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (GUIDinnerDialogMenu.this.purchaseButton.getAlpha() == 1.0f) {
                        int i = 0;
                        for (int i2 = 0; i2 < GUIDinnerDialogMenu.this.dataFoodList.size(); i2++) {
                            if (((DataFood) GUIDinnerDialogMenu.this.dataFoodList.get(i2)).isClickableListener()) {
                                i |= 1 << i2;
                            }
                        }
                        GUIDinnerDialogMenu.this.statusPurchase = true;
                        GUIDinnerDialogMenu.this.putDataToServer(i);
                        GUIDinnerDialogMenu.this.popupWindow.dismiss();
                    }
                }
            });
            this.popupWindow.setOutsideTouchable(false);
        }
    }

    public boolean checkClickable(List<DataFood> dataFood) {
        boolean z = false;
        for (int i = 0; i < dataFood.size(); i++) {
            if (dataFood.get(i).isClickableListener()) {
                z = true;
            }
        }
        return z;
    }

    private void setDataFood() {
        this.dataFoodList.clear();
        this.dataFoodList.add(new DataFood(1, R.drawable.br_diner_hotdog, this.context.getString(R.string.dinner_dialog_product_hotdog), 5, 120));
        this.dataFoodList.add(new DataFood(2, R.drawable.br_diner_cheburek, this.context.getString(R.string.dinner_dialog_product_cheburek), 10, 230));
        this.dataFoodList.add(new DataFood(3, R.drawable.br_diner_pie, this.context.getString(R.string.dinner_dialog_product_pie), 15, 320));
        this.dataFoodList.add(new DataFood(4, R.drawable.br_diner_sausage, this.context.getString(R.string.dinner_dialog_product_sausage), 20, 580));
        this.dataFoodList.add(new DataFood(5, R.drawable.br_diner_coffe, this.context.getString(R.string.dinner_dialog_product_coffee), 3, 80));
        this.dataFoodList.add(new DataFood(6, R.drawable.br_diner_tea, this.context.getString(R.string.dinner_dialog_product_tea), 2, 30));
    }

    private int getColumnValue() {
        double size = this.dataFoodList.size();
        Double.isNaN(size);
        return (int) Math.round(size / 2.0d);
    }

    private void setDataInView(DialogDinnerAdapter.OnUserClickListenerEatsDialog thisOnUserClickListenerEatsDialog) {
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.list_items_food_dinner_dialog);
        DialogDinnerAdapter dialogDinnerAdapter = new DialogDinnerAdapter(this.dataFoodList, thisOnUserClickListenerEatsDialog);
        recyclerView.setLayoutManager(new GridLayoutManager(this.rootView.getContext(), getColumnValue()));
        recyclerView.setAdapter(dialogDinnerAdapter);
    }

    public void setVisibilityView() {
        if (this.myMoney <= this.totalPrice) {
            this.currencyPriceView.setVisibility(4);
            this.totalValuePriceView.setVisibility(4);
            this.titlePriceView.setText(this.context.getText(R.string.dinner_dialog_title_price_if_not_money));
            this.purchaseButton.setAlpha(0.5f);
            return;
        }
        this.currencyPriceView.setVisibility(0);
        this.totalValuePriceView.setVisibility(0);
        this.titlePriceView.setText(this.context.getText(R.string.dinner_dialog_title_price_sum));
        this.purchaseButton.setAlpha(1.0f);
    }

    public void setStartView() {
        this.currencyPriceView.setVisibility(4);
        this.totalValuePriceView.setVisibility(4);
        this.titlePriceView.setText(this.context.getText(R.string.dinner_dialog_title_price_if_null_sum));
        this.purchaseButton.setAlpha(0.5f);
    }

    public void setTotalPrice(boolean isClickable, DataFood dataFood) {
        if (!isClickable) {
            this.totalPrice -= dataFood.getPriceFood();
        } else {
            this.totalPrice += dataFood.getPriceFood();
        }
        this.totalValuePriceView.setText(String.valueOf(this.totalPrice));
    }

    public void putDataToServer(int getData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put("r", getData);
            this.guiManager.sendJsonData(3, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void sendInfoToCloseEmptyDialog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            this.guiManager.sendJsonData(3, jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            if (this.statusPurchase) {
                return;
            }
            sendInfoToCloseEmptyDialog();
        }
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
