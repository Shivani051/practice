package com.example.songApp.service;

import com.example.songApp.entities.Song;

import java.util.List;

public interface SongService {
    List<Song> getSongs();
    Song getSongBySongID(long songID);
    List<Song> getSongBySongName(String songName);
    List<Song> getSongBySingerID(long singerID);
    List<Song> getSongBySingerName(String singerName);
    Song addSong(Song song);
    Song updateSong(Song song);
    void deleteSong(long songID);
}
