package com.pht.cust.dao;

import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CustomerDao {
    List<Customer> queryAll();
    int insert(Customer record);

    int updateByCode(@Param("customer") Customer customer);

    Customer getByCust3Val(@Param("custType") String custType, @Param("idType") String idType,@Param("idNum") String idNum);

    List<Customer> queryList(@Param("customerQueryParam") CustomerQueryParam customerQueryParam);

    Customer getByCode(@Param("code") String code);

    List<Customer> queryRecentNewCust(@Param("limitDay") String recentNewCustlimit,@Param("curDate") Date date);
}