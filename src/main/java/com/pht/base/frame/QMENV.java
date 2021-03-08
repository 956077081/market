package com.pht.base.frame;

import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.cust.entity.User;
import org.apache.commons.lang3.StringUtils;

public class QMENV {
    public  static UserInfo getUser(){
        return QMRunTimeContext.getUserInfo();
    }
    public  static  void setUser(User user){
        UserInfo userInfo = new UserInfo();
        userInfo.userCode =user.getCode();
        userInfo.userName =user.getUserName();
        QMRunTimeContext.setUserInfo(userInfo);
    }
    public static String getCompCode(){
        String compCode = QMRunTimeContext.getCompCode();
        if(StringUtils.isBlank(compCode)){
            return DataSourceFactory.getDefaultServerConfig().getCompCode();
        }
        return compCode;
    }
    public static void setCompCode(String compCode){
         QMRunTimeContext.setCompCode(compCode.toUpperCase());
    }
}
