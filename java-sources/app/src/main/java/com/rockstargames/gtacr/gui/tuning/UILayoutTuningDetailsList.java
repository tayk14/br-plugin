package com.rockstargames.gtacr.gui.tuning;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.TuningFragmentDetailsListBinding;
import blackrussia.online.network.Tune;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import blackrussia.online.network.TuneVinyls;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.TuningDetailsAdapter;
import com.rockstargames.gtacr.adapters.TuningVinylsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import java.util.ArrayList;
import java.util.List;

public class UILayoutTuningDetailsList extends UILayout implements TuningDetailsAdapter.OnClickDetailItem, TuningVinylsAdapter.OnClickVinylItem {
    private TuningFragmentDetailsListBinding binding;
    private final GUITuning mainRoot;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;
    private TuningDetailsAdapter detailsAdapter = null;
    private List<Tune> detailsItems = new ArrayList();
    private int detailsCost = 0;
    private String valueCurrency = "";
    private Tune buyThisDetail = null;
    private List<TuneVinyls> tuneVinyls = new ArrayList();
    private TuningVinylsAdapter tuningVinylsAdapter = null;
    private TuneVinyls tuneVinyl = null;
    private int thisActions = -1;
    private int costVinyl = 0;
    private boolean isBox = false;
    private int counter = 0;
    private int thisElement = 0;
    private boolean isGetType = false;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningDetailsList(GUITuning root) {
        this.mainRoot = root;
    }

    public void setNameThisWindow(String nameWindow) {
        this.binding.titleDetailsList.setText(nameWindow);
    }

    public void setActiveSelectorId(int selectorId) {
        this.mActiveSelectorId = selectorId;
    }

    public void setNewParametersInDetailList(List<Tune> detailsItems) {
        this.isBox = false;
        this.detailsItems.clear();
        this.detailsItems = detailsItems;
        cleaningInterface();
        setNewDataInList(detailsItems);
        visibleForDetailsInfo(false);
        int i = this.mActiveSelectorId;
        if (i == 36 || i == 37 || i == 38 || i == 39 || i == 40) {
            this.binding.buttonInfoBrake.setVisibility(0);
        } else {
            this.binding.buttonInfoBrake.setVisibility(4);
        }
        int i2 = this.mActiveSelectorId;
        switch (i2) {
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                break;
            default:
                switch (i2) {
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                        break;
                    default:
                        this.isGetType = false;
                        visibleForResetDetail(true);
                        return;
                }
        }
        this.isGetType = true;
        visibleForResetDetail(false);
    }

    public void setNewParametersWithVinyls() {
        this.isBox = false;
        this.costVinyl = this.mainRoot.setCost(this.mActiveSelectorId);
        cleaningInterface();
        setListVinyls();
        visibleForDetailsInfo(false);
    }

    private void visibleForDetailsInfo(boolean isVisible) {
        if (isVisible) {
            this.counter = 0;
            this.binding.buttonViewCarDetailsList.setVisibility(4);
            this.binding.buttonInfoBrake.setVisibility(0);
            return;
        }
        this.binding.buttonViewCarDetailsList.setVisibility(0);
        this.binding.buttonInfoBrake.setVisibility(4);
    }

    private void visibleForResetDetail(boolean isVisible) {
        if (isVisible) {
            this.binding.buttonResetDetail.setVisibility(0);
        } else {
            this.binding.buttonResetDetail.setVisibility(4);
        }
    }

    private void setListVinyls() {
        this.tuningVinylsAdapter = new TuningVinylsAdapter(this.mainRoot, getContext(), this.tuneVinyls, this, this.costVinyl);
        setVinylsInView();
        this.tuningVinylsAdapter.setOnlyVinylClickable(-1);
    }

    public void updateStatusVinylsAfterEstablished(int idVinyls) {
        int i = -1;
        boolean z = false;
        for (int i2 = 0; i2 < this.tuneVinyls.size(); i2++) {
            if (this.tuneVinyls.get(i2).getId() == idVinyls) {
                this.tuneVinyls.get(i2).setStartVinyl(true);
                this.tuningVinylsAdapter.notifyItemChanged(i2);
                changeViewButtonForVinyls(this.tuneVinyls.get(i2));
                i = i2;
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < this.tuneVinyls.size(); i3++) {
                if (this.tuneVinyls.get(i3).getStartVinyl() && i3 != i) {
                    this.tuneVinyls.get(i3).setStartVinyl(false);
                    this.tuningVinylsAdapter.notifyItemChanged(i3);
                }
            }
        }
    }

    public void setStartVinyl(String nameVinyl) {
        for (int i = 0; i < this.tuneVinyls.size(); i++) {
            if (this.tuneVinyls.get(i).getNameVinyl().equals(nameVinyl)) {
                this.tuneVinyls.get(i).setStartVinyl(true);
                this.tuningVinylsAdapter.notifyItemChanged(i);
            }
        }
    }

