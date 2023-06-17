package com.example.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rbac.entity.SysUser;
import com.example.rbac.mapper.SysUserMapper;
import com.example.rbac.service.SysUserService;
/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:39
 * @version: 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

}
