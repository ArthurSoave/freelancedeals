package com.soave.freelancerdeals.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class User {

    @JsonProperty(value = "user_id")
    private int userId;

    @JsonProperty(value = "user_name")
    private String name;

    @JsonProperty(value = "user_email")
    private String email;

    @JsonProperty(value = "user_login")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String login;

    @JsonProperty(value = "user_password")
    private String password;

    @JsonProperty(value = "user_birthday_date")
    private LocalDate userBirthdayDate;

    @JsonProperty(value = "user_is_active")
    private boolean userIsActive;

    @JsonProperty(value = "user_location")
    private Location location;

    public User(int userId, String name, String email, String login, String password, LocalDate userBirthdayDate, boolean userIsActive, Location location) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.userBirthdayDate = userBirthdayDate;
        this.userIsActive = userIsActive;
        this.location = location;
    }

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
