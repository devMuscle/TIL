package me.devMuscle.unittesting.chapter7.bus;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.chapter7.domain.event.DomainEvent;

@RequiredArgsConstructor
public class MessageBus implements DomainEvent {

    private final IBus bus;

    public void sendEmailChangedMessage(int userId, String newEmail) {
        bus.send(String.format("Type: USER EMAIL CHANGED; " + "Id: %d; " + "NewEmail: %s", userId, newEmail));
    }
}
