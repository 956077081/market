package com.pht.cust.Controller;

import com.pht.common.CommonResult;
import com.pht.cust.dto.CustomerParam;
import com.pht.cust.model.Customer;
import com.pht.cust.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/list")
    @ResponseBody
    public CommonResult list(){
        List<Customer> customers = customerService.queryAll();
        return CommonResult.success(customers);
    }
    @RequestMapping("/create")
    @ResponseBody
    public CommonResult create(@RequestBody CustomerParam customerParam){
        customerService.save(customerParam);
        return CommonResult.success(true);
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        return null;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public CommonResult get(@PathVariable Long id){
        return null;
    }
}
