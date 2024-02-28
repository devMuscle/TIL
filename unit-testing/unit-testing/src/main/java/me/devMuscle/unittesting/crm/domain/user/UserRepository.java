package me.devMuscle.unittesting.crm.domain.user;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.Transaction;
import me.devMuscle.unittesting.crm.domain.company.Company;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserRepository {

    private final Transaction transaction;

    private final List<User> userStorage = new ArrayList<>();

    public Object[] getUserById(int userId) {
        User user = userStorage.get(userId);
        return new Object[]{user.getUserId(), user.getEmail(), user.getType(), user.isEmailConfirmed()};
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
