package me.devMuscle.unittesting.chapter6;

public class Controller {

    private final EmailGateWay emailGateWay;

    public Controller(EmailGateWay emailGateWay) {
        this.emailGateWay = emailGateWay;
    }

    public void greetUser(String email) {
        emailGateWay.sendGreetingEmail(email);
    }
}
