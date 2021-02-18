package com.pht.cust.service;

import com.pht.cust.dto.CustomerParam;
import com.pht.cust.model.Customer;

import java.util.List;

public interface CustomerService {
     List<Customer> queryAll();
     Customer getByCode();

    void save(CustomerParam customerParam);
}
