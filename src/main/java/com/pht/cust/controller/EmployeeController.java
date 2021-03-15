package com.pht.cust.controller;

import com.pht.base.role.entity.SysRoleType;
import com.pht.common.CommonPage;
import com.pht.common.CommonResult;
import com.pht.cust.dto.EmployeeQueryParam;
import com.pht.cust.dto.EmployeeResourceParam;
import com.pht.cust.entity.Employee;
import com.pht.cust.entity.User;
import com.pht.cust.service.EmployeeService;
import com.pht.cust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 员工(Employee)表控制层
 *
 * @author pht
 * @since 2021-03-14 13:16:31
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public CommonResult  insert(@RequestBody EmployeeResourceParam employeeResourceParam){
         employeeService.insert(employeeResourceParam);
         return CommonResult.success(true);
    }

    @RequestMapping("/list")
    public CommonResult list(EmployeeQueryParam employeeQueryParam,@RequestParam(name = "currPage",defaultValue = "1") Integer currPage,@RequestParam(name = "pageSize",defaultValue = "10")  Integer pageSize ){
        List<Map<String,Object>> list= employeeService.queryList(employeeQueryParam,currPage,pageSize);
        CommonPage<Map<String, Object>> page = CommonPage.crtPageContent(list);
        return CommonResult.success(page);
    }

    @RequestMapping("/opsStatus")
    public CommonResult operate(@RequestParam String usercode,@RequestParam String opsStatus){
        userService.operateStatus(usercode,opsStatus);
        return CommonResult.success(true);
    }
}