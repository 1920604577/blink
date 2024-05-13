/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : blink

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 13/05/2024 17:19:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT ' 用户id',
  `role` int(5) NOT NULL DEFAULT 0 COMMENT ' 权限',
  `del_flag` tinyint(2) NOT NULL DEFAULT 0 COMMENT ' 逻辑删除(0:存在 1:删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 2, 5, 0);
INSERT INTO `admin` VALUES (6, 4, 4, 0);
INSERT INTO `admin` VALUES (7, 5, 0, 0);

-- ----------------------------
-- Table structure for dating_events
-- ----------------------------
DROP TABLE IF EXISTS `dating_events`;
CREATE TABLE `dating_events`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_date` datetime NOT NULL COMMENT '相亲活动日期',
  `message` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT ' 约会内容',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '相亲活动地点',
  `participant1_id` bigint(20) NOT NULL COMMENT '参与者1 ID',
  `participant2_id` bigint(20) NOT NULL COMMENT '参与者2 ID',
  `del_flag` tinyint(2) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0:存在 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dating_events
-- ----------------------------
INSERT INTO `dating_events` VALUES (1, '2024-05-18 00:00:00', '我爱你，在爱的回归线', '爱的回归线', 2, 5, 0);

-- ----------------------------
-- Table structure for dating_invitations
-- ----------------------------
DROP TABLE IF EXISTS `dating_invitations`;
CREATE TABLE `dating_invitations`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender_id` bigint(20) NOT NULL COMMENT '发送者ID',
  `receiver_id` bigint(20) NOT NULL COMMENT '接收者ID',
  `message` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `invitation_date` datetime NOT NULL COMMENT '邀请日期',
  `invitation_status` tinyint(2) NOT NULL DEFAULT 0 COMMENT '0:待确认 1:已确认 2:已拒绝',
  `del_flag` tinyint(2) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0:存在 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dating_invitations
-- ----------------------------
INSERT INTO `dating_invitations` VALUES (1, 2, 5, '我爱你', '2024-05-18 00:00:00', 1, 0);

-- ----------------------------
-- Table structure for profiles
-- ----------------------------
DROP TABLE IF EXISTS `profiles`;
CREATE TABLE `profiles`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片路径',
  `height` int(20) NOT NULL COMMENT '身高',
  `education_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学历',
  `occupation` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '职业',
  `interests_hobbies` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '爱好',
  `self_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '自我介use',
  `del_flag` tinyint(2) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0:存在 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of profiles
-- ----------------------------
INSERT INTO `profiles` VALUES (1, 1, 'ffdsf', 'xzcxcz', 175, '麻省理工', '神', '写代码', 'god一般的男人', 0);
INSERT INTO `profiles` VALUES (2, 5, '丛润泽', 'xcxcz', 170, '家大', '神', 'xd', 'asd', 0);
INSERT INTO `profiles` VALUES (4, 2, 'hln', NULL, 184, '麻省理工', '判官', '审判', '审判罪恶', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT ' 用户名',
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT ' 密码',
  `sex` tinyint(2) NOT NULL DEFAULT 0 COMMENT ' 性别(0：男，1：女)',
  `birth_data` datetime NOT NULL COMMENT '出生日期',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT ' 逻辑删除(0:存在 1:删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'hln', '123456', 1, '2024-05-11 00:00:00', 0);
INSERT INTO `user` VALUES (2, 'root', 'admin', 0, '2024-05-03 00:00:00', 0);
INSERT INTO `user` VALUES (3, 'tmd', 'tmd', 0, '2024-05-07 00:00:00', 0);
INSERT INTO `user` VALUES (4, 'xxx', '123', 1, '2024-05-13 00:00:00', 0);
INSERT INTO `user` VALUES (5, 'crz', 'crz', 0, '2004-05-05 00:00:00', 0);

SET FOREIGN_KEY_CHECKS = 1;
