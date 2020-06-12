package com.github.niefy.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.r2bc")
public class R2bcProperties {
    private String driver;
    private String protocal;
    private Integer maxSize;
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String database;
}
