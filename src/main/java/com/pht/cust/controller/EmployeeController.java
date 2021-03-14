package com.pht.cust.controller;

import com.pht.base.role.entity.SysRoleType;
import com.pht.common.CommonResult;
import com.pht.cust.dto.EmployeeResourceParam;
import com.pht.cust.entity.Employee;
import com.pht.cust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/insert")
    public CommonResult  insert(@RequestBody EmployeeResourceParam employeeResourceParam){
         employeeService.insert(employeeResourceParam);
         return CommonResult.success(true);
    }

//    @RequestMapping("/list")
//    public CommonResult list(@  )

}