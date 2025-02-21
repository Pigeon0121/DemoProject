package com.sjonline.mapper;

import org.apache.ibatis.annotations.*;

import com.sjonline.model.User;

@Mapper
public interface UserMapper {

    // 查询用户（根据ID）
    User getUserById(Long id);

    // 新增用户
    void saveUser(User user);

    // 删除用户（逻辑删除）
    void deleteUserById(Long id);
}