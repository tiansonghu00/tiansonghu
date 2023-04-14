package com.jining.service;

/**
 * @Interface MqttSendCmd
 * @Author Goslly
 * @Date 2023/4/12 0:37
 * @Description  向 mqtt 下发相关设备的指令
 */
public interface SendCmdMqtt {
    /***
     * 向指定 topic 发送开门指令， 此处的 topic = dev_sno
     * @author Goslly
     * @date 0:40 2023/4/12
     * @param topic
     **/
    void open_door(String topic);

    /***
     * 云端设置系统时间
     * @author Goslly 
     * @date 0:41 2023/4/12 
     * @param topic 
     **/
    void sync_time(String topic);
    
    /***
     * 云端重置设备参数
     * @author Goslly 
     * @date 0:42 2023/4/12
     * @param topic 
     **/
    void reset_device(String topic);
    
    /***
     * 9.云端设置测温参数
     * @author Goslly 
     * @date 0:44 2023/4/12
     * @param topic 
     **/
    void sync_TMParams(String topic);


}
