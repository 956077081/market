package com.pht.account.service.impl;

import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.dao.AccountMoneyDetailsDao;
import com.pht.account.service.AccountMoneyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支付金额明细(AccountMoneyDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-02-28 20:02:28
 */
@Service("accountMoneyDetailsService")
public class AccountMoneyDetailsServiceImpl implements AccountMoneyDetailsService {
    @Autowired
    private AccountMoneyDetailsDao accountMoneyDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetails queryByCode(String code) {
        return this.accountMoneyDetailsDao.queryByCode(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AccountMoneyDetails> queryAllByLimit(int offset, int limit) {
        return this.accountMoneyDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetails insert(AccountMoneyDetails accountMoneyDetails) {
        this.accountMoneyDetailsDao.insert(accountMoneyDetails);
        return accountMoneyDetails;
    }

    /**
     * 修改数据
     *
     * @param accountMoneyDetails 实例对象
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetails update(AccountMoneyDetails accountMoneyDetails) {
        this.accountMoneyDetailsDao.update(accountMoneyDetails);
        return this.queryByCode(accountMoneyDetails.getCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByCode(String code) {
        return this.accountMoneyDetailsDao.deleteByCode(code) > 0;
    }
}
