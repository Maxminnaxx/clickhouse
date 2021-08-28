package com.study.clickhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author zhb
 */
@SpringBootApplication
@MapperScan("com.study.clickhouse.mapper")
public class ClickhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickhouseApplication.class, args);
    }

}
