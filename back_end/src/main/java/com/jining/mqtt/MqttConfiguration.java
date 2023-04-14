package com.jining.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("mqtt")
public class MqttConfiguration {
    private String host;
    private String clientId;
    private String username;
    private String password;
    private String topic;
    private int timeout;
    private int keepAlive;

}