package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 删除系统
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 1:11
 **/
@ApiModel(value="删除系统PO",description="删除系统PO")
@Data
public class DeleteSystemPO {
    @ApiModelProperty(value="系统ID",name="systemId",example="1")
    private String systemId;
}
