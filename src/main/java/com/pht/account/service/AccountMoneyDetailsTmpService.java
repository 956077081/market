package com.pht.account.service;

import com.pht.account.entity.AccountMoneyDetailsTmp;

import java.util.List;

/**
 * 支付明细临时表(AccountMoneyDetailsTmp)表服务接口
 *
 * @author makejava
 * @since 2021-02-28 23:09:25
 */
public interface AccountMoneyDetailsTmpService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    AccountMoneyDetailsTmp queryByCode(String code);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AccountMoneyDetailsTmp> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 实例对象
     */
    AccountMoneyDetailsTmp insert(AccountMoneyDetailsTmp accountMoneyDetailsTmp);

    /**
     * 修改数据
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 实例对象
     */
    AccountMoneyDetailsTmp update(AccountMoneyDetailsTmp accountMoneyDetailsTmp);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteByCode(String code);

}
