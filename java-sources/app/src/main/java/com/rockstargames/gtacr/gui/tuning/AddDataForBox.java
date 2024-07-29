package com.rockstargames.gtacr.gui.tuning;

import blackrussia.online.network.Tune;
import com.rockstargames.gtacr.data.TuningBoxItem;
import java.util.ArrayList;
import java.util.List;

public class AddDataForBox {
    private GUITuning mainRoot;
    private List<Integer> correctList = new ArrayList();
    private List<Tune> dataDifferentialForBox = new ArrayList();
    private List<Tune> dataBrakersForBox = new ArrayList();
    private List<Tune> dataAirFiltersForBox = new ArrayList();
    private List<Tune> dataEnginesForBox = new ArrayList();
    private List<Tune> dataSuperchargerForBox = new ArrayList();
    private List<Tune> allDataForBox = new ArrayList();
    private List<TuningBoxItem> allNameInBox = new ArrayList();

    public AddDataForBox(GUITuning mainRoot) {
        this.mainRoot = mainRoot;
    }

    public void startAddDataForBoxOperations() {
        setStartData();
        upgradeData();
    }

    public List<TuningBoxItem> getAllNameInBox() {
        return this.allNameInBox;
    }

    private void setStartData() {
        List<Integer> correctList = this.mainRoot.getCorrectList();
        this.correctList = correctList;
        GUITuning gUITuning = this.mainRoot;
        this.dataDifferentialForBox = gUITuning.setCorrectDetailsListFormatTune(correctList, gUITuning.getTuneItemsForSelector(36));
        GUITuning gUITuning2 = this.mainRoot;
        this.dataBrakersForBox = gUITuning2.setCorrectDetailsListFormatTune(this.correctList, gUITuning2.getTuneItemsForSelector(37));
        GUITuning gUITuning3 = this.mainRoot;
        this.dataAirFiltersForBox = gUITuning3.setCorrectDetailsListFormatTune(this.correctList, gUITuning3.getTuneItemsForSelector(38));
        GUITuning gUITuning4 = this.mainRoot;
        this.dataEnginesForBox = gUITuning4.setCorrectDetailsListFormatTune(this.correctList, gUITuning4.getTuneItemsForSelector(39));
        GUITuning gUITuning5 = this.mainRoot;
        this.dataSuperchargerForBox = gUITuning5.setCorrectDetailsListFormatTune(this.correctList, gUITuning5.getTuneItemsForSelector(40));
    }

    private void upgradeData() {
        clearFirstElement(this.dataDifferentialForBox);
        clearFirstElement(this.dataBrakersForBox);
        clearFirstElement(this.dataAirFiltersForBox);
        clearFirstElement(this.dataEnginesForBox);
        clearFirstElement(this.dataSuperchargerForBox);
        this.allNameInBox.clear();
        addNameSelectorInList(36, this.dataDifferentialForBox);
        addNameSelectorInList(37, this.dataBrakersForBox);
        addNameSelectorInList(38, this.dataAirFiltersForBox);
        addNameSelectorInList(39, this.dataEnginesForBox);
        addNameSelectorInList(40, this.dataSuperchargerForBox);
    }

    private void addNameSelectorInList(int r6, List<blackrussia.online.network.Tune> r7) {
        String r1 = "Тормоза ";
    }

    private void clearFirstElement(List<Tune> fullList) {
        if (fullList.size() == 0 || !fullList.get(0).getName().equals("Коробка")) {
            return;
        }
        fullList.remove(0);
    }
}
