package com.jining.dto.req;

import lombok.Data;

/**
 * @ClassName NotifyReqDto
 * @Author Goslly
 * @Date 2023/4/12 0:55
 * @Description
 */
@Data
public class NotifyReqDto {

    private String dev_sno;
    private String token;
    private String method;
    private String success;
    private String msg;
    private String params;
}
