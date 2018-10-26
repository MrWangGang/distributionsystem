package com.vdong.rms.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 删除用户
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 1:10
 **/
@ApiModel(value="删除用户PO",description="删除用户PO")
@Data
public class DeleteUserPO {
    @ApiModelProperty(value="用户ID",name="userId",example="1")
    @NotBlank
    private String userId;
}
