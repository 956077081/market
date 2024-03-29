package com.pht.config.beans;

import com.pht.common.frame.QmThreadPoolExecutor;
import com.pht.common.cache.DictCache;
import com.pht.common.cache.SysParamCache;
import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.common.factory.datasource.DefDataSourceConfig;
import com.pht.common.factory.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;

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
    DataSource dataSource(DefDataSourceConfig defDataSourceConfig) {
        DataSource dataSource = new DynamicDataSource();
        return dataSource;
    }
    @Bean
    @DependsOn(value = {"dataSourceFactory"})
    public SqlSessionFactory sqlSessionFactory(MybatisProperties mybatisProperties,DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = mybatisProperties.getConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/pht/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(initMethod = "init")
    @ConditionalOnBean(name = "dataSourceFactory")
    public DictCache dictCache() {
        return new DictCache();
    }

    @Bean(initMethod = "init")
    @ConditionalOnBean(name = "dataSourceFactory")
    public SysParamCache sysParamCache() {
        return new SysParamCache();
    }


    @Bean
    public QmThreadPoolExecutor executor() {
        /**
         * int corePoolSize,  核心一直存活的线程数量
         *                               int maximumPoolSize,//最大线程数量
         *                               long keepAliveTime,// 没有任务调度是最大存活时间
         *                               TimeUnit unit,//时间类型
         *                               BlockingQueue<Runnable> workQueue,//达到最大线程的进入的队列
         *                               ThreadFactory threadFactory,//线程工厂
         *                               RejectedExecutionHandler handler//拒绝策略  队列满足最大队列是 请求的拒绝策略
         */
        QmThreadPoolExecutor threadPoolExecutor = new QmThreadPoolExecutor();
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
        ThreadPoolExecutor.AbortPolicy policy = new ThreadPoolExecutor.AbortPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(policy);
        return threadPoolExecutor;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate( SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 事务管理
     *
     * @return 事务管理实例
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//     * job任务调度 暂定
//     * @return
//     */
//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//        threadPoolTaskScheduler.setPoolSize(5);//线程数量
//        return threadPoolTaskScheduler;
//    }
}
