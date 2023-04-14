package com.jining.controller.device.alcohol;

import com.jining.dto.req.NotifyReqDto;
import com.jining.dto.resp.NotifyRespDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DeviceExecuteNotifyController
 * @Author Goslly
 * @Date 2023/4/12 0:49
 * @Description 酒精设备执行 mqtt 下发命令的回调接口，告诉控制中心命令是否执行成功
 */
@RestController
@RequestMapping("/device")
public class DeviceExecuteCmdNotifyController {

    /***
     * 回调接口是 /device/notify 的统一处理方法
     * @author Goslly
     * @date 1:01 2023/4/12
     * @param notifyReqDto
     * @return com.jining.dto.resp.NotifyRespDto
     **/
    @PostMapping("/notify")
    public NotifyRespDto notify(NotifyReqDto notifyReqDto){

        NotifyRespDto build = NotifyRespDto.builder().build();
        return build;
    }
}
