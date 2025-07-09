package me.devMuscle.unittesting.crm.bus;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.domain.event.DomainEvent;

@RequiredArgsConstructor
public class MessageBus implements DomainEvent {

    private final IBus bus;

    public void sendEmailChangedMessage(int userId, String newEmail) {
        bus.send(String.format("Type: USER EMAIL CHANGED; " + "Id: %d; " + "NewEmail: %s", userId, newEmail));
    }
}
