/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DataStore;
import Model.Song;
import java.util.ArrayList;
/*
 * Controller connects View and Model.
 * View never directly accesses file or data.
 */
public class SongController {
   


    private final ArrayList<Song> songs;

    // Load songs when controller starts
    public SongController() {
        songs = DataStore.loadSongs();
    }

    // Add new song
    public void addSong(Song song) {
        songs.add(song);
        DataStore.saveSongs(songs);
    }

    // Update existing song
    public void updateSong(int index, Song song) {
        songs.set(index, song);
        DataStore.saveSongs(songs);
    }

    // Delete song
    public void deleteSong(int index) {
        songs.remove(index);
        DataStore.saveSongs(songs);
    }

    // Return all songs
    public ArrayList<Song> getAllSongs() {
        return songs;
    }
}
