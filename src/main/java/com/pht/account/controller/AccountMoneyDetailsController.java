package com.pht.account.controller;

import com.pht.account.dto.AccountMoneyParam;
import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.service.AccountMoneyDetailsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public void insert(@RequestBody @Validated AccountMoneyParam accountMoneyParam){
        accountMoneyDetailsService.insert(accountMoneyParam);

    }
}
