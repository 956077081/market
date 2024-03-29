package com.pht.contract.dao;

import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.entity.Contractdetails;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 合同表(Contractdetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-27 11:29:54
 */
public interface ContractdetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    Contractdetails getByCode(String code);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contractdetails 实例对象
     * @return 对象列表
     */
    List<Contractdetails> queryAll(Contractdetails contractdetails);

    /**
     * 新增数据
     *
     * @param contractdetails 实例对象
     * @return 影响行数
     */
    int insert(Contractdetails contractdetails);


    /**
     * 修改数据
     *
     * @param contractdetails 实例对象
     * @return 影响行数
     */
    int update(Contractdetails contractdetails);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

    List<ContractReturnParam> queryList(@Param("contractQueryParam") ContractQueryParam contractQueryParam);

    String getContractName();

    void updateContractStatus(@Param("code") String code, @Param("status") String status,@Param("updateTime") Date updateTime);

    List<Map<String, Object>> queryRecentNewContract(@Param("contractTimeLimit") String contractTimeLimit, @Param("curTime") Date date);

    List<Map<String, Object>> queryRecentOverTimeContract(@Param("contractTimeLimit") String contractTimeLimit, @Param("curTime") Date date);

    List<Contractdetails> queryOverTimeContract(@Param("invalidContractOverTime") String invalidContractOverTime, @Param("curTime")Date date);

    List<Map<String, Object>> queryHasOverContract(@Param("hasOvercontractTimeLimit") String contractTimeLimit,@Param("curTime") Date date);
    /**
     * 有效合同
     * @param custCode
     * @return
     */
    List<Contractdetails> queryValidContractByCustCode(@Param("custCode") String custCode);
    /**
     * 无效合同
     * @param custCode
     * @return
     */
    List<Contractdetails> queryInvalidContractBycustCode(@Param("custCode") String custCode);
}

