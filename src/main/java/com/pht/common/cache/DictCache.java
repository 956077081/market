package com.pht.common.cache;

import com.pht.base.system.entity.SysDict;
import com.pht.base.system.service.SysDictService;
import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.common.factory.datasource.JdbcServerConfig;
import com.pht.common.frame.QMENV;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DictCache  {
    //               compCode    typeid      dicts
    private static Map<String, Map<String, List<SysDict>>> paramMap = new ConcurrentHashMap<>();
    @Autowired
    private SysDictService sysDictService;

    public void init(){
        initDictParam();
    }

    /**
     * 初始化系统配置
     */
    public void initDictParam(){
        Map<String, JdbcServerConfig> compServerConfigs = DataSourceFactory.getCompServerConfig();
        compServerConfigs.forEach( (code,serveConfig)->{
            QMENV.setCompCode(code);
            List<SysDict> dicts = sysDictService.queryAllDict();
            Map<String,  List<SysDict>> sysDictMap = getSysDictMap(dicts);
            paramMap.put(code,sysDictMap);
        });
        QMENV.setCompCode(DataSourceFactory.getDefaultServerConfig().getCompCode().toUpperCase());
    }
    private Map<String,List<SysDict>>  getSysDictMap( List<SysDict> params){
        Map<String,List<SysDict>> map =  new HashMap<>();
        if(params == null || params.isEmpty()){
            return map;
        }
         params.forEach(sysParamConfig -> {
             if(map.get(sysParamConfig.getType())== null){
                 List<SysDict> list = new ArrayList<>();
                 list.add(sysParamConfig);
                 map.put(sysParamConfig.getType(),list);
             }else{
                 map.get(sysParamConfig.getType()).add(sysParamConfig);
             }
        });
        return map;
    }

    /**
     * 获取字典项
     * @param type
     * @return
     */
    public static String getDictLabel(String type, String value){
        SysDict dict = getDict(type, value);
        if(dict == null){
            return "";
        }
        return dict.getLabel();
    }
    /**
     * 获取字典项
     * @param type
     * @return
     */
    private static SysDict getDict(String type, String value){
        Map<String, List<SysDict>> listMap = paramMap.get(QMENV.getCompCode());
        List<SysDict> dicts = listMap.get(type);
        if(dicts != null){
            for (SysDict sysDict : dicts) {
                if(sysDict.getValue().equals(value)){
                  return    sysDict;
                }
            }
        }
        return null;
    }
    /**
     * 获取字典项
     * @param type
     * @return
     */
    public static SysDict getDict(String type,String value,boolean sub){
        if(!sub){
            return getDict(type,value);
        }
        SysDict dict = getDict(type, value);
        dict.setSubDicts(getSubDict(type,value));
        return dict;
    }
    private static List<SysDict> getSubDict(String type,String value){
        Map<String, List<SysDict>> listMap = paramMap.get(QMENV.getCompCode());
        List<SysDict> list=   new ArrayList<>();
        if(listMap != null){
            listMap.values().forEach(sysList -> {
                sysList.forEach(sysDict -> {
                    if(type.equals(sysDict.getParentType())&& value.equals(sysDict.getParentValue())){
                        list.add(sysDict);
                    }
                });
            });
        }
        return list;
    }

    public static Map<String,List<SysDict>> getAllDict(){
        return paramMap.get(QMENV.getCompCode());
    }

}
