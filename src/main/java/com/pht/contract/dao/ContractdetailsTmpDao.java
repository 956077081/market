package com.pht.contract.dao;

import com.pht.contract.entity.ContractdetailsTmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * contractdetails_tmp(ContractdetailsTmp)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-27 11:30:13
 */
public interface ContractdetailsTmpDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    ContractdetailsTmp getByCode(String code);




    /**
     * 通过实体作为筛选条件查询
     *
     * @param contractdetailsTmp 实例对象
     * @return 对象列表
     */
    List<ContractdetailsTmp> queryAll(ContractdetailsTmp contractdetailsTmp);

    /**
     * 新增数据
     *
     * @param contractdetailsTmp 实例对象
     * @return 影响行数
     */
    int insert(ContractdetailsTmp contractdetailsTmp);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContractdetailsTmp> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ContractdetailsTmp> entities);


    /**
     * 修改数据
     *
     * @param contractdetailsTmp 实例对象
     * @return 影响行数
     */
    int update(ContractdetailsTmp contractdetailsTmp);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

}

