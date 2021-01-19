package com.pht.cust.Controller;

import com.pht.Common.CommonResult;
import com.pht.cust.model.User;
import com.pht.cust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public CommonResult<Object> login(User user){
         user =  userService.login(user);
        if(user ==null){
        }
        return null;
    }
}
