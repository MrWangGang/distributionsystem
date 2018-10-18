package com.lamb.permissionsystem.common.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.lamb.lambframework.core.config.LambSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.List;

/**
 * @description: swagger 拓展的配置
 * @author: Mr.WangGang
 * @create: 2018-10-18 上午 10:23
 **/
@Primary
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 3)
@Configuration
public class SwaggerExpandConfig extends LambSwaggerConfig {

    public SwaggerExpandConfig(TypeNameExtractor typeNameExtractor, TypeResolver typeResolver) {
        super(typeNameExtractor, typeResolver);
    }

    @Override
    public ApiInfo apiInfo(ApiInfoBuilder apiInfoBuilder) {
        return apiInfoBuilder
                .title("权限管理系统API")//大标题
                .description("权限管理系统接口")//详细描述
                .version("1.0")//版本
                .contact(new Contact(":王刚", "", "userbean@outlook.com"))//作者
                .license("The Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Override
    public List<Parameter> unifiedParameter(ParameterBuilder parameterBuilder) {
        /*List result = Lists.newLinkedList();
        //添加head参数start
        result.add(parameterBuilder.name("accessToken").description("访问方申请的令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        result.add(parameterBuilder.name("serviceCode").description("访问对应服务的编号").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        return result;*/
        return null;
    }
}
