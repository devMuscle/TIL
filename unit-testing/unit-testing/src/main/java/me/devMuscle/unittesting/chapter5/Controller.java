package me.devMuscle.unittesting.chapter5;

public class Controller {

    private final EmailGateWay emailGateWay;

    public Controller(EmailGateWay emailGateWay) {
        this.emailGateWay = emailGateWay;
    }

    public void greetUser(String email) {
        emailGateWay.sendGreetingEmail(email);
    }
}
