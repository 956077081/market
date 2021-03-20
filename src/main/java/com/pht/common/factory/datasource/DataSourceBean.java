package com.pht.common.factory.datasource;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;
import java.util.Arrays;

public class DataSourceBean {
    /**
     * 数据源默认配置
     * @param dataSource
     */
    public static void setDuridCommConfig(DruidDataSource dataSource, DefDataSourceConfig defDataSourceConfig){
        dataSource.setDriverClassName(defDataSourceConfig.getDriverClassName());
        dataSource.setUrl(defDataSourceConfig.getJdbcUrl()+"?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername(defDataSourceConfig.getUserName());
        dataSource.setPassword(defDataSourceConfig.getPassWord());

        dataSource.setInitialSize(defDataSourceConfig.getInitialSize());
        dataSource.setMinIdle(defDataSourceConfig.getMinIdle());
        dataSource.setMaxActive(defDataSourceConfig.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Slf4jLogFilter log4jFilter = new Slf4jLogFilter();
        log4jFilter.setConnectionLogEnabled(false);
        log4jFilter.setStatementLogEnabled(false);
        log4jFilter.setResultSetLogEnabled(true);
        log4jFilter.setStatementExecutableSqlLogEnable(true);
        dataSource.setProxyFilters(Arrays.asList(log4jFilter));
    }
}
