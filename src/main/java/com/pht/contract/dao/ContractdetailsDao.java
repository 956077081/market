package com.pht.contract.dao;

import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.entity.Contractdetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    Contractdetails queryByCode(String code);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Contractdetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


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
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Contractdetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Contractdetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Contractdetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Contractdetails> entities);

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
}

