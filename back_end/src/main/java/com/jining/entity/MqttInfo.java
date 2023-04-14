package com.jining.entity;

import lombok.Data;

/**
 * @ClassName MqInfo
 * @Author Goslly
 * @Date 2023/4/12 0:06
 * @Description mqtt 链接信息
 */
@Data
public class MqttInfo {
    private String host;
    private int keepalive;
    private String login;
    private String password;
    private int port;
    private int qos;
    private String topic;
    private String willTopic;
    private String willContent;
}
