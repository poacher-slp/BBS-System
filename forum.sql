/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : forum

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 19/12/2021 23:09:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board`  (
  `board_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '论坛板块id',
  `board_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '论坛板块名称',
  `board_desc` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '论坛板块描述',
  `board_post_num` int(10) NOT NULL DEFAULT 0 COMMENT '帖子数目',
  PRIMARY KEY (`board_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `login_log_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `login_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登录IP',
  `login_datetime` datetime(0) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`login_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `post_board_id` int(10) NOT NULL DEFAULT 0 COMMENT '论坛板块ID',
  `post_user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '发表者名称',
  `post_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子名称',
  `post_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子内容',
  `post_good_count` int(10) NOT NULL DEFAULT 0 COMMENT '点赞',
  `post_bad_count` int(10) NOT NULL DEFAULT 0 COMMENT '踩数',
  `post_view_count` int(10) NOT NULL DEFAULT 0 COMMENT '游览次数',
  `post_reply_count` int(10) NOT NULL DEFAULT 0 COMMENT '回帖数目',
  `post_status` int(2) NOT NULL DEFAULT 0 COMMENT '帖子状态:0:正常 1:锁定',
  `post_create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `post_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `reply_post_id` int(10) NOT NULL COMMENT '所回复帖子的ID',
  `reply_user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回帖者姓名',
  `reply_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复内容',
  `reply_good_count` int(10) NOT NULL DEFAULT 0 COMMENT '点赞',
  `reply_bad_count` int(10) NOT NULL DEFAULT 0 COMMENT '踩数',
  `reply_create_time` datetime(0) NOT NULL COMMENT '回复时间',
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `user_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  `user_sex` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_phone` int(11) NULL DEFAULT NULL COMMENT '电话号码',
  `create_time` datetime(0) NOT NULL COMMENT '用户创建时间',
  `user_type` int(2) NOT NULL DEFAULT 1 COMMENT '用户类型 0:管理员 1:普通用户',
  `user_state` int(2) NOT NULL DEFAULT 0 COMMENT '用户状态 0:正常 1:冻结',
  `credit` int(10) NOT NULL DEFAULT 100 COMMENT '用户积分',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '用户最后登入时间',
  `last_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户最后登入ip',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE,
  UNIQUE INDEX `user_email`(`user_email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
