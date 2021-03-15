package com.pht.cust.service.impI;

import com.pht.base.frame.LoggerFormator;
import com.pht.common.BizException;
import com.pht.common.CommonDict;
import com.pht.config.utils.PersistentUtil;
import com.pht.cust.constant.CustDict;
import com.pht.security.bo.AdminUserDetails;
import com.pht.cust.dao.UseDao;
import com.pht.cust.entity.User;
import com.pht.cust.service.UserService;
import com.pht.security.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImp implements UserService {
    private static LoggerFormator logger = LoggerFormator.getLogger(UserServiceImp.class);

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

    @Override
    public User insert(User user) {
        userDao.insert(user);
        return user;
    }
    public User crtUser(String userName){
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passwordEncoder.encode("11111111"));//默认密码11111111
        user.setCode(PersistentUtil.getBizEntity(User.class));
        user.setStatus(CommonDict.VALID);
        user.setCreateTime(new Date());
        user.setUserType(CustDict.USERCUSTTYPE_EMPLOYEE);
        insert(user);
        return user;
    }

    @Override
    public User getUserByCode(String usercode) {
        return  userDao.getUserByCode(usercode);
    }

    @Override
    public void operateStatus(String usercode, String operStatus) {
        User user = getUserByCode(usercode);
        if(user == null){
             throw new BizException("当前用户不存在！");
        }
        String newStatus ="";
        if(CommonDict.VALID.equals(operStatus)){
            newStatus=CommonDict.VALID;
        }else {
            newStatus=CommonDict.INVALID;
        }
        updateUserStatus(usercode,newStatus);
    }

    private void updateUserStatus(String usercode, String newStatus) {
        userDao.updateUserStatus(usercode,newStatus);
    }
}
