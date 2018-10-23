package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 操作角色PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 10:16
 **/
@ApiModel(value="操作角色请求参数",description="操作角色请求参数")
@Data
public class OperationRolePO {

    @ApiModelProperty(value="角色ID",name="roleId",example="1")
    private String roleId;

    @ApiModelProperty(value="角色名称",name="roleName",example="商户")
    @NotBlank
    private String roleName;
}
