package com.pht.account.dao;

import com.pht.account.entity.AccountMoneySum;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * 资金总额管理(AccountMoneySum)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-03 21:07:27
 */
public interface AccountMoneySumDao {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    AccountMoneySum getByCustAndContract(@Param("custCode") String custCode,@Param("contractCode") String contractCode);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accountMoneySum 实例对象
     * @return 对象列表
     */
    List<AccountMoneySum> queryAll(AccountMoneySum accountMoneySum);

    /**
     * 新增数据
     *
     * @param accountMoneySum 实例对象
     * @return 影响行数
     */
    int insert(AccountMoneySum accountMoneySum);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccountMoneySum> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AccountMoneySum> entities);


    /**
     * 修改数据
     *
     * @param accountMoneySum 实例对象
     * @return 影响行数
     */
    void update(AccountMoneySum accountMoneySum);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteByCustAndContract(@Param("custCode") String custCode,@Param("contractCode") String contractCode);

}

