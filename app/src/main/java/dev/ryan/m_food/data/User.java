package dev.ryan.m_food.data;

public class User {

    int id;
    String name;
    String password;

    public User(int id, String name, String password) {

        this.id = id;
        this.name = name;
        this.password = password;

        }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

}
