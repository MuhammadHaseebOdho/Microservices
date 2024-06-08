package com.user.service.service;

import com.user.service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    List<User> getUsers();

    User getUser(String id);

    User updateUser();

    void deleteUser();

}
