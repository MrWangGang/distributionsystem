package com.lamb.permissionsystem.common.util;

import com.lamb.permissionsystem.repository.entity.domain.UserDO;
import com.lamb.permissionsystem.repository.dao.repository.UserDORepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
public class SessionUtil {

    @Resource
    private UserDORepository userDORepository;


    public UserDO getLoginUser(){
        Mono.subscriberContext();
        return null;
    }
}
