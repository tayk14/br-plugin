package com.rockstargames.gtacr.data;

public class DataSmiInfoAll {
    private boolean checkedSwitchSmiElement = false;
    private int idSmiElement;
    private String nameSmiElement;

    public DataSmiInfoAll(int idSmiElement, String nameSmiElement) {
        this.idSmiElement = idSmiElement;
        this.nameSmiElement = nameSmiElement;
    }

    public int getIdSmiElement() {
        return this.idSmiElement;
    }

    public void setIdSmiElement(int idSmiElement) {
        this.idSmiElement = idSmiElement;
    }

    public String getNameSmiElement() {
        return this.nameSmiElement;
    }

    public void setNameSmiElement(String nameSmiElement) {
        this.nameSmiElement = nameSmiElement;
    }

    public boolean getCheckedSwitchSmiElement() {
        return this.checkedSwitchSmiElement;
    }

    public void setCheckedSwitchSmiElement(boolean checkedSwitchSmiElement) {
        this.checkedSwitchSmiElement = checkedSwitchSmiElement;
    }
}
