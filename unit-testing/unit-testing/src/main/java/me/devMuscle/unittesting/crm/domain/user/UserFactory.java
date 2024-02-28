package me.devMuscle.unittesting.crm.domain.user;

import org.springframework.util.Assert;

public class UserFactory {

    public static User create(Object[] data) {
        Assert.isTrue(data.length >= 3, "data의 길이가 3보다 작습니다.");

        int id = (int)data[0];
        String email = (String)data[1];
        UserType type = (UserType)data[2];
        boolean isEmailConfirmed = (boolean)data[3];

        return new User(id, email, type, isEmailConfirmed);
    }

    public static User createUser(String email, UserType userType, Database db) {
        User user = new User(db.getLastUserIndex()+1, email, userType, false);
        db.saveUser(user);
        return user;
    }
}
