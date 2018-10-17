package com.lamb.permissionsystem.common.security;

import org.lamb.lambframework.core.config.LambSpringSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import static com.lamb.permissionsystem.common.enums.ApiEnum.IPCMS00001;


/**
 * @program: decisionsupportsystem
 * @description: spring权限框架配置
 * @author: Mr.WangGang
 * @create: 2018-08-29 17:08
 **/

@Configuration
public class SpringSecurityConfig extends LambSpringSecurityConfig {

    @Override
    public ServerHttpSecurity.AuthorizeExchangeSpec strategy(ServerHttpSecurity.AuthorizeExchangeSpec authorizeExchangeSpec) {
        authorizeExchangeSpec.pathMatchers(IPCMS00001.api()).permitAll();
        return authorizeExchangeSpec;
    }
}
