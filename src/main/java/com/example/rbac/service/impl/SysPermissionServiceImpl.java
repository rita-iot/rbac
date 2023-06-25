package com.example.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rbac.mapper.SysPermissionMapper;
import com.example.rbac.entity.SysPermission;
import com.example.rbac.service.SysPermissionService;
/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/25 8:15
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService{

}