    public void resetVinyls() {
        for (int i = 0; i < this.tuneVinyls.size(); i++) {
            if (this.tuneVinyls.get(i).getStartVinyl()) {
                this.tuneVinyls.get(i).setStartVinyl(false);
                this.tuningVinylsAdapter.notifyItemChanged(i);
                changeViewButtonForVinyls(this.tuneVinyls.get(i));
            }
        }
    }

    private void cleaningInterface() {
        this.detailsCost = 0;
        setVisiblePriceBlock(0);
    }

    public void setVisibleBody(boolean isVisible) {
        if (isVisible) {
            this.binding.getRoot().setVisibility(0);
        } else {
            this.binding.getRoot().setVisibility(4);
        }
    }

    public void updateStatusDetailAfterPurchase(int idDetail) {
        for (int i = 0; i < this.detailsItems.size(); i++) {
            if (this.detailsItems.get(i).getId() == idDetail) {
                this.detailsItems.get(i).setThisLocation(1);
                this.detailsAdapter.notifyItemChanged(i);
                changeViewButtonForDetails(this.detailsItems.get(i));
            }
        }
    }

    public void updateStatusDetailAfterEstablished(int idNewDetail, int idOldDetail) {
        boolean z = false;
        for (int i = 0; i < this.detailsItems.size(); i++) {
            if (this.detailsItems.get(i).getId() == idNewDetail) {
                this.detailsItems.get(i).setThisLocation(2);
                this.detailsAdapter.notifyItemChanged(i);
                changeViewButtonForDetails(this.detailsItems.get(i));
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < this.detailsItems.size(); i2++) {
                if (this.detailsItems.get(i2).getId() == idOldDetail) {
                    this.detailsItems.get(i2).setThisLocation(1);
                    this.detailsAdapter.notifyItemChanged(i2);
                }
            }
        }
    }

    public void updateStatusDetailAfterReset(int idOldDetail) {
        for (int i = 0; i < this.detailsItems.size(); i++) {
            if (this.detailsItems.get(i).getId() == idOldDetail) {
                this.detailsItems.get(i).setThisLocation(1);
                this.detailsAdapter.notifyItemChanged(i);
            }
        }
    }

    private void setNewDataInList(List<Tune> detailsItems) {
        setIconForTeslaOrNot(detailsItems);
        this.detailsAdapter = new TuningDetailsAdapter(this.mainRoot, getContext(), detailsItems, this);
        setNewParamsForBlock(detailsItems);
        this.detailsAdapter.setOnlyDetailClickable(-1);
        setDetailsInView();
    }

    private void setIconForTeslaOrNot(List<Tune> detailsItems) {
        for (int i = 0; i < detailsItems.size(); i++) {
            if (detailsItems.get(i).getType() != -1) {
                if (this.mainRoot.getCarID() == 2543 || this.mainRoot.getCarID() == 2544 || this.mainRoot.getCarID() == 2581 || this.mainRoot.getCarID() == 2590) {
                    switch (detailsItems.get(i).getSelector()) {
                        case 36:
                            detailsItems.get(i).setImageId("t_battery_icon");
                            continue;
                        case 37:
                            detailsItems.get(i).setImageId("t_brakers_icon");
                            continue;
                        case 38:
                            detailsItems.get(i).setImageId("t_transmission_icon");
                            continue;
                        case 39:
                            detailsItems.get(i).setImageId("t_electro_engine_icon");
                            continue;
                        case 40:
                            detailsItems.get(i).setImageId("t_chip_icon");
                            continue;
                    }
                } else {
                    switch (detailsItems.get(i).getSelector()) {
                        case 36:
                            detailsItems.get(i).setImageId("t_differential_icon");
                            continue;
                        case 37:
                            detailsItems.get(i).setImageId("t_brakers_icon");
                            continue;
                        case 38:
                            detailsItems.get(i).setImageId("t_air_filter_icon");
                            continue;
                        case 39:
                            detailsItems.get(i).setImageId("t_engine_icon");
                            continue;
                        case 40:
                            detailsItems.get(i).setImageId("t_supercharger_icon");
                            continue;
                    }
                }
            }
        }
    }

