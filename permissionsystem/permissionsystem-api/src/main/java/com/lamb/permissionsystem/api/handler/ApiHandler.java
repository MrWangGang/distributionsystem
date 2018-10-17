package com.lamb.permissionsystem.api.handler;

import com.lamb.permissionsystem.service.IdentityVerificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lamb.lambframework.core.handler.LambHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
@Api("API接口")
@Controller
public class ApiHandler extends LambHandler {
    @Resource
    private IdentityVerificationService identityVerificationService;

    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    public Mono<ServerResponse> validate(ServerRequest request) {
        identityVerificationService.validate(request.headers().asHttpHeaders().getFirst("serviceCode"),request.headers().asHttpHeaders().getFirst("accessToken"));
        return example();
    }
}
