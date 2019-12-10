/*
Navicat MySQL Data Transfer

Source Server         : goodjob
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-26 16:19:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(10) NOT NULL COMMENT '学号',
  `name` char(20) NOT NULL COMMENT '姓名',
  `room` char(20) DEFAULT NULL COMMENT '班级',
  `password` char(20) NOT NULL COMMENT '密码',
  `passwords` char(20) NOT NULL COMMENT '确认密码',
  `state` char(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0227', '贺一', '1', '0227', '0227', '');
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '');
INSERT INTO `user` VALUES ('110', '警察', '1', '110', '110', '');
INSERT INTO `user` VALUES ('12', '贺义龙', '6', '123', '12', '2');
INSERT INTO `user` VALUES ('120', '医生', '110', '110', '110', '');
INSERT INTO `user` VALUES ('531113', '一只鱼', '6', '531113', '531113', '');
