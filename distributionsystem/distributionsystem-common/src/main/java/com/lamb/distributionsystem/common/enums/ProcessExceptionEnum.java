package com.lamb.distributionsystem.common.enums;

/**
 * Created by WangGang on 2017/6/22 0022.
 * E-mail userbean@outlook.com
 * The final interpretation of this procedure is owned by the author
 */
public enum ProcessExceptionEnum {
    EB00000000("EB00000000","无效认证,请先登陆"),
    EB00000001("EB00000001","token失效,请重写登陆"),
    EB00000002("EB00000002","授权失败,不存在此用户"),
    EB00000003("EB00000003","refresh_token 缺少"),
    EB00000004("EB00000004","找不到指定的解析方法"),
    EB00000005("EB00000005","第三方接口->业务处理失败"),
    EB00000006("EB00000006","解析第三方接口返回数据失败"),
    EB00000007("EB00000007","调用第三方接口失败");


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
