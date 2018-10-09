package com.lamb.permissionsystem.common.util;

import com.lamb.permissionsystem.repository.domain.UserDO;
import com.lamb.permissionsystem.repository.mapper.UserDOMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
public class SessionUtil {

    @Resource
    private UserDOMapper userDOMapper;


    public UserDO getLoginUser(){
        Mono.subscriberContext();
        return null;
    }
}
