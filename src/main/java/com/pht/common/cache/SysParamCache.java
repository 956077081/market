package com.pht.common.cache;


import com.pht.base.system.entity.SysParamConfig;
import com.pht.base.system.service.SysParamConfigService;
import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.common.factory.datasource.JdbcServerConfig;
import com.pht.base.frame.QMENV;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class SysParamCache  {
     //                 compCode    typeid      value
    private static Map<String, Map<String,SysParamConfig>> paramMap = new ConcurrentHashMap<>();
    @Autowired
    private SysParamConfigService sysParamConfigService;
    public void init() {
        initSysParam();
    }

    /**
     * 初始化系统配置
     */
    public void initSysParam(){
        Map<String, JdbcServerConfig> compServerConfigs = DataSourceFactory.getCompServerConfig();
        compServerConfigs.forEach( (code,serveConfig)->{
            QMENV.setCompCode(code);
            List<SysParamConfig> sysParamConfigs = sysParamConfigService.queryAll();
            Map<String, SysParamConfig> sysParamMap = getSysParamMap(sysParamConfigs);
            paramMap.put(code,sysParamMap);
        });
        QMENV.setCompCode(DataSourceFactory.getDefaultServerConfig().getCompCode().toUpperCase());
    }
    private Map<String,SysParamConfig>  getSysParamMap( List<SysParamConfig> params){
        Map<String,SysParamConfig> map =  new HashMap<>();
        if(params == null || params.isEmpty()){
            return map;
        }
        params.forEach(sysParamConfig -> {
                map.put(sysParamConfig.getName(),sysParamConfig);
        });
        return map;
    }

    /**
     * 获取系统配置
     * @param type
     * @return
     */
    public static String getSysParamValue(String type){
        Map<String, SysParamConfig> paramConfigMap = paramMap.get(QMENV.getCompCode());
        if(paramConfigMap != null && !paramConfigMap.isEmpty()){
            SysParamConfig sysParamConfig = paramConfigMap.get(type);
            if(sysParamConfig == null){
                    return  null;
            }
            return StringUtils.isNotBlank(sysParamConfig.getValue())?sysParamConfig.getValue():sysParamConfig.getDefValue();
        }
        return null;
    }

    /**
     * 当系统配置为空时 或者空字符时 返回入参默认参数
     * @param type
     * @param defaultValue
     * @return
     */
    public static String getSysParamValue(String type,String defaultValue){
        String sysParamValue = getSysParamValue(type);
        if(StringUtils.isNotBlank(sysParamValue)){
            return sysParamValue;
        }
        return defaultValue;
    }
}
