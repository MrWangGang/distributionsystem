package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @description: 将系统与服务联系
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 11:17
 **/
@ApiModel(value="将系统与服务联系PO",description="将系统与服务联系")
@Data
public class RelateSystemToServicePO {
    @ApiModelProperty(value="系统ID",name="systemId",example="1")
    @NotBlank
    private String systemId;

    @ApiModelProperty(value="服务ID集合",name="serviceIds",example="{[1],[2]}")
    @NotEmpty
    private List<String> serviceIds;
}
