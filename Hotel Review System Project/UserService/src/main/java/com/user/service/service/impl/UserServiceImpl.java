package com.user.service.service.impl;

import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository  userRepository;

    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Requested Resource Can not be found on server"+id));
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
