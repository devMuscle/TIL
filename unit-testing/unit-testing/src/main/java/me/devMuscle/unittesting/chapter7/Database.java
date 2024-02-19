package me.devMuscle.unittesting.chapter7;

public class Database {

    private Database() {}

    private static class DatabaseInstanceHandler {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return DatabaseInstanceHandler.INSTANCE;
    }

    public Object[] getUserById(int userId) {
        return new Object[]{userId, "user@email.com", UserType.EMPLOYEE};
    }

    public Object[] getCompany() {
        return new Object[]{"company.com", 10};
    }

    public void saveCompany(int numberOfEmployees) {}
    public void saveUser(User user) {}
}
