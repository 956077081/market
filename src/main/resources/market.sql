SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS market_details;
DROP TABLE IF EXISTS market;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS sever_operator_log;
DROP TABLE IF EXISTS user;




/* Create Tables */

-- 客户表
CREATE TABLE customer
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
	user_code varchar(32) COMMENT '用户编号',
	code varchar(32) COMMENT '编号',
	cust_name varchar(56) COMMENT '客户名称',
	cust_type varchar(8) COMMENT '客户类型',
	id_type varchar(8) COMMENT '证件类型',
	id_num varchar(32) COMMENT '证件号码',
	law_name varchar(56) COMMENT '法人名称',
	law_num varchar(32) COMMENT '法人证件号码',
	register_time date COMMENT '注册时间',
	profession varchar(32) COMMENT '行业',
	address varchar(56) COMMENT '地址',
	law_mobile varchar(32) COMMENT '法人手机号码',
	phone varchar(32) COMMENT '电话号码',
	update_time date COMMENT '更新时间',
	create_time date COMMENT '创建时间',
	PRIMARY KEY (id),
	UNIQUE (code)
) COMMENT = '客户表';


-- 员工
CREATE TABLE employee
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
	user_code varchar(32) COMMENT '用户编号',
	code varchar(32) NOT NULL COMMENT '员工编号',
	cust_name varchar(64) COMMENT '客户名称',
	-- 01: 自然人
	-- 02: 公司机构
	-- 
	cust_type varchar(8) COMMENT '客户类型',
	-- 01：身份证
	-- 02：营业执照
	-- 03：组织结构代码
	id_type varchar(8) COMMENT '证件类型',
	id_num varchar(32) COMMENT '证件号码',
	update_time date DEFAULT NOW(), SYSDATE() COMMENT '更新时间',
	create_time date DEFAULT NOW(), SYSDATE() COMMENT '创建时间',
	PRIMARY KEY (id),
	UNIQUE (code)
) COMMENT = '员工';


-- 客户营销
CREATE TABLE market
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
	cust_code varchar(32) COMMENT '客户编号',
	detail_code varchar(32) COMMENT '营销明细记录编号',
	code varchar(32) COMMENT '编号',
	start_time date COMMENT '服务开始时间',
	end_time date COMMENT '结束时间',
	money decimal(6,2) COMMENT '缴费金额',
	term varchar(8) COMMENT '期限',
	-- 0:线下
	-- 1:线上
	pay_type varchar(2) COMMENT '当前打款方式',
	accout_num varchar(64) COMMENT '当前打款账号',
	-- 00:支付宝
	-- 01:微信
	-- 02:银行卡
	-- 03:其他
	pay_method varchar(8) COMMENT '缴费方式',
	update_time date COMMENT '更新时间',
	create_time date COMMENT '创建时间',
	PRIMARY KEY (id),
	UNIQUE (code)
) COMMENT = '客户营销';


-- 营销明细表
CREATE TABLE market_details
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
	cust_code varchar(32) COMMENT '客户编号',
	code varchar(32) COMMENT '编号',
	market_code varchar(32) COMMENT '客户营销编号',
	start_time date COMMENT '服务开始时间',
	end_time date COMMENT '结束时间',
	money decimal(6,2) COMMENT '缴费金额',
	term varchar(8) COMMENT '期限',
	-- 0:线下
	-- 1:线上
	pay_type varchar(2) COMMENT '当前打款方式',
	accout_num varchar(64) COMMENT '当前打款账号',
	-- 00:支付宝
	-- 01:微信
	-- 02:银行卡
	-- 03:其他
	pay_method varchar(8) COMMENT '支付方式',
	operator_code varchar(32) COMMENT '操作人',
	update_time date COMMENT '更新时间',
	create_time date COMMENT '创建时间',
	PRIMARY KEY (id)
) COMMENT = '营销明细表';


-- sever_operator_log
CREATE TABLE sever_operator_log
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
	entity_name varchar(32) COMMENT '业务名称',
	entity_code varchar(32) COMMENT '业务编号',
	entity blob COMMENT '业务实体',
	create_time date DEFAULT NOW(), SYSDATE() NOT NULL COMMENT '创建时间',
	PRIMARY KEY (id)
) COMMENT = 'sever_operator_log';


-- 用户表
CREATE TABLE user
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
	code varchar(32) NOT NULL COMMENT '编号',
	user_name varchar(56) COMMENT '账号',
	pass_word varchar(56) COMMENT '密码',
	-- 0：员工
	-- 1:   客户
	-- 
	user_type varchar(2) COMMENT '客户类型',
	create_time date DEFAULT NOW(), SYSDATE() COMMENT '创建时间',
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (code)
) COMMENT = '用户表';



