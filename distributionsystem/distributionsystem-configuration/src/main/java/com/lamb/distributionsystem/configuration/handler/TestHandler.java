package com.lamb.distributionsystem.configuration.handler;

import com.lamb.distributionsystem.common.exception.ProcessException;
import org.lamb.lambframework.core.handler.LambHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.lamb.distributionsystem.common.enums.ProcessExceptionEnum.EB00000000;

@Component
public class TestHandler extends LambHandler {

    public Mono<ServerResponse> test(ServerRequest request) {
        return example();
    }
}
