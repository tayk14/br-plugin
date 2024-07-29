package com.rockstargames.gtacr.data;

public class DataFood {
    private boolean clickableListener = false;
    private int idFood;
    private int imageFood;
    private String nameFood;
    private int priceFood;
    private int satietyFood;

    public DataFood(int idFood, int imageFood, String nameFood, int satietyFood, int priceFood) {
        this.idFood = idFood;
        this.imageFood = imageFood;
        this.nameFood = nameFood;
        this.satietyFood = satietyFood;
        this.priceFood = priceFood;
    }

    public int getIdFood() {
        return this.idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return this.nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getImageFood() {
        return this.imageFood;
    }

    public void setImageFood(int imageFood) {
        this.imageFood = imageFood;
    }

    public int getSatietyFood() {
        return this.satietyFood;
    }

    public void setSatietyFood(int satietyFood) {
        this.satietyFood = satietyFood;
    }

    public int getPriceFood() {
        return this.priceFood;
    }

    public void setPriceFood(int priceFood) {
        this.priceFood = priceFood;
    }

    public boolean isClickableListener() {
        return this.clickableListener;
    }

    public void setClickableListener(boolean clickableListener) {
        this.clickableListener = clickableListener;
    }
}
