package me.devMuscle.unittesting.chapter5;

public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
    }

    public void setName(String value) {
        this.name = normalizeName(value);
    }

    public String normalizeName(String name) {
        String result = (name != null ? name : "").trim();

        if(result.length() > 50) {
            return result.substring(0, 50);
        }

        return result;
    }
}
