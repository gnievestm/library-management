package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.IUserPort;
import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.managers.UserManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserPort {

    private final UserManager userManager;

    public UserService() {
        this.userManager = new UserManager();
    }

    @Override
    public List<User> getAllUsers() {
        return this.userManager.getAllUsers();
    }

    public void addUser(String name, String userName, String email, String phone, int age) {
        User user = new User(name, userName, email, phone, age);
        this.userManager.addUser(user);
    }

    public void createUser(User user) {
        this.userManager.addUser(user);
    }

    public User getUserById(int id) {
        return userManager.findUserById(id);
    }

    public boolean existUser(User user) {
        return userManager.existUser(user);
    }
}
