package com.sjonline.service.impl;

import com.sjonline.mapper.UserMapper;
import com.sjonline.model.User;
import com.sjonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }
}