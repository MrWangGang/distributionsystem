package com.lamb.permissionsystem.repository.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 员工表
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 9:57
 **/
@Data
@Entity
@Table(name = "employee")
public class EmployeeDO {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_account")
    private String employeeAccount;

    @Column(name="account_password")
    private String accounPassword;

    @Column(name="create_time")
    private String createTime;

    @Column(name="update_time")
    private String updateTime;
}
