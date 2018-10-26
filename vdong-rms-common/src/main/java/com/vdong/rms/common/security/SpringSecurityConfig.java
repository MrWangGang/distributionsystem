package com.vdong.rms.common.security;


import org.lamb.framework.core.config.LambSpringSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.annotation.Resource;

import static com.vdong.rms.common.enums.ApiEnum.IPCMS00001;
import static com.vdong.rms.common.enums.ApiEnum.IPCMS00002;


/**
 * @program: decisionsupportsystem
 * @description: spring权限框架配置
 * @author: Mr.WangGang
 * @create: 2018-08-29 17:08
 **/
@Configuration
public class SpringSecurityConfig extends LambSpringSecurityConfig {


    @Resource
    private AuthTokenReactiveAuthorizationManager authTokenReactiveAuthorizationManager;


    @Override
    public SecurityWebFilterChain strategy(ServerHttpSecurity http) {
        http.authorizeExchange().pathMatchers(IPCMS00001.api()).permitAll();
        http.authorizeExchange().pathMatchers(IPCMS00002.api()).permitAll();
        http.authorizeExchange().anyExchange().access(authTokenReactiveAuthorizationManager);
        return http.build();
    }
}
