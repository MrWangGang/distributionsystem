package com.vdong.rms.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @description: 接口
 * @author: Mr.WangGang
 * @create: 2018-10-17 下午 12:50
 **/
public enum  ApiEnum {
    // I 意味着这是一个接口   P  权限   C 控制   M  管理  S 系统 ->权限系统接口
     IPCMS00001("/IPCMS00001"),//身份认证
     IPCMS00002("/IPCMS00002");//员工登录

    @Getter
    @Setter
    private String api;

    ApiEnum(String api) {
        this.api=api;
    }

    public String api(){
        return api;
    }
}
