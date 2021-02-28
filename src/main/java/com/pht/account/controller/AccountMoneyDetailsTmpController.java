package com.pht.account.controller;

import com.pht.account.entity.AccountMoneyDetailsTmp;
import com.pht.account.service.AccountMoneyDetailsTmpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 支付明细临时表(AccountMoneyDetailsTmp)表控制层
 *
 * @author makejava
 * @since 2021-02-28 23:09:25
 */
@RestController
@RequestMapping("accountMoneyDetailsTmp")
public class AccountMoneyDetailsTmpController {
    /**
     * 服务对象
     */
    @Resource
    private AccountMoneyDetailsTmpService accountMoneyDetailsTmpService;

    /**
     * 通过主键查询单条数据
     *
     * @param code 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AccountMoneyDetailsTmp selectOne(String code) {
        return this.accountMoneyDetailsTmpService.queryByCode(code);
    }

}
