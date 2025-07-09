package me.devMuscle.unittesting.crm;

import me.devMuscle.unittesting.crm.domain.user.UserType;

public interface IDomainLogger {

    void userTypeHasChanged(int userId, UserType oldType, UserType newType);
}
