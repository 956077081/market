package com.pht.account.service;

import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.entity.AccountMoneySum;

import java.math.BigDecimal;
import java.util.List;

/**
 * 资金总额管理(AccountMoneySum)表服务接口
 *
 * @author makejava
 * @since 2021-03-03 20:54:27
 */
public interface AccountMoneySumService {

    /**
     * 获取合同打款金额
     * @param custCode
     * @param contractCode
     * @return
     */
    AccountMoneySum getAccountSum(String custCode,String contractCode);

        /**
         * 新增数据
         *
         * @param accountMoneySum 实例对象
         * @return 实例对象
         */
    AccountMoneySum insert(AccountMoneySum accountMoneySum);

    /**
     * 修改数据
     *
     * @param accountMoneySum 实例对象
     * @return 实例对象
     */
    void update(AccountMoneySum accountMoneySum);

    /**
     * 有sum创建没有则更新
     * @param contractCode
     * @param custCode
     * @param sumMoney
     */
    void crtOrUpdateAccountSum(String contractCode, String custCode, BigDecimal sumMoney);

    BigDecimal calcAndUpdateAccountSum(String contractCode, String custCode);

}
