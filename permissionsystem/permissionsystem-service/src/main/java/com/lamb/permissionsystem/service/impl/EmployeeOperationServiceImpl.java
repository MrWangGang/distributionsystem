package com.lamb.permissionsystem.service.impl;

import com.lamb.permissionsystem.entity.parameter.FoundationOperationLoginPO;
import com.lamb.permissionsystem.entity.visual.EmployeeAuthTokenVO;
import com.lamb.permissionsystem.service.EmployeeOperationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @description: 员工操作
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 11:43
 **/
@Service
@Transactional
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

    @Override
    public EmployeeAuthTokenVO login(FoundationOperationLoginPO foundationOperationLoginPO) {
        return new EmployeeAuthTokenVO();
    }
}
