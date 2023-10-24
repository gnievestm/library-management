package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        if (users.contains(user))
            return false;
        users.add(user);
        return true;
    }

    public boolean existUser(User user) {
        return users.contains(user);
    }

    public User findUserByName(String name) {
        User result = null;
        for (User user : this.users) {
            if (user.getName().equals(name))
                result = user;
        }
        return result;
    }

    public User findUserByUserName(String userName) {
        User result = null;
        for (User user : this.users) {
            if (user.getUserName().equals(userName))
                result = user;
        }
        return result;
    }

    public User findUserById(int id) {
        User result = null;
        for (User user : this.users) {
            if (user.getId() == id)
                result = user;
        }
        return result;
    }

    public List<Integer> getUserIdsByAge(int age) {
        List<Integer> ids = new ArrayList<>();
        for (User user : this.users) {
            if (user.getAge() == age)
                ids.add(user.getAge());
        }
        return ids;
    }
}
