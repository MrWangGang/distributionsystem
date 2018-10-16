package com.lamb.permissionsystem.common.enums;

/**
 * Created by WangGang on 2017/6/22 0022.
 * E-mail userbean@outlook.com
 * The final interpretation of this procedure is owned by the author
 */
public enum ProcessExceptionEnum {
    EB00000000("EB00000000","认证失败,不存在此用户或者token失效！请重新登录"),
    EB00000001("EB00000001","此用户未绑定任何系统"),
    EB00000002("EB00000002","此服务未绑定到用户所属的系统"),
    EB00000003("EB00000003","此服务未注册到权限系统"),
    EB00000004("EB00000004","此服务未配置正确的策略"),


    EI00000000("EI00000000","接口参数缺少accessToken"),
    EI00000001("EI00000001","接口参数缺少serviceCode");




    // 成员变量
    private String code;

    private String message;
    // 构造方法
    private ProcessExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;

    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
