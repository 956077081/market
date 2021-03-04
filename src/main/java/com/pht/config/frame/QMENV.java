package com.pht.config.frame;

import com.pht.cust.entity.User;

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
}
