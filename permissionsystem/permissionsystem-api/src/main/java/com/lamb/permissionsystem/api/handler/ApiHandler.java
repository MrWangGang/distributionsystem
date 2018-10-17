package com.lamb.permissionsystem.api.handler;

import com.lamb.permissionsystem.service.IdentityVerificationService;
import org.lamb.lambframework.core.handler.LambHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
public class ApiHandler extends LambHandler {
    @Resource
    private IdentityVerificationService identityVerificationService;

    public Mono<ServerResponse> validate(ServerRequest request) {
        identityVerificationService.validate(request.headers().asHttpHeaders().getFirst("serviceCode"),request.headers().asHttpHeaders().getFirst("accessToken"));
        return example();
    }
}
