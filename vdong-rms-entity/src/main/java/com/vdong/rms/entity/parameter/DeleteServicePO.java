package com.vdong.rms.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 删除服务
 * @author: Mr.WangGang
 * @create: 2018-10-23 下午 1:10
 **/
@ApiModel(value="删除服务PO",description="删除服务PO")
@Data
public class DeleteServicePO {
    @ApiModelProperty(value="服务ID",name="serviceId",example="1")
    private String serviceId;
}
