package com.pht.common.factory.datasource;

import lombok.Data;

@Data
public class JdbcServerConfig {
    private String compName;//公司名称
    private String groupID;//网组
    private String compCode;//公司编号
    private String jdbcUrl;//连接路径
    private String userName;//用户名
    private String passWord;//连接密码
    private String isDefault;//是否默认数据源
    private String status;//是否有效
}
