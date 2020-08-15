/*
 Navicat Premium Data Transfer

 Source Server         : dudu
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : music

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 15/08/2020 10:51:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permission_id` bigint(18) UNSIGNED NOT NULL COMMENT '资源id',
  `permission_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '资源名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '描述',
  `parent_id` bigint(18) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父类id',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `operation` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作',
  `type` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '类型（0：菜单，1：按钮）',
  `sort` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '图标',
  `is_activation` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可用（0：false，1：true）',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '系统管理', '系统菜单栏【一级菜单】', 0, '', '', 0, 1, '', 0, '2018-09-19 15:08:15', '2018-09-19 15:08:17');
INSERT INTO `sys_permission` VALUES (2, '用户管理', '管理用户信息【二级菜单】', 1, '/user', 'user', 0, 2, '', 0, '2018-09-19 13:56:42', '2018-09-19 13:56:44');
INSERT INTO `sys_permission` VALUES (3, '角色管理', '管理角色资源【二级菜单】', 1, '/role', 'role', 0, 3, '', 0, '2018-09-19 14:58:27', '2018-09-19 14:58:28');
INSERT INTO `sys_permission` VALUES (4, '资源管理', '管理权限资源【二级菜单】', 1, '/permission', 'permission', 0, 4, '', 0, '2018-09-19 14:47:25', '2018-09-19 14:47:25');
INSERT INTO `sys_permission` VALUES (11, '新增用户', '添加一个用户信息', 2, '', 'user:add', 1, 5, '', 0, '2018-09-19 13:56:52', '2018-09-19 13:56:49');
INSERT INTO `sys_permission` VALUES (12, '编辑用户', '修改一个用户信息', 2, '', 'user:update', 1, 6, '', 0, '2018-09-19 13:58:56', '2018-09-19 13:58:58');
INSERT INTO `sys_permission` VALUES (13, '删除用户', '删除一个用户信息', 2, '', 'user:delete', 1, 7, '', 0, '2018-09-19 13:59:39', '2018-09-19 13:59:42');
INSERT INTO `sys_permission` VALUES (14, '批量删除用户', '删除多个用户信息', 2, '', 'user:batchDelete', 1, 8, '', 0, '2018-09-19 14:01:10', '2018-09-19 14:01:13');
INSERT INTO `sys_permission` VALUES (15, '分配角色', '为用户分配角色', 2, '', 'user:allotRole', 1, 9, '', 0, '2018-09-19 14:06:02', '2018-09-19 14:06:02');
INSERT INTO `sys_permission` VALUES (21, '新增角色', '添加一个角色信息', 3, '', 'role:add', 1, 10, '', 0, '2018-09-19 14:59:35', '2018-09-19 14:59:37');
INSERT INTO `sys_permission` VALUES (22, '编辑角色', '修改一个角色信息', 3, '', 'role:update', 1, 11, '', 0, '2018-09-19 15:02:05', '2018-09-19 15:02:06');
INSERT INTO `sys_permission` VALUES (23, '删除角色', '删除一个角色信息', 3, '', 'role:delete', 1, 12, '', 0, '2018-09-19 15:01:31', '2018-09-19 15:01:33');
INSERT INTO `sys_permission` VALUES (24, '批量删除角色', '删除多个角色信息', 3, '', 'role:batchDelete', 1, 13, '', 0, '2018-09-19 15:02:49', '2018-09-19 15:02:51');
INSERT INTO `sys_permission` VALUES (25, '分配权限', '为角色分配权限', 3, '', 'role:allotResource', 1, 14, '', 0, '2018-09-19 15:04:37', '2018-09-19 15:04:44');
INSERT INTO `sys_permission` VALUES (31, '新增资源', '添加一个资源信息', 4, '', 'permission:add', 1, 15, '', 0, '2018-09-19 14:49:20', '2018-09-19 14:49:18');
INSERT INTO `sys_permission` VALUES (32, '编辑资源', '修改一个资源信息', 4, '', 'permission:update', 1, 16, '', 0, '2018-09-19 14:49:18', '2018-09-19 14:49:18');
INSERT INTO `sys_permission` VALUES (33, '删除资源', '删除一个资源信息', 4, '', 'permission:delete', 1, 17, '', 0, '2018-09-19 14:53:39', '2018-09-19 14:53:41');
INSERT INTO `sys_permission` VALUES (34, '批量删除资源', '删除多个资源信息', 4, '', 'permission:batchDelete', 1, 18, '', 0, '2018-09-19 14:53:48', '2018-09-19 14:53:47');

SET FOREIGN_KEY_CHECKS = 1;
