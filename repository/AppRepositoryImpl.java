package com.example.songApp.repository;

import com.example.songApp.entities.Singer;
import com.example.songApp.entities.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class AppRepositoryImpl implements AppRepository {
    private List<Song> list;
    public AppRepositoryImpl() {
        list = new ArrayList<>();
        list.add(new Song(1, "one call away", new Singer(100, "charlie puth")));
        list.add(new Song(2, "dil diyan galla", new Singer(101, "atif")));
        list.add(new Song(3, "see you again", new Singer(100, "charlie puth")));
        list.add(new Song(4, "jeena Jeena", new Singer(101, "atif")));
        list.add(new Song(5, "Hold on", new Singer(102, "chord overstreet")));
    }

//    public List<Song> getSongs() {
//        return list;
//    }

    public List<Song> getSongs() {
        Song song = new Song();
        return list;
    }

    public Song getSongBySongID(long songID) {
        Song s = null;
        for(Song song: list) {
            if(song.getSongID() == songID) {
                s = song;
                break;
            }
        }
        return s;
    }

    public List<Song> getSongBySongName(String songName) {
        List<Song> tempList = new ArrayList<>();
        Song s = null;
        for(Song song: list) {
            if(song.getSongName().contains(songName)) {
                s = song;
                tempList.add(s);
            }
        }
        return tempList;
    }

    public List<Song> getSongBySingerID(long singerID) {
        List<Song> tempList = new ArrayList<>();
        Song s = null;
        for(Song song: list) {
            if(song.getSinger().getSingerID() == singerID) {
                s = song;
                tempList.add(s);
            }
        }
        return tempList;
    }

    public List<Song> getSongBySingerName(String singerName) {
        List<Song> tempList = new ArrayList<>();
        Song s = null;
        for(Song song: list) {
            if(Objects.equals(song.getSinger().getSingerName(), singerName)) {
                s = song;
                tempList.add(s);
            }
        }
        return tempList;
    }

    public Song addSong(Song song) {
        list.add(song);
        return song;
    }

    public Song updateSong(Song song) {
        List<Song> temp = list;
        for(Song x : temp) {
            if(x.getSongID() == song.getSongID()) {
                x.setSinger(song.getSinger());
            }
        }

        return song;
    }

    public void deleteSong(long songID) {
        list = this.list.stream().filter(e->e.getSongID() != songID).collect(Collectors.toList());
    }

}

