package com.example.songApp.entities;

public class Song {
    private long songID;
    private String songName;
    private Singer singer;
    public Song() {
    }

    public Song(long songID, String songName, Singer singer) {
        this.songID = songID;
        this.songName = songName;
        this.singer = singer;
    }

    public long getSongID() {
        return songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

}