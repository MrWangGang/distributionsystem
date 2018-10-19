package com.lamb.permissionsystem.repository.entity.template;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 员工REDIS实体类
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 10:11
 **/
@Data
public class EmployeeTM implements Serializable {
    private Integer employeeId;

    private String authToken;
}
