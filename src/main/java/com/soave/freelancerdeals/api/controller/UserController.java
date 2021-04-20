package com.soave.freelancerdeals.api.controller;

import com.soave.freelancerdeals.api.resource.UserResource;
import com.soave.freelancerdeals.domain.model.User;
import com.soave.freelancerdeals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserResource {

    @Autowired
    private UserService userService;

    @Override
    public void addUser(User user) {
        userService.addUser(user);
    }

    @Override
    public User updateUser(User user, int idUser) {
        return null;
    }

    @Override
    public void deleteUser(int idUser) {
        userService.dltUser(idUser);
    }

    @Override
    public User getUserById(int idUser) throws Exception {
        return userService.getUserById(idUser);
    }

    @Override
    public List<User> getUserByLogin(String userName) {
        return userService.getUsersByLogin(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @Override
    public void changeUserStatus(int idUser, boolean isActive) {
        userService.changeUserStatus(idUser, isActive);
    }
}
