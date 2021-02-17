package com.soave.freelancerdeals.domain.model;

import java.time.LocalDate;

public class User {

    private int userId;

    private String name;

    private String email;

    private String login;

    private String password;

    private LocalDate userBirthdayDate;

    private boolean userIsActive;

    private Location location;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getUserBirthdayDate() {
        return userBirthdayDate;
    }

    public void setUserBirthdayDate(LocalDate userBirthdayDate) {
        this.userBirthdayDate = userBirthdayDate;
    }

    public boolean isUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(boolean userIsActive) {
        this.userIsActive = userIsActive;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
