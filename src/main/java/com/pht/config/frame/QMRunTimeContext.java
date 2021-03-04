package com.pht.config.frame;

import java.util.HashMap;
import java.util.Map;

public class QMRunTimeContext {
     private static ThreadLocal<Map<String,Object>> threadLocal =new ThreadLocal<>();

     private static String  THREAD_USERINFO="userInfo";

    public static UserInfo getUserInfo() {
        Map<String, Object> threadMap = threadLocal.get();
        Object userObj = threadMap.get(THREAD_USERINFO);
        UserInfo userInfo  =null;
        if(userInfo ==null){
            userInfo =new UserInfo();
        }
        return (UserInfo) userObj;
    }
    public static void setUserInfo(UserInfo userInfo) {
        Map<String, Object> objectMap = threadLocal.get();
        if(objectMap ==null){
            objectMap= new HashMap<>();
        }
        objectMap.put(THREAD_USERINFO,userInfo);
    }

    public static void clear(){
        threadLocal.remove();
    }
}
