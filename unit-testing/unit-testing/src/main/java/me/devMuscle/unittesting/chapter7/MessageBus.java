package me.devMuscle.unittesting.chapter7;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageBus implements DomainEvent{

    private final IBus bus;

    public void sendEmailChangedMessage(int userId, String newEmail) {
        bus.send(String.format("Type: USER EMAIL CHANGED; " + "Id: %d; " + "NewEmail: %s", userId, newEmail));
    }
}
