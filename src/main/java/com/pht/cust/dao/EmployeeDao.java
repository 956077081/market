package com.pht.cust.dao;

import com.pht.cust.entity.Employee;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 员工(Employee)表数据库访问层
 *
 * @author pht
 * @since 2021-03-14 13:16:31
 */
public interface EmployeeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    Employee queryByCode(@Param("code") String code);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    List<Employee> queryAll(Employee employee);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteByCode(String code);

}