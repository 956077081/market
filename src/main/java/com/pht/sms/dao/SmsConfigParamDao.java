package com.pht.sms.dao;

import com.pht.sms.entity.SmsConfigParam;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 短信模板参数(SmsConfigParam)表数据库访问层
 *
 * @author pht
 * @since 2021-03-31 22:54:56
 */
public interface SmsConfigParamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmsConfigParam queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmsConfigParam> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smsConfigParam 实例对象
     * @return 对象列表
     */
    List<SmsConfigParam> queryAll(SmsConfigParam smsConfigParam);

    /**
     * 新增数据
     *
     * @param smsConfigParam 实例对象
     * @return 影响行数
     */
    int insert(SmsConfigParam smsConfigParam);

    /**
     * 修改数据
     *
     * @param smsConfigParam 实例对象
     * @return 影响行数
     */
    int update(SmsConfigParam smsConfigParam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}