package com.example.rbac.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.rbac.config.common.R;
import com.example.rbac.config.jwt.JwtUtil;
import com.example.rbac.config.redis.RedisCache;
import com.example.rbac.entity.LoginUser;
import com.example.rbac.entity.bo.SysUserBo;
import com.example.rbac.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:47
 * @version: 1.0
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisCache redisCache;

    @Override
    public R login(SysUserBo user) {
        //3使用ProviderManager auth方法进行验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //校验失败了
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //4自己生成jwt给前端
        LoginUser loginUser = (LoginUser) (authenticate.getPrincipal());
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap();
        map.put("token", jwt);
        //5系统用户相关所有信息放入redis
        String json = JSONObject.toJSONString(loginUser);
        redisCache.setCacheObject("login:" + userId, json);
        log.info("login success");
        return new R(200, "登陆成功", map);
    }

    @Override
    public R logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userId);
        log.info("logout success");
        return new R(200, "退出成功！");
    }
}

