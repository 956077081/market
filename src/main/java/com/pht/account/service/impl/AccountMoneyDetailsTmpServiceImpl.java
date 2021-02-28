package com.pht.account.service.impl;

import com.pht.account.entity.AccountMoneyDetailsTmp;
import com.pht.account.dao.AccountMoneyDetailsTmpDao;
import com.pht.account.service.AccountMoneyDetailsTmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支付明细临时表(AccountMoneyDetailsTmp)表服务实现类
 *
 * @author makejava
 * @since 2021-02-28 23:09:25
 */
@Service("accountMoneyDetailsTmpService")
public class AccountMoneyDetailsTmpServiceImpl implements AccountMoneyDetailsTmpService {
    @Autowired
    private AccountMoneyDetailsTmpDao accountMoneyDetailsTmpDao;

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetailsTmp queryByCode(String code) {
        return this.accountMoneyDetailsTmpDao.queryByCode(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AccountMoneyDetailsTmp> queryAllByLimit(int offset, int limit) {
        return this.accountMoneyDetailsTmpDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetailsTmp insert(AccountMoneyDetailsTmp accountMoneyDetailsTmp) {
        this.accountMoneyDetailsTmpDao.insert(accountMoneyDetailsTmp);
        return accountMoneyDetailsTmp;
    }

    /**
     * 修改数据
     *
     * @param accountMoneyDetailsTmp 实例对象
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetailsTmp update(AccountMoneyDetailsTmp accountMoneyDetailsTmp) {
        this.accountMoneyDetailsTmpDao.update(accountMoneyDetailsTmp);
        return this.queryByCode(accountMoneyDetailsTmp.getCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByCode(String code) {
        return this.accountMoneyDetailsTmpDao.deleteByCode(code) > 0;
    }
}
