package com.joe.role.mapper;

import com.joe.role.RoleApplicationTests;
import com.joe.role.entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RoleMapperTest extends RoleApplicationTests {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void findRoleByUserId() {
        Role role = roleMapper.findRoleByUserId(1);
        assertTrue(role != null);
    }
}