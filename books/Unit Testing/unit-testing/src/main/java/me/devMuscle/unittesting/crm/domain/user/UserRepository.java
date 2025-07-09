package me.devMuscle.unittesting.crm.domain.user;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.CrmContext;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserRepository {

    private final CrmContext crmContext;

    private final List<User> userStorage = new ArrayList<>();

    public User getUserById(int userId) {
        return userStorage.get(userId);
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
