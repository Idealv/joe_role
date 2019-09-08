package com.joe.role.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "jwt")
@Component
@Getter@Setter
public class SecurityConfig {

    private String secret;

    private Long expiration;
    //Authorization
    private String header;
    //Bearer
    private String tokenHead;

}
