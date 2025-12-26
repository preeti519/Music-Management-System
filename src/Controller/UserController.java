/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;

/**
 *
 * @author airm2
 */
public class UserController {

    public static void register(String username, String password, String role) {
        User user = new User(username, password, role);
        DataStore.userList.add(user);
    }

    public static User login(String username, String password, String role) {
        for (User u : DataStore.userList) {
            if (
                u.getUsername().equals(username) &&
                u.getPassword().equals(password) &&
                u.getRole().equals(role)
            ) {
                return u;
            }
        }
        return null;
    }
}
