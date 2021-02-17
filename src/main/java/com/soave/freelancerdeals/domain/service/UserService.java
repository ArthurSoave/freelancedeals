package com.soave.freelancerdeals.domain.service;

import com.soave.freelancerdeals.domain.model.User;

import java.util.List;

public interface UserService {

    //save user in database
    User addUser(User user);

    //edit user in database
    User updUser(User user);

    //fisical delete of user in database
    void dltUser(int userId);

    //logical delete of user in database
    void inactivateUser(int userId);

    //get user by id from database
    User getUserById(int userId);

    //get all users from database
    List<User> getUsers();

    //get users by name
    List<User> getUsersByName(String name);

}
