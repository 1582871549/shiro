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

 Date: 15/08/2020 10:51:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(18) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '盐',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '名字',
  `sex` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别（0：不详，1：男，2：女）',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '手机号',
  `photo` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '头像',
  `is_locked` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否锁定（0：false，1：true）',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否进行逻辑删除（0：false，1：true）',
  `last_login_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uq_username`(`username`) USING BTREE COMMENT '用户名唯一索引',
  UNIQUE INDEX `uq_phone`(`phone`) USING BTREE COMMENT '手机号唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'dudu', '123456', '1', 'mengli', 0, '1', '1', 0, 0, '2020-07-16 10:21:53', '2020-07-16 10:21:53', '2020-07-16 10:21:53');
INSERT INTO `sys_user` VALUES (2, '', '', '', 'dudu', 0, '123', '', 0, 0, '2020-07-16 11:56:39', '2020-07-16 11:56:39', '2020-07-16 11:56:39');

SET FOREIGN_KEY_CHECKS = 1;
