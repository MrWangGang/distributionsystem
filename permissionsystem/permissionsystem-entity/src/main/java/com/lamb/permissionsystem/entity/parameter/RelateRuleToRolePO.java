package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @description: 绑定规则与角色PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 2:39
 **/
@ApiModel(value="绑定规则与角色PO",description="绑定规则与角色PO")
@Data
public class RelateRuleToRolePO {
    @ApiModelProperty(value="规则ID",name="ruleId",example="1")
    @NotBlank
    private String ruleId;

    @ApiModelProperty(value="角色ID集合",name="roleIds",example="{[1],[2]}")
    @NotEmpty
    private List<String> roleIds;
}
