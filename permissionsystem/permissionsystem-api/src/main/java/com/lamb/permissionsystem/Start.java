package com.lamb.permissionsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(scanBasePackages={"com.lamb.**","org.lamb.**"})
@PropertySource(value = "classpath:repository.properties")
@EnableTransactionManagement
@EnableFeignClients
@EnableWebFlux
public class Start{

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

}
