package com.soave.freelancerdeals.service;

import com.soave.freelancerdeals.domain.exception.GenericErrorException;
import com.soave.freelancerdeals.domain.exception.NotFoundException;
import com.soave.freelancerdeals.domain.model.User;
import com.soave.freelancerdeals.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
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
    public User getUserById(int userId) throws GenericErrorException {
        Optional<User> userOpt = userRepository.getUserById(userId);
        return userOpt.orElseThrow(NotFoundException::new);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }
}
