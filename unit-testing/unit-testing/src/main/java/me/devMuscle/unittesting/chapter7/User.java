package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    public int userId;
    public String email;
    public UserType type;

    public int changeEmail(String newEmail, String companyDomainName, int numberOfEmployees) {
        if(email == newEmail) {
            return numberOfEmployees;
        }

        email = newEmail;
        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = (emailDomain.equals(companyDomainName));
        UserType newType = isEmailCorporate ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if(type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            type = newType;
            return numberOfEmployees + delta;
        }

        return numberOfEmployees;
    }
}
