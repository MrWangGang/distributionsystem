package com.vdong.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.config.EnableWebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication(scanBasePackages={"com.vdong.**","org.lamb.**"})
@PropertySource(value = "classpath:repository.properties")
@EnableTransactionManagement
@EnableFeignClients
@EnableWebFlux
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@EnableSwagger2WebFlux
public class Start{
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
