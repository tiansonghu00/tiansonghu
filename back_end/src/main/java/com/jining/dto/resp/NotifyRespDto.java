package com.jining.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName NotifyrespDto
 * @Author Goslly
 * @Date 2023/4/12 0:52
 * @Description mqtt 下发的命令执行结果的回调请求的响应体
 */
@Data
@Builder
public class NotifyRespDto {
    private int code;
    private String msg;
    private boolean success;

    /**
     * 执行成功的统一响应体
      {
      "code": 0,
      "msg": "OK",
      "success": true
      }
     */
}
