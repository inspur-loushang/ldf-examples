/*
Navicat MySQL Data Transfer

Source Server         : 101.132.128.194
Source Server Version : 50719
Source Host           : 101.132.128.194:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-06 09:32:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_archives
-- ----------------------------
DROP TABLE IF EXISTS `demo_archives`;
CREATE TABLE `demo_archives` (
  `id` varchar(128) NOT NULL,
  `gender` char(1) NOT NULL COMMENT 'M:男 F:女 N:未知',
  `birthday` char(15) DEFAULT NULL,
  `education` char(1) DEFAULT NULL COMMENT '学历',
  `school` varchar(30) DEFAULT NULL COMMENT '学校',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  CONSTRAINT `demo_archives_fk1` FOREIGN KEY (`id`) REFERENCES `demo_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
