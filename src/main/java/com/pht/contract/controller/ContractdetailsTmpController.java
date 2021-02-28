package com.pht.contract.controller;

import com.pht.contract.entity.ContractdetailsTmp;
import com.pht.contract.service.ContractdetailsTmpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * contractdetails_tmp(ContractdetailsTmp)表控制层
 *
 * @author makejava
 * @since 2021-02-27 11:30:13
 */
@RestController
@RequestMapping("contractdetailsTmp")
public class ContractdetailsTmpController {
    /**
     * 服务对象
     */
    @Resource
    private ContractdetailsTmpService contractdetailsTmpService;

    /**
     * 通过主键查询单条数据
     *
     * @param code 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ContractdetailsTmp selectOne(String code) {
        return this.contractdetailsTmpService.queryByCode(code);
    }

}
