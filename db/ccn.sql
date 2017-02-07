/*
Navicat MySQL Data Transfer

Source Server         : cheng、
Source Server Version : 50551
Source Host           : localhost:3306
Source Database       : ccn

Target Server Type    : MYSQL
Target Server Version : 50551
File Encoding         : 65001

Date: 2016-12-27 12:10:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `Administrator_id` int(8) NOT NULL AUTO_INCREMENT,
  `Administrator_name` varchar(40) NOT NULL,
  `Administrator_password` varchar(40) NOT NULL,
  PRIMARY KEY (`Administrator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'ccn', 'cheng123456');
INSERT INTO `administrator` VALUES ('2', 'sys', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(40) NOT NULL,
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_password` varchar(40) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('tom', '1', '123456');
INSERT INTO `user` VALUES ('lazha', '2', '123');
