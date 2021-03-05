package com.pht.common.factory.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "jdbc", ignoreInvalidFields = true)
@PropertySource("classpath:config/jdbc.properties")  //定义了要读取的properties文件的位置
public class DefDataSourceConfig {


    private String jdbcUrl;//连接url
    private String userName;//用户名
    private String passWord;//连接密码
    private String dataGroup;//数据源组

    private Integer initialSize;//初始化连接池大小
    private Integer minIdle;//最小
    private Integer maxActive;//存活时间
    private Integer maxWait;//超时等待时间单位毫秒 5000
    private String driverClassName;//驱动名称
}
