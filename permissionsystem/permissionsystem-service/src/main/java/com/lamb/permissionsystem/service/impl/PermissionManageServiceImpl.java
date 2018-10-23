package com.lamb.permissionsystem.service.impl;

import com.google.common.collect.Lists;
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
    public void operationRule(OperationRulePO operationRulePO) {
        ValidatorUtil.validate(operationRulePO);

        operation(operationRulePO, RuleDO.class, new OperationFunction<RuleDO>() {
            @Override
            public void execute(RuleDO ruleDO) {
                ruleDORepository.save(ruleDO);
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

    @Override
    public void relateRuleToRole(RelateRuleToRolePO relateRuleToRolePO) {
        ValidatorUtil.validate(relateRuleToRolePO);

        relateRuleToRolePO.getRoleIds().stream().filter(roleId->StringUtils.isNotBlank(roleId)).forEach((roleId)->{
            RuleRoleDO ruleRoleDO = new RuleRoleDO();
            ruleRoleDO.setRuleId(Integer.valueOf(relateRuleToRolePO.getRuleId()));
            ruleRoleDO.setRoleId(Integer.valueOf(roleId));

            operation(relateRuleToRolePO,RuleRoleDO.class, new OperationFunction<RuleRoleDO>() {
                @Override
                public void execute(RuleRoleDO ruleRoleDO) {
                    ruleRoleDORepository.save(ruleRoleDO);
                }
            });
        });
    }

    @Override
    public void deleteUser(DeleteUserPO deleteUserPO) {
        ValidatorUtil.validate(deleteUserPO);

        operation(deleteUserPO,UserDO.class, new OperationFunction<UserDO>() {
            @Override
            public void execute(UserDO userDO) {
                //删除用户与角色关联表
                List<UserRoleDO> userRoleDOList =  userRoleDORepository.findByUserId(userDO.getUserId()).orElse(Lists.newArrayList());
                userRoleDOList.stream().filter(e->e!=null).forEach((e)->{
                    userRoleDORepository.deleteById(e.getUserRoleId());
                });
                //删除用户
                userDORepository.deleteById(userDO.getUserId());
            }
        });
    }

    @Override
    public void deleteRole(DeleteRolePO deleteRolePO) {
        ValidatorUtil.validate(deleteRolePO);

        operation(deleteRolePO,RoleDO.class, new OperationFunction<RoleDO>() {
            @Override
            public void execute(RoleDO roleDO) {
                //删除角色与服务关联表
                List<RoleServiceDO> roleServiceDOList = roleServiceDORepository.findByRoleId(roleDO.getRoleId()).orElse(Lists.newArrayList());
                roleServiceDOList.stream().filter(e->e!=null).forEach((e)->{
                    roleServiceDORepository.deleteById(e.getRoleServiceId());
                });
                //删除规则与角色关联表
                List<RuleRoleDO> ruleRoleDOList = ruleRoleDORepository.findByRoleId(roleDO.getRoleId()).orElse(Lists.newArrayList());
                ruleRoleDOList.stream().filter(e->e!=null).forEach((e)->{
                    ruleRoleDORepository.deleteById(e.getRuleRoleId());
                });
                //删除角色
                roleDORepository.deleteById(roleDO.getRoleId());
            }
        });
    }

    @Override
    public void deleteService(DeleteServicePO deleteServicePO) {
        ValidatorUtil.validate(deleteServicePO);

        operation(deleteServicePO,ServiceDO.class, new OperationFunction<ServiceDO>() {
            @Override
            public void execute(ServiceDO serviceDO) {
                //删除系统与服务关联表
                SystemServiceDO systemServiceDO = systemServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElse(null);
                if(systemServiceDO!=null){
                    systemServiceDORepository.deleteById(systemServiceDO.getSystemServiceId());
                }
                //删除角色与服务关联表
                List<RoleServiceDO> roleServiceDOList = roleServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElse(Lists.newArrayList());
                roleServiceDOList.stream().filter(e->e!=null).forEach((e)->{
                    roleServiceDORepository.deleteById(e.getRoleServiceId());
                });
                //删除服务
                serviceDORepository.deleteById(serviceDO);
            }
        });
    }

    @Override
    public void deleteSystem(DeleteSystemPO deleteSystemPO) {
        ValidatorUtil.validate(deleteSystemPO);

        operation(deleteSystemPO,SystemDO.class, new OperationFunction<SystemDO>() {
            @Override
            public void execute(SystemDO systemDO) {
                //删除系统与服务关联表
                List<SystemServiceDO> systemServiceDOList = systemServiceDORepository.findBySystemId(systemDO.getSystemId()).orElse(Lists.newArrayList());
                systemServiceDOList.stream().filter(e->e!=null).forEach((e)->{
                    systemServiceDORepository.deleteById(e.getSystemServiceId());
                });
                //删除此系统所绑定所有用户
                List<UserDO> userDOList = userDORepository.findBySystemId(systemDO.getSystemId()).orElse(Lists.newArrayList());
                userDOList.stream().filter(e->e!=null).forEach((e)->{
                    userDORepository.deleteById(e.getUserId());
                });
                //删除此系统所绑定的规则
                List<RuleDO> ruleDOList = ruleDORepository.findBySystemId(systemDO.getSystemId()).orElse(Lists.newArrayList());
                ruleDOList.stream().filter(e->e!=null).forEach((e)->{
                    ruleDORepository.deleteById(e.getRuleId());
                });
                //删除系统
                systemDORepository.deleteById(systemDO.getSystemId());
            }
        });
    }

    @Override
    public void deleteRule(DeleteRulePO deleteRulePO) {
        ValidatorUtil.validate(deleteRulePO);
        operation(deleteRulePO,RuleDO.class, new OperationFunction<RuleDO>() {
            @Override
            public void execute(RuleDO ruleDO) {
                //删除规则与角色关联表
                List<RuleRoleDO> ruleRoleDOList = ruleRoleDORepository.findByRuleId(ruleDO.getRuleId()).orElse(Lists.newArrayList());
                ruleRoleDOList.stream().filter(e->e!=null).forEach((e)->{
                    ruleRoleDORepository.deleteById(e.getRuleRoleId());
                });
                //删除规则
                ruleDORepository.deleteById(ruleDO.getRuleId());
            }
        });
    }


    private <T extends Object,DO extends SupperDO,E extends OperationFunction<DO>>void operation(T t,Class<DO> clazz,E e){
        DO domain = BeanPlasticityUtill.copy(clazz,t);
        domain.timeSet();
        e.execute(domain);
    }
}
