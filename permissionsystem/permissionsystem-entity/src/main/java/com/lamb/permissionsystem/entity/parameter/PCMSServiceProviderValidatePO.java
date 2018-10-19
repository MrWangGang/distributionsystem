package com.lamb.permissionsystem.entity.parameter;

import com.lamb.permissionsystem.entity.validate.GroupRequired;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @description: 对外服务身份验证请求参数
 * @author: Mr.WangGang
 * @create: 2018-10-19 下午 5:12
 **/
@ApiModel(value="对外服务身份验证请求参数",description="对外服务身份验证请求参数")
@Data
public class PCMSServiceProviderValidatePO implements Serializable {
    @ApiModelProperty(value="服务编号",name="serviceCode",example="IPCMS00001")
    @NotEmpty
    private String serviceCode;

    @ApiModelProperty(value="访问令牌",name="accessToken",example="58D06DCB914C009354781E55D15DA9EE")
    @NotEmpty(groups = GroupRequired.class)
    private String accessToken;
}
