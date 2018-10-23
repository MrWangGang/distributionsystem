package com.lamb.permissionsystem.entity.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: 员工登录接口-请求参数
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 11:27
 **/
@ApiModel(value="员工登录接口请求参数",description="员工登录接口请求参数")
@Data
public class LoginPO implements Serializable {
    @ApiModelProperty(value="员工账号",name="employeeAccount",example="admin@vdong.com")
    @NotBlank
    private String employeeAccount;
    @ApiModelProperty(value="员工账号的密码",name="accountPassword",example="Ww778899321")
    @NotBlank
    private String accountPassword;
}
