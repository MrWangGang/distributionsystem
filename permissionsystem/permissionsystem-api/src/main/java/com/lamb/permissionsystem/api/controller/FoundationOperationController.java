package com.lamb.permissionsystem.api.controller;

import com.lamb.permissionsystem.entity.parameter.FoundationOperationLoginPO;
import com.lamb.permissionsystem.entity.visual.EmployeeAuthTokenVO;
import com.lamb.permissionsystem.service.EmployeeOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = EmployeeAuthTokenVO.class)
    })
    @RequestMapping(value= "/IPCMS00002",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> IPCMS00002(@RequestBody @Valid @NotNull FoundationOperationLoginPO param){
        return returning(employeeOperationService.login(param));
    }
}
