package com.sjonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sjonline.model.User;

@Service
public interface UserService {

    User getUserById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}