package com.example.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/25 8:15
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_permission")
public class SysPermission {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 路径
     */
    @TableField(value = "`path`")
    private String path;

    /**
     * 顺序
     */
    @TableField(value = "orders")
    private Integer orders;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 页面路径
     */
    @TableField(value = "page")
    private String page;

    /**
     * 权限
     */
    @TableField(value = "auth")
    private String auth;

    /**
     * 父级id
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 类型，1目录  2菜单 3按钮
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 是否隐藏
     */
    @TableField(value = "hide")
    private Boolean hide;
}