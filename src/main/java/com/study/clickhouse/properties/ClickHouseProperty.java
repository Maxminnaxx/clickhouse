package com.study.clickhouse.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhb
 */
@Data
@Component
@ConfigurationProperties("clickhouse")
public class ClickHouseProperty {

    private String driverClassName;

    private String url;

    private String password;

    private Integer initialSize;

    private Integer maxActive;

    private Integer minIdle;

    private Integer maxWait;

}
