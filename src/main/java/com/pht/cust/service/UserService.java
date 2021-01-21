package com.pht.cust.service;

import com.pht.cust.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     User login(String  userName,String passWord) ;
     UserDetails loadUserDetails(String userName);
     User getUserByUserName(String userNmae);

}
