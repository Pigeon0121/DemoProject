package com.sjonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjonline.mapper.UserMapper;
import com.sjonline.model.User;
import com.sjonline.service.UserService;

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
    
    @Override
    public List<User> findAll() {
        return userMapper.findAllUsers(); 
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}