package com.pht.account.dao;

import com.pht.account.dto.AccountFormsDto;
import com.pht.account.entity.AccountMoneyDetails;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    AccountMoneyDetails getByCode(String code);


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

    List<AccountMoneyDetails> queryByContractCode(@Param("contractCode") String contractCode);

    void invalidAccoutByContract(@Param("contractCode") String contractCode);

    List<Map<String, Object>> queryRecentNewPayDetails(@Param("timeLimie")String timeLimit, @Param("curDate")Date date);

    List<AccountFormsDto> queryAccountMonthForms(@Param("firstDayOfMonth") Date firstDayOfMonth,@Param("lastDayOfMonth") Date lastDayOfMonth);

    List<AccountFormsDto> queryAccountYearForms(@Param("year") int year);

    int deleteByContractCode(@Param("contractCode") String contractCode);
}

