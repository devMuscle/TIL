package me.devMuscle.unittesting.crm;

import lombok.extern.slf4j.Slf4j;
import me.devMuscle.unittesting.crm.domain.user.UserType;

@Slf4j
public class DomainLogger implements IDomainLogger{

    public void userTypeHasChanged(int userId, UserType oldType, UserType newType) {
        log.info("User {} changed type from {} to {}", userId, oldType, newType);
    }
}
