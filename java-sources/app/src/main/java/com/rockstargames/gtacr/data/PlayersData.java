package com.rockstargames.gtacr.data;

public class PlayersData {
    private boolean clickable = false;
    private int id;
    private String name;
    private int ping;
    private int playerLevel;

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public PlayersData(int id, String name, int playerLevel, int ping) {
        this.id = id;
        this.name = name;
        this.playerLevel = playerLevel;
        this.ping = ping;
    }

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

    public int getPlayerLevel() {
        return this.playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPing() {
        return this.ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
}
