/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author airm2
 */

import java.io.Serializable;

/*
 * This class represents a Song.
 * It only stores data (no UI, no logic).
 */
public class Song implements Serializable {

    private final String title;
    private final String artist;
    private final String album;
    private final String genre;
    private final int duration;
    private final int releaseYear;

    // Constructor
    public Song(String title, String artist, String album,
                String genre, int duration, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
        this.releaseYear = releaseYear;
    }

    // Getter methods (used by controller/view)
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public int getReleaseYear() { return releaseYear; }
}
