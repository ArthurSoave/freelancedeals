package com.soave.freelancerdeals.domain.api;

import com.soave.freelancerdeals.domain.model.User;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1")
public interface UserResource {

    @GetMapping("/user/{ID}")
    User getUserById(@PathVariable("ID") int idUser);

    @PostMapping("/user")
    User addUser(@RequestBody User user);

    @PutMapping("/user/{ID}")
    User updateUser(@RequestBody User user, @PathVariable("ID") int idUser);
}
