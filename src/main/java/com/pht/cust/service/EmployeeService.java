package com.pht.cust.service;

import com.pht.cust.dto.EmployeeQueryParam;
import com.pht.cust.dto.EmployeeResourceParam;
import com.pht.cust.entity.Employee;
import java.util.List;
import java.util.Map;

/**
 * 员工(Employee)表服务接口
 *
 * @author pht
 * @since 2021-03-14 13:16:31
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    Employee queryByCode(String code);


    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 插入员工（员工以及用户）
     * @param employeeResourceParam
     * @return
     */
    Employee insert(EmployeeResourceParam employeeResourceParam);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteByCode(String code);

    List<Map<String, Object>> queryList(EmployeeQueryParam employeeQueryParam, Integer curPage, Integer pageSize);
}