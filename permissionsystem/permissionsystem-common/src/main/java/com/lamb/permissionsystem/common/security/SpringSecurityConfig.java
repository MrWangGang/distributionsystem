package com.lamb.permissionsystem.common.security;

import org.lamb.lambframework.core.security.LambServerAccessDeniedHandler;
import org.lamb.lambframework.core.security.LambServerAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.annotation.Resource;


/**
 * @program: decisionsupportsystem
 * @description: spring权限框架配置
 * @author: Mr.WangGang
 * @create: 2018-08-29 17:08
 **/
@Configuration
public class SpringSecurityConfig  {

    @Resource
    private LambServerAccessDeniedHandler lambServerAccessDeniedHandler;

    @Resource
    private LambServerAuthenticationEntryPoint lambServerAuthenticationEntryPoint;

    @Resource
    private AuthTokenServerSecurityContextRepository authTokenServerSecurityContextRepository;

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();
        http.headers().disable();
        http.requestCache().disable();
        http.securityContextRepository(authTokenServerSecurityContextRepository);
        http.exceptionHandling().authenticationEntryPoint(lambServerAuthenticationEntryPoint);
        http.exceptionHandling().accessDeniedHandler(lambServerAccessDeniedHandler);
        http.authorizeExchange().anyExchange().authenticated();

        return http.build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService(final PasswordEncoder passwordEncoder) {

        UserDetails user = User
                .withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        return new MapReactiveUserDetailsService(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

