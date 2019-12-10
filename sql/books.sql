/*
Navicat MySQL Data Transfer

Source Server         : goodjob
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-26 16:19:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `number` int(220) NOT NULL COMMENT '编号',
  `bookname` char(100) NOT NULL COMMENT '书名',
  `writer` char(100) DEFAULT NULL COMMENT '作者',
  `math` int(100) DEFAULT NULL COMMENT '数量',
  `borrow` char(100) DEFAULT NULL,
  `people` char(100) DEFAULT NULL COMMENT '借书人',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '新海诚', '你的名字', '5', '已借出', '1');
INSERT INTO `books` VALUES ('2', '三体', '刘慈欣', '50', '已借出', '1');
INSERT INTO `books` VALUES ('3', '放学后', '东野圭吾', '5', '', null);
INSERT INTO `books` VALUES ('4', '白夜行', '东野圭吾', '5', null, null);
INSERT INTO `books` VALUES ('5', '你好之花', '花花', '5', null, null);
INSERT INTO `books` VALUES ('6', '大腕宽面', '吴亦凡', '6', null, null);
INSERT INTO `books` VALUES ('12', '12', '12', '12', '', '1');
INSERT INTO `books` VALUES ('66', '搁浅', '周杰伦', '6', null, null);
INSERT INTO `books` VALUES ('88', '七里香', '周杰伦', '6', null, null);
INSERT INTO `books` VALUES ('89', '你的名字', '三叶', '5', null, null);
INSERT INTO `books` VALUES ('98', '三体', '刘慈欣', '5', null, null);
INSERT INTO `books` VALUES ('111', '寄生兽', '小佑', '6', null, null);
INSERT INTO `books` VALUES ('354', '你的名字', '新海诚', '6', null, null);
INSERT INTO `books` VALUES ('666', '天长地久', '李银河', '6', null, null);
INSERT INTO `books` VALUES ('777', '暴走大事件', '王尼玛', '5', null, null);
INSERT INTO `books` VALUES ('789', '精神领袖', '贺义龙', '6', null, null);
INSERT INTO `books` VALUES ('888', '稻香', '周杰伦', '6', null, null);
INSERT INTO `books` VALUES ('891', '将夜', '宁缺', '5', null, null);
INSERT INTO `books` VALUES ('892', '蜘蛛侠', '河南弟', '5', null, null);
