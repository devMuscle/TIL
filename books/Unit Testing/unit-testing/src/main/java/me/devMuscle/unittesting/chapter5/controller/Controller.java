package me.devMuscle.unittesting.chapter5.controller;

import me.devMuscle.unittesting.chapter5.Database;
import me.devMuscle.unittesting.chapter5.EmailGateWay;
import me.devMuscle.unittesting.chapter5.domain.Report;

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
