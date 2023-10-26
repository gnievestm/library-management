package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.User;

import java.util.List;

public interface IUserPort {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);
}