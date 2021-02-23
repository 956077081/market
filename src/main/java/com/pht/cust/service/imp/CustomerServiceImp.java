package com.pht.cust.service.imp;

import com.github.pagehelper.PageHelper;
import com.pht.cust.constant.CustDict;
import com.pht.cust.dao.CustomerDao;
import com.pht.cust.dto.CustomerParam;
import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.model.Customer;
import com.pht.cust.service.CustomerService;
import com.pht.utils.PersistentUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<Customer> queryAll() {
        return customerDao.queryAll();
    }

    @Override
    public Customer getByCode() {
        return null;
    }

    @Override
    public void save(CustomerParam customerParam) {
        Customer customer = new Customer();
        if(CustDict.CUSTTYPE_00.equals(customerParam.getCustType())){
            customer.setOperatorCode(customerParam.getOperatorCode());
            customer.setOperatorName(customerParam.getOperatorName());
            customer.setCustName(customerParam.getCustName());
            customer.setCustType(customerParam.getCustType());
            customer.setIdType(customerParam.getIdType());
            customer.setIdNum(customerParam.getIdNum());
            customer.setEmail(customerParam.getEmail());
        }else{
            BeanUtils.copyProperties(customerParam,customer);
        }
        customer.setCode(PersistentUtil.getBizEntity(Customer.class));
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        customer.setStatus(CustDict.CUSTSTATUS_01);
        customerDao.insert(customer);
    }

    @Override
    public Customer getByCust3Val(String custType, String idType, String idNum) {
        return customerDao.getByCust3Val(custType,idType,idNum);
    }

    @Override
    public List<Customer> queryList(CustomerQueryParam customerQueryParam, Integer pageSize, Integer currPage) {
        PageHelper.startPage(currPage,pageSize);
        return customerDao.queryList(customerQueryParam);
    }
}
