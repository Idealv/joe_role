package com.joe.role.service.impl;

import com.joe.role.entity.Role;
import com.joe.role.mapper.RoleMapper;
import com.joe.role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findRoleByUserId(Integer id) {
        return roleMapper.findRoleByUserId(id);
    }
}
