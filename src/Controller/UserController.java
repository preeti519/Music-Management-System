/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;

public class UserController {

    /**
     * Login logic for USER
     */
    public static boolean loginUser(String username, String password) {

        for (User user : UserStore.users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)
                    && user.getRole().equalsIgnoreCase("User")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Login logic for ADMIN
     */
    public static boolean loginAdmin(String username, String password) {

        for (User user : UserStore.users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)
                    && user.getRole().equalsIgnoreCase("Admin")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Register a new user
     */
    public static boolean registerUser(String username, String password, String role) {

        // Check duplicate username
        for (User user : UserStore.users) {
            if (user.getUsername().equals(username)) {
                return false; // already exists
            }
        }

        // Add new user
        UserStore.users.add(new User(username, password, role));
        return true;
    }
}
