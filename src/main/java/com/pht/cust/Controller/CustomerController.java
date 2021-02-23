package com.pht.cust.Controller;

import com.github.pagehelper.PageInfo;
import com.pht.common.CommonPage;
import com.pht.common.CommonResult;
import com.pht.cust.dto.CustomerParam;
import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.model.Customer;
import com.pht.cust.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    @ResponseBody
        public CommonResult list(CustomerQueryParam customerQueryParam, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam(value = "currPage", defaultValue = "1") Integer currPage) {
        List<Customer> customers = customerService.queryList(customerQueryParam,pageSize,currPage);
        return CommonResult.success(CommonPage.crtPageContent(customers));
    }

    @RequestMapping("/create")
    @ResponseBody
    public CommonResult create(@RequestBody CustomerParam customerParam) {
        Customer customer = customerService.getByCust3Val(customerParam.getCustType(), customerParam.getIdType(), customerParam.getIdNum());
        if (customer != null) {
            return CommonResult.success("当前客户已存在", false);
        }
        customerService.save(customerParam);
        return CommonResult.success(true);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        return null;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public CommonResult get(@PathVariable Long id) {
        return null;
    }
}
