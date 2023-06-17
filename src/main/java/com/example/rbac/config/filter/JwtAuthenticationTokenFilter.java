package com.example.rbac.config.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.rbac.config.jwt.JwtUtil;
import com.example.rbac.config.redis.RedisCache;
import com.example.rbac.entity.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:49
 * @version: 1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //1获取token  header的token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行，让后面的过滤器执行
            filterChain.doFilter(request, response);
            return;
        }
        //2解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token不合法！");
        }

        //3获取userId, redis获取用户信息
        String json = redisCache.getCacheObject("login:" + userId);
        LoginUser loginUser = JSONObject.parseObject(json, LoginUser.class);
        //SysUser sysUser = JSONObject.parseObject(json, SysUser.class);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("当前用户未登录！");
        }
        //LoginUser loginUser = new LoginUser();
        //loginUser.setUser(sysUser);
        //4封装Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

        //5存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        //放行，让后面的过滤器执行
        filterChain.doFilter(request, response);
    }
}
