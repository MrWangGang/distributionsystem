package com.lamb.permissionsystem.service.impl;

import com.lamb.permissionsystem.common.exception.ProcessException;
import com.lamb.permissionsystem.entity.domain.EmployeeDO;
import com.lamb.permissionsystem.entity.parameter.LoginPO;
import com.lamb.permissionsystem.entity.visual.EmployeeAuthTokenVO;
import com.lamb.permissionsystem.repository.dao.repository.EmployeeDORepository;
import com.lamb.permissionsystem.service.EmployeeOperationService;
import org.lamb.lambframework.core.util.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.EB00000006;

/**
 * @description: 员工操作
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 11:43
 **/
@Service
@Transactional
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

    @Resource
    private EmployeeDORepository employeeDORepository;

    @Override
    public EmployeeAuthTokenVO login(LoginPO loginPO) {
        ValidatorUtil.validate(loginPO);
        EmployeeDO employeeDO = employeeDORepository.findByEmployeeAccount(loginPO.getEmployeeAccount()).orElseThrow(()->new ProcessException(EB00000006));
        if(!loginPO.getAccountPassword().equals(employeeDO.getAccounPassword())){
            throw new ProcessException(EB00000006);
        }
        EmployeeAuthTokenVO employeeAuthTokenVO = new EmployeeAuthTokenVO();
        employeeAuthTokenVO.setAuthToken("TEST_ACCESS_TOKEN");
        return employeeAuthTokenVO;
    }
}
