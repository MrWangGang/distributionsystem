package com.vdong.rms.service.impl;

import com.vdong.rms.common.exception.ProcessException;
import com.vdong.rms.entity.domain.ServiceDO;
import com.vdong.rms.entity.domain.UserDO;
import com.vdong.rms.entity.parameter.ValidatePO;
import com.vdong.rms.entity.template.UserTokenTM;
import com.vdong.rms.entity.validate.GroupRequired;
import com.vdong.rms.repository.dao.ServiceDORepository;
import com.vdong.rms.repository.dao.SystemDORepository;
import com.vdong.rms.repository.dao.SystemServiceDORepository;
import com.vdong.rms.repository.dao.UserDORepository;
import com.vdong.rms.repository.operation.UserTokenTMOperation;
import com.vdong.rms.service.IdentityVerificationService;
import org.lamb.framework.core.util.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.vdong.rms.common.enums.FoundationPropertyEnum.T_SERVICE_ANY;
import static com.vdong.rms.common.enums.FoundationPropertyEnum.T_SERVICE_AUTC;
import static com.vdong.rms.common.enums.FoundationPropertyEnum.T_SERVICE_AUTZ;
import static com.vdong.rms.common.enums.ProcessExceptionEnum.*;
import static com.vdong.rms.common.enums.RedisTMKeyEnum.USER_TOKEN;


/**
 * @description: 身份验证
 * @author: Mr.WangGang
 * @create: 2018-10-17 下午 12:31
 **/
@Service
@Transactional
public class IdentityVerificationServiceImpl implements IdentityVerificationService {
    @Resource
    private UserDORepository userDORepository;

    @Resource
    private SystemDORepository systemDORepository;

    @Resource
    private SystemServiceDORepository systemServiceDORepository;


    @Resource
    private UserTokenTMOperation userTokenTMOperation;

    @Resource
    private ServiceDORepository serviceDORepository;



    @Override
    public void validate(ValidatePO validatePO) {
       ValidatorUtil.validate(validatePO);
        ServiceDO serviceDO = serviceDORepository.findByServiceCode(validatePO.getServiceCode()).orElseThrow(()->new ProcessException(EB00000003));

        Byte serviceStrategy = serviceDO.getServiceStrategy();

        if(T_SERVICE_ANY.getValue().equals(serviceStrategy)){
            //任何人都可以访问
            return;
        }else if(T_SERVICE_AUTC.getValue().equals(serviceStrategy)){
            //需要认证
            UserDO userDO = autc(validatePO);
            legitimateRequestUSS(userDO,serviceDO);
            return;
        }else if(T_SERVICE_AUTZ.getValue().equals(serviceStrategy)){
            //需要授权
            UserDO userDO = autc(validatePO);
            legitimateRequestUSS(userDO,serviceDO);
            autz(userDO,serviceDO);
            return;
        }else{
            throw new ProcessException(EB00000004);
        }
    }

    //认证
    private UserDO autc(ValidatePO validatePO){
        ValidatorUtil.validate(validatePO, GroupRequired.class);
        UserTokenTM userTokenTM = Optional.ofNullable(userTokenTMOperation.getObject(USER_TOKEN.getKey()+ validatePO.getAccessToken())).orElseThrow(()->new ProcessException(EB00000000));
        UserDO userDO = userDORepository.findById(userTokenTM.getUserId()).orElseThrow(()->new ProcessException(EB00000000));
        return userDO;
    }

    //授权
    private void autz(UserDO userDO,ServiceDO serviceDO){
        List<ServiceDO> services =  serviceDORepository.findServiceByUserId(userDO.getUserId()).orElseThrow(()->new ProcessException(EB00000005));
        if (services.stream().noneMatch(e -> serviceDO.getServiceId().compareTo(e.getServiceId()) == 0)){
            throw new ProcessException(EB00000005);
        }
    }
    //合法的用户系统服务之间关系
    private void legitimateRequestUSS(UserDO userDO,ServiceDO serviceDO){
        systemDORepository.findById(userDO.getSystemId()).orElseThrow(()->new ProcessException(EB00000001));
        systemServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElseThrow(()->new ProcessException(EB00000002));
    }
}
