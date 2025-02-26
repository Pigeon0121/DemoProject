package com.sjonline.controller;

import com.sjonline.model.User;
import com.sjonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null || user.getDelFlag() == 1) { // 过滤逻辑删除的用户
        	return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //示例值
        user.setCreateTime(new Date());
        user.setCreateId(1L); // 假设当前为1
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (user.getId() == null || user.getId() != id) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        user.setUpdateTime(new Date());
        user.setUpdateId(1L); // 假设当前用户ID为1
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
