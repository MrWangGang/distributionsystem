package com.lamb.permissionsystem.repository.enums;

import lombok.Getter;
import lombok.Setter;

public enum RedisTMKeyEnum {


    USER_TOKEN("user.token.id.");

    // 成员变量
    @Getter
    @Setter
    public String key;

    RedisTMKeyEnum(String s) {
        this.key = s;
    }
}
