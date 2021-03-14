package com.pht.account.service;

import com.pht.account.dto.AccountMoneyParam;
import com.pht.account.entity.AccountMoneyDetails;

import java.util.List;
import java.util.Map;

/**
 * 支付金额明细(AccountMoneyDetails)表服务接口
 *
 * @author makejava
 * @since 2021-02-28 20:02:28
 */
public interface AccountMoneyDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    AccountMoneyDetails getByCode(String code);


    /**
     * 新增数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 实例对象
     */

    AccountMoneyDetails insert(AccountMoneyDetails  accountMoneyDetails);


    AccountMoneyDetails insert(AccountMoneyParam  accountMoneyParam);


    /**
     * 修改数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 实例对象
     */
    void update(AccountMoneyDetails accountMoneyDetails);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteByCode(String code);

    AccountMoneyDetails crtAccountDetails(AccountMoneyDetails accountMoneyDetails, String code, String code1);

    List<AccountMoneyDetails> queryByContractCode(String contractCode);
     void invalidAccoutByContract(String contractCode);

    List<Map<String,Object>> queryRecentNewPayDetails();
}

