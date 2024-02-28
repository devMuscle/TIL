package me.devMuscle.unittesting.crm.domain.event;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.IDomainLogger;
import me.devMuscle.unittesting.crm.bus.MessageBus;

import java.util.List;

@RequiredArgsConstructor
public class EventDispatcher {

    private final MessageBus messageBus;
    private final IDomainLogger domainLogger;

    public void dispatch(List<DomainEvent> domainEvents) {
        for(DomainEvent domainEvent : domainEvents) {
            dispatch(domainEvent);
        }
    }

    public void dispatch(DomainEvent domainEvent) {
        if(domainEvent instanceof EmailChangedEvent) {
            EmailChangedEvent emailChangedEvent = (EmailChangedEvent)domainEvent;
            messageBus.sendEmailChangedMessage(emailChangedEvent.getUserId(), emailChangedEvent.getNewEmail());
        }else if(domainEvent instanceof UserTypeChangedEvent) {
            UserTypeChangedEvent userTypeChangedEvent = (UserTypeChangedEvent)domainEvent;
            domainLogger.userTypeHasChanged(userTypeChangedEvent.getUserId(), userTypeChangedEvent.getOldType(), userTypeChangedEvent.getNewType());
        }
    }
}
