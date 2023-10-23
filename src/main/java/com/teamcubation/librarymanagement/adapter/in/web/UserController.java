package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IUserPort;
import com.teamcubation.librarymanagement.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final IUserPort userPort;

    public UserController(IUserPort userPort) {
        this.userPort = userPort;
    }

    @GetMapping(path = "/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userPort.getAllUsers());
    }

    @GetMapping(path = "/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
        return ResponseEntity.ok(userPort.getUserById(userId));
    }

    @PostMapping(path = "/api/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userPort.createUser(user);
        return ResponseEntity.ok(user);
    }
}
