package com.lamb.permissionsystem.common.security;

import com.lamb.permissionsystem.common.exception.ProcessException;
import com.lamb.permissionsystem.repository.dao.operation.EmployeeTMOperation;
import com.lamb.permissionsystem.repository.dao.repository.EmployeeDORepository;
import com.lamb.permissionsystem.repository.entity.domain.EmployeeDO;
import com.lamb.permissionsystem.repository.entity.template.EmployeeTM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Optional;

import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.EB00000000;
import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.EI00000002;
import static com.lamb.permissionsystem.common.enums.RedisTMKeyEnum.EMPLOYEE_TOKEN;


/**
 * @program: decisionsupportsystem
 * @description: token 认证管理器
 * @author: Mr.WangGang
 * @create: 2018-08-30 18:56
 **/
@Component
public class AuthTokenServerSecurityContextRepository implements ServerSecurityContextRepository {

    @Resource
    private EmployeeTMOperation employeeTMOperation;

    @Resource
    private EmployeeDORepository employeeDORepository;

    @Override
    public Mono<Void> save(ServerWebExchange serverWebExchange, SecurityContext securityContext) {
        //不知道这是什么
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange serverWebExchange) {
        ServerHttpRequest request =  serverWebExchange.getRequest();
        String authToken  = request.getHeaders().getFirst("authToken");
        if(StringUtils.isBlank(authToken)){
            throw new ProcessException(EI00000002);
        }

        EmployeeTM employeeTM = Optional.ofNullable(employeeTMOperation.getObject(EMPLOYEE_TOKEN.getKey()+authToken)).orElseThrow(()->new ProcessException(EB00000000));

        EmployeeDO employeeDO = employeeDORepository.findById(employeeTM.getEmployeeId()).orElseThrow(()->new ProcessException(EB00000000));

        Authentication authentication = new UsernamePasswordAuthenticationToken(employeeDO,authToken,null);

        return Mono.just(new SecurityContextImpl(authentication));
    }
}
