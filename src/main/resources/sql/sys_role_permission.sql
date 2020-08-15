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

 Date: 15/08/2020 10:51:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(18) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(18) UNSIGNED NOT NULL COMMENT '角色id',
  `permission_id` bigint(18) UNSIGNED NOT NULL COMMENT '权限id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_role_id_permission_id`(`role_id`, `permission_id`) USING BTREE COMMENT '唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, 1, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (2, 1, 2, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (3, 1, 3, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (4, 1, 4, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (5, 1, 5, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (6, 1, 6, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (7, 1, 7, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (8, 1, 8, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (9, 1, 9, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (10, 1, 10, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (11, 1, 11, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (12, 1, 12, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (13, 1, 13, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (14, 1, 14, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (15, 1, 15, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (16, 1, 16, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (17, 1, 17, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (18, 1, 18, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (19, 1, 19, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (20, 2, 1, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (21, 2, 2, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (22, 2, 3, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (23, 2, 4, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (24, 2, 5, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (25, 2, 6, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (26, 2, 7, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (27, 3, 8, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (28, 3, 9, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (29, 3, 10, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (30, 3, 11, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (31, 3, 12, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (32, 3, 13, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (33, 4, 8, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (34, 4, 14, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (35, 4, 15, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (36, 4, 16, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (37, 4, 17, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (38, 4, 18, '2020-07-16 10:27:15', '2020-07-16 10:27:15');
INSERT INTO `sys_role_permission` VALUES (39, 4, 19, '2020-07-16 10:27:15', '2020-07-16 10:27:15');

SET FOREIGN_KEY_CHECKS = 1;
