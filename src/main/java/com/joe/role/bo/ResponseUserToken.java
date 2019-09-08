package com.joe.role.bo;

import com.joe.role.security.SecurityUser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUserToken {

    private String token;

    private SecurityUser securityUser;
}
