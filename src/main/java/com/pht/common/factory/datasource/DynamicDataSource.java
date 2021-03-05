package com.pht.common.factory.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.pht.config.frame.QMENV;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class DynamicDataSource  extends AbstractRoutingDataSource implements InitializingBean, DisposableBean {

    //容器销毁
    @Override
    public void destroy() throws Exception {
        close();
    }
    //初始化
    @Override
    public void afterPropertiesSet() {
        this.setTargetDataSources(DataSourceFactory.queryAllDataSource());
        this.setDefaultTargetDataSource(DataSourceFactory.getDefaultDataSource());
        super.afterPropertiesSet();
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return QMENV.getCompCode();
    }

    public void close(){
        DataSourceFactory.queryAllDataSource().forEach((key,value)->{
            DruidDataSource  dataSource =(DruidDataSource)value;
            dataSource.close();
        });
    }
}
