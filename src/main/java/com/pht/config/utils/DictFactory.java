package com.pht.config.utils;

import com.pht.base.system.entity.SysDict;
import com.pht.common.cache.DictCache;

public class DictFactory {
    public static String getDictLable(String type, String value){
       return   DictCache.getDictLabel(type,value);
    }
    public static SysDict getDict(String type,String value,boolean sub){
        return DictCache.getDict(type,value,sub);
    }
}
