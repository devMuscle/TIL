package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@AllArgsConstructor
public class User {

    private int userId;
    private String email;
    private UserType type;
    private boolean isEmailConfirmed;

    public String canChangeEmail() {
        if(isEmailConfirmed) {
            return "Can't change a confirmed email";
        }

        return null;
    }

    public void changeEmail(String newEmail, Company company) {
        String message = canChangeEmail();
        Assert.isNull(message, message);

        if(email.equals(newEmail)) {
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
