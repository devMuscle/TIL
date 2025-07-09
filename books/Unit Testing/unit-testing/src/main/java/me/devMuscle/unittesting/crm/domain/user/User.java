package me.devMuscle.unittesting.crm.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.devMuscle.unittesting.crm.domain.event.UserTypeChangedEvent;
import me.devMuscle.unittesting.crm.domain.company.Company;
import me.devMuscle.unittesting.crm.domain.event.DomainEvent;
import me.devMuscle.unittesting.crm.domain.event.EmailChangedEvent;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
public class User {

    private int userId;
    private String email;
    private UserType type;
    private boolean isEmailConfirmed;
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public String canChangeEmail() {
        if(isEmailConfirmed) {
            return "Can't change a confirmed email";
        }

        return null;
    }

    public String changeEmail(String newEmail, Company company) {
        // 진단 로그
        log.info("Changing email for user {} to {}", userId, newEmail);

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
            // DomainLogger 대신 도메인 이벤트 사용
            domainEvents.add(new UserTypeChangedEvent(userId, type, newType));
        }

        email = newEmail;
        type = newType;
        // 새 이벤트는 이메일 변경을 나타냄
        domainEvents.add(new EmailChangedEvent(userId, newEmail));
        // 진단 로그
        log.info("Email is changed for user {}", userId);

        return null;
    }
}
