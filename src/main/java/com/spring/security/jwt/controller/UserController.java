package com.spring.security.jwt.controller;

import com.spring.security.jwt.entity.Product;
import com.spring.security.jwt.entity.User;
import com.spring.security.jwt.repository.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepositry userRepositry;

    @PostMapping("/login/save")
    public void saveUser(@RequestBody User user){
        this.userRepositry.save(user);
    }
}
