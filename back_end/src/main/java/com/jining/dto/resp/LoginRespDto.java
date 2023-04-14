package com.jining.dto.resp;

import com.jining.entity.MqttInfo;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName LoginRespDto
 * @Author Goslly
 * @Date 2023/4/12 0:05
 * @Description 酒精设备登录的响应体
 */
@Data
@Builder
public class LoginRespDto {
    /*0:成功     非0:失败*/
    private int code;
    /*设备号（设备MAC地址）*/
    private String dev_sno;
    private String msg;
    private boolean success;
    private String token;
    /*mqtt连接信息*/
    private MqttInfo mqinfo;
}
