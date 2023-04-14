package com.jining.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqttCallbackImpl implements MqttCallback {

    @Override
    public void connectionLost(Throwable throwable) {
        log.error("连接断开，正在重连....", throwable);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        log.info("接收消息主题 : " + topic);
        log.info("接收消息Qos : " + message.getQos());
        log.info("接收消息内容 : " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        if (!token.isComplete()) {
            try {
                log.error("delivery failed---------{}", token.getMessage().getPayload());
            } catch (MqttException e) {
                // Ignore
            }
        }

    }
}