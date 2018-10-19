package com.lamb.permissionsystem.api.controller;

import com.lamb.permissionsystem.entity.parameter.PCMSServiceProviderValidatePO;
import com.lamb.permissionsystem.service.IdentityVerificationService;
import io.swagger.annotations.*;
import org.lamb.lambframework.core.handler.LambHandler;
import org.lamb.lambframework.core.templete.LambResponseTemplete;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description: D
 * @author: Mr.WangGang
 * @create: 2018-10-17 下午 7:07
 **/
@Api(description = "暴露服务给其他子服务",tags = "对外服务")
@RestController
public class PCMSServiceProviderController extends LambHandler {


    @Resource
    private IdentityVerificationService identityVerificationService;

    @ApiOperation(value = "身份验证" ,  notes="第三方系统对接此接口,可以在本系统中实现身份验证")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "serviceCode", value = "需要访问的服务CODE", required = true) ,
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "accessToken", value = "访问方申请的令牌", required = false)
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00001",method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> IPCMS00001( @RequestBody @Valid @NotNull PCMSServiceProviderValidatePO param){
        identityVerificationService.validate(param);
        return returning();
    }
}
