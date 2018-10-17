package com.lamb.permissionsystem.common.filter;

import com.lamb.permissionsystem.common.exception.ProcessException;
import com.lamb.permissionsystem.repository.dao.operation.UserTokenTMOperation;
import com.lamb.permissionsystem.repository.dao.repository.*;
import com.lamb.permissionsystem.repository.entity.domain.ServiceDO;
import com.lamb.permissionsystem.repository.entity.domain.UserDO;
import com.lamb.permissionsystem.repository.entity.template.UserTokenTM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static com.lamb.permissionsystem.common.enums.FoundationPropertyEnum.*;
import static com.lamb.permissionsystem.common.enums.ProcessExceptionEnum.*;
import static com.lamb.permissionsystem.repository.enums.RedisTMKeyEnum.USER_TOKEN;

/**
 * @description: 基础过滤器
 * @author: Mr.WangGang
 * @create: 2018-10-16 下午 5:15
 **/
@Configuration
public class FoundationFilter  implements WebFilter {
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

    @Resource
    private FoundationQueryRepository foundationQueryRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        ServerHttpRequest request =  serverWebExchange.getRequest();
        String accessToken  = request.getHeaders().getFirst("accessToken");
        String serviceCode  = request.getHeaders().getFirst("serviceCode");
        if(StringUtils.isBlank(serviceCode)){
            throw new ProcessException(EI00000001);
        }

        ServiceDO serviceDO = foundationQueryRepository.findByServiceCode(serviceCode).orElseThrow(()->new ProcessException(EB00000003));

        Byte serviceStrategy = serviceDO.getServiceStrategy();

        if(ANY.getValue().equals(serviceStrategy)){
            //任何人都可以访问
            return webFilterChain.filter(serverWebExchange).then();
        }else if(AUTC.getValue().equals(serviceStrategy)){
            //需要认证
            UserDO userDO = autc(accessToken);
            legitimateRequestUSS(userDO,serviceDO);
            return webFilterChain.filter(serverWebExchange).then();
        }else if(AUTZ.getValue().equals(serviceStrategy)){
            //需要授权
            UserDO userDO = autc(accessToken);
            legitimateRequestUSS(userDO,serviceDO);
            autz(userDO,serviceDO);
            return webFilterChain.filter(serverWebExchange).then();
        }else{
            throw new ProcessException(EB00000004);
        }
    }

    //认证
    private UserDO autc(String accessToken){
        if(StringUtils.isBlank(accessToken)){
            throw new ProcessException(EI00000000);
        }
        UserTokenTM userTokenTM = Optional.ofNullable(userTokenTMOperation.getObject(USER_TOKEN.getKey()+accessToken)).orElseThrow(()->new ProcessException(EB00000000));
        UserDO userDO = userDORepository.findById(userTokenTM.getUserId()).orElseThrow(()->new ProcessException(EB00000000));
        return userDO;
    }

    //授权
    private void autz(UserDO userDO,ServiceDO serviceDO){
        List<ServiceDO> services =  foundationQueryRepository.findServiceByUserId(userDO.getUserId()).orElseThrow(()->new ProcessException(EB00000005));
        if (services.stream().noneMatch(e -> serviceDO.getServiceId().compareTo(e.getServiceId()) == 0)){
            throw new ProcessException(EB00000005);
        }
    }
    //合法的用户系统服务之间关系
    private void legitimateRequestUSS(UserDO userDO,ServiceDO serviceDO){
        systemDORepository.findById(userDO.getSystemId()).orElseThrow(()->new ProcessException(EB00000001));
        systemServiceDORepository.findByServiceId(serviceDO.getServiceId()).orElseThrow(()->new ProcessException(EB00000002));
    }
}
