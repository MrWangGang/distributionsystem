/*
package com.lamb.permissionsystem.common.security;

import com.lamb.permissionsystem.common.exception.ProcessException;
import com.lamb.permissionsystem.repository.dao.operation.UserTokenTMOperation;
import com.lamb.permissionsystem.repository.dao.repository.ServiceDORepository;
import com.lamb.permissionsystem.repository.dao.repository.SystemDORepository;
import com.lamb.permissionsystem.repository.dao.repository.SystemServiceDORepository;
import com.lamb.permissionsystem.repository.dao.repository.UserDORepository;
import com.lamb.permissionsystem.repository.entity.domain.ServiceDO;
import com.lamb.permissionsystem.repository.entity.domain.SystemDO;
import com.lamb.permissionsystem.repository.entity.domain.SystemServiceDO;
import com.lamb.permissionsystem.repository.entity.domain.UserDO;
import com.lamb.permissionsystem.repository.entity.template.UserTokenTM;
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

import static com.lamb.permissionsystem.common.enums.FoundationPropertyEnum.ANY;
import static com.lamb.permissionsystem.common.enums.FoundationPropertyEnum.AUTC;
import static com.lamb.permissionsystem.common.enums.FoundationPropertyEnum.AUTZ;
import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.*;
import static com.lamb.permissionsystem.repository.enums.RedisTMKeyEnum.USER_TOKEN;


*/
/**
 * @program: decisionsupportsystem
 * @description: token 认证管理器
 * @author: Mr.WangGang
 * @create: 2018-08-30 18:56
 **//*

@Component
public class AuthTokenServerSecurityContextRepository implements ServerSecurityContextRepository {

    @Resource
    private UserDORepository userDORepository;

    @Resource
    private SystemDORepository systemDORepository;

    @Resource
    private SystemServiceDORepository systemServiceDORepository;

    @Resource
    private ServiceDORepository serviceDORepository;


    @Resource
    private UserTokenTMOperation userTokenTMOperation;

    @Override
    public Mono<Void> save(ServerWebExchange serverWebExchange, SecurityContext securityContext) {
        //不知道这是什么
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange serverWebExchange) {
        //DictDO dictDO = dictDOMapper.findById("token_invalid_ms").get();

        ServerHttpRequest request =  serverWebExchange.getRequest();
        String accessToken  = request.getHeaders().getFirst("accessToken");
        String serviceCode  = request.getHeaders().getFirst("serviceCode");
        if(StringUtils.isBlank(accessToken)){
            throw new ProcessException(EI00000000);
        }

        if(StringUtils.isBlank(serviceCode)){
            throw new ProcessException(EI00000001);
        }
        UserTokenTM test = new UserTokenTM();
        test.setAccessToken("1");
        test.setUserId(1);
        userTokenTMOperation.set(USER_TOKEN.getKey()+accessToken,test,new Long("3600000"));


        UserTokenTM userTokenTM = Optional.ofNullable(userTokenTMOperation.getObject(USER_TOKEN.getKey()+accessToken)).orElseThrow(()->new ProcessException(EB00000000));

        UserDO userDO = userDORepository.findById(userTokenTM.getUserId()).orElseThrow(()->new ProcessException(EB00000000));

        ServiceDO serviceDO = serviceDORepository.findByServiceCode(serviceCode).orElseThrow(()->new ProcessException(EB00000003));

        SystemDO systemDO = systemDORepository.findById(userDO.getSystemId()).orElseThrow(()->new ProcessException(EB00000001));

        SystemServiceDO systemServiceDO = systemServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElseThrow(()->new ProcessException(EB00000002));

        Byte serviceStrategy = serviceDO.getServiceStrategy();

        if(ANY.getValue().equals(serviceStrategy)){
            //任何人都可以访问
            return null;
        }else if(AUTC.getValue().equals(serviceStrategy)){
            //需要认证

        }else if(AUTZ.getValue().equals(serviceStrategy)){
            //需要授权
        }else{
            throw new ProcessException(EB00000004);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDO,accessToken);

        return Mono.justOrEmpty(new SecurityContextImpl(authentication));
    }
}
*/
