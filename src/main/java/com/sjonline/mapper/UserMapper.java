package com.sjonline.mapper;

import com.sjonline.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // 查询用户（根据ID）
    @Select("SELECT * FROM sys_user WHERE id = #{id} AND del_fg = 0")
    User getUserById(Long id);

    // 新增用户
    @Insert("INSERT INTO sys_user (remark, del_fg, create_time, update_time, create_id, update_id) " +
           "VALUES (#{remark}, #{delFlag}, #{createTime}, #{updateTime}, #{createId}, #{updateId})")
    void saveUser(User user);

    // 删除用户（逻辑删除）
    @Update("UPDATE sys_user SET del_fg = 1 WHERE id = #{id}")
    void deleteUserById(Long id);
}