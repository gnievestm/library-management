package com.teamcubation.librarymanagement.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.teamcubation.librarymanagement.application.service.UserService;
import com.teamcubation.librarymanagement.domain.entities.User;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    void adduser() {
        UserService userService = new UserService();
        userService.addUser("name", "userName", "email", "phone", 21);
        User user = new User("name", "userName", "email", "phone", 21);
        boolean found = userService.existUser(user);

        assertTrue(found);
    }
}
