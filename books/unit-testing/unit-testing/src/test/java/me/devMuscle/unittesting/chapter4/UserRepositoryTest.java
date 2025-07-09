package me.devMuscle.unittesting.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryTest {

    @Test
    public void getById_executes_correct_SQL_code() {
        UserRepository sut = new UserRepository();

        User user = sut.getById(5);

        assertEquals("SELECT * FROM dbo.[User] WHERE UserID = 5", sut.lastExecutedSqlStatement);
    }
}