package com.pht.account.service.impl;

import com.pht.account.constant.AccountMoneyDict;
import com.pht.account.dto.AccountMoneyParam;
import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.dao.AccountMoneyDetailsDao;
import com.pht.account.service.AccountMoneyDetailsService;
import com.pht.account.service.AccountMoneySumService;
import com.pht.base.frame.LoggerFormator;
import com.pht.base.frame.QMENV;
import com.pht.base.system.constant.SysParam;
import com.pht.common.BizException;
import com.pht.config.utils.PersistentUtil;
import com.pht.config.utils.QmDataConvertUtils;
import com.pht.config.utils.SysParamFactory;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.service.ContractdetailsService;
import com.pht.cust.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 支付金额明细(AccountMoneyDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-02-28 20:02:28
 */
@Service("accountMoneyDetailsService")
public class AccountMoneyDetailsServiceImpl implements AccountMoneyDetailsService {
    private static LoggerFormator logger = LoggerFormator.getLogger(AccountMoneyDetailsServiceImpl.class);
    @Autowired
    private AccountMoneySumService accountMoneySumService;
    @Autowired
    private ContractdetailsService contractdetailsService;
    @Autowired
    private AccountMoneyDetailsDao accountMoneyDetailsDao;
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

    @Override
    public AccountMoneyDetails insert(AccountMoneyDetails accountMoneyDetails) {
        accountMoneyDetailsDao.insert(accountMoneyDetails);
         return accountMoneyDetails;
    }

    /**
     * 新增数据
     *
     * @param accountMoneyParam 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public AccountMoneyDetails insert( AccountMoneyParam accountMoneyParam) {
        logger.info("合同打款、扣款操作|data="+ QmDataConvertUtils.obj2JsonStr(accountMoneyParam));
        String contractCode = accountMoneyParam.getContractCode();
        Contractdetails contractdetails = contractdetailsService.getByCode(contractCode);
        if(contractdetails ==null ){
            throw  new BizException("保存打款/扣款金额错误！找不到合同code="+contractCode);
        }
        AccountMoneyDetails accountMoneyDetails =new AccountMoneyDetails();
        BeanUtils.copyProperties(accountMoneyParam,accountMoneyDetails);
        crtAccountDetails(accountMoneyDetails,contractCode,contractdetails.getCustCode());
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
    public AccountMoneyDetails crtAccountDetails(AccountMoneyDetails accountMoneyDetails, String contractCode, String custCode) {
        accountMoneyDetails.setId(null);
        accountMoneyDetails.setCode(PersistentUtil.getBizEntity(AccountMoneyDetails.class));
        accountMoneyDetails.setContractCode(contractCode);
        accountMoneyDetails.setCustCode(custCode);
        accountMoneyDetails.setStatus(AccountMoneyDict.ACCOUNT_MONEY_STATUS_VALID);
        accountMoneyDetails.setCreateTime(new Date());
        accountMoneyDetails.setUpdateTime(new Date());
        accountMoneyDetails.setOperatorCode(QMENV.getUser().userCode);
        accountMoneyDetails.setOperatorName(QMENV.getUser().userName);
        BigDecimal payMoneyAll = accountMoneySumService.calcAndUpdateAccountSum(contractCode, custCode);
        if(payMoneyAll==null){
            payMoneyAll=new BigDecimal(0);
        }
        if(AccountMoneyDict.ACCOUNT_TYPE_OUT.equals(accountMoneyDetails.getType())&&payMoneyAll.compareTo(accountMoneyDetails.getPayMoney())<0){
            throw new BizException("账户金额不够扣减！");
        }
        this.insert(accountMoneyDetails);//打款
        accountMoneySumService.crtOrUpdateAccountSum(contractCode,custCode,accountMoneyDetails.getPayMoney());//打款金额
        return accountMoneyDetails;
    }

    @Override
    public List<AccountMoneyDetails> queryByContractCode(String contractCode) {
        return accountMoneyDetailsDao.queryByContractCode(contractCode);
    }

    @Override
    public void invalidAccoutByContract(String contractCode) {
         accountMoneyDetailsDao.invalidAccoutByContract(contractCode);
    }

    @Override
    public List<Map<String,Object>> queryRecentNewPayDetails() {
        String timeLimit = SysParamFactory.getSysParam(SysParam.recentPayLimit, "7");
        return   accountMoneyDetailsDao.queryRecentNewPayDetails(timeLimit,new Date());
    }
}
