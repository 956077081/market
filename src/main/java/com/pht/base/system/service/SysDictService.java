package com.pht.base.system.service;

import com.pht.base.system.dao.SysDictDao;
import com.pht.base.system.entity.SysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictService {
    @Autowired
    private SysDictDao sysDictDao;
    public List<SysDict> queryAllDict(){
        return sysDictDao.queryAll();
    }
}
