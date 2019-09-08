package com.joe.role.service.impl;

import com.joe.role.RoleApplicationTests;
import com.joe.role.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends RoleApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findByUserName() {
        User user = userService.findByUserName("admin");
        assertTrue(user != null);
    }
}