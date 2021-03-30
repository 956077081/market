package com.pht.contract.service;

import com.pht.contract.dto.ContractParams;
import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.dto.ContractViews;
import com.pht.contract.entity.Contractdetails;

import java.util.List;
import java.util.Map;

/**
 * 合同表(Contractdetails)表服务接口
 *
 * @author makejava
 * @since 2021-02-27 11:29:54
 */
public interface ContractdetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    Contractdetails getByCode(String code);


    /**
     * 新增数据
     *
     * @param contractdetails 实例对象
     * @return 实例对象
     */
    Contractdetails insert(Contractdetails contractdetails);

    /**
     * 修改数据
     *
     * @param contractdetails 实例对象
     * @return 实例对象
     */
    Contractdetails update(Contractdetails contractdetails);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteByCode(String code);

    List<ContractReturnParam> queryList(ContractQueryParam contractQueryParam, Integer pageSize, Integer currPage);

    /**
     * 获取合同名称
     *
     * @return
     */
    String getAutoContractName();

    void save(ContractParams contractParams);

    ContractViews getContractDetails(String code);

    void invalid(String code);

    /**
     * 获取近期合同
     * @param contractTimeLimit
     * @return
     */
    List<Map<String,Object>> queryRecentNewContract(String contractTimeLimit);

    /**
     * 即将过期合同
     * @param contractTimeLimit
     * @return
     */
    List<Map<String,Object>> queryRecentOverTimeContract(String contractTimeLimit);

    List<Contractdetails> queryOverTimeContract(String invalidContractOverTime);

    void invalidContract(Contractdetails contractdetails);

    List<Map<String, Object>> queryHasOverContract(String contractTimeLimit);

    void finishContracts(String codes);

    List<Contractdetails> checkExistContract(String custcode);



    void delete(String code);
}
