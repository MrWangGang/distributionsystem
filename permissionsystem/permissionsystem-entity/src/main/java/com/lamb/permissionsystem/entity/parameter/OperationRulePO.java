package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 操作规则
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 2:23
 **/
@ApiModel(value="操作规则PO",description="操作规则PO")
@Data
public class OperationRulePO {

    @ApiModelProperty(value="规则ID",name="ruleId",example="1")
    private String ruleId;

    @ApiModelProperty(value="规则名称",name="ruleName",example="XXX系统XXX默认规则")
    @NotBlank
    private String ruleName;

    @ApiModelProperty(value="绑定的用户标签",name="userTag",example="member_level_1")
    @NotBlank
    private String userTag;

    @ApiModelProperty(value="绑定的系统ID",name="systemId",example="1")
    @NotBlank
    private String systemId;
}