    private void setNewParamsForBlock(List<Tune> detailsItems) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(19, R.id.help_view_in_detail_list);
        layoutParams.addRule(8, R.id.help_view_in_detail_list);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(19, R.id.help_view_above_list_in_detail_list);
        layoutParams2.addRule(8, R.id.help_view_above_list_in_detail_list);
        if (detailsItems.size() < 4) {
            this.binding.menuBlockDetail.setLayoutParams(layoutParams);
        } else {
            this.binding.menuBlockDetail.setLayoutParams(layoutParams2);
        }
    }

    @Override
    public View getView() {
        return this.binding.getRoot();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        this.binding = TuningFragmentDetailsListBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        setVisiblePriceBlock(this.detailsCost);
        this.tuneVinyls.clear();
        this.tuneVinyls = App.getInstance().getTuneVinyls();
        for (int i = 0; i < this.tuneVinyls.size(); i++) {
            this.tuneVinyls.get(i).setFirstRender(true);
        }
        this.binding.tuningPriceDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDetailsList.this.lambda$onCreateView$1$UILayoutTuningDetailsList(view);
            }
        });
        this.binding.backToSubmenuDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDetailsList.this.lambda$onCreateView$3$UILayoutTuningDetailsList(view);
            }
        });
        this.binding.buttonViewCarDetailsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDetailsList.this.lambda$onCreateView$5$UILayoutTuningDetailsList(view);
            }
        });
        this.binding.buttonResetDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDetailsList.this.lambda$onCreateView$6$UILayoutTuningDetailsList(view);
            }
        });
        this.binding.buttonInfoBrake.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningDetailsList.this.lambda$onCreateView$8$UILayoutTuningDetailsList(view);
            }
        });
        return this.binding.getRoot();
    }

    public void lambda$onCreateView$1$UILayoutTuningDetailsList(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningDetailsList.this.lambda$null$0$UILayoutTuningDetailsList();
            }
        }, 250L);
    }

    public void lambda$null$0$UILayoutTuningDetailsList() {
        int i = this.thisActions;
        if (i == 1) {
            int i2 = this.mActiveSelectorId;
            if (i2 == 2) {
                this.mainRoot.applyBuyNewItem(1, this.detailsCost, this.valueCurrency, i2, 4);
            } else {
                this.mainRoot.applyBuyNewItem(1, this.detailsCost, this.valueCurrency, i2, 3);
            }
        } else if (i == 3) {
            this.mainRoot.listenerLayout(11);
            setVisibleBody(false);
        } else if (i != 5) {
        } else {
            this.mainRoot.putIntegerDataToServer(10, this.buyThisDetail.getId());
        }
    }

    public void lambda$onCreateView$3$UILayoutTuningDetailsList(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningDetailsList.this.lambda$null$2$UILayoutTuningDetailsList();
            }
        }, 250L);
    }

    public void lambda$null$2$UILayoutTuningDetailsList() {
        this.mainRoot.backToSubmenu();
    }

    public void lambda$onCreateView$5$UILayoutTuningDetailsList(View view) {
        view.startAnimation(this.anim);
        this.mainRoot.saveLayoutForViewCar(4);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningDetailsList.this.lambda$null$4$UILayoutTuningDetailsList();
            }
        }, 250L);
    }

    public void lambda$null$4$UILayoutTuningDetailsList() {
        this.mainRoot.listenerLayout(1);
    }

    public void lambda$onCreateView$6$UILayoutTuningDetailsList(View view) {
        int i = this.mActiveSelectorId;
        if (i == 2) {
            this.mainRoot.applyResetDetails(i, 4, -1);
            return;
        }
        this.mainRoot.applyResetDetails(this.mActiveSelectorId, 3, getEstablishedType());
    }

    public void lambda$onCreateView$8$UILayoutTuningDetailsList(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningDetailsList.this.lambda$null$7$UILayoutTuningDetailsList();
            }
        }, 250L);
    }

    public void lambda$null$7$UILayoutTuningDetailsList() {
        this.mainRoot.listenerLayout(10);
    }

    private int getEstablishedType() {
        if (this.isGetType && this.buyThisDetail.getThisLocation() == 2) {
            return this.buyThisDetail.getType();
        }
        return -1;
    }

    private void setDetailsInView() {
        this.binding.recvDetailsList.setLayoutManager(setHorizontalLayout());
        this.binding.recvDetailsList.setAdapter(this.detailsAdapter);
    }

    private void setVinylsInView() {
        this.binding.recvDetailsList.setLayoutManager(setHorizontalLayout());
        this.binding.recvDetailsList.setAdapter(this.tuningVinylsAdapter);
        this.binding.recvDetailsList.setDrawingCacheEnabled(true);
        this.binding.recvDetailsList.setDrawingCacheQuality(1048576);
        this.binding.recvDetailsList.setItemViewCacheSize(this.tuneVinyls.size());
    }

    private RecyclerView.LayoutManager setHorizontalLayout() {
        return new LinearLayoutManager(this.binding.getRoot().getContext(), 0, false);
    }

    @Override
    public void click(Tune detailsItem, int getPosition, View view) {
        this.detailsAdapter.setOnlyDetailClickable(getPosition);
        if (detailsItem.getThisLocation() == 0) {
            this.detailsCost = detailsItem.getCost();
            setCurrency(detailsItem);
            setPrice();
        } else {
            this.detailsCost = 0;
        }
        changeViewButtonIsBox(detailsItem);
        changeViewButtonForDetails(detailsItem);
        this.buyThisDetail = detailsItem;
        int i = this.mActiveSelectorId;
        if (i == 2 || i == 14 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 31 || i == 33 || i == 43 || i == 44 || i == 45 || i == 46 || i == 47) {
            this.mainRoot.putDetailOrCollapseToClient(22, detailsItem.getTuneId());
        }
        int i2 = this.mActiveSelectorId;
        if (i2 == 7 || i2 == 9) {
            this.mainRoot.putSoundToClient(29, detailsItem.getTuneId());
        }
        if (this.isGetType) {
            if (detailsItem.getThisLocation() == 2) {
                visibleForResetDetail(true);
            } else {
                visibleForResetDetail(false);
            }
        }
    }

    private void setVisiblePriceBlock(int detailsCost) {
        if (detailsCost != 0) {
            this.binding.titlePriceBlockDetails.setVisibility(0);
            this.binding.tuningPriceDetail.setVisibility(0);
            return;
        }
        this.binding.titlePriceBlockDetails.setVisibility(4);
        this.binding.tuningPriceDetail.setVisibility(4);
    }

    private void changeViewButtonIsBox(Tune detailsItem) {
        if (detailsItem.getName().equals("Коробка")) {
            this.isBox = true;
            this.thisActions = 3;
            this.binding.tuningPriceDetail.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.tuning_icon_box_white), (Drawable) null, (Drawable) null, (Drawable) null);
            this.binding.tuningPriceDetail.setText(R.string.tuning_title_button_info);
            this.binding.tuningPriceDetail.setVisibility(0);
            this.binding.titlePriceBlockDetails.setVisibility(4);
            return;
        }
        this.isBox = false;
    }

    private void changeViewButtonForDetails(Tune detailsItem) {
        if (this.isBox) {
            return;
        }
        if (detailsItem.getThisLocation() == 1) {
            this.thisActions = 5;
            this.binding.tuningPriceDetail.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.tuning_repair), (Drawable) null, (Drawable) null, (Drawable) null);
            this.binding.tuningPriceDetail.setText(R.string.tuning_title_button_set_detail);
            this.binding.tuningPriceDetail.setVisibility(0);
            this.binding.titlePriceBlockDetails.setVisibility(4);
        } else if (detailsItem.getThisLocation() == 2) {
            this.binding.titlePriceBlockDetails.setVisibility(4);
            this.binding.tuningPriceDetail.setVisibility(4);
        } else {
            this.thisActions = 1;
            this.binding.tuningPriceDetail.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            setPrice();
            setVisiblePriceBlock(this.detailsCost);
        }
    }

    private void changeViewButtonForVinyls(TuneVinyls tuneVinyl) {
        if (tuneVinyl.getStartVinyl()) {
            this.binding.titlePriceBlockDetails.setVisibility(4);
            this.binding.tuningPriceDetail.setVisibility(4);
            return;
        }
        this.thisActions = 1;
        this.binding.tuningPriceDetail.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        setPrice();
        setVisiblePriceBlock(this.detailsCost);
    }

    private void setCurrency(Tune detailsItem) {
        if (detailsItem.getCurrency() == 0) {
            this.valueCurrency = " ₽";
        } else {
            this.valueCurrency = " BC";
        }
    }

    private void setPrice() {
        String priceWithSpaces = GUIManager.getPriceWithSpaces(this.detailsCost);
        Button button = this.binding.tuningPriceDetail;
        button.setText(priceWithSpaces + this.valueCurrency);
    }

    public Tune getBuyThisDetail() {
        return this.buyThisDetail;
    }

    public void setEmptyObjectForDetail() {
        this.buyThisDetail = null;
    }

    public TuneVinyls getTuneVinyl() {
        return this.tuneVinyl;
    }

    public void setEmptyObjectForVinyl() {
        this.tuneVinyl = null;
    }

    @Override
    public void click(TuneVinyls tuneVinyl, int getPosition, View view) {
        this.tuningVinylsAdapter.setOnlyVinylClickable(getPosition);
        if (!tuneVinyl.getStartVinyl()) {
            this.detailsCost = this.costVinyl;
            this.valueCurrency = " ₽";
            setPrice();
        } else {
            this.detailsCost = 0;
        }
        changeViewButtonForVinyls(tuneVinyl);
        this.tuneVinyl = tuneVinyl;
        this.mainRoot.putVinylToClient(25, tuneVinyl.getNameVinyl());
    }
}
