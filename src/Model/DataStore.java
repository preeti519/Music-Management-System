/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author airm2
 */

    



/*
 * This class handles saving and loading songs.
 * Data is stored in a file so it remains after logout.
 */

public class DataStore {
    private static final String FILE_NAME = "songs.data";

    // Save songs to file
    public static void saveSongs(ArrayList<Song> songs) {
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                out.writeObject(songs);
            }
        } catch (IOException e) {
        }
    }

    // Load songs from file
    public static ArrayList<Song> loadSongs() {
        try {
            ObjectInputStream in;
            in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<Song> songs =
                    (ArrayList<Song>) in.readObject();
            in.close();
            return songs;
        } catch (IOException | ClassNotFoundException e) {
            // First time app runs → no file yet
            return new ArrayList<>();
        }
    }
}

    
    

