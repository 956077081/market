package com.pht.market.mapper;

import com.pht.market.model.SeverOperatorLog;

public interface SeverOperatorLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeverOperatorLog record);

    int insertSelective(SeverOperatorLog record);

    SeverOperatorLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeverOperatorLog record);

    int updateByPrimaryKeyWithBLOBs(SeverOperatorLog record);

    int updateByPrimaryKey(SeverOperatorLog record);
}