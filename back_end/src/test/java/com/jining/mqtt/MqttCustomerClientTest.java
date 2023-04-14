package com.jining.mqtt;

import com.jining.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class MqttCustomerClientTest {
    @Resource
    private MqttCustomerClient mqttCustomerClient;

    @Value("${mqtt.topic}")
    private String topic;

    @Test
    public void subscribe() throws InterruptedException {
        /**
         * 启动 mqtt 订阅服务
         */
        mqttCustomerClient.subscribe(topic);
        Thread.sleep(300000000);
    }

    @Test
    public void publish() {
        /**
         * 进行 mqtt 消息发布
         */
        for (int i = 0; i < 1000; i++) {
            mqttCustomerClient.publish(topic, "hello mqtt............" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}