package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 操作SERVICE PO
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 10:16
 **/
@ApiModel(value="操作服务请求参数",description="操作服务请求参数")
@Data
public class OperationServicePO {

    @ApiModelProperty(value="服务ID",name="serviceId",example="1")
    private String serviceId;

    @ApiModelProperty(value="服务编号",name="serviceCode",example="1")
    @NotBlank
    private String serviceCode;

    @ApiModelProperty(value="服务名称",name="serviceName",example="1")
    @NotBlank
    private String serviceName;

    @ApiModelProperty(value="服务策略-枚举类型 0 任何人访问 1 需要认证 2 需要授权",name="serviceStrategy",example="1")
    @NotBlank
    private String serviceStrategy;
}
