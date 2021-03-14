package com.pht.cust.service.impI;

import com.pht.base.role.entity.SysRoleLnkEmployee;
import com.pht.base.role.entity.SysRoleType;
import com.pht.base.role.service.SysRoleLnkEmployeeService;
import com.pht.common.BizException;
import com.pht.common.CommonResult;
import com.pht.config.utils.PersistentUtil;
import com.pht.cust.constant.CustDict;
import com.pht.cust.dto.EmployeeResourceParam;
import com.pht.cust.entity.Employee;
import com.pht.cust.dao.EmployeeDao;
import com.pht.cust.entity.User;
import com.pht.cust.service.EmployeeService;
import com.pht.cust.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 员工(Employee)表服务实现类
 *
 * @author pht
 * @since 2021-03-14 13:16:31
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private UserService userService;
    @Autowired
    private SysRoleLnkEmployeeService sysRoleLnkEmployeeService;
    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public Employee queryByCode(String  code) {
        return this.employeeDao.queryByCode(code);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeDao.insert(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee insert(@RequestBody EmployeeResourceParam employeeResourceParam) {
        Employee employee =employeeResourceParam.getEmployee();//员工信息
        String [] sysRoleType = employeeResourceParam.getSysRoleType();//角色
        if( employee ==null){
            throw new BizException("创建员工失败！员工信息不全");
        }
        if(StringUtils.isBlank(employee.getCardNum())){
            throw  new BizException("创建员工失败，员工编号不能为空");
        }
        User user = userService.crtUser(employee.getCardNum());//创建用户登录账户
        employee.setUserCode(user.getCode());
        employee.setCustType(CustDict.CUSTTYPE_00);
        employee.setIdType(CustDict.PERIDTYPE_PASSPORT);
        crtEmployee(employee);//创建员工
        List<SysRoleLnkEmployee> list = new ArrayList<>();
        if(sysRoleType !=null){
            for (String roleType : sysRoleType) {
                SysRoleLnkEmployee lnkEmployee = new SysRoleLnkEmployee();
                lnkEmployee.setEmployeeCode(employee.getCode());
                lnkEmployee.setRoleType(roleType);
                lnkEmployee.setCreateTime(new Date());
                list.add(lnkEmployee);
            }
            sysRoleLnkEmployeeService.insertBatch(list);//保存员工角色
        }
        return employee;

    }

    private Employee crtEmployee(Employee employee){
        employee.setCode(PersistentUtil.getBizEntity(Employee.class));
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeDao.update(employee);
        return employee;
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByCode(String code) {
        return this.employeeDao.deleteByCode(code) > 0;
    }
}