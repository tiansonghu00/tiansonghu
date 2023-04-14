package com.jining.dto.req;

import com.jining.entity.EmployeeSummery;
import lombok.Data;

import java.util.List;

/**
 * @ClassName LoginDto
 * @Author Goslly
 * @Date 2023/4/11 23:52
 * @Description 酒精设备登录的请求体
 */
@Data
public class LoginReqDto {
    /*设备号*/
    private String dev_sno;
    /*签名类型，固定为 dev_sign*/
    private String sign_type;
    /*设备注册号 (暂无意义，但是对接时必须要在设备上必须要写入该字段)*/
    private String register_no;
    /*设备类型: 1门禁机*/
    private int type;
    /*设备名称*/
    private String name;
    /*出入口, 1:出 2:入*/
    private String throughType;
    /*识别阈值[0.0-100.0]*/
    private float threshold;
    /*检测活体，close：不开启活体检测，IRAlive：IRAlive模式*/
    private String detectAlive;
    /*是否开启IR小窗口*/
    private boolean openIRWindow;
    /*人脸识别去重时间， 单位：秒*/
    private float retryInterval;
    /*是否首次登录。如果在中途切换其它平台账号，再次登录此参数需设置为true*/
    private boolean isFirst;
    /*设备当前人员数量信息*/
    private List<EmployeeSummery> personInfo;
    /*是否开启热力图*/
    private boolean openHeatMap;
    /*测温报警温度*/
    private String warningTemperature;
    /*mq协议类型：MQTT*/
    private String mqProtocol;
}
