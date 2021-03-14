package com.pht.base.role.service;

import com.pht.base.role.dao.SysRoleLnkEmployeeDao;
import com.pht.base.role.entity.SysRoleLnkEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleLnkEmployeeService {
    @Autowired
    private SysRoleLnkEmployeeDao sysRoleLnkEmployeeDao;

    public int insert(SysRoleLnkEmployee sysRoleLnkEmployee){
       return sysRoleLnkEmployeeDao.insert(sysRoleLnkEmployee);
    }
    public int insertBatch(List<SysRoleLnkEmployee> sysRoleLnkEmployees){
         return sysRoleLnkEmployeeDao.insertBatch(sysRoleLnkEmployees);
    }
}
