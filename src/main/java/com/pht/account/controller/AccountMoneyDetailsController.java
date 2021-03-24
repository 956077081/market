package com.pht.account.controller;

import com.pht.account.dto.AccountFormsDto;
import com.pht.account.dto.AccountMoneyParam;
import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.service.AccountMoneyDetailsService;
import com.pht.common.BizException;
import com.pht.common.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 支付金额明细(AccountMoneyDetails)表控制层
 *
 * @author makejava
 * @since 2021-02-28 20:02:29
 */
@RestController
@RequestMapping("account")
public class AccountMoneyDetailsController {
    /**
     * 服务对象
     */
    @Autowired
    private AccountMoneyDetailsService accountMoneyDetailsService;


    @RequestMapping("/insert" )
    public CommonResult insert(@RequestBody @Validated AccountMoneyParam accountMoneyParam){
        accountMoneyDetailsService.insert(accountMoneyParam);
        return CommonResult.success(true);
    }

    /**
     * 近期打款
     * @return
     */
    @RequestMapping("/recentNewPayDetails")
    public CommonResult recentNewPayDetails(){
        List<Map<String,Object>> lists=  accountMoneyDetailsService.queryRecentNewPayDetails();
        return CommonResult.success(lists);
    }

    /**
     * 获取打款报表
     * @param type
     * @param date
     * @return
     */
    @RequestMapping("/forms")
    public CommonResult queryForm(@RequestParam String type, @RequestParam String date){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date formDate =null;
        try {
            formDate= simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return CommonResult.failed("当前时间传入错误");
        }
        AccountFormsDto accountFormsDto= accountMoneyDetailsService.queryAccountForms(type,formDate);
        return CommonResult.success(accountFormsDto);
    }

}
