package com.pht.plugins.mapper;

import com.pht.plugins.model.customer;

public interface customerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(customer record);

    int insertSelective(customer record);

    customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(customer record);

    int updateByPrimaryKey(customer record);
}