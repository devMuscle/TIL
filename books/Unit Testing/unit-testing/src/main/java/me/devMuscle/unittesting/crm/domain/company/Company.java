package me.devMuscle.unittesting.crm.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

@AllArgsConstructor
@Getter
public class Company {

    private String domainName;
    private int numberOfEmployees;

    public void changeNumberOfEmployees(int delta) {
        Assert.isTrue(numberOfEmployees + delta >= 0, "사원이 0명보다 작거나 같습니다.");

        numberOfEmployees += delta;
    }

    public boolean isEmailCorporate(String email) {
        String emailDomain = email.split("@")[1];
        return (emailDomain.equals(domainName));
    }
}
