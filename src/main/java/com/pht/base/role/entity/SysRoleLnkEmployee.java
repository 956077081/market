package com.pht.base.role.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色关联配置(SysRoleLnkEmployee)实体类
 *
 * @author pht
 * @since 2021-03-14 12:30:58
 */
public class SysRoleLnkEmployee implements Serializable {
    private static final long serialVersionUID = -96617102022117617L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 角色类型
    */
    private String roleType;
    /**
    * 员工编号
    */
    private String employeeCode;

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

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}