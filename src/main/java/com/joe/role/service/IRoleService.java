package com.joe.role.service;

import com.joe.role.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
public interface IRoleService{

    Role findRoleByUserId(Integer id);
}
