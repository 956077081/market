package com.pht.sms.dao;

import com.pht.sms.entity.SmsParamInst;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 短信特殊参数(SmsParamInst)表数据库访问层
 *
 * @author pht
 * @since 2021-03-31 22:54:41
 */
public interface SmsParamInstDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmsParamInst queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmsParamInst> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smsParamInst 实例对象
     * @return 对象列表
     */
    List<SmsParamInst> queryAll(SmsParamInst smsParamInst);

    /**
     * 新增数据
     *
     * @param smsParamInst 实例对象
     * @return 影响行数
     */
    int insert(SmsParamInst smsParamInst);

    /**
     * 修改数据
     *
     * @param smsParamInst 实例对象
     * @return 影响行数
     */
    int update(SmsParamInst smsParamInst);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}