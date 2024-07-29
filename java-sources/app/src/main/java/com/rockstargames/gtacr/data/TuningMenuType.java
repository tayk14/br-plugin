package com.rockstargames.gtacr.data;

public class TuningMenuType {
    private boolean clickable = false;
    private String titleType;

    public TuningMenuType(String titleType) {
        this.titleType = titleType;
    }

    public String getTitleType() {
        return this.titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public boolean getClickable() {
        return this.clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
}
