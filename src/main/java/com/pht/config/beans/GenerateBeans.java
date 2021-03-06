package com.pht.config.beans;

import com.pht.common.cache.DictCache;
import com.pht.common.cache.SysParamCache;
import com.pht.common.factory.datasource.DataSourceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class GenerateBeans {
    @Order(-1)
    @Bean(initMethod = "init")
    public DataSourceFactory dataSourceFactory() {
        return new DataSourceFactory();
    }

    @Bean(initMethod = "init")
    @ConditionalOnBean(name = "dataSourceFactory")
    public DictCache dictCache() {
        return new DictCache();
    }

    @Bean(initMethod = "init")
    @ConditionalOnBean(name = "dataSourceFactory")
    public SysParamCache sysParamCache() {
        return  new SysParamCache();
    }

}
