/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.*;
import java.util.ArrayList;

public class DataStore {

    private static final String FILE_NAME = "songs.data";

    // Save songs to file
    public static void saveSongs(ArrayList<Song> songs) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(songs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load songs from file
    @SuppressWarnings("unchecked")
    public static ArrayList<Song> loadSongs() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Song>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // first run
        }
    }
}
