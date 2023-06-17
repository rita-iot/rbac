package com.example.rbac.config.filter;

import com.alibaba.fastjson.JSON;
import com.example.rbac.config.common.R;
import com.example.rbac.config.common.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:57
 * @version: 1.0
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //给前端ResponseResult 的json
        R responseResult = new R(HttpStatus.FORBIDDEN.value(), "您权限不足!");
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
