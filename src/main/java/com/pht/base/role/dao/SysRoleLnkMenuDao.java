package com.pht.base.role.dao;

import com.pht.base.role.dto.MenuParam;
import com.pht.base.role.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleLnkMenuDao {
    List<SysMenu> queryRoleMenus(@Param("roles") List<String> roleList);
}
