/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import java.util.ArrayList;

/**
 * Stores registered users in memory
 */
public class UserStore {

    // Shared user list
    public static ArrayList<User> users = new ArrayList<>();

    // Optional: create default admin
    static {
        users.add(new User("admin", "admin", "Admin"));
    }
}
