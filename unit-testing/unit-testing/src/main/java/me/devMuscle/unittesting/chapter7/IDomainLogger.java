package me.devMuscle.unittesting.chapter7;

import me.devMuscle.unittesting.chapter7.domain.user.UserType;

public interface IDomainLogger {

    void userTypeHasChanged(int userId, UserType oldType, UserType newType);
}
