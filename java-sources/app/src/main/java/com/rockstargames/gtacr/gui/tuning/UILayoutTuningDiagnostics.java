package com.rockstargames.gtacr.gui.tuning;

import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import com.rockstargames.gtacr.adapters.TuningDetailsInDiagnosticAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.TuningDetailDiagnosticItem;
import java.util.ArrayList;
import java.util.List;

public class UILayoutTuningDiagnostics extends UILayout implements TuningDetailsInDiagnosticAdapter.OnClickDetailInDiagnosticItem {
    private Button buttonBackToSubmenu;
    private Button buttonDiagnostics;
    private LinearLayout linearLayoutParent;
    private GUITuning mainRoot;
    private RelativeLayout.LayoutParams params;
    private View rootView;
    private TextView viewThisStatusDiagnostics;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;
    private TuningDetailsInDiagnosticAdapter detailsAdapter = null;
    private RecyclerView recVListDetails = null;
    private List<TuningDetailDiagnosticItem> detailsItems = new ArrayList();
    private int detailsCost = 0;
    private String valueCurrency = " ₽";
    private int statusDiagnostics = -1;
    private int costDiagnostic = 0;
    private int gosCost = 0;
    private int thisRepairDetail = -1;
    private int[] listCosts = new int[7];
    private int isApplyPopupwindow = 0;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningDiagnostics(GUITuning root) {
        this.mainRoot = root;
    }

    public void setStatusDiagnosticAndChangeParameters(int statusDiagnostics) {
        this.statusDiagnostics = statusDiagnostics;
        changeViewButton(statusDiagnostics);
        setStatusDiagnostics(statusDiagnostics);
    }

    public void setStartParameters(List<Integer> detailsStatus) {
        setGosCost();
        setListCosts();
        double d = this.gosCost;
        Double.isNaN(d);
        this.costDiagnostic = (int) Math.round(((d * 0.005d) / 100.0d) + 2000.0d);
        Log.v("LOG_VIEW", "cost diagnostic = " + this.costDiagnostic);
        if (detailsStatus.size() != 0) {
            if (detailsStatus.size() == 3) {
                setDetailsForTesla();
            } else {
                setDetailsForEngine();
            }
            for (int i = 0; i < this.detailsItems.size(); i++) {
                this.detailsItems.get(i).setValueState(detailsStatus.get(i).intValue());
                this.detailsItems.get(i).setCost(this.listCosts[i]);
            }
            this.detailsAdapter = new TuningDetailsInDiagnosticAdapter(this.mainRoot, getContext(), this.detailsItems, this, this.statusDiagnostics);
            setDetailsInView();
            this.detailsCost = 0;
            if (this.detailsItems.size() < 4) {
                this.linearLayoutParent.setLayoutParams(this.params);
            }
        }
    }

    private void setGosCost() {
        this.gosCost = this.mainRoot.getGosCost();
    }

    private void setListCosts() {
        int i = this.gosCost;
        double d = i;
        Double.isNaN(d);
        double d2 = i;
        Double.isNaN(d2);
        double d3 = i;
        Double.isNaN(d3);
        double d4 = i;
        Double.isNaN(d4);
        double d5 = i;
        Double.isNaN(d5);
        double d6 = i;
        Double.isNaN(d6);
        double d7 = i;
        Double.isNaN(d7);
        this.listCosts[0] = (int) Math.round((d * 1.0d) / 100.0d);
        this.listCosts[1] = (int) Math.round(((d2 * 0.005d) / 100.0d) + 2000.0d);
        this.listCosts[2] = (int) Math.round((d3 * 0.5d) / 100.0d);
        this.listCosts[3] = (int) Math.round((d4 * 1.0d) / 100.0d);
        this.listCosts[4] = (int) Math.round((d5 * 0.5d) / 100.0d);
        this.listCosts[5] = (int) Math.round(((d6 * 0.005d) / 100.0d) + 500.0d);
        this.listCosts[6] = (int) Math.round(((d7 * 0.005d) / 100.0d) + 5000.0d);
    }

    public void updateStatusDetail(int idDetail) {
        for (int i = 0; i < this.detailsItems.size(); i++) {
            if (i == idDetail) {
                this.detailsItems.get(i).setValueState(100);
                this.detailsAdapter.notifyItemChanged(i);
            }
        }
    }

    public void getPopupApplyRepair() {
        this.mainRoot.applyBuyNewItem(0, this.detailsCost, this.valueCurrency, this.mActiveSelectorId, 0);
    }

