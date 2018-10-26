package com.vdong.rms.common.util;

import com.vdong.rms.entity.domain.UserDO;
import com.vdong.rms.repository.dao.UserDORepository;
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
