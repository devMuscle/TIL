package me.devMuscle.unittesting.chapter7.bus;

import java.util.ArrayList;
import java.util.List;

public class BusSpy implements IBus{

    private final List<String> sentMessages = new ArrayList<>();

    @Override
    public void send(String message) {
        sentMessages.add(message);
    }

    public BusSpy shouldSendNumberOfMessages(int number) {
        if(number == sentMessages.size()) {
            return this;
        }

        throw new IllegalArgumentException("message의 갯수가 일치하지 않습니다.");
    }

    public BusSpy withEmailChangedMessage(int userId, String newEmail) {
        String message = String.format("Type: USER EMAIL CHANGED; " + "Id: %d; " + "NewEmail: %s", userId, newEmail);

        if(sentMessages.contains(message)) {
            return this;
        }

        throw new IllegalArgumentException("해당 내용의 message가 없습니다");
    }
}
