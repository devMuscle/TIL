package me.devMuscle.unittesting.chapter7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainLogger {

    public void userTypeHasChanged(int userId, UserType oldType, UserType newType) {
        log.info("User {} changed type from {} to {}", userId, oldType, newType);
    }
}
