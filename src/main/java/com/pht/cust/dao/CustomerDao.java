package com.pht.cust.dao;

import com.pht.cust.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> queryAll();
    int insert(Customer record);

    int updateByCode(Customer record);
}