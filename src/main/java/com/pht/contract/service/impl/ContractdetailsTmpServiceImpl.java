package com.pht.contract.service.impl;

import com.pht.config.utils.PersistentUtil;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.entity.ContractdetailsTmp;
import com.pht.contract.dao.ContractdetailsTmpDao;
import com.pht.contract.service.ContractdetailsTmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * contractdetails_tmp(ContractdetailsTmp)表服务实现类
 *
 * @author makejava
 * @since 2021-02-27 11:30:13
 */
@Service("contractdetailsTmpService")
public class ContractdetailsTmpServiceImpl implements ContractdetailsTmpService {
    @Resource
    private ContractdetailsTmpDao contractdetailsTmpDao;

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public ContractdetailsTmp getByCode(String code) {
        return this.contractdetailsTmpDao.getByCode(code);
    }


    /**
     * 新增数据
     *
     * @param contractdetailsTmp 实例对象
     * @return 实例对象
     */
    @Override
    public ContractdetailsTmp insert(ContractdetailsTmp contractdetailsTmp) {
        this.contractdetailsTmpDao.insert(contractdetailsTmp);
        return contractdetailsTmp;
    }

    /**
     * 修改数据
     *
     * @param contractdetailsTmp 实例对象
     * @return 实例对象
     */
    @Override
    public ContractdetailsTmp update(ContractdetailsTmp contractdetailsTmp) {
        this.contractdetailsTmpDao.update(contractdetailsTmp);
        return this.getByCode(contractdetailsTmp.getCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByCode(String code) {
        return this.contractdetailsTmpDao.deleteByCode(code) > 0;
    }

    @Override
    public void crtContractTmp(Contractdetails contractdetails, String operate) {
        ContractdetailsTmp contractdetailsTmp = new ContractdetailsTmp();//合同临时表
        BeanUtils.copyProperties(contractdetails, contractdetailsTmp);
        contractdetailsTmp.setCode(PersistentUtil.getBizEntity(ContractdetailsTmp.class));
        contractdetailsTmp.setContractCode(contractdetails.getCode());
        contractdetailsTmp.setOperate(operate);
        contractdetailsTmp.setCreateTime(new Date());
        contractdetailsTmp.setUpdateTime(new Date());
        this.insert(contractdetailsTmp);
    }
}
