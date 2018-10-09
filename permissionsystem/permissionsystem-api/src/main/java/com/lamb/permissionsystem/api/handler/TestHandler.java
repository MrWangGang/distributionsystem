package com.lamb.permissionsystem.api.handler;

import org.lamb.lambframework.core.handler.LambHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TestHandler extends LambHandler {

    public Mono<ServerResponse> test(ServerRequest request) {
        return example();
    }
}
