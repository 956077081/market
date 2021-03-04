package com.pht.base.system.dao;

import com.pht.base.system.entity.SysParamConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统配置(SysParamConfig)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-04 16:57:15
 */
public interface SysParamConfigDao {

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<SysParamConfig> queryAll( );


}

