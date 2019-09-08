package com.joe.role.controller;

import com.joe.role.bo.ResponseUserToken;
import com.joe.role.bo.ResultJson;
import com.joe.role.code.ResultCode;
import com.joe.role.config.SecurityConfig;
import com.joe.role.entity.User;
import com.joe.role.security.SecurityUser;
import com.joe.role.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityConfig securityConfig;

    @GetMapping("/login")
    public ResultJson<ResponseUserToken> login(String username,String password) {
        ResponseUserToken responseUserToken = userService.login(username, password);
        return ResultJson.ok(responseUserToken);
    }

    @GetMapping("/user")
    public ResultJson<SecurityUser> getUser(HttpServletRequest request){
        String token = request.getHeader(securityConfig.getHeader());
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        SecurityUser securityUser = userService.getUserByToken(token);
        return ResultJson.ok(securityUser);
    }
}
