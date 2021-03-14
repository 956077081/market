package com.pht.base.role.dao;

import com.pht.base.role.entity.SysRoleLnkEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleLnkEmployeeDao {
    /**
     * 插入客户关联角色
     * @param sysRoleLnkEmployee
     * @return
     */
     int insert(SysRoleLnkEmployee sysRoleLnkEmployee);

    int insertBatch(@Param("roleEmployees")List<SysRoleLnkEmployee> sysRoleLnkEmployees);
}
