package com.lamb.permissionsystem.common.enums;

import lombok.Getter;
import lombok.Setter;

public enum FoundationPropertyEnum {

    //service表-service_strategy字段->服务策略  0 任何人都可以访问 1 需要认证 2 需要授权
    ANY(new Byte("0")),
    AUTC(new Byte("1")),
    AUTZ(new Byte("2"));


    @Getter
    @Setter
    private Byte value;

    FoundationPropertyEnum(Byte value) {
        this.value = value;
    }
}
