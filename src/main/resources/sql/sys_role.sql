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

 Date: 15/08/2020 10:51:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(18) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '角色描述',
  `is_activation` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可用（0：false，1：true）',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理员', '管理所有资源', 1, '2019-10-21 16:17:50', '2020-06-02 16:54:29');
INSERT INTO `sys_role` VALUES (2, '用户管理员', '管理用户资源', 1, '2019-10-21 16:17:55', '2020-06-02 16:54:30');
INSERT INTO `sys_role` VALUES (3, '权限管理员', '管理权限资源', 1, '2019-10-21 16:17:52', '2020-06-02 16:54:31');
INSERT INTO `sys_role` VALUES (4, '角色管理员', '管理角色资源', 1, '2019-10-21 16:17:57', '2020-06-02 16:54:32');
INSERT INTO `sys_role` VALUES (5, '测试', '测试描述', 0, '2019-10-21 16:18:00', '2020-06-02 16:54:32');
INSERT INTO `sys_role` VALUES (6, '444', '描述', 0, '2020-05-27 12:03:12', '2020-06-02 16:54:33');
INSERT INTO `sys_role` VALUES (7, '444', '描述', 0, '2019-11-07 05:48:03', '2020-06-02 16:57:37');
INSERT INTO `sys_role` VALUES (8, 'a', '1', 0, '2020-06-02 16:55:25', '2020-06-02 16:57:36');
INSERT INTO `sys_role` VALUES (10, '444', '描述', 0, '2020-06-24 15:07:13', '2020-06-24 15:07:13');

SET FOREIGN_KEY_CHECKS = 1;
