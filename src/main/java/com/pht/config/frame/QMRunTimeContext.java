package com.pht.config.frame;

import java.util.HashMap;
import java.util.Map;

public class QMRunTimeContext {
     private static ThreadLocal<Map<String,Object>> threadLocal =new ThreadLocal<>();

     private static String  THREAD_USERINFO="userInfo";
     private static String  COMP="comp";//当前数据源
    public static UserInfo getUserInfo() {
        Map<String, Object> threadMap = threadLocal.get();
        if(threadMap==null){
            threadMap =new HashMap<>();
        }
        Object userObj = threadMap.get(THREAD_USERINFO);
        if(userObj ==null){
            return null;
        }
        return (UserInfo) userObj;
    }
    public static void setUserInfo(UserInfo userInfo) {
        Map<String, Object> objectMap = threadLocal.get();
        if(objectMap ==null){
            objectMap= new HashMap<>();
        }
        objectMap.put(THREAD_USERINFO,userInfo);
        threadLocal.set(objectMap);
    }
    public static void clear(){
        threadLocal.remove();
    }
    public static String getCompCode(){
        Map<String, Object> objectMap = threadLocal.get();
        if(objectMap ==null){
            objectMap= new HashMap<>();
        }
        return objectMap.get(COMP)==null?"":objectMap.get(COMP).toString();
    }
    public static void setCompCode(String compCode){
        Map<String, Object> objectMap = threadLocal.get();
        if(objectMap ==null){
            objectMap= new HashMap<>();
        }
        objectMap.put(COMP,compCode);
        threadLocal.set(objectMap);
    }
}
