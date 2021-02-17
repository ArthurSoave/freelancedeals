package com.soave.freelancerdeals.domain.api;

import com.soave.freelancerdeals.domain.model.Location;
import com.soave.freelancerdeals.domain.model.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserResource{

    @Override
    public User getUserById(int idUser) {
        Location location = new Location();
        User user = new User();
        user.setLocation(location);
        return user;
    }

    @Override
    public User addUser(User user) {
        return new User();
    }

    @Override
    public User updateUser(User user, int idUser) {
        return new User();
    }
}
