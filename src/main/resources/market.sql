SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS market_details;
DROP TABLE IF EXISTS market;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS sever_operator_log;
DROP TABLE IF EXISTS user;




/* Create Tables */

-- �ͻ���
CREATE TABLE customer
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '����id',
	user_code varchar(32) COMMENT '�û����',
	code varchar(32) COMMENT '���',
	cust_name varchar(56) COMMENT '�ͻ�����',
	cust_type varchar(8) COMMENT '�ͻ�����',
	id_type varchar(8) COMMENT '֤������',
	id_num varchar(32) COMMENT '֤������',
	law_name varchar(56) COMMENT '��������',
	law_num varchar(32) COMMENT '����֤������',
	register_time date COMMENT 'ע��ʱ��',
	profession varchar(32) COMMENT '��ҵ',
	address varchar(56) COMMENT '��ַ',
	law_mobile varchar(32) COMMENT '�����ֻ�����',
	phone varchar(32) COMMENT '�绰����',
	update_time date COMMENT '����ʱ��',
	create_time date COMMENT '����ʱ��',
	PRIMARY KEY (id),
	UNIQUE (code)
) COMMENT = '�ͻ���';


-- Ա��
CREATE TABLE employee
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '����id',
	user_code varchar(32) COMMENT '�û����',
	code varchar(32) NOT NULL COMMENT 'Ա�����',
	cust_name varchar(64) COMMENT '�ͻ�����',
	-- 01: ��Ȼ��
	-- 02: ��˾����
	-- 
	cust_type varchar(8) COMMENT '�ͻ�����',
	-- 01�����֤
	-- 02��Ӫҵִ��
	-- 03����֯�ṹ����
	id_type varchar(8) COMMENT '֤������',
	id_num varchar(32) COMMENT '֤������',
	update_time date DEFAULT NOW(), SYSDATE() COMMENT '����ʱ��',
	create_time date DEFAULT NOW(), SYSDATE() COMMENT '����ʱ��',
	PRIMARY KEY (id),
	UNIQUE (code)
) COMMENT = 'Ա��';


-- �ͻ�Ӫ��
CREATE TABLE market
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '����id',
	cust_code varchar(32) COMMENT '�ͻ����',
	detail_code varchar(32) COMMENT 'Ӫ����ϸ��¼���',
	code varchar(32) COMMENT '���',
	start_time date COMMENT '����ʼʱ��',
	end_time date COMMENT '����ʱ��',
	money decimal(6,2) COMMENT '�ɷѽ��',
	term varchar(8) COMMENT '����',
	-- 0:����
	-- 1:����
	pay_type varchar(2) COMMENT '��ǰ��ʽ',
	accout_num varchar(64) COMMENT '��ǰ����˺�',
	-- 00:֧����
	-- 01:΢��
	-- 02:���п�
	-- 03:����
	pay_method varchar(8) COMMENT '�ɷѷ�ʽ',
	update_time date COMMENT '����ʱ��',
	create_time date COMMENT '����ʱ��',
	PRIMARY KEY (id),
	UNIQUE (code)
) COMMENT = '�ͻ�Ӫ��';


-- Ӫ����ϸ��
CREATE TABLE market_details
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '����id',
	cust_code varchar(32) COMMENT '�ͻ����',
	code varchar(32) COMMENT '���',
	market_code varchar(32) COMMENT '�ͻ�Ӫ�����',
	start_time date COMMENT '����ʼʱ��',
	end_time date COMMENT '����ʱ��',
	money decimal(6,2) COMMENT '�ɷѽ��',
	term varchar(8) COMMENT '����',
	-- 0:����
	-- 1:����
	pay_type varchar(2) COMMENT '��ǰ��ʽ',
	accout_num varchar(64) COMMENT '��ǰ����˺�',
	-- 00:֧����
	-- 01:΢��
	-- 02:���п�
	-- 03:����
	pay_method varchar(8) COMMENT '֧����ʽ',
	operator_code varchar(32) COMMENT '������',
	update_time date COMMENT '����ʱ��',
	create_time date COMMENT '����ʱ��',
	PRIMARY KEY (id)
) COMMENT = 'Ӫ����ϸ��';


-- sever_operator_log
CREATE TABLE sever_operator_log
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '����id',
	entity_name varchar(32) COMMENT 'ҵ������',
	entity_code varchar(32) COMMENT 'ҵ����',
	entity blob COMMENT 'ҵ��ʵ��',
	create_time date DEFAULT NOW(), SYSDATE() NOT NULL COMMENT '����ʱ��',
	PRIMARY KEY (id)
) COMMENT = 'sever_operator_log';


-- �û���
CREATE TABLE user
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT '����id',
	code varchar(32) NOT NULL COMMENT '���',
	user_name varchar(56) COMMENT '�˺�',
	pass_word varchar(56) COMMENT '����',
	-- 0��Ա��
	-- 1:   �ͻ�
	-- 
	user_type varchar(2) COMMENT '�ͻ�����',
	create_time date DEFAULT NOW(), SYSDATE() COMMENT '����ʱ��',
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (code)
) COMMENT = '�û���';



