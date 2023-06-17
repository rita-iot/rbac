package com.example.rbac.config.filter;

import com.alibaba.fastjson.JSON;
import com.example.rbac.config.common.R;
import com.example.rbac.config.common.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:55
 * @version: 1.0
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //给前端ResponseResult 的json
        R responseResult = new R(HttpStatus.UNAUTHORIZED.value(), "用户信息已过期，请重新登录");
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
