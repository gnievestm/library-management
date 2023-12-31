package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.managers.UserManager;
import com.teamcubation.librarymanagement.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    @Test
    void adduser() {
        UserService userService = UserService.getInstance();
        userService.addUser("name", "userName", "email", "phone", 21);
        User user = new User("name", "userName", "email", "phone", 21);
        boolean found = userService.existUser(user);

        assertTrue(found);
    }
}




