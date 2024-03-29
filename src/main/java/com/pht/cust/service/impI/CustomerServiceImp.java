package com.pht.cust.service.impI;

import com.github.pagehelper.PageHelper;
import com.pht.common.BizException;
import com.pht.common.frame.LoggerFormator;
import com.pht.base.system.constant.SysParam;
import com.pht.common.utils.SysParamFactory;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.service.ContractdetailsService;
import com.pht.cust.constant.CustDict;
import com.pht.cust.dao.CustomerDao;
import com.pht.cust.dto.CustomerParam;
import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.entity.Customer;
import com.pht.cust.service.CustomerService;
import com.pht.common.utils.PersistentUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private static LoggerFormator logger = LoggerFormator.getLogger(CustomerServiceImp.class);

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ContractdetailsService contractdetailsService;

    @Override
    public List<Customer> queryAll() {
        return customerDao.queryAll();
    }

    @Override
    public Customer getByCode(String code) {
        return customerDao.getByCode(code);
    }

    @Override
    public void save(CustomerParam customerParam) {
        Customer customer = new Customer();
        if (CustDict.CUSTTYPE_00.equals(customerParam.getCustType())) {
            customer.setOperatorCode(customerParam.getOperatorCode());
            customer.setOperatorName(customerParam.getOperatorName());
            customer.setCustName(customerParam.getCustName());
            customer.setCustType(customerParam.getCustType());
            customer.setIdType(customerParam.getIdType());
            customer.setIdNum(customerParam.getIdNum());
            customer.setEmail(customerParam.getEmail());
            customer.setAddress(customerParam.getAddress());
            customer.setPhone(customerParam.getPhone());
            customer.setSex(customerParam.getSex());
            customer.setAge(customerParam.getAge());
        } else {
            BeanUtils.copyProperties(customerParam, customer);
        }
        customer.setCode(PersistentUtil.getBizEntity(Customer.class));
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        customer.setStatus(CustDict.CUSTSTATUS_01);
        customerDao.insert(customer);
    }

    @Override
    public Customer getByCust3Val(String custType, String idType, String idNum) {
        return customerDao.getByCust3Val(custType, idType, idNum);
    }

    @Override
    public List<Customer> queryList(CustomerQueryParam customerQueryParam, Integer pageSize, Integer currPage) {
        PageHelper.startPage(currPage, pageSize);
        return customerDao.queryList(customerQueryParam);
    }

    @Override
    public void update(CustomerParam customerParam, Customer customer) {
        customer.setCustType(customerParam.getCustType());
        customer.setCustName(customerParam.getCustName());
        customer.setIdType(customerParam.getIdType());
        customer.setIdNum(customerParam.getIdNum());
        customer.setLawName(customerParam.getLawName());
        customer.setLawNum(customerParam.getLawNum());
        customer.setLawMobile(customerParam.getLawMobile());
        customer.setOperatorCode(customerParam.getOperatorCode());
        customer.setOperatorName(customerParam.getOperatorName());
        customer.setEmail(customerParam.getEmail());
        customer.setAddress(customerParam.getAddress());
        customer.setProfession(customerParam.getProfession());
        customer.setAge(customerParam.getAge());
        customer.setSex(customerParam.getSex());
        customer.setRegisterMoney(customerParam.getRegisterMoney());
        customer.setPhone(customerParam.getPhone());
        customer.setRegisterTime(customerParam.getRegisterTime());
        customer.setUpdateTime(new Date());
        customerDao.updateByCode(customer);
    }

    @Override
    public List<Customer> queryRecentNewCust() {
        String recentNewCustlimit = SysParamFactory.getSysParam("recentNewCustLimit", SysParam.recentNewCustLimit);
        return customerDao.queryRecentNewCust(recentNewCustlimit, new Date());
    }

    @Override
    public void deleteByCode(String code) {
        customerDao.deleteByCode(code);
    }

    @Transactional
    @Override
    public void delete(String code) {
        List<Contractdetails> contractdetails = contractdetailsService.checkExistContract(code);
        if (contractdetails != null && contractdetails.size() > 0) {
            throw new BizException("当前客户含有有效合同无法删除！");
        }
        List<Contractdetails>  invalidContractdetails = contractdetailsService.queryInvalidContractBycustCode(code);
        //删除无效合同  //删除客户
        invalidContractdetails.forEach(contract -> {
            contractdetailsService.delete(contract.getCode());
        });
        this.deleteByCode(code);

    }
}
