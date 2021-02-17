package com.soave.freelancerdeals.domain.service;

import com.soave.freelancerdeals.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updUser(User user) {
        return null;
    }

    @Override
    public void dltUser(int userId) {

    }

    @Override
    public void inactivateUser(int userId) {

    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }
}
