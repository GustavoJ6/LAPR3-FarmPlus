package Controller;

import java.util.HashMap;
import java.util.Map;

public class AuthSystem {
    // Map to store user information, with the username as the key and the password and role as values
    private final Map<String, User> users = new HashMap<>();

    // Enum to represent the different roles a user can have
    public enum Role {
        ESINF_USER, BDDAD_USER
    }

    // Class to represent a user, with a username, password, and role
    public record User(String username, String password, Role role) {
    }

    // Private constructor to prevent other classes from creating instances of the authentication system
    private AuthSystem() {
    }

    // Static field to hold the single instance of the authentication system
    private static AuthSystem instance = null;

    // Static method to return the single instance of the authentication system - singleton pattern
    public static AuthSystem getInstance() {
        if (instance == null) {
            instance = new AuthSystem();
        }
        return instance;
    }

    // Field to hold the currently logged-in user
    private User currentUser = null;

    // Method to register a new user
    public void registerUser(String username, String password, Role role) {
        users.put(username, new User(username, password, role));
    }

    // Method to authenticate a user
    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            // Set the current user and create a new login session
            this.currentUser = user;
            return user;
        }
        return null;
    }

    // Method to perform a logout
    public void logout() {
        // Clear the current user and invalidate the login session
        this.currentUser = null;
    }

    // Get the current user
    public User getCurrentUser() {
        return currentUser;
    }

}
