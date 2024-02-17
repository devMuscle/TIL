package me.devMuscle.unittesting.chapter5;

import me.devMuscle.unittesting.chapter5.domain.User;

public class Database {

    public int getNumberOfUsers() {
        return (int)(Math.random()*10);
    }

    public User findUserById(int userId) {
        return new User(userId);
    }
}
