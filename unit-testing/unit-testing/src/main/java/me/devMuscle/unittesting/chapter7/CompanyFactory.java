package me.devMuscle.unittesting.chapter7;

import org.springframework.util.Assert;

public class CompanyFactory {

    public static Company create(Object[] data) {
        Assert.isTrue(data.length >= 2, "data의 길이가 3보다 작습니다.");

        String domainName = (String)data[0];
        int numberOfEmployees = (int)data[1];

        return new Company(domainName, numberOfEmployees);
    }
}
