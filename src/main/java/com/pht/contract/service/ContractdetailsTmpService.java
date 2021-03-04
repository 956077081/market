package com.pht.contract.service;

import com.pht.contract.entity.Contractdetails;
import com.pht.contract.entity.ContractdetailsTmp;

import java.util.List;

/**
 * contractdetails_tmp(ContractdetailsTmp)表服务接口
 *
 * @author makejava
 * @since 2021-02-27 11:30:13
 */
public interface ContractdetailsTmpService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    ContractdetailsTmp getByCode(String code);


    /**
     * 新增数据
     *
     * @param contractdetailsTmp 实例对象
     * @return 实例对象
     */
    ContractdetailsTmp insert(ContractdetailsTmp contractdetailsTmp);

    /**
     * 修改数据
     *
     * @param contractdetailsTmp 实例对象
     * @return 实例对象
     */
    ContractdetailsTmp update(ContractdetailsTmp contractdetailsTmp);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteByCode(String code);

    void crtContractTmp(Contractdetails contractdetails, String operateCreate);
}
