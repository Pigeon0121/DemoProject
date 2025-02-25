package com.sjonline.mapper;

import org.apache.ibatis.annotations.*;

import com.sjonline.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(Long id);

    void saveUser(User user);


    @Select("SELECT * FROM user WHERE del_flag = 0")
    List<User> findAllUsers();

    @Update("UPDATE user SET remark = #{remark}, " +
            "update_time = #{updateTime}, update_id = #{updateId} " +
            "WHERE id = #{id}")
    void updateUser(User user);
    
    @Update("UPDATE user SET del_flag = 1 WHERE id = #{id}")
    void deleteUserById(Long id);
}