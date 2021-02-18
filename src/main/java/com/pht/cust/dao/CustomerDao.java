package com.pht.cust.dao;

import com.pht.cust.model.Customer;

import java.util.List;

public interface CustomerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    List<Customer> queryAll();
}