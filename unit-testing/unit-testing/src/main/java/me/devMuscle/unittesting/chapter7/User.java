package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class User {

    private int userId;
    private String email;
    private UserType type;
    private boolean isEmailConfirmed;
    private final List<EmailChangedEvent> emailChangedEvents = new ArrayList<>();

    public String canChangeEmail() {
        if(isEmailConfirmed) {
            return "Can't change a confirmed email";
        }

        return null;
    }

    public String changeEmail(String newEmail, Company company) {
        String error = canChangeEmail();

        if(error != null) {
            return error;
        }

        if(email.equals(newEmail)) {
            return null;
        }

        UserType newType = company.isEmailCorporate(newEmail) ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if(type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        email = newEmail;
        type = newType;
        // 새 이벤트는 이메일 변경을 나타냄
        emailChangedEvents.add(new EmailChangedEvent(userId, newEmail));

        return null;
    }
}
