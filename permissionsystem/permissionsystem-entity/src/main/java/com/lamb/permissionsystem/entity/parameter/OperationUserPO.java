package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 操作用户PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 10:16
 **/
@ApiModel(value="操作用户请求参数",description="操作用户请求参数")
@Data
public class OperationUserPO {

    @ApiModelProperty(value="用户id",name="userId",example="1")
    private String userId;

    @ApiModelProperty(value="用户名称",name="userName",example="王刚")
    @NotBlank
    private String userName;

    @ApiModelProperty(value="用户标签",name="userTag",example="member_level_1")
    @NotBlank
    private String userTag;


}
