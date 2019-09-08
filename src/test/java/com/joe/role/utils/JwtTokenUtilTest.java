package com.joe.role.utils;

import com.joe.role.RoleApplicationTests;
import com.joe.role.entity.Role;
import com.joe.role.security.SecurityUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class JwtTokenUtilTest extends RoleApplicationTests {
    @Autowired
    private JwtTokenUtil util;

    //@Test
    private String generateAccessToken() {
        SecurityUser securityUser = new SecurityUser(1, "xiaoming", "123456",
                new Role(1, "USER"));

         return util.generateAccessToken(securityUser);
    }

    @Test
    public void testGetUserFromToken() throws Exception{
        String token = generateAccessToken();
        //assertTrue(token!=null);

        SecurityUser user = util.getUserFromToken(token);

    }
}