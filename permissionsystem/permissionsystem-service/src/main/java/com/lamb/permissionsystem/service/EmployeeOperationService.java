package com.lamb.permissionsystem.service;

import com.lamb.permissionsystem.entity.parameter.FoundationOperationLoginPO;
import com.lamb.permissionsystem.entity.visual.EmployeeAuthTokenVO;

/**
 * @description: 员工操作
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 10:52
 **/
public interface EmployeeOperationService {
    public EmployeeAuthTokenVO login(FoundationOperationLoginPO foundationOperationLoginPO);
}
