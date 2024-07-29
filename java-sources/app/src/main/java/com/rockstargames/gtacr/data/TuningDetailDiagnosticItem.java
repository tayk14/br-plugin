package com.rockstargames.gtacr.data;

public class TuningDetailDiagnosticItem {
    private int cost;
    private int id;
    private boolean isChecked = false;
    private String nameDetail;
    private String resName;
    private int valueState;

    public TuningDetailDiagnosticItem(int id, String nameDetail, String resName) {
        this.id = id;
        this.nameDetail = nameDetail;
        this.resName = resName;
    }

    public String getNameDetail() {
        return this.nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public String getResName() {
        return this.resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getValueState() {
        return this.valueState;
    }

    public void setValueState(int valueState) {
        this.valueState = valueState;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
