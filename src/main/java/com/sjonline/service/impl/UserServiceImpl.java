package com.sjonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjonline.mapper.CampusMapper;
import com.sjonline.mapper.UserMapper;
import com.sjonline.model.Campus;
import com.sjonline.model.User;
import com.sjonline.service.CampusService;
import com.sjonline.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired CampusMapper campusMapper;
	
    @Autowired
    private CampusService campusService;

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        // 验证校区有效性
        if (user.getCampusId() == null || user.getCampusId() <= 0) {
            throw new RuntimeException("请选择有效校区！");
        }
        Campus campus = campusService.selectById(user.getCampusId());
        if (campus.getStatus() != 1) {
            throw new RuntimeException("校区已失效！");
        }
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
    
    @Override
    public void setUserCampus(Long userId, Long campusId) {
        User user = getUserById(userId);
        if (user != null) {
            user.setCampusId(campusId);
            updateById(user);
        }
    }

	@Override
	public void updateById(User user) {
		 userMapper.updateById(user);
	}
    
}