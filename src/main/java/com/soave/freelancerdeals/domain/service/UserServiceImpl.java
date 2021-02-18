package com.soave.freelancerdeals.domain.service;

import com.soave.freelancerdeals.domain.model.User;
import com.soave.freelancerdeals.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
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
