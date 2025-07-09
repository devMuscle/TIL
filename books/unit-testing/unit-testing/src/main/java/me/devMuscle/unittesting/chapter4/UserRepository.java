package me.devMuscle.unittesting.chapter4;

public class UserRepository {

    public String lastExecutedSqlStatement;

    public User getById(int id) {
        lastExecutedSqlStatement = "SELECT * FROM dbo.[User] WHERE UserID = " + id;

        return new User(id);
    }
}
