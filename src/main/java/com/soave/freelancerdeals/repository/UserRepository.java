package com.soave.freelancerdeals.repository;

import com.soave.freelancerdeals.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void addUser(User user);

    Optional<User> getUserById(int userId);

    List<User> getAllUsers();

    void changeUserStatus(int idUser, boolean isActive);
}
