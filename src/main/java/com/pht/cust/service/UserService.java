package com.pht.cust.service;

import com.pht.cust.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
     String login(String  userName,String passWord) ;
     UserDetails loadUserDetails(String userName);
     User getUserByUserName(String userNmae);
     User insert(User user);
     User crtUser(String userName);

    User getUserByCode(String usercode);

     void operateStatus(String usercode, String operStatus);
}
