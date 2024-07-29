package com.rockstargames.gtacr.data;

public class TuningDetailItem {
    private boolean checked = false;
    private int cost;
    private int currency;
    private int id;
    private String name;
    private String resImage;
    private int thisLocation;
    private int tyneId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getThisLocation() {
        return this.thisLocation;
    }

    public void setThisLocation(int thisLocation) {
        this.thisLocation = thisLocation;
    }

    public int getCurrency() {
        return this.currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public String getResImage() {
        return this.resImage;
    }

    public void setResImage(String resImage) {
        this.resImage = resImage;
    }

    public int getTyneId() {
        return this.tyneId;
    }

    public void setTyneId(int tyneId) {
        this.tyneId = tyneId;
    }
}
