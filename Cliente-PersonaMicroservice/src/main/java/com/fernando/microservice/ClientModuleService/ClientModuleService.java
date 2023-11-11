package com.fernando.microservice.ClientModuleService;

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
@ComponentScan(basePackages = {"com.fernando.microservice.ClientModuleService"})
@EntityScan(basePackages = {"com.fernando.microservice.ClientModuleService.domain"})
@EnableJpaRepositories(basePackages = {"com.fernando.microservice.ClientModuleService.repository"})
public class ClientModuleService {

    public static void main(String[] args) {
        SpringApplication.run(ClientModuleService.class, args);
        

    }
}
