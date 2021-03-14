package com.pht.base.role.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色关联菜单（可见性配置）(SysRoleLnkMenu)实体类
 *
 * @author pht
 * @since 2021-03-14 12:31:16
 */
public class SysRoleLnkMenu implements Serializable {
    private static final long serialVersionUID = 634323373389617457L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 角色类型
    */
    private String roleType;
    /**
    * 菜单编号
    */
    private String menuCode;
    /**
    * 创建时间
    */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}