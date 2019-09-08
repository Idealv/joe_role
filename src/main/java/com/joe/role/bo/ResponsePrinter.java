package com.joe.role.bo;

import com.alibaba.fastjson.JSON;
import com.joe.role.code.ResultCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponsePrinter {
    public static void writJson(HttpServletResponse response, ResultCode resultCode, String msg) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 状态
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSON.toJSONString(ResultJson.failure(resultCode,msg)));
        printWriter.flush();
    }
}
