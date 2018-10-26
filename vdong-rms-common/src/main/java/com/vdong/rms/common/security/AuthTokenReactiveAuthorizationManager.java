package com.vdong.rms.common.security;

import com.vdong.rms.common.enums.ProcessExceptionEnum;
import com.vdong.rms.common.enums.RedisTMKeyEnum;
import com.vdong.rms.common.exception.ProcessException;
import com.vdong.rms.entity.domain.EmployeeDO;
import com.vdong.rms.entity.template.EmployeeTM;
import com.vdong.rms.repository.dao.EmployeeDORepository;
import com.vdong.rms.repository.operation.EmployeeTMOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Optional;

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
            throw new ProcessException(ProcessExceptionEnum.EI00000002);
        }
        EmployeeTM employeeTM = Optional.ofNullable(employeeTMOperation.getObject(RedisTMKeyEnum.EMPLOYEE_TOKEN.getKey()+authToken)).orElseThrow(()->new ProcessException(ProcessExceptionEnum.EB00000000));
        EmployeeDO employeeDO = employeeDORepository.findById(employeeTM.getEmployeeId()).orElseThrow(()->new ProcessException(ProcessExceptionEnum.EB00000000));
        return Mono.just(new AuthorizationDecision(true));
    }
}
