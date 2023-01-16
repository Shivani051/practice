package com.example.songApp.repository;

import com.example.songApp.entities.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppRepository {
    List<Song> getSongs();
    Song getSongBySongID(long songID);
    List<Song> getSongBySongName(String songName);
    List<Song> getSongBySingerID(long singerID);
    List<Song> getSongBySingerName(String singerName);
    Song addSong(Song song);
    Song updateSong(Song song);
    void deleteSong(long songID);

}
