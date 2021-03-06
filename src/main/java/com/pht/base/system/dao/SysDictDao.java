package com.pht.base.system.dao;

import com.pht.base.system.entity.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典表(SysDict)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-05 23:01:55
 */
public interface SysDictDao {



    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<SysDict> queryAll();

}

