package me.devMuscle.unittesting.chapter7;

import lombok.NoArgsConstructor;
import me.devMuscle.unittesting.chapter7.domain.company.Company;
import me.devMuscle.unittesting.chapter7.domain.user.User;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Database {

    private final List<User> userStorage = new ArrayList<>();
    private final List<Company> companyStorage = new ArrayList<>();

    public Object[] getUserById(int userId) {
        User user = userStorage.get(userId);
        return new Object[]{user.getUserId(), user.getEmail(), user.getType(), user.isEmailConfirmed()};
    }

    public Object[] getCompany() {
        Company company = companyStorage.get(0);
        return new Object[]{company.getDomainName(), company.getNumberOfEmployees()};
    }

    public void saveCompany(Company company) {
        for(int i=0; i<companyStorage.size(); i++) {
            if(companyStorage.get(i).getDomainName().equals(company.getDomainName())) {
                companyStorage.set(i, company);
                return;
            }
        }
        companyStorage.add(company);
    }
    public void saveUser(User user) {
        if(user.getUserId() > getLastUserIndex()) {
            userStorage.add(user);
            return;
        }

        userStorage.set(user.getUserId(), user);
    }

    public int getLastUserIndex() {
        return userStorage.size() - 1;
    }
}
