package com.sjonline.service;

import com.sjonline.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // 查询用户（根据ID）
    User getUserById(Long id);

    // 新增用户
    void saveUser(User user);

    // 删除用户（逻辑删除）
    void deleteUserById(Long id);
}