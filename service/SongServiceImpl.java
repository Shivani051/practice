package com.example.songApp.service;

import com.example.songApp.entities.Song;
import com.example.songApp.repository.AppRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongServiceImpl implements SongService {

    private final AppRepositoryImpl appRepository;

    public SongServiceImpl(AppRepositoryImpl appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public List<Song> getSongs() {
        return appRepository.getSongs();
    }

    @Override
    public Song getSongBySongID(long songID) {
        return appRepository.getSongBySongID(songID);
    }

    @Override
    public List<Song> getSongBySongName(String songName) {
        return appRepository.getSongBySongName(songName);
    }


    @Override
    public List<Song> getSongBySingerID(long singerID) {
        return appRepository.getSongBySingerID(singerID);
    }

    @Override
    public List<Song> getSongBySingerName(String singerName) {
        return appRepository.getSongBySingerName(singerName);
    }

    @Override
    public Song addSong(Song song) {
        return appRepository.addSong(song);
    }

    @Override
    public Song updateSong(Song song) {
        return appRepository.updateSong(song);
    }

    @Override
    public void deleteSong(long songID) {
        appRepository.deleteSong(songID);
    }
}