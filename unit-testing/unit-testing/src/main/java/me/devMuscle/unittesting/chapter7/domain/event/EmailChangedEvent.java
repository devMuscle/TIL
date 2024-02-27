package me.devMuscle.unittesting.chapter7.domain.event;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class EmailChangedEvent implements DomainEvent {

    private int userId;
    private String newEmail;
}
