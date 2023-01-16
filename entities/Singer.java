package com.example.songApp.entities;

public class Singer {

    private long singerID;
    private String singerName;

    public Singer() {
    }

    public Singer(long singerID, String singerName) {
        this.singerID = singerID;
        this.singerName = singerName;
    }

    public long getSingerID() {
        return singerID;
    }

    public void setSingerID(long singerID) {
        this.singerID = singerID;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }


}
