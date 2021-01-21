package com.pht.cust.service.imp;

import com.pht.bo.AdminUserDetails;
import com.pht.cust.model.User;
import com.pht.cust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User login(String userName, String passWord) {
         UserDetails userDetails = loadUserDetails(userName);
         if(!passwordEncoder.matches(passWord,userDetails.getPassword())){
                throw  new BadCredentialsException("用户名或者密码错误！");
         }
         //获取token


        return null;
    }

    public UserDetails loadUserDetails(String userName) {
        User user = getUserByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("当前用户不存在");
        }else{
              return new AdminUserDetails(user);
        }
    }

    @Override
    public User getUserByUserName(String userNmae) {
        return null;
    }
}
