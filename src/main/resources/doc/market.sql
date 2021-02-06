create schema if not exists market collate utf8_general_ci;

create table if not exists customer
(
	id bigint auto_increment comment '自增id'
		primary key,
	user_code varchar(32) null comment '用户编号',
	code varchar(32) null comment '编号',
	cust_name varchar(56) null comment '客户名称',
	cust_type varchar(8) null comment '客户类型',
	id_type varchar(8) null comment '证件类型',
	id_num varchar(32) null comment '证件号码',
	law_name varchar(56) null comment '法人名称',
	law_num varchar(32) null comment '法人证件号码',
	register_time date null comment '注册时间',
	profession varchar(32) null comment '行业',
	address varchar(56) null comment '地址',
	law_mobile varchar(32) null comment '法人手机号码',
	phone varchar(32) null comment '电话号码',
	update_time datetime null comment '更新时间',
	create_time datetime null comment '创建时间',
	constraint code
		unique (code)
)
comment '客户表';

create table if not exists employee
(
	id bigint auto_increment comment '自增id'
		primary key,
	user_code varchar(32) null comment '用户编号',
	code varchar(32) not null comment '员工编号',
	cust_name varchar(64) null comment '客户名称',
	cust_type varchar(8) null comment '客户类型',
	id_type varchar(8) null comment '证件类型',
	id_num varchar(32) null comment '证件号码',
	update_time datetime default CURRENT_TIMESTAMP null comment '更新时间',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	constraint code
		unique (code)
)
comment '员工';

create table if not exists market
(
	id bigint auto_increment comment '自增id'
		primary key,
	cust_code varchar(32) null comment '客户编号',
	detail_code varchar(32) null comment '营销明细记录编号',
	code varchar(32) null comment '编号',
	start_time date null comment '服务开始时间',
	end_time date null comment '结束时间',
	money decimal(6,2) null comment '缴费金额',
	term varchar(8) null comment '期限',
	pay_type varchar(2) null comment '当前打款方式',
	accout_num varchar(64) null comment '当前打款账号',
	pay_method varchar(8) null comment '缴费方式',
	update_time datetime null comment '更新时间',
	create_time datetime null comment '创建时间',
	constraint code
		unique (code)
)
comment '客户营销';

create table if not exists market_details
(
	id bigint auto_increment comment '自增id'
		primary key,
	cust_code varchar(32) null comment '客户编号',
	code varchar(32) null comment '编号',
	market_code varchar(32) null comment '客户营销编号',
	start_time date null comment '服务开始时间',
	end_time date null comment '结束时间',
	money decimal(6,2) null comment '缴费金额',
	term varchar(8) null comment '期限',
	pay_type varchar(2) null comment '当前打款方式',
	accout_num varchar(64) null comment '当前打款账号',
	pay_method varchar(8) null comment '支付方式',
	operator_code varchar(32) null comment '操作人',
	update_time datetime null comment '更新时间',
	create_time datetime null comment '创建时间'
)
comment '营销明细表';

create table if not exists sever_operator_log
(
	id bigint auto_increment comment '自增id'
		primary key,
	entity_name varchar(32) null comment '业务名称',
	entity_code varchar(32) null comment '业务编号',
	entity blob null comment '业务实体',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间'
)
comment 'sever_operator_log';

create table if not exists user
(
	id bigint auto_increment comment '自增id',
	code varchar(32) not null comment '编号',
	user_name varchar(56) null comment '账号',
	pass_word varchar(128) null comment '密码',
	user_type varchar(2) null comment '客户类型',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	constraint code
		unique (code),
	constraint id
		unique (id)
)
comment '用户表';

alter table user
	add primary key (id);

