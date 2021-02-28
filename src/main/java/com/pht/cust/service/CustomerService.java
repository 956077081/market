package com.pht.cust.service;

import com.pht.cust.dto.CustomerParam;
import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.entity.Customer;

import java.util.List;

public interface CustomerService {
     List<Customer> queryAll();
     List<Customer> queryList(CustomerQueryParam customerQueryParam,Integer  pageSize,Integer currPage);
     Customer getByCode(String code);

    void save(CustomerParam customerParam);

    Customer getByCust3Val(String custType, String idType, String idNum);

    void update(CustomerParam customerParam,Customer  customer);
}
