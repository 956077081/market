package com.pht.common.factory.datasource;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.pht.common.CommonDict;
import com.pht.base.frame.QMENV;
import com.pht.config.utils.QmDataConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DataSourceFactory  {
    private static Logger log = LoggerFactory.getLogger(DataSourceFactory.class);
    @Autowired
    private DefDataSourceConfig defDataSourceConfig;
    private static DataSource defaultDataSource=null;
    private static JdbcServerConfig defaultServerConfig =null;
    private static Map<Object,Object> dataSourceMap= new ConcurrentHashMap<>();
    private static Map<String,JdbcServerConfig> compServers =new HashMap<>();
    private static List<String> compCodes= new ArrayList();
    public void init() {//加载数据源
        List<JdbcServerConfig> collect = getGroupJdbc();
        StringBuffer sb = new StringBuffer();

          collect.forEach(jdbcBean -> {
              if(!CommonDict.YES.equals(jdbcBean.getStatus())){
                  return;
              }
            if (CommonDict.YES.equals(jdbcBean.getIsDefault())) {
                defaultServerConfig=jdbcBean;
                QMENV.setCompCode(jdbcBean.getCompCode());//初始化为默人comp
                System.out.println(QMENV.getCompCode());
                defaultDataSource = crtDuridDataSource(jdbcBean);
            }
            compServers.put(jdbcBean.getCompCode().toUpperCase(),jdbcBean);
            dataSourceMap.put(jdbcBean.getCompCode().toUpperCase(),crtDuridDataSource(jdbcBean));
            compCodes.add(jdbcBean.getCompCode().toUpperCase());
          });
        if(collect== null ||collect.isEmpty()){
            log.error("当前获取数据为空，启动失败");
            throw  new RuntimeException();
        }
        if(defaultDataSource ==null){
            log.error("获取默认数据严失败");
            throw  new RuntimeException();
        }
        log.info("当前启动加载数据源个数："+collect.size()+"|数据源="+ QmDataConvertUtils.obj2JsonStr(collect));
    }

    public List<JdbcServerConfig> getGroupJdbc(){
        log.info("数据中心连接|"+defDataSourceConfig.toString());
        List<JdbcServerConfig> list =new ArrayList<>();
        try{
            Class.forName(this.defDataSourceConfig.getDriverClassName());
            Connection conn= DriverManager.getConnection(this.defDataSourceConfig.getJdbcUrl(), this.defDataSourceConfig.getUserName(), this.defDataSourceConfig.getPassWord());
            if(conn ==null){
                throw  new RuntimeException("获取数据中心失败!"+QmDataConvertUtils.obj2JsonStr(this.defDataSourceConfig));
            }
            PreparedStatement preparedStatement = conn.prepareStatement(getExecCenterSql());
            preparedStatement.setString(1, this.defDataSourceConfig.getDataGroup());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JdbcServerConfig jdbcBean =new JdbcServerConfig();
                jdbcBean.setGroupID(resultSet.getString("group_id"));
                jdbcBean.setCompCode(resultSet.getString("comp_code"));
                jdbcBean.setCompName(resultSet.getString("comp_name"));
                jdbcBean.setJdbcUrl(resultSet.getString("jdbc_url"));
                jdbcBean.setUserName(resultSet.getString("username"));
                jdbcBean.setPassWord(resultSet.getString("password"));
                jdbcBean.setIsDefault(resultSet.getString("id_default"));
                jdbcBean.setStatus(resultSet.getString("status"));
                list.add(jdbcBean);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询组网信息异常");
        }
        return list;
    }
    public DataSource crtDuridDataSource(JdbcServerConfig jdbcBean){
        DruidDataSource dataSource =new DruidDataSource();
        setDuridCommConfig(dataSource);
        dataSource.setUrl(jdbcBean.getUserName());
        dataSource.setPassword(jdbcBean.getPassWord());
        return dataSource;
    }

    private String getExecCenterSql(){
            String sql ="select   group_id, comp_code, comp_name, jdbc_url, username, password, status, id_default " +
                     " from sys_server_config  where  group_id = ?";
            return sql;
    }

    /**
     * 数据源默认配置
     * @param dataSource
     */
    private void setDuridCommConfig(DruidDataSource dataSource){
        dataSource.setDriverClassName(defDataSourceConfig.getDriverClassName());
        dataSource.setInitialSize(defDataSourceConfig.getInitialSize());
        dataSource.setMinIdle(defDataSourceConfig.getMinIdle());
        dataSource.setMaxActive(defDataSourceConfig.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        try {
            dataSource.setFilters("stat,slf4jLog");
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
    public static Map<Object, Object> queryAllDataSource(){
        return dataSourceMap;
    }
    public static DataSource getDefaultDataSource(){
        return defaultDataSource;
    }
    public static Map<String,JdbcServerConfig> getCompServerConfig(){
        return compServers;
    }
    public static JdbcServerConfig getDefaultServerConfig(){
        return defaultServerConfig;
    }

    public static List<String> getCodes(){
        return compCodes;
    }
}