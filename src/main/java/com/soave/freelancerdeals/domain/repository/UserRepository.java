package com.soave.freelancerdeals.domain.repository;

import com.soave.freelancerdeals.domain.model.User;

public interface UserRepository {

    User addUser(User user);

    User getUserById(int userId);

}
