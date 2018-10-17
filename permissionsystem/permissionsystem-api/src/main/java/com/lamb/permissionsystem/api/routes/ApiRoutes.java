package com.lamb.permissionsystem.api.routes;

import com.lamb.permissionsystem.api.handler.ApiHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.lamb.permissionsystem.common.enums.ApiEnum.IPCMS00001;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ApiRoutes {
    @Bean
    public RouterFunction<ServerResponse> testRoute(ApiHandler apiHandler) {
        return RouterFunctions.route(GET(IPCMS00001.api()).and(accept(APPLICATION_JSON)), apiHandler::validate);
    }
}
