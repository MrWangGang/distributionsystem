package com.lamb.distributionsystem.common.util;

import com.lamb.distributionsystem.repository.domain.UserDO;
import com.lamb.distributionsystem.repository.mapper.UserDOMapper;
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
