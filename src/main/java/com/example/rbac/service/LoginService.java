package com.example.rbac.service;

import com.example.rbac.config.common.R;
import com.example.rbac.entity.bo.SysUserBo;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:47
 * @version: 1.0
 */
public interface LoginService {
    public R login(SysUserBo user);

    R logout();
}
