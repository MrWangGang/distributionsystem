package com.vdong.rms.repository.dao;


import com.vdong.rms.entity.domain.EmployeeDO;
import org.lamb.framework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @description: 员工表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 10:00
 **/
public interface EmployeeDORepository extends LambDORepository<EmployeeDO> {

    @Query(nativeQuery = true,value =
            "select " +
                    "employees.* " +
                    "FROM employee employees " +
                    "where employees.employee_account = ?1"
    )
    public Optional<EmployeeDO> findByEmployeeAccount(String employeeAccount);
}
