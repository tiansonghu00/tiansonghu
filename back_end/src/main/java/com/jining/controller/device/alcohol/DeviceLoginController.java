package com.jining.controller.device.alcohol;

import com.jining.dto.req.LoginReqDto;
import com.jining.dto.resp.LoginRespDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Author Goslly
 * @Date 2023/4/11 23:44
 * @Description 酒精检测仪登录接口
 */
@RestController
public class DeviceLoginController {

    @PostMapping("device/login")
    public LoginRespDto login(LoginReqDto loginReqDto){
        // 业务代码

        LoginRespDto loginRespDto = LoginRespDto.builder()
                .code(0)
                .success(true)
                .dev_sno("")
                .build();
        return loginRespDto;
    }
}
