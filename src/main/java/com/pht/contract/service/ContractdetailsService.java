package com.pht.contract.service;

import com.pht.contract.dto.ContractParams;
import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.entity.Contractdetails;

import java.util.List;

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
    Contractdetails queryByCode(String code);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Contractdetails> queryAllByLimit(int offset, int limit);

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
}
