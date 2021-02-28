package com.pht.account.dao;

import com.pht.account.entity.AccountMoneyDetailsTmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支付明细临时表(AccountMoneyDetailsTmp)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-28 23:09:25
 */
public interface AccountMoneyDetailsTmpDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    AccountMoneyDetailsTmp queryByCode(String code);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AccountMoneyDetailsTmp> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 对象列表
     */
    List<AccountMoneyDetailsTmp> queryAll(AccountMoneyDetailsTmp accountMoneyDetailsTmp);

    /**
     * 新增数据
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 影响行数
     */
    int insert(AccountMoneyDetailsTmp accountMoneyDetailsTmp);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccountMoneyDetailsTmp> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AccountMoneyDetailsTmp> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccountMoneyDetailsTmp> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AccountMoneyDetailsTmp> entities);

    /**
     * 修改数据
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 影响行数
     */
    int update(AccountMoneyDetailsTmp accountMoneyDetailsTmp);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

}

