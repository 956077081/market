package com.pht.account.dao;

import com.pht.account.entity.AccountMoneyDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支付金额明细(AccountMoneyDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-28 20:02:28
 */
public interface AccountMoneyDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    AccountMoneyDetails queryByCode(String code);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AccountMoneyDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accountMoneyDetails 实例对象
     * @return 对象列表
     */
    List<AccountMoneyDetails> queryAll(AccountMoneyDetails accountMoneyDetails);

    /**
     * 新增数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 影响行数
     */
    int insert(AccountMoneyDetails accountMoneyDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccountMoneyDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AccountMoneyDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccountMoneyDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AccountMoneyDetails> entities);

    /**
     * 修改数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 影响行数
     */
    int update(AccountMoneyDetails accountMoneyDetails);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

}

