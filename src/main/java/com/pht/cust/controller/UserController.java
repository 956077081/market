package com.pht.cust.controller;

import com.pht.common.CommonResult;
import com.pht.cust.entity.User;
import com.pht.cust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/updateWord")
    public CommonResult updateWord(@RequestBody User user){
        boolean res= userService.updateWord(user.getCode(),user.getPassWord());
        return CommonResult.success(res);
    }
}
