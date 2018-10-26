package com.vdong.rms.web;


import com.vdong.rms.entity.parameter.*;
import com.vdong.rms.entity.visual.EmployeeAuthTokenVO;
import com.vdong.rms.service.EmployeeOperationService;
import com.vdong.rms.service.PermissionManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.lamb.framework.core.handler.LambHandler;
import org.lamb.framework.core.templete.LambResponseTemplete;
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

    @Resource
    private PermissionManageService permissionManageService;

    @ApiOperation(value = "登录" ,  notes="本系统员工由此登录")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = EmployeeAuthTokenVO.class)
    })
    @RequestMapping(value= "/IPCMS00002",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> login(@RequestBody @Valid @NotNull LoginPO param){
        return returning(employeeOperationService.login(param));
    }


    //- 新建和更新
    @ApiOperation(value = "操作用户" ,  notes="操作用户/保存OR更新")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00003",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> operationUser(@RequestBody @Valid @NotNull OperationUserPO param){
        permissionManageService.operationUser(param);
        return returning();
    }

    @ApiOperation(value = "操作角色" ,  notes="操作角色/保存OR更新")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00004",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> operationRole(@RequestBody @Valid @NotNull OperationRolePO param){
        permissionManageService.operationRole(param);
        return returning();
    }

    @ApiOperation(value = "操作服务" ,  notes="操作服务/保存OR更新")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00005",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> operationService(@RequestBody @Valid @NotNull OperationServicePO param){
        permissionManageService.operationService(param);
        return returning();
    }

    @ApiOperation(value = "操作统系" ,  notes="操作统系/保存OR更新")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00006",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> operationSystem(@RequestBody @Valid @NotNull OperationSystemPO param){
        permissionManageService.operationSystem(param);
        return returning();
    }

    @ApiOperation(value = "操作规则" ,  notes="操作规则/保存OR更新")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00007",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> operationRule(@RequestBody @Valid @NotNull OperationRulePO param){
        permissionManageService.operationRule(param);
        return returning();
    }

    //-关联操作
    @ApiOperation(value = "关联用户和角色" ,  notes="关联用户和角色/保存")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00008",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> relateUserToRole(@RequestBody @Valid @NotNull RelateUserToRolePO param){
        permissionManageService.relateUserToRole(param);
        return returning();
    }

    @ApiOperation(value = "关联角色和服务" ,  notes="关联角色和服务/保存")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00009",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> relateRoleToService(@RequestBody @Valid @NotNull RelateRoleToServicePO param){
        permissionManageService.relateRoleToService(param);
        return returning();
    }

    @ApiOperation(value = "关联系统和服务" ,  notes="关联系统和服务/保存")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00010",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> relateSystemToService(@RequestBody @Valid @NotNull RelateSystemToServicePO param){
        permissionManageService.relateSystemToService(param);
        return returning();
    }

    @ApiOperation(value = "关联规则和角色" ,  notes="关联规则和角色/保存")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00011",method= RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> relateRuleToRole(@RequestBody @Valid @NotNull RelateRuleToRolePO param){
        permissionManageService.relateRuleToRole(param);
        return returning();
    }

    //-删除操作
    @ApiOperation(value = "删除用户" ,  notes="删除用户/删除")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00012",method= RequestMethod.DELETE,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> deleteUser(@RequestBody @Valid @NotNull DeleteUserPO param){
        permissionManageService.deleteUser(param);
        return returning();
    }

    @ApiOperation(value = "删除角色" ,  notes="删除角色/删除")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00013",method= RequestMethod.DELETE,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> deleteRole(@RequestBody @Valid @NotNull DeleteRolePO param){
        permissionManageService.deleteRole(param);
        return returning();
    }

    @ApiOperation(value = "删除服务" ,  notes="删除服务/删除")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00014",method= RequestMethod.DELETE,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> deleteService(@RequestBody @Valid @NotNull DeleteServicePO param){
        permissionManageService.deleteService(param);
        return returning();
    }

    @ApiOperation(value = "删除系统" ,  notes="删除系统/删除")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00015",method= RequestMethod.DELETE,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> deleteSystem(@RequestBody @Valid @NotNull DeleteSystemPO param){
        permissionManageService.deleteSystem(param);
        return returning();
    }

    @ApiOperation(value = "删除规则" ,  notes="删除规则/删除")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = LambResponseTemplete.class)
    })
    @RequestMapping(value= "/IPCMS00016",method= RequestMethod.DELETE,consumes= MediaType.APPLICATION_JSON_VALUE)
    public Mono<LambResponseTemplete> deleteRule(@RequestBody @Valid @NotNull DeleteRulePO param){
        permissionManageService.deleteRule(param);
        return returning();
    }
}
