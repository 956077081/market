package com.pht.sms.dao;

import com.pht.sms.entity.SmsDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SmsDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-04 10:59:44
 */
public interface SmsDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    SmsDetails getByCode(String code);



    /**
     * 通过实体作为筛选条件查询
     *
     * @param smsDetails 实例对象
     * @return 对象列表
     */
    List<SmsDetails> queryAll(SmsDetails smsDetails);

    /**
     * 新增数据
     *
     * @param smsDetails 实例对象
     * @return 影响行数
     */
    int insert(SmsDetails smsDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SmsDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SmsDetails> entities);

    /**
     * 修改数据
     *
     * @param smsDetails 实例对象
     * @return 影响行数
     */
    int update(SmsDetails smsDetails);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

}

