package com.ppeinventory.controllers;

import com.ppeinventory.models.User;
import com.ppeinventory.services.UserService;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void modifyUser(User user) {
        userService.modifyUser(user);
    }

    public User searchUser(String userId) {
        return userService.searchUser(userId);
    }

    public void deleteUser(String userId) {
        userService.deleteUser(userId);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}