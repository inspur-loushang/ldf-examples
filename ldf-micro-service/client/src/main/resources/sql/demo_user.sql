/*
Navicat MySQL Data Transfer

Source Server         : 101.132.128.194
Source Server Version : 50719
Source Host           : 101.132.128.194:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-06 09:32:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` varchar(128) NOT NULL,
  `user_id` varchar(30) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(128) NOT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `act_status` varchar(1) NOT NULL DEFAULT 'N' COMMENT 'N: 正常 L: 锁定(待激活) X：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
