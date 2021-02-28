package com.pht.cust.service.imp;

import com.pht.common.BizException;
import com.pht.bo.AdminUserDetails;
import com.pht.cust.dao.UseDao;
import com.pht.cust.entity.User;
import com.pht.cust.service.UserService;
import com.pht.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UseDao userDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public String login(String userName, String passWord) {
         UserDetails userDetails = loadUserDetails(userName);
         if(!passwordEncoder.matches(passWord,userDetails.getPassword())){
                throw  new BadCredentialsException("用户名或者密码错误！");
         }
         if(!userDetails.isEnabled()){
             throw new BizException("当前用户不可用！");
         }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);//配置use数据sercurityContext管理
        //获取token
        String token = jwtTokenUtil.generateToken(userDetails);
        return token;
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
        return userDao.getUserByName(userNmae);
    }
}
