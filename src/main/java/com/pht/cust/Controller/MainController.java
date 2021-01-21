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
@RequestMapping("/index")
public class MainController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user){
            return "";
    }
}
