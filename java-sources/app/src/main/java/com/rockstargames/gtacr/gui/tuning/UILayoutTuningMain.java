package com.rockstargames.gtacr.gui.tuning;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.TuningFragmentTypeListBinding;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import com.rockstargames.gtacr.adapters.TuningTypeAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.TuningMenuType;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class UILayoutTuningMain extends UILayout implements TuningTypeAdapter.OnClickTuningType {
    private TuningFragmentTypeListBinding binding;
    private GUITuning mainRoot;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private Animation anim = null;
    private TuningTypeAdapter typeAdapter = null;
    private List<TuningMenuType> tuningTypes = new ArrayList();
    List<TuneGuiNode> selectedNodesList = new ArrayList();
    private Integer[] isCarID = {Integer.valueOf((int) 1), 410, 411, 413, 414, 415, Integer.valueOf((int) 0), 427, 429, 433, 436, 438, 440, 445, 456, 459, 462, 470, 480, 490, 494, 495, Integer.valueOf((int) 0), Integer.valueOf((int) 0), Integer.valueOf((int) 0), 526, 540, 541, 559, 565, 579, 587, 589, Integer.valueOf((int) 0), Integer.valueOf((int) 0)};
    private final String nameSelectorDVS1 = "Дифференциалы";
    private final String nameSelectorDVS2 = "Тормоза";
    private final String nameSelectorDVS3 = "Турбонаддув";
    private final String nameSelectorDVS4 = "Двигатели";
    private final String nameSelectorDVS5 = "Нагнетатели";
    private final String nameSelectorTesla1 = "Батарея";
    private final String nameSelectorTesla2 = "Тормоза";
    private final String nameSelectorTesla3 = "Трансмиссия";
    private final String nameSelectorTesla4 = "Электродвигатель";
    private final String nameSelectorTesla5 = "Контроллер";
    private final String ImageSelectorDVS1 = "t_differential_icon";
    private final String ImageSelectorDVS2 = "t_brakers_icon";
    private final String ImageSelectorDVS3 = "t_air_filter_icon";
    private final String ImageSelectorDVS4 = "t_engine_icon";
    private final String ImageSelectorDVS5 = "t_supercharger_icon";
    private final String ImageSelectorTesla1 = "t_battery_icon";
    private final String ImageSelectorTesla2 = "t_brakers_icon";
    private final String ImageSelectorTesla3 = "t_transmission_icon";
    private final String ImageSelectorTesla4 = "t_electro_engine_icon";
    private final String ImageSelectorTesla5 = "t_chip_icon";

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutTuningMain(GUITuning root) {
        this.mainRoot = root;
    }

    public void setVisibleMainView(boolean isVisible) {
        if (isVisible) {
            this.binding.typeViewMain.setVisibility(0);
        } else {
            this.binding.typeViewMain.setVisibility(4);
        }
    }

    @Override
    public View getView() {
        return this.binding.getRoot();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        this.binding = TuningFragmentTypeListBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.mActiveScreen = this.mainRoot.getActiveScreen();
        setDataTuningTypes(dataTuningTypes());
        this.typeAdapter = new TuningTypeAdapter(getContext(), this.tuningTypes, this);
        setDataInView();
        this.binding.buttonViewCarType.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutTuningMain.this.lambda$onCreateView$1$UILayoutTuningMain(view);
            }
        });
        return this.binding.getRoot();
    }

    public void lambda$onCreateView$1$UILayoutTuningMain(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutTuningMain.this.lambda$null$0$UILayoutTuningMain();
            }
        }, 250L);
    }

    public void lambda$null$0$UILayoutTuningMain() {
        this.mainRoot.setEmptyThisSubmenu();
        this.mainRoot.listenerLayout(1);
    }

    private List<String> dataTuningTypes() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mActiveScreen.getFooter().size(); i++) {
            TuneGuiNode tuneGuiNode = this.mActiveScreen.getFooter().get(i);
            if (tuneGuiNode.getName() != null) {
                arrayList.add(tuneGuiNode.getName());
            }
        }
        return arrayList;
    }

    private void setDataTuningTypes(final List<String> thisData) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    UILayoutTuningMain.this.lambda$setDataTuningTypes$2$UILayoutTuningMain(thisData, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void lambda$setDataTuningTypes$2$UILayoutTuningMain(final List thisData, SingleEmitter subscribe) throws Throwable {
        this.tuningTypes.clear();
        for (int i = 0; i < thisData.size(); i++) {
            this.tuningTypes.add(new TuningMenuType((String) thisData.get(i)));
        }
        subscribe.onSuccess(this.tuningTypes);
    }

    private void setDataInView() {
        this.binding.recvTypeTuningList.setLayoutManager(setHorizontalLayout());
        this.binding.recvTypeTuningList.setAdapter(this.typeAdapter);
    }

    private RecyclerView.LayoutManager setHorizontalLayout() {
        return new LinearLayoutManager(this.binding.getRoot().getContext(), 0, false);
    }

    @Override
    public void click(TuningMenuType tuningType, int getPosition, View view) {
        boolean z;
        this.typeAdapter.setOnlyItemClickable(getPosition);
        TuneGuiNode tuneGuiNode = this.mActiveScreen.getFooter().get(getPosition);
        GUITuning gUITuning = this.mainRoot;
        List<Integer> correctSelectorsOld = gUITuning.getCorrectSelectorsOld(gUITuning.getCorrectSelectors());
        this.mActiveNode = tuneGuiNode;
        int opensType = tuneGuiNode.getOpensType();
        if (opensType == 0) {
            this.selectedNodesList.clear();
            for (int i = 0; i < tuneGuiNode.getNames().size(); i++) {
                int selectorId = tuneGuiNode.getNames().get(i).getSelectorId();
                if (tuneGuiNode.getNames().get(i).getOpensType() == 2 && selectorId != 2) {
                    for (int i2 = 0; i2 < correctSelectorsOld.size(); i2++) {
                        if (selectorId == correctSelectorsOld.get(i2).intValue()) {
                            this.selectedNodesList.add(tuneGuiNode.getNames().get(i));
                        }
                    }
                } else if (selectorId == 2) {
                    int carID = this.mainRoot.getCarID();
                    int i3 = 0;
                    while (true) {
                        Integer[] numArr = this.isCarID;
                        if (i3 >= numArr.length) {
                            z = false;
                            break;
                        } else if (carID == numArr[i3].intValue()) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        this.selectedNodesList.add(tuneGuiNode.getNames().get(i));
                    }
                } else {
                    this.selectedNodesList.add(tuneGuiNode.getNames().get(i));
                }
            }
            for (int i4 = 0; i4 < this.selectedNodesList.size(); i4++) {
                if (this.mainRoot.getCarID() == 2543 || this.mainRoot.getCarID() == 2544 || this.mainRoot.getCarID() == 2581 || this.mainRoot.getCarID() == 2590) {
                    switch (this.selectedNodesList.get(i4).getSelectorId()) {
                        case 36:
                            this.selectedNodesList.get(i4).setName("Батарея");
                            this.selectedNodesList.get(i4).setImageId("t_battery_icon");
                            continue;
                        case 37:
                            this.selectedNodesList.get(i4).setName("Тормоза");
                            this.selectedNodesList.get(i4).setImageId("t_brakers_icon");
                            continue;
                        case 38:
                            this.selectedNodesList.get(i4).setName("Трансмиссия");
                            this.selectedNodesList.get(i4).setImageId("t_transmission_icon");
                            continue;
                        case 39:
                            this.selectedNodesList.get(i4).setName("Электродвигатель");
                            this.selectedNodesList.get(i4).setImageId("t_electro_engine_icon");
                            continue;
                        case 40:
                            this.selectedNodesList.get(i4).setName("Контроллер");
                            this.selectedNodesList.get(i4).setImageId("t_chip_icon");
                            continue;
                    }
                } else {
                    switch (this.selectedNodesList.get(i4).getSelectorId()) {
                        case 36:
                            this.selectedNodesList.get(i4).setName("Дифференциалы");
                            this.selectedNodesList.get(i4).setImageId("t_differential_icon");
                            continue;
                        case 37:
                            this.selectedNodesList.get(i4).setName("Тормоза");
                            this.selectedNodesList.get(i4).setImageId("t_brakers_icon");
                            continue;
                        case 38:
                            this.selectedNodesList.get(i4).setName("Турбонаддув");
                            this.selectedNodesList.get(i4).setImageId("t_air_filter_icon");
                            continue;
                        case 39:
                            this.selectedNodesList.get(i4).setName("Двигатели");
                            this.selectedNodesList.get(i4).setImageId("t_engine_icon");
                            continue;
                        case 40:
                            this.selectedNodesList.get(i4).setName("Нагнетатели");
                            this.selectedNodesList.get(i4).setImageId("t_supercharger_icon");
                            continue;
                    }
                }
            }
            this.mainRoot.setDataInNewSubmenu(this.selectedNodesList);
            Log.v("LOG_VIEW", "selectedNodesList size = " + this.selectedNodesList.size());
            this.mainRoot.listenerLayout(2);
            return;
        }
        this.mainRoot.setClickMainMenu(opensType);
    }

    public TuneGuiNode getDataInActiveScreen() {
        return this.mActiveNode;
    }

    public List<TuneGuiNode> getSelectedNodesList() {
        return this.selectedNodesList;
    }
}
