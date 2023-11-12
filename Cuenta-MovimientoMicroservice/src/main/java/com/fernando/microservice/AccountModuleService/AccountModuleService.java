package com.fernando.microservice.AccountModuleService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.fernando.microservice.AccountModuleService" })
@EntityScan(basePackages = { "com.fernando.microservice.AccountModuleService.domain" })
@EnableJpaRepositories(basePackages = { "com.fernando.microservice.AccountModuleService.repository" })
public class AccountModuleService {

    public static void main(String[] args) {
        SpringApplication.run(AccountModuleService.class, args);

    }
}
