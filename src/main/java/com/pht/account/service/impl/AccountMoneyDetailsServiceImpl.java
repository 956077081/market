package com.pht.account.service.impl;

import com.pht.account.constant.AccountMoneyDict;
import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.dao.AccountMoneyDetailsDao;
import com.pht.account.service.AccountMoneyDetailsService;
import com.pht.account.service.AccountMoneySumService;
import com.pht.config.utils.PersistentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    @Autowired
    private AccountMoneySumService accountMoneySumService;
    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public AccountMoneyDetails getByCode(String code) {
        return this.accountMoneyDetailsDao.getByCode(code);
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
    public void update(AccountMoneyDetails accountMoneyDetails) {
        this.accountMoneyDetailsDao.update(accountMoneyDetails);
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

    @Override
    public void crtAccountDetails(AccountMoneyDetails accountMoneyDetails, String contractCode, String custCode, String type) {
        accountMoneyDetails.setCode(PersistentUtil.getBizEntity(AccountMoneyDetails.class));
        accountMoneyDetails.setContractCode(contractCode);
        accountMoneyDetails.setCustCode(custCode);
        accountMoneyDetails.setStatus(AccountMoneyDict.ACCOUNT_MONEY_STATUS_VALID);
        accountMoneyDetails.setCreateTime(new Date());
        accountMoneyDetails.setUpdateTime(new Date());
        accountMoneyDetails.setType(type);
        this.insert(accountMoneyDetails);
        accountMoneySumService.crtAccountSum(accountMoneyDetails);
    }

    @Override
    public List<AccountMoneyDetails> queryByContractCode(String contractCode) {
        return accountMoneyDetailsDao.queryByContractCode(contractCode);
    }
}
