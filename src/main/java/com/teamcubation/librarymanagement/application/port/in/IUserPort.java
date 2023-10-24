package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.User;

import java.util.List;

public interface IUserPort {
    public List<User> getAllUsers();

    public User getUserById(int id);
    public void createUser(User user);
}