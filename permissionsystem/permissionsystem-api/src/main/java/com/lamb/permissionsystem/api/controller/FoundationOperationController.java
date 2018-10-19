package com.lamb.permissionsystem.api.controller;

import com.lamb.permissionsystem.service.EmployeeOperationService;
import io.swagger.annotations.*;
import org.lamb.lambframework.core.handler.LambHandler;
import org.lamb.lambframework.core.templete.LambResponseTemplete;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @description: 基础操作
 * @author: Mr.WangGang
 * @create: 2018-10-19 上午 10:57
 **/
@Api(description = "提供给本系统员工用户可操作的基础功能",tags = "基础操作")
@RestController
public class FoundationOperationController extends LambHandler {
    @Resource
    private EmployeeOperationService employeeOperationService;

    @ApiOperation(value = "登录" ,  notes="本系统员工由此登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "json", name = "serviceCode", value = "员工信息RO", required = true) ,
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00001",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<ServerResponse> IPCMS00001(ServerRequest request){

        identityVerificationService.validate(request.headers().asHttpHeaders().getFirst("serviceCode"),request.headers().asHttpHeaders().getFirst("accessToken"));
        return example();
    }
}
