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

 Date: 15/08/2020 10:51:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(18) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(18) UNSIGNED NOT NULL COMMENT '用户id',
  `role_id` bigint(18) UNSIGNED NOT NULL COMMENT '角色id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_user_id_role_id`(`user_id`, `role_id`) USING BTREE COMMENT '唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, '2020-07-16 10:25:42', '2020-07-16 10:25:42');
INSERT INTO `sys_user_role` VALUES (2, 1, 2, '2020-07-16 10:25:42', '2020-07-16 10:25:42');
INSERT INTO `sys_user_role` VALUES (3, 2, 2, '2020-07-16 10:25:42', '2020-07-16 10:25:42');
INSERT INTO `sys_user_role` VALUES (4, 2, 3, '2020-07-16 10:25:42', '2020-07-16 10:25:42');

SET FOREIGN_KEY_CHECKS = 1;
