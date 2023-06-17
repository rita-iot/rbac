package com.example.rbac.controller;

import com.example.rbac.config.common.R;
import com.example.rbac.entity.bo.SysUserBo;
import com.example.rbac.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:46
 * @version: 1.0
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/admin/login")
    public R login(@RequestBody SysUserBo user) {
        return loginService.login(user);
    }

    @GetMapping("/admin/logout")
    public R logout(){
        return loginService.logout();
    }
}
