package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 操作系统PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 10:16
 **/
@ApiModel(value="操作系统请求参数",description="操作系统请求参数")
@Data
public class OperationSystemPO {

    @ApiModelProperty(value="系统ID",name="systemId",example="1")
    private String systemId;

    @ApiModelProperty(value="系统名称",name="systemName",example="学兽")
    @NotBlank
    private String systemName;
}
