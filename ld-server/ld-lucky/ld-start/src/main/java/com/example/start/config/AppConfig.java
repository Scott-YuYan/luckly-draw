package com.example.start.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableFeignClients(basePackages = "cn.j3code.luckyclient.feign")
@Configuration
@EnableScheduling
@EnableTransactionManagement
@ComponentScan("com.example")
@MapperScan(basePackages = "com.example.infrastructure.gateway.impl.mapper")
public class AppConfig {
}
