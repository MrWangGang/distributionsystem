package com.lamb.permissionsystem.service.impl;

import com.lamb.permissionsystem.entity.domain.*;
import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import com.lamb.permissionsystem.entity.parameter.*;
import com.lamb.permissionsystem.repository.dao.repository.*;
import com.lamb.permissionsystem.service.PermissionManageService;
import com.lamb.permissionsystem.service.function.OperationFunction;
import org.apache.commons.lang3.StringUtils;
import org.lamb.lambframework.core.util.BeanPlasticityUtill;
import org.lamb.lambframework.core.util.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @description: 权限管理
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 9:47
 **/
@Service
@Transactional
public class PermissionManageServiceImpl implements PermissionManageService {

    @Resource
    private UserDORepository userDORepository;

    @Resource
    private RoleDORepository roleDORepository;

    @Resource
    private ServiceDORepository serviceDORepository;

    @Resource
    private SystemDORepository systemDORepository;

    @Resource
    private UserRoleDORepository userRoleDORepository;

    @Resource
    private RoleServiceDORepository roleServiceDORepository;

    @Resource
    private SystemServiceDORepository systemServiceDORepository;


    @Override
    public void operationUser(OperationUserPO operationUserPO) {
        ValidatorUtil.validate(operationUserPO);

        operation(operationUserPO, UserDO.class, new OperationFunction<UserDO>() {
            @Override
            public void execute(UserDO userDO) {
                userDORepository.save(userDO);
            }
        });
    }
    @Override
    public void operationRole(OperationRolePO operationRolePO) {
        ValidatorUtil.validate(operationRolePO);

        operation(operationRolePO, RoleDO.class, new OperationFunction<RoleDO>() {
            @Override
            public void execute(RoleDO roleDO) {
                roleDORepository.save(roleDO);
            }
        });
    }

    @Override
    public void operationService(OperationServicePO operationServicePO) {
        ValidatorUtil.validate(operationServicePO);

        operation(operationServicePO, ServiceDO.class, new OperationFunction<ServiceDO>() {
            @Override
            public void execute(ServiceDO serviceDO) {
                serviceDORepository.save(serviceDO);
            }
        });
    }

    @Override
    public void operationSystem(OperationSystemPO operationSystemPO) {
        ValidatorUtil.validate(operationSystemPO);

        operation(operationSystemPO, SystemDO.class, new OperationFunction<SystemDO>() {
            @Override
            public void execute(SystemDO systemDO) {
                systemDORepository.save(systemDO);
            }
        });
    }

    @Override
    public void relateUserToRole(RelateUserToRolePO relateUserToRolePO) {
        ValidatorUtil.validate(relateUserToRolePO);

        relateUserToRolePO.getRoleIds().stream().filter(roleId-> StringUtils.isNotBlank(roleId)).forEach((roleId)->{
            UserRoleDO userRoleDO = new UserRoleDO();
            userRoleDO.setUserId(Integer.valueOf(relateUserToRolePO.getUserId()));
            userRoleDO.setRoleId(Integer.valueOf(roleId));

            operation(userRoleDO,UserRoleDO.class, new OperationFunction<UserRoleDO>() {
                @Override
                public void execute(UserRoleDO userRoleDO) {
                    userRoleDORepository.save(userRoleDO);
                }
            });
        });
    }

    @Override
    public void relateRoleToService(RelateRoleToServicePO relateRoleToServicePO) {
        ValidatorUtil.validate(relateRoleToServicePO);

        relateRoleToServicePO.getServiceIds().stream().filter(serviceId-> StringUtils.isNotBlank(serviceId)).forEach((serviceId)->{
            RoleServiceDO roleServiceDO = new RoleServiceDO();
            roleServiceDO.setRoleId(Integer.valueOf(relateRoleToServicePO.getRoleId()));
            roleServiceDO.setServiceId(Integer.valueOf(serviceId));

            operation(roleServiceDO,RoleServiceDO.class, new OperationFunction<RoleServiceDO>() {
                @Override
                public void execute(RoleServiceDO roleServiceDO) {
                    roleServiceDORepository.save(roleServiceDO);
                }
            });
        });
    }


    @Override
    public void relateSystemToService(RelateSystemToServicePO relateSystemToServicePO) {
        ValidatorUtil.validate(relateSystemToServicePO);

        relateSystemToServicePO.getServiceIds().stream().filter(serviceId-> StringUtils.isNotBlank(serviceId)).forEach((serviceId)->{
            SystemServiceDO systemServiceDO = new SystemServiceDO();
            systemServiceDO.setSystemId(Integer.valueOf(relateSystemToServicePO.getSystemId()));
            systemServiceDO.setServiceId(Integer.valueOf(serviceId));

            operation(systemServiceDO,SystemServiceDO.class, new OperationFunction<SystemServiceDO>() {
                @Override
                public void execute(SystemServiceDO systemServiceDO) {
                    systemServiceDORepository.save(systemServiceDO);
                }
            });
        });
    }


    private <T extends Object,DO extends SupperDO,E extends OperationFunction<DO>>void operation(T t,Class<DO> clazz,E e){
        DO domain = BeanPlasticityUtill.copy(clazz,t);
        domain.timeSet();
        e.execute(domain);
    }
}
