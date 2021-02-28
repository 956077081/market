package com.pht.account.controller;

import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.service.AccountMoneyDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 支付金额明细(AccountMoneyDetails)表控制层
 *
 * @author makejava
 * @since 2021-02-28 20:02:29
 */
@RestController
@RequestMapping("accountMoneyDetails")
public class AccountMoneyDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private AccountMoneyDetailsService accountMoneyDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param code 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AccountMoneyDetails selectOne(String code) {
        return this.accountMoneyDetailsService.queryByCode(code);
    }

}
