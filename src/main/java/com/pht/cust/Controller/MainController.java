package com.pht.cust.Controller;

import cn.hutool.http.HttpResponse;
import com.pht.Common.CommonResult;
import com.pht.cust.dto.AdminLoginParam;
import com.pht.cust.model.User;
import com.pht.cust.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public CommonResult login(HttpServletRequest request, HttpServletResponse response,@RequestBody  AdminLoginParam adminLoginParam){
        User user = new User();
//        System.out.println(adminLoginParam),@Validated @RequestBody  AdminLoginParam adminLoginParam;
        String token = userService.login(user.getUserName(), user.getPassWord());
        if(StringUtils.isBlank(token)){
            return  CommonResult.failed();
        }

        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }
}
