package com.lamb.permissionsystem.common.security;

import com.lamb.permissionsystem.common.exception.ProcessException;
import com.lamb.permissionsystem.entity.domain.EmployeeDO;
import com.lamb.permissionsystem.entity.template.EmployeeTM;
import com.lamb.permissionsystem.repository.dao.operation.EmployeeTMOperation;
import com.lamb.permissionsystem.repository.dao.repository.EmployeeDORepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Optional;

import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.EB00000000;
import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.EI00000002;
import static com.lamb.permissionsystem.common.enums.RedisTMKeyEnum.EMPLOYEE_TOKEN;

/**
 * @description: AuthToken认证管理器
 * @author: Mr.WangGang
 * @create: 2018-10-19 下午 1:18
 **/
@Component
public class AuthTokenReactiveAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Resource
    private EmployeeTMOperation employeeTMOperation;

    @Resource
    private EmployeeDORepository employeeDORepository;


    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        String authToken  = authorizationContext.getExchange().getRequest().getHeaders().getFirst("authToken");
        if(StringUtils.isEmpty(authToken)){
            throw new ProcessException(EI00000002);
        }
        EmployeeTM employeeTM = Optional.ofNullable(employeeTMOperation.getObject(EMPLOYEE_TOKEN.getKey()+authToken)).orElseThrow(()->new ProcessException(EB00000000));
        EmployeeDO employeeDO = employeeDORepository.findById(employeeTM.getEmployeeId()).orElseThrow(()->new ProcessException(EB00000000));
        return Mono.just(new AuthorizationDecision(true));
    }
}
