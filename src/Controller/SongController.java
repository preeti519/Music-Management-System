/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Song;
import java.util.ArrayList;

/**
 *
 * @author airm2
 */
public class SongController {
    // CREATE
    public static void addSong(String title, String artist, String genre) {
        Song s = new Song(title, artist, genre);
        DataStore.songList.add(s);
    }

    // READ
    public static ArrayList<Song> getAllSongs() {
        return DataStore.songList;
    }

    // UPDATE
    public static void updateSong(int index, String title, String artist, String genre) {
        Song s = DataStore.songList.get(index);
        s.setTitle(title);
        s.setArtist(artist);
        s.setGenre(genre);
    }

    // DELETE
    public static void deleteSong(int index) {
        DataStore.songList.remove(index);
    }
    
    public static void sortSongsByTitle() {
    DataStore.songList.sort(
        (s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle())
    );
}



    
}
