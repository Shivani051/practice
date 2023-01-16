package com.example.songApp.controller;

import com.example.songApp.entities.Song;
import com.example.songApp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private SongService songService;
    //        get all songs
    @GetMapping("/songs")
    public List<Song> getSongs() {
        return this.songService.getSongs();
    }

    //    get song using songID
    @GetMapping("/songs/id/{songID}")
    public Song getSongBySongID(@PathVariable String songID) {
        return this.songService.getSongBySongID(Long.parseLong(songID));
    }
    

//    @GetMapping("/songs/song-name/{songName}")
    @GetMapping("/songs/song-name/{songName}")
    public List<Song> getSongBySongName(@PathVariable String songName) {
        return this.songService.getSongBySongName(songName);
    }

    //    get songs using singerID
    @GetMapping("/songs/singer-id/{singerID}")
    public List<Song> getSongBySingerID(@PathVariable String singerID) {
        return this.songService.getSongBySingerID(Long.parseLong(singerID));
    }


    //    get songs using singerName
    @GetMapping("/songs/singer-name/{singerName}")
    public List<Song> getSongBySingerName(@PathVariable String singerName) {
        return this.songService.getSongBySingerName(singerName);
    }

    //    ADD NEW SONGS
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return this.songService.addSong(song);
    }

//    UPDATE SONGS USING put request
    @PutMapping("/songs/{songID}")
    public Song updateSong(@RequestBody Song song) {
        return this.songService.updateSong(song);
    }

//    DELETE SONGS
    @DeleteMapping("/songs/{songID}")
    public void deleteSong(@PathVariable String songID) {
        this.songService.deleteSong(Long.parseLong(songID));
    }
}
