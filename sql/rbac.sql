/*
 Navicat Premium Data Transfer

 Source Server         : 42.192.37.49
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 42.192.37.49:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 25/06/2023 09:01:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路径',
  `orders` int(11) NULL DEFAULT 1 COMMENT '顺序',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'grid' COMMENT '图标',
  `page` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '页面路径',
  `auth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级id',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型，1目录  2菜单 3按钮',
  `hide` tinyint(1) NULL DEFAULT 0 COMMENT '是否隐藏',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `a_d_index`(`auth`, `deleted`) USING BTREE,
  UNIQUE INDEX `p_p_d_index`(`path`, `page`, `deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '系统管理', '', 2, 'menu', NULL, NULL, NULL, 0, '2023-01-16 20:45:51', '2023-01-16 20:45:51', 1, 0);
INSERT INTO `sys_permission` VALUES (3, '用户管理', 'user', 1, 'grid', 'User', 'user.list', 1, 0, '2023-01-16 20:45:51', '2023-01-16 20:45:51', 2, 0);
INSERT INTO `sys_permission` VALUES (4, '用户新增', '', 1, 'grid', '', 'user.add', 3, 0, '2023-01-16 20:45:51', '2023-01-16 20:45:51', 3, 0);
INSERT INTO `sys_permission` VALUES (8, '用户编辑', '', 1, 'grid', NULL, 'user.edit', 3, 0, NULL, '2023-01-28 11:45:21', 3, 0);
INSERT INTO `sys_permission` VALUES (9, '用户删除', NULL, 1, 'grid', NULL, 'user.delete', 3, 0, '2023-01-29 11:04:15', '2023-01-29 11:04:15', 3, 0);
INSERT INTO `sys_permission` VALUES (10, '角色管理', 'role', 1, 'grid', 'Role', 'role.list', 1, 0, '2023-01-31 20:32:59', '2023-01-31 20:32:59', 2, 0);
INSERT INTO `sys_permission` VALUES (11, '权限管理', 'permission', 1, 'grid', 'Permission', 'permission.list', 1, 0, '2023-01-31 20:33:25', '2023-01-31 20:33:25', 2, 0);
INSERT INTO `sys_permission` VALUES (12, '首页', 'home', 1, 'house', 'Home', NULL, NULL, 0, '2023-01-31 21:03:00', '2023-01-31 21:03:00', 2, 0);
INSERT INTO `sys_permission` VALUES (13, '数据字典管理', 'dict', 1, 'grid', 'Dict', 'dict.list', 1, 0, '2023-02-02 20:41:32', '2023-02-02 20:41:32', 2, 0);
INSERT INTO `sys_permission` VALUES (14, '批量删除', NULL, 1, 'grid', NULL, 'user.deleteBatch', 3, 0, '2023-02-02 22:32:22', '2023-02-02 22:32:22', 3, 0);
INSERT INTO `sys_permission` VALUES (15, '用户导入', NULL, 1, 'grid', NULL, 'user.import', 3, 0, '2023-02-02 22:32:53', '2023-02-02 22:32:53', 3, 0);
INSERT INTO `sys_permission` VALUES (16, '用户导出', NULL, 1, 'grid', NULL, 'user.export', 3, 0, '2023-02-02 22:33:08', '2023-02-02 22:33:08', 3, 0);
INSERT INTO `sys_permission` VALUES (17, '聊天管理', 'im', 1, 'grid', 'Im', 'im.list', NULL, 0, '2023-02-09 21:35:17', '2023-02-09 21:35:17', 2, 0);
INSERT INTO `sys_permission` VALUES (27, '动态管理', 'dynamic', 1, 'grid', 'Dynamic', NULL, NULL, 0, NULL, NULL, 2, 0);
INSERT INTO `sys_permission` VALUES (28, '动态查询', NULL, 1, 'grid', NULL, 'dynamic.list', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (29, '动态新增', NULL, 1, 'grid', NULL, 'dynamic.add', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (30, '动态导入', NULL, 1, 'grid', NULL, 'dynamic.import', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (31, '动态导出', NULL, 1, 'grid', NULL, 'dynamic.export', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (32, '批量删除', NULL, 1, 'grid', NULL, 'dynamic.deleteBatch', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (33, '动态编辑', NULL, 1, 'grid', NULL, 'dynamic.edit', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (34, '动态删除', NULL, 1, 'grid', NULL, 'dynamic.delete', 27, 0, NULL, NULL, 3, 0);
INSERT INTO `sys_permission` VALUES (35, '热门动态', NULL, 1, 'grid', NULL, 'dynamic.list.hot', 27, 0, '2023-02-12 21:24:34', '2023-02-12 21:24:34', 3, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` bigint(200) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(200) NOT NULL DEFAULT 0 COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `phone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '电话',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (3, 'test', '1', '13662301000', '$2a$12$pgFnH5Ot.XIvbaTM7X9nNe8AGwBV.3eggszusKShXXG2HJ1fFdNMO', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(200) NOT NULL COMMENT '用户id',
  `role_id` bigint(200) NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
