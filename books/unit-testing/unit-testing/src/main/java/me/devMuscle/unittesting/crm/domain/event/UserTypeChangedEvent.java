package me.devMuscle.unittesting.crm.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.devMuscle.unittesting.crm.domain.user.UserType;

@Getter
@AllArgsConstructor
public class UserTypeChangedEvent implements DomainEvent {

    private int userId;
    private UserType oldType;
    private UserType newType;
}
