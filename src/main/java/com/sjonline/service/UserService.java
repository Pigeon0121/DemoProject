package com.sjonline.service;

import com.sjonline.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUserById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}