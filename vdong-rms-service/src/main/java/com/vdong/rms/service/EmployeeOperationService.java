package com.vdong.rms.service;

import com.vdong.rms.entity.parameter.LoginPO;
import com.vdong.rms.entity.visual.EmployeeAuthTokenVO;


/**
 * @description: 员工操作
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 10:52
 **/
public interface EmployeeOperationService {
    public EmployeeAuthTokenVO login(LoginPO loginPO);
}
