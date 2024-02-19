package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    public int userId;
    public String email;
    public UserType type;

    public void changeEmail(String newEmail, Company company) {
        if(email == newEmail) {
            return;
        }

        UserType newType = company.isEmailCorporate(newEmail) ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if(type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        email = newEmail;
        type = newType;
    }
}
