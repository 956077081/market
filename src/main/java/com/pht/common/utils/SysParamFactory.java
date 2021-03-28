package com.pht.common.utils;

import com.pht.common.cache.SysParamCache;

public class SysParamFactory {

    public static String getSysParam(String type){
        return SysParamCache.getSysParamValue(type);
    }
    public static String getSysParam(String type,String defaultValue){
        return SysParamCache.getSysParamValue(type,defaultValue);
    }
}
