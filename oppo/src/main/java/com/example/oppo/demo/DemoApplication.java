package com.example.oppo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.example.oppo.demo.repository","com.example.oppo.demo.domain","com.example.oppo.demo.service","com.example.oppo.demo.controller","com.example.oppo.demo"})
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan("com")//扫描com下所有文件
@EnableJpaRepositories(basePackages = "com.example.oppo.demo.repository")
@EnableCaching//开启缓存
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

