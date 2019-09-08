package com.joe.role.config;

import com.alibaba.fastjson.JSON;
import com.joe.role.bo.ResponsePrinter;
import com.joe.role.code.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//权限不足处理类
@Slf4j
@Component("accessDeniedHandler")
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public  void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        StringBuilder msg = new StringBuilder("请求: ");
        msg.append(request.getRequestURI()).append(" 权限不足，无法访问系统资源.");
        log.info(msg.toString());
        ResponsePrinter.writJson(response, ResultCode.FORBIDDEN, msg.toString());
    }
}
