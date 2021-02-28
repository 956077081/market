package com.pht.contract.service.impl;

import com.pht.contract.entity.ContractdetailsTmp;
import com.pht.contract.dao.ContractdetailsTmpDao;
import com.pht.contract.service.ContractdetailsTmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public ContractdetailsTmp queryByCode(String code) {
        return this.contractdetailsTmpDao.queryByCode(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ContractdetailsTmp> queryAllByLimit(int offset, int limit) {
        return this.contractdetailsTmpDao.queryAllByLimit(offset, limit);
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
        return this.queryByCode(contractdetailsTmp.getCode());
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
}
