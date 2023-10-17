package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

public class User {
    static int userIds=0;
    private String name;
    private String userName;
    private String email;
    private String phone;
    private int age;
    private int id;

    public User(String name, String userName, String email, String phone, int age) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.id = User.userIds++;
    }

    public static int getUserIds() {
        return userIds;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, email);
    }
}
