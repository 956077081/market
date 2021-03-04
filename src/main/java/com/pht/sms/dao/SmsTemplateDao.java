package com.pht.sms.dao;

import com.pht.sms.entity.SmsTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SmsTemplate)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-04 11:05:50
 */
public interface SmsTemplateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    SmsTemplate getByCode(String code);



    /**
     * 通过实体作为筛选条件查询
     *
     * @param smsTemplate 实例对象
     * @return 对象列表
     */
    List<SmsTemplate> queryAll(SmsTemplate smsTemplate);

    /**
     * 新增数据
     *
     * @param smsTemplate 实例对象
     * @return 影响行数
     */
    int insert(SmsTemplate smsTemplate);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SmsTemplate> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SmsTemplate> entities);

    /**
     * 修改数据
     *
     * @param smsTemplate 实例对象
     * @return 影响行数
     */
    int update(SmsTemplate smsTemplate);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

}

