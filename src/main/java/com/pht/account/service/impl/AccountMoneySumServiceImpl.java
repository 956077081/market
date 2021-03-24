package com.pht.account.service.impl;

import com.pht.account.entity.AccountMoneySum;
import com.pht.account.dao.AccountMoneySumDao;
import com.pht.account.service.AccountMoneySumService;
import com.pht.common.frame.LoggerFormator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资金总额管理(AccountMoneySum)表服务实现类
 *
 * @author makejava
 * @since 2021-03-03 20:54:28
 */
@Service("accountMoneySumService")
public class AccountMoneySumServiceImpl implements AccountMoneySumService {
    private static LoggerFormator logger = LoggerFormator.getLogger(AccountMoneySumServiceImpl.class);
    @Resource
    private AccountMoneySumDao accountMoneySumDao;

    public AccountMoneySum getAccountSum(String custCode,String contractCode){
      return   accountMoneySumDao.getByCustAndContract(custCode,contractCode);
    }
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
    public void crtOrUpdateAccountSum(String contractCode, String custCode, BigDecimal sumMoney) {
        AccountMoneySum accountSum = getAccountSum(custCode, contractCode);
        if(accountSum == null){
            AccountMoneySum sum = new AccountMoneySum();
            sum.setCustCode(custCode);
            sum.setContractCode(contractCode);
            sum.setTotalMoney(sumMoney);
            sum.setUpdateTime(new Date());
            sum.setCreateTime(new Date());
            insert(sum);
        }else{
            accountSum.setUpdateTime(new Date());
            accountSum.setTotalMoney(sumMoney);
            update(accountSum);
        }

    }

    @Override
    public BigDecimal calcAndUpdateAccountSum(String contractCode, String custCode) {
       BigDecimal sum= accountMoneySumDao.calcAndUpdateAccountSum(contractCode,custCode);
        return sum;
    }
}
