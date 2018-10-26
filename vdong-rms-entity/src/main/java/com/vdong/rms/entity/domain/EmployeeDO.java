package com.vdong.rms.entity.domain;

import com.vdong.rms.entity.domain.supper.SupperDO;
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
public class EmployeeDO  extends SupperDO {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_account")
    private String employeeAccount;

    @Column(name="account_password")
    private String accounPassword;
}
