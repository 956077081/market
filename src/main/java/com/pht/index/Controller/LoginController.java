package com.pht.index.Controller;

import com.pht.index.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public  String login(){
        return  loginService.getUser();
    }
}
