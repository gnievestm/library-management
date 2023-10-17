package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.managers.UserManager;

public class UserService {

    static UserService instance;
    private UserManager userManager;
    public static UserService getInstance(){
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    private UserService(){
        this.userManager = new UserManager();
    }

    public void addUser(String name, String userName, String email, String phone, int age){
        User user = new User(name,userName,email,phone,age);
        this.userManager.addUser(user);
    }

    public boolean existUser(User user){
        return userManager.existUser(user);
    }

}
