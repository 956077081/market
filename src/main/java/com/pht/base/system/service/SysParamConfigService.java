package com.pht.base.system.service;

import com.pht.base.system.dao.SysParamConfigDao;
import com.pht.base.system.entity.SysParamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysParamConfigService {
    @Autowired
    private SysParamConfigDao sysParamConfigDao;

    /**
     * 查询所有的
     * @return
     */
    public List<SysParamConfig> queryAll(){
       return sysParamConfigDao.queryAll();
    }
}
