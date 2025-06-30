package com.bankapp.controller;

import com.bankapp.dto.UserDto;
import com.bankapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }
}