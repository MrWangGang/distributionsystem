package com.vdong.rms.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @description: 将用户与角色联系PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 11:17
 **/
@ApiModel(value="将用户与角色联系PO",description="将用户与角色联系PO")
@Data
public class RelateUserToRolePO {
    @ApiModelProperty(value="用户ID",name="userId",example="1")
    @NotBlank
    private String userId;

    @ApiModelProperty(value="角色ID集合",name="roleIds",example="{[1],[2]}")
    @NotEmpty
    private List<String> roleIds;
}
