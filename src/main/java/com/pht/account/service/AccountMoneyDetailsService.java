package com.pht.account.service;

import com.pht.account.entity.AccountMoneyDetails;

import java.util.List;

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
    AccountMoneyDetails queryByCode(String code);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AccountMoneyDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 实例对象
     */
    AccountMoneyDetails insert(AccountMoneyDetails accountMoneyDetails);

    /**
     * 修改数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 实例对象
     */
    AccountMoneyDetails update(AccountMoneyDetails accountMoneyDetails);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteByCode(String code);

}
