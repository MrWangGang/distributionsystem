package com.vdong.rms.service.impl;

import com.google.common.collect.Lists;
import com.vdong.rms.entity.domain.*;
import com.vdong.rms.entity.domain.supper.SupperDO;
import com.vdong.rms.entity.parameter.*;
import com.vdong.rms.repository.dao.*;
import com.vdong.rms.service.PermissionManageService;
import com.vdong.rms.service.function.OperationFunction;
import org.apache.commons.lang3.StringUtils;
import org.lamb.framework.core.util.BeanPlasticityUtill;
import org.lamb.framework.core.util.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


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

    @Resource
    private RuleRoleDORepository ruleRoleDORepository;

    @Resource
    private RuleDORepository ruleDORepository;

    @Override
    public void operationUser(OperationUserPO operationUserPO) {
        ValidatorUtil.validate(operationUserPO);

        operation(operationUserPO, UserDO.class, userDO -> userDORepository.save(userDO));
    }
    @Override
    public void operationRole(OperationRolePO operationRolePO) {
        ValidatorUtil.validate(operationRolePO);

        operation(operationRolePO, RoleDO.class, roleDO -> roleDORepository.save(roleDO));
    }

    @Override
    public void operationService(OperationServicePO operationServicePO) {
        ValidatorUtil.validate(operationServicePO);

        operation(operationServicePO,ServiceDO.class, serviceDO -> serviceDORepository.save(serviceDO));
    }

    @Override
    public void operationSystem(OperationSystemPO operationSystemPO) {
        ValidatorUtil.validate(operationSystemPO);

        operation(operationSystemPO, SystemDO.class, systemDO -> systemDORepository.save(systemDO));
    }

    @Override
    public void operationRule(OperationRulePO operationRulePO) {
        ValidatorUtil.validate(operationRulePO);

        operation(operationRulePO, RuleDO.class, ruleDO -> ruleDORepository.save(ruleDO));
    }

    @Override
    public void relateUserToRole(RelateUserToRolePO relateUserToRolePO) {
        ValidatorUtil.validate(relateUserToRolePO);

        relateUserToRolePO.getRoleIds().stream().filter(roleId-> StringUtils.isNotBlank(roleId)).forEach((roleId)->{
            UserRoleDO param = new UserRoleDO();
            param.setUserId(Integer.valueOf(relateUserToRolePO.getUserId()));
            param.setRoleId(Integer.valueOf(roleId));

            operation(param,UserRoleDO.class, userRoleDO -> userRoleDORepository.save(userRoleDO));
        });
    }

    @Override
    public void relateRoleToService(RelateRoleToServicePO relateRoleToServicePO) {
        ValidatorUtil.validate(relateRoleToServicePO);

        relateRoleToServicePO.getServiceIds().stream().filter(serviceId-> StringUtils.isNotBlank(serviceId)).forEach((serviceId)->{
            RoleServiceDO param = new RoleServiceDO();
            param.setRoleId(Integer.valueOf(relateRoleToServicePO.getRoleId()));
            param.setServiceId(Integer.valueOf(serviceId));

            operation(param,RoleServiceDO.class, roleServiceDO -> roleServiceDORepository.save(roleServiceDO));

        });
    }


    @Override
    public void relateSystemToService(RelateSystemToServicePO relateSystemToServicePO) {
        ValidatorUtil.validate(relateSystemToServicePO);

        relateSystemToServicePO.getServiceIds().stream().filter(serviceId-> StringUtils.isNotBlank(serviceId)).forEach((serviceId)->{
            SystemServiceDO param = new SystemServiceDO();
            param.setSystemId(Integer.valueOf(relateSystemToServicePO.getSystemId()));
            param.setServiceId(Integer.valueOf(serviceId));

            operation(param,SystemServiceDO.class, systemServiceDO -> systemServiceDORepository.save(systemServiceDO));

        });
    }

    @Override
    public void relateRuleToRole(RelateRuleToRolePO relateRuleToRolePO) {
        ValidatorUtil.validate(relateRuleToRolePO);

        relateRuleToRolePO.getRoleIds().stream().filter(roleId->StringUtils.isNotBlank(roleId)).forEach((roleId)->{
            RuleRoleDO param = new RuleRoleDO();
            param.setRuleId(Integer.valueOf(relateRuleToRolePO.getRuleId()));
            param.setRoleId(Integer.valueOf(roleId));

            operation(relateRuleToRolePO,RuleRoleDO.class, ruleRoleDO -> ruleRoleDORepository.save(ruleRoleDO));

        });
    }

    @Override
    public void deleteUser(DeleteUserPO deleteUserPO) {
        ValidatorUtil.validate(deleteUserPO);
        operation(deleteUserPO,UserDO.class,userDO-> {
                //删除用户与角色关联表
                List<UserRoleDO> userRoleDOList =  userRoleDORepository.findByUserId(userDO.getUserId()).orElse(Lists.newArrayList());
                userRoleDOList.stream().filter(userRoleDO->userRoleDO!=null).forEach((userRoleDO)->{
                    userRoleDORepository.deleteById(userRoleDO.getUserRoleId());
                });
                //删除用户
                userDORepository.deleteById(userDO.getUserId());
            });
    }

    @Override
    public void deleteRole(DeleteRolePO deleteRolePO) {
        ValidatorUtil.validate(deleteRolePO);

        operation(deleteRolePO,RoleDO.class,roleDO-> {
                //删除角色与服务关联表
                List<RoleServiceDO> roleServiceDOList = roleServiceDORepository.findByRoleId(roleDO.getRoleId()).orElse(Lists.newArrayList());
                roleServiceDOList.stream().filter(roleServiceDO->roleServiceDO!=null).forEach((roleServiceDO)->{
                    roleServiceDORepository.deleteById(roleServiceDO.getRoleServiceId());
                });
                //删除规则与角色关联表
                List<RuleRoleDO> ruleRoleDOList = ruleRoleDORepository.findByRoleId(roleDO.getRoleId()).orElse(Lists.newArrayList());
                ruleRoleDOList.stream().filter(ruleRoleDO->ruleRoleDO!=null).forEach((ruleRoleDO)->{
                    ruleRoleDORepository.deleteById(ruleRoleDO.getRuleRoleId());
                });
                //删除角色
                roleDORepository.deleteById(roleDO.getRoleId());
        });
    }

    @Override
    public void deleteService(DeleteServicePO deleteServicePO) {
        ValidatorUtil.validate(deleteServicePO);

        operation(deleteServicePO,ServiceDO.class,serviceDO-> {

                //删除系统与服务关联表
                SystemServiceDO systemServiceDO = systemServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElse(null);
                if(systemServiceDO!=null){
                    systemServiceDORepository.deleteById(systemServiceDO.getSystemServiceId());
                }
                //删除角色与服务关联表
                List<RoleServiceDO> roleServiceDOList = roleServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElse(Lists.newArrayList());
                roleServiceDOList.stream().filter(roleServiceDO->roleServiceDO!=null).forEach((roleServiceDO)->{
                    roleServiceDORepository.deleteById(roleServiceDO.getRoleServiceId());
                });
                //删除服务
                serviceDORepository.deleteById(serviceDO.getServiceId());
        });
    }

    @Override
    public void deleteSystem(DeleteSystemPO deleteSystemPO) {
        ValidatorUtil.validate(deleteSystemPO);

        operation(deleteSystemPO,SystemDO.class,systemDO-> {

                //删除系统与服务关联表
                List<SystemServiceDO> systemServiceDOList = systemServiceDORepository.findBySystemId(systemDO.getSystemId()).orElse(Lists.newArrayList());
                systemServiceDOList.stream().filter(systemServiceDO->systemServiceDO!=null).forEach((systemServiceDO)->{
                    systemServiceDORepository.deleteById(systemServiceDO.getSystemServiceId());
                });
                //删除此系统所绑定所有用户
                List<UserDO> userDOList = userDORepository.findBySystemId(systemDO.getSystemId()).orElse(Lists.newArrayList());
                userDOList.stream().filter(userDO->userDO!=null).forEach((userDO)->{
                    userDORepository.deleteById(userDO.getUserId());
                });
                //删除此系统所绑定的规则
                List<RuleDO> ruleDOList = ruleDORepository.findBySystemId(systemDO.getSystemId()).orElse(Lists.newArrayList());
                ruleDOList.stream().filter(ruleDO->ruleDO!=null).forEach((ruleDO)->{
                    ruleDORepository.deleteById(ruleDO.getRuleId());
                });
                //删除系统
                systemDORepository.deleteById(systemDO.getSystemId());
        });
    }

    @Override
    public void deleteRule(DeleteRulePO deleteRulePO) {
        ValidatorUtil.validate(deleteRulePO);
        operation(deleteRulePO,RuleDO.class,ruleDO-> {

                //删除规则与角色关联表
                List<RuleRoleDO> ruleRoleDOList = ruleRoleDORepository.findByRuleId(ruleDO.getRuleId()).orElse(Lists.newArrayList());
                ruleRoleDOList.stream().filter(ruleRoleDO->ruleRoleDO!=null).forEach((ruleRoleDO)->{
                    ruleRoleDORepository.deleteById(ruleRoleDO.getRuleRoleId());
                });
                //删除规则
                ruleDORepository.deleteById(ruleDO.getRuleId());
        });
    }


    private <T extends Object,DO extends SupperDO,E extends OperationFunction<DO>>void operation(T t, Class<DO> clazz, E e){
        DO domain = BeanPlasticityUtill.copy(clazz,t);
        domain.timeSet();
        e.execute(domain);
    }
}
