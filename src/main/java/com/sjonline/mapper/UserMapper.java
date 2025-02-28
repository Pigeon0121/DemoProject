
package com.sjonline.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sjonline.model.User;



@Mapper
public interface UserMapper  {

    User getUserById(Long id);

    void saveUser(User user);

    List<User> findAllUsers();
    
    void updateUser(User user);
    void updateById(User user);
    
    void deleteUserById(Long id);
    
    User getUserWithCampus(Long id);
    
    List<User> findAllUsersWithCampus();
}