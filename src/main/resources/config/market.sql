/*
Navicat MySQL Data Transfer

Source Server         : 182.92.204.169
Source Server Version : 50730
Source Host           : 182.92.204.169:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2021-03-20 20:09:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_money_details
-- ----------------------------
DROP TABLE IF EXISTS `account_money_details`;
CREATE TABLE `account_money_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) DEFAULT NULL COMMENT '账户编号',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `contract_code` varchar(32) DEFAULT NULL COMMENT '合同编号',
  `status` varchar(2) DEFAULT NULL COMMENT '打款状态',
  `pay_method` varchar(8) DEFAULT NULL COMMENT '支付方式',
  `pay_type` varchar(8) DEFAULT NULL COMMENT '支付类型',
  `account_num` varchar(128) DEFAULT NULL COMMENT '账户号码',
  `pay_money` decimal(11,2) DEFAULT NULL COMMENT '支付金额',
  `type` varchar(2) DEFAULT NULL COMMENT '1:打款\n0：扣款\n',
  `operator_code` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operator_name` varchar(64) DEFAULT NULL COMMENT '操作员名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COMMENT='支付金额明细';

-- ----------------------------
-- Records of account_money_details
-- ----------------------------

-- ----------------------------
-- Table structure for account_money_sum
-- ----------------------------
DROP TABLE IF EXISTS `account_money_sum`;
CREATE TABLE `account_money_sum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `contract_code` varchar(32) DEFAULT NULL COMMENT '合同编号',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `total_money` decimal(13,2) DEFAULT NULL COMMENT '资金总额',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='资金总额管理';

-- ----------------------------
-- Records of account_money_sum
-- ----------------------------

-- ----------------------------
-- Table structure for contractdetails
-- ----------------------------
DROP TABLE IF EXISTS `contractdetails`;
CREATE TABLE `contractdetails` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `contract_name` varchar(128) DEFAULT NULL COMMENT '合同名称',
  `start_time` datetime DEFAULT NULL COMMENT '合同开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `term` varchar(8) DEFAULT NULL COMMENT '期限',
  `total_money` decimal(11,2) DEFAULT NULL COMMENT '总金额',
  `status` varchar(2) DEFAULT NULL COMMENT '合同状态',
  `type` varchar(8) DEFAULT NULL COMMENT '合同类型',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `manager_code` varchar(32) DEFAULT NULL COMMENT '客户经理编码',
  `operator_code` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operator_name` varchar(64) DEFAULT NULL COMMENT '操作人名称',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COMMENT='合同表';

-- ----------------------------
-- Records of contractdetails
-- ----------------------------
INSERT INTO `contractdetails` VALUES ('1', 'AAAA', 'C_2102192154007_B33Imu', '第一个合同', '2021-03-09 00:00:00', '2021-03-17 00:00:00', '24', '1000000.00', '01', '', null, 'USE_0001', 'USE_0001', 'admin', '2021-03-11 22:15:33', '2021-02-27 16:00:07');
INSERT INTO `contractdetails` VALUES ('18', 'C_2103032127051_YvecxI', 'C_2103012229057_P66ytH', '第5号合同', '2021-03-03 00:00:00', '2021-06-03 00:00:00', '3', '100000.00', '01', null, null, 'USE_0001', 'USE_0001', 'admin', '2021-03-03 21:27:52', '2021-03-03 21:27:52');
INSERT INTO `contractdetails` VALUES ('20', 'C_2103092359052_MOXGrX', 'C_2103012232030_QqLuQz', '第3号合同', '2021-03-09 00:00:00', '2031-06-09 00:00:00', '123', '111111.00', '00', null, null, '', '', '', '2021-03-09 23:59:52', '2021-03-09 23:59:52');
INSERT INTO `contractdetails` VALUES ('21', 'C_2103102143024_TyetoL', 'C_2103012230022_ytJvTh', '第4号合同', '2021-03-09 00:00:00', '2021-04-09 00:00:00', '1', '2.00', '01', null, null, '', '', '', '2021-03-10 21:43:24', '2021-03-10 21:43:24');
INSERT INTO `contractdetails` VALUES ('22', 'C_2103102146053_rBhk0o', 'C_2103012230022_ytJvTh', '第5号合同', '2021-03-10 00:00:00', '2022-02-10 00:00:00', '11', '10000.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-10 21:46:53', '2021-03-10 21:46:53');
INSERT INTO `contractdetails` VALUES ('23', 'C_2103112202050_vakfQt', 'C_2102211714018_ztMGSE', '第6号合同', '2021-03-10 00:00:00', '2021-03-24 00:00:00', '0', '11.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:16:07', '2021-03-11 22:02:51');
INSERT INTO `contractdetails` VALUES ('24', 'C_2103112205003_TsL6xp', 'C_2103012230022_ytJvTh', '第7号合同', '2021-03-10 00:00:00', '2021-03-07 00:00:00', '0', '111.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:11:20', '2021-03-11 22:05:04');
INSERT INTO `contractdetails` VALUES ('25', 'C_2103112207045_BNLP9r', 'C_2103012230022_ytJvTh', '第8号合同', '2021-03-10 00:00:00', '2021-03-10 00:00:00', '1111', '1111.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:10:44', '2021-03-11 22:07:46');
INSERT INTO `contractdetails` VALUES ('26', 'C_2103112209052_PgTFzI', 'C_2102211715007_7H3Vvd', '第9号合同', '2021-03-09 00:00:00', '2022-01-31 00:00:00', '11', '11.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:10:34', '2021-03-11 22:09:53');
INSERT INTO `contractdetails` VALUES ('27', 'C_2103112222022_nmyJGY', 'C_2102211714018_ztMGSE', '第10号合同', '2021-03-11 00:00:00', '2021-04-09 00:00:00', '1', '1111.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:22:22', '2021-03-11 22:22:22');
INSERT INTO `contractdetails` VALUES ('28', 'C_2103112223037_AbKDrV', 'C_2103012150016_72z50D', '第11号合同', '2021-03-11 00:00:00', '2021-03-31 00:00:00', '0', '111.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:23:37', '2021-03-11 22:23:37');
INSERT INTO `contractdetails` VALUES ('29', 'C_2103112223052_dMDh3P', 'C_2103012230022_ytJvTh', '第12号合同', '2021-03-11 00:00:00', '2022-02-24 00:00:00', '11', '111.00', '00', null, null, '', 'USE_0001', 'admin', '2021-03-11 22:23:52', '2021-03-11 22:23:52');
INSERT INTO `contractdetails` VALUES ('30', 'C_2103142336023_JdHJeb', 'C_2103012232030_QqLuQz', '第13号合同', '2021-03-15 00:00:00', '2022-02-15 00:00:00', '11', '1111.00', '01', null, null, '', 'USE_0001', 'admin', '2021-03-14 23:36:23', '2021-03-14 23:36:23');

-- ----------------------------
-- Table structure for contractdetails_tmp
-- ----------------------------
DROP TABLE IF EXISTS `contractdetails_tmp`;
CREATE TABLE `contractdetails_tmp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `contract_code` varchar(32) DEFAULT NULL COMMENT '主合同编号',
  `contract_name` varchar(128) DEFAULT NULL COMMENT '合同名称\n',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '合同结束时间',
  `term` varchar(8) DEFAULT NULL COMMENT '期限',
  `total_money` decimal(11,2) DEFAULT NULL COMMENT '总金额',
  `status` varchar(2) DEFAULT NULL COMMENT '合同状态',
  `type` varchar(8) DEFAULT NULL COMMENT '合同类型',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注\n',
  `operate` varchar(8) DEFAULT NULL COMMENT '操作类型',
  `manager_code` varchar(32) DEFAULT NULL COMMENT '客户经理编号\n',
  `operator_code` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operator_name` varchar(64) DEFAULT NULL COMMENT '操作员名称',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COMMENT='contractdetails_tmp';

-- ----------------------------
-- Records of contractdetails_tmp
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `cust_name` varchar(56) DEFAULT NULL COMMENT '客户名称',
  `cust_type` varchar(8) DEFAULT NULL COMMENT '客户类型',
  `id_type` varchar(8) DEFAULT NULL COMMENT '证件类型',
  `id_num` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `status` varchar(8) DEFAULT NULL COMMENT '客户状态 01 有效',
  `law_name` varchar(56) DEFAULT NULL COMMENT '法人名称',
  `law_num` varchar(32) DEFAULT NULL COMMENT '法人证件号码',
  `law_mobile` varchar(32) DEFAULT NULL COMMENT '法人手机号码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `register_money` decimal(11,2) DEFAULT NULL COMMENT '注册资金\n',
  `profession` varchar(32) DEFAULT NULL COMMENT '行业',
  `address` varchar(56) DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `age` int(2) DEFAULT NULL COMMENT '年龄\n',
  `operator_code` varchar(32) DEFAULT NULL COMMENT '操作员编号\n',
  `operator_name` varchar(64) DEFAULT NULL COMMENT '操作员名称',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('45', 'C_2103201618041_mS00Ht', '12312', '01', '11', '123123', '01', '', '', '', null, '0.00', '', '', '', '', '0', '0', 'USE_0001', 'admin', '2021-03-20 08:18:42', '2021-03-20 08:18:42');
INSERT INTO `customer` VALUES ('46', 'C_2103201645048_JSmMhV', '1', '00', '01', '123', '01', null, null, null, null, null, null, '', '', '', '0', '0', 'USE_0001', 'admin', '2021-03-20 08:45:48', '2021-03-20 08:45:48');
INSERT INTO `customer` VALUES ('47', 'C_2103201645055_wrWVgS', '1', '01', '11', '12', '01', '', '', '', null, '0.00', '', '', '', '', '0', '0', 'USE_0001', 'admin', '2021-03-20 08:45:55', '2021-03-20 08:45:55');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) NOT NULL COMMENT '员工编号',
  `user_code` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `card_num` varchar(32) DEFAULT NULL COMMENT '员工工牌编号	',
  `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
  `cust_type` varchar(8) DEFAULT NULL COMMENT '客户类型',
  `id_type` varchar(8) DEFAULT NULL COMMENT '证件类型',
  `id_num` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号码\n',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'EM_0001', 'USE_0001', 'admin', '潘宏涛', '00', '01', '610321199603122772', null, '2021-02-27 16:02:05', '2021-02-27 16:02:08');

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
-- Table structure for sms_details
-- ----------------------------
DROP TABLE IF EXISTS `sms_details`;
CREATE TABLE `sms_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `cust_code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `sms_template_code` varchar(32) DEFAULT NULL COMMENT '短信模板编号',
  `tel_phone` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `template_param` varchar(512) DEFAULT NULL COMMENT '模板业务参数',
  `content` varchar(128) DEFAULT NULL COMMENT '短信内容',
  `sms_status` varchar(2) DEFAULT NULL COMMENT '短信响应状态',
  `ssm_id` varchar(32) DEFAULT NULL COMMENT '短信id',
  `Consumption` decimal(6,2) DEFAULT NULL COMMENT '扣费金额',
  `tmoney` decimal(8,2) DEFAULT NULL COMMENT '余额',
  `sms_send` varchar(8) DEFAULT NULL COMMENT '发送条数',
  `dsc` varchar(64) DEFAULT NULL COMMENT '描述',
  `update_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_name` varchar(64) DEFAULT NULL COMMENT '操作人名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='短信详情';

-- ----------------------------
-- Records of sms_details
-- ----------------------------

-- ----------------------------
-- Table structure for sms_template
-- ----------------------------
DROP TABLE IF EXISTS `sms_template`;
CREATE TABLE `sms_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) DEFAULT NULL,
  `content` varchar(80) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `calc_type` varchar(8) DEFAULT NULL COMMENT '0:直接映射\n1: sql\n2: groovy\n3: js\n1、2、3暂不考虑',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sms_template
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `type` varchar(32) DEFAULT NULL COMMENT '字典类型',
  `value` varchar(128) DEFAULT NULL COMMENT '值',
  `label` varchar(128) DEFAULT NULL COMMENT '描述',
  `parent_type` varchar(32) DEFAULT NULL COMMENT '父类型',
  `parent_value` varchar(128) DEFAULT NULL COMMENT '父字典值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', 'custTypeDict', '00', '个人', null, null, '2021-03-05 10:39:59');
INSERT INTO `sys_dict` VALUES ('2', 'custTypeDict', '01', '企业', '', null, null);
INSERT INTO `sys_dict` VALUES ('3', 'peopIdTypes', '01', '身份证', 'custTypeDict', '00', '2021-03-05 10:40:45');
INSERT INTO `sys_dict` VALUES ('4', 'peopIdTypes', '02', '护照', 'custTypeDict', '00', '2021-03-05 10:41:29');
INSERT INTO `sys_dict` VALUES ('5', 'compIdTypes', '11', '营业执照', 'custTypeDict', '01', '2021-03-05 10:42:46');
INSERT INTO `sys_dict` VALUES ('6', 'compIdTypes', '13', '社会信用代码', 'custTypeDict', '01', '2021-03-05 10:42:44');
INSERT INTO `sys_dict` VALUES ('7', 'compIdTypes', '12', '组织结构代码', 'custTypeDict', '01', '2021-03-05 10:42:45');
INSERT INTO `sys_dict` VALUES ('8', 'contractStatus', '00', '无效', '', null, '2021-03-05 10:46:38');
INSERT INTO `sys_dict` VALUES ('9', 'contractStatus', '01', '有效', null, null, '2021-03-05 10:46:40');
INSERT INTO `sys_dict` VALUES ('10', 'contractStatus', '02', '结束', null, null, '2021-03-05 10:46:41');
INSERT INTO `sys_dict` VALUES ('11', 'payType', '00', '线上支付', '', null, '2021-03-05 10:44:36');
INSERT INTO `sys_dict` VALUES ('12', 'payType', '01', '线下支付', '', null, '2021-03-05 10:44:37');
INSERT INTO `sys_dict` VALUES ('13', 'payMethod', 'zf', '支付宝', null, null, '2021-03-05 10:45:54');
INSERT INTO `sys_dict` VALUES ('14', 'payMethod', 'vx', '微信', null, null, '2021-03-05 10:45:55');
INSERT INTO `sys_dict` VALUES ('15', 'payMethod', 'bank', '银行卡', null, null, '2021-03-05 10:45:57');
INSERT INTO `sys_dict` VALUES ('16', 'payMethod', 'other', '其他', null, null, '2021-03-05 10:45:58');
INSERT INTO `sys_dict` VALUES ('17', 'sex', '0', '男', null, null, '2021-03-05 10:46:36');
INSERT INTO `sys_dict` VALUES ('18', 'sex', '1', '女', null, null, '2021-03-05 10:46:37');
INSERT INTO `sys_dict` VALUES ('19', 'accountType', '0', '打款', null, '', '2021-03-05 10:47:05');
INSERT INTO `sys_dict` VALUES ('20', 'accountType', '1', '扣款', null, null, '2021-03-05 10:47:06');
INSERT INTO `sys_dict` VALUES ('21', 'validStatus', '0', '无效', null, null, '2021-03-16 23:24:35');
INSERT INTO `sys_dict` VALUES ('22', 'validStatus', '1', '有效', null, null, '2021-03-16 23:24:32');
INSERT INTO `sys_dict` VALUES ('23', 'roleType', 'manager', '管理员', null, null, '2021-03-16 23:25:10');
INSERT INTO `sys_dict` VALUES ('24', 'roleType', 'emp', '普通员工', null, null, '2021-03-16 23:25:11');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `url` varchar(64) DEFAULT NULL COMMENT '路由',
  `parent_url` varchar(64) DEFAULT NULL COMMENT '父级路由',
  `sort_no` varchar(8) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '001', '首页', '/', '', '0', '2021-03-18 21:56:08');
INSERT INTO `sys_menu` VALUES ('2', '001_01', '消息提醒', '/claimMess', '/', '0', '2021-03-18 21:56:46');
INSERT INTO `sys_menu` VALUES ('3', '002', '客户管理', 'cust', '', '1', '2021-03-18 21:57:30');
INSERT INTO `sys_menu` VALUES ('4', '002_01', '客户查询管理', '/cust/custmanager', 'cust', '1', '2021-03-18 21:58:21');
INSERT INTO `sys_menu` VALUES ('5', '003', '合同管理', 'contract', '', '2', '2021-03-18 22:00:56');
INSERT INTO `sys_menu` VALUES ('6', '003_01', '合同查询管理', '/contract/contractManager', 'contract', '2', '2021-03-18 22:01:23');
INSERT INTO `sys_menu` VALUES ('7', '004', '员工管理', 'employee', '', '3', '2021-03-18 22:05:30');
INSERT INTO `sys_menu` VALUES ('8', '004_01', '员工查询管理', '/employee/employeeManager', 'employee', '3', '2021-03-18 22:06:06');

-- ----------------------------
-- Table structure for sys_param_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_param_config`;
CREATE TABLE `sys_param_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `level` varchar(8) DEFAULT NULL COMMENT '级别\n',
  `module` varchar(32) DEFAULT NULL COMMENT '模块',
  `name` varchar(128) DEFAULT NULL COMMENT '配置名称',
  `dsc` varchar(256) DEFAULT NULL COMMENT '描述',
  `value` varchar(128) DEFAULT NULL COMMENT '值',
  `def_value` varchar(128) DEFAULT NULL COMMENT '默认值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置';

-- ----------------------------
-- Records of sys_param_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_lnk_employee
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_lnk_employee`;
CREATE TABLE `sys_role_lnk_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_type` varchar(32) NOT NULL COMMENT '角色类型',
  `employee_code` varchar(32) DEFAULT NULL COMMENT '员工编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间\r\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='角色关联配置';

-- ----------------------------
-- Records of sys_role_lnk_employee
-- ----------------------------
INSERT INTO `sys_role_lnk_employee` VALUES ('1', 'emp', 'E_2103150008009_ohTMay', '2021-03-15 00:08:14');
INSERT INTO `sys_role_lnk_employee` VALUES ('2', 'manager', 'E_2103150008009_ohTMay', '2021-03-15 00:08:14');
INSERT INTO `sys_role_lnk_employee` VALUES ('3', 'emp', 'E_2103150027005_wvGcd2', '2021-03-15 00:27:06');
INSERT INTO `sys_role_lnk_employee` VALUES ('4', 'manager', 'E_2103150027005_wvGcd2', '2021-03-15 00:27:06');
INSERT INTO `sys_role_lnk_employee` VALUES ('5', 'emp', 'E_2103152133038_hEWUgv', '2021-03-15 21:33:38');
INSERT INTO `sys_role_lnk_employee` VALUES ('6', 'manager', 'E_2103152133038_hEWUgv', '2021-03-15 21:33:38');
INSERT INTO `sys_role_lnk_employee` VALUES ('7', 'emp', 'E_2103152353051_qsyR6B', '2021-03-15 23:53:51');
INSERT INTO `sys_role_lnk_employee` VALUES ('8', 'manager', 'E_2103152353051_qsyR6B', '2021-03-15 23:53:51');
INSERT INTO `sys_role_lnk_employee` VALUES ('9', 'emp', 'E_2103160002043_ufau4x', '2021-03-16 00:02:44');
INSERT INTO `sys_role_lnk_employee` VALUES ('10', 'manager', 'E_2103160002043_ufau4x', '2021-03-16 00:02:44');
INSERT INTO `sys_role_lnk_employee` VALUES ('11', 'emp', 'E_2103160003006_8toHnF', '2021-03-16 00:03:07');
INSERT INTO `sys_role_lnk_employee` VALUES ('12', 'manager', 'E_2103160003006_8toHnF', '2021-03-16 00:03:07');
INSERT INTO `sys_role_lnk_employee` VALUES ('13', 'emp', 'E_2103160004057_TmPo5N', '2021-03-16 00:04:57');
INSERT INTO `sys_role_lnk_employee` VALUES ('14', 'manager', 'E_2103160004057_TmPo5N', '2021-03-16 00:04:57');
INSERT INTO `sys_role_lnk_employee` VALUES ('15', 'emp', 'E_2103160009053_KOqq5S', '2021-03-16 00:09:53');
INSERT INTO `sys_role_lnk_employee` VALUES ('16', 'manager', 'E_2103160009053_KOqq5S', '2021-03-16 00:09:53');
INSERT INTO `sys_role_lnk_employee` VALUES ('17', 'emp', 'E_2103160013004_CkVyXG', '2021-03-16 00:13:04');
INSERT INTO `sys_role_lnk_employee` VALUES ('18', 'emp', 'E_2103160013013_RLwhr9', '2021-03-16 00:13:14');
INSERT INTO `sys_role_lnk_employee` VALUES ('19', 'emp', 'EM_0001', '2021-03-18 22:55:15');
INSERT INTO `sys_role_lnk_employee` VALUES ('20', 'manager', 'EM_0001', '2021-03-18 22:55:16');
INSERT INTO `sys_role_lnk_employee` VALUES ('21', 'emp', 'E_2103182354006_4Lu5Ud', '2021-03-18 23:54:07');

-- ----------------------------
-- Table structure for sys_role_lnk_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_lnk_menu`;
CREATE TABLE `sys_role_lnk_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_type` varchar(32) DEFAULT NULL COMMENT '角色类型',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COMMENT='角色关联菜单（可见性配置）';

-- ----------------------------
-- Records of sys_role_lnk_menu
-- ----------------------------
INSERT INTO `sys_role_lnk_menu` VALUES ('1', 'manager', '001', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('2', 'manager', '001_01', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('3', 'manager', '002', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('4', 'manager', '002_01', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('5', 'manager', '003', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('6', 'manager', '003_01', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('7', 'manager', '004', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('8', 'manager', '004_01', '2021-03-18 14:08:53');
INSERT INTO `sys_role_lnk_menu` VALUES ('16', 'emp', '001', '2021-03-18 14:08:58');
INSERT INTO `sys_role_lnk_menu` VALUES ('17', 'emp', '001_01', '2021-03-18 14:08:58');
INSERT INTO `sys_role_lnk_menu` VALUES ('18', 'emp', '002', '2021-03-18 14:08:58');
INSERT INTO `sys_role_lnk_menu` VALUES ('19', 'emp', '002_01', '2021-03-18 14:08:58');
INSERT INTO `sys_role_lnk_menu` VALUES ('20', 'emp', '003', '2021-03-18 14:08:58');
INSERT INTO `sys_role_lnk_menu` VALUES ('21', 'emp', '003_01', '2021-03-18 14:08:58');

-- ----------------------------
-- Table structure for sys_role_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_type`;
CREATE TABLE `sys_role_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `type` varchar(32) DEFAULT NULL COMMENT '角色类型',
  `name` varchar(64) DEFAULT NULL COMMENT '角色类型名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色类型';

-- ----------------------------
-- Records of sys_role_type
-- ----------------------------
INSERT INTO `sys_role_type` VALUES ('1', 'emp', '员工', '2021-03-15 21:52:13');
INSERT INTO `sys_role_type` VALUES ('2', 'manager', '管理员', '2021-03-15 21:52:28');

-- ----------------------------
-- Table structure for sys_server_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_server_config`;
CREATE TABLE `sys_server_config` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `group_id` varchar(32) NOT NULL COMMENT '源组id',
  `comp_code` varchar(32) NOT NULL COMMENT '公司编号',
  `comp_name` varchar(32) NOT NULL COMMENT '公司名称',
  `jdbc_url` varchar(64) NOT NULL COMMENT '数据库连接',
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `status` varchar(2) DEFAULT NULL COMMENT '是否有效\nN：无效\nY：有效',
  `id_default` varchar(2) DEFAULT NULL COMMENT '是否默认数据源\nY：是\nN：否',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='组网信息';

-- ----------------------------
-- Records of sys_server_config
-- ----------------------------
INSERT INTO `sys_server_config` VALUES ('1', 'finance-0', 'ysjf', '银杉金服', 'jdbc:mysql://182.92.204.169/market1', 'root', '867315', 'Y', 'N', '2021-03-05 16:32:04');
INSERT INTO `sys_server_config` VALUES ('2', 'finance-0', 'zf', '新正丰财务营销合同管理系统', 'jdbc:mysql://182.92.204.169/market2', 'root', '867315', 'Y', 'N', '2021-03-05 16:32:04');
INSERT INTO `sys_server_config` VALUES ('3', 'finance-0', 'qmkj', '营销合同管理系统', 'jdbc:mysql://182.92.204.169/market', 'root', '867315', 'Y', 'Y', '2021-03-05 16:32:04');

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
  `status` varchar(2) DEFAULT NULL COMMENT '是否有效\n1：是\n0：否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'USE_0001', 'admin', '$2a$10$H5ZfoyP9Edhfwzlp29hJqusMmy85ZZ9gtMIZ6lozMVJlz6/5cWKUW', '0', '2021-01-24 13:38:31', '1');
