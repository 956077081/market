package com.pht.cust.dto;

import com.pht.base.role.dto.MenuParam;
import com.pht.base.role.entity.SysRoleLnkEmployee;
import com.pht.base.role.entity.SysRoleType;
import com.pht.cust.entity.Employee;
import com.pht.cust.entity.User;

import java.util.List;

public class EmployeeResourceParam {
    private Employee employee;
    private User user;
    private String [] sysRoleType;
    private List<MenuParam> menus;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getSysRoleType() {
        return sysRoleType;
    }

    public void setSysRoleType(String[] sysRoleType) {
        this.sysRoleType = sysRoleType;
    }

    public List<MenuParam> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuParam> menus) {
        this.menus = menus;
    }
}
