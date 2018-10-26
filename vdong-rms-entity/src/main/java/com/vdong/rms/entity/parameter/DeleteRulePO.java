package com.vdong.rms.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 删除规则PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 2:41
 **/
@ApiModel(value="删除规则PO",description="删除规则PO")
@Data
public class DeleteRulePO {
    @ApiModelProperty(value="规则ID",name="ruleId",example="1")
    @NotBlank
    private String ruleId;
}
