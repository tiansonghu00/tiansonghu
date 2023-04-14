package com.jining.service.impl;

import com.jining.service.SendCmdMqtt;
import org.springframework.stereotype.Component;

/**
 * @ClassName SendCmdMqttImpl
 * @Author Goslly
 * @Date 2023/4/12 0:47
 * @Description
 */
@Component
public class SendCmdMqttImpl implements SendCmdMqtt {
    @Override
    public void open_door(String topic) {

    }

    @Override
    public void sync_time(String topic) {

    }

    @Override
    public void reset_device(String topic) {

    }

    @Override
    public void sync_TMParams(String topic) {

    }
}
