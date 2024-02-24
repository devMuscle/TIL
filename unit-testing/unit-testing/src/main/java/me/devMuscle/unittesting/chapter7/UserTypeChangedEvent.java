package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserTypeChangedEvent implements DomainEvent{

    private int userId;
    private UserType oldType;
    private UserType newType;
}
