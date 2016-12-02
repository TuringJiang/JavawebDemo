/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-02 00:35:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `beizhu` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('142100701', 'wangjing', '女', '软工王晶');
INSERT INTO `student` VALUES ('142100718', 'duyuhao', 'ha', 'duyuhao');
INSERT INTO `student` VALUES ('142100724', 'zhangming', 'm', 'zhangming');
INSERT INTO `student` VALUES ('142100731', 'wuhao', 'm', '吴昊');
INSERT INTO `student` VALUES ('142100734', 'liyaoheng', 'nan', '14ruangong');
INSERT INTO `student` VALUES ('142100735', 'yangqifan', '女', '14软工');
INSERT INTO `student` VALUES ('142100736', 'linlin', 'm', '林麟');
INSERT INTO `student` VALUES ('142100744', 'jianghao', 'm', '姜浩');
