package com.joe.role.mapper;

import com.joe.role.RoleApplicationTests;
import com.joe.role.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserMapperTest extends RoleApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapper() throws Exception {
        User user = userMapper.selectById(1);
        assertTrue(user != null);
    }

}