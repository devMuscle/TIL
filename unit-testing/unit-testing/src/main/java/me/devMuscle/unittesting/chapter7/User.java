package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private int userId;
    private String email;
    private UserType type;
    private boolean isEmailConfirmed;

    public String changeEmail(String newEmail, Company company) {
        if(isEmailConfirmed) {
            return "Can't change a confirmed email";
        }

        UserType newType = company.isEmailCorporate(newEmail) ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if(type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        email = newEmail;
        type = newType;

        return null;
    }
}
