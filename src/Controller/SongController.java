/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DataStore;
import Model.Song;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Controller connects View and Model.
 * View never directly accesses file or data.
 */
public class SongController {
   
   


    private final ArrayList<Song> songs;
    // Queue to store recently added songs (FIFO)
    private final Queue<Song> recentQueue = new LinkedList<>();


    // Load songs when controller starts
    public SongController() {
        songs = DataStore.loadSongs();
        // Fill the recent queue from existing songs (last 5)
    // This ensures dashboard shows recently added songs even after restart
    loadRecentQueueFromSavedSongs();
    }
    /**
 * Loads the last 5 songs from the saved song list into recentQueue.
 * This helps dashboard show "recent songs" even after restarting the program.
 */
private void loadRecentQueueFromSavedSongs() {

    // Clear queue first (safe reset)
    recentQueue.clear();

    // If there are no songs, nothing to load
    if (songs == null || songs.isEmpty()) {
        return;
    }

    // Start index: last 5 songs (or 0 if less than 5)
    int startIndex = Math.max(0, songs.size() - 5);

    // Add the last songs in correct order (old → new)
    for (int i = startIndex; i < songs.size(); i++) {
        recentQueue.add(songs.get(i));
    }
}


    // Add new song
    public void addSong(Song song) {
    songs.add(song);

    // Add song to recent queue
    recentQueue.add(song);

    // Keep only last 5 songs
    if (recentQueue.size() > 5) {
        recentQueue.poll(); // removes oldest song
    }

    DataStore.saveSongs(songs);
}
    // Returns last 5 recently added songs
    public Queue<Song> getRecentSongs() {
    return recentQueue;
}


    //public void addSong(Song song) {
        //songs.add(song);
       // DataStore.saveSongs(songs);
    //}

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
    
    // SEARCH LOGIC (Controller)
public Song searchByTitleBinary(String title) {
    sortByTitle();   // binary search needs sorted data

    int low = 0;
    int high = songs.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;

        int result = songs.get(mid).getTitle()
                .compareToIgnoreCase(title);

        if (result == 0) {
            return songs.get(mid);
        } else if (result < 0) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return null;
}



// Helper method used before binary search
private void sortByTitle() {
    songs.sort((a, b) ->
        a.getTitle().compareToIgnoreCase(b.getTitle()));
}


/*
 * Binary Search to find a song by release year.
 * This search is for exact year matches only.
 * Time Complexity: O(log n)
 */
public Song searchByYearBinary(int year) {

    // Step 1: Sort songs by year before searching
    sortByYearAscending();

    int low = 0;
    int high = songs.size() - 1;

    while (low <= high) {

        // Find middle index
        int mid = (low + high) / 2;

        // Get the year of the middle song
        int midYear = songs.get(mid).getReleaseYear();

        if (midYear == year) {
            // Song found
            return songs.get(mid);

        } else if (midYear < year) {
            // Search right half
            low = mid + 1;

        } else {
            // Search left half
            high = mid - 1;
        }
    }

    // Song not found
    return null;
}

/*
 * Helper method to sort songs by release year (ascending).
 * Binary Search by year requires sorted data.
 */
private void sortByYearAscending() {
    songs.sort((a, b) ->
        Integer.compare(a.getReleaseYear(), b.getReleaseYear()));
}

    


/*
 * Linear Search for partial matches.
 * Allows searching by:
 * - Title (partial)
 * - Artist (partial)
 * - Release Year (text-based match)
 *
 * Linear Search is used because Binary Search
 * cannot support partial matching.
 */
public ArrayList<Song> linearSearch(String keyword) {

    ArrayList<Song> results = new ArrayList<>();

    // Convert search keyword to lowercase for case-insensitive search
    String searchKey = keyword.toLowerCase();

    // Check every song one by one (Linear Search)
    for (Song song : songs) {

        // Partial match for title or artist
        if (song.getTitle().toLowerCase().contains(searchKey) ||
            song.getArtist().toLowerCase().contains(searchKey)) {

            results.add(song);
        }

        // Match release year as text (e.g. "2020")
        else if (String.valueOf(song.getReleaseYear()).contains(searchKey)) {
            results.add(song);
        }
    }

    return results;
}
/*
 * Sort songs by release year in ascending order.
 * This method is called from the View (Sort button).
 */
public ArrayList<Song> sortSongsAscending() {

    songs.sort((a, b) ->
        Integer.compare(a.getReleaseYear(), b.getReleaseYear())
    );

    return songs;
}
/*
 * Sort songs by release year in descending order.
 * Newest songs appear first.
 */
public ArrayList<Song> sortSongsDescending() {

    songs.sort((a, b) ->
        Integer.compare(b.getReleaseYear(), a.getReleaseYear())
    );

    return songs;
}




    
    
}
