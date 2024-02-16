package me.devMuscle.unittesting.chapter5;

public class UserController {

    private Database database;

    public void renameUser(int userId, String newName) {
        User user = getUserFromDatabase(userId);

        String normalizedName = user.normalizeName(newName);
        user.name = normalizedName;

        saveUserToDatabase(user);
    }

    public User getUserFromDatabase(int userId) {
        return database.findUserById(userId);
    }

    public void saveUserToDatabase(User user) {}
}
