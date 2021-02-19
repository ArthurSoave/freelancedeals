package com.soave.freelancerdeals.api;

import com.soave.freelancerdeals.domain.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1")
public interface UserResource {

    @GetMapping("/users/user/{ID}")
    User getUserById(@PathVariable("ID") int idUser) throws Exception;

    @PostMapping("/users/user")
    void addUser(@RequestBody User user);

    @PutMapping("/users/user/{ID}")
    User updateUser(@RequestBody User user, @PathVariable("ID") int idUser);

    @GetMapping("/users") //todo -> must be paginated
    List<User> getAllUsers();
}