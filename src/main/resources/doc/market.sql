/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2021-02-19 08:29:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_code` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `cust_name` varchar(56) DEFAULT NULL COMMENT '客户名称',
  `cust_type` varchar(8) DEFAULT NULL COMMENT '客户类型',
  `id_type` varchar(8) DEFAULT NULL COMMENT '证件类型',
  `id_num` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `law_name` varchar(56) DEFAULT NULL COMMENT '法人名称',
  `law_num` varchar(32) DEFAULT NULL COMMENT '法人证件号码',
  `law_mobile` varchar(32) DEFAULT NULL COMMENT '法人手机号码',
  `register_time` date DEFAULT NULL COMMENT '注册时间',
  `register_money` decimal(11,2) DEFAULT NULL COMMENT '注册资金\n',
  `profession` varchar(32) DEFAULT NULL COMMENT '行业',
  `address` varchar(56) DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('10', 'USE_0001', 'C_2102182256002_3nd0yO', '123123', '01', '00', '123', null, null, null, null, null, null, null, null, null, '2021-02-18 22:56:02', '2021-02-18 22:56:02');
INSERT INTO `customer` VALUES ('11', 'USE_0001', 'C_2102182257028_7eHHlO', '12311', '01', '00', '11', null, null, null, null, null, null, null, null, null, '2021-02-18 22:57:29', '2021-02-18 22:57:29');
INSERT INTO `customer` VALUES ('12', 'USE_0001', 'C_2102182259054_l4YgHZ', '12311', '01', '00', '11', null, null, null, null, null, null, null, null, null, '2021-02-18 22:59:55', '2021-02-18 22:59:55');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_code` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `code` varchar(32) NOT NULL COMMENT '员工编号',
  `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
  `cust_type` varchar(8) DEFAULT NULL COMMENT '客户类型',
  `id_type` varchar(8) DEFAULT NULL COMMENT '证件类型',
  `id_num` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for market
-- ----------------------------
DROP TABLE IF EXISTS `market`;
CREATE TABLE `market` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `detail_code` varchar(32) DEFAULT NULL COMMENT '营销明细记录编号',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `start_time` date DEFAULT NULL COMMENT '服务开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `money` decimal(6,2) DEFAULT NULL COMMENT '缴费金额',
  `term` varchar(8) DEFAULT NULL COMMENT '期限',
  `pay_type` varchar(2) DEFAULT NULL COMMENT '当前打款方式',
  `accout_num` varchar(64) DEFAULT NULL COMMENT '当前打款账号',
  `pay_method` varchar(8) DEFAULT NULL COMMENT '缴费方式',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户营销';

-- ----------------------------
-- Records of market
-- ----------------------------

-- ----------------------------
-- Table structure for market_details
-- ----------------------------
DROP TABLE IF EXISTS `market_details`;
CREATE TABLE `market_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `market_code` varchar(32) DEFAULT NULL COMMENT '客户营销编号',
  `start_time` date DEFAULT NULL COMMENT '服务开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `money` decimal(6,2) DEFAULT NULL COMMENT '缴费金额',
  `term` varchar(8) DEFAULT NULL COMMENT '期限',
  `pay_type` varchar(2) DEFAULT NULL COMMENT '当前打款方式',
  `accout_num` varchar(64) DEFAULT NULL COMMENT '当前打款账号',
  `pay_method` varchar(8) DEFAULT NULL COMMENT '支付方式',
  `operator_code` varchar(32) DEFAULT NULL COMMENT '操作人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营销明细表';

-- ----------------------------
-- Records of market_details
-- ----------------------------

-- ----------------------------
-- Table structure for sever_operator_log
-- ----------------------------
DROP TABLE IF EXISTS `sever_operator_log`;
CREATE TABLE `sever_operator_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `entity_name` varchar(32) DEFAULT NULL COMMENT '业务名称',
  `entity_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `entity` blob COMMENT '业务实体',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sever_operator_log';

-- ----------------------------
-- Records of sever_operator_log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_name` varchar(56) DEFAULT NULL COMMENT '账号',
  `pass_word` varchar(128) DEFAULT NULL COMMENT '密码',
  `user_type` varchar(2) DEFAULT NULL COMMENT '客户类型',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'USE_0001', 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', '0', '2021-01-24 13:38:31');
