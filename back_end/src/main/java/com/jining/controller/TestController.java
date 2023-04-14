package com.jining.controller;

import com.jining.dto.WebResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author Goslly
 * @Date 2023/3/29 22:11
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hi")
    public WebResult sayHello(){
        return WebResult.ok().data("Hello World!");
    }
}
