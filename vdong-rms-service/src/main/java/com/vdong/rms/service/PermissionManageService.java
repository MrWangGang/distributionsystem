package com.vdong.rms.service;


import com.vdong.rms.entity.parameter.*;

/**
 * @description: 权限管理
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 9:47
 **/
public interface PermissionManageService {

    //操作
    // - 新建和更新
    public void operationUser(OperationUserPO operationUserPO);

    public void operationRole(OperationRolePO operationRolePO);

    public void operationService(OperationServicePO operationServicePO);

    public void operationSystem(OperationSystemPO operationSystemPO);

    public void operationRule(OperationRulePO operationRulePO);

    //-关联操作
    public void relateUserToRole(RelateUserToRolePO relateUserToRolePO);

    public void relateRoleToService(RelateRoleToServicePO relateRoleToServicePO);

    public void relateSystemToService(RelateSystemToServicePO relateSystemToServicePO);

    public void relateRuleToRole(RelateRuleToRolePO relateRuleToRolePO);

    //-删除操作
    public void deleteUser(DeleteUserPO deleteUserPO);

    public void deleteRole(DeleteRolePO deleteRolePO);

    public void deleteService(DeleteServicePO deleteServicePO);

    public void deleteSystem(DeleteSystemPO deleteSystemPO);

    public void deleteRule(DeleteRulePO deleteRulePO);
}
