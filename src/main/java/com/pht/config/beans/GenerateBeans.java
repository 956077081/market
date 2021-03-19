package com.pht.config.beans;

import com.pht.base.frame.QmThreadPoolExecutor;
import com.pht.common.cache.DictCache;
import com.pht.common.cache.SysParamCache;
import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.common.factory.datasource.DefDataSourceConfig;
import com.pht.common.factory.datasource.DynamicDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
@Configuration
public class GenerateBeans {
    @Bean(initMethod = "init")
    public DataSourceFactory dataSourceFactory() {
        return new DataSourceFactory();
    }

    @Bean
    @DependsOn(value = {"dataSourceFactory"})
    DataSource dataSource(DefDataSourceConfig defDataSourceConfig){
//        DruidDataSource dataSource = new DruidDataSource();
//        DataSourceBean.setDuridCommConfig(dataSource,defDataSourceConfig);
//        return dataSource;
          DataSource dataSource =new DynamicDataSource();
          return dataSource;
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

    @Bean
    public Executor qmThreadPoolExecutor(){
        /**
         * int corePoolSize,  核心一直存活的线程数量
         *                               int maximumPoolSize,//最大线程数量
         *                               long keepAliveTime,// 没有任务调度是最大存活时间
         *                               TimeUnit unit,//时间类型
         *                               BlockingQueue<Runnable> workQueue,//达到最大线程的进入的队列
         *                               ThreadFactory threadFactory,//线程工厂
         *                               RejectedExecutionHandler handler//拒绝策略  队列满足最大队列是 请求的拒绝策略
         */
        ThreadPoolTaskExecutor threadPoolExecutor = new QmThreadPoolExecutor();
        threadPoolExecutor.setCorePoolSize(3);
        threadPoolExecutor.setMaxPoolSize(5);
        threadPoolExecutor.setKeepAliveSeconds(5);//5秒
        threadPoolExecutor.setQueueCapacity(200);
        /**
         * abortPolicy  队列满时最接抛出异常
         * DiscardOLderstPolicy  丢弃前面的任务，重置后面的任务有效执行
         * DiscardPolicy 丢弃任务 不排除异常
         * CallerRunsPolicy  调用任务调用的线程处理该任务
         *
         */
        ThreadPoolExecutor.AbortPolicy policy =  new  ThreadPoolExecutor.AbortPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(policy);
        return threadPoolExecutor;
    }

}
