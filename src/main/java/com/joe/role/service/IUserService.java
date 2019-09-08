package com.joe.role.service;

import com.joe.role.bo.ResponseUserToken;
import com.joe.role.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joe.role.security.SecurityUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
public interface IUserService{
    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUserName(String username);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    ResponseUserToken login(String username, String password);


    /**
     * 根据Token获取用户信息
     * @param token
     * @return
     */
    SecurityUser getUserByToken(String token);
}
