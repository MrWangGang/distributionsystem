package com.lamb.distributionsystem.common.security;

import com.lamb.distributionsystem.common.exception.ProcessException;
import com.lamb.distributionsystem.repository.domain.DictDO;
import com.lamb.distributionsystem.repository.domain.UserDO;
import com.lamb.distributionsystem.repository.domain.UserTokenDO;
import com.lamb.distributionsystem.repository.mapper.DictDOMapper;
import com.lamb.distributionsystem.repository.mapper.UserDOMapper;
import com.lamb.distributionsystem.repository.mapper.UserTokenDOMapper;
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
import java.util.Date;

import static com.lamb.distributionsystem.common.enums.ProcessExceptionEnum.EB00000001;
import static com.lamb.distributionsystem.common.enums.ProcessExceptionEnum.EB00000002;


/**
 * @program: decisionsupportsystem
 * @description: token 认证管理器
 * @author: Mr.WangGang
 * @create: 2018-08-30 18:56
 **/
@Component
public class AuthTokenServerSecurityContextRepository implements ServerSecurityContextRepository {

    @Resource
    private UserDOMapper userDOMapper;

    @Resource
    private UserTokenDOMapper userTokenDOMapper;

    @Resource
    private DictDOMapper dictDOMapper;

    @Override
    public Mono<Void> save(ServerWebExchange serverWebExchange, SecurityContext securityContext) {
        //不知道这是什么
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange serverWebExchange) {
        ServerHttpRequest request =  serverWebExchange.getRequest();
        String token  = request.getHeaders().getFirst("token");
        if(StringUtils.isBlank(token)){
            throw new ProcessException(EB00000002);
        }
        UserTokenDO userTokenDO = userTokenDOMapper.selectByPrimaryKey(token);
        if(userTokenDO == null){
            throw new ProcessException(EB00000002);
        }
        UserDO userDO = userDOMapper.selectByPrimaryKey(userTokenDO.getUserId());
        if(userDO == null){
            throw new ProcessException(EB00000002);
        }
        userTokenDO.getCreateTime();
        DictDO dictDO = dictDOMapper.selectByPrimaryKey("token_invalid_ms");
        if(dictDO == null){
            //如果不存在,默认1小时后失效
            if(new Date().getTime() - userTokenDO.getCreateTime().getTime() > 3600000){
                throw new ProcessException(EB00000001);
            }
        }else {
            if (new Date().getTime() -  userTokenDO.getCreateTime().getTime()> Long.valueOf(StringUtils.isBlank(dictDO.getValue()) ? "0" : dictDO.getValue())) {
                throw new ProcessException(EB00000001);
            }
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDO,userDO.getUserPassword(),userDO.getAuthorities());
        return Mono.justOrEmpty(new SecurityContextImpl(authentication));
    }
}
