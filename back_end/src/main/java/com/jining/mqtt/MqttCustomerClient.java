package com.jining.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class MqttCustomerClient {
    @Resource
    private MqttCallbackImpl mqttCallbackImpl;

    @Resource
    MqttConfiguration mqttConfiguration;
    private MqttClient client;

    @PostConstruct
    private void initClient() {
        MqttClient client;
        try {
            client = new MqttClient(mqttConfiguration.getHost(), mqttConfiguration.getClientId(), new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(mqttConfiguration.getUsername());
            options.setPassword(mqttConfiguration.getPassword().toCharArray());
            options.setConnectionTimeout(mqttConfiguration.getTimeout());
            options.setKeepAliveInterval(mqttConfiguration.getKeepAlive());
            try {
                client.setCallback(mqttCallbackImpl);
                client.connect(options);
                this.client = client;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布消息，默认 qos 为 0，非持久化
     *
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic, String pushMessage) {
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布
     *
     * @param qos         连接方式
     * @param retained    是否保留
     * @param topic       主题
     * @param pushMessage 消息体
     */
    public void publish(int qos, boolean retained, String topic, String pushMessage) {
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.getBytes());
        MqttTopic mqttTopic = client.getTopic(topic);
        if (null == mqttTopic) {
            log.error("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mqttTopic.publish(message);
            token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题，qos默认为0
     *
     * @param topic
     */
    public void subscribe(String topic) {
        log.info("开始订阅主题" + topic);
        subscribe(topic, 0);
    }

    public void subscribe(String topic, int qos) {
        try {
            client.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}