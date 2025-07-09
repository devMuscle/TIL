package me.devMuscle.unittesting.chapter3;

public abstract class IntegrationTest {

    protected Database database;

    protected IntegrationTest() {
        database = new Database();
    }

    public void dispose() {
        database.dispose();
    }
}
