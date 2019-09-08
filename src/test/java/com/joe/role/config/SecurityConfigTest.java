package com.joe.role.config;

import com.joe.role.RoleApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

@Slf4j
public class SecurityConfigTest extends RoleApplicationTests {
    @Autowired
    private SecurityConfig securityConfig;

    @Test
    public void testConfig() throws Exception{
        String secret = securityConfig.getSecret();
        assertTrue(secret != null);
    }

    @Test
    public void testEncode() throws Exception{
        String password = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }

}