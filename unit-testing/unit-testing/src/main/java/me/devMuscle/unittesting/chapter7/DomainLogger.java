package me.devMuscle.unittesting.chapter7;

import lombok.extern.slf4j.Slf4j;
import me.devMuscle.unittesting.chapter7.domain.user.UserType;

@Slf4j
public class DomainLogger implements IDomainLogger{

    public void userTypeHasChanged(int userId, UserType oldType, UserType newType) {
        log.info("User {} changed type from {} to {}", userId, oldType, newType);
    }
}
