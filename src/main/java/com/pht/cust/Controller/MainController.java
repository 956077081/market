package com.pht.cust.Controller;

import com.pht.common.CommonResult;
import com.pht.cust.dto.AdminLoginParam;
import com.pht.cust.model.User;
import com.pht.cust.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/admin")
public class MainController {
    @Value("${jwt.tokenHead}")
    private String tokenHead ;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody  AdminLoginParam adminLoginParam){
        String token = userService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword());
        if(StringUtils.isBlank(token)){
            return  CommonResult.failed();
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }
    @RequestMapping(value = "/userinfo")
    @ResponseBody
    public CommonResult getUserInfo(Principal principal){
        if(principal==null){
            return CommonResult.failed("获取用户信息错误",null);
        }
        User user = userService.getUserByUserName(principal.getName());
        Map<String, Object> map = new HashMap<>();
        map.put("userCode",user.getCode());
        return CommonResult.success(map);
    }
}
