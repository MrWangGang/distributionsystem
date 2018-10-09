package com.lamb.permissionsystem.api.routes;

import com.lamb.permissionsystem.api.handler.TestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ApiRoutes {
    @Bean
    public RouterFunction<ServerResponse> testRoute(TestHandler testHandler) {
        return RouterFunctions.route(GET("/test").and(accept(APPLICATION_JSON)), testHandler::test);
    }

    @Resource
    private TestHandler testService;

    @RequestMapping(value = "/test")
    public Mono<ServerResponse> test(ServerRequest serverRequest){
        return testService.test(serverRequest);
    }
}
