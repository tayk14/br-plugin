package com.rockstargames.gtacr.data;

public class TuningDetailForCheck {
    private int id;
    private int selectorId;

    public TuningDetailForCheck(int id, int selectorId) {
        this.id = id;
        this.selectorId = selectorId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSelectorId() {
        return this.selectorId;
    }

    public void setSelectorId(int selectorId) {
        this.selectorId = selectorId;
    }
}
