package com.ppeinventory.models;

public class User {
    private String userId;
    private String name;
    private String password;
    private String userType; // admin or staff

    public User(String userId, String name, String password, String userType) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}