package com.pht.contract.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pht.account.constant.AccountMoneyDict;
import com.pht.account.entity.AccountMoneyDetails;
import com.pht.account.service.AccountMoneyDetailsService;
import com.pht.account.service.AccountMoneySumService;
import com.pht.common.frame.LoggerFormator;
import com.pht.common.frame.QMENV;
import com.pht.common.BizException;
import com.pht.common.utils.PersistentUtil;
import com.pht.contract.constant.ContractDict;
import com.pht.contract.dto.ContractParams;
import com.pht.contract.dto.ContractQueryParam;
import com.pht.contract.dto.ContractReturnParam;
import com.pht.contract.dto.ContractViews;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.dao.ContractdetailsDao;
import com.pht.contract.service.ContractdetailsService;
import com.pht.contract.service.ContractdetailsTmpService;
import com.pht.cust.entity.Customer;
import com.pht.cust.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 合同表(Contractdetails)表服务实现类
 *
 * @author makejava
 * @since 2021-02-27 11:29:54
 */
@Service("contractdetailsService")
public class ContractdetailsServiceImpl implements ContractdetailsService {
    private static LoggerFormator logger = LoggerFormator.getLogger(ContractdetailsServiceImpl.class);
    @Autowired
    private ContractdetailsDao contractdetailsDao;
   @Autowired
    private AccountMoneyDetailsService accountMoneyDetailsService;
   @Autowired
   private ContractdetailsTmpService contractdetailsTmpService;

   @Autowired
     private AccountMoneySumService accountMoneySumService;
   @Autowired
   private CustomerService customerService;
    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public Contractdetails getByCode(String code) {
        return this.contractdetailsDao.getByCode(code);
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
        contractdetails.setId(null);
        contractdetails.setUpdateTime(new Date());
        this.contractdetailsDao.update(contractdetails);
        contractdetailsTmpService.crtContractTmp(contractdetails,ContractDict.OPERATE_UPDATE);
        return contractdetails;
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
       contractQueryParam.setCurTime(new Date());
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
        contractdetails.setOperatorCode(QMENV.getUser().userCode);
        contractdetails.setOperatorName(QMENV.getUser().userName);
        contractdetails.setUpdateTime(new Date());
        contractdetails.setCreateTime(new Date());
        accountMoneyDetails.setType(AccountMoneyDict.ACCOUNT_TYPE_IN);
        contractdetailsTmpService.crtContractTmp(contractdetails,ContractDict.OPERATE_CREATE);
        accountMoneyDetailsService.crtAccountDetails(accountMoneyDetails,contractdetails.getCode(),customer.getCode());
        contractdetailsDao.insert(contractdetails);
    }


    @Override
    public ContractViews getContractDetails(String code) {
        ContractViews contractViews =new ContractViews();
        Contractdetails contractdetails = contractdetailsDao.getByCode(code);
        if(contractdetails ==null){
            throw  new BizException("当前合同保存不存在code="+code);
        }
        Customer customer = customerService.getByCode(contractdetails.getCustCode());
        List<AccountMoneyDetails> accountMoneyDetails = accountMoneyDetailsService.queryByContractCode(contractdetails.getCode());
        contractViews.setAccountMoneyDetails(accountMoneyDetails);//打款
        contractViews.setCustomer(customer);//客户
        contractViews.setContractdetails(contractdetails);//合同
        return contractViews;
    }

    @Override
    @Transactional
    public void invalid(String code) {
        Contractdetails contractdetails = getByCode(code);
        contractdetails.setStatus(ContractDict.CONTRACT_STATUS_INVALID);
        updateContractStatus(code,contractdetails.getStatus());
        accountMoneyDetailsService.invalidAccoutByContract(code);
        contractdetailsTmpService.crtContractTmp(contractdetails,ContractDict.OPERATE_UPDATE);
    }

    @Override
    public List<Map<String,Object>> queryRecentNewContract(String contractTimeLimit) {
        return    contractdetailsDao.queryRecentNewContract(contractTimeLimit,new Date());
    }

    @Override
    public List<Map<String,Object>> queryRecentOverTimeContract(String contractTimeLimit) {
     return    contractdetailsDao.queryRecentOverTimeContract(contractTimeLimit,new Date());
    }

    @Override
    public List<Contractdetails> queryOverTimeContract(String invalidContractOverTime) {
        return contractdetailsDao.queryOverTimeContract(invalidContractOverTime,new Date());
    }

    @Override
    public void invalidContract(Contractdetails contractdetails) {
        updateContractStatus(contractdetails.getCode(),ContractDict.CONTRACT_STATUS_FINISH);
    }

    @Override
    public List<Map<String, Object>> queryHasOverContract(String contractTimeLimit) {
        return  contractdetailsDao.queryHasOverContract(contractTimeLimit,new Date());
    }

    @Override
    public void finishContracts(String codes) {
        String[] codearr = codes.split(",");
        for (int i = 0; i < codearr.length; i++) {
            if(StringUtils.isNotBlank(codearr[i])){
                Contractdetails contractdetails = contractdetailsDao.getByCode(codearr[i]);
                if(contractdetails != null){
                    contractdetails.setStatus(ContractDict.CONTRACT_STATUS_FINISH);
                    contractdetails.setUpdateTime(new Date());
                    contractdetailsDao.update(contractdetails);
                    contractdetailsTmpService.crtContractTmp(contractdetails,ContractDict.CONTRACT_STATUS_FINISH);
                }
            }
        }
    }

    @Override
    public List<Contractdetails> checkExistContract(String custcode) {
        return   contractdetailsDao.queryValidContractByCustCode(custcode);
    }

    /**
     * check:无效合同才能删除
     * 1 删除合同
     * 2 删除打款
     * @param code
     */
    @Override
    @Transactional
    public void delete(String code) {
        Contractdetails contractdetails = contractdetailsDao.getByCode(code);
        if (!ContractDict.CONTRACT_STATUS_INVALID.equals(contractdetails.getStatus())) {
            throw new BizException("非无效合同无法删除！");
        }
        deleteByCode(contractdetails.getCode());//1 删除合同
        contractdetailsTmpService.crtContractTmp(contractdetails,ContractDict.OPERATE_DELETE);
        accountMoneyDetailsService.deleteByContractCode(contractdetails.getCode());// 2 删除打款详情
        accountMoneySumService.deleteByContract(contractdetails.getCode());//3 删除资金打款金额
    }

    @Override
    public List<Contractdetails> queryInvalidContractBycustCode(String code) {
        return contractdetailsDao.queryInvalidContractBycustCode(code);
    }

    private void updateContractStatus(String code,String status){
         contractdetailsDao.updateContractStatus(code,status,new Date());
    }
}
