package com.pht.market.mapper;

import com.pht.market.model.Market;

public interface MarketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Market record);

    int insertSelective(Market record);

    Market selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Market record);

    int updateByPrimaryKey(Market record);
}