    @Override
    public View getView() {
        return this.rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_diagnostics, (ViewGroup) null, false);
        this.rootView = inflate;
        this.recVListDetails = (RecyclerView) inflate.findViewById(R.id.recv_details_list_diagnostics);
        this.viewThisStatusDiagnostics = (TextView) this.rootView.findViewById(R.id.title_actual_diagnostics);
        this.buttonDiagnostics = (Button) this.rootView.findViewById(R.id.tuning_diagnostics);
        this.buttonBackToSubmenu = (Button) this.rootView.findViewById(R.id.back_to_submenu_diagnostics);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.linearLayoutParent = (LinearLayout) this.rootView.findViewById(R.id.menu_block_diagnostics);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.params = layoutParams;
        layoutParams.addRule(19, R.id.help_view_in_diagnostic);
        this.params.addRule(8, R.id.help_view_in_diagnostic);
        this.buttonDiagnostics.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDiagnostics.this.lambda$onCreateView$0$UILayoutTuningDiagnostics(view);
            }
        });
        this.buttonBackToSubmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDiagnostics.this.lambda$onCreateView$2$UILayoutTuningDiagnostics(view);
            }
        });
        return this.rootView;
    }

    public void lambda$onCreateView$0$UILayoutTuningDiagnostics(View view) {
        view.startAnimation(this.anim);
        int i = this.statusDiagnostics;
        if (i == 0) {
            this.mainRoot.applyBuyNewItem(2, this.costDiagnostic, this.valueCurrency, this.mActiveSelectorId, 0);
        } else if (i != 1 || this.detailsCost == 0) {
        } else {
            this.mainRoot.putIntegerDataToServer(9, this.thisRepairDetail);
        }
    }

    public void lambda$onCreateView$2$UILayoutTuningDiagnostics(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningDiagnostics.this.lambda$null$1$UILayoutTuningDiagnostics();
            }
        }, 250L);
    }

    public void lambda$null$1$UILayoutTuningDiagnostics() {
        this.mainRoot.backToSubmenu();
    }

    private void setDetailsForTesla() {
        this.detailsItems.clear();
        this.detailsItems.add(new TuningDetailDiagnosticItem(0, "Электродвигатель", "t_electro_engine_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(1, "Подвеска", "t_suspension_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(2, "Аккумулятор", "t_battery_icon"));
    }

    private void setDetailsForEngine() {
        this.detailsItems.clear();
        this.detailsItems.add(new TuningDetailDiagnosticItem(0, "Двигатель", "t_engine_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(1, "Воздушный фильтр", "t_air_filter_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(2, "Топливная система", "t_fuel_system_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(3, "Трансмиссия", "t_transmission_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(4, "Подвеска", "t_suspension_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(5, "Свечи зажигания", "t_spark_plug_icon"));
        this.detailsItems.add(new TuningDetailDiagnosticItem(6, "Аккумулятор", "t_battery_engine_icon"));
    }

    private void setDetailsInView() {
        this.recVListDetails.setLayoutManager(setHorizontalLayout());
        this.recVListDetails.setAdapter(this.detailsAdapter);
    }

    private RecyclerView.LayoutManager setHorizontalLayout() {
        return new LinearLayoutManager(this.rootView.getContext(), 0, false);
    }

    private void setStatusDiagnostics(int status) {
        if (status == 0) {
            this.viewThisStatusDiagnostics.setText(R.string.tuning_diagnostic_status_no_actual);
            this.viewThisStatusDiagnostics.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.tuning_bg_not_actual_diagnostics));
            return;
        }
        this.viewThisStatusDiagnostics.setText(R.string.tuning_diagnostic_status_actual);
        this.viewThisStatusDiagnostics.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.tuning_bg_actual_diagnostics));
    }

    public void startDiagnostic() {
        this.mainRoot.startDiagnostic();
    }

    @Override
    public void clickInDiagnostic(TuningDetailDiagnosticItem detailsItem, int getPosition, View view) {
        this.detailsAdapter.setOnlyItemClickable(getPosition);
        this.detailsCost = detailsItem.getCost();
        this.thisRepairDetail = detailsItem.getId();
    }

    public int getThisRepairDetail() {
        return this.thisRepairDetail;
    }

    private void changeViewButton(int statusDiagnostics) {
        if (statusDiagnostics == 0) {
            this.buttonDiagnostics.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.tuning_icon_diagnostics), (Drawable) null, (Drawable) null, (Drawable) null);
            this.buttonDiagnostics.setText(R.string.tuning_title_diagnostic_button);
            return;
        }
        this.buttonDiagnostics.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.tuning_repair), (Drawable) null, (Drawable) null, (Drawable) null);
        this.buttonDiagnostics.setText(R.string.tuning_submenu_button_repeat);
    }
}
