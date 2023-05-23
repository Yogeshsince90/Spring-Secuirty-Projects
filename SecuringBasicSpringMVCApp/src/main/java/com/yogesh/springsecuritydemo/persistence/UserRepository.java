package com.yogesh.springsecuritydemo.persistence;

import com.yogesh.springsecuritydemo.web.model.User;

public interface UserRepository {

    Iterable<User> findAll();

    User save(User user);

    User findUser(Long id);

    void deleteUser(Long id);

}
