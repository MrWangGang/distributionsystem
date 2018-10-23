package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 删除权限
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 1:10
 **/
@ApiModel(value="删除角色PO",description="删除角色PO")
@Data
public class DeleteRolePO {
    @ApiModelProperty(value="角色ID",name="roleId",example="1")
    private String roleId;
}
