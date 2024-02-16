package me.devMuscle.unittesting.chapter5;

import me.devMuscle.unittesting.chapter5.Database;

public class Controller {

    private EmailGateWay emailGateWay;
    private Database database;

    public Controller(EmailGateWay emailGateWay) {
        this.emailGateWay = emailGateWay;
    }

    public Controller(Database database) {
        this.database = database;
    }

    public void greetUser(String email) {
        emailGateWay.sendGreetingEmail(email);
    }

    public Report createReport() {
        return new Report(database.getNumberOfUsers());
    }
}
