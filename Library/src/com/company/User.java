package com.company;

public class User {
    private String username;
    private String position;

    public User(String username,String position) {
        setUsername(username);
        setPosition(position);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
