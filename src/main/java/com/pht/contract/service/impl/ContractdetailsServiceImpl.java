package com.pht.contract.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pht.account.constant.AccountMoneyDict;
import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.entity.AccountMoneyDetailsTmp;
import com.pht.account.service.AccountMoneyDetailsService;
import com.pht.account.service.AccountMoneyDetailsTmpService;
import com.pht.contract.constant.ContractDict;
import com.pht.contract.dto.ContractParams;
import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.dao.ContractdetailsDao;
import com.pht.contract.entity.ContractdetailsTmp;
import com.pht.contract.service.ContractdetailsService;
import com.pht.contract.service.ContractdetailsTmpService;
import com.pht.cust.entity.Customer;
import com.pht.config.utils.PersistentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 合同表(Contractdetails)表服务实现类
 *
 * @author makejava
 * @since 2021-02-27 11:29:54
 */
@Service("contractdetailsService")
public class ContractdetailsServiceImpl implements ContractdetailsService {
    private static Logger logger = LoggerFactory.getLogger(ContractdetailsServiceImpl.class);
    @Autowired
    private ContractdetailsDao contractdetailsDao;
   @Autowired
    private AccountMoneyDetailsService accountMoneyDetailsService;
   @Autowired
   private ContractdetailsTmpService contractdetailsTmpService;
   @Autowired
   private AccountMoneyDetailsTmpService accountMoneyDetailsTmpService;
    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public Contractdetails queryByCode(String code) {
        return this.contractdetailsDao.queryByCode(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Contractdetails> queryAllByLimit(int offset, int limit) {
        return this.contractdetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contractdetails 实例对象
     * @return 实例对象
     */
    @Override
    public Contractdetails insert(Contractdetails contractdetails) {
        this.contractdetailsDao.insert(contractdetails);
        return contractdetails;
    }

    /**
     * 修改数据
     *
     * @param contractdetails 实例对象
     * @return 实例对象
     */
    @Override
    public Contractdetails update(Contractdetails contractdetails) {
        this.contractdetailsDao.update(contractdetails);
        return this.queryByCode(contractdetails.getCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByCode(String code) {
        return this.contractdetailsDao.deleteByCode(code) > 0;
    }

    @Override
    public List<ContractReturnParam> queryList(ContractQueryParam contractQueryParam, Integer pageSize, Integer currPage) {
        PageHelper.startPage(currPage,pageSize);
        return  contractdetailsDao.queryList(contractQueryParam);
    }

    @Override
    public String getAutoContractName( ) {
        return  contractdetailsDao.getContractName();
    }

    @Override
    @Transactional
    public void save(ContractParams contractParams) {
        logger.info("合同保存save:"+ JSONObject.toJSONString(contractParams));
        Contractdetails contractdetails =contractParams.getContractdetails();//合同
        Customer customer = contractParams.getCustomer();
        AccountMoneyDetails accountMoneyDetails =contractParams.getAccount();//打款明细
        contractdetails.setCode(PersistentUtil.getBizEntity(ContractParams.class));
        contractdetails.setCustCode(customer.getCode());
        contractdetails.setStatus(ContractDict.CONTRACT_STATUS_VALID);
        contractdetails.setUpdateTime(new Date());
        contractdetails.setCreateTime(new Date());
        contractdetails.setTotalMoney(accountMoneyDetails.getPayMoney());
        accountMoneyDetails.setCode(PersistentUtil.getBizEntity(AccountMoneyDetails.class));
        accountMoneyDetails.setContractCode(contractdetails.getCode());
        accountMoneyDetails.setCustCode(customer.getCode());
        accountMoneyDetails.setStatus(AccountMoneyDict.ACCOUNT_MONEY_STATUS_VALID);
        accountMoneyDetails.setCreateTime(new Date());
        accountMoneyDetails.setUpdateTime(new Date());

        ContractdetailsTmp contractdetailsTmp = new ContractdetailsTmp();//合同临时表
        AccountMoneyDetailsTmp accountMoneyDetailsTmp =new AccountMoneyDetailsTmp();//打款临时表
        BeanUtils.copyProperties(contractdetails,contractdetailsTmp);
        BeanUtils.copyProperties(accountMoneyDetails,accountMoneyDetailsTmp);
        contractdetailsTmp.setCode(PersistentUtil.getBizEntity(ContractdetailsTmp.class));
        contractdetailsTmp.setContractCode(contractdetails.getCode());
        contractdetailsTmp.setOperate(ContractDict.OPERATE_CREATE);
        accountMoneyDetailsTmp.setCode(PersistentUtil.getBizEntity(AccountMoneyDetailsTmp.class));
        accountMoneyDetailsTmp.setAccountCode(accountMoneyDetails.getCode());
        accountMoneyDetailsTmp.setOperate(AccountMoneyDict.OPERATE_CREATE);

        contractdetailsDao.insert(contractdetails);
        accountMoneyDetailsService.insert(accountMoneyDetails);
        contractdetailsTmpService.insert(contractdetailsTmp);
        accountMoneyDetailsTmpService.insert(accountMoneyDetailsTmp);
    }
}
