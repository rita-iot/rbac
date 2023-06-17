package com.example.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rbac.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:39
 * @version: 1.0
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}