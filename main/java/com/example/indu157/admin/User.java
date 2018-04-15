package com.example.admin1.stitchger_android;

public class User {
    public String name;
    public String password;
    public String role;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
