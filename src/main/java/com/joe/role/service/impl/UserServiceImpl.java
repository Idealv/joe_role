package com.joe.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joe.role.bo.ResponseUserToken;
import com.joe.role.config.SecurityConfig;
import com.joe.role.entity.User;
import com.joe.role.mapper.UserMapper;
import com.joe.role.security.SecurityUser;
import com.joe.role.service.IUserService;
import com.joe.role.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public User findByUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, username);
        return userMapper.selectOne(wrapper);
    }

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResponseUserToken login(String username, String password) {
        Authentication authentication = authentication(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        SecurityUser userDetail = (SecurityUser) authentication.getPrincipal();
        String token = jwtTokenUtil.generateAccessToken(userDetail);
        jwtTokenUtil.putToken(username, token);

        return new ResponseUserToken(token, userDetail);
    }

    /**
     * 根据Token获取用户信息
     *
     * @param token
     * @return
     */
    @Override
    public SecurityUser getUserByToken(String token) {
        //去除Bearer
        token = token.substring(securityConfig.getTokenHead().length());

        return jwtTokenUtil.getUserFromToken(token);
    }

    private Authentication authentication(String username, String password) {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException | BadCredentialsException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
