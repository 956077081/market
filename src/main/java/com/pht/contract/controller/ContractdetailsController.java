package com.pht.contract.controller;

import com.pht.common.CommonPage;
import com.pht.common.CommonResult;
import com.pht.contract.dto.ContractParams;
import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.dto.ContractViews;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.service.ContractdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 合同表(Contractdetails)表控制层
 *
 * @author makejava
 * @since 2021-02-27 11:29:54
 */
@RestController
@RequestMapping("contract")
public class ContractdetailsController {
    /**
     * 服务对象
     */
    @Autowired
    private ContractdetailsService contractdetailsService;



    @RequestMapping("/list")
    public CommonResult list(ContractQueryParam contractQueryParam, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam(value = "currPage", defaultValue = "1") Integer currPage){
        List<ContractReturnParam> contractdetails = contractdetailsService.queryList(contractQueryParam,pageSize,currPage);
        return  CommonResult.success(CommonPage.crtPageContent(contractdetails));
    }

    @RequestMapping("/getContractName")
    public CommonResult getContractName( String custCode){
        String contractName = contractdetailsService.getAutoContractName();
        return  CommonResult.success(contractName);
    }

    @RequestMapping("/save")
    public CommonResult save(@RequestBody ContractParams contractParams){
          contractdetailsService.save(contractParams);
          return  CommonResult.success(true);
    }
    @RequestMapping("/get/{code}")
    public CommonResult get(@PathVariable String code){
        ContractViews contractViews  =contractdetailsService.getContractDetails(code);
        return CommonResult.success(contractViews);
    }
}
