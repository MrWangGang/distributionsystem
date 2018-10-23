package com.lamb.permissionsystem.service;

import com.lamb.permissionsystem.entity.parameter.*;

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

    //关联操作
    public void relateUserToRole(RelateUserToRolePO relateUserToRolePO);

    public void relateRoleToService(RelateRoleToServicePO relateRoleToServicePO);

    public void relateSystemToService(RelateSystemToServicePO relateSystemToServicePO);

}
