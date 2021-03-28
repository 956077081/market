package com.pht.common.utils;

import com.pht.base.system.entity.SysDict;
import com.pht.common.cache.DictCache;

import java.util.List;
import java.util.Map;

public class DictFactory {
    public static String getDictLable(String type, String value){
       return   DictCache.getDictLabel(type,value);
    }
    public static SysDict getDict(String type,String value,boolean sub){
        return DictCache.getDict(type,value,sub);
    }
    public static Map<String, List<SysDict>> getAllDict(){
       return DictCache.getAllDict();
    }
}
