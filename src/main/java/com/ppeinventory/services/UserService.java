package com.ppeinventory.services;

import com.ppeinventory.models.User;
import com.ppeinventory.utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String USER_FILE = "src/main/resources/users.txt";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    User user = new User(data[0], data[1], data[2], data[3]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(user.getUserId() + "," + user.getName() + "," + user.getPassword() + "," + user.getUserType());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        List<User> users = getAllUsers();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User u : users) {
                if (u.getUserId().equals(user.getUserId())) {
                    bw.write(user.getUserId() + "," + user.getName() + "," + user.getPassword() + "," + user.getUserType());
                } else {
                    bw.write(u.getUserId() + "," + u.getName() + "," + u.getPassword() + "," + u.getUserType());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String userId) {
        List<User> users = getAllUsers();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User u : users) {
                if (!u.getUserId().equals(userId)) {
                    bw.write(u.getUserId() + "," + u.getName() + "," + u.getPassword() + "," + u.getUserType());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findUserById(String userId) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}