package com.vdong.rms.service.impl;

import com.vdong.rms.common.exception.ProcessException;
import com.vdong.rms.entity.domain.EmployeeDO;
import com.vdong.rms.entity.parameter.LoginPO;
import com.vdong.rms.entity.visual.EmployeeAuthTokenVO;
import com.vdong.rms.repository.dao.EmployeeDORepository;
import com.vdong.rms.service.EmployeeOperationService;
import org.lamb.framework.core.util.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static com.vdong.rms.common.enums.ProcessExceptionEnum.EB00000006;

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
