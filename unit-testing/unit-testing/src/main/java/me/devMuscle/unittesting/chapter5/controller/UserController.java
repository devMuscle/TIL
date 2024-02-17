package me.devMuscle.unittesting.chapter5.controller;

import me.devMuscle.unittesting.chapter5.Database;
import me.devMuscle.unittesting.chapter5.domain.User;

public class UserController {

    private Database database;

    public void renameUser(int userId, String newName) {
        User user = getUserFromDatabase(userId);
        user.setName(newName);
        saveUserToDatabase(user);
    }

    public User getUserFromDatabase(int userId) {
        return database.findUserById(userId);
    }

    public void saveUserToDatabase(User user) {}
}
