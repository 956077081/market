package com.pht.market.mapper;

import com.pht.market.model.MarketDetails;

public interface MarketDetailsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MarketDetails record);

    int insertSelective(MarketDetails record);

    MarketDetails selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MarketDetails record);

    int updateByPrimaryKey(MarketDetails record);
}