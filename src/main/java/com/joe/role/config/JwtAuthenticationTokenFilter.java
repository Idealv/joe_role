package com.joe.role.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.joe.role.security.SecurityUser;
import com.joe.role.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Component("authenticationTokenFilter")
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取http请求头中的Authorization字段
        String authToken = request.getHeader(securityConfig.getHeader());

        log.info(authToken);
        //token格式: Bearer jwt字符串
        if (StringUtils.isNotEmpty(authToken) && authToken.startsWith(securityConfig.getTokenHead())) {
            //去除Bearer
            authToken = authToken.substring(securityConfig.getTokenHead().length());
            log.info("请求" + request.getRequestURI() + "携带的token值：" + authToken);
            //如果在token过期之前触发接口,我们更新token过期时间，token值不变只更新过期时间
            //获取token生成时间
            Date createTokenDate = jwtTokenUtil.getCreatedDateFromToken(authToken);
            log.info("jwt签发时间: " + createTokenDate);

        } else {
            // 不按规范,不允许通过验证
            authToken = null;
        }
        //获取用户名
        String username = jwtTokenUtil.getUsernameFromToken(authToken);

        log.info("JwtAuthenticationTokenFilter[doFilterInternal] checking authentication " + username);

        if (jwtTokenUtil.containToken(username, authToken) && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            SecurityUser userDetail = jwtTokenUtil.getUserFromToken(authToken);
            if (jwtTokenUtil.validateToken(authToken, userDetail)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                log.info(String.format("Authenticated userDetail %s, setting security context", username));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
