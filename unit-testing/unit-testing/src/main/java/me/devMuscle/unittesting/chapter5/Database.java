package me.devMuscle.unittesting.chapter5;

public class Database {

    public int getNumberOfUsers() {
        return (int)(Math.random()*10);
    }

    public User findUserById(int userId) {
        return new User(userId);
    }
}
