package com.example.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.rbac.entity.LoginUser;
import com.example.rbac.entity.SysUser;
import com.example.rbac.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:41
 * @version: 1.0
 */
@Service(value = "userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName, username);
        SysUser user = userMapper.selectOne(wrapper);
        //如果查询不到数据就通过抛出异常来给出提示
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名不存在");
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中
        //TODO 查询权限信息  一会儿真实查数据库，现在先做一个假的权限
        List<String> list = new ArrayList<>(Arrays.asList("sayhello", "delgoods"));
        //封装成UserDetails对象返回
        return new LoginUser(user, list);
    }
}

