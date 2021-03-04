package com.pht.account.service.impl;

import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.entity.AccountMoneySum;
import com.pht.account.dao.AccountMoneySumDao;
import com.pht.account.service.AccountMoneySumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 资金总额管理(AccountMoneySum)表服务实现类
 *
 * @author makejava
 * @since 2021-03-03 20:54:28
 */
@Service("accountMoneySumService")
public class AccountMoneySumServiceImpl implements AccountMoneySumService {
    @Resource
    private AccountMoneySumDao accountMoneySumDao;

    /**
     * 新增数据
     *
     * @param accountMoneySum 实例对象
     * @return 实例对象
     */
    @Override
    public AccountMoneySum insert(AccountMoneySum accountMoneySum) {
        this.accountMoneySumDao.insert(accountMoneySum);
        return accountMoneySum;
    }

    /**
     * 修改数据
     *
     * @param accountMoneySum 实例对象
     * @return 实例对象
     */
    @Override
    public void update(AccountMoneySum accountMoneySum) {
        this.accountMoneySumDao.update(accountMoneySum);
    }


    @Override
    public void crtAccountSum(AccountMoneyDetails accountMoneyDetails) {
        AccountMoneySum sum = new AccountMoneySum();
        sum.setCustCode(accountMoneyDetails.getCustCode());
        sum.setContractCode(accountMoneyDetails.getContractCode());
        sum.setTotalMoney(accountMoneyDetails.getPayMoney());
        sum.setUpdateTime(new Date());
        sum.setCreateTime(new Date());
        insert(sum);
    }
}
