package com.vdong.rms.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @description: 将角色与服务联系PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 11:17
 **/
@ApiModel(value="将角色与服务联系PO",description="将角色与服务联系PO")
@Data
public class RelateRoleToServicePO {

    @ApiModelProperty(value="角色ID",name="roleId",example="1")
    @NotBlank
    private String roleId;

    @ApiModelProperty(value="服务ID集合",name="serviceIds",example="{[1],[2]}")
    @NotEmpty
    private List<String> serviceIds;
}
